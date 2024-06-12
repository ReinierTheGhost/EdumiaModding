package com.legends.edumia.world.worldgen.treegrowers;

import com.legends.edumia.world.worldgen.configured.trees.TropicalTreeConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MangoTreeGrower  extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        if (random.nextInt(3) == 0){
            return TropicalTreeConfiguredFeatures.MANGO;
        }else {
            return TropicalTreeConfiguredFeatures.MANGO_TWO;
        }

    }
}
