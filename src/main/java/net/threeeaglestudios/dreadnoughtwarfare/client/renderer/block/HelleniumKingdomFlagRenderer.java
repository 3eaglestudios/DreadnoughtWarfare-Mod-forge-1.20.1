package net.threeeaglestudios.dreadnoughtwarfare.client.renderer.block;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.threeeaglestudios.dreadnoughtwarfare.block.entity.HelleniumKingdomFlagEntity;
import net.threeeaglestudios.dreadnoughtwarfare.client.model.block.HelleniumKingdomFlagModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HelleniumKingdomFlagRenderer extends GeoBlockRenderer<HelleniumKingdomFlagEntity> {
    public HelleniumKingdomFlagRenderer(BlockEntityRendererProvider.Context context) {
        super(new HelleniumKingdomFlagModel());
    }
}