package com.legends.edumia.block.content.contraptions.bearing;

import com.legends.edumia.block.content.kinetics.base.GeneratingKineticBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class MechanicalBearingBlockEntity extends GeneratingKineticBlockEntity {


    protected boolean running;
    protected boolean assembleNextTick;
    public MechanicalBearingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void disassemble() {
    }
}
