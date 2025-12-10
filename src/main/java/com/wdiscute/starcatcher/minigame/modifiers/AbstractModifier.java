package com.wdiscute.starcatcher.minigame.modifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;

public abstract class AbstractModifier
{
    public abstract void onHit(FishingMinigameScreen instance, ActiveSweetSpot ass);

    public abstract void onMiss(FishingMinigameScreen instance);

    public abstract void tick(FishingMinigameScreen instance);

    public abstract void onSuccessfulCatch(FishingMinigameScreen instance);

    public abstract void render(FishingMinigameScreen instance, GuiGraphics guiGraphics, float partialTick, PoseStack poseStack, int width, int height);
}
