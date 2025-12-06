package com.wdiscute.starcatcher.registry.fishing.compatiblemods;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.FishProperties.WorldRestrictions.Seasons;

public class FishOfThievesFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {

        //region Fish of Thieves

        register(overworldOceanFish(fromRL("fishofthieves", "splashtail"))
                .withBucketedFish(fromRL("fishofthieves", "splashtail_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "splashtail"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(250, 70, 7600, 2000, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
        );

        register(overworldLakeFish(fromRL("fishofthieves", "pondie"))
                .withBucketedFish(fromRL("fishofthieves", "pondie_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "pondie"))
                .withSeasons(Seasons.SPRING, Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(190, 30, 9000, 3600, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldRiverFish(fromRL("fishofthieves", "islehopper"))
                .withBucketedFish(fromRL("fishofthieves", "islehopper_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "islehopper"))
                .withSizeAndWeight(FishProperties.sw(300, 20, 23000, 3600, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldWarmOceanFish(fromRL("fishofthieves", "ancientscale"))
                .withBucketedFish(fromRL("fishofthieves", "ancientscale_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "ancientscale"))
                .withSeasons(Seasons.SPRING, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(70, 10, 4000, 2000, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
                .withRarity(FishProperties.Rarity.RARE)
        );

        register(overworldWarmOceanFish(fromRL("fishofthieves", "plentifin"))
                .withBucketedFish(fromRL("fishofthieves", "plentifin_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "plentifin"))
                .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldLushCavesFish(fromRL("fishofthieves", "wildsplash"))
                .withBucketedFish(fromRL("fishofthieves", "wildsplash_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "wildsplash"))
                .withSeasons(Seasons.SPRING, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(120, 30, 8000, 2200, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldDeepslateFish(fromRL("fishofthieves", "devilfish"))
                .withBucketedFish(fromRL("fishofthieves", "devilfish_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "devilfish"))
                .withSizeAndWeight(FishProperties.sw(180, 80, 20000, 2200, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withRarity(FishProperties.Rarity.RARE)
        );

        register(overworldColdOceanFish(fromRL("fishofthieves", "battlegill"))
                .withBucketedFish(fromRL("fishofthieves", "battlegill_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "battlegill"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(100, 10, 19000, 4200, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(endFish(fromRL("fishofthieves", "wrecker"))
                .withBucketedFish(fromRL("fishofthieves", "wrecker_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "wrecker"))
                .withSeasons(Seasons.SPRING, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(100, 10, 19000, 4200, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.FISH_OF_THIEVES)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_FAST_FISH_VANISHING)
                .withRarity(FishProperties.Rarity.EPIC)
        );

        register(overworldOceanFish(fromRL("fishofthieves", "stormfish"))
                .withBucketedFish(fromRL("fishofthieves", "stormfish_bucket"))
                .withEntityToSpawn(rl("fishofthieves", "stormfish"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(150, 30, 14000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_FAST_FISH_VANISHING)
                .withWeather(FishProperties.Weather.THUNDER)
                .withRarity(FishProperties.Rarity.RARE)
        );

        //endregion Fish of Thieves
    }
}
