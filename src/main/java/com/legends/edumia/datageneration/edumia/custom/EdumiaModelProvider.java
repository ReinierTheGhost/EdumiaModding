package com.legends.edumia.datageneration.edumia.custom;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;

public abstract class EdumiaModelProvider extends FabricModelProvider {
    public EdumiaModelProvider(FabricDataOutput output) {
        super(output);
    }

    public abstract void generateCustomBlockStateModels(EdumiaBlockStateModelGenerator blockStateModelGenerator);
}
