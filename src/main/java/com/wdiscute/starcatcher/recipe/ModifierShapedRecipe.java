package com.wdiscute.starcatcher.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.io.ModDataComponents;
import com.wdiscute.starcatcher.registry.ModRecipes;
import com.wdiscute.starcatcher.registry.custom.catchmodifiers.AbstractCatchModifier;
import com.wdiscute.starcatcher.registry.custom.minigamemodifiers.AbstractMinigameModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModifierShapedRecipe implements CraftingRecipe
{
    public final ShapedRecipePattern pattern;
    final ItemStack result;
    final List<ResourceLocation> minigameModifiers;
    final List<ResourceLocation> catchModifiers;
    final ResourceLocation bobberSkin;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;

    public ModifierShapedRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result,
                                boolean showNotification,
                                List<ResourceLocation> minigameModifiers,
                                List<ResourceLocation> catchModifiers,
                                ResourceLocation bobberSkin
    )
    {
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.showNotification = showNotification;
        this.minigameModifiers = minigameModifiers;
        this.catchModifiers = catchModifiers;
        this.bobberSkin = bobberSkin;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipes.MODIFIER_SHAPED_RECIPE.get();
    }

    @Override
    public String getGroup()
    {
        return this.group;
    }

    @Override
    public CraftingBookCategory category()
    {
        return this.category;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries)
    {
        return this.result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients()
    {
        return this.pattern.ingredients();
    }

    @Override
    public boolean showNotification()
    {
        return this.showNotification;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return width >= this.pattern.width() && height >= this.pattern.height();
    }

    public boolean matches(CraftingInput input, Level level)
    {
        return this.pattern.matches(input);
    }

    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries)
    {
        var itemstack = this.getResultItem(registries).copy();

        List<ResourceLocation> catchModifiers = new ArrayList<>();
        List<ResourceLocation> minigameModifiers = new ArrayList<>();

        for (ResourceLocation rl : this.minigameModifiers)
        {
            ResourceKey<Supplier<AbstractCatchModifier>> catchRK = ResourceKey.create(Starcatcher.CATCH_MODIFIERS, rl);
            ResourceKey<Supplier<AbstractMinigameModifier>> minigameRK = ResourceKey.create(Starcatcher.MINIGAME_MODIFIERS, rl);

            if (registries.lookupOrThrow(Starcatcher.CATCH_MODIFIERS).get(catchRK).isPresent())
                catchModifiers.add(rl);

            if (registries.lookupOrThrow(Starcatcher.MINIGAME_MODIFIERS).get(minigameRK).isPresent())
                minigameModifiers.add(rl);
        }

        if (!catchModifiers.isEmpty())
            ModDataComponents.set(itemstack, ModDataComponents.CATCH_MODIFIERS, catchModifiers);
        if (!minigameModifiers.isEmpty())
            ModDataComponents.set(itemstack, ModDataComponents.MINIGAME_MODIFIERS, minigameModifiers);

        return itemstack;
    }

    public int getWidth()
    {
        return this.pattern.width();
    }

    public int getHeight()
    {
        return this.pattern.height();
    }

    @Override
    public boolean isIncomplete()
    {
        NonNullList<Ingredient> nonnulllist = this.getIngredients();
        return nonnulllist.isEmpty() || nonnulllist.stream().filter(p_151277_ -> !p_151277_.isEmpty()).anyMatch(Ingredient::hasNoItems);
    }

    public static class Serializer implements RecipeSerializer<ModifierShapedRecipe>
    {
        public static final MapCodec<ModifierShapedRecipe> CODEC = RecordCodecBuilder.mapCodec(
                group -> group.group(
                                Codec.STRING.optionalFieldOf("group", "").forGetter(shapedRecipe -> shapedRecipe.group),
                                CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(shapedRecipe -> shapedRecipe.category),
                                ShapedRecipePattern.MAP_CODEC.forGetter(shapedRecipe -> shapedRecipe.pattern),
                                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(shapedRecipe -> shapedRecipe.result),
                                Codec.BOOL.optionalFieldOf("show_notification", Boolean.TRUE).forGetter(shapedRecipe -> shapedRecipe.showNotification),
                                ResourceLocation.CODEC.listOf().optionalFieldOf("minigame_modifiers", List.of()).forGetter(shapedRecipe -> shapedRecipe.minigameModifiers),
                                ResourceLocation.CODEC.listOf().optionalFieldOf("catch_modifiers", List.of()).forGetter(shapedRecipe -> shapedRecipe.catchModifiers),
                                ResourceLocation.CODEC.optionalFieldOf("bobber_skin", Starcatcher.rl("missingno")).forGetter(shapedRecipe -> shapedRecipe.bobberSkin)
                        )
                        .apply(group, ModifierShapedRecipe::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, ModifierShapedRecipe> STREAM_CODEC = StreamCodec.of(
                ModifierShapedRecipe.Serializer::toNetwork, ModifierShapedRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<ModifierShapedRecipe> codec()
        {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ModifierShapedRecipe> streamCodec()
        {
            return STREAM_CODEC;
        }

        private static ModifierShapedRecipe fromNetwork(RegistryFriendlyByteBuf buffer)
        {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            ShapedRecipePattern shapedrecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            boolean flag = buffer.readBoolean();
            List<ResourceLocation> minigameModifiers = ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()).decode(buffer);
            List<ResourceLocation> catchModifiers = ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()).decode(buffer);
            ResourceLocation bobberSkin = ResourceLocation.STREAM_CODEC.decode(buffer);
            return new ModifierShapedRecipe(s, craftingbookcategory, shapedrecipepattern, itemstack, flag, minigameModifiers, catchModifiers, bobberSkin);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, ModifierShapedRecipe recipe)
        {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            buffer.writeBoolean(recipe.showNotification);
            ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()).encode(buffer, recipe.minigameModifiers);
            ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()).encode(buffer, recipe.catchModifiers);
            ResourceLocation.STREAM_CODEC.encode(buffer, recipe.bobberSkin);
        }
    }

}
