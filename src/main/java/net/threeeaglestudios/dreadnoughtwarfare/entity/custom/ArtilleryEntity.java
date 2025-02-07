package net.threeeaglestudios.dreadnoughtwarfare.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ArtilleryEntity extends Entity {
    public  final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public ArtilleryEntity(EntityType<? extends Entity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createAttributes().add(Attributes.MAX_HEALTH, 50D)
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
        } else if (level().isClientSide) {
            if (player.isPassenger()) return InteractionResult.PASS;
            if (player.startRiding(this)) return InteractionResult.CONSUME;
            return InteractionResult.PASS;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public LivingEntity getControllingPassenger() {
        if (getPassengers().size() > 0) return getPassengers().get(0).getControllingPassenger();
        else return null;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();
        followControllerHead();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

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

}
