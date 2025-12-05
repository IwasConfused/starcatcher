package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.FishProperties.WorldRestrictions.Seasons;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;

public class FishOfThievesFishingProperties {
    public static void bootstrap() {

        //region Fish of Thieves

        register(overworldOceanFish(fromRL("fishofthieves", "splashtail"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(250, 70, 7600, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
        );

        register(overworldLakeFish(fromRL("fishofthieves", "pondie"))
                .withSeasons(Seasons.SPRING, Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(190, 30, 9000, 3600, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withBaseChance(2)
        );

        register(overworldRiverFish(fromRL("fishofthieves", "islehopper"))
                .withSizeAndWeight(FishProperties.sw(300, 20, 23000, 3600, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withBaseChance(2)
        );

        register(overworldWarmOceanFish(fromRL("fishofthieves", "ancientscale"))
                .withSeasons(Seasons.SPRING, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(70, 10, 4000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
                .withRarity(FishProperties.Rarity.RARE)
        );

        register(overworldWarmOceanFish(fromRL("fishofthieves", "plentifin"))
                .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldLushCavesFish(fromRL("fishofthieves", "wildsplash"))
                .withSeasons(Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(120, 30, 8000, 2200, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldDeepslateFish(fromRL("fishofthieves", "devilfish"))
                .withSizeAndWeight(FishProperties.sw(180, 80, 20000, 2200, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withRarity(FishProperties.Rarity.RARE)
        );

        register(overworldColdOceanFish(fromRL("fishofthieves", "battlegill"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(100, 10, 19000, 4200, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(endFish(fromRL("fishofthieves", "wrecker"))
                .withSeasons(Seasons.SPRING, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(100, 10, 19000, 4200, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_FAST_FISH_VANISHING)
                .withRarity(FishProperties.Rarity.EPIC)
        );

        register(overworldOceanFish(fromRL("fishofthieves", "stormfish"))
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(150, 30, 14000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_FAST_FISH_VANISHING)
                .withWeather(FishProperties.Weather.THUNDER)
                .withRarity(FishProperties.Rarity.RARE)
        );

        //endregion Fish of Thieves
    }
}
