package net.threeeaglestudios.dreadnoughtwarfare.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

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
        if (!doesPlayerHaveAnArrow(player)) // check if the player has any arrows
            return;
        shootArrow(player);
        if (player.gameMode.isSurvival()) consumeAnArrow(player);
    }

    public static boolean doesPlayerHaveAnArrow(ServerPlayer player) {
        return player.getInventory().hasAnyMatching(stack -> stack.is(ItemTags.ARROWS));
    }

    public static void consumeAnArrow(ServerPlayer player) {
        Inventory inv = player.getInventory();
        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack stack = inv.getItem(i);
            if (!stack.is(ItemTags.ARROWS)) continue;
            stack.shrink(1);
            return; // 1 arrow consumed so exit the loop and the function
        }
    }

    public static void shootArrow(@NotNull Entity shooter) {
        Level projectileLevel = shooter.level();
        if (projectileLevel.isClientSide())
            return;
        Projectile _entityToSpawn = createArrow(projectileLevel, 5, 100, (byte) 10);
        _entityToSpawn.setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
        _entityToSpawn.shoot(shooter.getLookAngle().x, shooter.getLookAngle().y, shooter.getLookAngle().z, 5, 0);
        projectileLevel.addFreshEntity(_entityToSpawn);
    }

    public static Projectile createArrow(Level level, float damage, int knockback, byte piercing) {
        AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
        entityToSpawn.setBaseDamage(damage);
        entityToSpawn.setKnockback(knockback);
        entityToSpawn.setPierceLevel(piercing);
        entityToSpawn.setSecondsOnFire(100);
        return entityToSpawn;
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