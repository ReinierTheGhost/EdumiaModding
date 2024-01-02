package com.legends.edumia.world.worldgen.treegrowers;

import com.legends.edumia.world.worldgen.configured.TreeConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class GreenOakTreeGrower extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return TreeConfiguredFeatures.GREEN_OAK_KEY;
    }
}
