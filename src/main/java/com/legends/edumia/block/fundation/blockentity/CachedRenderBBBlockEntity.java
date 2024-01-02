package com.legends.edumia.block.fundation.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class CachedRenderBBBlockEntity extends SyncedBlockEntity{
    public CachedRenderBBBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
