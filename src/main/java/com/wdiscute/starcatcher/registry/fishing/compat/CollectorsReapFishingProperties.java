package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.FishProperties.WorldRestrictions.Seasons;

public class CollectorsReapFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {
        //
        // ,-----.         ,--. ,--.                  ,--.                   ,--.             ,------.
        //'  .--./  ,---.  |  | |  |  ,---.   ,---. ,-'  '-.  ,---.  ,--.--. |  |  ,---.      |  .--. '  ,---.   ,--,--.  ,---.
        //|  |     | .-. | |  | |  | | .-. : | .--' '-.  .-' | .-. | |  .--' `-'  (  .-'      |  '--'.' | .-. : ' ,-.  | | .-. |
        //'  '--'\ ' '-' ' |  | |  | \   --. \ `--.   |  |   ' '-' ' |  |         .-'  `)     |  |\  \  \   --. \ '-'  | | '-' '
        // `-----'  `---'  `--' `--'  `----'  `---'   `--'    `---'  `--'         `----'      `--' '--'  `----'  `--`--' |  |-'
        //                                                                                                               `--'

        register(fish(fromRL("collectorsreap", "platinum_bass"))
                .withBucketedFish(fromRL("collectorsreap", "platinum_bass_bucket"))
                .withEntityToSpawn(rl("collectorsreap", "platinum_bass"))
                .withSizeAndWeight(FishProperties.sw(40, 12, 1600, 1100))
                .withSeasons(Seasons.MID_AUTUMN, Seasons.LATE_AUTUMN, Seasons.WINTER)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/platinum_bass")))
        );


        register(fish(fromRL("collectorsreap", "tiger_prawn"))
                .withBucketedFish(fromRL("collectorsreap", "tiger_prawn_bucket"))
                .withEntityToSpawn(rl("collectorsreap", "tiger_prawn"))
                .withSizeAndWeight(FishProperties.sw(28, 8, 260, 60))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withRarity(FishProperties.Rarity.RARE)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/tiger_prawn")))
        );

        register(fish(fromRL("collectorsreap", "clam"))  //no mini game
                .withBucketedFish(fromRL("collectorsreap", "clam_bucket"))
                .withEntityToSpawn(rl("collectorsreap", "clam"))
                .withSkipMinigame(true)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/clam")))
        );

        register(fish(fromRL("collectorsreap", "urchin"))  //no mini game
                .withBucketedFish(fromRL("collectorsreap", "urchin_bucket"))
                .withEntityToSpawn(rl("collectorsreap", "urchin"))
                .withHasGuideEntry(false)
                .withSkipMinigame(true)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/urchin")))
        );


        register(fish(fromRL("collectorsreap", "chieftain_crab"))
                .withBucketedFish(fromRL("collectorsreap", "chieftain_crab_bucket"))
                .withEntityToSpawn(rl("collectorsreap", "chieftain_crab"))
                .withSizeAndWeight(FishProperties.sw(28, 8, 260, 60, 10, 20))
                .withDifficulty(FishProperties.Difficulty.REALLY_HEAVY_FISH)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomesTags(rl("collectorsreap", "biome/has_spawn/chieftain_crab")))
                .withAlwaysSpawnEntity(true)
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
        );
    }
}
