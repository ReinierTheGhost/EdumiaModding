package com.legends.edumia.datageneration.edumia;

import com.legends.edumia.block.blocksets.BuildingSets;
import com.legends.edumia.block.blocksets.ClayTilingSets;
import com.legends.edumia.block.blocksets.StoneSets;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import com.legends.edumia.core.BlockLoader;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.server.recipe.RecipeProvider {

    protected RecipeProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
//        for (SimpleBlockSets.SimpleBlockSet record : SimpleBlockSets.sets) {
//            if(record.source() != null) createBrickRecipe(exporter, record.source(), record.base(), 4);
//
//            createSlabsRecipe(exporter, record.base(), record.slab());
//            createStairsRecipe(exporter, record.base(), record.stairs());
//            createWallsRecipe(exporter, record.base(), record.wall());
//        }

        createBrickRecipe(exporter, Blocks.TERRACOTTA, ClayTilingSets.CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.BLACK_TERRACOTTA, ClayTilingSets.BLACK_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.BLUE_TERRACOTTA, ClayTilingSets.BLUE_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.BROWN_TERRACOTTA, ClayTilingSets.BROWN_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.CYAN_TERRACOTTA, ClayTilingSets.CYAN_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.GRAY_TERRACOTTA, ClayTilingSets.GRAY_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.GREEN_TERRACOTTA, ClayTilingSets.GREEN_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, ClayTilingSets.LIGHT_BLUE_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, ClayTilingSets.LIGHT_GRAY_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.LIME_TERRACOTTA, ClayTilingSets.LIME_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.MAGENTA_TERRACOTTA, ClayTilingSets.MAGENTA_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.ORANGE_TERRACOTTA, ClayTilingSets.ORANGE_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.PINK_TERRACOTTA, ClayTilingSets.PINK_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.PURPLE_TERRACOTTA, ClayTilingSets.PURPLE_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.RED_TERRACOTTA, ClayTilingSets.RED_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.WHITE_TERRACOTTA, ClayTilingSets.WHITE_CLAY_TILING.block(), 4);
        createBrickRecipe(exporter, Blocks.YELLOW_TERRACOTTA, ClayTilingSets.YELLOW_CLAY_TILING.block(), 4);

        for(ClayTilingSets.ClayTilingSet record : ClayTilingSets.sets){
            createSlabsRecipe(exporter, record.block(), record.slab());
            createStairsRecipe(exporter, record.block(), record.stairs());
            createCornerRecipe(exporter, record.block(), record.corner());
        }
//
        for (StoneSets.StoneSet record : StoneSets.naturalSets){
            createWallsRecipe(exporter, record.block(), record.wall());
            createSlabsRecipe(exporter, record.block(), record.slab());
            createStairsRecipe(exporter, record.block(), record.stair());
        }

        for (BuildingSets.BuildSet record : BuildingSets.buildSets){
            createWallsRecipe(exporter, record.block(), record.wall());
            createSlabsRecipe(exporter, record.block(), record.slab());
            createStairsRecipe(exporter, record.block(), record.stair());
            if (record.pillar() != null) createPillarRecipe(exporter, record.block(), record.pillar());
        }

        for (WoodBlockSets.SimpleBlockSet record : WoodBlockSets.sets) {
            createBrickRecipe(exporter, record.log(), record.wood(), 3);
            createWallsRecipe(exporter, record.wood(), record.woodWall());
            createSlabsRecipe(exporter, record.planks(), record.planksSlab());
            createStairsRecipe(exporter, record.planks(), record.planksStairs());
            createPillarRecipe(exporter, record.log(), record.beam());

            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, record.planks())
                    .input(record.log())
                    .criterion(FabricRecipeProvider.hasItem(record.log()),
                            FabricRecipeProvider.conditionsFromItem(record.planks()))
                    .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, record.planksFence(), 3)
                    .pattern("lsl")
                    .pattern("lsl")
                    .input('l', record.planks())
                    .input('s', Items.STICK)
                    .criterion(FabricRecipeProvider.hasItem(record.planks()),
                            FabricRecipeProvider.conditionsFromItem(record.planks()))
                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, record.planksGate(), 1)
                    .pattern("sls")
                    .pattern("sls")
                    .input('l', record.planks())
                    .input('s', Items.STICK)
                    .criterion(FabricRecipeProvider.hasItem(record.planks()),
                            FabricRecipeProvider.conditionsFromItem(record.planks()))
                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .offerTo(exporter);
        }

        createMossyRecipe(exporter, StoneSets.HIGH_ELVEN_COBBLESTONE.block(), StoneSets.MOSSY_HIGH_ELVEN_COBBLESTONE.block());
        createMossyRecipe(exporter, StoneSets.DARK_HIGH_ELVEN_COBBLESTONE.block(), StoneSets.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.block());
        createMossyRecipe(exporter, StoneSets.LIGHT_HIGH_ELVEN_COBBLESTONE.block(), StoneSets.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.block());

        createMossyRecipe(exporter, BuildingSets.BASALT_BRICKS.block(), BuildingSets.MOSSY_BASALT_BRICKS.block());
        createMossyRecipe(exporter, BuildingSets.DESERT_MUD_BRICKS.block(), BuildingSets.MOSSY_DESERT_MUD_BRICKS.block());
        createMossyRecipe(exporter, BuildingSets.RED_GENSAI_BRICK.block(), BuildingSets.MOSSY_RED_GENSAI_BRICK.block());
        createMossyRecipe(exporter, BuildingSets.BLUE_BRICKS.block(), BuildingSets.MOSSY_BLUE_BRICKS.block());
        createMossyRecipe(exporter, BuildingSets.CACHOLONG_BRICKS.block(), BuildingSets.MOSSY_CACHOLONG_BRICKS.block());
        createMossyRecipe(exporter, BuildingSets.BLACK_DEMON_BRICKS.block(), BuildingSets.MOSSY_BLACK_DEMON_BRICKS.block());
        createMossyRecipe(exporter, BuildingSets.HIGH_ELVEN.block(), BuildingSets.MOSSY_HIGH_ELVEN.block());
        createMossyRecipe(exporter, BuildingSets.BROWN_SANDSTONE_BRICKS.block(), BuildingSets.MOSSY_BROWN_SANDSTONE_BRICKS.block());
        createMossyRecipe(exporter, BuildingSets.LIGHT_HIGH_ELVEN.block(), BuildingSets.MOSSY_LIGHT_HIGH_ELVEN.block());
        createMossyRecipe(exporter, BuildingSets.DARK_HIGH_ELVEN.block(), BuildingSets.MOSSY_DARK_HIGH_ELVEN.block());
        createMossyRecipe(exporter, BuildingSets.VOLCANIC_DEMON_BRICKS.block(), BuildingSets.MOSSY_VOLCANIC_DEMON_BRICKS.block());
        createMossyRecipe(exporter, BuildingSets.GENSAI_BRICK.block(), BuildingSets.MOSSY_GENSAI_BRICK.block());

        createPillarRecipe(exporter, Blocks.STONE_BRICKS, BlockLoader.STONE_PILLAR);
        createPillarRecipe(exporter, Blocks.SANDSTONE, BlockLoader.SANDSTONE_PILLAR);
        createPillarRecipe(exporter, Blocks.BRICKS, BlockLoader.BRICK_PILLAR);

        createBrickRecipe(exporter, StoneSets.HIGH_ELVEN_ROCK.block(), BuildingSets.HIGH_ELVEN.block(), 4);
        createBrickRecipe(exporter, StoneSets.DARK_HIGH_ELVEN_ROCK.block(), BuildingSets.DARK_HIGH_ELVEN.block(), 4);
        createBrickRecipe(exporter, StoneSets.LIGHT_HIGH_ELVEN_ROCK.block(), BuildingSets.LIGHT_HIGH_ELVEN.block(), 4);
        createBrickRecipe(exporter, StoneSets.CHALK.block(), BuildingSets.CHALK.block(), 4);

        createStoneCutterRecipe(exporter, BuildingSets.HIGH_ELVEN.block(), BuildingSets.SMALL_HIGH_ELVEN.block());
        createStoneCutterRecipe(exporter, BuildingSets.DARK_HIGH_ELVEN.block(), BuildingSets.SMALL_DARK_HIGH_ELVEN.block());
        createStoneCutterRecipe(exporter, BuildingSets.LIGHT_HIGH_ELVEN.block(), BuildingSets.SMALL_LIGHT_HIGH_ELVEN.block());

        createBrickRecipe(exporter, BuildingSets.SMALL_HIGH_ELVEN.block(), BlockLoader.HIGH_ELVEN_BRICK_TILING, 4);
        createBrickRecipe(exporter, BuildingSets.SMALL_DARK_HIGH_ELVEN.block(), BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING, 4);
        createBrickRecipe(exporter, BuildingSets.SMALL_LIGHT_HIGH_ELVEN.block(), BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING, 4);
    }
    private void createPillarRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 3)
                .pattern("l")
                .pattern("l")
                .pattern("l")
                .input('l', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }
    private void createMossyRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output)
                .input(input).input(Blocks.VINE).group("mossy_" + input).criterion("has_vine",
                        VanillaRecipeProvider.conditionsFromItem(Blocks.VINE))
                .offerTo(exporter, VanillaRecipeProvider.convertBetween(input, Blocks.VINE));
    }

    private void createBrickRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output, int count) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, count)
                .pattern("ll")
                .pattern("ll")
                .input('l', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    private void createCornerRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("lll")
                .pattern(" ll")
                .pattern("  l")
                .input('l', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    private void createStairsRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("l  ")
                .pattern("ll ")
                .pattern("lll")
                .input('l', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }

    private void createSlabsRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .pattern("lll")
                .input('l', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }


    private void createWallsRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6)
                .pattern("lll")
                .pattern("lll")
                .input('l', input)
                .criterion(FabricRecipeProvider.hasItem(input),
                        FabricRecipeProvider.conditionsFromItem(input))
                .offerTo(exporter);
    }
    private void createStoneCutterRecipe(Consumer<RecipeJsonProvider> exporter, Block input, Block output) {
        VanillaRecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, output, input);
    }
}

