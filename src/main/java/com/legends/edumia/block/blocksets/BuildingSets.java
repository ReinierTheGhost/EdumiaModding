package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.block.BlockRegisters;
import com.legends.edumia.block.EdumiaPillarBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class BuildingSets {

    public static final float STONE_STRENGTH = 2.0f;

    public static BuildSet MOSSY_GENSAI_BRICK = registerBuildingSet("mossy_gensai", STONE_STRENGTH, false);
    public static BuildSet TRIMMED_GENSAI_BRICK = registerBuildingSet("trimmed_gensai", STONE_STRENGTH, false);
    public static BuildSet GENSAI_BRICK = registerBuildingSet("gensai", STONE_STRENGTH, true);

    public static BuildSet[] buildSets = new BuildSet[]{
            MOSSY_GENSAI_BRICK,
            TRIMMED_GENSAI_BRICK,
            GENSAI_BRICK

    };

    public record BuildSet(Block block, Block slab, Block stair, Block wall, Block pillar){
    }

    public static BuildSet registerBuildingSet(String name, float strength, boolean hasPillar){

        Block stone = BlockRegisters.registerbuildingBlock(name + "_bricks", new Block(AbstractBlock.Settings.copy(Blocks.STONE)
                .strength(strength).sounds(BlockSoundGroup.STONE)));


        Block slab = BlockRegisters.registerbuildingBlock(name + "_bricks_slab", new AxialSlabBlock(stone));

        Block stairs = BlockRegisters.registerbuildingBlock(name + "_bricks_stairs", new StairsBlock(stone.getDefaultState(),
                FabricBlockSettings.copyOf(stone).strength(strength).sounds(BlockSoundGroup.STONE)));

        Block wall = BlockRegisters.registerbuildingBlock(name + "_bricks_wall", new WallBlock(AbstractBlock.Settings.copy(stone)
                .strength(strength).sounds(BlockSoundGroup.STONE)));

        Block pillar = null;
        if (hasPillar){
            pillar = BlockRegisters.registerbuildingBlock(name + "_pillar", new EdumiaPillarBlock(AbstractBlock.Settings.copy(stone)
                    .strength(strength).sounds(BlockSoundGroup.STONE)));
        }

        return new BuildSet(stone, slab, stairs, wall, pillar);
    }

    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering OreSets for " + Edumia.MOD_ID);
    }
}
