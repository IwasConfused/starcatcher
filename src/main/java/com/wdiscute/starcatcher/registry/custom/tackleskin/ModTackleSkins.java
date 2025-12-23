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
   ResourceLocation BASE_TACKLE_SKIN = registerCatchModifier("base", BaseTackleSkin::new);

    //pearl
    ResourceLocation PEARL_TACKLE_SKIN = registerCatchModifier("pearl", PearlTackleSkin::new);

    //kimbe
   ResourceLocation KIMBE_TACKLE_SKIN = registerCatchModifier("kimbe", KimbeTackleSkin::new);

    //frog
   ResourceLocation FROG_TACKLE_SKIN = registerCatchModifier("frog", FrogTackleSkin::new);

    //colorful
   ResourceLocation COLORFUL_TACKLE_SKIN = registerCatchModifier("colorful", ColorfulTackleSkin::new);

    //clear
   ResourceLocation CLEAR_TACKLE_SKIN = registerCatchModifier("clear", ClearTackleSkin::new);


    static ResourceLocation registerCatchModifier(String name, Supplier<AbstractTackleSkin> sup)
    {
        REGISTRY.register(name, () -> sup);
        return Starcatcher.rl(name);
    }

    static void register(IEventBus eventBus)
    {
        REGISTRY.register(eventBus);
    }
}
