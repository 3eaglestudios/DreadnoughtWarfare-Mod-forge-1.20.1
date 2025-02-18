package net.threeeaglestudios.dreadnoughtwarfare.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;

public class PacketHandler {
    public static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(
            new ResourceLocation(DreadnoughtWarfare.MOD_ID, "main"))
            .serverAcceptedVersions(version -> true)
            .clientAcceptedVersions(version -> true)
            .simpleChannel();

    public static void register() {
        INSTANCE.messageBuilder(ToServerArtilleryShootPacket.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ToServerArtilleryShootPacket::encode)
                .decoder(ToServerArtilleryShootPacket::new)
                .consumerMainThread(ToServerArtilleryShootPacket::handle)
                .add();

    }
}
