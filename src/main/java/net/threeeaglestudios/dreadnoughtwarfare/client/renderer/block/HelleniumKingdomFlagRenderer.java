package net.threeeaglestudios.dreadnoughtwarfare.client.renderer.block;

import net.threeeaglestudios.dreadnoughtwarfare.block.entity.HelleniumKingdomFlagEntity;
import net.threeeaglestudios.dreadnoughtwarfare.client.model.block.HelleniumKingdomFlagModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HelleniumKingdomFlagRenderer extends GeoBlockRenderer<HelleniumKingdomFlagEntity> {
    public HelleniumKingdomFlagRenderer() {
        super(new HelleniumKingdomFlagModel());
    }
}