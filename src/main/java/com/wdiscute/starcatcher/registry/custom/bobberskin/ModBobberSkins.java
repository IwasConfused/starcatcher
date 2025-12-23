package com.wdiscute.starcatcher.registry.custom.bobberskin;

import com.mojang.datafixers.util.Pair;
import com.wdiscute.starcatcher.Starcatcher;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModBobberSkins
{
    DeferredRegister<Supplier<AbstractBobberSkin>> REGISTRY =
            DeferredRegister.create(Starcatcher.BOBBER_SKIN_REGISTRY, Starcatcher.MOD_ID);


    //pearl
    Pair<ResourceLocation, Supplier<AbstractBobberSkin>> PEARL_BOBBER_SKIN = registerCatchModifier(
            "pearl",
            PearlBobberSkin::new);





    static Pair<ResourceLocation, Supplier<AbstractBobberSkin>> registerCatchModifier(String name, Supplier<AbstractBobberSkin> sup)
    {
        REGISTRY.register(name, () -> sup);
        return Pair.of(Starcatcher.rl(name), sup);
    }

    static void register(IEventBus eventBus)
    {
        REGISTRY.register(eventBus);
    }
}
