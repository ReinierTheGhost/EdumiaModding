package com.legends.edumia.block;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.CreativeTabLoader;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.legends.edumia.block.blocksets.WoodBlockSets.LEAVES_STRENGTH;

public class ModNatureBlocks {

    public static final Block GHOST_GUM_LEAVES = ModNatureBlocks.registerPlantBlock("ghost_gum_leaves",
            new EdumiaLeavesBlock(), false);
    public static final Block HOLLY_LEAVES = ModNatureBlocks.registerPlantBlock("holly_leaves",
            new EdumiaLeavesBlock(), false);
    public static final Block MAPLE_LEAVES = ModNatureBlocks.registerPlantBlock("maple_leaves",
            new EdumiaLeavesBlock(), false);

    public static final Block APPLE_LEAVES_RED = ModNatureBlocks.registerPlantBlock("apple_leaves_red",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sounds(BlockSoundGroup.GRASS)), false);
    public static final Block APPLE_LEAVES_GREEN = ModNatureBlocks.registerPlantBlock("apple_leaves_green",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sounds(BlockSoundGroup.GRASS)), false);
    public static final Block PEAR_LEAVES_FRUIT = ModNatureBlocks.registerPlantBlock("pear_leaves_fruit",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sounds(BlockSoundGroup.GRASS)), false);
    public static final Block CHERRY_LEAVES_FRUIT = ModNatureBlocks.registerPlantBlock("cherry_leaves_fruit",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sounds(BlockSoundGroup.GRASS)), false);


    public static Block registerPlantBlock(String name, Block block, boolean absent) {
        if(!absent) registerPlantBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, name), block);
    }

    static Item registerPlantBlockItem(String name, Block block) {
        var item =  Registry.register(Registries.ITEM, new Identifier(Edumia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

        Item.BLOCK_ITEMS.put(block, item);
        CreativeTabLoader.PLANT_CONTENTS.add(item.getDefaultStack());
        return item;
    }

    public static void registerModBlocks() {
        Edumia.LOGGER.debug("Registering ModBlocks for " + Edumia.MOD_ID);
    }
}
