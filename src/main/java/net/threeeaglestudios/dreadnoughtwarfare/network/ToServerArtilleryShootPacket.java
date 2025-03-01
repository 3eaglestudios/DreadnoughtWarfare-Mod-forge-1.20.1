package net.threeeaglestudios.dreadnoughtwarfare.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.threeeaglestudios.dreadnoughtwarfare.entity.custom.ArtilleryEntity;
import java.util.function.Supplier;

public class ToServerArtilleryShootPacket {

    // handler function uses a context supplier instead
    // it is the same as what you had before except I added the contextSupplier.get() line
    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        ServerPlayer player = context.getSender();
        if (player == null) { // sometimes packets are received with null players so cancel packet handling if it is
            return;
        }
        if (player.getRootVehicle() instanceof ArtilleryEntity artilleryEntity) {
            artilleryEntity.onShootInput(player);
        }
    }

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        // if you wanted to encode additional information in the packet use the byte buf write methods
    }

    public ToServerArtilleryShootPacket(FriendlyByteBuf friendlyByteBuf) {
        // add extra data from the encoder must be read here with the friendlyByteBuf read methods
    }

    public ToServerArtilleryShootPacket() {
        // use private final fields to store the extra data so the handler method can access them
    }
}