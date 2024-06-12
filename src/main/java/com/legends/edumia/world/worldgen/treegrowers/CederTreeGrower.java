package com.legends.edumia.world.worldgen.treegrowers;

import com.legends.edumia.world.worldgen.configured.TreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.TemperateTreeConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CederTreeGrower extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        if (random.nextInt(4) == 0){
            return TemperateTreeConfiguredFeatures.LARGE_CEDER_KEY;
        }else {
            return TemperateTreeConfiguredFeatures.CEDER_KEY;
        }

    }
}
