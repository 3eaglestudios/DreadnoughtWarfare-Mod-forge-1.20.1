package net.threeeaglestudios.dreadnoughtwarfare.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlockEntities;
import net.threeeaglestudios.dreadnoughtwarfare.client.renderer.block.HelleniumKingdomFlagRenderer;

@Mod.EventBusSubscriber(modid = DreadnoughtWarfare.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public final class RendererReg {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.HELLENIUM_KINGDOM_FLAG.get(), HelleniumKingdomFlagRenderer::new);
    }
}