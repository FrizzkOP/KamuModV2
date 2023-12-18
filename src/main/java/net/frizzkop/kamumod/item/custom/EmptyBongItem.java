package net.frizzkop.kamumod.item.custom;


import net.frizzkop.kamumod.block.ModBlocks;
import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static net.frizzkop.kamumod.block.custom.EmptyBongBlock.FACING;

public class EmptyBongItem extends BlockItem {


    public EmptyBongItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    /*
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        BlockPos bPos = pContext.getClickedPos().above();
        Direction clickedFace = pContext.getClickedFace();
        Block block = level.getBlockState(bPos).getBlock();

        if(!level.isClientSide) {
            if (player.isCrouching() && clickedFace.equals(Direction.UP) && block.equals(Blocks.AIR)) {
                level.setBlock(bPos, ModBlocks.EMPTY_BONG.get().defaultBlockState().setValue(FACING, pContext.getHorizontalDirection()), 3);
                player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
    */

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if(pPlayer.getItemInHand(InteractionHand.OFF_HAND).getItem().equals(ModItems.GRINDED_WEED.get())){
            pPlayer.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.FILLED_BONG.get()));
            pPlayer.getItemInHand(InteractionHand.OFF_HAND).shrink(1);
            pPlayer.playSound(SoundEvents.ARMOR_EQUIP_LEATHER);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
