package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;


public class MinecraftFishingProperties {
    public static void bootstrap() {

        //ocean
        register(overworldOceanFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.COD))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 20)));

        register(overworldOceanFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.PUFFERFISH))
                .withSizeAndWeight(FishProperties.sw(70, 20, 10000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withBaseChance(4));

        //river
        register(overworldRiverFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.SALMON))
                .withSizeAndWeight(FishProperties.sw(80, 40, 10000, 8000, 10, 20)));



        register(overworldFish(fromRL("minecraft", "creeper_head"))
                .withSizeAndWeight(FishProperties.SizeAndWeight.NONE)
                .withBaseChance(0)
                .withBaitRestrictions(
                        FishProperties.BaitRestrictions.DEFAULT
                                .withCorrectBait(Starcatcher.rl("creeper_bait"))
                                .withCorrectBaitChanceAdded(20)
                )
                .withAlwaysSpawnEntity(true)
                .withEntityToSpawn(rl("minecraft", "creeper"))
                .withOverrideMinigameItem(true)
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
                .withSkipMinigame(true));

        register(overworldSurfaceFish(fromRL("minecraft", "rotten_flesh"))
                .withSizeAndWeight(FishProperties.SizeAndWeight.NONE)
                .withBaseChance(1)
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withWeather(FishProperties.Weather.RAIN)
                .withHasGuideEntry(false)
                .withAlwaysSpawnEntity(true)
                .withEntityToSpawn(rl("minecraft", "drowned"))
                .withOverrideMinigameItem(true)
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
                .withSkipMinigame(true));
    }
}
