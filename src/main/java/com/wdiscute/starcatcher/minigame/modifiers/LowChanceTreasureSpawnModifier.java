package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.storage.FishProperties;

import java.util.Random;

public class LowChanceTreasureSpawnModifier extends AbstractModifier
{
    private static Random r = new Random();

    @Override
    public void onHit(ActiveSweetSpot ass)
    {
        super.onHit(ass);
        if (r.nextFloat() > 0.975 && instance.progress < 75)
        {
            removed = true;
            ActiveSweetSpot newTreasureSweetSpot = new ActiveSweetSpot(instance, FishProperties.SweetSpot.TREASURE);
            instance.addSweetSpot(newTreasureSweetSpot);
        }
    }
}
