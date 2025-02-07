package net.threeeaglestudios.dreadnoughtwarfare.entity.client;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.entity.custom.ArtilleryEntity;
import net.threeeaglestudios.dreadnoughtwarfare.entity.layers.ModModelLayers;

public class ArtilleryRenderer extends EntityRenderer<ArtilleryEntity> {
    private static final ResourceLocation ARTILLERY_LOCATION = new ResourceLocation(DreadnoughtWarfare.MOD_ID, "textures/entity/artillery.png");

    public ArtilleryRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }


//    public ArtilleryRenderer(EntityRendererProvider.Context pContext) {
//        super(pContext, new ArtilleryModel<>(pContext.bakeLayer(ModModelLayers.ARTILLERY_LAYER)), 1f);
//    }

    @Override
    public ResourceLocation getTextureLocation(ArtilleryEntity pEntity) {
        return ARTILLERY_LOCATION;
    }
}
