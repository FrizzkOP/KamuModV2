package net.frizzkop.kamumod.item.custom;


import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class PorritoHachisItem extends Item {
    public PorritoHachisItem (Properties pProperties){
        super(pProperties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        if(!pLevel.isClientSide) {
            if (pLivingEntity instanceof Player pPlayer) {
                pStack.hurtAndBreak(1, pPlayer, player -> player.broadcastBreakEvent(pPlayer.getUsedItemHand()));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER,800));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION,300));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,700));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,1200));

                pPlayer.getItemInHand(InteractionHand.OFF_HAND).hurtAndBreak(1,pPlayer, player -> player.broadcastBreakEvent(InteractionHand.OFF_HAND));
            }
        }
        for(int i = 0 ; i < 10 ; i++) {
            pLevel.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pLivingEntity.getX(), pLivingEntity.getY() + 2, pLivingEntity.getZ(), 0, 0.02d, 0.02d);
        }

        pLivingEntity.playSound(SoundEvents.FIRE_EXTINGUISH, 0.5F, 1.0F);
        return pStack;
    }


    // Define el tiempo que tiene que estar usandose
    public int getUseDuration(ItemStack pStack) {
        return 35;
    }

    // Define que animacion va a usar
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        if(pPlayer.getItemInHand(InteractionHand.OFF_HAND).getItem().equals(ModItems.LIGHTER.get())) {
            pPlayer.startUsingItem(pHand);
            pPlayer.playSound(SoundEvents.FIRE_AMBIENT, 0.5F, 1.0F);
        }else{
            pPlayer.displayClientMessage(Component.literal("Necesitas un mechero para encenderte el porrito"), true);
        }

        return InteractionResultHolder.pass(itemstack);
    }
}
