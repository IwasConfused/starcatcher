package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.storage.FishProperties;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;

public class CollectorsReapFishingProperties {
    public static void bootstrap() {
        //region Collectors Reap
        //
        // ,-----.         ,--. ,--.                  ,--.                   ,--.             ,------.
        //'  .--./  ,---.  |  | |  |  ,---.   ,---. ,-'  '-.  ,---.  ,--.--. |  |  ,---.      |  .--. '  ,---.   ,--,--.  ,---.
        //|  |     | .-. | |  | |  | | .-. : | .--' '-.  .-' | .-. | |  .--' `-'  (  .-'      |  '--'.' | .-. : ' ,-.  | | .-. |
        //'  '--'\ ' '-' ' |  | |  | \   --. \ `--.   |  |   ' '-' ' |  |         .-'  `)     |  |\  \  \   --. \ '-'  | | '-' '
        // `-----'  `---'  `--' `--'  `----'  `---'   `--'    `---'  `--'         `----'      `--' '--'  `----'  `--`--' |  |-'
        //                                                                                                               `--'
        register(fish(fromRL("collectorsreap", "platinum_bass"))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.MID_AUTUMN, FishProperties.WorldRestrictions.Seasons.LATE_AUTUMN, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(40, 12, 1600, 1100, 10, 20))
                .withBaseChance(10)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/platinum_bass")))
        );


        register(fish(fromRL("collectorsreap", "tiger_prawn"))
                .withSizeAndWeight(FishProperties.sw(28, 8, 260, 60, 10, 20))
                .withBaseChance(10)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.COMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/tiger_prawn")))
        );

        register(fish(fromRL("collectorsreap", "clam"))  //no mini game
                .withBaseChance(5)
                .withHasGuideEntry(false)
                .withSkipMinigame(true)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/clam")))
        );

        register(fish(fromRL("collectorsreap", "urchin"))  //no mini game
                .withBaseChance(5)
                .withHasGuideEntry(false)
                .withSkipMinigame(true)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/urchin")))
        );


        register(fish(fromRL("collectorsreap", "chieftain_crab"))
                .withSizeAndWeight(FishProperties.sw(28, 8, 260, 60, 10, 20))
                .withBaseChance(5)
                .withHasGuideEntry(false)
                .withDifficulty(FishProperties.Difficulty.REALLY_HEAVY_FISH)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/chieftain_crab")))
                .withAlwaysSpawnEntity(true)
                .withEntityToSpawn(rl("collectorsreap", "chieftain_crab"))
                .withOverrideMinigameItem(true)
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
        );


        //when you can do live catches add the chieftain crab
        //endregion Collectors Reap
    }
}
