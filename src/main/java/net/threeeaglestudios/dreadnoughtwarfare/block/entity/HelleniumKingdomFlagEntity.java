package net.threeeaglestudios.dreadnoughtwarfare.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlockEntities;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlocks;
import software.bernie.example.registry.BlockEntityRegistry;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class HelleniumKingdomFlagEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    // We statically instantiate our RawAnimations for efficiency, consistency, and error-proofing
    private static final RawAnimation HELLENIUM_KINGDOM_FLAG_ANIMS = RawAnimation.begin().thenLoop("hellenium_kingdom_flag");

    public HelleniumKingdomFlagEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HELLENIUM_KINGDOM_FLAG.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> {
                return state.setAndContinue(HELLENIUM_KINGDOM_FLAG_ANIMS);
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}