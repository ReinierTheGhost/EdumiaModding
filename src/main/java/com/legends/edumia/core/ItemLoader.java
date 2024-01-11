package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.item.EdumiaFoodComponent;
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


    /**
     * food Items
     */

    public static final Item TEA_SAKURA_PETALS = registerItem("tea_sakura_petals",
            new Item(new FabricItemSettings()));
    public static final Item TEA_MINT_LEAVES = registerItem("tea_mint_leaves",
            new Item(new FabricItemSettings()));
    public static final Item TEA_LEAF = registerItem("tea_leaf",
            new Item(new FabricItemSettings()));
    public static final Item TEA_LILY_PETALS = registerItem("tea_lily_petals",
            new Item(new FabricItemSettings()));
    public static final Item TEA_WHITE_JADE_PETALS = registerItem("tea_white_jade_petals",
            new Item(new FabricItemSettings()));
    public static final Item TEA_HIBISCUS_PETALS = registerItem("tea_hibiscus_petals",
            new Item(new FabricItemSettings()));
    public static final Item TEA_JASMINE_PETALS = registerItem("tea_jasmine_petals",
            new Item(new FabricItemSettings()));
    public static final Item TEA_CINNAMON_STICK = registerItem("tea_cinnamon_stick",
            new Item(new FabricItemSettings()));
    public static final Item TEA_WHITE_DRAGON_PETALS = registerItem("tea_white_dragon_petals",
            new Item(new FabricItemSettings()));
    public static final Item BROCCOLI = registerItem("broccoli",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.BROCCOLI)));
    public static final Item PAPRIKA_GREEN = registerItem("paprika_green",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.PAPRIKA)));
    public static final Item RAMEN = registerItem("ramen",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.RAMEN)));
    public static final Item RAMEN_BEEF = registerItem("ramen_beef",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.RAMEN_BEEF)));
    public static final Item RAMEN_PORK = registerItem("ramen_pork",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.RAMEN_PORK)));
    public static final Item RAMEN_SHRIMPS = registerItem("ramen_shrimps",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.RAMEN_SHRIMPS)));
    public static final Item RAMEN_VEGI = registerItem("ramen_vegi",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.RAMEN_VEGI)));
    public static final Item RED_GRAPES = registerItem("red_grapes",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.RED_GRAPES)));
    public static final Item RICE = registerItem("rice",
            new Item(new FabricItemSettings()));
    public static final Item RICE_BALL = registerItem("rice_ball",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.RICE_BALL)));
    public static final Item SPINACH = registerItem("spinach",
            new Item(new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.TOMATO)));
    public static final Item CHEESE = registerItem("cheese",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.CHEESE)));
    public static final Item LETTUCE = registerItem("lettuce",
            new Item(new FabricItemSettings().food(EdumiaFoodComponent.LETTUCE)));




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
