package com.legends.edumia.item;

import com.legends.edumia.world.dimension.ModDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WorldTeleporterItem extends Item {
    public WorldTeleporterItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!ModDimensions.isInEdumia(world)) {
            if (!user.isCreative()) {
                //user.getInventory().removeStack(user.getActiveHand().ordinal());
                user.getStackInHand(hand).decrement(1);
            }
            ModDimensions.teleportPlayerToME(user);
        }
        return super.use(world, user, hand);
    }
}
