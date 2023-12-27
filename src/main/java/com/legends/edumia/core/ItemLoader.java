package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.item.EdumiaMapItem;
import com.legends.edumia.item.WorldTeleporterItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemLoader {

    public static final Item LEGENDS_COIN = registerItem("legends_coin",
            new WorldTeleporterItem(new FabricItemSettings().maxCount(1)));

    public static final Item ATLAS = registerItem("atlas", new EdumiaMapItem(new FabricItemSettings().maxCount(1)));
    //gems
    public static final Item GEM_FINE_AMBER = registerItem("gem_fine_amber",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWED_AMBER = registerItem("gem_flawed_amber",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWLESS_AMBER = registerItem("gem_flawless_amber",
             new Item(new FabricItemSettings()));
    public static final Item GEM_PERFECT_AMBER = registerItem("gem_perfect_amber",
             new Item(new FabricItemSettings()));
    public static final Item GEM_ROUGH_AMBER = registerItem("gem_rough_amber",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FINE_AMETHYST = registerItem("gem_fine_amethyst",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWED_AMETHYST = registerItem("gem_flawed_amethyst",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWLESS_AMETHYST = registerItem("gem_flawless_amethyst",
             new Item(new FabricItemSettings()));
    public static final Item GEM_PERFECT_AMETHYST = registerItem("gem_perfect_amethyst",
             new Item(new FabricItemSettings()));
    public static final Item GEM_ROUGH_AMETHYST = registerItem("gem_rough_amethyst",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FINE_JADE = registerItem("gem_fine_jade",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWED_JADE = registerItem("gem_flawed_jade",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWLESS_JADE = registerItem("gem_flawless_jade",
             new Item(new FabricItemSettings()));
    public static final Item GEM_PERFECT_JADE = registerItem("gem_perfect_jade",
             new Item(new FabricItemSettings()));
    public static final Item GEM_ROUGH_JADE = registerItem("gem_rough_jade",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FINE_JASPER = registerItem("gem_fine_jasper",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWED_JASPER = registerItem("gem_flawed_jasper",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWLESS_JASPER = registerItem("gem_flawless_jasper",
             new Item(new FabricItemSettings()));
    public static final Item GEM_PERFECT_JASPER = registerItem("gem_perfect_jasper",
             new Item(new FabricItemSettings()));
    public static final Item GEM_ROUGH_JASPER = registerItem("gem_rough_jasper",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FINE_RUBY = registerItem("gem_fine_ruby",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWED_RUBY = registerItem("gem_flawed_ruby",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWLESS_RUBY = registerItem("gem_flawless_ruby",
             new Item(new FabricItemSettings()));
    public static final Item GEM_PERFECT_RUBY = registerItem("gem_perfect_ruby",
             new Item(new FabricItemSettings()));
    public static final Item GEM_ROUGH_RUBY = registerItem("gem_rough_ruby",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FINE_SAPPHIRE = registerItem("gem_fine_sapphire",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWED_SAPPHIRE = registerItem("gem_flawed_sapphire",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWLESS_SAPPHIRE = registerItem("gem_flawless_sapphire",
             new Item(new FabricItemSettings()));
    public static final Item GEM_PERFECT_SAPPHIRE = registerItem("gem_perfect_sapphire",
             new Item(new FabricItemSettings()));
    public static final Item GEM_ROUGH_SAPPHIRE = registerItem("gem_rough_sapphire",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FINE_TOPAZ = registerItem("gem_fine_topaz",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWED_TOPAZ = registerItem("gem_flawed_topaz",
             new Item(new FabricItemSettings()));
    public static final Item GEM_FLAWLESS_TOPAZ = registerItem("gem_flawless_topaz",
             new Item(new FabricItemSettings()));
    public static final Item GEM_PERFECT_TOPAZ = registerItem("gem_perfect_topaz",
             new Item(new FabricItemSettings()));
    public static final Item GEM_ROUGH_TOPAZ = registerItem("gem_rough_topaz",
             new Item(new FabricItemSettings()));

//    public static final Item REEDS = registerItem("reeds",
//            new AliasedBlockItem(BlockLoader.REEDS, new FabricItemSettings()));
//    public static final Item PAPYRUS = registerItem("papyrus",
//            new AliasedBlockItem(BlockLoader.PAPYRUS, new FabricItemSettings()));
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(LEGENDS_COIN);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Edumia.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Edumia.LOGGER.info("Registering Mod Items for " + Edumia.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ItemLoader::addItemsToIngredientItemGroup);
    }
}
