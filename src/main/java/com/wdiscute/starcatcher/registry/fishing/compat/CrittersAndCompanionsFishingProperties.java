package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class CrittersAndCompanionsFishingProperties extends FishingPropertiesRegistry
{


    public static void bootstrap()
    {

        //
        // ,-----.         ,--.   ,--.     ,--.                                                    ,--.      ,-----.                                              ,--.
        //'  .--./ ,--.--. `--' ,-'  '-. ,-'  '-.  ,---.  ,--.--.  ,---.       ,--,--. ,--,--,   ,-|  |     '  .--./  ,---.  ,--,--,--.  ,---.   ,--,--. ,--,--,  `--'  ,---.  ,--,--,   ,---.
        //|  |     |  .--' ,--. '-.  .-' '-.  .-' | .-. : |  .--' (  .-'      ' ,-.  | |      \ ' .-. |     |  |     | .-. | |        | | .-. | ' ,-.  | |      \ ,--. | .-. | |      \ (  .-'
        //'  '--'\ |  |    |  |   |  |     |  |   \   --. |  |    .-'  `)     \ '-'  | |  ||  | \ `-' |     '  '--'\ ' '-' ' |  |  |  | | '-' ' \ '-'  | |  ||  | |  | ' '-' ' |  ||  | .-'  `)
        // `-----' `--'    `--'   `--'     `--'    `----' `--'    `----'       `--`--' `--''--'  `---'       `-----'  `---'  `--`--`--' |  |-'   `--`--' `--''--' `--'  `---'  `--''--' `----'
        //                                                                                                                              `--'


        register(overworldBeachFish(fromRL("crittersandcompanions", "clam"))  //no mini game
                .withSkipMinigame(true)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_RIVER)
        );

        register(overworldRiverFish(fromRL("crittersandcompanions", "koi_fish"))
                .withBucketedFish(fromRL("crittersandcompanions", "koi_fish_bucket"))
                .withEntityToSpawn(rl("crittersandcompanions", "koi_fish"))
                .withSizeAndWeight(FishProperties.sw(60, 20, 3000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_RIVER)
        );

        register(overworldDeepOceanFish(fromRL("crittersandcompanions", "dumbo_octopus_bucket"))
                .withAlwaysSpawnEntity(true)
                .withBucketedFish(fromRL("crittersandcompanions", "dumbo_octopus_bucket"))
                .withEntityToSpawn(rl("crittersandcompanions", "dumbo_octopus"))
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 300, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_RIVER)
        );

        register(overworldDeepOceanFish(fromRL("crittersandcompanions", "sea_bunny_bucket"))
                .withAlwaysSpawnEntity(true)
                .withBucketedFish(fromRL("crittersandcompanions", "sea_bunny_bucket"))
                .withEntityToSpawn(rl("crittersandcompanions", "sea_bunny"))
                .withSizeAndWeight(FishProperties.sw(40, 10, 200, 60, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withRarity(FishProperties.Rarity.RARE)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_RIVER)
        );

    }
}
