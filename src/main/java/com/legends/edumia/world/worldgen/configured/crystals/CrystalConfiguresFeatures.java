package com.legends.edumia.world.worldgen.configured.crystals;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.world.features.bouders.BouldersFeatureConfig;
import com.legends.edumia.world.features.crystal.CrystalFeatureConfig;
import com.legends.edumia.world.worldgen.EdumiaFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class CrystalConfiguresFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ELVEN_CRYSTAL = registerKey("elven_crystal");
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ConfiguredFeatures.register(featureRegisterable, ELVEN_CRYSTAL, EdumiaFeatures.CRYSTAL,
                new CrystalFeatureConfig(BlockStateProvider.of(BlockLoader.HIGH_ELVEN_CRYSTAL), 64,6, 4, 6));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

}
