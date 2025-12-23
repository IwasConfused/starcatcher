package com.wdiscute.starcatcher.registry.custom.tackleskin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.bob.FishingBobEntity;
import com.wdiscute.starcatcher.bob.FishingBobModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public abstract class AbstractTackleSkin
{
    public abstract ModelLayerLocation getLayerLocation();
    public abstract ResourceLocation getTexture();

    RenderType renderType = null;
    protected FishingBobModel<FishingBobEntity> model;

    public void renderTackle(EntityRendererProvider.Context context, FishingBobEntity fishingBobEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        if (renderType == null)
        {
            this.model = new FishingBobModel<>(context.bakeLayer(getLayerLocation()));
            this.renderType = RenderType.entityCutout(getTexture());
        }
        this.model.renderToBuffer(poseStack, buffer.getBuffer(renderType), packedLight, OverlayTexture.NO_OVERLAY, -1);
    }

}
