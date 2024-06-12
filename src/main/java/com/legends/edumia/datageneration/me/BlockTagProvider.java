package com.legends.edumia.datageneration.me;

import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.datageneration.edumia.custom.models.SimplePillarModels;
import com.legends.edumia.datageneration.edumia.custom.tags.Pillar;
import com.legends.edumia.datageneration.edumia.custom.tags.RequiresIronTool;
import com.legends.edumia.datageneration.edumia.custom.tags.RequiresStoneTool;
import com.legends.edumia.datageneration.me.content.tags.*;
import com.legends.edumia.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        var mineablePickaxe = getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "mineable/pickaxe")));
        var mineableAxe = getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "mineable/axe")));
        mineableAxe.add(MineableAxe.blocks.toArray(new Block[0]));
        mineablePickaxe.add(MineablePickaxe.blocks.toArray(new Block[0]));

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(RequiresStoneTool.blocks.toArray(new Block[0]));

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(RequiresIronTool.blocks.toArray(new Block[0]));

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "buttons"))).add(Buttons.buttons.toArray(new Block[0]));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "fences"))).add(Fences.fences.toArray(new Block[0]));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "fence_gates"))).add(FenceGates.fenceGates.toArray(new Block[0]));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "logs"))).add(Logs.logs.toArray(new Block[0]));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "pressure_plates"))).add(PressurePlates.pressurePlates.toArray(new Block[0]));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "walls"))).add(Walls.walls.toArray(new Block[0]));
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("minecraft", "planks"))).add(Planks.planks.toArray(new Block[0]));



        getOrCreateTagBuilder(ModTags.Blocks.GRAVEL)
                .add(Blocks.GRAVEL);

        getOrCreateTagBuilder(ModTags.Blocks.DIRT)
                .add(Blocks.DIRT);

        getOrCreateTagBuilder(ModTags.Blocks.VOLCANIC_PLANT_SURFACE)
                .add(StoneSets.VOLCANIC_ROCK.block())
                .add(Blocks.BASALT);

        getOrCreateTagBuilder(ModTags.Blocks.PILLARS)
                .add(BlockLoader.BRICK_PILLAR)
                .add(BlockLoader.STONE_PILLAR)
                .add(BlockLoader.SANDSTONE_PILLAR)
                .add(Pillar.pillars.toArray(new Block[0]));

        getOrCreateTagBuilder(ModTags.Blocks.REEDS_PLACEABLE_ON)
                .add(Blocks.SAND)
                .add(BlockLoader.WHITE_SAND)
                .add(Blocks.DIRT)
                .add(Blocks.GRASS_BLOCK);
    }

}
