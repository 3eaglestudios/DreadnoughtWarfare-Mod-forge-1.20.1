package net.threeeaglestudios.dreadnoughtwarfare.event;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;
import net.threeeaglestudios.dreadnoughtwarfare.entity.custom.ArtilleryEntity;
import net.threeeaglestudios.dreadnoughtwarfare.network.PacketHandler;

@Mod.EventBusSubscriber(modid = DreadnoughtWarfare.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class ClientInputEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void clientTickPilotControl(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;

        Minecraft mc = Minecraft.getInstance();
        final var player = mc.player;
        if (player == null) return;
        if (!player.isPassenger() || !(player.getRootVehicle() instanceof ArtilleryEntity artillery)) return;
        Entity controller = artillery.getControllingPassenger();
        if (controller == null || !controller.equals(player)) return;

        if (mc.mouseHandler.isRightPressed()) {
            PacketHandler.INSTANCE.sendToServer(new ToServerArtilleryShootPacket(artillery)); // this may be different based on the tutorial video I sent.
        }
    }
}