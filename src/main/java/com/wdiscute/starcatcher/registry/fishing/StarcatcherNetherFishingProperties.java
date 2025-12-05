package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.storage.FishProperties;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;

public class StarcatcherNetherFishingProperties {
    public static void bootstrap() {
        register(netherLavaFish(ModItems.EMBERGILL)
                .withSizeAndWeight(FishProperties.sw(220, 70, 5700, 900, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN.withTreasure(FishProperties.Treasure.NETHER)));

                register(netherLavaFish(ModItems.LAVA_CRAB)
                        .withSizeAndWeight(FishProperties.sw(15, 8, 700, 300, 10, 20))
                        .withRarity(FishProperties.Rarity.EPIC)
                        .withDifficulty(FishProperties.Difficulty.EVERYTHING_FLIP.withTreasure(FishProperties.Treasure.NETHER)));

                register(netherLavaFish(ModItems.MAGMA_FISH)
                        .withSizeAndWeight(FishProperties.sw(120, 40, 3700, 900, 10, 20))
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDifficulty(FishProperties.Difficulty.HARD.withTreasure(FishProperties.Treasure.NETHER)));

                register(netherLavaFish(ModItems.GLOWSTONE_SEEKER)
                        .withSizeAndWeight(FishProperties.sw(120, 40, 3700, 900, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EVERYTHING_FLIP_MOVING.withTreasure(FishProperties.Treasure.NETHER)));

                register(netherLavaFish(ModItems.CINDER_SQUID)
                        .withSizeAndWeight(FishProperties.sw(40, 20, 1300, 700, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_NO_DECAY.withTreasure(FishProperties.Treasure.NETHER))
                        .withRarity(FishProperties.Rarity.RARE)
                        .withBaseChance(2));

                register(netherLavaFish(ModItems.SCALDING_PIKE)
                        .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING.withTreasure(FishProperties.Treasure.NETHER)));

                register(netherLavaFish(ModItems.GLOWSTONE_PUFFERFISH)
                        .withSizeAndWeight(FishProperties.sw(35, 25, 1000, 700, 10, 20))
                        .withRarity(FishProperties.Rarity.RARE)
                        .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING.withTreasure(FishProperties.Treasure.NETHER)));

                register(netherLavaBasaltDeltasFish(ModItems.WILLISH)
                        .withSizeAndWeight(FishProperties.sw(75, 25, 4000, 700, 10, 20))
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING.withTreasure(FishProperties.Treasure.NETHER)));

                register(netherLavaFish(ModItems.LAVA_CRAB_CLAW).withBaseChance(1)
                        .withSkipMinigame(true)
                        .withHasGuideEntry(false));
    }
}
