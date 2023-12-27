package com.legends.edumia.datageneration.edumia;

import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.ItemLoader;
import com.legends.edumia.datageneration.edumia.custom.EdumiaBlockStateModelGenerator;
import com.legends.edumia.datageneration.edumia.custom.ModModels;
import com.legends.edumia.datageneration.edumia.custom.models.*;
import com.legends.edumia.datageneration.me.content.CustomItemModels;
import com.legends.edumia.datageneration.me.content.models.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        /**
         * ME
         */

        for (Block block : SimpleBlockModel.blocks) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }

        for (SimplePillarModel.Pillar block : SimplePillarModel.blocks) {
            blockStateModelGenerator.registerAxisRotated(block.base(), TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        }

        for (SimpleSlabModel.Slab block : SimpleSlabModel.blocks) {
            Identifier id = ModelIds.getBlockModelId(block.block());
            Block slab = block.slab();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Identifier bottom = Models.SLAB.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier top = Models.SLAB_TOP.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createSlabBlockState(slab, bottom, top, id));
        }

        for (SimpleStairModel.Stair block : SimpleStairModel.blocks) {
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Block stairs = block.stairs();

            Identifier inner = Models.INNER_STAIRS.upload(stairs, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier regular = Models.STAIRS.upload(stairs, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier outer = Models.OUTER_STAIRS.upload(stairs, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createStairsBlockState(stairs, inner, regular, outer));
        }

        for (SimpleWallModel.Wall block : SimpleWallModel.blocks) {
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Block wall = block.wall();

            Models.WALL_INVENTORY.upload(wall, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            Identifier post = Models.TEMPLATE_WALL_POST.upload(wall, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier low = Models.TEMPLATE_WALL_SIDE.upload(wall, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier tall = Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createWallBlockState(wall, post, low, tall));
        }

        for (SimpleFenceModel.Fence block : SimpleFenceModel.blocks) {
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Block fence = block.fence();

            Identifier post = Models.FENCE_POST.upload(fence, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier side = Models.FENCE_SIDE.upload(fence, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier inventory = Models.FENCE_INVENTORY.upload(fence, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createFenceBlockState(fence, post, side));

            blockStateModelGenerator.registerParentedItemModel(fence, inventory);
        }

        for (SimpleFenceGateModel.FenceGate block : SimpleFenceGateModel.blocks) {
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Block fenceGate = block.fenceGate();

            Identifier open = Models.TEMPLATE_CUSTOM_FENCE_GATE_OPEN.upload(fenceGate, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier closed = Models.TEMPLATE_CUSTOM_FENCE_GATE.upload(fenceGate, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier openWall = Models.TEMPLATE_CUSTOM_FENCE_GATE_WALL_OPEN.upload(fenceGate, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier closedWall = Models.TEMPLATE_CUSTOM_FENCE_GATE_WALL.upload(fenceGate, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createFenceGateBlockState(fenceGate, open, closed, openWall, closedWall, false));
        }

        for (SimpleButtonModel.Button block : SimpleButtonModel.blocks) {
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Block button = block.button();

            Identifier unpressed = Models.BUTTON.upload(button, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier pressed = Models.BUTTON_PRESSED.upload(button, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier inventory = Models.BUTTON_INVENTORY.upload(button, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createButtonBlockState(button, unpressed, pressed));

            blockStateModelGenerator.registerParentedItemModel(button, inventory);
        }

        for (SimplePressurePlateModel.PressurePlate block : SimplePressurePlateModel.blocks) {
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Block pressurePlate = block.pressurePlate();

            Identifier up = Models.PRESSURE_PLATE_UP.upload(pressurePlate, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier down = Models.PRESSURE_PLATE_DOWN.upload(pressurePlate, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createPressurePlateBlockState(pressurePlate, up, down));
        }

        for (Block block : SimpleTrapDoorModel.blocks) {
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block);

            Identifier top = Models.TEMPLATE_ORIENTABLE_TRAPDOOR_TOP.upload(block, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier bottom = Models.TEMPLATE_ORIENTABLE_TRAPDOOR_BOTTOM.upload(block, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier open = Models.TEMPLATE_ORIENTABLE_TRAPDOOR_OPEN.upload(block, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator
                    .createTrapdoorBlockState(block, top, bottom, open));
        }

        /**
         * Edumia
         */

        for (Block block : SimpleDoubleFlowerModel.blocks){
            blockStateModelGenerator.registerDoubleBlock(block, BlockStateModelGenerator.TintType.NOT_TINTED);
        }

        for (Block block : SimpleSaplingModel.blocks){
            blockStateModelGenerator.registerTintableCross(block, BlockStateModelGenerator.TintType.NOT_TINTED);
        }

        for (SimpleTwoMeterArchModel.Arch block: SimpleTwoMeterArchModel.blocks){
            Block twoMeterArch = block.arch();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());

            Identifier model = ModModels.TWO_METER_ARCH.upload(twoMeterArch, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createTwoMeterArchBlockState(twoMeterArch, model));

        }

        for (SimpleSmallArchModel.Arch block: SimpleSmallArchModel.blocks){
            Block smallArch = block.arch();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());

            Identifier model = ModModels.SMALL_ARCH.upload(smallArch, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createSmallArchBlockState(smallArch, model));
        }

        for (SimpleArrowSlitModel.ArrowSlit block: SimpleArrowSlitModel.blocks){
            Block arrowSlit = block.arrowSlit();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());
            Identifier model = ModModels.TEMPLATE_ARROWSLIT.upload(arrowSlit, texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createArrowSlitBlockState(arrowSlit, model));
        }

        for (SimpleBalustradeModels.Balustrade block: SimpleBalustradeModels.blocks){
            Block balustrade = block.balustrade();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());

            Identifier dir = ModModels.BALUSTRADE.upload(balustrade, texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier base = ModModels.BALUSTRADE_BASE.upload(balustrade, "_base", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createBalustradeBlockState(
                    balustrade, base, dir));
        }

        for (SimpleRoundArchModel.Arch block: SimpleRoundArchModel.blocks){
            Block arch = block.arch();
            Block texture = block.texture();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());
            Identifier one = ModModels.SMOOTH_ROUND_ARCH_1.upload(arch, "_1", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier two = ModModels.SMOOTH_ROUND_ARCH_2.upload(arch, "_2", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier three = ModModels.SMOOTH_ROUND_ARCH_3.upload(arch, "_3", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier middle = ModModels.SMOOTH_ROUND_ARCH_3_MIDDLE.upload(arch, "_3_middle", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createArchBlockState(arch, one, two, three, middle));

            blockStateModelGenerator.registerParentedItemModel(arch, ModelIds.getBlockSubModelId(arch, "_1"));

        }

        for (SimpleSegmentalArchModel.Arch block: SimpleSegmentalArchModel.blocks){
            Block arch = block.arch();
            Block texture = block.texture();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());
            Identifier one = ModModels.SMOOTH_SEGMENTAL_ARCH_1.upload(arch, "_1", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier two = ModModels.SMOOTH_SEGMENTAL_ARCH_2.upload(arch, "_2", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier three = ModModels.SMOOTH_SEGMENTAL_ARCH_3.upload(arch, "_3", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier middle = ModModels.SMOOTH_SEGMENTAL_ARCH_3_MIDDLE.upload(arch, "_3_middle", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createArchBlockState(arch, one, two, three, middle));

            blockStateModelGenerator.registerParentedItemModel(arch, ModelIds.getBlockSubModelId(arch, "_1"));

        }

        for (SimpleGothicArchModel.Arch block: SimpleGothicArchModel.blocks){
            Block arch = block.arch();
            Block texture = block.texture();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());
            Identifier one = ModModels.SMOOTH_GOTHIC_ARCH_1.upload(arch, "_1", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier two = ModModels.SMOOTH_GOTHIC_ARCH_2.upload(arch, "_2", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier three = ModModels.SMOOTH_GOTHIC_ARCH_3.upload(arch, "_3", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);
            Identifier middle = ModModels.SMOOTH_GOTHIC_ARCH_3_MIDDLE.upload(arch, "_3_middle", texturedModel.getTextures(),
                    blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createArchBlockState(arch, one, two, three, middle));

            blockStateModelGenerator.registerParentedItemModel(arch, ModelIds.getBlockSubModelId(arch, "_1"));

        }


        for (SimplePillarModels.Pillar block: SimplePillarModels.blocks){
            Block pillar = block.pillar();

            Identifier single = Models.CUBE_COLUMN.upload(pillar, TextureMap.sideEnd(TextureMap.getId(pillar), TextureMap.getSubId(pillar,
                    "_face")),  blockStateModelGenerator.modelCollector);
            Identifier top = Models.CUBE_COLUMN.upload(pillar, "_top" , TextureMap.sideEnd(TextureMap.getSubId(pillar, "_top"), TextureMap.getSubId(pillar,
                    "_face")),  blockStateModelGenerator.modelCollector);
            Identifier middle = Models.CUBE_COLUMN.upload(pillar, "_middle", TextureMap.sideEnd(TextureMap.getSubId(pillar, "_middle"), TextureMap.getSubId(pillar,
                    "_face")),  blockStateModelGenerator.modelCollector);
            Identifier bottom = Models.CUBE_COLUMN.upload(pillar, "_bottom", TextureMap.sideEnd(TextureMap.getSubId(pillar, "_bottom"), TextureMap.getSubId(pillar,
                    "_face")),  blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createPillarBlockState(pillar, single, top, middle, bottom));

        }

        for (SimpleCornerBlockModel.Corner block: SimpleCornerBlockModel.blocks){
            Block corner = block.corner();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());

            Identifier layer1 = ModModels.TEMPLATE_VERTICAL_CORNER_1.upload(corner, "_1", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer2 = ModModels.TEMPLATE_VERTICAL_CORNER_2.upload(corner, "_2", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer3 = ModModels.TEMPLATE_VERTICAL_CORNER_4.upload(corner, "_4", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer4 = ModModels.TEMPLATE_VERTICAL_CORNER_6.upload(corner, "_6", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator
                    .createVerticalCornerBlockState(corner, layer1, layer2, layer3, layer4));

            blockStateModelGenerator.registerParentedItemModel(corner, ModelIds.getBlockSubModelId(corner, "_4"));
        }

        for (SimpleReedsModel.Reed block: SimpleReedsModel.blocks){
            Block reed = block.reed();

            Identifier one = Models.CROSS.upload(reed, "_1", TextureMap.cross(TextureMap.getSubId(reed, "_1")), blockStateModelGenerator.modelCollector);
            Identifier two_top = Models.CROSS.upload(reed, "_2_top", TextureMap.cross(TextureMap.getSubId(reed, "_2_top")), blockStateModelGenerator.modelCollector);
            Identifier two_top_water = Models.CROSS.upload(reed, "_2_top_waterlogged", TextureMap.cross(TextureMap.getSubId(reed, "_2_top_waterlogged")), blockStateModelGenerator.modelCollector);
            Identifier two_bottom = Models.CROSS.upload(reed, "_2_bottom", TextureMap.cross(TextureMap.getSubId(reed, "_2_bottom")), blockStateModelGenerator.modelCollector);
            Identifier three_top = Models.CROSS.upload(reed, "_3_top", TextureMap.cross(TextureMap.getSubId(reed, "_3_top")), blockStateModelGenerator.modelCollector);
            Identifier three_middle = Models.CROSS.upload(reed, "_3_middle", TextureMap.cross(TextureMap.getSubId(reed, "_3_middle")), blockStateModelGenerator.modelCollector);
            Identifier three_bottom = Models.CROSS.upload(reed, "_3_bottom", TextureMap.cross(TextureMap.getSubId(reed, "_3_bottom")), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createReedsBlockState(reed, one, two_top,
                    two_top_water, two_bottom, three_top, three_middle, three_bottom));

            blockStateModelGenerator.registerItemModel(reed.asItem());
        }

        for (SimpleLayerModel.Layer block: SimpleLayerModel.blocks){
            Identifier id = ModelIds.getBlockModelId(block.texture());
            Block layer = block.layer();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());
            Identifier layer1 = ModModels.LAYER_HEIGHT2.upload(layer, "_height2", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer2 = ModModels.LAYER_HEIGHT4.upload(layer, "_height4", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer3 = ModModels.LAYER_HEIGHT6.upload(layer, "_height6", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer4 = ModModels.LAYER_HEIGHT8.upload(layer, "_height8", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer5 = ModModels.LAYER_HEIGHT10.upload(layer, "_height10", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer6 = ModModels.LAYER_HEIGHT12.upload(layer, "_height12", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier layer7 = ModModels.LAYER_HEIGHT14.upload(layer, "_height14", texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator
                    .createLayerBlockState(layer, layer1, layer2, layer3, layer4, layer5, layer6, layer7, id));
            blockStateModelGenerator.registerParentedItemModel(layer, ModelIds.getBlockSubModelId(layer, "_height2"));
        }

        for (SimpleAxisSlabModel.Slab block : SimpleAxisSlabModel.blocks) {
            Identifier id = ModelIds.getBlockModelId(block.block());
            Block slab = block.slab();

            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.block());
            Identifier bottom = Models.SLAB.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
            Identifier top = Models.SLAB_TOP.upload(slab, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator
                    .createAxisSlabBlockState(slab, bottom, top, id));
        }

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.WHITE_SAND);


        BlockStateModelGenerator.BlockTexturePool basalt_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BASALT_BRICKS);
        basalt_bricks.stairs(BlockLoader.BASALT_BRICKS_STAIRS);
        basalt_bricks.wall( BlockLoader.BASALT_BRICKS_WALL);



        BlockStateModelGenerator.BlockTexturePool green_basalt_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.GREEN_BASALT_BRICKS);
        green_basalt_bricks.stairs(BlockLoader.GREEN_BASALT_BRICKS_STAIRS);
        green_basalt_bricks.wall( BlockLoader.GREEN_BASALT_BRICKS_WALL);


        BlockStateModelGenerator.BlockTexturePool green_basalt_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.GREEN_BASALT_COBBLESTONE);
        green_basalt_cobble.stairs( BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS);
        green_basalt_cobble.wall(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL);


        BlockStateModelGenerator.BlockTexturePool green_basalt = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.GREEN_BASALT);
        green_basalt.stairs( BlockLoader.GREEN_BASALT_STAIRS);
        green_basalt.wall( BlockLoader.GREEN_BASALT_WALL);

        BlockStateModelGenerator.BlockTexturePool light_gray_stone = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_GRAY_STONE);
        light_gray_stone.stairs( BlockLoader.LIGHT_GRAY_STONE_STAIRS);
        light_gray_stone.wall( BlockLoader.LIGHT_GRAY_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool light_gray_stone_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_GRAY_STONE_BRICKS);
        light_gray_stone_bricks.stairs( BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS);
        light_gray_stone_bricks.wall( BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool brown_stone = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BROWN_STONE);
        brown_stone.stairs( BlockLoader.BROWN_STONE_STAIRS);
        brown_stone.wall( BlockLoader.BROWN_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool blue_stone = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BLUE_STONE);
        blue_stone.stairs( BlockLoader.BLUE_STONE_STAIRS);
        blue_stone.wall( BlockLoader.BLUE_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool yellow_stone = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.YELLOW_STONE);
        yellow_stone.stairs( BlockLoader.YELLOW_STONE_STAIRS);
        yellow_stone.wall( BlockLoader.YELLOW_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool yellow_stone_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.YELLOW_STONE_BRICKS);
        yellow_stone_bricks.stairs( BlockLoader.YELLOW_STONE_BRICKS_STAIRS);
        yellow_stone_bricks.wall( BlockLoader.YELLOW_STONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool yellow_stone_2 = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.YELLOW_STONE_2);
        yellow_stone_2.stairs( BlockLoader.YELLOW_STONE_2_STAIRS);
        yellow_stone_2.wall( BlockLoader.YELLOW_STONE_2_WALL);

        BlockStateModelGenerator.BlockTexturePool yellow_stone_bricks_2 = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.YELLOW_STONE_BRICKS_2);
        yellow_stone_bricks_2.stairs( BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS);
        yellow_stone_bricks_2.wall( BlockLoader.YELLOW_STONE_BRICKS_2_WALL);

        BlockStateModelGenerator.BlockTexturePool CGB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_GREEN_BASALT);
        CGB.stairs( BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
        CGB.wall( BlockLoader.CRACKED_GREEN_BASALT_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_BASALT);

//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.LIMESTONE);
//        .stairs( BlockLoader.LIMESTONE_STAIRS, blockTexture(BlockLoader.LIMESTONE));
//        .wall( BlockLoader.LIMESTONE_WALL, blockTexture(BlockLoader.LIMESTONE));
//
        BlockStateModelGenerator.BlockTexturePool gneiss = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.GNEISS);
        gneiss.stairs( BlockLoader.GNEISS_STAIRS);
        gneiss.wall( BlockLoader.GNEISS_WALL);

        BlockStateModelGenerator.BlockTexturePool MBB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_BASALT_BRICKS);
        MBB.stairs( BlockLoader.MOSSY_BASALT_BRICKS_STAIRS);
        MBB.wall( BlockLoader.MOSSY_BASALT_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool blue_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BLUE_BRICK);
        blue_bricks.stairs( BlockLoader.BLUE_BRICK_STAIRS);
        blue_bricks.wall( BlockLoader.BLUE_BRICK_WALL);

        BlockStateModelGenerator.BlockTexturePool cyan_stone = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CYAN_STONE);
        cyan_stone.stairs( BlockLoader.CYAN_STONE_STAIRS);
        cyan_stone.wall( BlockLoader.CYAN_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool orange_rock = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.ORANGE_ROCK);
        orange_rock.stairs( BlockLoader.ORANGE_ROCK_STAIRS);
        orange_rock.wall( BlockLoader.ORANGE_ROCK_WALL);

        BlockStateModelGenerator.BlockTexturePool redrock = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.RED_ROCK);
        redrock.stairs( BlockLoader.RED_ROCK_STAIRS);
        redrock.wall( BlockLoader.RED_ROCK_WALL);

        BlockStateModelGenerator.BlockTexturePool yellow_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.YELLOW_COBBLE);
        yellow_cobble.stairs( BlockLoader.YELLOW_COBBLE_STAIRS);
        yellow_cobble.wall( BlockLoader.YELLOW_COBBLE_WALL);

        BlockStateModelGenerator.BlockTexturePool HEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.HIGH_ELVEN_BRICKS);
        HEB.stairs( BlockLoader.HIGH_ELVEN_BRICKS_STAIRS);
        HEB.wall( BlockLoader.HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool SHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.SMALL_HIGH_ELVEN_BRICKS);
        SHEB.stairs( BlockLoader.SMALL_HIGH_ELVEN_BRICKS_STAIRS);
        SHEB.wall( BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool CHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS);
        CHEB.stairs( BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS);
        CHEB.wall( BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool MHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS);
        MHEB.stairs( BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS);
        MHEB.wall( BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS);

        BlockStateModelGenerator.BlockTexturePool LHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS);
        LHEB.stairs( BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        LHEB.wall( BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool CLHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS);
        CLHEB.stairs( BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        CLHEB.wall( BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool MLHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS);
        MLHEB.stairs( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        MLHEB.wall( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS);

        BlockStateModelGenerator.BlockTexturePool SLHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS);
        SLHEB.stairs( BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        SLHEB.wall( BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool DHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.DARK_HIGH_ELVEN_BRICKS);
        DHEB.stairs( BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS);
        DHEB.wall( BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool CDHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS);
        CDHEB.stairs( BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS);
        CDHEB.wall( BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool MDHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS);
        MDHEB.stairs( BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS);
        MDHEB.wall( BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS);

        BlockStateModelGenerator.BlockTexturePool SDHEB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS);
        SDHEB.stairs( BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS);
        SDHEB.wall( BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool chalk = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CHALK);
        chalk.stairs( BlockLoader.CHALK_STAIRS);
        chalk.wall( BlockLoader.CHALK_WALL);

        BlockStateModelGenerator.BlockTexturePool chalk_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CHALK_BRICKS);
        chalk_bricks.stairs( BlockLoader.CHALK_BRICKS_STAIRS);
        chalk_bricks.wall( BlockLoader.CHALK_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool brown_sandstone_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BROWN_SANDSTONE_BRICKS);
        brown_sandstone_bricks.stairs( BlockLoader.BROWN_SANDSTONE_BRICKS_STAIRS);
        brown_sandstone_bricks.wall( BlockLoader.BROWN_SANDSTONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool CBSB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS);
        CBSB.stairs( BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS);
        CBSB.wall( BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool MBSB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS);
        MBSB.stairs( BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS);
        MBSB.wall( BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS);

        BlockStateModelGenerator.BlockTexturePool cacholong_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CACHOLONG_BRICKS);
        cacholong_bricks.stairs( BlockLoader.CACHOLONG_BRICKS_STAIRS);
        cacholong_bricks.wall( BlockLoader.CACHOLONG_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool cracked_cacholong_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_CACHOLONG_BRICKS);
        cracked_cacholong_bricks.stairs( BlockLoader.CRACKED_CACHOLONG_BRICKS_STAIRS);
        cracked_cacholong_bricks.wall( BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_cacholong_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_CACHOLONG_BRICKS);
        mossy_cacholong_bricks.stairs( BlockLoader.MOSSY_CACHOLONG_BRICKS_STAIRS);
        mossy_cacholong_bricks.wall( BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_CACHOLONG_BRICKS);

        BlockStateModelGenerator.BlockTexturePool black_demon_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BLACK_DEMON_BRICKS);
        black_demon_bricks.stairs( BlockLoader.BLACK_DEMON_BRICKS_STAIRS);
        black_demon_bricks.wall( BlockLoader.BLACK_DEMON_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool cracked_black_demon_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_BLACK_DEMON_BRICKS);
        cracked_black_demon_bricks.stairs( BlockLoader.CRACKED_BLACK_DEMON_BRICKS_STAIRS);
        cracked_black_demon_bricks.wall( BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_black_demon_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_BLACK_DEMON_BRICKS);
        mossy_black_demon_bricks.stairs( BlockLoader.MOSSY_BLACK_DEMON_BRICKS_STAIRS);
        mossy_black_demon_bricks.wall( BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_BLACK_DEMON_BRICKS);

        BlockStateModelGenerator.BlockTexturePool blue_brick = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.BLUE_BRICKS);
        blue_brick.stairs( BlockLoader.BLUE_BRICKS_STAIRS);
        blue_brick.wall( BlockLoader.BLUE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool cracked_blue_brick = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_BLUE_BRICKS);
        cracked_blue_brick.stairs( BlockLoader.CRACKED_BLUE_BRICKS_STAIRS);
        cracked_blue_brick.wall( BlockLoader.CRACKED_BLUE_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_blue_brick = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_BLUE_BRICKS);
        mossy_blue_brick.stairs( BlockLoader.MOSSY_BLUE_BRICKS_STAIRS);
        mossy_blue_brick.wall( BlockLoader.MOSSY_BLUE_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_BLUE_BRICKS);

        BlockStateModelGenerator.BlockTexturePool demon_basalt_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.DEMON_BASALT_BRICKS);
        demon_basalt_bricks.stairs( BlockLoader.DEMON_BASALT_BRICKS_STAIRS);
        demon_basalt_bricks.wall( BlockLoader.DEMON_BASALT_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_DEMON_BASALT_BRICKS);

        BlockStateModelGenerator.BlockTexturePool volcanic_demon_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.VULCANIC_DEMON_BRICKS);
        volcanic_demon_bricks.stairs( BlockLoader.VULCANIC_DEMON_BRICKS_STAIRS);
        volcanic_demon_bricks.wall( BlockLoader.VULCANIC_DEMON_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool volcanic_rock = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.VULCANIC_ROCK);
        volcanic_rock.stairs( BlockLoader.VULCANIC_ROCK_STAIRS);
        volcanic_rock.wall( BlockLoader.VULCANIC_ROCK_WALL);

        BlockStateModelGenerator.BlockTexturePool cracked_volcanic_demon_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS);
        cracked_volcanic_demon_bricks.stairs( BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_STAIRS);
        cracked_volcanic_demon_bricks.wall( BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_volcanic_demon_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS);
        mossy_volcanic_demon_bricks.stairs( BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_STAIRS);
        mossy_volcanic_demon_bricks.wall( BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_VULCANIC_DEMON_BRICKS);

        BlockStateModelGenerator.BlockTexturePool red_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.RED_BRICKS);
        red_bricks.stairs( BlockLoader.RED_BRICKS_STAIRS);
        red_bricks.wall( BlockLoader.RED_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool cracked_red_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_RED_BRICKS);
        cracked_red_bricks.stairs( BlockLoader.CRACKED_RED_BRICKS_STAIRS);
        cracked_red_bricks.wall( BlockLoader.CRACKED_RED_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_red_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_RED_BRICKS);
        mossy_red_bricks.stairs( BlockLoader.MOSSY_RED_BRICKS_STAIRS);
        mossy_red_bricks.wall( BlockLoader.MOSSY_RED_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_RED_BRICKS);

        BlockStateModelGenerator.BlockTexturePool desert_mud_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.DESERT_MUD_BRICKS);
        desert_mud_bricks.stairs( BlockLoader.DESERT_MUD_BRICKS_STAIRS);
        desert_mud_bricks.wall( BlockLoader.DESERT_MUD_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool cracked_desert_mud_bricks = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.CRACKED_DESERT_MUD_BRICKS);
        cracked_desert_mud_bricks.stairs( BlockLoader.CRACKED_DESERT_MUD_BRICKS_STAIRS);
        cracked_desert_mud_bricks.wall( BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_desert_mud_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_DESERT_MUD_BRICKS);
        mossy_desert_mud_bricks.stairs( BlockLoader.MOSSY_DESERT_MUD_BRICKS_STAIRS);
        mossy_desert_mud_bricks.wall( BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL);

        BlockStateModelGenerator.BlockTexturePool high_elven_rock = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.HIGH_ELVEN_ROCK);
        high_elven_rock.stairs( BlockLoader.HIGH_ELVEN_ROCK_STAIRS);
        high_elven_rock.wall( BlockLoader.HIGH_ELVEN_ROCK_WALL);

        BlockStateModelGenerator.BlockTexturePool dark_high_elven_rock = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.DARK_HIGH_ELVEN_ROCK);
        dark_high_elven_rock.stairs( BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS);
        dark_high_elven_rock.wall( BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL);

        BlockStateModelGenerator.BlockTexturePool light_high_elven_rock = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_HIGH_ELVEN_ROCK);
        light_high_elven_rock.stairs( BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS);
        light_high_elven_rock.wall( BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL);

        BlockStateModelGenerator.BlockTexturePool high_elven_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.HIGH_ELVEN_COBBLESTONE);
        high_elven_cobble.stairs( BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS);
        high_elven_cobble.wall( BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_high_elven_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE);
        mossy_high_elven_cobble.stairs( BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS);
        mossy_high_elven_cobble.wall( BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL);

        BlockStateModelGenerator.BlockTexturePool light_high_elven_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE);
        light_high_elven_cobble.stairs( BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
        light_high_elven_cobble.wall( BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_light_high_elven_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE);
        mossy_light_high_elven_cobble.stairs( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
        mossy_light_high_elven_cobble.wall( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL);

        BlockStateModelGenerator.BlockTexturePool dark_high_elven_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE);
        dark_high_elven_cobble.stairs( BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
        dark_high_elven_cobble.wall( BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL);

        BlockStateModelGenerator.BlockTexturePool mossy_dark_high_elven_cobble = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE);
        mossy_dark_high_elven_cobble.stairs( BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
        mossy_dark_high_elven_cobble.wall( BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL);





//
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.BROWN_SANDSTONE_SLATES);
//
//
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.MARBLE_PINK);
//
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.TOPAZ_ORE);
//
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.ORE_VEIL);
//
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.ALEXANDRITE_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.ALEXANDRITE_ORE);
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.RAW_ALEXANDRITE_BLOCK);
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.APPLE_PLANKS);
//        .stairs( BlockLoader.APPLE_PLANKS_STAIRS, blockTexture(BlockLoader.APPLE_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.APPLE_FENCE, blockTexture(BlockLoader.APPLE_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.APPLE_FENCE_GATE, blockTexture(BlockLoader.APPLE_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.APPLE_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.APPLE_WOOD), blockTexture(BlockLoader.APPLE_LOG), blockTexture(BlockLoader.APPLE_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_APPLE_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_apple_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_apple_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_APPLE_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_apple_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_apple_log"));
//
//        leavesBlock(BlockLoader.APPLE_LEAVES);
//        saplingBlock(BlockLoader.APPLE_SAPLING);
//
//        blockItem(BlockLoader.APPLE_LOG);
//        blockItem(BlockLoader.APPLE_WOOD);
//        blockItem(BlockLoader.STRIPPED_APPLE_LOG);
//        blockItem(BlockLoader.STRIPPED_APPLE_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.ASPEN_PLANKS);
//        .stairs( BlockLoader.ASPEN_PLANKS_STAIRS, blockTexture(BlockLoader.ASPEN_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.ASPEN_FENCE, blockTexture(BlockLoader.ASPEN_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.ASPEN_FENCE_GATE, blockTexture(BlockLoader.ASPEN_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.ASPEN_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.ASPEN_WOOD), blockTexture(BlockLoader.ASPEN_LOG), blockTexture(BlockLoader.ASPEN_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_ASPEN_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_ASPEN_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log"));
//
//        leavesBlock(BlockLoader.ASPEN_LEAVES);
//        saplingBlock(BlockLoader.ASPEN_SAPLING);
//
//        blockItem(BlockLoader.ASPEN_LOG);
//        blockItem(BlockLoader.ASPEN_WOOD);
//        blockItem(BlockLoader.STRIPPED_ASPEN_LOG);
//        blockItem(BlockLoader.STRIPPED_ASPEN_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.BAOBAB_PLANKS);
//        .stairs( BlockLoader.BAOBAB_PLANKS_STAIRS, blockTexture(BlockLoader.BAOBAB_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.BAOBAB_FENCE, blockTexture(BlockLoader.BAOBAB_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.BAOBAB_FENCE_GATE, blockTexture(BlockLoader.BAOBAB_PLANKS));
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.BEECH_PLANKS);
//        .stairs( BlockLoader.BEECH_PLANKS_STAIRS, blockTexture(BlockLoader.BEECH_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.BEECH_FENCE, blockTexture(BlockLoader.BEECH_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.BEECH_FENCE_GATE, blockTexture(BlockLoader.BEECH_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.BEECH_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.BEECH_WOOD), blockTexture(BlockLoader.BEECH_LOG), blockTexture(BlockLoader.BEECH_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BEECH_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_beech_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_beech_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BEECH_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_beech_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_beech_log"));
//
//        leavesBlock(BlockLoader.BEECH_LEAVES);
//        saplingBlock(BlockLoader.BEECH_SAPLING);
//
//        blockItem(BlockLoader.BEECH_LOG);
//        blockItem(BlockLoader.BEECH_WOOD);
//        blockItem(BlockLoader.STRIPPED_BEECH_LOG);
//        blockItem(BlockLoader.STRIPPED_BEECH_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.CEDAR_PLANKS);
//        .stairs( BlockLoader.CEDAR_PLANKS_STAIRS, blockTexture(BlockLoader.CEDAR_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.CEDAR_FENCE, blockTexture(BlockLoader.CEDAR_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.CEDAR_FENCE_GATE, blockTexture(BlockLoader.CEDAR_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.CEDAR_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.CEDAR_WOOD), blockTexture(BlockLoader.CEDAR_LOG), blockTexture(BlockLoader.CEDAR_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CEDAR_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CEDAR_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log"));
//
//        leavesBlock(BlockLoader.CEDAR_LEAVES);
//        saplingBlock(BlockLoader.CEDAR_SAPLING);
//
//        blockItem(BlockLoader.CEDAR_LOG);
//        blockItem(BlockLoader.CEDAR_WOOD);
//        blockItem(BlockLoader.STRIPPED_CEDAR_LOG);
//        blockItem(BlockLoader.STRIPPED_CEDAR_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.CHERRY_PLANKS);
//        .stairs( BlockLoader.CHERRY_PLANKS_STAIRS, blockTexture(BlockLoader.CHERRY_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.CHERRY_FENCE, blockTexture(BlockLoader.CHERRY_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.CHERRY_FENCE_GATE, blockTexture(BlockLoader.CHERRY_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.CHERRY_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.CHERRY_WOOD), blockTexture(BlockLoader.CHERRY_LOG), blockTexture(BlockLoader.CHERRY_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CHERRY_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CHERRY_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log"));
//
//        leavesBlock(BlockLoader.CHERRY_LEAVES);
//        saplingBlock(BlockLoader.CHERRY_SAPLING);
//
//        blockItem(BlockLoader.CHERRY_LOG);
//        blockItem(BlockLoader.CHERRY_WOOD);
//        blockItem(BlockLoader.STRIPPED_CHERRY_LOG);
//        blockItem(BlockLoader.STRIPPED_CHERRY_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.CYPRESS_PLANKS);
//        .stairs( BlockLoader.CYPRESS_PLANKS_STAIRS, blockTexture(BlockLoader.CYPRESS_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.CYPRESS_FENCE, blockTexture(BlockLoader.CYPRESS_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.CYPRESS_FENCE_GATE, blockTexture(BlockLoader.CYPRESS_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.CYPRESS_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.CYPRESS_WOOD), blockTexture(BlockLoader.CYPRESS_LOG), blockTexture(BlockLoader.CYPRESS_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CYPRESS_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CYPRESS_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log"));
//
//        leavesBlock(BlockLoader.CYPRESS_LEAVES);
//        saplingBlock(BlockLoader.CYPRESS_SAPLING);
//
//        blockItem(BlockLoader.CYPRESS_LOG);
//        blockItem(BlockLoader.CYPRESS_WOOD);
//        blockItem(BlockLoader.STRIPPED_CYPRESS_LOG);
//        blockItem(BlockLoader.STRIPPED_CYPRESS_WOOD);
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.FIR_PLANKS);
//        .stairs( BlockLoader.FIR_PLANKS_STAIRS, blockTexture(BlockLoader.FIR_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.FIR_FENCE, blockTexture(BlockLoader.FIR_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.FIR_FENCE_GATE, blockTexture(BlockLoader.FIR_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.FIR_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.FIR_WOOD), blockTexture(BlockLoader.FIR_LOG), blockTexture(BlockLoader.FIR_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_FIR_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_fir_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_fir_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_FIR_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_fir_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_fir_log"));
//
//        leavesBlock(BlockLoader.FIR_LEAVES);
//        saplingBlock(BlockLoader.FIR_SAPLING);
//
//        blockItem(BlockLoader.FIR_LOG);
//        blockItem(BlockLoader.FIR_WOOD);
//        blockItem(BlockLoader.STRIPPED_FIR_LOG);
//        blockItem(BlockLoader.STRIPPED_FIR_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.GREEN_OAK_PLANKS);
//        .stairs( BlockLoader.GREEN_OAK_PLANKS_STAIRS, blockTexture(BlockLoader.GREEN_OAK_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.GREEN_OAK_FENCE, blockTexture(BlockLoader.GREEN_OAK_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.GREEN_OAK_FENCE_GATE, blockTexture(BlockLoader.GREEN_OAK_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.GREEN_OAK_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.GREEN_OAK_WOOD), blockTexture(BlockLoader.GREEN_OAK_LOG), blockTexture(BlockLoader.GREEN_OAK_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GREEN_OAK_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GREEN_OAK_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log"));
//
//        leavesBlock(BlockLoader.GREEN_OAK_LEAVES);
//        saplingBlock(BlockLoader.GREEN_OAK_SAPLING);
//
//        blockItem(BlockLoader.GREEN_OAK_LOG);
//        blockItem(BlockLoader.GREEN_OAK_WOOD);
//        blockItem(BlockLoader.STRIPPED_GREEN_OAK_LOG);
//        blockItem(BlockLoader.STRIPPED_GREEN_OAK_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.HOLLY_PLANKS);
//        .stairs( BlockLoader.HOLLY_PLANKS_STAIRS, blockTexture(BlockLoader.HOLLY_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.HOLLY_FENCE, blockTexture(BlockLoader.HOLLY_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.HOLLY_FENCE_GATE, blockTexture(BlockLoader.HOLLY_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.HOLLY_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.HOLLY_WOOD), blockTexture(BlockLoader.HOLLY_LOG), blockTexture(BlockLoader.HOLLY_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_HOLLY_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_holly_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_holly_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_HOLLY_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_holly_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_holly_log"));
//
//        leavesBlock(BlockLoader.HOLLY_LEAVES);
//        saplingBlock(BlockLoader.HOLLY_SAPLING);
//
//        blockItem(BlockLoader.HOLLY_LOG);
//        blockItem(BlockLoader.HOLLY_WOOD);
//        blockItem(BlockLoader.STRIPPED_HOLLY_LOG);
//        blockItem(BlockLoader.STRIPPED_HOLLY_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.LARCH_PLANKS);
//        .stairs( BlockLoader.LARCH_PLANKS_STAIRS, blockTexture(BlockLoader.LARCH_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.LARCH_FENCE, blockTexture(BlockLoader.LARCH_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.LARCH_FENCE_GATE, blockTexture(BlockLoader.LARCH_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.LARCH_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.LARCH_WOOD), blockTexture(BlockLoader.LARCH_LOG), blockTexture(BlockLoader.LARCH_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_LARCH_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_larch_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_larch_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_LARCH_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_larch_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_larch_log"));
//
//        leavesBlock(BlockLoader.LARCH_LEAVES);
//        saplingBlock(BlockLoader.LARCH_SAPLING);
//
//        blockItem(BlockLoader.LARCH_LOG);
//        blockItem(BlockLoader.LARCH_WOOD);
//        blockItem(BlockLoader.STRIPPED_LARCH_LOG);
//        blockItem(BlockLoader.STRIPPED_LARCH_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.MAPLE_PLANKS);
//        .stairs( BlockLoader.MAPLE_PLANKS_STAIRS, blockTexture(BlockLoader.MAPLE_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.MAPLE_FENCE, blockTexture(BlockLoader.MAPLE_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.MAPLE_FENCE_GATE, blockTexture(BlockLoader.MAPLE_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.MAPLE_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.MAPLE_WOOD), blockTexture(BlockLoader.MAPLE_LOG), blockTexture(BlockLoader.MAPLE_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_MAPLE_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_maple_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_maple_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_MAPLE_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_maple_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_maple_log"));
//
//        leavesBlock(BlockLoader.MAPLE_LEAVES);
//        saplingBlock(BlockLoader.MAPLE_SAPLING);
//
//        blockItem(BlockLoader.MAPLE_LOG);
//        blockItem(BlockLoader.MAPLE_WOOD);
//        blockItem(BlockLoader.STRIPPED_MAPLE_LOG);
//        blockItem(BlockLoader.STRIPPED_MAPLE_WOOD);
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.BLACKTHORN_PLANKS);
//        .stairs( BlockLoader.BLACKTHORN_PLANKS_STAIRS, blockTexture(BlockLoader.BLACKTHORN_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.BLACKTHORN_FENCE, blockTexture(BlockLoader.BLACKTHORN_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.BLACKTHORN_FENCE_GATE, blockTexture(BlockLoader.BLACKTHORN_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.BLACKTHORN_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.BLACKTHORN_WOOD), blockTexture(BlockLoader.BLACKTHORN_LOG), blockTexture(BlockLoader.BLACKTHORN_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BLACKTHORN_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BLACKTHORN_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log"));
//
//        leavesBlock(BlockLoader.BLACKTHORN_LEAVES);
//        saplingBlock(BlockLoader.BLACKTHORN_SAPLING);
//
//        blockItem(BlockLoader.BLACKTHORN_LOG);
//        blockItem(BlockLoader.BLACKTHORN_WOOD);
//        blockItem(BlockLoader.STRIPPED_BLACKTHORN_LOG);
//        blockItem(BlockLoader.STRIPPED_BLACKTHORN_WOOD);
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.GHOST_GUM_PLANKS);
//        .stairs( BlockLoader.GHOST_GUM_PLANKS_STAIRS, blockTexture(BlockLoader.GHOST_GUM_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.GHOST_GUM_FENCE, blockTexture(BlockLoader.GHOST_GUM_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.GHOST_GUM_FENCE_GATE, blockTexture(BlockLoader.GHOST_GUM_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.GHOST_GUM_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.GHOST_GUM_WOOD), blockTexture(BlockLoader.GHOST_GUM_LOG), blockTexture(BlockLoader.GHOST_GUM_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GHOST_GUM_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GHOST_GUM_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log"));
//
//        leavesBlock(BlockLoader.GHOST_GUM_LEAVES);
//        saplingBlock(BlockLoader.GHOST_GUM_SAPLING);
//
//        blockItem(BlockLoader.GHOST_GUM_LOG);
//        blockItem(BlockLoader.GHOST_GUM_WOOD);
//        blockItem(BlockLoader.STRIPPED_GHOST_GUM_LOG);
//        blockItem(BlockLoader.STRIPPED_GHOST_GUM_WOOD);
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.WHITE_ASH_PLANKS);
//        .stairs( BlockLoader.WHITE_ASH_PLANKS_STAIRS, blockTexture(BlockLoader.WHITE_ASH_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.WHITE_ASH_FENCE, blockTexture(BlockLoader.WHITE_ASH_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.WHITE_ASH_FENCE_GATE, blockTexture(BlockLoader.WHITE_ASH_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.WHITE_ASH_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.WHITE_ASH_WOOD), blockTexture(BlockLoader.WHITE_ASH_LOG), blockTexture(BlockLoader.WHITE_ASH_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_WHITE_ASH_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_WHITE_ASH_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log"));
//
//        leavesBlock(BlockLoader.WHITE_ASH_LEAVES);
//        saplingBlock(BlockLoader.WHITE_ASH_SAPLING);
//
//        blockItem(BlockLoader.WHITE_ASH_LOG);
//        blockItem(BlockLoader.WHITE_ASH_WOOD);
//        blockItem(BlockLoader.STRIPPED_WHITE_ASH_LOG);
//        blockItem(BlockLoader.STRIPPED_WHITE_ASH_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.OKOME_PLANKS);
//        .stairs( BlockLoader.OKOME_PLANKS_STAIRS, blockTexture(BlockLoader.OKOME_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.OKOME_FENCE, blockTexture(BlockLoader.OKOME_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.OKOME_FENCE_GATE, blockTexture(BlockLoader.OKOME_PLANKS));
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.PEAR_PLANKS);
//        .stairs( BlockLoader.PEAR_PLANKS_STAIRS, blockTexture(BlockLoader.PEAR_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.PEAR_FENCE, blockTexture(BlockLoader.PEAR_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.PEAR_FENCE_GATE, blockTexture(BlockLoader.PEAR_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.PEAR_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.PEAR_WOOD), blockTexture(BlockLoader.PEAR_LOG), blockTexture(BlockLoader.PEAR_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PEAR_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_pear_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_pear_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PEAR_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_pear_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_pear_log"));
//
//        leavesBlock(BlockLoader.PEAR_LEAVES);
//        saplingBlock(BlockLoader.PEAR_SAPLING);
//
//        blockItem(BlockLoader.PEAR_LOG);
//        blockItem(BlockLoader.PEAR_WOOD);
//        blockItem(BlockLoader.STRIPPED_PEAR_LOG);
//        blockItem(BlockLoader.STRIPPED_PEAR_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.PINE_PLANKS);
//        .stairs( BlockLoader.PINE_PLANKS_STAIRS, blockTexture(BlockLoader.PINE_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.PINE_FENCE, blockTexture(BlockLoader.PINE_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.PINE_FENCE_GATE, blockTexture(BlockLoader.PINE_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.PINE_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.PINE_WOOD), blockTexture(BlockLoader.PINE_LOG), blockTexture(BlockLoader.PINE_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PINE_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_pine_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_pine_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PINE_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_pine_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_pine_log"));
//
//        leavesBlock(BlockLoader.PINE_LEAVES);
//        saplingBlock(BlockLoader.PINE_SAPLING);
//
//        blockItem(BlockLoader.PINE_LOG);
//        blockItem(BlockLoader.PINE_WOOD);
//        blockItem(BlockLoader.STRIPPED_PINE_LOG);
//        blockItem(BlockLoader.STRIPPED_PINE_WOOD);
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.PLUM_PLANKS);
//        .stairs( BlockLoader.PLUM_PLANKS_STAIRS, blockTexture(BlockLoader.PLUM_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.PLUM_FENCE, blockTexture(BlockLoader.PLUM_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.PLUM_FENCE_GATE, blockTexture(BlockLoader.PLUM_PLANKS));
//
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.RED_OAK_PLANKS);
//        .stairs( BlockLoader.RED_OAK_PLANKS_STAIRS, blockTexture(BlockLoader.RED_OAK_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.RED_OAK_FENCE, blockTexture(BlockLoader.RED_OAK_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.RED_OAK_FENCE_GATE, blockTexture(BlockLoader.RED_OAK_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.RED_OAK_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.RED_OAK_WOOD), blockTexture(BlockLoader.RED_OAK_LOG), blockTexture(BlockLoader.RED_OAK_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_RED_OAK_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_RED_OAK_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log"));
//
//        leavesBlock(BlockLoader.RED_OAK_LEAVES);
//        saplingBlock(BlockLoader.RED_OAK_SAPLING);
//
//        blockItem(BlockLoader.RED_OAK_LOG);
//        blockItem(BlockLoader.RED_OAK_WOOD);
//        blockItem(BlockLoader.STRIPPED_RED_OAK_LOG);
//        blockItem(BlockLoader.STRIPPED_RED_OAK_WOOD);
//
//        simpleBlockWithItem(BlockLoader.ARID_GRASS,
//                models().cross(blockTexture(BlockLoader.ARID_GRASS).getPath(),
//                        blockTexture(BlockLoader.ARID_GRASS)).renderType("cutout"));
//
//
//        simpleBlockWithItem(BlockLoader.BLACK_GRASS,
//                models().cross(blockTexture(BlockLoader.BLACK_GRASS).getPath(),
//                        blockTexture(BlockLoader.BLACK_GRASS)).renderType("cutout"));
//
//        simpleBlockWithItem(BlockLoader.FLAX_GRASS,
//                models().cross(blockTexture(BlockLoader.FLAX_GRASS).getPath(),
//                        blockTexture(BlockLoader.FLAX_GRASS)).renderType("cutout"));
//
//
        //flowers
        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.ASPHODEL, BlockLoader.POTTED_ASPHODEL,
                BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.BLUE_DELPHINIUM, BlockLoader.POTTED_BLUE_DELPHINIUM,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.BLUEBELL, BlockLoader.POTTED_BLUEBELL,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CALLA_LILY, BlockLoader.POTTED_CALLA_LILY,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CELSEMIUM, BlockLoader.POTTED_CELSEMIUM,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CHRYS_BLUE, BlockLoader.POTTED_CHRYS_BLUE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CHRYS_ORANGE, BlockLoader.POTTED_CHRYS_ORANGE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CHRYS_PINK, BlockLoader.POTTED_CHRYS_PINK,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CHRYS_WHITE, BlockLoader.POTTED_CHRYS_WHITE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CHRYS_YELLOW, BlockLoader.POTTED_CHRYS_YELLOW,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.CROCUS, BlockLoader.POTTED_CROCUS,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.DAISY, BlockLoader.POTTED_DAISY,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.DELPHINIUM, BlockLoader.POTTED_DELPHINIUM,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.FLAX_FLOWERS, BlockLoader.POTTED_FLAX_FLOWERS,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.FOXGLOVE_ORANGE, BlockLoader.POTTED_FOXGLOVE_ORANGE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.FOXGLOVE_PINK, BlockLoader.POTTED_FOXGLOVE_PINK,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.FOXGLOVE_RED, BlockLoader.POTTED_FOXGLOVE_RED,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.FOXGLOVE_WHITE, BlockLoader.POTTED_FOXGLOVE_WHITE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.GERBERA_RED, BlockLoader.POTTED_GERBERA_RED,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.GERBERA_YELLOW, BlockLoader.POTTED_GERBERA_YELLOW,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.HEATHER_BUSH, BlockLoader.POTTED_HEATHER_BUSH,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.LAVENDER, BlockLoader.POTTED_LAVENDER,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.MARIGOLD, BlockLoader.POTTED_MARIGOLD,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.PINK_ANEMONE, BlockLoader.POTTED_PINK_ANEMONE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.SIMBLELMYNE, BlockLoader.POTTED_SIMBLELMYNE,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(BlockLoader.TUBEROSE, BlockLoader.POTTED_TUBEROSE,
                BlockStateModelGenerator.TintType.NOT_TINTED);
