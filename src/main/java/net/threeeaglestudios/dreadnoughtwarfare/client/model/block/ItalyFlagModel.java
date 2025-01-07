//package net.threeeaglestudios.dreadnoughtwarfare.client.model.block;
//
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.client.event.EntityRenderersEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
//import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlockEntities;
//import net.threeeaglestudios.dreadnoughtwarfare.block.entity.HelleniumKingdomFlagEntity;
//import net.threeeaglestudios.dreadnoughtwarfare.block.entity.ItalyFlagEntity;
//import net.threeeaglestudios.dreadnoughtwarfare.client.renderer.block.HelleniumKingdomFlagRenderer;
//import software.bernie.geckolib.model.DefaultedBlockGeoModel;
//
//public class ItalyFlagModel extends DefaultedBlockGeoModel<ItalyFlagEntity> {
//    private final ResourceLocation ITALY_FLAG_MODEL = buildFormattedModelPath(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "italy_flag"));
//    private final ResourceLocation ITALY_FLAG_TEXTURE = buildFormattedTexturePath(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "italy_flag"));
//    private final ResourceLocation ITALY_FLAG_ANIMATIONS = buildFormattedAnimationPath(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "italy_flag"));
//
//    public ItalyFlagModel() {
//        super(new ResourceLocation(DreadnoughtWarfare.MOD_ID, "italy_flag"));
//    }
//    @Override
//    public ResourceLocation getAnimationResource(ItalyFlagEntity animatable) {
//        return ITALY_FLAG_ANIMATIONS;
//    }
//
//    @Override
//    public ResourceLocation getModelResource(ItalyFlagEntity animatable) {
//        return ITALY_FLAG_MODEL;
//    }
//    @Override
//    public ResourceLocation getTextureResource(ItalyFlagEntity animatable) {
//        return ITALY_FLAG_TEXTURE;
//    }
//
//    @Override
//    public RenderType getRenderType(ItalyFlagEntity animatable, ResourceLocation texture) {
//        return RenderType.entityTranslucent(getTextureResource(animatable));
//    }
//}
