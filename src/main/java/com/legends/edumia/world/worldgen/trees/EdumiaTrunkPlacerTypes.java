package com.legends.edumia.world.worldgen.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.mixin.TrunkPlacerTypeInvoker;
import com.legends.edumia.world.worldgen.trees.trunkplacers.BoughsTrunkPlacer;
import com.legends.edumia.world.worldgen.trees.trunkplacers.CederTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class EdumiaTrunkPlacerTypes {
    public static final TrunkPlacerType<?> BOUGHS_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("boughs_trunk_placer", BoughsTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> CEDER_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("ceder_trunk_placer", CederTrunkPlacer.CODEC);

    public static void register() {
        Edumia.LOGGER.info("Registering Trunk Placers for " + Edumia.MOD_ID);
    }
}
