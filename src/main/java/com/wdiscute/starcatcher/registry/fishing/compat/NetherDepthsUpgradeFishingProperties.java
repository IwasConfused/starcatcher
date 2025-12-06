package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class NetherDepthsUpgradeFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {

        //region Nether Depths Upgrade

        //
        //,--.  ,--.           ,--.   ,--.                          ,------.                     ,--.   ,--.
        //|  ,'.|  |  ,---.  ,-'  '-. |  ,---.   ,---.  ,--.--.     |  .-.  \   ,---.   ,---.  ,-'  '-. |  ,---.   ,---.
        //|  |' '  | | .-. : '-.  .-' |  .-.  | | .-. : |  .--'     |  |  \  : | .-. : | .-. | '-.  .-' |  .-.  | (  .-'
        //|  | `   | \   --.   |  |   |  | |  | \   --. |  |        |  '--'  / \   --. | '-' '   |  |   |  | |  | .-'  `)
        //`--'  `--'  `----'   `--'   `--' `--'  `----' `--'        `-------'   `----' |  |-'    `--'   `--' `--' `----'
        //                                                                             `--'
        //
        //,--. ,--.                                     ,--.
        //|  | |  |  ,---.   ,---.  ,--.--.  ,--,--.  ,-|  |  ,---.
        //|  | |  | | .-. | | .-. | |  .--' ' ,-.  | ' .-. | | .-. :
        //'  '-'  ' | '-' ' ' '-' ' |  |    \ '-'  | \ `-' | \   --.
        // `-----'  |  |-'  .`-  /  `--'     `--`--'  `---'   `----'
        //          `--'    `---'


        register(netherLavaFish(fromRL("netherdepthsupgrade", "bonefish"))
                .withSizeAndWeight(FishProperties.sw(120, 40, 700, 200, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        //TODO ADD STRUCTURE RESTRICTION
        register(netherLavaFish(fromRL("netherdepthsupgrade", "blazefish"))
                .withSizeAndWeight(FishProperties.sw(560, 129, 5200, 1200, 20, 30))
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaCrimsonForestFish(fromRL("netherdepthsupgrade", "eyeball_fish"))
                .withSizeAndWeight(FishProperties.sw(70, 40, 700, 200, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaFish(fromRL("netherdepthsupgrade", "glowdine"))
                .withSizeAndWeight(FishProperties.sw(130, 30, 3400, 900, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING_MOVING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaWarpedForestFish(fromRL("netherdepthsupgrade", "lava_pufferfish"))
                .withSizeAndWeight(FishProperties.sw(90, 30, 3700, 900, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaBasaltDeltasFish(fromRL("netherdepthsupgrade", "magmacubefish"))
                .withSizeAndWeight(FishProperties.sw(120, 40, 3000, 400, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaBasaltDeltasFish(fromRL("netherdepthsupgrade", "obsidianfish"))
                .withSizeAndWeight(FishProperties.sw(200, 50, 500000, 68000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.REALLY_HEAVY_FISH
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaFish(fromRL("netherdepthsupgrade", "searing_cod"))
                .withSizeAndWeight(FishProperties.sw(500, 50, 80000, 20000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.EASY_FAST_FISH
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaSoulSandValleyFish(fromRL("netherdepthsupgrade", "soulsucker"))
                .withSizeAndWeight(FishProperties.sw(140, 30, 12000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_FAST_FISH_VANISHING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        register(netherLavaSoulSandValleyFish(fromRL("netherdepthsupgrade", "wither_bonefish"))
                .withSizeAndWeight(FishProperties.sw(400, 100, 32000, 7000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING
                        .withTreasure(FishProperties.Treasure.NETHER))
        );

        //endregion Nether Depths Upgrade
    }
}
