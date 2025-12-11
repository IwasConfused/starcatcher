package com.wdiscute.starcatcher.minigame.sweetspotbehaviour;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;
import org.joml.Quaternionf;

public abstract class AbstractSweetSpotBehaviour
{
    public int particleColor = 0x00ff00;
    public int ticksActive;
    protected FishingMinigameScreen instance;
    protected ActiveSweetSpot ass;

    public void onAdd(FishingMinigameScreen instance, ActiveSweetSpot ass)
    {
        this.instance = instance;
        this.ass = ass;
        ass.pos = instance.getRandomFreePosition(ass.thickness);
    }

    public void tick()
    {
        ticksActive++;

        ass.pos += ass.movingRate * ass.currentRotation;
        ass.pos += ass.movingRate * ass.currentRotation;

        ass.alpha -= ass.vanishingRate;

        if(ass.shouldSudokuOnVanish && ass.alpha <= 0) ass.removed = true;
    }

    public void render(GuiGraphics guiGraphics, float partialTick, int width, int height)
    {
        float centerX = width / 2f;
        float centerY = height / 2f;

        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.translate(centerX, centerY, 0);

        poseStack.mulPose(new Quaternionf().rotateZ((float) Math.toRadians(ass.pos + ((ass.movingRate * partialTick) * ass.currentRotation))));
        poseStack.translate(-centerX, -centerY, 0);

        RenderSystem.setShaderColor(1, 1, 1, ass.alpha);

        RenderSystem.enableBlend();

        guiGraphics.blit(
                ass.texture, width / 2 - 48, height / 2 - 48,
                96, 96, 0, 0, 96, 96, 96, 96);

        RenderSystem.disableBlend();

        RenderSystem.setShaderColor(1, 1, 1, 1);

        poseStack.popPose();
    }

    public void onHit(){}
}
