package net.threeeaglestudios.dreadnoughtwarfare.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.entity.custom.ArtilleryEntity;
import net.threeeaglestudios.dreadnoughtwarfare.entity.layers.ModModelLayers;

public class ArtilleryRenderer extends EntityRenderer<ArtilleryEntity> {
    private static final ResourceLocation ARTILLERY_LOCATION = new ResourceLocation(DreadnoughtWarfare.MOD_ID, "textures/entity/artillery.png");

    protected final EntityModel<ArtilleryEntity> model;

    public ArtilleryRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new ArtilleryModel<>(pContext.bakeLayer(ModModelLayers.ARTILLERY_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(ArtilleryEntity pEntity) {
        return ARTILLERY_LOCATION;
    }

    @Override
    public void render(ArtilleryEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();

        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(model.renderType(getTextureLocation(entity)));
        model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}