package com.wdiscute.starcatcher.registry.custom.catchmodifiers;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.io.ModDataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public interface ModCatchModifiers
{
    DeferredRegister<Supplier<AbstractCatchModifier>> REGISTRY =
            DeferredRegister.create(Starcatcher.CATCH_MODIFIERS_REGISTRY, Starcatcher.MOD_ID);

    //todo built-in modifiers to skip minigame for low rarity or something, using AbstractCatchModifier#forceSkipMinigame

    //every bait
    ResourceLocation DECREASES_LURE_TIME = registerCatchModifier(
            "decrease_lure_time",
            () -> new DecreaseLureTimeModifier(20, 100, 80));

    //every bait
    ResourceLocation BIG_DECREASES_LURE_TIME = registerCatchModifier(
            "big_decrease_lure_time",
            () -> new DecreaseLureTimeModifier(50, 170, 80));

    ResourceLocation INCREASE_DECREASES_LURE_TIME = registerCatchModifier(
            "increase_lure_time",
            () -> new DecreaseLureTimeModifier(-20, -100, -80));

    //vanilla bobber
    ResourceLocation VANILLA_LOOT = registerCatchModifier("vanilla_loot", VanillaLootModifier::new);

    //almighty worm
    ResourceLocation FISH_ENTITY = registerCatchModifier("fish_entity", ForceFishEntityModifier::new);

    //seeking worm
    ResourceLocation GUARANTEE_NEW_FISH_ALWAYS = registerCatchModifier("guarantee_new_fish_always", () -> new GuaranteeNewFishModifier(101));
    ResourceLocation GUARANTEE_NEW_FISH_ALWAYS = registerCatchModifier("guarantee_new_fish_half", () -> new GuaranteeNewFishModifier(50));

    //gold hook
    ResourceLocation EXTRA_EXP_BASED_ON_PERFORMANCE = registerCatchModifier("extra_exp_based_on_performance", ExtraExpBasedOnPerformanceModifier::new);

    //split hook
    ResourceLocation EXTRA_ITEM = registerCatchModifier("extra_item", () -> new ExtraItemsModifier(1));
    ResourceLocation EXTRA_TWO_ITEMS = registerCatchModifier("extra_two_item", () -> new ExtraItemsModifier(2));
    ResourceLocation EXTRA_THREE_ITEMS = registerCatchModifier("extra_three_item", () -> new ExtraItemsModifier(3));
    ResourceLocation EXTRA_FIVE_ITEMS = registerCatchModifier("extra_two_item", () -> new ExtraItemsModifier(5));
    ResourceLocation EXTRA_TEN_ITEMS = registerCatchModifier("extra_two_item", () -> new ExtraItemsModifier(10));
    ResourceLocation EXTRA_THIRTY_TWO_ITEMS = registerCatchModifier("extra_thirty_two_item", () -> new ExtraItemsModifier(32));




    static ResourceLocation registerCatchModifier(String name, Supplier<AbstractCatchModifier> sup)
    {
        REGISTRY.register(name, () -> sup);
        return Starcatcher.rl(name);
    }

    static void register(IEventBus eventBus)
    {
        REGISTRY.register(eventBus);
    }


    static List<AbstractCatchModifier> getAllCatchModifiers(Level level, ItemStack is)
    {
        return getAllCatchModifiers(level, is, true);
    }

    static List<AbstractCatchModifier> getAllCatchModifiers(Level level, ItemStack is, boolean checkRodItemStack)
    {
        List<AbstractCatchModifier> modifiers = new ArrayList<>();

        if (is.is(StarcatcherTags.RODS) && checkRodItemStack)
        {
            modifiers.addAll(getAllCatchModifiers(level, is.get(ModDataComponents.BOBBER_SKIN).stack(), false));
            modifiers.addAll(getAllCatchModifiers(level, is.get(ModDataComponents.BOBBER).stack(), false));
            modifiers.addAll(getAllCatchModifiers(level, is.get(ModDataComponents.BAIT).stack(), false));
            modifiers.addAll(getAllCatchModifiers(level, is.get(ModDataComponents.HOOK).stack(), false));
        }

        if (is.has(ModDataComponents.CATCH_MODIFIERS))
        {
            for (ResourceLocation rl : Objects.requireNonNull(is.get(ModDataComponents.CATCH_MODIFIERS)))
            {
                Optional<Supplier<AbstractCatchModifier>> optional = level.registryAccess().registryOrThrow(Starcatcher.CATCH_MODIFIERS).getOptional(rl);

                optional.ifPresent(abstractCatchModifierSupplier -> modifiers.add(abstractCatchModifierSupplier.get()));
            }
        }
        return modifiers;
    }

    static boolean hasModifier(ItemStack is, ResourceLocation rl)
    {
        return hasModifier(is, rl, true);
    }

    static boolean hasModifier(ItemStack is, ResourceLocation rl, boolean checkRodItemStack)
    {

        if (is.is(StarcatcherTags.RODS) && checkRodItemStack)
        {
            return (
                    hasModifier(is.get(ModDataComponents.BOBBER_SKIN).stack(), rl) ||
                            hasModifier(is.get(ModDataComponents.BOBBER).stack(), rl) ||
                            hasModifier(is.get(ModDataComponents.BAIT).stack(), rl) ||
                            hasModifier(is.get(ModDataComponents.HOOK).stack(), rl) ||
                            hasModifier(is, rl, false)
            );
        }

        if (is.has(ModDataComponents.CATCH_MODIFIERS))
        {
            return is.get(ModDataComponents.CATCH_MODIFIERS).contains(rl);
        }
        else
        {
            return false;
        }
    }
}

