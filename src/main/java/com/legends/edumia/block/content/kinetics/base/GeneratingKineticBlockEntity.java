package com.legends.edumia.block.content.kinetics.base;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class GeneratingKineticBlockEntity extends KineticBlockEntity{
    public GeneratingKineticBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
