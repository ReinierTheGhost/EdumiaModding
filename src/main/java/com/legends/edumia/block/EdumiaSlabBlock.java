package com.legends.edumia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class EdumiaSlabBlock extends SlabBlock {


    private final Block modelBlock;

    public EdumiaSlabBlock(Block block) {
        super(Settings.copy(block));
        this.modelBlock = block;
    }

    public EdumiaSlabBlock(Supplier<Block> block){
        this(block.get());
    }

    public Block getModelBlock(){
        return this.modelBlock;
    }


    @Override
    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random rand) {
        this.modelBlock.randomDisplayTick(state, level, pos, rand);
    }
}
