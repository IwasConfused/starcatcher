package com.wdiscute.starcatcher.minigame.sweetspotbehaviour;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import com.wdiscute.starcatcher.minigame.modifiers.FrozenPointerModifier;
import net.minecraft.client.gui.GuiGraphics;

public class FreezeSweetSpotBehaviour extends AbstractSweetSpotBehaviour
{
    @Override
    public void onHit()
    {
        super.onHit();
        instance.addParticles(ass.pos, 30, 0xADD8E6);

        instance.addModifier(new FrozenPointerModifier(20));
    }
}
