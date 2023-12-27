package com.legends.edumia.block;

import com.legends.edumia.block.directional.HalfDirectional;
import com.legends.edumia.block.properties.BlockVoxelShapes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ArchTwoMeter extends HalfDirectional {
    public ArchTwoMeter(Settings properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state) {
        if (state.get(TYPE_UPDOWN) == BlockHalf.BOTTOM) {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return  BlockVoxelShapes.stairBottomShapes.get(0);
                case EAST:
                    return BlockVoxelShapes.stairBottomShapes.get(1);
                case SOUTH:
                    return BlockVoxelShapes.stairBottomShapes.get(2);
                case WEST:
                    return BlockVoxelShapes.stairBottomShapes.get(3);
            }
        } else {
            switch (state.get(DIRECTION)) {
                case NORTH:
                default:
                    return BlockVoxelShapes.stairTopShapes.get(0);
                case EAST:
                    return BlockVoxelShapes.stairTopShapes.get(1);
                case SOUTH:
                    return BlockVoxelShapes.stairTopShapes.get(2);
                case WEST:
                    return BlockVoxelShapes.stairTopShapes.get(3);
            }
        }
    }

    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }
}
