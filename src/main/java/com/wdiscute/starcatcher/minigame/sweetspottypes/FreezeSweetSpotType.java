package com.wdiscute.starcatcher.minigame.sweetspottypes;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class FreezeSweetSpotType extends AbstractSweetSpotType
{
    public static final ResourceLocation TEXTURE = Starcatcher.rl("textures/gui/minigame/minigame.png");

    private int frozenTicks = -1;

    @Override
    public void onHit(FishingMinigameScreen instance, ActiveSweetSpot ass)
    {
        frozenTicks = 20;
        instance.pointerSpeed = 0;
    }

    @Override
    public void tick(FishingMinigameScreen instance)
    {
        if (frozenTicks > 0)
        {
            instance.pointerSpeed = 0;
            frozenTicks--;
        }
        if (frozenTicks == 0)
        {
            frozenTicks = -1;
            instance.pointerSpeed = instance.pointerBaseSpeed;
        }
    }

    @Override
    public void render(FishingMinigameScreen instance, GuiGraphics guiGraphics, float partialTick, int width, int height)
    {
        if (frozenTicks > 0)
            guiGraphics.blit(TEXTURE, width / 2 - 16, height / 2 - 16, 32, 32, 0, 0, 32, 32, 256, 256);

    }
}
