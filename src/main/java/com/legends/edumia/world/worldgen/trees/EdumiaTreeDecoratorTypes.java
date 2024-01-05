package com.legends.edumia.world.worldgen.trees;

import com.legends.edumia.Edumia;
import com.legends.edumia.mixin.TreeDecoratorTypeInvoker;
import com.legends.edumia.mixin.TrunkPlacerTypeInvoker;
import com.legends.edumia.world.worldgen.trees.treedecorators.PineBranchDecorator;
import com.legends.edumia.world.worldgen.trees.trunkplacers.PartyTreeTrunkPlacer;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class EdumiaTreeDecoratorTypes {

    public static final TreeDecoratorType<?> PINE_BRANCH_DECORATOR = TreeDecoratorTypeInvoker.callRegister("pine_branch_decorator",
            PineBranchDecorator.CODEC);

    public static void register() {
        Edumia.LOGGER.info("Registering Trunk Placers for " + Edumia.MOD_ID);
    }
}
