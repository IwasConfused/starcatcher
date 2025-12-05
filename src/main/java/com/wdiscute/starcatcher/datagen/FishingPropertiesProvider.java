package com.wdiscute.starcatcher.datagen;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class FishingPropertiesProvider extends DatapackBuiltinEntriesProvider {

    static {
        FishingPropertiesRegistry.register(); //register all entries before anything else
    }

    public static final RegistrySetBuilder REGISTRY = new RegistrySetBuilder()
            //fishes
            .add(Starcatcher.FISH_REGISTRY, FishingPropertiesRegistry::bootstrap);

    public FishingPropertiesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, REGISTRY, FishingPropertiesProvider::addConditions, Set.of(
                Starcatcher.MOD_ID,
                "tide",
                "aquaculture",
                "fishofthieves",
                "netherdepthsupgrade",
                "sullysmod",
                "upgrade_aquatic",
                "environmental",
                "collectorsreap",
                "miners_delight",
                "alexscaves",
                "crittersandcompanions"
                //That's a lot of compatibilities
        ));
    }

    private static void addConditions(final BiConsumer<ResourceKey<?>, ICondition> consumer) {
        FishingPropertiesRegistry.registerConditions(consumer);
    }

    //region restricted fps

    //list to store all fishes from other mods for compatibility, alongside the modid so it
    //datagens with the neoforge restrictions modifier

    //example of a custom fish using starcatcher's pink_koi as a base for the fish

//            FishProperties.DEFAULT
//                    .withFish(baseItem("starcatcher", "pink_koi"))
//                    .withWorldRestrictions(
//                            FishProperties.WorldRestrictions.DEFAULT
//                                    .withBiomes(List.of(baseItem("mysticcraft", "cool_biome")))
//                                    .withFluids(List.of(baseItem("mysticcraft", "magical_water"))))
//                    .withDifficulty(FishProperties.Difficulty.HARD)
//                    .withRarity(FishProperties.Rarity.EPIC)
//                    .withWeather(FishProperties.Weather.RAIN)
//                    .withDaytime(FishProperties.Daytime.MIDNIGHT)
//                    .withMod("mysticcraft")

    //alexsmobs:
    //  cosmic_cod
    //  flying_fish
    //  blobfish

    //endregion restricted fps

    //endregion trophies

    @Override
    public String getName() {
        return "FishingProperties";
    }
}
