package com.wdiscute.starcatcher.registry.fishing;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;

import static com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry.*;

public class StarcatcherOverworldFishingProperties {
    public static void bootstrap() {
        register(overworldLakeFish(ModItems.OBIDONTIEE)
                .withSizeAndWeight(FishProperties.sw(17.7f, 5, 1200, 200, 20, 33)));

        register(overworldLakeFish(ModItems.MORGANITE)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(120, 80, 7000, 1000, 10, 20))
                .withWeather(FishProperties.Weather.RAIN)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldLakeFish(ModItems.SILVERVEIL_PERCH)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(27.0f, 11, 500, 352, 5, 36))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_VANISHING));

        register(overworldLakeFish(ModItems.ELDERSCALE)
                .withSizeAndWeight(FishProperties.sw(160.0f, 85, 2300, 652, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.LATE_SPRING, FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withBaseChance(3));

        register(overworldLakeFish(ModItems.DRIFTFIN)
                .withSizeAndWeight(FishProperties.sw(16.0f, 3, 167, 70, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withWeather(FishProperties.Weather.CLEAR));

        register(overworldLakeFish(ModItems.TWILIGHT_KOI)
                .withSizeAndWeight(FishProperties.sw(60, 13, 3500, 731, 20, 10))
                .withDaytime(FishProperties.Daytime.MIDNIGHT)
                .withRarity(FishProperties.Rarity.EPIC)
                .withWeather(FishProperties.Weather.RAIN)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING));

        register(overworldLakeFish(ModItems.THUNDER_BASS)
                .withSizeAndWeight(FishProperties.sw(40, 12, 1200, 800, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withRarity(FishProperties.Rarity.RARE)
                .withWeather(FishProperties.Weather.THUNDER)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING));

        register(overworldLakeFish(ModItems.LIGHTNING_BASS)
                .withSizeAndWeight(FishProperties.sw(40, 12, 1300, 620, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withRarity(FishProperties.Rarity.RARE)
                .withWeather(FishProperties.Weather.THUNDER)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING));

        register(overworldLakeFish(ModItems.BOOT).withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false));


        //cold lake
        register(overworldColdLakeFish(ModItems.FROSTJAW_TROUT)
                .withSizeAndWeight(FishProperties.sw(35, 8, 1600, 1200, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_VANISHING));

        register(overworldColdLakeFish(ModItems.CRYSTALBACK_TROUT)
                .withSizeAndWeight(FishProperties.sw(35, 8, 1600, 1200, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.WINTER)
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldColdLakeFish(ModItems.AURORA)
                .withSizeAndWeight(FishProperties.sw(10, 8, 120, 30, 30, 20))
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withBaseChance(2)
                .withDifficulty(FishProperties.Difficulty.NON_STOP_ACTION_VANISHING));

        register(overworldColdLakeFish(ModItems.WINTERY_PIKE)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.LATE_AUTUMN, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING));


        //lake warm
        register(overworldWarmLakeFish(ModItems.SANDTAIL)
                .withSizeAndWeight(FishProperties.sw(200, 100, 1600, 1200, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER)
                .withDaytime(FishProperties.Daytime.NIGHT));

        register(overworldWarmLakeFish(ModItems.MIRAGE_CARP)
                .withSizeAndWeight(FishProperties.sw(60, 20, 6000, 4000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withDaytime(FishProperties.Daytime.DAY)
                .withWeather(FishProperties.Weather.CLEAR)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldWarmLakeFish(ModItems.SCORCHFISH)
                .withSizeAndWeight(FishProperties.sw(60, 20, 6000, 4000, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withWeather(FishProperties.Weather.CLEAR));

        register(overworldWarmLakeFish(ModItems.CACTIFISH)
                .withSizeAndWeight(FishProperties.sw(100, 50, 10000, 3000, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER)
                .withDaytime(FishProperties.Daytime.DAY));

        register(overworldWarmLakeFish(ModItems.AGAVE_BREAM)
                .withSizeAndWeight(FishProperties.sw(36, 12, 2000, 1000, 10, 10))
                .withRarity(FishProperties.Rarity.RARE)
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withWeather(FishProperties.Weather.CLEAR)
                .withDifficulty(FishProperties.Difficulty.HARD));


        //mountain
        register(overworldMountainFish(ModItems.SUNNY_STURGEON)
                .withSizeAndWeight(FishProperties.sw(400, 200, 100000, 50000, 10, 10))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.SUMMER)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN)
                .withRarity(FishProperties.Rarity.RARE)
                .withDaytime(FishProperties.Daytime.DAY)
                .withBaseChance(2));

        register(overworldMountainFish(ModItems.PEAKDWELLER)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.AUTUMN, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(100, 50, 10000, 5000, 10, 10))
                .withDifficulty(FishProperties.Difficulty.HARD));

        register(overworldMountainFish(ModItems.ROCKGILL)
                .withSizeAndWeight(FishProperties.sw(100, 50, 10000, 5000, 10, 10))
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldMountainFish(ModItems.SUN_SEEKING_CARP)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.LATE_SPRING, FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.EARLY_AUTUMN)
                .withSizeAndWeight(FishProperties.sw(60, 20, 6000, 4000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withBaseChance(2)
                .withDaytime(FishProperties.Daytime.NOON));


        //swamp
        register(overworldSwampFish(ModItems.SLUDGE_CATFISH)
                .withSizeAndWeight(FishProperties.sw(100, 50, 10000, 3000, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldSwampFish(ModItems.LILY_SNAPPER)
                .withSizeAndWeight(FishProperties.sw(60, 20, 7000, 2000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldSwampFish(ModItems.SAGE_CATFISH)
                .withSizeAndWeight(FishProperties.sw(100, 50, 10000, 3000, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.AUTUMN, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_NO_DECAY)
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withWeather(FishProperties.Weather.CLEAR));

        register(overworldSwampFish(ModItems.MOSSY_BOOT).withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false));


        //darkoak forest
        register(overworldDarkForestFish(ModItems.PALE_PINFISH)
                .withSizeAndWeight(FishProperties.sw(15, 5, 150, 100, 10, 20))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.LATE_AUTUMN, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withDaytime(FishProperties.Daytime.MIDNIGHT)
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.EASY_NO_FLIP_VANISHING));

        register(overworldDarkForestFish(ModItems.PINFISH)
                .withSizeAndWeight(FishProperties.sw(15, 5, 150, 100, 10, 20))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldDarkForestFish(ModItems.PALE_CARP)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.LATE_AUTUMN, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(60, 20, 6000, 4000, 10, 20))
                .withDaytime(FishProperties.Daytime.DAY));


        //cherry grove
        register(overworldCherryGroveFish(ModItems.VESANI)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.EARLY_SUMMER)
                .withSizeAndWeight(FishProperties.sw(10, 3, 67, 0, 10, 0))
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withDifficulty(FishProperties.Difficulty.VESANI));

        register(overworldCherryGroveFish(ModItems.BLOSSOMFISH)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(60, 20, 6000, 4000, 10, 20))
                .withWeather(FishProperties.Weather.CLEAR));

        register(overworldCherryGroveFish(ModItems.PETALDRIFT_CARP)
                .withSizeAndWeight(FishProperties.sw(60, 20, 6000, 4000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withWeather(FishProperties.Weather.RAIN)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldCherryGroveFish(ModItems.PINK_KOI)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(60, 20, 3000, 2000, 10, 20))
                .withWeather(FishProperties.Weather.RAIN));

        register(overworldCherryGroveFish(ModItems.ROSE_SIAMESE_FISH)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(30, 10, 1000, 500, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                .withDaytime(FishProperties.Daytime.DAY)
                .withWeather(FishProperties.Weather.RAIN)
                .withRarity(FishProperties.Rarity.EPIC));


        //cold mountain
        register(overworldColdMountainFish(ModItems.CRYSTALBACK_STURGEON)
                .withSizeAndWeight(FishProperties.sw(400, 200, 100000, 50000, 10, 10)));

        register(overworldColdMountainFish(ModItems.ICETOOTH_STURGEON)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(400, 200, 100000, 50000, 10, 10))
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldColdMountainFish(ModItems.BOREAL)
                .withSizeAndWeight(FishProperties.sw(30, 15, 1000, 200, 10, 10))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING_MOVING)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withBaseChance(3));

        register(overworldColdMountainFish(ModItems.CRYSTALBACK_BOREAL)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(30, 15, 6000, 2000, 10, 10))
                .withDifficulty(FishProperties.Difficulty.MEDIUM));


        //river
        register(overworldRiverFish(ModItems.DOWNFALL_BREAM)
                .withSizeAndWeight(FishProperties.sw(36, 12, 2000, 1000, 10, 10))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withWeather(FishProperties.Weather.RAIN)
                .withDifficulty(FishProperties.Difficulty.EASY_VANISHING));

        register(overworldRiverFish(ModItems.DRIFTING_BREAM)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(36, 12, 2000, 1000, 10, 10))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING));

        register(overworldRiverFish(ModItems.WILLOW_BREAM)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN)
                .withSizeAndWeight(FishProperties.sw(36, 12, 2000, 1000, 10, 10))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
                .withRarity(FishProperties.Rarity.EPIC)
                .withBaseChance(2));

        register(overworldRiverFish(ModItems.HOLLOWBELLY_DARTER)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(6, 2, 7, 6, 10, 10))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING));

        register(overworldRiverFish(ModItems.MISTBACK_CHUB)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING)
                .withSizeAndWeight(FishProperties.sw(30, 10, 1400, 600, 10, 10)));

        register(overworldRiverFish(ModItems.SILVERFIN_PIKE)
                .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldRiverFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.SALMON))
                .withSizeAndWeight(FishProperties.sw(80, 40, 10000, 8000, 10, 20)));

        register(overworldRiverFish(ModItems.DRIED_SEAWEED).withBaseChance(1)
                .withSkipMinigame(true)
                .withHasGuideEntry(false));


        //cold river
        register(overworldColdRiverFish(ModItems.FROSTGILL_CHUB)
                .withSizeAndWeight(FishProperties.sw(30, 10, 1400, 600, 10, 10))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.SUMMER, FishProperties.WorldRestrictions.Seasons.AUTUMN));

        register(overworldColdRiverFish(ModItems.CRYSTALBACK_MINNOW)
                .withSizeAndWeight(FishProperties.sw(6, 4, 5, 3, 10, 10))
                .withSeasons(FishProperties.WorldRestrictions.Seasons.WINTER)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withDaytime(FishProperties.Daytime.NIGHT));

        register(overworldColdRiverFish(ModItems.AZURE_CRYSTALBACK_MINNOW)
                .withSizeAndWeight(FishProperties.sw(6, 4, 5, 3, 10, 10))
                .withDaytime(FishProperties.Daytime.MIDNIGHT)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withBaseChance(1)
                .withDifficulty(FishProperties.Difficulty.NON_STOP_ACTION));

        register(overworldColdRiverFish(ModItems.BLUE_CRYSTAL_FIN)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(12, 4, 70, 30, 10, 10))
                .withDaytime(FishProperties.Daytime.DAY)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON));


        //ocean
        register(overworldOceanFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.COD))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withSizeAndWeight(FishProperties.sw(80, 40, 12000, 7000, 10, 20)));

        register(overworldOceanFish(BuiltInRegistries.ITEM.wrapAsHolder(Items.PUFFERFISH))
                .withSizeAndWeight(FishProperties.sw(70, 20, 10000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withBaseChance(4));

        register(overworldOceanFish(ModItems.SEA_BASS)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.EARLY_SPRING, FishProperties.WorldRestrictions.Seasons.MID_AUTUMN, FishProperties.WorldRestrictions.Seasons.LATE_AUTUMN, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(40, 12, 1600, 1100, 10, 20))
                .withBaseChance(15)
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withDaytime(FishProperties.Daytime.DAY));

        register(overworldOceanFish(ModItems.IRONJAW_HERRING)
                .withSizeAndWeight(FishProperties.sw(30, 8, 300, 100, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MOVING_THIN_NO_DECAY)
                .withBaseChance(2)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldOceanFish(ModItems.DEEPJAW_HERRING)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(30, 8, 300, 100, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldOceanFish(ModItems.DUSKTAIL_SNAPPER)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(60, 20, 7000, 2000, 10, 20)));

        register(overworldOceanFish(ModItems.JOEL)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SUMMER)
                .withSizeAndWeight(FishProperties.sw(69, 0, 2000, 600, 10, 0))
                .withDifficulty(FishProperties.Difficulty.EVERYTHING)
                .withBaseChance(1)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY));

        register(overworldOceanFish(ModItems.REDSCALED_TUNA)
                .withSizeAndWeight(FishProperties.sw(150, 50, 120000, 60000, 10, 20))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_NO_DECAY_VANISHING));

        register(overworldOceanFish(ModItems.WATERLOGGED_BOTTLE)
                .withBaseChance(1)
                .withHasGuideEntry(false)
                .withSkipMinigame(true));

        //deep ocean
        register(overworldDeepOceanFish(ModItems.BIGEYE_TUNA)
                .withSeasons(FishProperties.WorldRestrictions.Seasons.SPRING, FishProperties.WorldRestrictions.Seasons.WINTER)
                .withSizeAndWeight(FishProperties.sw(150, 50, 120000, 60000, 10, 20))
                .withDaytime(FishProperties.Daytime.NIGHT)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING));

        //beach
        register(overworldBeachFish(ModItems.CONCH).withBaseChance(15)
                .withHasGuideEntry(false)
                .withSkipMinigame(true));

        register(overworldBeachFish(ModItems.CLAM).withBaseChance(15)
                .withHasGuideEntry(false)
                .withSkipMinigame(true));

        //mushroom islands
        register(overworldMushroomFieldsFish(ModItems.SHROOMFISH)
                .withSizeAndWeight(FishProperties.sw(70, 50, 4000, 2000, 10, 20))
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withDifficulty(FishProperties.Difficulty.THIN_NO_DECAY_NOT_FORGIVING_MOVING));

        register(overworldMushroomFieldsFish(ModItems.SPOREFISH)
                .withSizeAndWeight(FishProperties.sw(70, 50, 4000, 2000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING));


        //underground
        register(overworldUndergroundFish(ModItems.GOLD_FAN)
                .withSizeAndWeight(FishProperties.sw(70, 50, 4000, 2000, 10, 20)));

        register(overworldUndergroundFish(ModItems.GEODE_EEL)
                .withSizeAndWeight(FishProperties.sw(500, 150, 10000, 2000, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withBaseChance(1)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING));

        //caves
        register(overworldCavesFish(ModItems.WHITEVEIL)
                .withSizeAndWeight(FishProperties.sw(100, 30, 3000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING));

        register(overworldCavesFish(ModItems.BLACK_EEL)
                .withSizeAndWeight(FishProperties.sw(500, 150, 6000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldCavesFish(ModItems.STONEFISH)
                .withSizeAndWeight(FishProperties.sw(300, 150, 26000, 7000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING));

        register(overworldCavesFish(ModItems.AMETHYSTBACK)
                .withSizeAndWeight(FishProperties.sw(300, 150, 16000, 7000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST)
                .withRarity(FishProperties.Rarity.EPIC)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD_STONE_CAVES.withMustBeCaughtBelowY(-20)
                        .withMustBeCaughtAboveY(-40)));

        //dripstone caves
        register(overworldDripstoneCavesFish(ModItems.FOSSILIZED_ANGELFISH)
                .withSizeAndWeight(FishProperties.sw(700, 150, 36000, 7000, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.THIN_NO_DECAY));

        register(overworldDripstoneCavesFish(ModItems.DRIPFIN)
                .withSizeAndWeight(FishProperties.sw(300, 150, 16000, 7000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING));

        register(overworldDripstoneCavesFish(ModItems.YELLOWSTONE_FISH)
                .withSizeAndWeight(FishProperties.sw(600, 150, 22000, 7000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM)
                .withRarity(FishProperties.Rarity.UNCOMMON));


        //lush caves
        register(overworldLushCavesFish(ModItems.LUSH_PIKE)
                .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MOVING_THIN_NO_DECAY)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaseChance(2));

        register(overworldLushCavesFish(ModItems.VIVID_MOSS)
                .withSizeAndWeight(FishProperties.sw(120, 70, 7000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withBaseChance(4));

        register(overworldLushCavesFish(ModItems.THE_QUARRISH)
                .withSizeAndWeight(FishProperties.sw(620, 270, 700000, 300000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.FAT_CATCH)
                .withRarity(FishProperties.Rarity.EPIC)
                .withWorldRestrictions(FishProperties.WorldRestrictions.OVERWORLD.withBiomes(Biomes.LUSH_CAVES.location())
                        .withBiomesTags(BiomeTags.IS_JUNGLE.location())));


        //deepslate
        register(overworldDeepslateFish(ModItems.GHOSTLY_PIKE)
                .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withBaseChance(2));

        register(overworldDeepslateFish(ModItems.DEEPSLATEFISH)
                .withSizeAndWeight(FishProperties.sw(420, 70, 70000, 20000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD));

        register(overworldDeepslateFish(ModItems.AQUAMARINE_PIKE)
                .withSizeAndWeight(FishProperties.sw(75, 20, 5000, 3000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldDeepslateFish(ModItems.GARNET_MACKEREL)
                .withSizeAndWeight(FishProperties.sw(40, 20, 2000, 1500, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldDeepslateFish(ModItems.BRIGHT_AMETHYST_SNAPPER)
                .withSizeAndWeight(FishProperties.sw(60, 20, 7000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN)
                .withRarity(FishProperties.Rarity.EPIC)
                .withBaseChance(2));

        register(overworldDeepslateFish(ModItems.DARK_AMETHYST_SNAPPER)
                .withSizeAndWeight(FishProperties.sw(60, 20, 7000, 2000, 10, 20))
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_NO_DECAY)
                .withRarity(FishProperties.Rarity.EPIC)
                .withBaseChance(2));


        //deep dark
        register(overworldDeepDarkFish(ModItems.SCULKFISH)
                .withSizeAndWeight(FishProperties.sw(30, 10, 2000, 600, 10, 20))
                .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        register(overworldDeepDarkFish(ModItems.WARD)
                .withSizeAndWeight(FishProperties.sw(50, 10, 2600, 600, 10, 20))
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_NO_DECAY_VANISHING)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY)
                .withBaseChance(2));

        register(overworldDeepDarkFish(ModItems.GLOWING_DARK)
                .withSizeAndWeight(FishProperties.sw(100, 10, 3000, 600, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_MOVING));


        //overworld surface lava
        register(overworldSurfaceLava(ModItems.SUNEATER)
                .withSizeAndWeight(FishProperties.sw(100, 10, 3000, 600, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.SINGLE_BIG_FAST_MOVING));

        register(overworldSurfaceLava(ModItems.PYROTROUT)
                .withSizeAndWeight(FishProperties.sw(40, 20, 1200, 700, 10, 20))
                .withRarity(FishProperties.Rarity.UNCOMMON)
                .withDifficulty(FishProperties.Difficulty.MEDIUM));

        register(overworldSurfaceLava(ModItems.OBSIDIAN_EEL)
                .withSizeAndWeight(FishProperties.sw(500, 150, 70000, 13000, 10, 20))
                .withWeather(FishProperties.Weather.RAIN)
                .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING_MOVING)
                .withBaitRestrictions(FishProperties.BaitRestrictions.LEGENDARY_BAIT)
                .withRarity(FishProperties.Rarity.LEGENDARY));

        //overworld underground lava
        register(overworldUndergroundLava(ModItems.MOLTEN_SHRIMP)
                .withSizeAndWeight(FishProperties.sw(10, 3, 20, 10, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD));

        register(overworldUndergroundLava(ModItems.OBSIDIAN_CRAB)
                .withSizeAndWeight(FishProperties.sw(15, 8, 700, 300, 10, 20))
                .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                .withRarity(FishProperties.Rarity.UNCOMMON));

        //overworld deepslate lava
        register(overworldDeepslateLava(ModItems.SCORCHED_BLOODSUCKER)
                .withSizeAndWeight(FishProperties.sw(60, 30, 1700, 300, 10, 20))
                .withRarity(FishProperties.Rarity.EPIC)
                .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN));

        register(overworldDeepslateLava(ModItems.MOLTEN_DEEPSLATE_CRAB)
                .withSizeAndWeight(FishProperties.sw(15, 8, 700, 300, 10, 20))
                .withRarity(FishProperties.Rarity.RARE)
                .withDifficulty(FishProperties.Difficulty.HARD_VANISHING));
    }
}
