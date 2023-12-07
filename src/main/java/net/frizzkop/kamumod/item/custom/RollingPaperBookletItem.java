package net.frizzkop.kamumod.item.custom;

import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RollingPaperBookletItem extends Item {
    public RollingPaperBookletItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if(pPlayer.getInventory().add(new ItemStack(ModItems.PAPEL_RAW.get())) == false){
            pPlayer.drop(new ItemStack(ModItems.PAPEL_RAW.get()), false);
        }

        pPlayer.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, pPlayer, player -> player.broadcastBreakEvent(pPlayer.getUsedItemHand()));
        pPlayer.playSound(SoundEvents.ARMOR_EQUIP_LEATHER, 0.6f,1.0f);

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
