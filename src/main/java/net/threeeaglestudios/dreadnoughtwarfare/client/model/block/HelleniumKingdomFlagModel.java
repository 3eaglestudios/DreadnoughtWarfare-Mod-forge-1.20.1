package net.threeeaglestudios.dreadnoughtwarfare.client.model.block;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlockEntities;
import net.threeeaglestudios.dreadnoughtwarfare.block.entity.HelleniumKingdomFlagEntity;
import net.threeeaglestudios.dreadnoughtwarfare.client.renderer.block.HelleniumKingdomFlagRenderer;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class HelleniumKingdomFlagModel extends DefaultedBlockGeoModel<HelleniumKingdomFlagEntity> {
    private final ResourceLocation HELLENIUM_KINGDOM_FLAG_MODEL = buildFormattedModelPath(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "hellenium_kingdom_flag"));
    private final ResourceLocation HELLENIUM_KINGDOM_FLAG_TEXTURE = buildFormattedTexturePath(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "hellenium_kingdom_flag"));
    private final ResourceLocation HELLENIUM_KINGDOM_FLAG_ANIMATIONS = buildFormattedAnimationPath(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "hellenium_kingdom_flag"));

    public HelleniumKingdomFlagModel() {
        super(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "hellenium_kingdom_flag"));
    }
    @Override
    public ResourceLocation getAnimationResource(HelleniumKingdomFlagEntity animatable) {
            return HELLENIUM_KINGDOM_FLAG_ANIMATIONS;
    }

    @Override
    public ResourceLocation getModelResource(HelleniumKingdomFlagEntity animatable) {
        return HELLENIUM_KINGDOM_FLAG_MODEL;
    }
    @Override
    public ResourceLocation getTextureResource(HelleniumKingdomFlagEntity animatable) {
            return HELLENIUM_KINGDOM_FLAG_TEXTURE;
    }

    @Override
    public RenderType getRenderType(HelleniumKingdomFlagEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}
