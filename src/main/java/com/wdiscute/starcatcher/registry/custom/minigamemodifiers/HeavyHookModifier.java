package com.wdiscute.starcatcher.registry.custom.minigamemodifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;

public class HeavyHookModifier extends AbstractMinigameModifier
{

    @Override
    public ActiveSweetSpot onSpotAdded(ActiveSweetSpot ass)
    {
        super.onSpotAdded(ass);
        if(ass.movingRate > 2) ass.movingRate /= 2;
        return ass;
    }
}
