package com.legends.edumia.world.worldgen.trees.treedecorators;

import com.legends.edumia.world.worldgen.trees.EdumiaTreeDecoratorTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class HangingBranchDecorator extends TreeDecorator {
    public static final Codec<HangingBranchDecorator> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(decorator -> decorator.probability),
                            BlockStateProvider.TYPE_CODEC.fieldOf("head_provider").forGetter(decorator -> decorator.headProvider),
                            BlockStateProvider.TYPE_CODEC.fieldOf("body_provider").forGetter(decorator -> decorator.bodyProvider))
                    .apply(instance, HangingBranchDecorator::new));
    private final float probability;
    private final BlockStateProvider headProvider;
    private final BlockStateProvider bodyProvider;

    public HangingBranchDecorator(float probability, BlockStateProvider headProvider, BlockStateProvider bodyProvider) {
        this.probability = probability;
        this.headProvider = headProvider;
        this.bodyProvider = bodyProvider;
    }
    @Override
    protected TreeDecoratorType<?> getType() {
        return EdumiaTreeDecoratorTypes.HANGING_BRANCH_DECORATOR;
    }

    @Override
    public void generate(Generator generator) {
        for (BlockPos leafPos : Util.copyShuffled(generator.getLeavesPositions(), generator.getRandom())) {
            BlockPos branchPos = leafPos.offset(Direction.DOWN);
            int height = generator.getRandom().nextBetween(1, 6);
            if (generator.isAir(branchPos) && generator.getRandom().nextFloat() < this.probability) {
                placeBranchColumn(generator, branchPos, height);
            }
        }
    }

    private void placeBranchColumn(Generator generator, BlockPos pPos, int pHeight) {
        for (int i = 0; i < pHeight; ++i) {
            BlockPos blockPos = pPos.offset(Direction.DOWN, i);
            if (!generator.isAir(blockPos.down())) {
                generator.replace(blockPos, headProvider.get(generator.getRandom(), blockPos));
                break;
            }
            generator.replace(blockPos, bodyProvider.get(generator.getRandom(), blockPos));
        }
    }
}
