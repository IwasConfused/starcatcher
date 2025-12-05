package com.wdiscute.starcatcher.registry.fishing.compatiblemods;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class CrittersAndCompanionsFishingProperties extends FishingPropertiesRegistry
{


    public static void bootstrap()
    {

        //region Critters and companions
        //
        // ,-----.         ,--.   ,--.     ,--.                                                    ,--.      ,-----.                                              ,--.
        //'  .--./ ,--.--. `--' ,-'  '-. ,-'  '-.  ,---.  ,--.--.  ,---.       ,--,--. ,--,--,   ,-|  |     '  .--./  ,---.  ,--,--,--.  ,---.   ,--,--. ,--,--,  `--'  ,---.  ,--,--,   ,---.
        //|  |     |  .--' ,--. '-.  .-' '-.  .-' | .-. : |  .--' (  .-'      ' ,-.  | |      \ ' .-. |     |  |     | .-. | |        | | .-. | ' ,-.  | |      \ ,--. | .-. | |      \ (  .-'
        //'  '--'\ |  |    |  |   |  |     |  |   \   --. |  |    .-'  `)     \ '-'  | |  ||  | \ `-' |     '  '--'\ ' '-' ' |  |  |  | | '-' ' \ '-'  | |  ||  | |  | ' '-' ' |  ||  | .-'  `)
        // `-----' `--'    `--'   `--'     `--'    `----' `--'    `----'       `--`--' `--''--'  `---'       `-----'  `---'  `--`--`--' |  |-'   `--`--' `--''--' `--'  `---'  `--''--' `----'
        //                                                                                                                              `--'


        register(fish(fromRL("crittersandcompanions", "clam"))  //no mini game
                .withBaseChance(1)
                .withHasGuideEntry(false)
                .withSkipMinigame(true)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_RIVER
                        .withMustBeCaughtAboveY(48))
        );

        register(fish(fromRL("crittersandcompanions", "koi_fish"))
                .withSizeAndWeight(FishProperties.sw(60, 20, 3000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_RIVER
                        .withMustBeCaughtAboveY(55))
        );

        //could add sea bunny and dumbo octopus with entity fishing

        //endregion  Critters and companions
    }
}
