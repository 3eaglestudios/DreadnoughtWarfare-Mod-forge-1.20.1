package net.threeeaglestudios.dreadnoughtwarfare.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ArtilleryEntity extends Entity {

    public static final EntityDataAccessor<Integer> SHOOT_TICKS = SynchedEntityData.defineId(ArtilleryEntity.class, EntityDataSerializers.INT);

    protected int lastShootInputTick = 0, lastShootTick = 0;

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public ArtilleryEntity(EntityType<? extends Entity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createAttributes().add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.ARMOR_TOUGHNESS, 1F)
                .add(Attributes.MOVEMENT_SPEED, 0.0);
    }

    private void setIdleAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else if (!level().isClientSide()) {
            if (player.isPassenger()) return InteractionResult.PASS;
            if (player.startRiding(this)) return InteractionResult.CONSUME;
            return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public LivingEntity getControllingPassenger() {
        if (!getPassengers().isEmpty() && getPassengers().get(0) instanceof LivingEntity entity) {
            return entity;
        } else {
            return null;
        }
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(SHOOT_TICKS, 0);
    }

    @Override
    public void tick() {
        super.tick();
        followControllerHead();
        tickShoot();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        setShootTicks(compoundTag.getInt("shootTicks"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt("shootTicks", getShootTicks());
    }

    protected void followControllerHead() {
        Entity controller = getControllingPassenger();
        if (controller == null) return;
        float newYRot = rotLerp(this.getYRot(), controller.getYRot(), getTurnRate());
        float newXRot = rotLerp(this.getXRot(), controller.getXRot(), getTurnRate());
        this.setYRot(newYRot);
        this.setXRot(newXRot);
    }

    public float getTurnRate() {
        return 0.5f;
    }

    public static float rotLerp(float currentAngle, float targetAngle, float stepSize) {
        float f = Mth.wrapDegrees(targetAngle - currentAngle);
        if (f > stepSize) f = stepSize;
        if (f < -stepSize) f = -stepSize;
        return currentAngle + f;
    }

    public static boolean doesPlayerHaveAnArrow(ServerPlayer player) {
        return player.gameMode.isCreative() || player.getInventory().hasAnyMatching(stack -> stack.is(ItemTags.ARROWS));
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

    /**
     * this function is called from {@link net.threeeaglestudios.dreadnoughtwarfare.network.ToServerArtilleryShootPacket#handle(Supplier)}
     * it updates {@link #lastShootInputTick}
     */
    public void onShootInput(@NotNull ServerPlayer player) {
        lastShootInputTick = tickCount;
        if (timingsAllowShoot()) onShoot(player);
    }

    /**
     * @return true if the player has been shooting for longer than the {@link #getInitialShootDelay()} which
     * can be thought of as "charge time". then it checks if it can shoot at the fire rate.
     */
    public boolean timingsAllowShoot() {
        int shootTicks = getShootTicks();
        if (shootTicks < getInitialShootDelay()) {
            return false;
        }
        shootTicks -= getInitialShootDelay();
        return shootTicks % getShootRate() == 0;
    }

    public void onShoot(@NotNull ServerPlayer player) {
        if (!doesPlayerHaveAnArrow(player)) {// check if the player has any arrows
            return;
        }
        shootArrow(this);
        if (player.gameMode.isSurvival()) consumeAnArrow(player);
        lastShootTick = tickCount;
    }

    /**
     * called in the {@link #tick()} function every tick on the server side.
     * if the player is shooting it increments the shoot ticks counter.
     * if the player isn't shooting then it resets the counter to zero.
     */
    public void tickShoot() {
        if (level().isClientSide()) {
            return;
        }
        if (isShooting()) {
            setShootTicks(getShootTicks() + 1);
        } else {
            setShootTicks(0);
        }
    }

    public int getShootTicks() {
        return entityData.get(SHOOT_TICKS);
    }

    public void setShootTicks(int ticks) {
        entityData.set(SHOOT_TICKS, ticks);
    }

    public boolean isShooting() {
        return tickCount - lastShootInputTick < getIsShootingBuffer();
    }

    /**
     * @return how long after a shoot input isn't received before shooting stops.
     * I have it set to 10 because it can take up to 10 ticks for a packet to be sent from server to client.
     * But it could be increased if shoot inputs get lost when playing on a laggy server.
     */
    public int getIsShootingBuffer() {
        return 10;
    }

    /**
     * @return time in ticks player has to hold down right click before shooting starts
     */
    public int getInitialShootDelay() {
        return 2;
    }

    /**
     * @return time in ticks in between shots
     */
    public int getShootRate() {
        return 40;
    }

}
