package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class NetherDepthsUpgradeFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {

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
                .withBucketedFish(fromRL("netherdepthsupgrade", "bonefish_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "bonefish"))
                .withSizeAndWeight(FishProperties.sw(120, 40, 700, 200))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING)
        );

        //TODO ADD STRUCTURE RESTRICTION
        register(netherLavaFish(fromRL("netherdepthsupgrade", "blazefish"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "blazefish_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "blazefish"))
                .withSizeAndWeight(FishProperties.sw(160, 29, 5200, 1200))
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
        );

        register(netherLavaCrimsonForestFish(fromRL("netherdepthsupgrade", "eyeball_fish"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "eyeball_fish_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "eyeball_fish"))
                .withSizeAndWeight(FishProperties.sw(70, 40, 700, 200))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
        );

        register(netherLavaFish(fromRL("netherdepthsupgrade", "glowdine"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "glowdine_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "glowdine"))
                .withSizeAndWeight(FishProperties.sw(130, 30, 3400, 900, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING_MOVING)
        );

        register(netherLavaWarpedForestFish(fromRL("netherdepthsupgrade", "lava_pufferfish"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "lava_pufferfish_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "lava_pufferfish"))
                .withSizeAndWeight(FishProperties.sw(90, 30, 3700, 900, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING)
        );

        register(netherLavaBasaltDeltasFish(fromRL("netherdepthsupgrade", "magmacubefish"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "magmacubefish_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "magmacubefish"))
                .withSizeAndWeight(FishProperties.sw(120, 40, 3000, 400, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
        );

        register(netherLavaBasaltDeltasFish(fromRL("netherdepthsupgrade", "obsidianfish"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "obsidianfish_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "obsidianfish"))
                .withSizeAndWeight(FishProperties.sw(200, 50, 500000, 68000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.REALLY_HEAVY_FISH)
        );

        register(netherLavaFish(fromRL("netherdepthsupgrade", "searing_cod"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "searing_cod_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "searing_cod"))
                .withSizeAndWeight(FishProperties.sw(500, 50, 80000, 20000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.EASY_FAST_FISH)
        );

        register(netherLavaSoulSandValleyFish(fromRL("netherdepthsupgrade", "soulsucker"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "soulsucker_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "soulsucker"))
                .withSizeAndWeight(FishProperties.sw(140, 30, 12000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_FAST_FISH_VANISHING)
        );

        register(netherLavaSoulSandValleyFish(fromRL("netherdepthsupgrade", "wither_bonefish"))
                .withBucketedFish(fromRL("netherdepthsupgrade", "wither_bonefish_bucket"))
                .withEntityToSpawn(rl("netherdepthsupgrade", "wither_bonefish"))
                .withSizeAndWeight(FishProperties.sw(400, 100, 32000, 7000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING)
        );
    }
}
