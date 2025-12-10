package com.wdiscute.starcatcher.minigame.sweetspottypes;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;

public abstract class AbstractSweetSpotType
{
    public abstract void onHit(FishingMinigameScreen instance, ActiveSweetSpot ass);

    public abstract void tick(FishingMinigameScreen instance);

    public abstract void render(FishingMinigameScreen instance, GuiGraphics guiGraphics, float partialTick, int width, int height);

}
