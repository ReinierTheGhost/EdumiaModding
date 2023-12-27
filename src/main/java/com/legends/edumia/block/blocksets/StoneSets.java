package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.block.BlockRegisters;
import com.legends.edumia.block.EdumiaPillarBlock;
import com.legends.edumia.block.WoodBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class StoneSets {
    public static final float STONE_STRENGTH = 2.0f;

    public static StoneSet[] naturalSets = new StoneSet[]{

    };



    public record StoneSet(Block block, Block slab, Block stair, Block wall){

    }

    public static StoneSet registerStoneSet(String name, float strength) {

        Block stone = BlockRegisters.registerStoneBlock(name, new Block(AbstractBlock.Settings.copy(Blocks.STONE)
                .strength(strength).sounds(BlockSoundGroup.STONE)));

        Block slab = BlockRegisters.registerStoneBlock(name + "_slab", new AxialSlabBlock(stone));

        Block stairs = BlockRegisters.registerStoneBlock(name + "_stairs", new StairsBlock(stone.getDefaultState(),
                FabricBlockSettings.copyOf(stone).strength(strength).sounds(BlockSoundGroup.STONE)));

        Block wall = BlockRegisters.registerStoneBlock(name + "_wall", new WallBlock(AbstractBlock.Settings.copy(stone)
                .strength(strength).sounds(BlockSoundGroup.STONE)));

        return new StoneSet(stone, slab, stairs, wall);
    }

    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering OreSets for " + Edumia.MOD_ID);
    }


}
