package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.register.NaturalStoneBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class OreRockSets {
    public static final float STONE_STRENGTH = 2.0f;
    public static final float DEEPSLATE_STRENGTH = 2.5f;

    public static CompleteOreRockSet DEEPSLATE = registerVanillaOreSet("deepslate_", DEEPSLATE_STRENGTH, null);
    public static CompleteOreRockSet STONE = registerVanillaOreSet("", STONE_STRENGTH, null);

    public static OreRockSet[] sets = new OreRockSet[] {

    };

    public static CompleteOreRockSet[] vanillaSets = new CompleteOreRockSet[]{
            DEEPSLATE,
            STONE
    };

    public record OreRockSet(Block iron_ore, Block gold_ore, Block copper_ore, Block coal_ore, Block tin_ore) {
    }

    public record CompleteOreRockSet(Block tin_ore) {
    }

    public static OreRockSet registerOreSet(String rockName, float strength_mult, Block source) {

        Block iron_ore = NaturalStoneBlocks.registerStoneBlock(
                rockName + "_iron_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                        STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool().dropsLike(Blocks.IRON_ORE)), false);

        Block gold_ore = NaturalStoneBlocks.registerStoneBlock(
                rockName + "_gold_ore", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).strength(
                        STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool().dropsLike(Blocks.GOLD_ORE)), false);

        Block copper_ore = NaturalStoneBlocks.registerStoneBlock(
                rockName + "_copper_ore", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).strength(
                        STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool().dropsLike(Blocks.COPPER_ORE)), false);

        Block coal_ore = NaturalStoneBlocks.registerStoneBlock(
                rockName + "_coal_ore", new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE).strength(
                        STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool().dropsLike(Blocks.COAL_ORE)), false);

        Block tin_ore = NaturalStoneBlocks.registerStoneBlock(
                rockName + "_tin_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                        STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), false);


        return new OreRockSet(iron_ore, gold_ore, copper_ore, coal_ore, tin_ore);
    }

    public static CompleteOreRockSet registerVanillaOreSet(String rockname, float strength_mult, Block source) {
        Block tin_ore = NaturalStoneBlocks.registerStoneBlock(
                rockname + "tin_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(
                        STONE_STRENGTH * strength_mult, 3*strength_mult).requiresTool()), false);

        return new CompleteOreRockSet(tin_ore);
    }




    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering OreSets for " + Edumia.MOD_ID);
    }
}
