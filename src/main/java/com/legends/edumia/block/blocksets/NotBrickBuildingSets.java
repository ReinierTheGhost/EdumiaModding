package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.block.BlockRegisters;
import com.legends.edumia.block.EdumiaPillarBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class NotBrickBuildingSets {

    public static final float STONE_STRENGTH = 2.0f;

    public static BuildSet POLISHED_DRIPSTONE = registerBuildingSet("polished_dripstone", STONE_STRENGTH, false);

    public static BuildSet[] buildSets = new BuildSet[]{
            POLISHED_DRIPSTONE,
    };

    public record BuildSet(Block block, Block slab, Block stair, Block wall){
    }

    public static BuildSet registerBuildingSet(String name, float strength, boolean hasWall){

        Block stone = BlockRegisters.registerbuildingBlock(name, new Block(AbstractBlock.Settings.copy(Blocks.STONE)
                .strength(strength).sounds(BlockSoundGroup.STONE).requiresTool()));


        Block slab = BlockRegisters.registerbuildingBlock(name + "_slab", new AxialSlabBlock(stone));

        Block stairs = BlockRegisters.registerbuildingBlock(name + "_stairs", new StairsBlock(stone.getDefaultState(),
                FabricBlockSettings.copyOf(stone).strength(strength).sounds(BlockSoundGroup.STONE).requiresTool()));

        Block wall = null;
        if (hasWall){
            wall = BlockRegisters.registerbuildingBlock(name + "_wall", new WallBlock(AbstractBlock.Settings.copy(stone)
                    .strength(strength).sounds(BlockSoundGroup.STONE).requiresTool()));
        }




        return new BuildSet(stone, slab, stairs, wall);
    }

    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering OreSets for " + Edumia.MOD_ID);
    }
}
