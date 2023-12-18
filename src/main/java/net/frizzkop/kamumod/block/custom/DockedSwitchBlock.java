package net.frizzkop.kamumod.block.custom;

import net.frizzkop.kamumod.block.ModBlocks;
import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static net.frizzkop.kamumod.block.custom.SwitchDockBlock.FACING;

public class DockedSwitchBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(3,0,3, 13, 5, 13);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public DockedSwitchBlock(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        Direction direction = pLevel.getBlockState(pPos).getValue(FACING);
        if(pPlayer.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()){
            pPlayer.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SWITCH.get()));
            pLevel.setBlock(pPos, ModBlocks.SWITCH_DOCK.get().defaultBlockState().setValue(FACING, direction), 2);

        }else if(!pPlayer.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()){
            if(!pPlayer.getInventory().add(new ItemStack(ModItems.SWITCH.get()))) {
                pPlayer.drop(new ItemStack(ModItems.SWITCH.get()), false);
            }

            pLevel.setBlock(pPos, ModBlocks.SWITCH_DOCK.get().defaultBlockState().setValue(FACING, direction), 2);
        }

        pPlayer.playSound(SoundEvents.ITEM_PICKUP,1 ,1);
        return InteractionResult.SUCCESS;
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
