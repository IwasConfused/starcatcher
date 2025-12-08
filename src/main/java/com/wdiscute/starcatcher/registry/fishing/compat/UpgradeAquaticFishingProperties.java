package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class UpgradeAquaticFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {
        //
        //,--. ,--.                                     ,--.               ,---.                               ,--.   ,--.
        //|  | |  |  ,---.   ,---.  ,--.--.  ,--,--.  ,-|  |  ,---.       /  O  \   ,---.  ,--.,--.  ,--,--. ,-'  '-. `--'  ,---.
        //|  | |  | | .-. | | .-. | |  .--' ' ,-.  | ' .-. | | .-. :     |  .-.  | | .-. | |  ||  | ' ,-.  | '-.  .-' ,--. | .--'
        //'  '-'  ' | '-' ' ' '-' ' |  |    \ '-'  | \ `-' | \   --.     |  | |  | ' '-' | '  ''  ' \ '-'  |   |  |   |  | \ `--.
        // `-----'  |  |-'  .`-  /  `--'     `--`--'  `---'   `----'     `--' `--'  `-|  |  `----'   `--`--'   `--'   `--'  `---'
        //          `--'    `---'                                                     `--'

        register(fish(fromRL("upgrade_aquatic", "pike"))
                .withBucketedFish(fromRL("upgrade_aquatic", "pike_bucket"))
                .withEntityToSpawn(rl("upgrade_aquatic", "pike"))
                .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/pike")))
        );

        register(fish(fromRL("upgrade_aquatic", "perch"))
                .withBucketedFish(fromRL("upgrade_aquatic", "perch_bucket"))
                .withEntityToSpawn(rl("upgrade_aquatic", "perch"))
                .withSizeAndWeight(FishProperties.sw(27.0f, 11, 500, 352, 5, 36))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/perch")))
        );

        register(fish(fromRL("upgrade_aquatic", "lionfish"))
                .withBucketedFish(fromRL("upgrade_aquatic", "lionfish_bucket"))
                .withEntityToSpawn(rl("upgrade_aquatic", "lionfish"))
                .withSizeAndWeight(FishProperties.sw(27.0f, 11, 500, 352, 5, 36))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/lionfish")))
        );

        register(fish(fromRL("upgrade_aquatic", "thrasher_tooth"))
                .withBaseChance(0)
                .withEntityToSpawn(rl("upgrade_aquatic", "great_thrasher"))
                .withBaitRestrictions(FishProperties.BaitRestrictions.DEFAULT
                        .withCorrectBait(ModItems.ALMIGHTY_WORM.getId())
                        .withCorrectBaitChanceAdded(5))
                .withSizeAndWeight(FishProperties.sw(28, 8, 260, 60))
                .withDifficulty(FishProperties.Difficulty.REALLY_HEAVY_FISH)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/thrasher")))
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
        );
    }
}
