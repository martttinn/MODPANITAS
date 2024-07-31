package net.martin.panitasMod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    // PROPIEDADES DE LA SETA
    public static final FoodProperties SETA_PROPERTIES = new FoodProperties.Builder().nutrition(5).saturationMod(4.0f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION,3000,20),0.032f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,2000,20),0.032f).effect(() -> new MobEffectInstance(MobEffects.WEAKNESS,2000,3),0.032f).build();

    // PROPIEDADES DEL BLUNT
    public static final FoodProperties BLUNT_PROPERTIES = new FoodProperties.Builder().nutrition(2).saturationMod(0.5f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.HUNGER,1500,20),1.00f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,1500,4),1.00f).build();
}

