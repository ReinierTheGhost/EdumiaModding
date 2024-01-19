package com.legends.edumia.block;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.CreativeTabLoader;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockRegisters {

    public static Block registerbuildingBlock(String name, Block block) {
        registerBuildingBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, name), block);
    }

    static Item registerBuildingBlockItem(String name, Block block) {
        var item =  Registry.register(Registries.ITEM, new Identifier(Edumia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

        Item.BLOCK_ITEMS.put(block, item);
        CreativeTabLoader.BUILDING_CONTENTS.add(item.getDefaultStack());
        return item;
    }

    public static Block registerStoneBlock(String name, Block block) {
        registerStoneBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, name), block);
    }

    static Item registerStoneBlockItem(String name, Block block) {
        var item =  Registry.register(Registries.ITEM, new Identifier(Edumia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

        Item.BLOCK_ITEMS.put(block, item);
        CreativeTabLoader.NATURAL_STONE_BLOCKS_CONTENTS.add(item.getDefaultStack());
        return item;
    }

    public static Block registerDoorBlock(String name, Block block) {
        registerDoorBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Edumia.MOD_ID, name), block);
    }

    static Item registerDoorBlockItem(String name, Block block) {
        var item =  Registry.register(Registries.ITEM, new Identifier(Edumia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

        Item.BLOCK_ITEMS.put(block, item);
        CreativeTabLoader.UTILITY_CONTENTS.add(item.getDefaultStack());
        return item;
    }

    public static void registerModBlocks() {
        Edumia.LOGGER.debug("Registering ModBlocks for " + Edumia.MOD_ID);
    }
}
