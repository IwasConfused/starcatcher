package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class AlexsCavesFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap() {

        //region Alex's Caves
        //
        //  ,---.   ,--.                    ,--.              ,-----.
        // /  O  \  |  |  ,---.  ,--.  ,--. |  |  ,---.      '  .--./  ,--,--. ,--.  ,--.  ,---.   ,---.
        //|  .-.  | |  | | .-. :  \  `'  /  `-'  (  .-'      |  |     ' ,-.  |  \  `'  /  | .-. : (  .-'
        //|  | |  | |  | \   --.  /  /.  \       .-'  `)     '  '--'\ \ '-'  |   \    /   \   --. .-'  `)
        //`--' `--' `--'  `----' '--'  '--'      `----'       `-----'  `--`--'    `--'     `----' `----'
        //
        register(fish(fromRL("alexscaves", "radgill"))
                .withBucketedFish(fromRL("alexscaves", "radgill_bucket"))
                .withEntityToSpawn(rl("alexscaves", "radgill"))
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 10))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withFluids(rl("alexscaves", "acid"))
                        .withBiomes(rl("alexscaves", "toxic_caves")))
                .withDifficulty(new FishProperties.Difficulty(12, 25, 35, 25, 5,
                        new FishProperties.Difficulty.Markers(true, true, true, false),
                        FishProperties.Treasure.DEFAULT,
                        new FishProperties.Difficulty.Extras(false, true, true)))
        );

        register(fish(fromRL("alexscaves", "sweetish_fish_blue"))
                .withBucketedFish(fromRL("alexscaves", "sweetish_fish_blue_bucket"))
                .withEntityToSpawn(rl("alexscaves", "sweetish_fish"))
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 10))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withFluids(rl("alexscaves", "purple_soda"))
                        .withBiomes(rl("alexscaves", "candy_cavity")))
                .withDifficulty(new FishProperties.Difficulty(12, 15, 35, 25, 2,
                        new FishProperties.Difficulty.Markers(true, true, true, false),
                        new FishProperties.Treasure(true, rl("alexscaves", "radiant_essence"), 13),
                        new FishProperties.Difficulty.Extras(true, false, true)))
        );

        register(fish(fromRL("alexscaves", "sweetish_fish_green"))
                .withBucketedFish(fromRL("alexscaves", "sweetish_fish_blue_bucket"))
                .withEntityToSpawn(rl("alexscaves", "sweetish_fish"))
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 10))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withFluids(rl("alexscaves", "purple_soda"))
                        .withBiomes(rl("alexscaves", "candy_cavity")))
                .withDifficulty(new FishProperties.Difficulty(12, 15, 35, 25, 2,
                        new FishProperties.Difficulty.Markers(true, true, true, false),
                        new FishProperties.Treasure(true, rl("alexscaves", "radiant_essence"), 13),
                        new FishProperties.Difficulty.Extras(true, false, true)))
        );

        register(fish(fromRL("alexscaves", "sweetish_fish_pink"))
                .withBucketedFish(fromRL("alexscaves", "sweetish_fish_pink_bucket"))
                .withEntityToSpawn(rl("alexscaves", "sweetish_fish"))
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 10))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withFluids(rl("alexscaves", "purple_soda"))
                        .withBiomes(rl("alexscaves", "candy_cavity")))
                .withDifficulty(new FishProperties.Difficulty(12, 15, 35, 25, 2,
                        new FishProperties.Difficulty.Markers(true, true, true, false),
                        new FishProperties.Treasure(true, rl("alexscaves", "radiant_essence"), 13),
                        new FishProperties.Difficulty.Extras(true, false, true)))
        );

        register(fish(fromRL("alexscaves", "sweetish_fish_red"))
                .withBucketedFish(fromRL("alexscaves", "sweetish_fish_red_bucket"))
                .withEntityToSpawn(rl("alexscaves", "sweetish_fish"))
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 10))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withFluids(rl("alexscaves", "purple_soda"))
                        .withBiomes(rl("alexscaves", "candy_cavity")))
                .withDifficulty(new FishProperties.Difficulty(12, 15, 35, 25, 2,
                        new FishProperties.Difficulty.Markers(true, true, true, false),
                        new FishProperties.Treasure(true, rl("alexscaves", "radiant_essence"), 13),
                        new FishProperties.Difficulty.Extras(true, false, true)))
        );

        register(fish(fromRL("alexscaves", "sweetish_fish_yellow"))
                .withBucketedFish(fromRL("alexscaves", "sweetish_fish_yellow_bucket"))
                .withEntityToSpawn(rl("alexscaves", "sweetish_fish"))
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 10))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withFluids(rl("alexscaves", "purple_soda"))
                        .withBiomes(rl("alexscaves", "candy_cavity")))
                .withDifficulty(new FishProperties.Difficulty(12, 15, 35, 25, 2,
                        new FishProperties.Difficulty.Markers(true, true, true, false),
                        new FishProperties.Treasure(true, rl("alexscaves", "radiant_essence"), 13),
                        new FishProperties.Difficulty.Extras(true, false, true)))
        );


        register(fish(fromRL("alexscaves", "lanternfish"))
                .withBucketedFish(fromRL("alexscaves", "lanternfish_bucket"))
                .withEntityToSpawn(rl("alexscaves", "lanternfish"))
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomes(rl("alexscaves", "abyssal_chasm")))
                .withDifficulty(new FishProperties.Difficulty(12, 15, 35, 25, 2,
                        new FishProperties.Difficulty.Markers(true, true, true, true),
                        FishProperties.Treasure.DEFAULT,
                        new FishProperties.Difficulty.Extras(false, false, true)))
        );

        FishProperties.Difficulty customDifficulty = new FishProperties.Difficulty(12, 15, 30, 25, 7,
                new FishProperties.Difficulty.Markers(true, true, true, false),
                FishProperties.Treasure.DEFAULT,
                new FishProperties.Difficulty.Extras(false, false, true)
        );

        register(fish(fromRL("alexscaves", "tripodfish"))
                .withBucketedFish(fromRL("alexscaves", "tripodfish_bucket"))
                .withEntityToSpawn(rl("alexscaves", "tripodfish"))
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 5000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomes(rl("alexscaves", "abyssal_chasm")))
                .withDifficulty(customDifficulty)
        );


        register(fish(fromRL("alexscaves", "trilocaris_tail"))
                .withBucketedFish(fromRL("alexscaves", "trilocaris_bucket"))
                .withEntityToSpawn(rl("alexscaves", "trilocaris"))
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 5000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD
                        .withBiomes(rl("alexscaves", "primordial_caves")))
                .withDifficulty(customDifficulty)
                .withAlwaysSpawnEntity(true)
                .withEntityToSpawn(rl("alexscaves", "trilocaris"))
                .withItemToOverrideWith(ModItems.UNKNOWN_FISH)
        );

        //endregion Alex's Caves
    }
}
