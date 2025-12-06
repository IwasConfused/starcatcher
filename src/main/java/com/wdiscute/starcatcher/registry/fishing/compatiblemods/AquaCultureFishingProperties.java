package com.wdiscute.starcatcher.registry.fishing.compatiblemods;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.FishProperties.WorldRestrictions.Seasons;

public class AquaCultureFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {

        //
        //                                                   ,--.   ,--.                                 ,---.
        // ,--,--.  ,---.  ,--.,--.  ,--,--.  ,---. ,--.,--. |  | ,-'  '-. ,--.,--. ,--.--.  ,---.      '.-.  \
        //' ,-.  | | .-. | |  ||  | ' ,-.  | | .--' |  ||  | |  | '-.  .-' |  ||  | |  .--' | .-. :      .-' .'
        //\ '-'  | ' '-' | '  ''  ' \ '-'  | \ `--. '  ''  ' |  |   |  |   '  ''  ' |  |    \   --.     /   '-.
        // `--`--'  `-|  |  `----'   `--`--'  `---'  `----'  `--'   `--'    `----'  `--'     `----'     '-----'
        //            `--'


        //freshwater
        register(overworldRiverFish(fromRL("aquaculture", "smallmouth_bass"))
                .withBucketedFish(fromRL("aquaculture", "smallmouth_bass_bucket"))
                .withEntityToSpawn(rl("aquaculture", "smallmouth_bass"))
                .withSeasons(Seasons.SPRING, Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(30, 10, 1500, 500, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withDaytime(FishProperties.Daytime.DAY)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldRiverFish(fromRL("aquaculture", "bluegill"))
                .withBucketedFish(fromRL("aquaculture", "smallmouth_bass_bucket"))
                .withEntityToSpawn(rl("aquaculture", "smallmouth_bass"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(15, 3, 300, 200, 10, 20))
        );

        register(overworldRiverFish(fromRL("aquaculture", "brown_trout"))
                .withBucketedFish(fromRL("aquaculture", "brown_trout_bucket"))
                .withEntityToSpawn(rl("aquaculture", "brown_trout"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(45, 15, 3000, 2000, 10, 20))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withWeather(FishProperties.Weather.CLEAR)
        );

        register(overworldRiverFish(fromRL("aquaculture", "carp"))
                .withBucketedFish(fromRL("aquaculture", "carp_bucket"))
                .withEntityToSpawn(rl("aquaculture", "carp"))
                .withSeasons(Seasons.SPRING, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(60, 20, 10000, 4000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withRarity(FishProperties.Rarity.RARE)
                .withWeather(FishProperties.Weather.RAIN)
        );

        register(overworldMountainFish(fromRL("aquaculture", "catfish"))
                .withBucketedFish(fromRL("aquaculture", "catfish_bucket"))
                .withEntityToSpawn(rl("aquaculture", "catfish"))
                .withSizeAndWeight(FishProperties.sw(150, 40, 100000, 25000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.THIN_NO_DECAY_NOT_FORGIVING)
                .withRarity(FishProperties.Rarity.EPIC)
                .withWeather(FishProperties.Weather.RAIN)
        );

        register(overworldMountainFish(fromRL("aquaculture", "gar"))
                .withBucketedFish(fromRL("aquaculture", "gar_bucket"))
                .withEntityToSpawn(rl("aquaculture", "gar"))
                .withSeasons(Seasons.SPRING, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(160, 30, 160000, 20000, 10, 20))
        );

        register(overworldLakeFish(fromRL("aquaculture", "minnow"))
                .withBucketedFish(fromRL("aquaculture", "minnow_bucket"))
                .withEntityToSpawn(rl("aquaculture", "minnow"))
                .withSizeAndWeight(FishProperties.sw(6, 4, 10, 4, 10, 20))
        );

        register(overworldLakeFish(fromRL("aquaculture", "muskellunge"))
                .withBucketedFish(fromRL("aquaculture", "muskellunge_bucket"))
                .withEntityToSpawn(rl("aquaculture", "muskellunge"))
                .withSizeAndWeight(FishProperties.sw(100, 10, 7000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDaytime(FishProperties.Daytime.MIDNIGHT)
        );

        register(overworldLakeFish(fromRL("aquaculture", "perch"))
                .withBucketedFish(fromRL("aquaculture", "perch_bucket"))
                .withEntityToSpawn(rl("aquaculture", "perch"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(20, 5, 500, 200, 10, 20))
        );

        //arid
        register(overworldWarmMountainFish(fromRL("aquaculture", "bayad"))
                .withBucketedFish(fromRL("aquaculture", "bayad_bucket"))
                .withEntityToSpawn(rl("aquaculture", "bayad"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(170, 30, 150000, 20000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withDaytime(FishProperties.Daytime.NIGHT)
        );

        register(overworldWarmLakeFish(fromRL("aquaculture", "boulti"))
                .withBucketedFish(fromRL("aquaculture", "boulti_bucket"))
                .withEntityToSpawn(rl("aquaculture", "boulti"))
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(40, 10, 4000, 300, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDaytime(FishProperties.Daytime.DAY)
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(overworldWarmMountainFish(fromRL("aquaculture", "capitaine"))
                .withBucketedFish(fromRL("aquaculture", "capitaine_bucket"))
                .withEntityToSpawn(rl("aquaculture", "capitaine"))
                .withSeasons(Seasons.SPRING, Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(130, 50, 12000, 3000, 10, 20))
        );

        register(overworldWarmMountainFish(fromRL("aquaculture", "synodontis"))
                .withBucketedFish(fromRL("aquaculture", "synodontis_bucket"))
                .withEntityToSpawn(rl("aquaculture", "synodontis"))
                .withSizeAndWeight(FishProperties.sw(35, 15, 1000, 300, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING)
                .withRarity(FishProperties.Rarity.EPIC)
        );

        //arctic ocean
        register(overworldColdOceanFish(fromRL("aquaculture", "atlantic_cod"))
                .withBucketedFish(fromRL("aquaculture", "atlantic_cod_bucket"))
                .withEntityToSpawn(rl("aquaculture", "atlantic_cod"))
                .withSeasons(Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withDaytime(FishProperties.Daytime.DAY)
        );

        register(overworldColdOceanFish(fromRL("aquaculture", "blackfish"))
                .withBucketedFish(fromRL("aquaculture", "blackfish_bucket"))
                .withEntityToSpawn(rl("aquaculture", "blackfish"))
                .withSeasons(Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(50, 20, 5000, 3000, 10, 20))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldColdOceanFish(fromRL("aquaculture", "pacific_halibut"))
                .withBucketedFish(fromRL("aquaculture", "pacific_halibut_bucket"))
                .withEntityToSpawn(rl("aquaculture", "pacific_halibut"))
                .withSeasons(Seasons.WINTER, Seasons.AUTUMN, Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(150, 50, 80000, 5000, 10, 20))
        );

        register(overworldColdOceanFish(fromRL("aquaculture", "atlantic_halibut"))
                .withBucketedFish(fromRL("aquaculture", "atlantic_halibut_bucket"))
                .withEntityToSpawn(rl("aquaculture", "atlantic_halibut"))
                .withSizeAndWeight(FishProperties.sw(200, 80, 150000, 10000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withWeather(FishProperties.Weather.RAIN)
        );

        register(overworldColdOceanFish(fromRL("aquaculture", "atlantic_herring"))
                .withBucketedFish(fromRL("aquaculture", "atlantic_herring_bucket"))
                .withEntityToSpawn(rl("aquaculture", "atlantic_herring"))
                .withSeasons(Seasons.WINTER, Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(25, 5, 200, 100, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING)
                .withRarity(FishProperties.Rarity.RARE)
                .withDaytime(FishProperties.Daytime.DAY)
        );

        register(overworldColdOceanFish(fromRL("aquaculture", "pink_salmon"))
                .withBucketedFish(fromRL("aquaculture", "pink_salmon_bucket"))
                .withEntityToSpawn(rl("aquaculture", "pink_salmon"))
                .withSeasons(Seasons.WINTER, Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(50, 10, 2000, 1000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withWeather(FishProperties.Weather.THUNDER)
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(overworldColdOceanFish(fromRL("aquaculture", "pollock"))
                .withBucketedFish(fromRL("aquaculture", "pollock_bucket"))
                .withEntityToSpawn(rl("aquaculture", "pollock"))
                .withSizeAndWeight(FishProperties.sw(70, 30, 5000, 4000, 10, 20))
        );

        register(overworldColdOceanFish(fromRL("aquaculture", "rainbow_trout"))
                .withBucketedFish(fromRL("aquaculture", "rainbow_trout_bucket"))
                .withEntityToSpawn(rl("aquaculture", "rainbow_trout"))
                .withSeasons(Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(60, 20, 2000, 1500, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDaytime(FishProperties.Daytime.DAY)
        );

        //saltwater
        register(overworldOceanFish(fromRL("aquaculture", "jellyfish"))
                .withBucketedFish(fromRL("aquaculture", "jellyfish_bucket"))
                .withEntityToSpawn(rl("aquaculture", "jellyfish_trout"))
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(100, 70, 50000, 40000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withBaseChance(3)
        );

        register(overworldOceanFish(fromRL("aquaculture", "red_grouper"))
                .withBucketedFish(fromRL("aquaculture", "red_grouper_bucket"))
                .withEntityToSpawn(rl("aquaculture", "red_grouper"))
                .withSeasons(Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
        );

        register(overworldOceanFish(fromRL("aquaculture", "tuna"))
                .withBucketedFish(fromRL("aquaculture", "tuna_bucket"))
                .withEntityToSpawn(rl("aquaculture", "tuna"))
                .withSizeAndWeight(FishProperties.sw(200, 100, 200000, 150000, 10, 20))
        );

        //jungle
        register(overworldJungleFish(fromRL("aquaculture", "arapaima"))
                .withBucketedFish(fromRL("aquaculture", "arapaima_bucket"))
                .withEntityToSpawn(rl("aquaculture", "arapaima"))
                .withSeasons(Seasons.AUTUMN, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(250, 50, 50000, 150000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withWeather(FishProperties.Weather.RAIN)
        );

        register(overworldJungleFish(fromRL("aquaculture", "arrau_turtle"))
                //no bucketed version
                .withEntityToSpawn(rl("aquaculture", "arrau_turtle"))
                .withSizeAndWeight(FishProperties.sw(100, 30, 80000, 150000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );


        register(overworldJungleFish(fromRL("aquaculture", "piranha"))
                .withBucketedFish(fromRL("aquaculture", "piranha_bucket"))
                .withEntityToSpawn(rl("aquaculture", "piranha"))
                .withSeasons(Seasons.SPRING, Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(30, 10, 500, 300, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_FLIP)
                .withDaytime(FishProperties.Daytime.NOON)
        );

        register(overworldJungleFish(fromRL("aquaculture", "tambaqui"))
                .withBucketedFish(fromRL("aquaculture", "tambaqui_bucket"))
                .withEntityToSpawn(rl("aquaculture", "tambaqui"))
                .withSizeAndWeight(FishProperties.sw(100, 30, 150000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        //swamp
        register(overworldSwampFish(fromRL("aquaculture", "leech"))
                //no bucketed version
                //no entity
                .withSeasons(Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(10, 5, 5, 3, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(overworldSwampFish(fromRL("aquaculture", "box_turtle"))
                //no bucketed version
                .withEntityToSpawn(rl("aquaculture", "box_turtle"))
                .withSizeAndWeight(FishProperties.sw(20, 5, 1000, 500, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withWeather(FishProperties.Weather.RAIN)
        );

        //mushroom island
        register(overworldMushroomFieldsFish(fromRL("aquaculture", "brown_shrooma"))
                .withBucketedFish(fromRL("aquaculture", "brown_shrooma_bucket"))
                .withEntityToSpawn(rl("aquaculture", "brown_shrooma"))
                .withSizeAndWeight(FishProperties.sw(100, 20, 3000, 500, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING)
        );

        register(overworldMushroomFieldsFish(fromRL("aquaculture", "red_shrooma"))
                .withBucketedFish(fromRL("aquaculture", "brown_shrooma_bucket"))
                .withEntityToSpawn(rl("aquaculture", "brown_shrooma"))
                .withSizeAndWeight(FishProperties.sw(100, 20, 3000, 500, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_FLIP)
        );

        //anywhere
        register(overworldFish(fromRL("aquaculture", "goldfish"))
                //no bucketed version
                //no entity
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(15, 5, 100, 5, 10, 20))
                .withBaseChance(1)
        );

        //endregion Aquaculture 2

    }
}
