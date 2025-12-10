package com.wdiscute.starcatcher.minigame.sweetspottypes;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;

public class NormalSweetSpotType extends AbstractSweetSpotType
{
    @Override
    public void onHit(FishingMinigameScreen instance, ActiveSweetSpot ass)
    {
        instance.addParticles(ass.pos, 30);
    }

    @Override
    public void tick(FishingMinigameScreen instance)
    {

    }

    @Override
    public void render(FishingMinigameScreen instance, GuiGraphics guiGraphics, float partialTick, int width, int height)
    {

    }
}
