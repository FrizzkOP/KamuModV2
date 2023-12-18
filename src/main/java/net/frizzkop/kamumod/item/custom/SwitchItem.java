package net.frizzkop.kamumod.item.custom;


import net.frizzkop.kamumod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static net.frizzkop.kamumod.block.custom.SwitchDockBlock.FACING;


public class SwitchItem extends Item {
    public SwitchItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        Block block = level.getBlockState(blockPos).getBlock();
        ItemStack itemstack = player.getItemInHand(InteractionHand.MAIN_HAND);

        if(block.equals(ModBlocks.SWITCH_DOCK.get())){
            Direction direction = level.getBlockState(blockPos).getValue(FACING);
            itemstack.shrink(1);
            level.setBlock(blockPos, ModBlocks.DOCKED_SWITCH.get().defaultBlockState().setValue(FACING, direction), 2);
            player.playSound(SoundEvents.ITEM_PICKUP, 1, 1);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }
}
