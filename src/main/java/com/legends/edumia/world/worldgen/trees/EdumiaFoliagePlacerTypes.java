package com.legends.edumia.world.worldgen.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.mixin.FoliagePlacerTypeInvoker;
import com.legends.edumia.world.worldgen.trees.foliageplacer.*;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class EdumiaFoliagePlacerTypes {

    public static final FoliagePlacerType<?> GHOST_GUM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("ghost_gum_foliage_placer",
            GhostGumFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> ASPEN_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("aspen_foliage_placer",
            AspenFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> BOUGHS_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("boughs_foliage_placer",
            BoughsFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> CEDER_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("ceder_foliage_placer",
            CederFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> EMPTY_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("empty_foliage_placer",
            EmptyFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> CLUSTER_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("cluster_foliage_placer",
            ClusterFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> CYPRESS_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("cypress_foliage_placer",
            CypressFoliagePlacer.CODEC);
    public static final FoliagePlacerType<?> GOLDEN_OAK_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("golden_oak_foliage_placer",
            GoldenOakFoliagePlacer.CODEC);
    public static final FoliagePlacerType<?> DESERT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("desert_foliage_placer",
            DesertFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> FIR_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("fir_foliage_placer",
            FirFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> HOLLY_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("holly_foliage_placer",
            HollyFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> SILVER_SPRUCE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("silver_spruce_foliage_placer",
            SilverSpruceFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> OAK_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("oak_foliage_placer",
            OakFoliagePlacer.CODEC);

    public static void register() {
        Edumia.LOGGER.info("Registering Foliage Placer for " + Edumia.MOD_ID);
    }
}
