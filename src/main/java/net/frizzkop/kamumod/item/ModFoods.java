package net.frizzkop.kamumod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties WEED_BROWNIE = new FoodProperties.Builder().nutrition(8).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,400), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,600), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION,100), 1.0f)

            .build();
    public static final FoodProperties HALF_WEED_BROWNIE = new FoodProperties.Builder().nutrition(4).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,300), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,600), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION,100), 1.0f)
            .build();

    public static final FoodProperties WEED_BROWNIE_DOUGH = new FoodProperties.Builder().nutrition(3).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,300), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,600), 1.0f)
            .build();

    public static final FoodProperties ALUCINOGEN_MUSHROOMS = new FoodProperties.Builder().nutrition(3).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION,300), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS,200), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,400), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER,600), 0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION,300), 1.0f)
            .alwaysEat()
            .build();
}
