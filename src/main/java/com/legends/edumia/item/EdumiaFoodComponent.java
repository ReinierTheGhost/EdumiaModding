package com.legends.edumia.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class EdumiaFoodComponent {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(2).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().hunger(4).build();
    public static final FoodComponent RICE_BALL = new FoodComponent.Builder().hunger(4).build();
    public static final FoodComponent RED_GRAPES = new FoodComponent.Builder().hunger(2).build();
    public static final FoodComponent LETTUCE = new FoodComponent.Builder().hunger(3).build();
    public static final FoodComponent RAMEN_VEGI = new FoodComponent.Builder().hunger(8).build();
    public static final FoodComponent RAMEN_SHRIMPS = new FoodComponent.Builder().hunger(9).build();
    public static final FoodComponent RAMEN_PORK = new FoodComponent.Builder().hunger(10).build();
    public static final FoodComponent RAMEN_BEEF = new FoodComponent.Builder().hunger(10).build();
    public static final FoodComponent RAMEN = new FoodComponent.Builder().hunger(8).build();
    public static final FoodComponent PAPRIKA = new FoodComponent.Builder().hunger(3).build();
    public static final FoodComponent BROCCOLI = new FoodComponent.Builder().hunger(3).build();
    public static final FoodComponent BANANA = new FoodComponent.Builder().hunger(2).saturationModifier(2f).build();
    public static final FoodComponent BANANA_BREAD = new FoodComponent.Builder().hunger(5).saturationModifier(6f).build();
    public static final FoodComponent MANGO = new FoodComponent.Builder().hunger(4).saturationModifier(2.4F).build();
    public static final FoodComponent DATE = new FoodComponent.Builder().hunger(2).saturationModifier(1.2f).build();
}
