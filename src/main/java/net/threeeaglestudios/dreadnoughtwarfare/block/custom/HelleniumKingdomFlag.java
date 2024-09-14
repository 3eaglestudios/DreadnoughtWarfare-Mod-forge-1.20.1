package net.threeeaglestudios.dreadnoughtwarfare.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import javax.annotation.Nullable;

import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlockEntities;
import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlocks;
import software.bernie.example.registry.BlockEntityRegistry;

public class HelleniumKingdomFlag extends Block implements EntityBlock {

    public HelleniumKingdomFlag(Properties p_52591_) {
        super(p_52591_);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.HELLENIUM_KINGDOM_FLAG.get().create(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(FACING);
//    }
//
//    @Nullable
//    @Override
//    public BlockState getStateForPlacement(BlockPlaceContext context) {
//        return defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
//    }

}