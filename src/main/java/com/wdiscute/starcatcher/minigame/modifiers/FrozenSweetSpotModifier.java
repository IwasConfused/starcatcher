package com.wdiscute.starcatcher.minigame.modifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.minigame.ActiveSweetSpot;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class FrozenSweetSpotModifier extends AbstractModifier
{

    private final Random r = new Random();

    @Override
    public void onMiss(FishingMinigameScreen instance)
    {
    }

    @Override
    public void render(FishingMinigameScreen instance, GuiGraphics guiGraphics, float partialTick, PoseStack poseStack, int width, int height)
    {
    }

    @Override
    public void tick(FishingMinigameScreen instance)
    {

        if(r.nextFloat() > 0.99f)
        {
            ActiveSweetSpot activeSweetSpot = new ActiveSweetSpot(FishProperties.SweetSpot.FREEZE, instance);
            activeSweetSpot.setShouldSudokuOnVanish(true);
            activeSweetSpot.setVanishingRate(0.02f);
            instance.activeSweetSpots.add(activeSweetSpot);
        }
    }

    @Override
    public void onSuccessfulCatch(FishingMinigameScreen instance)
    {

    }

    @Override
    public void onHit(FishingMinigameScreen instance, ActiveSweetSpot ass)
    {

    }
}
