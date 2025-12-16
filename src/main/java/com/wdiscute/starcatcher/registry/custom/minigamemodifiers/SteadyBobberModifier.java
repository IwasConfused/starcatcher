package com.wdiscute.starcatcher.registry.custom.minigamemodifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.storage.FishProperties;

public class SteadyBobberModifier extends AbstractMinigameModifier
{

    @Override
    public ActiveSweetSpot onSpotAdded(ActiveSweetSpot ass)
    {
        super.onSpotAdded(ass);
        if(ass.baseSS.equals(FishProperties.SweetSpot.NORMAL))
        {
            ass.texture = FishProperties.SweetSpot.NORMAL_STEADY.texturePath();
            ass.thickness = FishProperties.SweetSpot.NORMAL_STEADY.size();
        }
        return ass;
    }
}
