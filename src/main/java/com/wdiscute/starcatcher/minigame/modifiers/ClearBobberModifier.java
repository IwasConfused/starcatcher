package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;

public class ClearBobberModifier extends AbstractModifier
{
    @Override
    public void onSweetSpotAdded(ActiveSweetSpot ass)
    {
        super.onSweetSpotAdded(ass);
        ass.vanishingRate /= 3;
    }
}
