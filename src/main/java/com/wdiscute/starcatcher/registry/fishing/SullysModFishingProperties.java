package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.storage.FishProperties;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;

public class SullysModFishingProperties {
    public static void bootstrap() {

        //region Sullys Mod

        //
        // ,---.            ,--. ,--.           ,--.             ,--.   ,--.            ,--.
        //'   .-'  ,--.,--. |  | |  | ,--. ,--. |  |  ,---.      |   `.'   |  ,---.   ,-|  |
        //`.  `-.  |  ||  | |  | |  |  \  '  /  `-'  (  .-'      |  |'.'|  | | .-. | ' .-. |
        //.-'    | '  ''  ' |  | |  |   \   '        .-'  `)     |  |   |  | ' '-' ' \ `-' |
        //`-----'   `----'  `--' `--' .-'  /         `----'      `--'   `--'  `---'   `---'
        //                            `---'
        register(fish(fromRL("sullysmod", "piranha"))
                .withSizeAndWeight(FishProperties.sw(30, 10, 500, 300, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("sullysmod", "biome/piranha_spawn_in")))
        );

        register(fish(fromRL("sullysmod", "lanternfish"))
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.HARD)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("sullysmod", "biome/lanternfish_spawn_in")))
        );
        //endregion Sullys Mod
    }
}
