package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.register.NaturalStoneBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;

import java.util.Arrays;
import java.util.List;

public class OreRockSets {
    public static final float STONE_STRENGTH = 2.0f;
    public static final float DEEPSLATE_STRENGTH = 2.5f;
    public static final float DIFTOMIN_STRENGTH = 3.0f;
    public static final float EPMOSTO_STRENGTH = 4.0f;


    public static OreRockSet STONE = registerOreSet("", STONE_STRENGTH,
            List.of(ORES.TIN_ORE, ORES.SILVER_ORE), Blocks.STONE);

    public static OreRockSet DEEPSLATE = registerOreSet("deepslate_", DEEPSLATE_STRENGTH,
            Arrays.asList(ORES.TIN_ORE), Blocks.DEEPSLATE);

    public static OreRockSet LIMESTONE = registerOreSet("limestone_", DIFTOMIN_STRENGTH,
            Arrays.asList(ORES.TIN_ORE, ORES.SILVER_ORE, ORES.GOLD_ORE, ORES.IRON_ORE), StoneSets.LIMESTONE.block());



    public static OreRockSet[] sets = new OreRockSet[] {
            STONE,
            DEEPSLATE,
            LIMESTONE
    };

    public record OreRockSet(Block coal_ore, Block copper_ore, Block tin_ore, Block lead_ore, Block silver_ore, Block gold_ore, Block iron_ore, Block mithril_ore, Block origin) {
    }


    public static OreRockSet registerOreSet(String rockName, float strength_mult, List<ORES> ores, Block origin) {

        Block coal_ore = null;
        Block copper_ore = null;
        Block tin_ore = null;
        Block lead_ore = null;
        Block silver_ore = null;
        Block gold_ore = null;
        Block iron_ore = null;
        Block mithril_ore = null;

        if(ores.contains(ORES.COAL_ORE)){
            coal_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "coal_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        if(ores.contains(ORES.COPPER_ORE)) {
            copper_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "copper_ore", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        if(ores.contains(ORES.TIN_ORE)) {
            tin_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "tin_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        if(ores.contains(ORES.LEAD_ORE)) {
            lead_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "lead_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        if(ores.contains(ORES.SILVER_ORE)) {
            silver_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "silver_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        if(ores.contains(ORES.GOLD_ORE)) {
            gold_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "gold_ore", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        if(ores.contains(ORES.IRON_ORE)) {
            iron_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "iron_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        if(ores.contains(OreRockSets.ORES.MITHRIL_ORE)) {
            mithril_ore = NaturalStoneBlocks.registerStoneBlock(
                    rockName + "mithril_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                            STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), true);
        }

        return new OreRockSet(coal_ore, copper_ore, tin_ore, lead_ore, silver_ore, gold_ore, iron_ore, mithril_ore, origin);
    }

    enum ORES{
        COAL_ORE,
        COPPER_ORE,
        TIN_ORE,
        LEAD_ORE,
        SILVER_ORE,
        GOLD_ORE,
        IRON_ORE,
        MITHRIL_ORE,
        ;
    }




    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering OreSets for " + Edumia.MOD_ID);
    }
}
