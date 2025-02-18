package net.threeeaglestudios.dreadnoughtwarfare.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ToServerArtilleryShootPacket {


    public void handle(NetworkEvent.ServerCustomPayloadEvent.Context context) {
        ServerPlayer player = context.getSender();
        if (player == null)
            return;

        ServerLevel level = player.serverLevel();
        BlockPos position = player.blockPosition();

        List<Map.Entry<ResourceKey<EntityType<?>>, EntityType<?>>> entities =
                ForgeRegistries.ENTITY_TYPES.getEntries()
                        .stream()
                        .filter(entry -> entry.getValue().getBaseClass().isAssignableFrom(Arrow.class))
                        .toList();

        EntityType<?> type = entities.get(ThreadLocalRandom.current().nextInt(entities.size())).getValue();
        type.spawn(level, position, MobSpawnType.MOB_SUMMONED);
    }
}
