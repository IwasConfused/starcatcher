package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class TerraFirmaCraftFishProperties extends FishingPropertiesRegistry
{
    public static void bootstrap() {

        //
        //   ,--.
        // ,-'  '-.  ,---.  ,--.--. ,--.--.  ,--,--.
        // '-.  .-' | .-. : |  .--' |  .--' ' ,-.  |
        //   |  |   \   --. |  |    |  |    \ '-'  |
        //   `--'    `----' `--'    `--'     `--`--'
        //  ,---. ,--.
        // /  .-' `--' ,--.--. ,--,--,--.  ,--,--.
        // |  `-, ,--. |  .--' |        | ' ,-.  |
        // |  .-' |  | |  |    |  |  |  | \ '-'  |
        // `--'   `--' `--'    `--`--`--'  `--`--'
        //                          ,---.   ,--.
        //  ,---. ,--.--.  ,--,--. /  .-' ,-'  '-.
        // | .--' |  .--' ' ,-.  | |  `-, '-.  .-'
        // \ `--. |  |    \ '-'  | |  .-'   |  |
        //  `---' `--'     `--`--' `--'     `--'
        //


        register(overworldLakeFish(fromRL("tfc", "food/bluegill"))
                .withBucketedFish(fromRL("tfc", "bucket/bluegill"))
                .withEntityToSpawn(rl("tfc", "bluegill"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldRiverFish(fromRL("tfc", "food/lake_trout"))
                .withBucketedFish(fromRL("tfc", "bucket/lake_trout"))
                .withEntityToSpawn(rl("tfc", "lake_trout"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldLakeFish(fromRL("tfc", "food/largemouth_bass"))
                .withBucketedFish(fromRL("tfc", "bucket/bluegill"))
                .withEntityToSpawn(rl("tfc", "bluegill"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldRiverFish(fromRL("tfc", "food/rainbow_trout"))
                .withBucketedFish(fromRL("tfc", "bucket/rainbow_trout"))
                .withEntityToSpawn(rl("tfc", "rainbow_trout"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldLakeFish(fromRL("tfc", "food/smallmouth_bass"))
                .withBucketedFish(fromRL("tfc", "bucket/smallmouth_bass"))
                .withEntityToSpawn(rl("tfc", "smallmouth_bass"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldLakeFish(fromRL("tfc", "food/salmon"))
                .withBucketedFish(fromRL("tfc", "bucket/salmon"))
                .withEntityToSpawn(rl("tfc", "salmon"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldOceanFish(fromRL("tfc", "food/cod"))
                .withBucketedFish(fromRL("tfc", "bucket/cod"))
                .withEntityToSpawn(rl("tfc", "cod"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );


        //dolphin
        //todo change baits to use tag #tfc:large_fishing_bait and #tfc:small_fishing_bait
        register(overworldOceanFish(fromRL("tfc", "blubber"))
                .withEntityToSpawn(rl("tfc", "dolphin"))
                .withBaseChance(0)
                .withAlwaysSpawnEntity(true)
                .withSkipMinigame(true)
                .withBaitRestrictions(FishProperties.BaitRestrictions.DEFAULT
                        .withCorrectBaitChanceAdded(5)
                        .withCorrectBait(
                                rl("tfc", "food/bluegill"),
                                rl("tfc", "food/cod"),
                                rl("tfc", "food/salmon"),
                                rl("tfc", "food/tropical_fish")
                        )
                )
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withHasGuideEntry(false)
        );






        //trash
        register(overworldOceanFish(fromRL("tfc", "food/fresh_seaweed"))
                .withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false)
        );

        register(overworldRiverFish(fromRL("tfc", "food/shellfish"))
                .withEntityToSpawn(rl("tfc", "crayfish"))
                .withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false)
        );

        register(overworldOceanFish(fromRL("tfc", "groundcover/sea_urchin"))
                .withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false)
        );

        register(overworldBeachFish(fromRL("tfc", "groundcover/clam"))
                .withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false)
        );

        register(overworldFish(fromRL("tfc", "groundcover/driftwood"))
                .withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false)
        );



    }
}
