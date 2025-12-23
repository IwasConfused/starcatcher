package com.wdiscute.starcatcher.registry.custom.tackleskin;

import com.mojang.datafixers.util.Pair;
import com.wdiscute.starcatcher.Starcatcher;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModTackleSkins
{
    DeferredRegister<Supplier<AbstractTackleSkin>> REGISTRY =
            DeferredRegister.create(Starcatcher.TACKLE_SKIN_REGISTRY, Starcatcher.MOD_ID);

    //base
    Pair<ResourceLocation, AbstractTackleSkin> BASE_TACKLE_SKIN = registerCatchModifier("base", BaseTackleSkin::new);

    //pearl
    Pair<ResourceLocation, AbstractTackleSkin> PEARL_TACKLE_SKIN = registerCatchModifier("pearl", PearlTackleSkin::new);

    //kimbe
    Pair<ResourceLocation, AbstractTackleSkin> KIMBE_TACKLE_SKIN = registerCatchModifier("kimbe", KimbeTackleSkin::new);

    //frog
    Pair<ResourceLocation, AbstractTackleSkin> FROG_TACKLE_SKIN = registerCatchModifier("frog", FrogTackleSkin::new);

    //colorful
    Pair<ResourceLocation, AbstractTackleSkin> COLORFUL_TACKLE_SKIN = registerCatchModifier("colorful", ColorfulTackleSkin::new);

    //clear
    Pair<ResourceLocation, AbstractTackleSkin> CLEAR_TACKLE_SKIN = registerCatchModifier("clear", ClearTackleSkin::new);


    static Pair<ResourceLocation, AbstractTackleSkin> registerCatchModifier(String name, Supplier<AbstractTackleSkin> sup)
    {
        REGISTRY.register(name, () -> sup);
        return Pair.of(Starcatcher.rl(name), sup.get());
    }

    static void register(IEventBus eventBus)
    {
        REGISTRY.register(eventBus);
    }
}
