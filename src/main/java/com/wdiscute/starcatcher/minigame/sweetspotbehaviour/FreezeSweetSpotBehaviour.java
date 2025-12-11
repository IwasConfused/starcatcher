package com.wdiscute.starcatcher.minigame.sweetspotbehaviour;

import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;

public class FreezeSweetSpotBehaviour extends AbstractSweetSpotBehaviour
{
    private int frozenTicks = -1;

    @Override
    public void onHit()
    {
        super.onHit();
        frozenTicks = 20;
        instance.pointerSpeed = 0;
        instance.addParticles(ass.pos, 30, 0xADD8E6);
    }

    @Override
    public void onAdd(FishingMinigameScreen instance, ActiveSweetSpot ass)
    {
        super.onAdd(instance, ass);
    }

    @Override
    public void tick()
    {
        super.tick();
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
    public void renderForeground(GuiGraphics guiGraphics, float partialTick, int width, int height)
    {
        super.renderForeground(guiGraphics, partialTick, width, height);
        if (frozenTicks > 0)
            guiGraphics.blit(FishingMinigameScreen.TEXTURE, width / 2 - 16, height / 2 - 16, 32, 32, 0, 0, 32, 32, 256, 256);
    }
}
