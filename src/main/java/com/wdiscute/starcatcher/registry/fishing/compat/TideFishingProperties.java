package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.FishProperties.WorldRestrictions.Seasons;
import net.minecraft.tags.BiomeTags;

public class TideFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {
        //
        //  ,--.   ,--.    ,--.
        //,-'  '-. `--'  ,-|  |  ,---.
        //'-.  .-' ,--. ' .-. | | .-. :
        //  |  |   |  | \ `-' | \   --.
        //  `--'   `--'  `---'   `----'
        //

        register(overworldColdLakeFish(fromRL("tide", "trout"))
                .withBucketedFish(fromRL("tide", "trout_bucket"))
                .withEntityToSpawn(rl("tide", "trout"))
                .withSeasons(Seasons.SPRING, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(50, 20, 2000, 1600, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withDaytime(FishProperties.Daytime.DAY)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldLakeFish(fromRL("tide", "bass"))
                .withBucketedFish(fromRL("tide", "bass_bucket"))
                .withEntityToSpawn(rl("tide", "bass"))
                .withSeasons(Seasons.SPRING, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(50, 20, 2000, 1600, 10, 20))
                .withWeather(FishProperties.Weather.CLEAR)
        );

        register(overworldLakeFish(fromRL("tide", "yellow_perch"))
                .withBucketedFish(fromRL("tide", "yellow_perch_bucket"))
                .withEntityToSpawn(rl("tide", "yellow_perch"))
                .withSeasons(Seasons.SPRING, Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(25, 10, 200, 20, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                .withWeather(FishProperties.Weather.RAIN)
        );

        register(overworldMountainFish(fromRL("tide", "bluegill"))
                .withBucketedFish(fromRL("tide", "bluegill_bucket"))
                .withEntityToSpawn(rl("tide", "bluegill"))
                .withSeasons(Seasons.SPRING, Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 20, 10, 20))
        );

        register(overworldWarmMountainFish(fromRL("tide", "mint_carp"))
                .withBucketedFish(fromRL("tide", "mint_carp_bucket"))
                .withEntityToSpawn(rl("tide", "mint_carp"))
                .withSeasons(Seasons.SUMMER, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(80, 40, 10000, 5000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                .withWeather(FishProperties.Weather.RAIN)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldColdRiverFish(fromRL("tide", "pike"))
                .withBucketedFish(fromRL("tide", "pike_bucket"))
                .withEntityToSpawn(rl("tide", "pike"))
                .withSeasons(Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 5000, 10, 20))
        );

        register(overworldWarmLakeFish(fromRL("tide", "guppy"))
                .withBucketedFish(fromRL("tide", "guppy_bucket"))
                .withEntityToSpawn(rl("tide", "guppy"))
                .withSizeAndWeight(FishProperties.sw(4, 1, 2, 1, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withDaytime(FishProperties.Daytime.NIGHT)
        );

        register(overworldColdLakeFish(fromRL("tide", "catfish"))
                .withBucketedFish(fromRL("tide", "catfish_bucket"))
                .withEntityToSpawn(rl("tide", "catfish"))
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 5000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldColdLakeFish(fromRL("tide", "clayfish"))
                .withBucketedFish(fromRL("tide", "clayfish_bucket"))
                .withEntityToSpawn(rl("tide", "clayfish"))
                .withSizeAndWeight(FishProperties.sw(15, 5, 200, 100, 10, 20))
                .withWeather(FishProperties.Weather.RAIN)
        );

        //tide saltwater
        register(overworldOceanFish(fromRL("tide", "tuna"))
                .withBucketedFish(fromRL("tide", "tuna_bucket"))
                .withEntityToSpawn(rl("tide", "tuna"))
                .withSeasons(Seasons.AUTUMN, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(200, 100, 200000, 150000, 10, 20))
        );

        register(overworldColdOceanFish(fromRL("tide", "ocean_perch"))
                .withBucketedFish(fromRL("tide", "ocean_perch_bucket"))
                .withEntityToSpawn(rl("tide", "ocean_perch"))
                .withSeasons(Seasons.AUTUMN, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(50, 20, 2000, 1600, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldOceanFish(fromRL("tide", "mackerel"))
                .withBucketedFish(fromRL("tide", "mackerel_bucket"))
                .withEntityToSpawn(rl("tide", "mackerel"))
                .withSeasons(Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(35, 15, 500, 400, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldWarmOceanFish(fromRL("tide", "angelfish"))
                .withBucketedFish(fromRL("tide", "angelfish_bucket"))
                .withEntityToSpawn(rl("tide", "angelfish"))
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(15, 5, 100, 5, 10, 20))
                .withWeather(FishProperties.Weather.RAIN)
        );

        register(overworldOceanFish(fromRL("tide", "barracuda"))
                .withBucketedFish(fromRL("tide", "barracuda_bucket"))
                .withEntityToSpawn(rl("tide", "barracuda"))
                .withSizeAndWeight(FishProperties.sw(150, 50, 30000, 20000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withWeather(FishProperties.Weather.RAIN)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING)
        );

        register(overworldWarmOceanFish(fromRL("tide", "sailfish"))
                .withBucketedFish(fromRL("tide", "sailfish_bucket"))
                .withEntityToSpawn(rl("tide", "sailfish"))
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(250, 50, 100000, 50000, 10, 20))
                .withWeather(FishProperties.Weather.RAIN)
        );

        //tide underground
        register(overworldCavesFish(fromRL("tide", "cave_eel"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(15, 5, 5, 3, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
        );

        register(overworldCavesFish(fromRL("tide", "crystal_shrimp"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(10, 5, 2, 1, 10, 20))
        );

        register(overworldCavesFish(fromRL("tide", "iron_tetra"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(4, 1, 2, 1, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
        );

        register(overworldCavesFish(fromRL("tide", "glowfish"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(20, 10, 10, 5, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldCavesFish(fromRL("tide", "anglerfish"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 20000, 15000, 10, 20))
        );

        register(overworldCavesFish(fromRL("tide", "cave_crawler"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 500, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
        );

        register(overworldCavesFish(fromRL("tide", "gilded_minnow"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(5, 2, 10, 6, 10, 20))
        );

        //tide deepslate
        register(overworldDeepslateFish(fromRL("tide", "deep_grouper"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(200, 50, 200000, 100000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
        );

        register(overworldDeepslateFish(fromRL("tide", "shadow_snapper"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(80, 40, 10000, 5000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldDeepslateFish(fromRL("tide", "abyss_angler"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 20000, 15000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                .withBaseChance(2)
        );

        register(overworldDeepslateFish(fromRL("tide", "lapis_lanternfish"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(20, 10, 100, 5, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldDeepslateFish(fromRL("tide", "luminescent_jellyfish"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(50, 30, 5000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
        );

        register(overworldDeepslateFish(fromRL("tide", "crystalline_carp"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(80, 30, 10000, 5000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN)
                .withRarity(FishProperties.Rarity.RARE)
        );

        register(overworldDeepslateFish(fromRL("tide", "bedrock_tetra"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(4, 1, 2, 1, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN)
        );

        //tide biome specific
        register(fish(fromRL("tide", "prarie_pike"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withWorldRestrictions(FishProperties.WorldRestrictions.DEFAULT.withBiomes(rl("minecraft", "plains")))
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(fish(fromRL("tide", "sandskipper"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 500, 10, 20))
                .withWorldRestrictions(FishProperties.WorldRestrictions.DEFAULT.withBiomes(rl("minecraft", "desert")))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST)
        );

        register(overworldCherryGroveFish(fromRL("tide", "blossom_bass"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(50, 20, 5000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(overworldFish(fromRL("tide", "oakfish"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.SPRING, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(40, 20, 3000, 2000, 10, 20))
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD.withBiomesTags(BiomeTags.IS_FOREST.location()))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldColdLakeFish(fromRL("tide", "frostbite_flounder"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.AUTUMN, Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(60, 30, 6000, 4000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
        );

        register(overworldFish(fromRL("tide", "mirage_catfish"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_FLIP)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD.withBiomesTags(BiomeTags.IS_BADLANDS.location()))
        );

        register(overworldDeepDarkFish(fromRL("tide", "echofin_snapper"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(80, 30, 10000, 5000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
        );

        register(overworldFish(fromRL("tide", "sunspike_goby"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(15, 5, 100, 5, 10, 20))
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD.withBiomesTags(BiomeTags.IS_BADLANDS.location()))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(overworldFish(fromRL("tide", "birch_trout"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(50, 20, 2000, 1700, 10, 20))
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD.withBiomesTags(StarcatcherTags.IS_BIRCH_FOREST))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldMountainFish(fromRL("tide", "stonefish"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(40, 20, 2000, 1700, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldDripstoneCavesFish(fromRL("tide", "dripstone_darter"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(5, 2, 5, 1, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(overworldSwampFish(fromRL("tide", "slimefin_snapper"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(80, 40, 10000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST)
        );

        register(overworldMushroomFieldsFish(fromRL("tide", "sporestalker"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(50, 20, 5000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.THIN_NO_DECAY)
        );

        register(overworldJungleFish(fromRL("tide", "leafback"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.SPRING, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(40, 20, 3000, 2000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING)
        );

        register(overworldLushCavesFish(fromRL("tide", "fluttergill"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 500, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(overworldTaigaFish(fromRL("tide", "pine_perch"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.SPRING, Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(25, 10, 500, 300, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        //missing structure restriction support to add windbass and aquathorn from tide mod

        //tide overworld lava
        register(overworldSurfaceLava(fromRL("tide", "ember_koi"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(40, 20, 3000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING)
                .withRarity(FishProperties.Rarity.EPIC)
        );

        register(overworldSurfaceLava(fromRL("tide", "inferno_guppy"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(4, 1, 20, 2, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                .withRarity(FishProperties.Rarity.RARE)
        );

        register(overworldSurfaceLava(fromRL("tide", "obsidian_pike"))
                //no bucketed version
                //no entity version
                .withSeasons(Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(100, 5, 15000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(overworldSurfaceLava(fromRL("tide", "volcano_tuna"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(200, 100, 150000, 50000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
        );

        //tide nether
        register(netherLavaFish(fromRL("tide", "magma_mackerel"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(35, 15, 500, 300, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(netherLavaBasaltDeltasFish(fromRL("tide", "ashen_perch"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(25, 10, 200, 100, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(netherLavaSoulSandValleyFish(fromRL("tide", "soulscaler"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(80, 30, 10000, 5000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING_MOVING)
        );

        register(netherLavaWarpedForestFish(fromRL("tide", "warped_guppy"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(4, 1, 4, 1, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN)
        );

        register(netherLavaCrimsonForestFish(fromRL("tide", "crimson_fangjaw"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON)
        );

        register(netherLavaSoulSandValleyFish(fromRL("tide", "witherfin"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN)
        );

        register(netherLavaFish(fromRL("tide", "blazing_swordfish"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(200, 100, 100000, 50000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING)
        );

        //tide end
        register(endFish(fromRL("tide", "endstone_perch"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(25, 10, 500, 300, 10, 20)).withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING_NO_FLIP)
        );

        register(endFish(fromRL("tide", "enderfin"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(50, 20, 5000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
        );

        register(endFish(fromRL("tide", "endergazer"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(60, 30, 6000, 4000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                .withRarity(FishProperties.Rarity.EPIC)
        );

        register(endOuterIslandsFish(fromRL("tide", "purpur_pike"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
        );

        register(endOuterIslandsFish(fromRL("tide", "chorus_cod"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_FAST_FISH_VANISHING)
                .withRarity(FishProperties.Rarity.EPIC)
        );

        register(endFish(fromRL("tide", "elytrout"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(50, 20, 5000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD)
        );

        register(endFish(fromRL("tide", "voidseeker"))
                //no bucketed version
                //no entity version
                .withSizeAndWeight(FishProperties.sw(100, 50, 15000, 10000, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withDifficulty(FishProperties.Difficulty.THIN_NO_DECAY_NOT_FORGIVING)
        );


        //TODO put into corresponding category
        register(overworldLakeFish(fromRL("tide", "midas_fish"))
                //no bucketed version
                .withEntityToSpawn(rl("tide", "midas_fish"))
                .withSizeAndWeight(FishProperties.sw(800, 50, 310000, 120000, 10, 20))
                .withWeather(FishProperties.Weather.THUNDER)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_FLIP_MOVING)
        );

        register(overworldOceanFish(fromRL("tide", "shooting_starfish"))
                .withBucketedFish(fromRL("tide", "shooting_starfish_bucket"))
                .withEntityToSpawn(rl("tide", "shooting_starfish"))
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 500, 10, 20))
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withDaytime(FishProperties.Daytime.MIDNIGHT)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN)
        );
    }
}
