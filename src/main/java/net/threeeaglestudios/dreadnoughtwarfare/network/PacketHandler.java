package net.threeeaglestudios.dreadnoughtwarfare.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.threeeaglestudios.dreadnoughtwarfare.DreadnoughtWarfare;

public class PacketHandler {
    public static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(
            new ResourceLocation(DreadnoughtWarfare.MOD_ID, "main"))
            .serverAcceptedVersions(status, version -> true)
            .clientAcceptedVersions(status, version -> true)
            .networkProtocolVersion(1)
            .simpleChannel();

    public static void register() {

    }
}
