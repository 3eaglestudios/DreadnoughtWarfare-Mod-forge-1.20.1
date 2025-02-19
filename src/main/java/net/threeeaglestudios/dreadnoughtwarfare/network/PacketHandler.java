package net.threeeaglestudios.dreadnoughtwarfare.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;

public class PacketHandler {

    private static final String PROTOCOL_VERSION = "1.0";

    public static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(
                    new ResourceLocation(DreadnoughtWarfare.MOD_ID, "main"))
            .serverAcceptedVersions(version -> true)
            .clientAcceptedVersions(version -> true)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    public static void register() {
        int index = 0; // each packet is registered with a unique integer id (index)
        INSTANCE.messageBuilder(ToServerArtilleryShootPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ToServerArtilleryShootPacket::encode)
                .decoder(ToServerArtilleryShootPacket::new)
                .consumerMainThread(ToServerArtilleryShootPacket::handle)
                .add();
    }
}