package com.wdiscute.starcatcher.minigame.sweetspotbehaviour;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;

public class TreasureSweetSpotBehaviour extends AbstractSweetSpotBehaviour
{

    @Override
    public void onHit()
    {
        super.onHit();
        //spawn particles before repositioning
        instance.addParticles(ass.pos, 30, 0x00ff00);
        //reposition
        ass.pos = instance.getRandomFreePosition(ass.thickness);
        //flip if ass is flip
        if(ass.isFlip) instance.currentRotation *= -1;
        //award treasure progress based on ass
        instance.treasureProgress += ass.reward;
    }

    @Override
    public void onAdd(FishingMinigameScreen instance, ActiveSweetSpot ass)
    {
        super.onAdd(instance, ass);
        if(!instance.treasureActive) instance.treasureActive = true;
        if(instance.treasureProgress >= 100) ass.removed = true;
        particleColor = 0xFFD700;
    }

    @Override
    public void tick()
    {
        super.tick();
        if(instance.treasureProgress >= 100) ass.removed = true;
    }
}
