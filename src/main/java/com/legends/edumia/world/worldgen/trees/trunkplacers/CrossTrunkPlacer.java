package com.legends.edumia.world.worldgen.trees.trunkplacers;

import com.legends.edumia.world.worldgen.trees.EdumiaTrunkPlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class CrossTrunkPlacer extends TrunkPlacer
{
    public static final Codec<CrossTrunkPlacer> CODEC = RecordCodecBuilder
            .create((instance) -> fillTrunkPlacerFields(instance)
                    .and(IntProvider.createValidatingCodec(0, 8).fieldOf("branch")
                            .forGetter((placerInstance2) -> placerInstance2.branchLength))
                    .and(IntProvider.createValidatingCodec(0, 8).fieldOf("branch_offset")
                            .forGetter((placerInstance2) -> placerInstance2.branchTopOffset))
                    .and(IntProvider.createValidatingCodec(-6, 5).fieldOf("crown_offset")
                            .forGetter((placerInstance2) -> placerInstance2.crownOffset))
                    .and(Codec.BOOL.fieldOf("leaves_at_end")
                            .forGetter((placerInstance2) -> placerInstance2.leavesAtEnd))
                    .apply(instance, CrossTrunkPlacer::new));

    private final IntProvider branchLength;
    private final IntProvider branchTopOffset;
    private final IntProvider crownOffset;
    private final boolean leavesAtEnd;

    public CrossTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, IntProvider branchLength, IntProvider branchTopOffset, IntProvider crownOffset, boolean leavesAtEnd)
    {
        super(baseHeight, heightRandA, heightRandB);
        this.branchLength = branchLength;
        this.branchTopOffset = branchTopOffset;
        this.crownOffset = crownOffset;
        this.leavesAtEnd = leavesAtEnd;
    }

    @Override
    protected TrunkPlacerType<?> getType()
    {
        return EdumiaTrunkPlacerTypes.CROSS_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld reader, BiConsumer<BlockPos, BlockState> blockConsumer, Random random, int height, BlockPos startPos, TreeFeatureConfig config)
    {
        setToDirt(reader, blockConsumer, random, startPos.down(), config);
        List<FoliagePlacer.TreeNode> foliages = new ArrayList<>();

        int crownHeightOffset = crownOffset.get(random);

        int[] branchOffsets = new int[]{
                this.branchTopOffset.get(random),
                this.branchTopOffset.get(random),
                this.branchTopOffset.get(random),
                this.branchTopOffset.get(random)
        };
        for (int i = 0; i < height; ++i)
        {
            getAndSetState(reader, blockConsumer, random, startPos.up(i), config);
            for (Direction dir : Direction.Type.HORIZONTAL)
            {
                if (i + 1 + branchOffsets[dir.getHorizontal()] == height)
                {
                    int thisBranchLen = this.branchLength.get(random);
                    for (int branch = 1; branch <= thisBranchLen; branch++)
                    {
                        BlockPos p = startPos.up(i).offset(dir, branch);
                        getAndSetState(reader, blockConsumer, random, p, config, state -> state.with(PillarBlock.AXIS, dir.getAxis()));
                        if (branch == thisBranchLen && this.leavesAtEnd)
                        {
                            foliages.add(new FoliagePlacer.TreeNode(p.up(crownHeightOffset), 0, false));
                        }
                    }
                }
            }
        }

        foliages.add(new FoliagePlacer.TreeNode(startPos.up(height + crownHeightOffset - 1), 0, false));
        return foliages;
    }
}
