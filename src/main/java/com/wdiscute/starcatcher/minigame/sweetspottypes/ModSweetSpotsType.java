package com.wdiscute.starcatcher.minigame.sweetspottypes;

import com.wdiscute.starcatcher.Starcatcher;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModSweetSpotsType
{
    DeferredRegister<AbstractSweetSpotType> SWEET_SPOTS =
            DeferredRegister.create(Starcatcher.SWEET_SPOTS_REGISTRY, Starcatcher.MOD_ID);

    Supplier<AbstractSweetSpotType> NORMAL = SWEET_SPOTS.register("normal", NormalSweetSpotType::new);
    Supplier<AbstractSweetSpotType> FREEZE_SWEET_SPOT = SWEET_SPOTS.register("freeze", FreezeSweetSpotType::new);

}
