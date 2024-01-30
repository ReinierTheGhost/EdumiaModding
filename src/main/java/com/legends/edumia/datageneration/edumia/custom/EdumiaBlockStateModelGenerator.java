package com.legends.edumia.datageneration.edumia.custom;

import com.google.gson.JsonElement;
import com.legends.edumia.block.*;
import com.legends.edumia.block.blocksets.GlassSets;
import com.legends.edumia.block.plants.ReedsBlock;
import com.legends.edumia.block.properties.ArchShape;
import com.legends.edumia.block.properties.BidirectionalShape;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.block.enums.StairShape;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class EdumiaBlockStateModelGenerator {

    public final Consumer<BlockStateSupplier> blockStateCollector;

    public final BiConsumer<Identifier, Supplier<JsonElement>> modelCollector;

    public EdumiaBlockStateModelGenerator(Consumer<BlockStateSupplier> blockStateCollector, BiConsumer<Identifier, Supplier<JsonElement>> modelCollector) {
        this.blockStateCollector = blockStateCollector;
        this.modelCollector = modelCollector;
    }

    public static BlockStateSupplier createCrystalBlockState(Block block, Identifier model){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(CrystalBlock.CRYSTAL_FACING)
                .register(Direction.UP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R0)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.DOWN, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R0)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.WEST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.EAST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))

                .register(Direction.NORTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R0)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                .register(Direction.SOUTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R0)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
        );
    }

    public static BlockStateSupplier createTwoMeterArchBlockState(Block block, Identifier model){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(ArchTwoMeter.DIRECTION, ArchTwoMeter.TYPE_UPDOWN)
                .register(Direction.EAST, BlockHalf.BOTTOM, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180))
                .register(Direction.EAST, BlockHalf.TOP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.NORTH, BlockHalf.BOTTOM, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180))
                .register(Direction.NORTH, BlockHalf.TOP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                .register(Direction.SOUTH, BlockHalf.BOTTOM, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180))
                .register(Direction.SOUTH, BlockHalf.TOP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true))

                .register(Direction.WEST, BlockHalf.BOTTOM, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                        .put(VariantSettings.X, VariantSettings.Rotation.R180))
                .register(Direction.WEST, BlockHalf.TOP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
        );
    }
    public static BlockStateSupplier createSmallArchBlockState(Block block, Identifier model){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(ArchSmall.DIRECTION)
                .register(BidirectionalShape.NORTH_SOUTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model))
                .register(BidirectionalShape.EAST_WEST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
        );
    }

    public static BlockStateSupplier createArrowSlitBlockState(Block block, Identifier model){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(ArrowSlit.DIRECTION)
                .register(Direction.EAST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.NORTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true))
                .register(Direction.WEST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.SOUTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, model)
                        .put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
        );
    }

    public static BlockStateSupplier createBalustradeBlockState(Block block, Identifier base, Identifier directional){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Balustrade.AXIS)

                .register(Direction.Axis.X, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, directional)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true))
                .register(Direction.Axis.Y, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, base)
                        .put(VariantSettings.UVLOCK, true))
                .register(Direction.Axis.Z, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, directional)
                        .put(VariantSettings.UVLOCK, true))
        );
    }

    public static BlockStateSupplier createReedsBlockState(Block block, Identifier one, Identifier two_top, Identifier two_top_water,
                                                           Identifier two_bottom, Identifier three_top, Identifier three_middle,
                                                           Identifier three_bottom){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap
                .create(ReedsBlock.REEDS_TYPE, Properties.WATERLOGGED)

                .register(ReedsBlock.Type.ONE, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, one))
                .register(ReedsBlock.Type.ONE, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, one))
                .register(ReedsBlock.Type.TWO_TOP, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two_top))
                .register(ReedsBlock.Type.TWO_TOP, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two_top_water))
                .register(ReedsBlock.Type.TWO_BOTTOM, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two_bottom))
                .register(ReedsBlock.Type.TWO_BOTTOM, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two_bottom))
                .register(ReedsBlock.Type.THREE_TOP, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three_top))
                .register(ReedsBlock.Type.THREE_TOP, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three_top))
                .register(ReedsBlock.Type.THREE_MIDDLE, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three_middle))
                .register(ReedsBlock.Type.THREE_MIDDLE, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three_middle))
                .register(ReedsBlock.Type.THREE_BOTTOM, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three_bottom))
                .register(ReedsBlock.Type.THREE_BOTTOM, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three_bottom))
        );
    }

    public static BlockStateSupplier createArchBlockState(Block block, Identifier one, Identifier two, Identifier three, Identifier middle){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Arch.FORM, Arch.FACING)

                .register(ArchShape.ONE, Direction.SOUTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, one)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(ArchShape.ONE, Direction.WEST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, one)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(ArchShape.ONE, Direction.NORTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, one)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(ArchShape.ONE, Direction.EAST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, one))

                .register(ArchShape.TWO, Direction.SOUTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(ArchShape.TWO, Direction.WEST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two))
                .register(ArchShape.TWO, Direction.NORTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(ArchShape.TWO, Direction.EAST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, two)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                .register(ArchShape.THREE, Direction.SOUTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(ArchShape.THREE, Direction.WEST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three))
                .register(ArchShape.THREE, Direction.NORTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(ArchShape.THREE, Direction.EAST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, three)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                .register(ArchShape.THREE_MIDDLE, Direction.SOUTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, middle)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(ArchShape.THREE_MIDDLE, Direction.WEST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, middle))
                .register(ArchShape.THREE_MIDDLE, Direction.NORTH, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, middle)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(ArchShape.THREE_MIDDLE, Direction.EAST, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, middle)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
        );
    }

    public static BlockStateSupplier createPillarBlockState(Block block, Identifier pillar, Identifier top, Identifier middle, Identifier bottom){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(EdumiaPillarBlock.AXIS,
                EdumiaPillarBlock.ABOVE, EdumiaPillarBlock.BELOW)

                .register(Direction.Axis.X, false, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, pillar)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90))
                .register(Direction.Axis.X, false, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, top)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90))
                .register(Direction.Axis.X, true, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, bottom)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90))
                .register(Direction.Axis.X, true, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, middle)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90))

                .register(Direction.Axis.Y, false, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, pillar))
                .register(Direction.Axis.Y, false, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, top))
                .register(Direction.Axis.Y, true, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, bottom))
                .register(Direction.Axis.Y, true, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, middle))

                .register(Direction.Axis.Z, false, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, pillar)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270))
                .register(Direction.Axis.Z, false, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, top)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270))
                .register(Direction.Axis.Z, true, false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, bottom)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270))
                .register(Direction.Axis.Z, true, true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, middle)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270))

        );
    }

    public static BlockStateSupplier createVerticalCornerBlockState(Block block, Identifier layer1, Identifier layer2,
                                                                    Identifier layer3, Identifier layer4){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(VerticalCorner.DIRECTION,
                        VerticalCorner.LAYERS)

                .register(Direction.EAST, 1, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer1).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.EAST, 2, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer2).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.EAST, 3, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer3).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.EAST, 4, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer4).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))

                .register(Direction.SOUTH, 1, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer1).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.SOUTH, 2, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer2).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.SOUTH, 3, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer3).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.SOUTH, 4, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer4).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))

                .register(Direction.WEST, 1, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer1).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.WEST, 2, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer2).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.WEST, 3, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer3).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.WEST, 4, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer4).put(VariantSettings.UVLOCK, true)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                .register(Direction.NORTH, 1, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer1).put(VariantSettings.UVLOCK, true))
                .register(Direction.NORTH, 2, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer2).put(VariantSettings.UVLOCK, true))
                .register(Direction.NORTH, 3, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer3).put(VariantSettings.UVLOCK, true))
                .register(Direction.NORTH, 4, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, layer4).put(VariantSettings.UVLOCK, true)
                        )


        );
    }

    public static BlockStateSupplier createLayerBlockState(Block block, Identifier layer1, Identifier layer2, Identifier layer3,Identifier layer4,
                                                           Identifier layer5, Identifier layer6, Identifier layer7, Identifier full){
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap
                .create(Properties.LAYERS).register((height) -> {
                    BlockStateVariant var10000 = BlockStateVariant.create();
                    VariantSetting var10001 = VariantSettings.MODEL;

                    Identifier var2;
                    if (height < 8) {
                        Block var10002 = block;
                        int var10003 = height;
                        var2 = ModelIds.getBlockSubModelId(var10002, "_height" + var10003 * 2);
                    } else {
                        var2 = full;
                    }
                    return var10000.put(var10001, var2);
                }));
    }

    public void registerSingleton(Block block, TexturedModel.Factory modelFactory) {
        this.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block,
                modelFactory.upload(block, this.modelCollector)));
    }
    public void registerSimpleCubeAll(Block block) {
        this.registerSingleton(block, TexturedModel.CUBE_ALL);
    }
    public void registerGlassPane(Block glass, Block glassPane) {
        this.registerSimpleCubeAll(glass);
        TextureMap textureMap = TextureMap.paneAndTopForEdge(glass, GlassSets.FINE_GLASS.pane());
        Identifier identifier = Models.TEMPLATE_GLASS_PANE_POST.upload(glassPane, textureMap, this.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_GLASS_PANE_SIDE.upload(glassPane, textureMap, this.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(glassPane, textureMap, this.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(glassPane, textureMap, this.modelCollector);
        Identifier identifier5 = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(glassPane, textureMap, this.modelCollector);
        Item item = glassPane.asItem();
        Models.GENERATED.upload(ModelIds.getItemModelId(item), TextureMap.layer0(glass), this.modelCollector);
        this.blockStateCollector.accept(MultipartBlockStateSupplier.create(glassPane).with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with((When)When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)).with((When)When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)).with((When)When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)).with((When)When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)).with((When)When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }
    public static BlockStateSupplier createAxisSlabBlockState(Block block, Identifier bottomModelId, Identifier topModelId,
                                                                 Identifier fullModelId) {
        return VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap
                .create(Properties.AXIS, Properties.SLAB_TYPE)

                .register(Direction.Axis.Y, SlabType.BOTTOM, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, bottomModelId))
                .register(Direction.Axis.Y, SlabType.TOP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, topModelId))
                .register(Direction.Axis.Y, SlabType.DOUBLE, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, fullModelId))

                .register(Direction.Axis.Z, SlabType.BOTTOM, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, bottomModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true))
                .register(Direction.Axis.Z, SlabType.TOP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, topModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true))
                .register(Direction.Axis.Z, SlabType.DOUBLE, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, fullModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R270)
                        .put(VariantSettings.UVLOCK, true))

                .register(Direction.Axis.X, SlabType.BOTTOM, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, bottomModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true))
                .register(Direction.Axis.X, SlabType.TOP, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, topModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true))
                .register(Direction.Axis.X, SlabType.DOUBLE, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, fullModelId)
                        .put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90)
                        .put(VariantSettings.UVLOCK, true))


        );
    }



    
}
