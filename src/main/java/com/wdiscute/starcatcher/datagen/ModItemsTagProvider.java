package com.wdiscute.starcatcher.datagen;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemsTagProvider extends ItemTagsProvider {

    public ModItemsTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Starcatcher.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //fishes, cat_food, foods/raw_fish
        for (DeferredItem<Item> item : ModItems.fishes) {
            tag(ItemTags.FISHES).add(item.get());
            tag(ItemTags.CAT_FOOD).add(item.get());
            tag(Tags.Items.FOODS_RAW_FISH).add(item.get());
        }

        //baits tag
        for (DeferredHolder<Item, ? extends Item> item : ModItems.BAITS_REGISTRY.getEntries()) {
            tag(StarcatcherTags.BAITS).add(item.get());
        }

        tag(StarcatcherTags.BAITS).add(Items.BUCKET);
        tag(StarcatcherTags.BAITS).addOptional(rl("fishofthieves", "earthworms"));
        tag(StarcatcherTags.BAITS).addOptional(rl("fishofthieves", "grubs"));
        tag(StarcatcherTags.BAITS).addOptional(rl("fishofthieves", "leeches"));

        //rods and tools/fishing_rod
        for (DeferredHolder<Item, ? extends Item> item : ModItems.RODS_REGISTRY.getEntries()) {
            tag(Tags.Items.TOOLS_FISHING_ROD).add(item.get());
            tag(StarcatcherTags.RODS).add(item.get());
        }

        tag(StarcatcherTags.HOOKS)
                .add(
                        ModItems.HOOK.value(),
                        ModItems.SHINY_HOOK.value(),
                        ModItems.GOLD_HOOK.value(),
                        ModItems.MOSSY_HOOK.value(),
                        ModItems.STONE_HOOK.value(),
                        ModItems.SPLIT_HOOK.value(),
                        ModItems.STABILIZING_HOOK.value(),
                        ModItems.HEAVY_HOOK.value()
                );

        tag(StarcatcherTags.BOBBERS)
                .add(
                        ModItems.STEADY_BOBBER.value(),
                        ModItems.CLEAR_BOBBER.value()
                );
    }


    public static ResourceLocation rl(String ns, String path) {
        return ResourceLocation.fromNamespaceAndPath(ns, path);
    }
}
