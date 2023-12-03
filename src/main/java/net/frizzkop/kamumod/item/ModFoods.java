package net.frizzkop.kamumod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties WEED_BROWNIE = new FoodProperties.Builder().nutrition(6).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,400), 0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,400), 0.2f)
            .build();
    public static final FoodProperties HALF_WEED_BROWNIE = new FoodProperties.Builder().nutrition(3).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,200), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,300), 0.1f)
            .build();
}
