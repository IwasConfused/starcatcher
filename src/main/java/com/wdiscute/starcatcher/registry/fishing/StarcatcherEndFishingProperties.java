package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.storage.FishProperties;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;

public class StarcatcherEndFishingProperties {
    public static void bootstrap() {
        register(endFish(ModItems.CHARFISH)
                .withSizeAndWeight(FishProperties.sw(135, 25, 4000, 700, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD));

        register(endFish(ModItems.CHORUS_CRAB)
                .withSizeAndWeight(FishProperties.sw(15, 8, 700, 300, 10, 70))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_FLIP_MOVING));

        register(endFish(ModItems.END_GLOW)
                .withSizeAndWeight(FishProperties.sw(235, 25, 7000, 700, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MOVING_THIN_NO_DECAY));

        register(endOuterIslandsFish(ModItems.VOIDBITER)
                .withSizeAndWeight(FishProperties.sw(50, 15, 2000, 200, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.VOIDBITER)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT_VOIDBITER));

    }
}
