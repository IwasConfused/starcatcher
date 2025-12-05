package com.wdiscute.starcatcher.registry.fishing;

import com.mojang.datafixers.util.Pair;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.datagen.TrustedHolder;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class FishingPropertiesRegistry {

    public static void register() {
        MinecraftFishingProperties.bootstrap();
        StarcatcherOverworldFishingProperties.bootstrap();
        StarcatcherNetherFishingProperties.bootstrap();
        StarcatcherEndFishingProperties.bootstrap();
        TideFishingProperties.bootstrap();
        AquaCultureFishingProperties.bootstrap();
        FishOfThievesFishingProperties.bootstrap();
        NetherDepthsUpgradeFishingProperties.bootstrap();
        SullysModFishingProperties.bootstrap();
        UpgradeAquaticFishingProperties.bootstrap();
        EnvironmentalFishingProperties.bootstrap();
        CollectorsReapFishingProperties.bootstrap();
        MinersDelightFishingProperties.bootstrap();
        AlexesCavesFishingProperties.bootstrap();
        CrittersAndCompanionsFishingProperties.bootstrap();
    }

    //region builders
    static FishProperties.Builder fish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish);
    }

    static FishProperties.Builder overworldFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD);
    }

    static FishProperties.Builder endFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.END);
    }

    static FishProperties.Builder endOuterIslandsFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.END_OUTER_ISLANDS);
    }

    static FishProperties.Builder netherLavaFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.NETHER_LAVA);
    }

    static FishProperties.Builder netherLavaCrimsonForestFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.NETHER_LAVA_CRIMSON_FOREST);
    }

    static FishProperties.Builder netherLavaWarpedForestFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.NETHER_LAVA_WARPED_FOREST);
    }

    static FishProperties.Builder netherLavaSoulSandValleyFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.NETHER_LAVA_SOUL_SAND_VALLEY);
    }

    static FishProperties.Builder netherLavaBasaltDeltasFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.NETHER_LAVA_BASALT_DELTAS);
    }

    static FishProperties.Builder overworldLushCavesFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_LUSH_CAVES)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LUSH_BAIT);
    }

    static FishProperties.Builder overworldDeepDarkFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_DEEP_DARK)
                .withBaitRestrictions(FishProperties.BaitRestrictions.SCULK_BAIT);
    }

    static FishProperties.Builder overworldSurfaceFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_SURFACE);
    }

    static FishProperties.Builder overworldSurfaceLava(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_LAVA_SURFACE);
    }

    static FishProperties.Builder overworldCavesFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_STONE_CAVES);
    }

    static FishProperties.Builder overworldDripstoneCavesFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_DRIPSTONE_CAVES)
                .withBaitRestrictions(FishProperties.BaitRestrictions.DRIPSTONE_BAIT);
    }

    static FishProperties.Builder overworldUndergroundFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_UNDERGROUND);
    }

    static FishProperties.Builder overworldUndergroundLava(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_LAVA_UNDERGROUND);
    }

    static FishProperties.Builder overworldMountainFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_LAKE.withMustBeCaughtAboveY(100));
    }

    static FishProperties.Builder overworldDeepslateFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_DEEPSLATE);
    }

    static FishProperties.Builder overworldDeepslateLava(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_LAVA_DEEPSLATE);
    }

    static FishProperties.Builder overworldColdLakeFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_COLD_LAKE);
    }

    static FishProperties.Builder overworldWarmLakeFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_WARM_LAKE);
    }

    static FishProperties.Builder overworldWarmMountainFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_WARM_LAKE);
    }

    static FishProperties.Builder overworldColdMountainFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_COLD_MOUNTAIN);
    }

    static FishProperties.Builder overworldColdOceanFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_COLD_OCEAN);
    }

    static FishProperties.Builder overworldColdRiverFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_COLD_RIVER);
    }

    static FishProperties.Builder overworldLakeFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_LAKE);
    }

    static FishProperties.Builder overworldOceanFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_OCEAN);
    }

    static FishProperties.Builder overworldWarmOceanFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_WARM_OCEAN);
    }

    static FishProperties.Builder overworldDeepOceanFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_DEEP_OCEAN);
    }

    static FishProperties.Builder overworldRiverFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_RIVER);
    }

    static FishProperties.Builder overworldBeachFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_BEACH);
    }


    static FishProperties.Builder overworldMushroomFieldsFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_MUSHROOM_FIELDS);
    }

    static FishProperties.Builder overworldJungleFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_JUNGLE);
    }

    static FishProperties.Builder overworldTaigaFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_TAIGA);
    }

    static FishProperties.Builder overworldCherryGroveFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_CHERRY_GROVE)
                .withBaitRestrictions(FishProperties.BaitRestrictions.CHERRY_BAIT);
    }

    static FishProperties.Builder overworldSwampFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_SWAMP)
                .withBaitRestrictions(FishProperties.BaitRestrictions.MURKWATER_BAIT);
    }

    static FishProperties.Builder overworldDarkForestFish(Holder<Item> fish) {
        return FishProperties.builder().withFish(fish)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_DARK_FOREST);
    }

    //endregion

    static ResourceLocation rl(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }

    static Holder<Item> fromRL(String ns, String path) {
        return TrustedHolder.createStandAlone(BuiltInRegistries.ITEM.holderOwner(), ResourceKey.create(Registries.ITEM, rl(ns, path)));
    }

    private static final List<Pair<ResourceKey<FishProperties>, FishProperties>> PROPERTIES = new ArrayList<>();
    private static final List<ResourceKey<FishProperties>> COMPAT_KEYS = new ArrayList<>();

    private static int customFishCount = 0;

    static ResourceKey<FishProperties> createKey(FishProperties fp) {
        if (fp.customName()
                .isEmpty()) {
            return ResourceKey.create(
                    Starcatcher.FISH_REGISTRY, ResourceLocation.parse(fp.catchInfo().fish()
                            .getRegisteredName()));
        } else {
            customFishCount++;
            return ResourceKey.create(
                    Starcatcher.FISH_REGISTRY, ResourceLocation.parse(fp.catchInfo().fish()
                            .getRegisteredName() + "_" + customFishCount));
        }
    }

    static void register(FishProperties.Builder builder) {
        FishProperties properties = builder.build();
        ResourceKey<FishProperties> key = FishingPropertiesRegistry.createKey(properties);
        PROPERTIES.add(Pair.of(key, properties));
        String namespace = key.location().getNamespace();
        if (!namespace.equals("minecraft") && !namespace.equals("starcatcher"))
            COMPAT_KEYS.add(key);
    }

    public static void registerConditions(BiConsumer<ResourceKey<?>, ICondition> consumer) {
        for (ResourceKey<FishProperties> compatKey : COMPAT_KEYS) {
            consumer.accept(compatKey, new ModLoadedCondition(compatKey.location().getNamespace()));
        }
    }

    public static void bootstrap(BootstrapContext<FishProperties> context) {
        PROPERTIES.forEach(p -> context.register(p.getFirst(), p.getSecond()));
    }
}
