package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;

public class BaseModifier extends AbstractModifier
{
    @Override
    public void onMiss()
    {
        super.onMiss();
        instance.kimbeMarkerAlpha = 1;
        instance.kimbeMarkerColor = 0xe53838;
        instance.kimbeMarkerPos = instance.getPointerPosPrecise();
    }

    @Override
    public void onHit(ActiveSweetSpot ass)
    {
        super.onHit(ass);
        instance.kimbeMarkerAlpha = 1;
        instance.kimbeMarkerColor = 0x2a972a;
        instance.kimbeMarkerPos = instance.getPointerPosPrecise();
    }
}
