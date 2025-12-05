package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.storage.FishProperties;

public class MinecraftFishingProperties {
    public static void bootstrap() {
        FishingPropertiesRegistry.register(FishingPropertiesRegistry.overworldFish(FishingPropertiesRegistry.fromRL("minecraft", "creeper_head"))
                .withSizeAndWeight(FishProperties.SizeAndWeight.NONE)
                .withBaseChance(0)
                .withBaitRestrictions(
                        FishProperties.BaitRestrictions.DEFAULT
                                .withCorrectBait(Starcatcher.rl("creeper_bait"))
                                .withCorrectBaitChanceAdded(20)
                )
                .withAlwaysSpawnEntity(true)
                .withEntityToSpawn(FishingPropertiesRegistry.rl("minecraft", "creeper"))
                .withOverrideMinigameItem(true)
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
                .withSkipMinigame(true));

        FishingPropertiesRegistry.register(FishingPropertiesRegistry.overworldSurfaceFish(FishingPropertiesRegistry.fromRL("minecraft", "rotten_flesh"))
                .withSizeAndWeight(FishProperties.SizeAndWeight.NONE)
                .withBaseChance(1)
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withWeather(FishProperties.Weather.RAIN)
                .withHasGuideEntry(false)
                .withAlwaysSpawnEntity(true)
                .withEntityToSpawn(FishingPropertiesRegistry.rl("minecraft", "drowned"))
                .withOverrideMinigameItem(true)
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
                .withSkipMinigame(true));
    }
}
