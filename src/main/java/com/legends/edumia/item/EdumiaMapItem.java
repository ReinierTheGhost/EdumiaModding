package com.legends.edumia.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import com.legends.edumia.client.screens.EdumiaMapScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EdumiaMapItem extends Item {
    public EdumiaMapItem(Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(world.isClient) {
            if (mc.currentScreen == null) {
                mc.setScreen(new EdumiaMapScreen());
            }
        }
        return super.use(world, user, hand);
    }
}
