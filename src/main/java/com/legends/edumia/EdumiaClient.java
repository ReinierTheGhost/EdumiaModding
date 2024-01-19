package com.legends.edumia;

import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.core.BlockLoader;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import com.legends.edumia.datageneration.me.VariantsModelProvider;
import com.legends.edumia.entity.ModEntities;
import com.legends.edumia.entity.crab.CrabRenderer;
import com.legends.edumia.entity.model.ModEntityModels;
import com.legends.edumia.entity.spear.JavelinEntityRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
public class EdumiaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModEntityModels.getModels();

        // Items
        ModelLoadingRegistry.INSTANCE.registerModelProvider(((manager, out) -> new VariantsModelProvider().provideExtraModels(manager, out)));
        EntityRendererRegistry.register(ModEntities.SPEAR, JavelinEntityRenderer::new);


        // Animals
        EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);


        initializeRenderLayerMap();
    }

    private void initializeRenderLayerMap() {

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.REEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.PAPYRUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.DRIED_REEDS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FLAX_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.BLACK_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.ARID_GRASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.DRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.TALL_DRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.TALL_DEAD_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.BEACH_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.TALL_BEACH_GRASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FROSTED_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.TALL_FROSTED_GRASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.PARASOL_MUSHROOM_1, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.PARASOL_MUSHROOM_2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.PARASOL_MUSHROOM_TALL, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.ASPHODEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.BLUE_DELPHINIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.BLUEBELL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CALLA_LILY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CELSEMIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CHRYS_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CHRYS_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CHRYS_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CHRYS_WHITE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CHRYS_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.CROCUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.DAISY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.DELPHINIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FLAX_FLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FOXGLOVE_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FOXGLOVE_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FOXGLOVE_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FOXGLOVE_WHITE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.GERBERA_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.GENSAI_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.GERBERA_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.HEATHER_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.MARIGOLD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.PINK_ANEMONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.SIMBLELMYNE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.TUBEROSE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.FLAME_OF_THE_SOUTH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.YELLOW_IRIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.HIBISCUS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.TEST_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.ASPEN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.BEECH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.BLACKTHORN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.CEDAR_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.CYPRESS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.DRAGON_BLOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.FIR_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.GHOST_GUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.GREEN_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.HOLLY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.LARCH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.PINE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.RED_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.REDWOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.SILVER_SPRUCE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModNatureBlocks.WHITE_ASH_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_ASPHODEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_BLUE_DELPHINIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_BLUEBELL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CALLA_LILY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CELSEMIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CHRYS_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CHRYS_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CHRYS_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CHRYS_WHITE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CHRYS_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_CROCUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_DAISY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_DELPHINIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_FLAX_FLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_FOXGLOVE_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_FOXGLOVE_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_FOXGLOVE_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_FOXGLOVE_WHITE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_GERBERA_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_GERBERA_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_HEATHER_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_MARIGOLD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_PINK_ANEMONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_SIMBLELMYNE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.POTTED_TUBEROSE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlockLoader.HIGH_ELVEN_CRYSTAL, RenderLayer.getTranslucent());
        for (WoodBlockSets.SimpleBlockSet set : WoodBlockSets.sets){
            BlockRenderLayerMap.INSTANCE.putBlock(set.door(), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(set.trapdoor(), RenderLayer.getCutout());
        }

    }

    private void registerDyeableItem(Item item) {
        ColorProviderRegistry.ITEM.register((stack, layer) -> layer == 0 ? ((DyeableItem)stack.getItem()).getColor(stack) : 0xFFFFFF, item);
    }
}