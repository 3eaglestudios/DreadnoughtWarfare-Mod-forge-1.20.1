//package net.threeeaglestudios.dreadnoughtwarfare.block.custom;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.item.context.BlockPlaceContext;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.DirectionalBlock;
//import net.minecraft.world.level.block.EntityBlock;
//import net.minecraft.world.level.block.RenderShape;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//
//import javax.annotation.Nullable;
//
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlockEntities;
//import net.threeeaglestudios.dreadnoughtwarfare.block.ModBlocks;
//import software.bernie.example.registry.BlockEntityRegistry;
//
//public class ItalyFlag extends Block implements EntityBlock {
//
//    public ItalyFlag(Properties p_52591_) {
//        super(p_52591_);
//    }
//
//    @Nullable
//    @Override
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return ModBlockEntities.ITALY_FLAG.get().create(pos, state);
//    }
//
//    @Override
//    public RenderShape getRenderShape(BlockState state) {
//        return RenderShape.ENTITYBLOCK_ANIMATED;
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
//        return Block.box(4,0,4,12,54,12);
//    }
//
//    @Override
//    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
//        return Block.box(4,0,4,12,54,12);
//    }
//
//    @Override
//    public boolean collisionExtendsVertically(BlockState state, BlockGetter level, BlockPos pos, Entity collidingEntity) {
//        return true;
//    }
//}