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
        for (SimpleWoodBlockModel.WoodBlocks block : SimpleWoodBlockModel.blocks){
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());

            Identifier model = Models.CUBE_ALL.upload(block.wood(), texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createAxisRotatedBlockState(block.wood(), model));
        }

        for (Block block : SimpleBlockModel.blocks) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }

        for (Block block : SimpleLeavesModel.blocks){
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block);

            Identifier leaves = Models.LEAVES.upload(block, texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, leaves));
        }

        for (SimplePillarModel.Pillar block : SimplePillarModel.blocks) {
            blockStateModelGenerator.registerAxisRotated(block.base(), TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
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

        BlockStateModelGenerator.BlockTexturePool CGB = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.CRACKED_GREEN_BASALT);
        CGB.stairs( BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
        CGB.wall( BlockLoader.CRACKED_GREEN_BASALT_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_BASALT);


        BlockStateModelGenerator.BlockTexturePool blue_bricks = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.BLUE_BRICK);
        blue_bricks.stairs( BlockLoader.BLUE_BRICK_STAIRS);
        blue_bricks.wall( BlockLoader.BLUE_BRICK_WALL);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_CACHOLONG_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_BLACK_DEMON_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_BLUE_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_DEMON_BASALT_BRICKS);


        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_VOLCANIC_DEMON_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.CARVED_RED_GENSAI_BRICKS);





//
//        blockStateModelGenerator.registerSimpleCubeAll(BlockLoader.BROWN_SANDSTONE_SLATES);
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

        BlockStateModelGenerator.BlockTexturePool HEBT = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.HIGH_ELVEN_BRICK_TILING);
        HEBT.stairs( BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool DHEBT = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);
        DHEBT.stairs( BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS);

        BlockStateModelGenerator.BlockTexturePool LHEBT = blockStateModelGenerator
                .registerCubeAllModelTexturePool(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING);
        LHEBT.stairs( BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
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