//
//        BlockStateModelGenerator.BlockTexturePool white_sand = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockLoader.SILVER_SPRUCE_PLANKS);
//        .stairs( BlockLoader.SILVER_SPRUCE_PLANKS_STAIRS, blockTexture(BlockLoader.SILVER_SPRUCE_PLANKS));
//        fenceBlock((FenceBlock) BlockLoader.SILVER_SPRUCE_FENCE, blockTexture(BlockLoader.SILVER_SPRUCE_PLANKS));
//        fenceGateBlock((FenceGateBlock) BlockLoader.SILVER_SPRUCE_FENCE_GATE, blockTexture(BlockLoader.SILVER_SPRUCE_PLANKS));
//
//        logBlock(((RotatedPillarBlock) BlockLoader.SILVER_SPRUCE_LOG));
//        axisBlock(((RotatedPillarBlock) BlockLoader.SILVER_SPRUCE_WOOD), blockTexture(BlockLoader.SILVER_SPRUCE_LOG), blockTexture(BlockLoader.SILVER_SPRUCE_LOG));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_SILVER_SPRUCE_LOG, new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log_top"));
//        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_SILVER_SPRUCE_WOOD, new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log"),
//                new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log"));
//
//        leavesBlock(BlockLoader.SILVER_SPRUCE_LEAVES);
//        saplingBlock(BlockLoader.SILVER_SPRUCE_SAPLING);
//
//        blockItem(BlockLoader.SILVER_SPRUCE_LOG);
//        blockItem(BlockLoader.SILVER_SPRUCE_WOOD);
//        blockItem(BlockLoader.STRIPPED_SILVER_SPRUCE_LOG);
//        blockItem(BlockLoader.STRIPPED_SILVER_SPRUCE_WOOD);
//
        BlockStateModelGenerator.BlockTexturePool HEBT = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.HIGH_ELVEN_BRICK_TILING);
