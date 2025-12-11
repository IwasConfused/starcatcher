package com.wdiscute.starcatcher.minigame.modifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;

public abstract class AbstractModifier
{
    public boolean removed = false;
    protected FishingMinigameScreen instance;

    public void onAdd(FishingMinigameScreen instance)
    {
        this.instance = instance;
    }

    public void onHit(ActiveSweetSpot ass){};

    public void onMiss(){}

    public void tick(){}

    public void onSuccessfulCatch(){}

    public void renderBackground(GuiGraphics guiGraphics, float partialTick, int width, int height){};

    public void renderForeground(GuiGraphics guiGraphics, float partialTick, int width, int height){};
}
