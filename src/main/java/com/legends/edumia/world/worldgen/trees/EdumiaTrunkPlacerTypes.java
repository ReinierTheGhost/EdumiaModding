package com.legends.edumia.world.worldgen.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.mixin.TrunkPlacerTypeInvoker;
import com.legends.edumia.utils.cliient.NamedRenderTypeManager;
import com.legends.edumia.world.worldgen.trees.foliageplacer.OakFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class EdumiaTrunkPlacerTypes {
    public static final TrunkPlacerType<?> BOUGHS_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("boughs_trunk_placer", BoughsTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> CEDER_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("ceder_trunk_placer", CederTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> EDUMIA_GIANT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("edumia_giant_trunk_placer",
            EdumiaGiantTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> GOLDEN_OAK_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("golden_oak_trunk_placer",
            GoldenOakTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> DEATH_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("death_trunk_placer",
            DeadTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> DESERT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("desert_trunk_placer",
            DesertTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> OAK_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("oak_trunk_placer",
            OakTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> PARTY_TREE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("party_tree_trunk_placer",
            PartyTreeTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> SMALL_REDWOOD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("small_redwood_trunk_placer",
            SmallRedwoodTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> MEDIUM_REDWOOD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("medium_redwood_trunk_placer",
            MediumRedwoodTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> PALM_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("palm_trunk_placer",
            PalmTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> CROSS_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("cross_trunk_placer",
            CrossTrunkPlacer.CODEC);

    public static void register() {
        Edumia.LOGGER.info("Registering Trunk Placers for " + Edumia.MOD_ID);
    }

    public static void setGrassToDirt(TestableWorld world, BlockPos groundPos) {
        if (world.testBlockState(groundPos, (state) -> {
            return state.isOf(Blocks.GRASS_BLOCK) || state.isOf(Blocks.MYCELIUM);
        })){
            TreeFeature.setBlockStateWithoutUpdatingNeighbors((ModifiableWorld) world, groundPos, Blocks.DIRT.getDefaultState());
        }
    }

}
