package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.registry.ModItemProperties;
import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.registry.blocks.ModBlocks;
import net.dries007.tfc.client.overworld.Star;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModModifiers
{
    DeferredRegister<AbstractModifier> REGISTRY =
            DeferredRegister.create(Starcatcher.MODIFIERS_REGISTRY, Starcatcher.MOD_ID);

    ResourceLocation FREEZE_ON_MISS = registerModifier("freeze_on_miss", FreezeModifier::new);
    ResourceLocation SPAWN_FROZEN_SWEET_SPOTS = registerModifier("spawn_frozen_sweet_spots", AddFrozenSweetSpotsModifier::new);
    ResourceLocation LOW_CHANCE_TREASURE_SPAWN = registerModifier("low_chance_treasure_spawn", LowChanceTreasureSpawnModifier::new);


    static ResourceLocation registerModifier(String name, Supplier<AbstractModifier> sup)
    {
        REGISTRY.register(name, sup);
        return Starcatcher.rl("name");
    }

    static void register(IEventBus eventBus)
    {
        REGISTRY.register(eventBus);
    }
}
