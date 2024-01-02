package com.legends.edumia.block.content.kinetics.base;

import com.legends.edumia.block.fundation.blockentity.SmartBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class KineticBlockEntity extends SmartBlockEntity {
    public KineticBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
