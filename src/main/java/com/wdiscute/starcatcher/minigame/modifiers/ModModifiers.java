package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.Starcatcher;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModModifiers
{
    DeferredRegister<AbstractModifier> MODIFIERS =
            DeferredRegister.create(Starcatcher.MODIFIERS_REGISTRY, Starcatcher.MOD_ID);

    Supplier<AbstractModifier> FREEZE_MODIFIER = MODIFIERS.register("freeze_modifier", FreezeModifier::new);
    Supplier<AbstractModifier> FROZEN_SWEET_SPOT_MODIFIER = MODIFIERS.register("frozen_sweet_spot_modifier", FrozenSweetSpotModifier::new);

}
