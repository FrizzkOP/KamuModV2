package net.frizzkop.kamumod.item.custom;


import net.frizzkop.kamumod.block.ModBlocks;
import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static net.frizzkop.kamumod.block.custom.EmptyBongBlock.FACING;

public class FilledBongItem extends Item {
    public FilledBongItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        if(!pLevel.isClientSide) {
            if (pLivingEntity instanceof Player pPlayer) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER,800));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION,400));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,100));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION,300));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.LEVITATION,200));

                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.EMPTY_BONG.get()));
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
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        BlockPos bPos = pContext.getClickedPos().above();
        Direction clickedFace = pContext.getClickedFace();
        Block block = level.getBlockState(bPos).getBlock();
        int count = player.getItemInHand(InteractionHand.MAIN_HAND).getCount();


        if (player.isCrouching() && clickedFace.equals(Direction.UP) && block.equals(Blocks.AIR)) {
            level.setBlock(bPos, ModBlocks.FILLED_BONG.get().defaultBlockState().setValue(FACING, pContext.getHorizontalDirection()), 1);
            player.getItemInHand(InteractionHand.MAIN_HAND).setCount(count - 1);
            player.playSound(SoundEvents.GLASS_PLACE, 1.0f, 1.0f);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        if(pPlayer.getItemInHand(InteractionHand.OFF_HAND).getItem().equals(ModItems.LIGHTER.get())) {
            pPlayer.startUsingItem(pHand);
            pPlayer.playSound(SoundEvents.FIRE_AMBIENT, 0.5F, 1.0F);
        }else{
            pPlayer.displayClientMessage(Component.literal("Necesitas un mechero para usar el bong"), true);
        }

        return InteractionResultHolder.consume(itemstack);
    }
}
