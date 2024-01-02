package com.legends.edumia.block.fundation.blockentity;

import com.legends.edumia.block.fundation.utility.IInteractionChecker;
import com.legends.edumia.block.fundation.utility.IPartialSafeNBT;
import com.legends.edumia.block.fundation.utility.ISpecialBlockEntityItemRequirement;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class SmartBlockEntity extends CachedRenderBBBlockEntity
        implements IPartialSafeNBT, IInteractionChecker, ISpecialBlockEntityItemRequirement {
    public SmartBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
