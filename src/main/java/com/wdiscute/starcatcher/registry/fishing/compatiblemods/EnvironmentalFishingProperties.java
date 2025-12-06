package com.wdiscute.starcatcher.registry.fishing.compatiblemods;

import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class EnvironmentalFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {

        //
        //,------.                     ,--.                                                        ,--.            ,--.
        //|  .---' ,--,--,  ,--.  ,--. `--' ,--.--.  ,---.  ,--,--,  ,--,--,--.  ,---.  ,--,--,  ,-'  '-.  ,--,--. |  |
        //|  `--,  |      \  \  `'  /  ,--. |  .--' | .-. | |      \ |        | | .-. : |      \ '-.  .-' ' ,-.  | |  |
        //|  `---. |  ||  |   \    /   |  | |  |    ' '-' ' |  ||  | |  |  |  | \   --. |  ||  |   |  |   \ '-'  | |  |
        //`------' `--''--'    `--'    `--' `--'     `---'  `--''--' `--`--`--'  `----' `--''--'   `--'    `--`--' `--'
        //

        register(fish(fromRL("environmental", "koi"))
                .withBucketedFish(fromRL("environmental", "koi_bucket"))
                .withEntityToSpawn(rl("environmental", "koi"))
                .withSizeAndWeight(FishProperties.sw(60, 20, 3000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_FAST_FISH)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomes(rl("environmental", "blossom_woods"), rl("environmental", "blossom_valleys")))
        );

        register(fish(fromRL("environmental", "slabfish_bucket"))
                .withAlwaysSpawnEntity(true)
                .withBucketedFish(fromRL("environmental", "slabfish_bucket"))
                .withEntityToSpawn(rl("environmental", "slabfish_bucket"))
                .withSizeAndWeight(FishProperties.sw(120, 40, 20000, 10000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomes(rl("environmental", "marsh"))
                        .withBiomesTags(StarcatcherTags.IS_SWAMP))
        );

    }
}
