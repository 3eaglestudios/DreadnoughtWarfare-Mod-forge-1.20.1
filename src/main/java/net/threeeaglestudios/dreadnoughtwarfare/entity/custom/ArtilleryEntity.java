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
import net.minecraft.world.phys.Vec3;
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

        float targetYRot = controller.getYRot();
        float newYRot = rotLerp(this.getYRot(), targetYRot, getTurnRate());

        float targetXRot = controller.getXRot();
        float newXRot = Mth.clamp(
                rotLerp(this.getXRot(), targetXRot, getTurnRate()),
                -getMaxVerticalAngle(), getMaxVerticalAngle()
        );

        this.setYRot(newYRot);
        this.setXRot(newXRot);
        this.yRotO = newYRot;
        this.xRotO = newXRot;
    }

    public float getTurnRate() {
        return 4.0f;
    }

    public Vec3 getRiderOffset() {
        return new Vec3(0.0D, 0.9D, -1.3D);
    }


    public float getMaxVerticalAngle() {
        return 45.0F;
    }

    public static float rotLerp(float currentAngle, float targetAngle, float stepSize) {
        float f = Mth.wrapDegrees(targetAngle - currentAngle);
        if (f > stepSize) f = stepSize;
        if (f < -stepSize) f = -stepSize;
        return currentAngle + f;
    }

    @Override
    protected void positionRider(Entity passenger, Entity.MoveFunction moveFunction) {
        if (!this.hasPassenger(passenger)) return;

        Vec3 offset = getRiderOffset();

        float yRotRad = (float) Math.toRadians(this.getYRot());
        double xOffset = Math.sin(-yRotRad) * offset.z() + Math.cos(yRotRad) * offset.x();
        double zOffset = Math.cos(yRotRad) * offset.z() + Math.sin(yRotRad) * offset.x();

        double riderX = this.getX() + xOffset;
        double riderY = this.getY() + offset.y();
        double riderZ = this.getZ() + zOffset;

        moveFunction.accept(passenger, riderX, riderY, riderZ);

        if (passenger instanceof LivingEntity living) {
            living.yBodyRot = this.getYRot();
        }
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
            return;
        }
    }

    public static void shootArrow(@NotNull Entity shooter) {
        Level projectileLevel = shooter.level();
        if (projectileLevel.isClientSide()) return;
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

    public void onShootInput(@NotNull ServerPlayer player) {
        lastShootInputTick = tickCount;
        if (timingsAllowShoot()) onShoot(player);
    }

    public boolean timingsAllowShoot() {
        int shootTicks = getShootTicks();
        if (shootTicks < getInitialShootDelay()) {
            return false;
        }
        shootTicks -= getInitialShootDelay();
        return shootTicks % getShootRate() == 0;
    }

    public void onShoot(@NotNull ServerPlayer player) {
        if (!doesPlayerHaveAnArrow(player)) {
            return;
        }
        shootArrow(this);
        if (player.gameMode.isSurvival()) consumeAnArrow(player);
        lastShootTick = tickCount;
    }

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

    public int getIsShootingBuffer() {
        return 10;
    }

    public int getInitialShootDelay() {
        return 2;
    }

    public int getShootRate() {
        return 40;
    }
}