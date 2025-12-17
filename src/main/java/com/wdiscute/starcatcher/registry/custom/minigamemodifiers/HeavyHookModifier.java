package com.wdiscute.starcatcher.registry.custom.minigamemodifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import org.checkerframework.checker.index.qual.PolyUpperBound;

public class HeavyHookModifier extends AbstractMinigameModifier
{
    float rate;

    public HeavyHookModifier(float speedDividedByX)
    {
        this.rate = speedDividedByX;
    }

    @Override
    public ActiveSweetSpot onSpotAdded(ActiveSweetSpot ass)
    {
        super.onSpotAdded(ass);
        ass.movingRate /= rate;
        return ass;
    }
}
