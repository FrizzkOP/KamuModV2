package net.frizzkop.kamumod.item.custom;

import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GrinderItem extends Item {
    public GrinderItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        int count = pPlayer.getItemInHand(InteractionHand.OFF_HAND).getCount();

        if(pPlayer.getItemInHand(InteractionHand.OFF_HAND).getItem() == ModItems.WEED_BUD.get()) {
            if(count == 1){
                pPlayer.setItemInHand(InteractionHand.OFF_HAND,new ItemStack(ModItems.GRINDED_WEED.get()));
            }else if (pPlayer.getInventory().add(new ItemStack(ModItems.GRINDED_WEED.get(), 1)) == false) {
                pPlayer.drop(new ItemStack(ModItems.GRINDED_WEED.get()), true);

            }

            if(count != 1){
                pPlayer.getItemInHand(InteractionHand.OFF_HAND).setCount(count - 1);
            }
            pPlayer.playSound(SoundEvents.GRINDSTONE_USE, 0.6f,1.0f);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
