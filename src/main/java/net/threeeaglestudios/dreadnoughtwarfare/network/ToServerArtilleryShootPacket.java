package net.threeeaglestudios.dreadnoughtwarfare.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class ToServerArtilleryShootPacket {

    // handler function uses a context supplier instead
    // it is the same as what you had before except I added the contextSupplier.get() line
    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        ServerPlayer player = context.getSender();
        if (player == null)
            return;

        ServerLevel level = player.serverLevel();
        BlockPos position = player.blockPosition();

        public static void execute(Entity entity) {
            if (entity == null)
                return;
            if (true) {
                {
                    Entity _shootFrom = entity;
                    Level projectileLevel = _shootFrom.level();
                    if (!projectileLevel.isClientSide()) {
                        Projectile _entityToSpawn = new Object() {
                            public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                                AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
                                entityToSpawn.setBaseDamage(damage);
                                entityToSpawn.setKnockback(knockback);
                                entityToSpawn.setPierceLevel(piercing);
                                entityToSpawn.setSecondsOnFire(100);
                                return entityToSpawn;
                            }
                        }.getArrow(projectileLevel, 5, 100, (byte) 10);
                        _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                        _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                    }
                }
            }
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