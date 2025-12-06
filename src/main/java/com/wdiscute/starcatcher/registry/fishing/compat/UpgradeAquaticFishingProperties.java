package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class UpgradeAquaticFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {

        //region Upgrade Aquatic
        //
        //,--. ,--.                                     ,--.               ,---.                               ,--.   ,--.
        //|  | |  |  ,---.   ,---.  ,--.--.  ,--,--.  ,-|  |  ,---.       /  O  \   ,---.  ,--.,--.  ,--,--. ,-'  '-. `--'  ,---.
        //|  | |  | | .-. | | .-. | |  .--' ' ,-.  | ' .-. | | .-. :     |  .-.  | | .-. | |  ||  | ' ,-.  | '-.  .-' ,--. | .--'
        //'  '-'  ' | '-' ' ' '-' ' |  |    \ '-'  | \ `-' | \   --.     |  | |  | ' '-' | '  ''  ' \ '-'  |   |  |   |  | \ `--.
        // `-----'  |  |-'  .`-  /  `--'     `--`--'  `---'   `----'     `--' `--'  `-|  |  `----'   `--`--'   `--'   `--'  `---'
        //          `--'    `---'                                                     `--'

        register(fish(fromRL("upgrade_aquatic", "pike"))
                .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/pike")))
        );

        register(fish(fromRL("upgrade_aquatic", "perch"))
                .withSizeAndWeight(FishProperties.sw(27.0f, 11, 500, 352, 5, 36))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/perch")))
        );

        register(fish(fromRL("upgrade_aquatic", "lionfish"))
                .withSizeAndWeight(FishProperties.sw(27.0f, 11, 500, 352, 5, 36))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/lionfish")))
        );

        register(fish(fromRL("upgrade_aquatic", "thrasher_tooth"))
                .withSizeAndWeight(FishProperties.sw(28, 8, 260, 60, 10, 20))
                .withHasGuideEntry(false)
                .withDifficulty(FishProperties.Difficulty.REALLY_HEAVY_FISH)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("upgrade_aquatic", "biome/has_spawn/thrasher")))
                .withAlwaysSpawnEntity(true)
                .withBaseChance(1)
                .withEntityToSpawn(rl("upgrade_aquatic", "thrasher"))
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
        );

        //add thrasher as an entity spawn with hide during minigame

        //endregion Upgrade Aquatic
    }
}
