package com.wdiscute.starcatcher.registry.custom.minigamemodifiers;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.io.ModDataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModMinigameModifiers
{
    DeferredRegister<Supplier<AbstractMinigameModifier>> REGISTRY =
            DeferredRegister.create(Starcatcher.MINIGAME_MODIFIERS_REGISTRY, Starcatcher.MOD_ID);

    //ice fishes
    ResourceLocation FREEZE_ON_MISS = registerMinigameModifier("freeze_on_miss", FreezeOnMissModifier::new);

    //aurora?
    ResourceLocation SPAWN_FROZEN_SWEET_SPOTS = registerMinigameModifier("spawn_frozen_sweet_spots", SpawnFrozenSweetSpotsModifier::new);

    //base modifier
    ResourceLocation LOW_CHANCE_TREASURE_SPAWN = registerMinigameModifier("low_chance_treasure_spawn", LowChanceTreasureSpawnModifier::new);

    //gunpowder bait
    ResourceLocation SPAWN_TNT_SWEET_SPOTS = registerMinigameModifier("spawn_tnt_sweet_spots", SpawnTntSweetSpotsModifier::new);

    //shiny hook
    ResourceLocation SPAWN_TREASURE_ON_THREE_HITS = registerMinigameModifier("spawn_treasure_on_three_hits", ShinyHookModifier::new);

    //heavy hook
    ResourceLocation SLOWER_MOVING_SWEET_SPOTS = registerMinigameModifier("slower_moving_sweet_spots", HeavyHookModifier::new);

    //stone hook
    ResourceLocation STOP_DECAY_ON_HIT = registerMinigameModifier("stop_decay_on_hit", StoneHookModifier::new);

    //mossy hook
    ResourceLocation HARDER_WITH_TREASURE_ON_PERFECT = registerMinigameModifier("harder_with_treasure_on_perfect", MossyHookModifier::new);

    //stabilizing hook
    ResourceLocation NO_FLIP = registerMinigameModifier("no_flip", EmptyMinigameModifier::new);

    //steady bobber
    ResourceLocation BIGGER_GREEN_SWEET_SPOTS = registerMinigameModifier("bigger_green_sweet_spots", SteadyBobberModifier::new);

    //clear bobber
    ResourceLocation SLOWER_VANISHING = registerMinigameModifier("slower_vanishing", ClearBobberModifier::new);

    //aqua bobber
    ResourceLocation ADD_AQUA_SWEET_SPOT = registerMinigameModifier("add_aqua_sweet_spot", () -> new AquaBobberModifier(1));

    //unused
    ResourceLocation ADD_THREE_AQUA_SWEET_SPOT = registerMinigameModifier("add_three_aqua_sweet_spot", () -> new AquaBobberModifier(3));



    static ResourceLocation registerMinigameModifier(String name, Supplier<AbstractMinigameModifier> sup)
    {
        REGISTRY.register(name, () -> sup);
        return Starcatcher.rl(name);
    }

    static void register(IEventBus eventBus)
    {
        REGISTRY.register(eventBus);
    }
}
