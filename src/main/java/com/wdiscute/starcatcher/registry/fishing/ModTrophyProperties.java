package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.blocks.ModBlocks;
import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.TrophyProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;

public class ModTrophyProperties {

    private static ResourceKey<TrophyProperties> createKey(TrophyProperties tp) {
        String customName = tp.customName();
        if (!customName.isEmpty()) {
            return ResourceKey.create(
                    Starcatcher.TROPHY_REGISTRY, tp.fish().getKey().location().withPath(customName.toLowerCase().replace(" ", "_")));
        }
        return ResourceKey.create(
                Starcatcher.TROPHY_REGISTRY, tp.fish().getKey().location());
    }

    private static void register(BootstrapContext<TrophyProperties> context, TrophyProperties.Builder builder) {
        TrophyProperties entry = builder.build();
        context.register(createKey(entry), entry);
    }

    @SuppressWarnings("deprecation")
    public static void bootstrap(BootstrapContext<TrophyProperties> context) {

        register(context, TrophyProperties.builder()
                .setFish(ModBlocks.TROPHY_GOLD.asItem().builtInRegistryHolder())
                .alwaysShow()
                .setTrophyType(TrophyProperties.TrophyType.TROPHY)
                .setCustomName("Trophy of Masterful Fishing")
                .setAllProgress(new TrophyProperties.RarityProgress(50, 0))
        );

        register(context, TrophyProperties.builder()
                .setFish(ModBlocks.TROPHY_SILVER.asItem().builtInRegistryHolder())
                .alwaysShow()
                .setTrophyType(TrophyProperties.TrophyType.TROPHY)
                .setCustomName("Trophy of Skilled Fishing")
                .setAllProgress(new TrophyProperties.RarityProgress(25, 0))
        );

        register(context, TrophyProperties.builder()
                .setFish(ModBlocks.TROPHY_BRONZE.asItem().builtInRegistryHolder())
                .alwaysShow()
                .setTrophyType(TrophyProperties.TrophyType.TROPHY)
                .setAllProgress(new TrophyProperties.RarityProgress(10, 0))
        );

        register(context, TrophyProperties.builder()
                .setFish(ModBlocks.TROPHY_SILVER.asItem().builtInRegistryHolder())
                .alwaysShow()
                .setTrophyType(TrophyProperties.TrophyType.TROPHY)
                .setCustomName("Trophy of Flowing Fishes")
                .setAllProgress(new TrophyProperties.RarityProgress(0, 50))
        );

        register(context, TrophyProperties.builder()
                .setFish(ModBlocks.TROPHY_GOLD.asItem().builtInRegistryHolder())
                .alwaysShow()
                .setTrophyType(TrophyProperties.TrophyType.TROPHY)
                .setCustomName("Trophy of Infinite Fishes")
                .setAllProgress(new TrophyProperties.RarityProgress(0, 90))
        );

        register(context, TrophyProperties.builder()
                .setFish(ModBlocks.TROPHY_GOLD.asItem().builtInRegistryHolder())
                .alwaysShow()
                .setTrophyType(TrophyProperties.TrophyType.TROPHY)
                .setCustomName("Trophy of the Older Angler")
                .setAllProgress(new TrophyProperties.RarityProgress(200, 0))
                .withProgress(FishProperties.Rarity.COMMON, new TrophyProperties.RarityProgress(0, 36))
                .withProgress(FishProperties.Rarity.UNCOMMON, new TrophyProperties.RarityProgress(0, 23))
                .withProgress(FishProperties.Rarity.RARE, new TrophyProperties.RarityProgress(0, 14))
                .withProgress(FishProperties.Rarity.EPIC, new TrophyProperties.RarityProgress(0, 13))
                .withProgress(FishProperties.Rarity.LEGENDARY, new TrophyProperties.RarityProgress(0, 8))
        );
        //                                         ,--.
        // ,---.   ,---.   ,---. ,--.--.  ,---.  ,-'  '-.  ,---.
        //(  .-'  | .-. : | .--' |  .--' | .-. : '-.  .-' (  .-'
        //.-'  `) \   --. \ `--. |  |    \   --.   |  |   .-'  `)
        //`----'   `----'  `---' `--'     `----'   `--'   `----'
        //

        register(context, TrophyProperties.builder()
                .setFishProperties(overworldFish(ModItems.DRIFTING_WATERLOGGED_BOTTLE))
                .setTrophyType(TrophyProperties.TrophyType.SECRET)
                .setAllProgress(new TrophyProperties.RarityProgress(6, 15))
        );

        register(context, TrophyProperties.builder()
                .setFishProperties(overworldSurfaceLava(ModItems.SCALDING_BOTTLE))
                .setTrophyType(TrophyProperties.TrophyType.SECRET)
                .setAllProgress(new TrophyProperties.RarityProgress(0, 27))
                .setChanceToCatch(33)
        );

        register(context, TrophyProperties.builder()
                .setFishProperties(overworldSurfaceLava(ModItems.BURNING_BOTTLE))
                .setTrophyType(TrophyProperties.TrophyType.SECRET)
                .setAllProgress(new TrophyProperties.RarityProgress(0, 42))
                .setChanceToCatch(33)
        );

        register(context, TrophyProperties.builder()
                .setFishProperties(overworldDeepOceanFish(ModItems.HOPEFUL_BOTTLE))
                .setTrophyType(TrophyProperties.TrophyType.SECRET)
                .withProgress(FishProperties.Rarity.EPIC, new TrophyProperties.RarityProgress(5, 0))
                .setChanceToCatch(33)
        );

        register(context, TrophyProperties.builder()
                .setFishProperties(overworldDeepOceanFish(ModItems.HOPELESS_BOTTLE))
                .setTrophyType(TrophyProperties.TrophyType.SECRET)
                .withProgress(FishProperties.Rarity.EPIC, new TrophyProperties.RarityProgress(5, 0))
                .setChanceToCatch(33)
        );

        register(context, TrophyProperties.builder()
                .setFishProperties(overworldRiverFish(ModItems.TRUE_BLUE_BOTTLE))
                .setTrophyType(TrophyProperties.TrophyType.SECRET)
                .withProgress(FishProperties.Rarity.LEGENDARY, new TrophyProperties.RarityProgress(1, 0))
                .setChanceToCatch(1)
        );

        //
        //          ,--.   ,--.
        // ,---.  ,-'  '-. |  ,---.   ,---.  ,--.--.  ,---.
        //| .-. | '-.  .-' |  .-.  | | .-. : |  .--' (  .-'
        //' '-' '   |  |   |  | |  | \   --. |  |    .-'  `)
        // `---'    `--'   `--' `--'  `----' `--'    `----'
        //
        register(context, TrophyProperties.builder()
                .setFishProperties(overworldFish(ModItems.SHINY_HOOK))
                .setTrophyType(TrophyProperties.TrophyType.EXTRA)
                .setAllProgress(new TrophyProperties.RarityProgress(15, 0))
        );

        register(context, TrophyProperties.builder().setFishProperties(overworldDeepslateFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.DIAMOND)))
                .setTrophyType(TrophyProperties.TrophyType.EXTRA)
                .withProgress(FishProperties.Rarity.RARE, new TrophyProperties.RarityProgress(1, 4))
        );

        register(context, TrophyProperties.builder().setFishProperties(netherLavaFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.GOLD_BLOCK)))
                .setTrophyType(TrophyProperties.TrophyType.EXTRA)
                .withProgress(FishProperties.Rarity.LEGENDARY, new TrophyProperties.RarityProgress(3, 0))
                .setChanceToCatch(33)
        );

        register(context, TrophyProperties.builder().setFishProperties(netherLavaFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.NETHERITE_SCRAP)))
                .setTrophyType(TrophyProperties.TrophyType.EXTRA)
                .withProgress(FishProperties.Rarity.LEGENDARY, new TrophyProperties.RarityProgress(0, 10))
                .setChanceToCatch(33)
        );

        register(context, TrophyProperties.builder().setFishProperties(netherLavaFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)))
                .setTrophyType(TrophyProperties.TrophyType.EXTRA)
                .setChanceToCatch(1)
        );

        register(context, TrophyProperties.builder().setFishProperties(netherLavaFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.HEART_OF_THE_SEA)))
                        .setTrophyType(TrophyProperties.TrophyType.EXTRA)
                        .setAllProgress(new TrophyProperties.RarityProgress(25, 0))
                        .setChanceToCatch(1)
        );
    }
}
