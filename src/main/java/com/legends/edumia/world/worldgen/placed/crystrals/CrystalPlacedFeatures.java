package com.legends.edumia.world.worldgen.placed.crystrals;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.worldgen.configured.crystals.CrystalConfiguresFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class CrystalPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ELVEN_CRYSTAL = registerKey("elven_crystal");


    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        PlacedFeatures.register(featureRegisterable, ELVEN_CRYSTAL, registryEntryLookup.getOrThrow(CrystalConfiguresFeatures.ELVEN_CRYSTAL),
                CountPlacementModifier.of(2), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(5), YOffset.fixed(41)), BiomePlacementModifier.of());
    }
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Edumia.MOD_ID, name));
    }

}
