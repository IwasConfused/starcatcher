package com.wdiscute.starcatcher.registry.custom.minigamemodifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.storage.FishProperties;

import java.util.Random;

public class SpawnTntSweetSpotsModifier extends AbstractMinigameModifier
{
    private final Random r = new Random();

    @Override
    public void tick()
    {
        super.tick();
        if (r.nextFloat() > 0.95f)
        {
            ActiveSweetSpot activeSweetSpot = new ActiveSweetSpot(instance, FishProperties.SweetSpot.TNT);
            instance.addSweetSpot(activeSweetSpot);
        }
    }
}
