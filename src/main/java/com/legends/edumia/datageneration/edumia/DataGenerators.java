package com.legends.edumia.datageneration.edumia;

import com.legends.edumia.datageneration.edumia.custom.EdumiaHelpingGenerator;
import com.legends.edumia.datageneration.me.BlockTagProvider;
import com.legends.edumia.world.biomes.EdumiaBiomeKeys;
import com.legends.edumia.world.biomes.caves.ModCaveBiomes;
import com.legends.edumia.world.biomes.surface.ModBiomes;
import com.legends.edumia.world.dimension.ModDimensions;
import com.legends.edumia.world.worldgen.ModConfiguredFeatures;
import com.legends.edumia.world.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class DataGenerators implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        EdumiaHelpingGenerator.generateFiles();

        var pack = fabricDataGenerator.createPack();
        //pack.addProvider(ModelProvider::new);
        pack.addProvider(RecipeProvider::new);
        pack.addProvider(ModBlockLootTables::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(WorldGenerator::new);
        pack.addProvider(BlockTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModCaveBiomes::bootstrap);
    }
}
