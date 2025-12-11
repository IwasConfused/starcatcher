package com.wdiscute.starcatcher.minigame.modifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.wdiscute.starcatcher.Starcatcher;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class FreezeModifier extends AbstractModifier
{
    public static final ResourceLocation TEXTURE = Starcatcher.rl("textures/gui/minigame/minigame.png");
    public static final ResourceLocation OVERLAY = Starcatcher.rl("textures/gui/minigame/modifiers/freeze.png");

    private int frozenTicks = -1;

    @Override
    public void onMiss()
    {
        super.onMiss();
        frozenTicks = 20;
        instance.pointerSpeed = 0;
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, float partialTick, PoseStack poseStack, int width, int height)
    {
        super.renderBackground(guiGraphics, partialTick, poseStack, width, height);
        guiGraphics.blit(
                OVERLAY, width / 2 - 48, height / 2 - 48,
                96, 96, 0, 0, 96, 96, 96, 96);
    }

    @Override
    public void renderForeground(GuiGraphics guiGraphics, float partialTick, PoseStack poseStack, int width, int height)
    {
        super.renderForeground(guiGraphics, partialTick, poseStack, width, height);
        if (frozenTicks > 0)
            guiGraphics.blit(TEXTURE, width / 2 - 16, height / 2 - 16, 32, 32, 0, 0, 32, 32, 256, 256);

    }

    @Override
    public void tick()
    {
        super.tick();
        if (frozenTicks > 0) frozenTicks--;
        if (frozenTicks == 0)
        {
            frozenTicks = -1;
            instance.pointerSpeed = instance.pointerBaseSpeed;
        }
    }
}
