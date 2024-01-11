package com.legends.edumia.datageneration.edumia;

import com.legends.edumia.Edumia;
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
        for (SimpleFallenLeavesBlockModel.FallenLeaves block : SimpleFallenLeavesBlockModel.blocks){
            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.texture());

            Identifier model = ModModels.TEMPLATE_FALLEN_LEAVES.upload(block.leaves(), texturedModel.getTextures(), blockStateModelGenerator.modelCollector);

            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block.leaves(), model));
        }

//        for (SimpleCrystalBlockModel.Crystals block : SimpleCrystalBlockModel.blocks){
//            TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(block.crystal());
//
//            Identifier model = ModModels.CRYSTAL_CLUSTER.upload(block.crystal(), texturedModel.getTextures(), blockStateModelGenerator.modelCollector);
//
//            blockStateModelGenerator.blockStateCollector.accept(EdumiaBlockStateModelGenerator.createCrystalBlockState(block.crystal(), model));
//        }

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


        blockStateModelGenerator.registerAxisRotated(BlockLoader.CHISELED_ANDESITE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockLoader.CHISELED_DIORITE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockLoader.CHISELED_GRANITE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockLoader.CHISELED_DRIPSTONE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockLoader.DIRTY_CHALK, TexturedModel.CUBE_COLUMN);

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

        blockStateModelGenerator.registerTintableCross(BlockLoader.ARID_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(BlockLoader.BLACK_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(BlockLoader.FLAX_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(BlockLoader.BEACH_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(BlockLoader.TALL_BEACH_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(BlockLoader.FROSTED_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(BlockLoader.TALL_FROSTED_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);


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

        itemModelGenerator.register(ItemLoader.BROCCOLI, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_WHITE_JADE_PETALS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_HIBISCUS_PETALS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_SAKURA_PETALS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_WHITE_DRAGON_PETALS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_MINT_LEAVES, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_LILY_PETALS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_LEAF, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_JASMINE_PETALS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TEA_CINNAMON_STICK, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.SPINACH, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RICE_BALL, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RAMEN_VEGI, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RAMEN_SHRIMPS, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RAMEN_PORK, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RAMEN_BEEF, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.PAPRIKA_GREEN, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.LETTUCE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RAMEN, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RED_GRAPES, Models.GENERATED);
        itemModelGenerator.register(ItemLoader.RICE, Models.GENERATED);







//
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
