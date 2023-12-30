package com.legends.edumia.world.worldgen.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.mixin.FoliagePlacerTypeInvoker;
import com.legends.edumia.world.worldgen.trees.foliageplacer.AspenFoliagePlacer;
import com.legends.edumia.world.worldgen.trees.foliageplacer.GhostGumFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class EdumiaFoliagePlacerTypes {

    public static final FoliagePlacerType<?> GHOST_GUM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("ghost_gum_foliage_placer",
            GhostGumFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> ASPEN_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("aspen_foliage_placer",
            AspenFoliagePlacer.CODEC);

    public static void register() {
        Edumia.LOGGER.info("Registering Foliage Placer for " + Edumia.MOD_ID);
    }
}
