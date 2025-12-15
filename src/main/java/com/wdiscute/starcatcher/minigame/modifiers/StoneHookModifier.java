package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;

public class StoneHookModifier extends AbstractModifier
{
    @Override
    public boolean onHit(ActiveSweetSpot ass)
    {
        instance.gracePeriod = instance.fishProperties.rarity().getStoneHookGraceTicks();;

        return super.onHit(ass);
    }
}