//        HEBT.slab(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB, blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING),
//                blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING));
        HEBT.stairs( BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool DHEBT = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);
//        .slab(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB, blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING),
//                blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING));
        DHEBT.stairs( BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS);
//
        BlockStateModelGenerator.BlockTexturePool LHEBT = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING);
//        .slab(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB, blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING),
//                blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING));
        LHEBT.stairs( BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS);
//
        BlockStateModelGenerator.BlockTexturePool clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CLAY_TILING);
        clay_tiling.stairs( BlockLoader.CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool black_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BLACK_CLAY_TILING);
        black_clay_tiling.stairs( BlockLoader.BLACK_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool blue_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BLUE_CLAY_TILING);
        blue_clay_tiling.stairs( BlockLoader.BLUE_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool brown_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BROWN_CLAY_TILING);
        brown_clay_tiling.stairs( BlockLoader.BROWN_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool cyan_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CYAN_CLAY_TILING);
        cyan_clay_tiling.stairs( BlockLoader.CYAN_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool gray_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.GRAY_CLAY_TILING);
        gray_clay_tiling.stairs( BlockLoader.GRAY_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool green_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.GREEN_CLAY_TILING);
        green_clay_tiling.stairs( BlockLoader.GREEN_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool light_blue_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_BLUE_CLAY_TILING);
        light_blue_clay_tiling.stairs( BlockLoader.LIGHT_BLUE_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool light_gray_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_GRAY_CLAY_TILING);
        light_gray_clay_tiling.stairs( BlockLoader.LIGHT_GRAY_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool lime_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIME_CLAY_TILING);
        lime_clay_tiling.stairs( BlockLoader.LIME_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool magenta_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.MAGENTA_CLAY_TILING);
        magenta_clay_tiling.stairs( BlockLoader.MAGENTA_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool orange_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.ORANGE_CLAY_TILING);
        orange_clay_tiling.stairs( BlockLoader.ORANGE_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool pink_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.PINK_CLAY_TILING);
        pink_clay_tiling.stairs(BlockLoader.PINK_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool purple_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.PURPLE_CLAY_TILING);
        purple_clay_tiling.stairs( BlockLoader.PURPLE_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool red_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.RED_CLAY_TILING);
        red_clay_tiling.stairs( BlockLoader.RED_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool white_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.WHITE_CLAY_TILING);
        white_clay_tiling.stairs( BlockLoader.WHITE_CLAY_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool yellow_clay_tiling = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.YELLOW_CLAY_TILING);
        yellow_clay_tiling.stairs( BlockLoader.YELLOW_CLAY_TILING_STAIRS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        verticalCornerBlock(BlockLoader.BLACK_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.BLUE_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.BROWN_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.CYAN_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.GRAY_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.GREEN_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.LIME_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.MAGENTA_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.ORANGE_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.PINK_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.PURPLE_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.RED_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.WHITE_CLAY_TILING_VERTICAL_CORNER);
//        verticalCornerBlock(BlockLoader.YELLOW_CLAY_TILING_VERTICAL_CORNER);
//
//        archBlock(BlockLoader.GREEN_BASALT_ROUND_ARCH);
//        archBlock(BlockLoader.GREEN_BASALT_GOTHIC_ARCH);
//        archBlock(BlockLoader.GREEN_BASALT_SEGMENTAL_ARCH);
//
//        archBlock(BlockLoader.HIGH_ELVEN_BRICKS_ROUND_ARCH);
//        archBlock(BlockLoader.HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH);
//        archBlock(BlockLoader.HIGH_ELVEN_BRICKS_GOTHIC_ARCH);
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICKS_SMALL_ARCH);
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICKS_TWO_METER_ARCH);
//
//        layerBlock(BlockLoader.SAND_LAYER);
//        layerBlock(BlockLoader.RED_SAND_LAYER);
//        layerBlock(BlockLoader.WHITE_SAND_LAYER);
//
//        itemModelGenerator.register(ItemLoader.TEA_CINNAMON_STICK, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_WHITE_DRAGON_PETALS, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_LEAF, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_HIBISCUS_PETALS, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_JASMINE_PETALS, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_LILY_PETALS, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_MINT_LEAVES, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_SAKURA_PETALS, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.TEA_WHITE_JADE_PETALS, Models.GENERATED);
//        itemModelGenerator.register(ItemLoader.RICE_BALL, Models.GENERATED);

