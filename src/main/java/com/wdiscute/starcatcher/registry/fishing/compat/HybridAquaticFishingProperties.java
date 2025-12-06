package com.wdiscute.starcatcher.registry.fishing.compat;

import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.registry.fishing.FishingPropertiesRegistry;
import com.wdiscute.starcatcher.storage.FishProperties;

public class HybridAquaticFishingProperties extends FishingPropertiesRegistry
{
    public static void bootstrap()
    {

        //Literally The Coolest Mod Ever (this fact has been fact-checked by true fisherman ✅)

        //
        // ,--.  ,--.           ,--.            ,--.    ,--.       ,---.                               ,--.   ,--.
        // |  '--'  | ,--. ,--. |  |-.  ,--.--. `--'  ,-|  |      /  O  \   ,---.  ,--.,--.  ,--,--. ,-'  '-. `--'  ,---.
        // |  .--.  |  \  '  /  | .-. ' |  .--' ,--. ' .-. |     |  .-.  | | .-. | |  ||  | ' ,-.  | '-.  .-' ,--. | .--'
        // |  |  |  |   \   '   | `-' | |  |    |  | \ `-' |     |  | |  | ' '-' | '  ''  ' \ '-'  |   |  |   |  | \ `--.
        // `--'  `--' .-'  /     `---'  `--'    `--'  `---'      `--' `--'  `-|  |  `----'   `--`--'   `--'   `--'  `---'
        //            `---'                                                   `--'                                                                   |_|

        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "clownfish"))
                        .withSizeAndWeight(FishProperties.sw(9, 2, 200, 50, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR)
        );

        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "surgeonfish"))
                        .withSizeAndWeight(FishProperties.sw(25, 10, 450, 150, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));

        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "blowfish"))
                        .withSizeAndWeight(FishProperties.sw(18, 4, 5, 3, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "boxfish"))
                        .withSizeAndWeight(FishProperties.sw(30, 20, 150, 50, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "damselfish"))
                        .withSizeAndWeight(FishProperties.sw(10, 5, 20, 5, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "moray_eel"))
                        .withSizeAndWeight(FishProperties.sw(250, 150, 10000, 8000, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
                        .withRarity(FishProperties.Rarity.RARE)
                        .withDaytime(FishProperties.Daytime.NIGHT));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "blue_spotted_stingray"))
                        .withSizeAndWeight(FishProperties.sw(50, 30, 4000, 1000, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD)
                        .withRarity(FishProperties.Rarity.RARE)
                        .withDaytime(FishProperties.Daytime.NOON)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "spotted_eagle_ray"))
                        .withSizeAndWeight(FishProperties.sw(400, 100, 20000, 3000, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD)
                        .withRarity(FishProperties.Rarity.RARE)
                        .withDaytime(FishProperties.Daytime.NOON)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "lionfish"))
                        .withSizeAndWeight(FishProperties.sw(33, 5, 900, 150, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.NOON)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "needlefish"))
                        .withSizeAndWeight(FishProperties.sw(100, 10, 2300, 300, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "stonefish"))
                        .withSizeAndWeight(FishProperties.sw(35, 5, 1500, 500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.NOON)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "parrotfish"))
                        .withSizeAndWeight(FishProperties.sw(40, 10, 1600, 1400, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.COMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "seahorse"))
                        .withSizeAndWeight(FishProperties.sw(15, 10, 20, 15, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "triggerfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldWarmOceanFish(fromRL("hybrid-aquatic", "flying_fish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "anglerfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "barreleye"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "dragonfish"))
                        .withSizeAndWeight(FishProperties.sw(12, 3, 13, 3, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.NIGHT));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "coelacanth"))
                        .withSizeAndWeight(FishProperties.sw(150, 50, 60000, 30000, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD_VANISHING)
                        .withRarity(FishProperties.Rarity.RARE));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "oarfish"))
                        .withSizeAndWeight(FishProperties.sw(800, 300, 250000, 22000, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING)
                        .withRarity(FishProperties.Rarity.RARE)
                        .withWeather(FishProperties.Weather.THUNDER));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "ratfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "snailfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "john_dory"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM_VANISHING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "flashlight_fish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withDaytime(FishProperties.Daytime.NIGHT)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "squirrelfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withDaytime(FishProperties.Daytime.NIGHT)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldOceanFish(fromRL("hybrid-aquatic", "tuna"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldOceanFish(fromRL("hybrid-aquatic", "mahi"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldOceanFish(fromRL("hybrid-aquatic", "mackerel"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldColdOceanFish(fromRL("hybrid-aquatic", "herring"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_MOVING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldOceanFish(fromRL("hybrid-aquatic", "sea_bass"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldOceanFish(fromRL("hybrid-aquatic", "sheepshead_wrasse"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldOceanFish(fromRL("hybrid-aquatic", "pearlfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldOceanFish(fromRL("hybrid-aquatic", "rockfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "opah"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.MEDIUM_MOVING)
                        .withRarity(FishProperties.Rarity.UNCOMMON)
                        .withDaytime(FishProperties.Daytime.NIGHT)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldDeepOceanFish(fromRL("hybrid-aquatic", "sunfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD_MOVING)
                        .withRarity(FishProperties.Rarity.RARE)
                        .withDaytime(FishProperties.Daytime.DAY)
                        .withWeather(FishProperties.Weather.CLEAR));
        register(
                overworldCherryGroveFish(fromRL("hybrid-aquatic", "goldfish"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldCherryGroveFish(fromRL("hybrid-aquatic", "koi"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldRiverFish(fromRL("hybrid-aquatic", "carp"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "golden_dorado"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.HARD_ONLY_THIN_MOVING)
                        .withRarity(FishProperties.Rarity.RARE));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "oscar"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "tetra"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "tiger_barb"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "betta"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.UNCOMMON));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "danio"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "gourami"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.COMMON));
        register(
                overworldJungleFish(fromRL("hybrid-aquatic", "discus"))
                        .withSizeAndWeight(FishProperties.sw(90, 10, 4300, 2500, 10, 20))
                        .withDifficulty(FishProperties.Difficulty.EASY_VANISHING)
                        .withRarity(FishProperties.Rarity.COMMON));
    }
}
