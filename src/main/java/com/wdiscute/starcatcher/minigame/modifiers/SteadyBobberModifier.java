package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.storage.FishProperties;

public class SteadyBobberModifier extends AbstractModifier
{

    @Override
    public void onSweetSpotAdded(ActiveSweetSpot ass)
    {
        super.onSweetSpotAdded(ass);
        if(ass.baseSS.equals(FishProperties.SweetSpot.NORMAL))
        {
            ass.texture = FishProperties.SweetSpot.NORMAL_STEADY.texturePath();
            ass.thickness = FishProperties.SweetSpot.NORMAL_STEADY.size();
        }
    }
}
