package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class AquamiraeFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {
        //
        //                                              ,--.
        // ,--,--.  ,---.  ,--.,--.  ,--,--. ,--,--,--. `--' ,--.--.  ,--,--.  ,---.
        //' ,-.  | | .-. | |  ||  | ' ,-.  | |        | ,--. |  .--' ' ,-.  | | .-. :
        //\ '-'  | ' '-' | '  ''  ' \ '-'  | |  |  |  | |  | |  |    \ '-'  | \   --.
        // `--`--'  `-|  |  `----'   `--`--' `--`--`--' `--' `--'     `--`--'  `----'
        //            `--'

        register(fish(fromRL("aquamirae", "spinefish"))
                .withBucketedFish(fromRL("aquamirae", "spinefish_bucket"))
                .withEntityToSpawn(rl("aquamirae", "spinefish"))
                .withSizeAndWeight(FishProperties.sw(30, 10, 500, 300, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("aquamirae", "ice_maze")))
        );
    }
}
