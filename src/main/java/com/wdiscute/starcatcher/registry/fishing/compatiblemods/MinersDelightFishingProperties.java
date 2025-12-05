package com.wdiscute.starcatcher.registry.fishing.compatiblemods;

import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class MinersDelightFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {


        //region Miner's Delight

        //
        //,--.   ,--. ,--.                          ,--.             ,------.           ,--. ,--.         ,--.        ,--.
        //|   `.'   | `--' ,--,--,   ,---.  ,--.--. |  |  ,---.      |  .-.  \   ,---.  |  | `--'  ,---.  |  ,---.  ,-'  '-.
        //|  |'.'|  | ,--. |      \ | .-. : |  .--' `-'  (  .-'      |  |  \  : | .-. : |  | ,--. | .-. | |  .-.  | '-.  .-'
        //|  |   |  | |  | |  ||  | \   --. |  |         .-'  `)     |  '--'  / \   --. |  | |  | ' '-' ' |  | |  |   |  |
        //`--'   `--' `--' `--''--'  `----' `--'         `----'      `-------'   `----' `--' `--' .`-  /  `--' `--'   `--'
        //                                                                                        `---'
        register(fish(fromRL("miners_delight", "squid"))
                .withSizeAndWeight(FishProperties.sw(40, 20, 1300, 700, 10, 20))
                .withBaseChance(2) //low to avoid clutter as you are going to see them about the place
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withMustBeCaughtAboveY(50)
                        .withMustBeCaughtBelowY(63)
                        .withBiomesTags(StarcatcherTags.IS_OCEAN, StarcatcherTags.IS_RIVER)
                )
        );

        register(fish(fromRL("miners_delight", "glow_squid"))
                .withSizeAndWeight(FishProperties.sw(40, 20, 1300, 700, 10, 20))
                .withBaseChance(2) //low to avoid clutter as you are going to see them about the place
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withMustBeCaughtBelowY(30))
        );

        //endregion Miner's Delight
    }
}
