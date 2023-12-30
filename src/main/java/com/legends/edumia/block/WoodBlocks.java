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

public class WoodBlocks {

    public static Block registerWoodBlock(String name, Block block) {
        registerWoodBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, name), block);
    }
    static Item registerWoodBlockItem(String name, Block block) {
        var item =  Registry.register(Registries.ITEM, new Identifier(Edumia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        Item.BLOCK_ITEMS.put(block, item);
        CreativeTabLoader.WOOD_BLOCKS_CONTENTS.add(item.getDefaultStack());
        return item;
    }

    public static void registerModBlocks() {
        Edumia.LOGGER.debug("Registering ModBlocks for " + Edumia.MOD_ID);
    }
}
