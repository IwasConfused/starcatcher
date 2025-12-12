package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import net.minecraft.client.gui.GuiGraphics;

public class FrozenPointerModifier extends AbstractTimedModifier{
    float lastPointerSpeed;

    public FrozenPointerModifier(int length) {
        super(length);
    }

    @Override
    public void onAdd(FishingMinigameScreen instance) {
        super.onAdd(instance);

        lastPointerSpeed = instance.pointerSpeed;
        instance.pointerSpeed = 0f;
    }

    @Override
    public void onRemove() {
        super.onRemove();

        instance.pointerSpeed = lastPointerSpeed;
    }

    @Override
    public void renderForeground(GuiGraphics guiGraphics, float partialTick, int width, int height) {
        super.renderForeground(guiGraphics, partialTick, width, height);

        guiGraphics.blit(FishingMinigameScreen.TEXTURE, width / 2 - 16, height / 2 - 16, 32, 32, 0, 0, 32, 32, 256, 256);
    }
}
