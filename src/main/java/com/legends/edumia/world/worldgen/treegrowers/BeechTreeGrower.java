package com.legends.edumia.world.worldgen.treegrowers;

import com.legends.edumia.world.worldgen.configured.TreeConfiguredFeatures;
import com.legends.edumia.world.worldgen.configured.trees.BeechTreeConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class BeechTreeGrower extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        int nextInt = random.nextInt(10);
        if (nextInt == 0 || nextInt == 1){
            return BeechTreeConfiguredFeatures.BIG_BEECH_KEY;
        } else if (nextInt == 2){
            return BeechTreeConfiguredFeatures.PARTY_BEECH_KEY;
        } else if (nextInt == 3){
            return BeechTreeConfiguredFeatures.GIGA_BEECH_KEY;
        }else {
            return BeechTreeConfiguredFeatures.BEECH_KEY;
        }
    }
}
