package com.wdiscute.starcatcher.minigame;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.minigame.sweetspottypes.AbstractSweetSpotType;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;

public class ActiveSweetSpot
{
    //from ss
    private final ResourceLocation texture;
    public final AbstractSweetSpotType sweetSpotType;
    public final int size;
    public final int reward;

    //from minigame screen/rod
    private final ItemStack bobber;
    private final ItemStack bait;
    private final ItemStack hook;

    //from fp
    public boolean isFlip;
    public float vanishingRate;
    private float movingRate;

    //active sweet spot tracking
    public float alpha;
    public float pos;
    public int currentRotation;

    public boolean removed = false;
    private boolean shouldSudokuOnVanish = false;

    public void setShouldSudokuOnVanish(boolean shouldSudokuOnVanish)
    {
        this.shouldSudokuOnVanish = shouldSudokuOnVanish;
    }

    public void setVanishingRate(float vanishingRate)
    {
        this.vanishingRate = vanishingRate;
    }

    public ActiveSweetSpot(FishProperties.SweetSpot ss, ItemStack bobber, ItemStack bait, ItemStack hook, FishingMinigameScreen instance)
    {
        this.sweetSpotType = Minecraft.getInstance().level.registryAccess().registryOrThrow(Starcatcher.SWEET_SPOT_TYPES).get(ss.sweetSpotType());
        this.texture = ss.texturePath();
        this.size = ss.size();
        this.reward = ss.reward();

        this.bobber = bobber;
        this.bait = bait;
        this.hook = hook;

        this.isFlip = ss.isFlip();
        this.vanishingRate = ss.isVanishing() ? 0.1f : 0f;
        this.movingRate = ss.isMoving() ? 1 : 0;

        //todo set moving and vanishing rate based on fp

        currentRotation = 1;

        this.alpha = 1;
        this.pos = instance.getRandomFreePosition();
    }

    public ActiveSweetSpot(FishProperties.SweetSpot ss, FishingMinigameScreen instance)
    {
        this(ss, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, instance);
    }

    public void tick(FishingMinigameScreen instance)
    {
        this.pos += movingRate * currentRotation;
        this.pos += movingRate * currentRotation;

        this.alpha -= vanishingRate;

        if(shouldSudokuOnVanish && alpha <= 0) removed = true;
    }

    public void render(FishingMinigameScreen instance, GuiGraphics guiGraphics, float partialTick, int width, int height)
    {
        float centerX = width / 2f;
        float centerY = height / 2f;

        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.translate(centerX, centerY, 0);

        poseStack.mulPose(new Quaternionf().rotateZ((float) Math.toRadians(pos + ((movingRate * partialTick) * currentRotation))));
        poseStack.translate(-centerX, -centerY, 0);

        RenderSystem.setShaderColor(1, 1, 1, alpha);

        RenderSystem.enableBlend();

        guiGraphics.blit(
                texture, width / 2 - 48, height / 2 - 48,
                96, 96, 0, 0, 96, 96, 96, 96);

        RenderSystem.disableBlend();

        RenderSystem.setShaderColor(1, 1, 1, 1);

        poseStack.popPose();
    }


}
