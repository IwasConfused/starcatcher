package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class MinersDelightFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {
        //
        //,--.   ,--. ,--.                          ,--.             ,------.           ,--. ,--.         ,--.        ,--.
        //|   `.'   | `--' ,--,--,   ,---.  ,--.--. |  |  ,---.      |  .-.  \   ,---.  |  | `--'  ,---.  |  ,---.  ,-'  '-.
        //|  |'.'|  | ,--. |      \ | .-. : |  .--' `-'  (  .-'      |  |  \  : | .-. : |  | ,--. | .-. | |  .-.  | '-.  .-'
        //|  |   |  | |  | |  ||  | \   --. |  |         .-'  `)     |  '--'  / \   --. |  | |  | ' '-' ' |  | |  |   |  |
        //`--'   `--' `--' `--''--'  `----' `--'         `----'      `-------'   `----' `--' `--' .`-  /  `--' `--'   `--'
        //                                                                                        `---'

        register(overworldSurfaceFish(fromRL("miners_delight", "squid"))
                .withEntityToSpawn(rl("minecraft", "squid"))
                .withSizeAndWeight(FishProperties.sw(40, 20, 1300, 700, 10, 20))
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_SURFACE
                        .withBiomesTags(StarcatcherTags.IS_OCEAN, StarcatcherTags.IS_RIVER)
                )
        );

        register(overworldUndergroundFish(fromRL("miners_delight", "glow_squid"))
                .withEntityToSpawn(rl("minecraft", "glow_squid"))
                .withSizeAndWeight(FishProperties.sw(40, 20, 1300, 700, 10, 20))
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
        );
    }
}