//        reedItem(BlockLoader.REEDS);
//        reedItem(BlockLoader.DRIED_REEDS);
//        reedItem(BlockLoader.PAPYRUS);

        itemModelGenerator.register(ItemLoader.ATLAS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FINE_AMBER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWED_AMBER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWLESS_AMBER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_PERFECT_AMBER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_ROUGH_AMBER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FINE_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWED_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWLESS_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_PERFECT_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_ROUGH_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FINE_JADE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWED_JADE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWLESS_JADE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_PERFECT_JADE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_ROUGH_JADE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FINE_JASPER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWED_JASPER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWLESS_JASPER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_PERFECT_JASPER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_ROUGH_JASPER, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FINE_RUBY, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWED_RUBY, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWLESS_RUBY, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_PERFECT_RUBY, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_ROUGH_RUBY, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FINE_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWED_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWLESS_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_PERFECT_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_ROUGH_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FINE_TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWED_TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_FLAWLESS_TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_PERFECT_TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.GEM_ROUGH_TOPAZ, Models.GENERATED);

//        evenSimplerBlockItem(BlockLoader.BRICK_PILLAR);
//        evenSimplerBlockItem(BlockLoader.STONE_PILLAR);
//        evenSimplerBlockItem(BlockLoader.CHALK_PILLAR);
//        evenSimplerBlockItem(BlockLoader.RED_PILLAR);
//        evenSimplerBlockItem(BlockLoader.CACHOLONG_PILLAR);
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_PILLAR);
//        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_PILLAR);
//        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_PILLAR);
//
//        evenSimplerBlockItem(BlockLoader.BASALT_BRICKS_SLAB);
//        evenSimplerBlockItem(BlockLoader.BASALT_BRICKS_STAIRS);
//        wallItem(BlockLoader.BASALT_BRICKS_WALL, BlockLoader.BASALT_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.GREEN_BASALT_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.GREEN_BASALT_BRICKS_STAIRS);
//        wallItem(BlockLoader.GREEN_BASALT_BRICKS_WALL, BlockLoader.GREEN_BASALT_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS);
//        wallItem(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL, BlockLoader.GREEN_BASALT_COBBLESTONE);
//
//        evenSimplerBlockItem(BlockLoader.GREEN_BASALT_SLAB);
//        evenSimplerBlockItem( BlockLoader.GREEN_BASALT_STAIRS);
//        wallItem(BlockLoader.GREEN_BASALT_WALL, BlockLoader.GREEN_BASALT);
//
//        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_STONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.LIGHT_GRAY_STONE_STAIRS);
//        wallItem(BlockLoader.LIGHT_GRAY_STONE_WALL, BlockLoader.LIGHT_GRAY_STONE);
//
//        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS);
//        wallItem(BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL, BlockLoader.LIGHT_GRAY_STONE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.BROWN_STONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.BROWN_STONE_STAIRS);
//        wallItem(BlockLoader.BROWN_STONE_WALL, BlockLoader.BROWN_STONE);
//
//        evenSimplerBlockItem(BlockLoader.BLUE_STONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.BLUE_STONE_STAIRS);
//        wallItem(BlockLoader.BLUE_STONE_WALL, BlockLoader.BLUE_STONE);
//
//        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_STAIRS);
//        wallItem(BlockLoader.YELLOW_STONE_WALL, BlockLoader.YELLOW_STONE);
//
//        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_BRICKS_STAIRS);
//        wallItem(BlockLoader.YELLOW_STONE_BRICKS_WALL, BlockLoader.YELLOW_STONE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_2_SLAB);
//        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_2_STAIRS);
//        wallItem(BlockLoader.YELLOW_STONE_2_WALL, BlockLoader.YELLOW_STONE_2);
//
//        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_BRICKS_2_SLAB);
//        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS);
//        wallItem(BlockLoader.YELLOW_STONE_BRICKS_2_WALL, BlockLoader.YELLOW_STONE_BRICKS_2);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_GREEN_BASALT_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
//        wallItem(BlockLoader.CRACKED_GREEN_BASALT_WALL, BlockLoader.CRACKED_GREEN_BASALT);
//
//        evenSimplerBlockItem(BlockLoader.LIMESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.LIMESTONE_STAIRS);
//        wallItem(BlockLoader.LIMESTONE_WALL, BlockLoader.LIMESTONE);
//
//        evenSimplerBlockItem(BlockLoader.GNEISS_SLAB);
//        evenSimplerBlockItem( BlockLoader.GNEISS_STAIRS);
//        wallItem(BlockLoader.GNEISS_WALL, BlockLoader.GNEISS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_BASALT_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_BASALT_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_BASALT_BRICKS_WALL, BlockLoader.MOSSY_BASALT_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.BLUE_BRICK_SLAB);
//        evenSimplerBlockItem( BlockLoader.BLUE_BRICK_STAIRS);
//        wallItem(BlockLoader.BLUE_BRICK_WALL, BlockLoader.BLUE_BRICK);
//
//        evenSimplerBlockItem(BlockLoader.CYAN_STONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.CYAN_STONE_STAIRS);
//        wallItem(BlockLoader.CYAN_STONE_WALL, BlockLoader.CYAN_STONE);
//
//        evenSimplerBlockItem(BlockLoader.ORANGE_ROCK_SLAB);
//        evenSimplerBlockItem( BlockLoader.ORANGE_ROCK_STAIRS);
//        wallItem(BlockLoader.ORANGE_ROCK_WALL, BlockLoader.ORANGE_ROCK);
//
//        evenSimplerBlockItem(BlockLoader.RED_ROCK_SLAB);
//        evenSimplerBlockItem( BlockLoader.RED_ROCK_STAIRS);
//        wallItem(BlockLoader.RED_ROCK_WALL, BlockLoader.RED_ROCK);
//
//
//        evenSimplerBlockItem(BlockLoader.YELLOW_COBBLE_SLAB);
//        evenSimplerBlockItem( BlockLoader.YELLOW_COBBLE_STAIRS);
//        wallItem(BlockLoader.YELLOW_COBBLE_WALL, BlockLoader.YELLOW_COBBLE);
//
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.HIGH_ELVEN_BRICKS_WALL, BlockLoader.HIGH_ELVEN_BRICKS);
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICK_ARROWSLIT);
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BALUSTRADE);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL, BlockLoader.CRACKED_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL, BlockLoader.MOSSY_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.SMALL_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL, BlockLoader.SMALL_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.LIGHT_HIGH_ELVEN_BRICKS);
//        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BALUSTRADE);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.DARK_HIGH_ELVEN_BRICKS);
//        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_BALUSTRADE);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS);
//        wallItem(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.RED_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.RED_BRICKS_STAIRS);
//        wallItem(BlockLoader.RED_BRICKS_WALL, BlockLoader.RED_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_RED_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_RED_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_RED_BRICKS_WALL, BlockLoader.CRACKED_RED_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_RED_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_RED_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_RED_BRICKS_WALL, BlockLoader.MOSSY_RED_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.BLUE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.BLUE_BRICKS_STAIRS);
//        wallItem(BlockLoader.BLUE_BRICKS_WALL, BlockLoader.BLUE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_BLUE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_BLUE_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_BLUE_BRICKS_WALL, BlockLoader.CRACKED_BLUE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_BLUE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_BLUE_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_BLUE_BRICKS_WALL, BlockLoader.MOSSY_BLUE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.DEMON_BASALT_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.DEMON_BASALT_BRICKS_STAIRS);
//        wallItem(BlockLoader.DEMON_BASALT_BRICKS_WALL, BlockLoader.DEMON_BASALT_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.VULCANIC_DEMON_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.VULCANIC_DEMON_BRICKS_STAIRS);
//        wallItem(BlockLoader.VULCANIC_DEMON_BRICKS_WALL, BlockLoader.VULCANIC_DEMON_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.VULCANIC_ROCK_SLAB);
//        evenSimplerBlockItem( BlockLoader.VULCANIC_ROCK_STAIRS);
//        wallItem(BlockLoader.VULCANIC_ROCK_WALL, BlockLoader.VULCANIC_ROCK);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL, BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL, BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.CACHOLONG_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CACHOLONG_BRICKS_STAIRS);
//        wallItem(BlockLoader.CACHOLONG_BRICKS_WALL, BlockLoader.CACHOLONG_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_CACHOLONG_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_CACHOLONG_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL, BlockLoader.CRACKED_CACHOLONG_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_CACHOLONG_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_CACHOLONG_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL, BlockLoader.MOSSY_CACHOLONG_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.BLACK_DEMON_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.BLACK_DEMON_BRICKS_STAIRS);
//        wallItem(BlockLoader.BLACK_DEMON_BRICKS_WALL, BlockLoader.BLACK_DEMON_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_BLACK_DEMON_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL, BlockLoader.CRACKED_BLACK_DEMON_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_BLACK_DEMON_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL, BlockLoader.MOSSY_BLACK_DEMON_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.BROWN_SANDSTONE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.BROWN_SANDSTONE_BRICKS_STAIRS);
//        wallItem(BlockLoader.BROWN_SANDSTONE_BRICKS_WALL, BlockLoader.BROWN_SANDSTONE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL, BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL, BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.DESERT_MUD_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.DESERT_MUD_BRICKS_STAIRS);
//        wallItem(BlockLoader.DESERT_MUD_BRICKS_WALL, BlockLoader.DESERT_MUD_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.CRACKED_DESERT_MUD_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CRACKED_DESERT_MUD_BRICKS_STAIRS);
//        wallItem(BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL, BlockLoader.CRACKED_DESERT_MUD_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_DESERT_MUD_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_DESERT_MUD_BRICKS_STAIRS);
//        wallItem(BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL, BlockLoader.MOSSY_DESERT_MUD_BRICKS);
//
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS);
//        wallItem(BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.HIGH_ELVEN_COBBLESTONE);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS);
//        wallItem(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE);
//
//        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
//        wallItem(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
//        wallItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE);
//
//        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
//        wallItem(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE);
//
//        evenSimplerBlockItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB);
//        evenSimplerBlockItem( BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
//        wallItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE);
//
//
//        evenSimplerBlockItem(BlockLoader.CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.BLACK_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.BLUE_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.BROWN_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.CYAN_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.GRAY_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.GREEN_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.LIGHT_BLUE_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.LIME_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.MAGENTA_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.ORANGE_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.PINK_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.PURPLE_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.RED_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.WHITE_CLAY_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.YELLOW_CLAY_TILING_SLAB);
//
//        evenSimplerBlockItem(BlockLoader.BLACK_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.BLUE_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.BROWN_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.CYAN_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.GRAY_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.GREEN_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.LIGHT_BLUE_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.LIME_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.MAGENTA_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.ORANGE_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.PINK_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.PURPLE_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.RED_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.WHITE_CLAY_TILING_STAIRS);
//        evenSimplerBlockItem(BlockLoader.YELLOW_CLAY_TILING_STAIRS);
//
//
//
//        evenSimplerBlockItem(BlockLoader.CHALK_SLAB);
//        evenSimplerBlockItem( BlockLoader.CHALK_STAIRS);
//        wallItem(BlockLoader.CHALK_WALL, BlockLoader.CHALK);
//
//        evenSimplerBlockItem(BlockLoader.CHALK_BRICKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CHALK_BRICKS_STAIRS);
//        wallItem(BlockLoader.CHALK_BRICKS_WALL, BlockLoader.CHALK_BRICKS);
//
//
//        evenSimplerBlockItem(BlockLoader.APPLE_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.APPLE_PLANKS_STAIRS);
//        fenceItem(BlockLoader.APPLE_FENCE, BlockLoader.APPLE_PLANKS);
//        evenSimplerBlockItem(BlockLoader.APPLE_FENCE_GATE);
//
//        saplingItem(BlockLoader.APPLE_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.ASPEN_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.ASPEN_PLANKS_STAIRS);
//        fenceItem(BlockLoader.ASPEN_FENCE, BlockLoader.ASPEN_PLANKS);
//        evenSimplerBlockItem(BlockLoader.ASPEN_FENCE_GATE);
//
//        saplingItem(BlockLoader.ASPEN_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.BAOBAB_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.BAOBAB_PLANKS_STAIRS);
//        fenceItem(BlockLoader.BAOBAB_FENCE, BlockLoader.BAOBAB_PLANKS);
//        evenSimplerBlockItem(BlockLoader.BAOBAB_FENCE_GATE);
//
//        evenSimplerBlockItem(BlockLoader.BEECH_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.BEECH_PLANKS_STAIRS);
//        fenceItem(BlockLoader.BEECH_FENCE, BlockLoader.BEECH_PLANKS);
//        evenSimplerBlockItem(BlockLoader.BEECH_FENCE_GATE);
//
//        saplingItem(BlockLoader.BEECH_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.CEDAR_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CEDAR_PLANKS_STAIRS);
//        fenceItem(BlockLoader.CEDAR_FENCE, BlockLoader.CEDAR_PLANKS);
//        evenSimplerBlockItem(BlockLoader.CEDAR_FENCE_GATE);
//
//        saplingItem(BlockLoader.CEDAR_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.CHERRY_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CHERRY_PLANKS_STAIRS);
//        fenceItem(BlockLoader.CHERRY_FENCE, BlockLoader.CHERRY_PLANKS);
//        evenSimplerBlockItem(BlockLoader.CHERRY_FENCE_GATE);
//
//        saplingItem(BlockLoader.CHERRY_SAPLING);
//        evenSimplerBlockItem(BlockLoader.CYPRESS_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.CYPRESS_PLANKS_STAIRS);
//        fenceItem(BlockLoader.CYPRESS_FENCE, BlockLoader.CYPRESS_PLANKS);
//        evenSimplerBlockItem(BlockLoader.CYPRESS_FENCE_GATE);
//
//        saplingItem(BlockLoader.CYPRESS_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.FIR_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.FIR_PLANKS_STAIRS);
//        fenceItem(BlockLoader.FIR_FENCE, BlockLoader.FIR_PLANKS);
//        evenSimplerBlockItem(BlockLoader.FIR_FENCE_GATE);
//
//        saplingItem(BlockLoader.FIR_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.GREEN_OAK_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.GREEN_OAK_PLANKS_STAIRS);
//        fenceItem(BlockLoader.GREEN_OAK_FENCE, BlockLoader.GREEN_OAK_PLANKS);
//        evenSimplerBlockItem(BlockLoader.GREEN_OAK_FENCE_GATE);
//
//        saplingItem(BlockLoader.GREEN_OAK_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.HOLLY_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.HOLLY_PLANKS_STAIRS);
//        fenceItem(BlockLoader.HOLLY_FENCE, BlockLoader.HOLLY_PLANKS);
//        evenSimplerBlockItem(BlockLoader.HOLLY_FENCE_GATE);
//
//        saplingItem(BlockLoader.HOLLY_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.LARCH_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.LARCH_PLANKS_STAIRS);
//        fenceItem(BlockLoader.LARCH_FENCE, BlockLoader.LARCH_PLANKS);
//        evenSimplerBlockItem(BlockLoader.LARCH_FENCE_GATE);
//
//        saplingItem(BlockLoader.LARCH_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.MAPLE_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.MAPLE_PLANKS_STAIRS);
//        fenceItem(BlockLoader.MAPLE_FENCE, BlockLoader.MAPLE_PLANKS);
//        evenSimplerBlockItem(BlockLoader.MAPLE_FENCE_GATE);
//
//        saplingItem(BlockLoader.MAPLE_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.BLACKTHORN_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.BLACKTHORN_PLANKS_STAIRS);
//        fenceItem(BlockLoader.BLACKTHORN_FENCE, BlockLoader.BLACKTHORN_PLANKS);
//        evenSimplerBlockItem(BlockLoader.BLACKTHORN_FENCE_GATE);
//
//        saplingItem(BlockLoader.BLACKTHORN_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.GHOST_GUM_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.GHOST_GUM_PLANKS_STAIRS);
//        fenceItem(BlockLoader.GHOST_GUM_FENCE, BlockLoader.GHOST_GUM_PLANKS);
//        evenSimplerBlockItem(BlockLoader.GHOST_GUM_FENCE_GATE);
//
//        saplingItem(BlockLoader.GHOST_GUM_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.WHITE_ASH_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.WHITE_ASH_PLANKS_STAIRS);
//        fenceItem(BlockLoader.WHITE_ASH_FENCE, BlockLoader.WHITE_ASH_PLANKS);
//        evenSimplerBlockItem(BlockLoader.WHITE_ASH_FENCE_GATE);
//
//        saplingItem(BlockLoader.WHITE_ASH_SAPLING);
//
//
//
//        evenSimplerBlockItem(BlockLoader.SILVER_SPRUCE_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.SILVER_SPRUCE_PLANKS_STAIRS);
//        fenceItem(BlockLoader.SILVER_SPRUCE_FENCE, BlockLoader.SILVER_SPRUCE_PLANKS);
//        evenSimplerBlockItem(BlockLoader.SILVER_SPRUCE_FENCE_GATE);
//
//        saplingItem(BlockLoader.SILVER_SPRUCE_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.OKOME_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.OKOME_PLANKS_STAIRS);
//        fenceItem(BlockLoader.OKOME_FENCE, BlockLoader.OKOME_PLANKS);
//        evenSimplerBlockItem(BlockLoader.OKOME_FENCE_GATE);
//
//        evenSimplerBlockItem(BlockLoader.PEAR_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.PEAR_PLANKS_STAIRS);
//        fenceItem(BlockLoader.PEAR_FENCE, BlockLoader.PEAR_PLANKS);
//        evenSimplerBlockItem(BlockLoader.PEAR_FENCE_GATE);
//
//        saplingItem(BlockLoader.PEAR_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.PINE_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.PINE_PLANKS_STAIRS);
//        fenceItem(BlockLoader.PINE_FENCE, BlockLoader.PINE_PLANKS);
//        evenSimplerBlockItem(BlockLoader.PINE_FENCE_GATE);
//
//        saplingItem(BlockLoader.PINE_SAPLING);
//
//        evenSimplerBlockItem(BlockLoader.PLUM_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.PLUM_PLANKS_STAIRS);
//        fenceItem(BlockLoader.PLUM_FENCE, BlockLoader.PLUM_PLANKS);
//        evenSimplerBlockItem(BlockLoader.PLUM_FENCE_GATE);
//
//        evenSimplerBlockItem(BlockLoader.RED_OAK_PLANKS_SLAB);
//        evenSimplerBlockItem( BlockLoader.RED_OAK_PLANKS_STAIRS);
//        fenceItem(BlockLoader.RED_OAK_FENCE, BlockLoader.RED_OAK_PLANKS);
//        evenSimplerBlockItem(BlockLoader.RED_OAK_FENCE_GATE);
//
//        saplingItem(BlockLoader.RED_OAK_SAPLING);
//        toBlock(BlockLoader.REDWOOD_LOG);
//        toBlock(BlockLoader.STRIPPED_REDWOOD_LOG);
//        toBlock(BlockLoader.REDWOOD_WOOD);
//        toBlock(BlockLoader.STRIPPED_REDWOOD_WOOD);
//        saplingItem(BlockLoader.REDWOOD_SAPLING);
//        woodBlock(BlockLoader.REDWOOD_PLANKS);
//        woodBlock(BlockLoader.REDWOOD_PLANKS_STAIRS);
//        woodBlock(BlockLoader.REDWOOD_PLANKS_SLAB);
//        woodenButton(BlockLoader.REDWOOD_BUTTON, "redwood");
//        woodenFence(BlockLoader.REDWOOD_FENCE, "redwood");
//        woodBlock(BlockLoader.REDWOOD_FENCE_GATE);
//        woodBlock(BlockLoader.REDWOOD_PRESSURE_PLATE);
//        woodBlockModel(BlockLoader.REDWOOD_TRAPDOOR, "redwood_trapdoor_bottom");
//        withExistingParent(BlockLoader.REDWOOD_BANISTER.getId().toString(), prefix("item/banister_item"))
//                .texture("texture", "block/redwood_planks");
//        withExistingParent(BlockLoader.REDWOOD_BALUSTRADE.getId().toString(), prefix("block/redwood_balustrade"));
//        simpleDoorItem(BlockLoader.REDWOOD_DOOR);
//
//
//        handheldItem(ItemLoader.ORC_AXE);
//        handheldItem(ItemLoader.ORC_HOE);
//        handheldItem(ItemLoader.ORC_PICKAXE);
//        handheldItem(ItemLoader.ORC_SHOVEL);
//        handheldItem(ItemLoader.ORC_SWORD);
//
//        handheldItem(ItemLoader.MAN_AXE);
//        handheldItem(ItemLoader.MAN_HOE);
//        handheldItem(ItemLoader.MAN_PICKAXE);
//        handheldItem(ItemLoader.MAN_SHOVEL);
//        handheldItem(ItemLoader.MAN_SWORD);
//
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_ROCK_SLAB);
//        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_ROCK_STAIRS);
//        wallItem(BlockLoader.HIGH_ELVEN_ROCK_WALL, BlockLoader.HIGH_ELVEN_ROCK);
//
//        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB);
//        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS);
//        wallItem(BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL, BlockLoader.DARK_HIGH_ELVEN_ROCK);
//
//        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB);
//        evenSimplerBlockItem( BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS);
//        wallItem(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL, BlockLoader.HIGH_ELVEN_ROCK);
//
//        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB);
//        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS);
//        //wallItem(BlockLoader.HIGH_ELVEN_BRICK_TILING_WALL, BlockLoader.HIGH_ELVEN_BRICK_TILING);
//
//        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB);
//        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS);
//        //wallItem(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_WALL, BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);
//
//        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB);
//        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS);
//        //wallItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_WALL, BlockLoader.HIGH_ELVEN_BRICK_TILING);
//
//        withExistingParent(ItemLoader.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
//        withExistingParent(ItemLoader.BOAR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
//        withExistingParent(ItemLoader.ALLIGATOR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
//        withExistingParent(ItemLoader.BADGER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        /**
         * ME
         */
        for (SimpleWallModel.Wall wall : SimpleWallModel.blocks) {
            Identifier id = Registries.BLOCK.getId(wall.wall());
            itemModelGenerator.register(wall.wall().asItem(), new Model(Optional.of(id.withPath("block/" + id.getPath() + "_inventory")), Optional.empty()));
        }

        for (Item item : SimpleItemModel.items) {
            itemModelGenerator.register(item, Models.GENERATED);
        }

        for (Item item : SimpleHandheldItemModel.items) {
            itemModelGenerator.register(item, Models.HANDHELD);
        }

        for (Item item : SimpleBigItemModel.items) {
            itemModelGenerator.register(item, CustomItemModels.BIG_WEAPON);
            itemModelGenerator.register(item, "_inventory", Models.HANDHELD);
        }

        for (Item item : SimpleBowItemModel.items) {
            for(int i = 0; i < 3; i++) {
                itemModelGenerator.register(item, "_pulling_" + i, Models.GENERATED);
            }
        }

        for (Item item : SimpleSpawnEggItemModel.items) {
            itemModelGenerator.register(item, CustomItemModels.TEMPLATE_SPAWN_EGG);
        }

        // Dyeables needs to be done manually (because of layers)


    }






}
