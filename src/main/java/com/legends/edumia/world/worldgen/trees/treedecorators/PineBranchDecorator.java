package com.legends.edumia.world.worldgen.trees.treedecorators;

import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.block.EdumiaBlockStates;
import com.legends.edumia.world.worldgen.trees.EdumiaTreeDecoratorTypes;
import com.legends.edumia.world.worldgen.trees.foliageplacer.PinusFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class PineBranchDecorator extends TreeDecorator {

    public static final Codec<PineBranchDecorator> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(BlockStateProvider.TYPE_CODEC.fieldOf("wood_provider").forGetter((deco) ->
                            deco.woodProvider),
                    Codec.floatRange(0.0f, 1.0f).fieldOf("probability").forGetter((deco) ->
                            deco.probability)
            ).apply(instance, PineBranchDecorator::new));

    private final BlockStateProvider woodProvider;
    private final float probability;

    protected PineBranchDecorator(BlockStateProvider woodProvider, float probability) {
        this.woodProvider = woodProvider;
        this.probability = probability;
    }

    public PineBranchDecorator(BlockState log, float probability){
        this(BlockStateProvider.of(log), probability);
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return EdumiaTreeDecoratorTypes.PINE_BRANCH_DECORATOR;
    }

    @Override
    public void generate(Generator generator) {
        ObjectArrayList<BlockPos> list = generator.getLogPositions();
        Random random = generator.getRandom();
        TestableWorld world = generator.getWorld();
        int baseY = (list.get(0)).getY();
        int trunkHeight = list.size();
        Direction[] lastDir = new Direction[1];
        list.stream().filter(pos ->{
            int diff = pos.getY() - baseY;
            return diff >= 3 && diff < trunkHeight - 3;
                }).forEach(pos -> {
                    if (random.nextFloat() < this.probability){
                        Direction dir = Direction.Type.HORIZONTAL.random(random);
                        if (dir != lastDir[0]){
                            lastDir[0] = dir;
                            BlockPos branchPos = pos.add(dir.getOffsetX(), 0, dir.getOffsetZ());
                            if (TreeFeature.isSoil(world, branchPos)){
                                BlockState blockState = this.woodProvider.get(random, branchPos);
                                if (blockState.getBlock() instanceof PillarBlock){
                                    blockState = blockState.with(PillarBlock.AXIS, dir.getAxis());
                                } else if (blockState.getBlock() instanceof AxialSlabBlock && blockState.contains(EdumiaBlockStates.SLAB_AXIS)) {
                                    blockState = (blockState.with(EdumiaBlockStates.SLAB_AXIS, dir.getAxis())).with(SlabBlock.TYPE, dir.getDirection() == Direction.AxisDirection.NEGATIVE ? SlabType.TOP : SlabType.BOTTOM);
                                    
                                }

                                generator.replace(branchPos, blockState);
                            }
                        }
                    }
        });
    }
}
