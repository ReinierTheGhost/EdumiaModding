package com.legends.edumia.block;

import com.legends.edumia.block.base.WaterloggedBidirectionalShape;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import javax.swing.text.html.BlockView;

public class ArchSmall extends WaterloggedBidirectionalShape {
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);

    public ArchSmall(Settings properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    public VoxelShape getOcclusionShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }
}
