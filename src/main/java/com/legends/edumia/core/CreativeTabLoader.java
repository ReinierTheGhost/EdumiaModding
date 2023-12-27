package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.blocksets.WoodBlockSets;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class CreativeTabLoader {

    public static final ItemGroup LEGENDS_GROUP = FabricItemGroup.builder()
            .displayName(Text.literal("Rewards"))
                    .icon(() -> new ItemStack(ItemLoader.LEGENDS_COIN)).entries((displayContext, entries) -> {
                        entries.add(ItemLoader.LEGENDS_COIN);
                        entries.add(ItemLoader.ATLAS);
                    }).build();


    public static final List<ItemStack> PLANT_CONTENTS = new LinkedList<>();

    public static final ItemGroup EDUMIA_PLANTS = FabricItemGroup.builder()
            .displayName(Text.literal("Edumia Plants"))
                    .icon(() -> new ItemStack(BlockLoader.PAPYRUS)).entries((displayContext, entries) -> {
                        for (ItemStack item : PLANT_CONTENTS) {
                            entries.add(item);
                        }
                        entries.add(BlockLoader.PAPYRUS);
                        entries.add(BlockLoader.REEDS);
                        entries.add(BlockLoader.DRIED_REEDS);
//
//                        entries.add(BlockLoader.ARID_GRASS);
//                        entries.add(BlockLoader.BLACK_GRASS);
//                        entries.add(BlockLoader.FLAX_GRASS);
//                        flowers
                        entries.add(BlockLoader.ASPHODEL);
                        entries.add(BlockLoader.BLUE_DELPHINIUM);
                        entries.add(BlockLoader.BLUEBELL);
                        entries.add(BlockLoader.CALLA_LILY);
                        entries.add(BlockLoader.CELSEMIUM);
                        entries.add(BlockLoader.CHRYS_BLUE);
                        entries.add(BlockLoader.CHRYS_ORANGE);
                        entries.add(BlockLoader.CHRYS_PINK);
                        entries.add(BlockLoader.CHRYS_WHITE);
                        entries.add(BlockLoader.CHRYS_YELLOW);
                        entries.add(BlockLoader.CROCUS);
                        entries.add(BlockLoader.DAISY);
                        entries.add(BlockLoader.DELPHINIUM);
                        entries.add(BlockLoader.FLAX_FLOWERS);
                        entries.add(BlockLoader.FOXGLOVE_ORANGE);
                        entries.add(BlockLoader.FOXGLOVE_PINK);
                        entries.add(BlockLoader.FOXGLOVE_RED);
                        entries.add(BlockLoader.FOXGLOVE_WHITE);
                        entries.add(BlockLoader.GERBERA_RED);
                        entries.add(BlockLoader.GERBERA_YELLOW);
                        entries.add(BlockLoader.HEATHER_BUSH);
                        entries.add(BlockLoader.LAVENDER);
                        entries.add(BlockLoader.MARIGOLD);
                        entries.add(BlockLoader.PINK_ANEMONE);
                        entries.add(BlockLoader.SIMBLELMYNE);
                        entries.add(BlockLoader.TUBEROSE);
                        entries.add(BlockLoader.YELLOW_IRIS);
                        entries.add(BlockLoader.FLAME_OF_THE_SOUTH);
                        entries.add(BlockLoader.HIBISCUS);
//
                        entries.add(BlockLoader.APPLE_SAPLING);
//                        entries.add(BlockLoader.APPLE_LEAVES);
//                        entries.add(BlockLoader.ASPEN_SAPLING);
//                        entries.add(BlockLoader.ASPEN_LEAVES);
//                        entries.add(BlockLoader.BEECH_SAPLING);
//                        entries.add(BlockLoader.BEECH_LEAVES);
//                        entries.add(BlockLoader.BLACKTHORN_SAPLING);
//                        entries.add(BlockLoader.BLACKTHORN_LEAVES);
//                        entries.add(BlockLoader.CEDAR_SAPLING);
//                        entries.add(BlockLoader.CEDAR_LEAVES);
//                        entries.add(BlockLoader.CHERRY_SAPLING);
//                        entries.add(BlockLoader.CHERRY_LEAVES);
//                        entries.add(BlockLoader.CYPRESS_SAPLING);
//                        entries.add(BlockLoader.CYPRESS_LEAVES);
//                        entries.add(BlockLoader.FIR_SAPLING);
//                        entries.add(BlockLoader.FIR_LEAVES);
//                        entries.add(BlockLoader.GHOST_GUM_SAPLING);
//                        entries.add(BlockLoader.GHOST_GUM_LEAVES);
//                        entries.add(BlockLoader.GREEN_OAK_SAPLING);
//                        entries.add(BlockLoader.GREEN_OAK_LEAVES);
//                        entries.add(BlockLoader.HOLLY_SAPLING);
//                        entries.add(BlockLoader.HOLLY_LEAVES);
//                        entries.add(BlockLoader.LARCH_SAPLING);
//                        entries.add(BlockLoader.LARCH_LEAVES);
//                        entries.add(BlockLoader.MAPLE_SAPLING);
//                        entries.add(BlockLoader.MAPLE_LEAVES);
//                        entries.add(BlockLoader.PEAR_SAPLING);
//                        entries.add(BlockLoader.PEAR_LEAVES);
//                        entries.add(BlockLoader.PINE_SAPLING);
//                        entries.add(BlockLoader.PINE_LEAVES);
//                        entries.add(BlockLoader.RED_OAK_SAPLING);
//                        entries.add(BlockLoader.RED_OAK_LEAVES);
//                        entries.add(BlockLoader.REDWOOD_SAPLING);
//                        entries.add(BlockLoader.SILVER_SPRUCE_SAPLING);
//                        entries.add(BlockLoader.SILVER_SPRUCE_LEAVES);
//                        entries.add(BlockLoader.WHITE_ASH_SAPLING);
//                        entries.add(BlockLoader.WHITE_ASH_LEAVES);
                    })
                    .build();

    public static final ItemGroup EDUMIA_GEMS = FabricItemGroup.builder()
            .displayName(Text.literal("Edumia Gems"))
                    .icon(() -> new ItemStack(ItemLoader.GEM_PERFECT_AMBER)).entries((displayContext, entries) -> {
                        entries.add(ItemLoader.GEM_FINE_AMBER);
                        entries.add(ItemLoader.GEM_FLAWED_AMBER);
                        entries.add(ItemLoader.GEM_FLAWLESS_AMBER);
                        entries.add(ItemLoader.GEM_PERFECT_AMBER);
                        entries.add(ItemLoader.GEM_ROUGH_AMBER);
                        entries.add(ItemLoader.GEM_FINE_AMETHYST);
                        entries.add(ItemLoader.GEM_FLAWED_AMETHYST);
                        entries.add(ItemLoader.GEM_FLAWLESS_AMETHYST);
                        entries.add(ItemLoader.GEM_PERFECT_AMETHYST);
                        entries.add(ItemLoader.GEM_ROUGH_AMETHYST);
                        entries.add(ItemLoader.GEM_FINE_JADE);
                        entries.add(ItemLoader.GEM_FLAWED_JADE);
                        entries.add(ItemLoader.GEM_FLAWLESS_JADE);
                        entries.add(ItemLoader.GEM_PERFECT_JADE);
                        entries.add(ItemLoader.GEM_ROUGH_JADE);
                        entries.add(ItemLoader.GEM_FINE_JASPER);
                        entries.add(ItemLoader.GEM_FLAWED_JASPER);
                        entries.add(ItemLoader.GEM_FLAWLESS_JASPER);
                        entries.add(ItemLoader.GEM_PERFECT_JASPER);
                        entries.add(ItemLoader.GEM_ROUGH_JASPER);
                        entries.add(ItemLoader.GEM_FINE_RUBY);
                        entries.add(ItemLoader.GEM_FLAWED_RUBY);
                        entries.add(ItemLoader.GEM_FLAWLESS_RUBY);
                        entries.add(ItemLoader.GEM_PERFECT_RUBY);
                        entries.add(ItemLoader.GEM_ROUGH_RUBY);
                        entries.add(ItemLoader.GEM_FINE_SAPPHIRE);
                        entries.add(ItemLoader.GEM_FLAWED_SAPPHIRE);
                        entries.add(ItemLoader.GEM_FLAWLESS_SAPPHIRE);
                        entries.add(ItemLoader.GEM_PERFECT_SAPPHIRE);
                        entries.add(ItemLoader.GEM_ROUGH_SAPPHIRE);
                        entries.add(ItemLoader.GEM_FINE_TOPAZ);
                        entries.add(ItemLoader.GEM_FLAWED_TOPAZ);
                        entries.add(ItemLoader.GEM_FLAWLESS_TOPAZ);
                        entries.add(ItemLoader.GEM_PERFECT_TOPAZ);
                        entries.add(ItemLoader.GEM_ROUGH_TOPAZ);
                    })
                    .build();


//
//    public static final ItemGroup EDUMIA_ITEMS = Registry.register(Registries.ITEM_GROUP,
//            new Identifier(Edumia.MOD_ID,"edumia_items"),
//            FabricItemGroup.builder().displayName(Text.translatable("creativetab.edumia_items"))
//                    .icon(() -> new ItemStack(ItemLoader.TEA_SAKURA_PETALS)).entries((displayContext, entries) -> {
//                        entries.add(ItemLoader.TEA_SAKURA_PETALS);
//                        entries.add(ItemLoader.TEA_MINT_LEAVES);
//                        entries.add(ItemLoader.TEA_LEAF);
//                        entries.add(ItemLoader.TEA_LILY_PETALS);
//                        entries.add(ItemLoader.TEA_WHITE_JADE_PETALS);
//                        entries.add(ItemLoader.TEA_HIBISCUS_PETALS);
//                        entries.add(ItemLoader.TEA_JASMINE_PETALS);
//                        entries.add(ItemLoader.TEA_CINNAMON_STICK);
//                        entries.add(ItemLoader.TEA_WHITE_DRAGON_PETALS);
//
//                        entries.add(ItemLoader.BROCCOLI);
//                        entries.add(ItemLoader.PAPRIKA_GREEN);
//                        entries.add(ItemLoader.RAMEN);
//                        entries.add(ItemLoader.RAMEN_BEEF);
//                        entries.add(ItemLoader.RAMEN_PORK);
//                        entries.add(ItemLoader.RAMEN_SHRIMPS);
//                        entries.add(ItemLoader.RAMEN_VEGI);
//                        entries.add(ItemLoader.RED_GRAPES);
//                        entries.add(ItemLoader.RICE);
//                        entries.add(ItemLoader.RICE_BALL);
//                        entries.add(ItemLoader.SPINACH);
//                        entries.add(ItemLoader.TOMATO);
//                        entries.add(ItemLoader.WINE_BOTTLE);
//
//                        entries.add(ItemLoader.POLISHED_JADE);
//                        entries.add(ItemLoader.TOPAZ_SHARD);
//
//                        entries.add(ItemLoader.INGOT_OCkER);
//                        entries.add(ItemLoader.INGOT_BLACK);
//                        entries.add(ItemLoader.INGOT_ICE);
//                        entries.add(ItemLoader.INGOT_PINK);
//                        entries.add(ItemLoader.INGOT_VEIL);
//                        entries.add(ItemLoader.INGOT_AQUATIA);
//                        entries.add(ItemLoader.INGOT_CRIMSUN);
//                        entries.add(ItemLoader.INGOT_DEMONIUM);
//                        entries.add(ItemLoader.INGOT_DRACONIAN);
//                        entries.add(ItemLoader.INGOT_HELLIAN);
//                        entries.add(ItemLoader.INGOT_GLIMMERING);
//                        entries.add(ItemLoader.INGOT_NEPTUNIUM);
//                        entries.add(ItemLoader.INGOT_SOLARITE);
//
//                        entries.add(ItemLoader.BAMBOO_STAFF);
//                        entries.add(ItemLoader.WAND_AIRSCEPTRE);
//                        entries.add(ItemLoader.GENSAI_NECKLESS);
//
//                        entries.add(ItemLoader.MAN_HOE);
//                        entries.add(ItemLoader.MAN_AXE);
//                        entries.add(ItemLoader.MAN_SHOVEL);
//                        entries.add(ItemLoader.MAN_PICKAXE);
//                        entries.add(ItemLoader.MAN_SWORD);
//
//                        entries.add(ItemLoader.ORC_HOE);
//                        entries.add(ItemLoader.ORC_AXE);
//                        entries.add(ItemLoader.ORC_SHOVEL);
//                        entries.add(ItemLoader.ORC_PICKAXE);
//                        entries.add(ItemLoader.ORC_SWORD);
//
//                        entries.add(ItemLoader.BATTLE_AXE);
//
//                        entries.add(ItemLoader.ATLAS);
//                        entries.add(ItemLoader.BIGBOOK);
//                        entries.add(ItemLoader.CHASE);
//                        entries.add(ItemLoader.CLIPBOARDSIMPLE);
//                        entries.add(ItemLoader.FRAMINGBOARD);
//                        entries.add(ItemLoader.FRAMINGAHEET);
//                        entries.add(ItemLoader.HANDDRILL);
//                        entries.add(ItemLoader.LOCK);
//                        entries.add(ItemLoader.MAPTOOL);
//                        entries.add(ItemLoader.MONOCLE);
//                        entries.add(ItemLoader.PLATE);
//                        entries.add(ItemLoader.PLUMBLINE);
//                        entries.add(ItemLoader.RECIPEBOOK);
//                        entries.add(ItemLoader.SAW);
//                        entries.add(ItemLoader.STOCKCATALOG);
//                        entries.add(ItemLoader.TAPE);
//
//                        entries.add(ItemLoader.ALEXANDRITE);
//                        entries.add(ItemLoader.RAW_ALEXANDRITE);
//                    })
//                    .build());
//
//    public static final ItemGroup EDUMIA_SPAWNS = Registry.register(Registries.ITEM_GROUP,
//            new Identifier(Edumia.MOD_ID,"edumia_spawns"),
//            FabricItemGroup.builder().displayName(Text.translatable("creativetab.edumia_spawns"))
//                    .icon(() -> new ItemStack(ItemLoader.RHINO_SPAWN_EGG)).entries((displayContext, entries) -> {
//                        entries.add(ItemLoader.RHINO_SPAWN_EGG);
//                        entries.add((ItemLoader.BOAR_SPAWN_EGG));
//                        entries.add(ItemLoader.ALLIGATOR_SPAWN_EGG);
//                        entries.add(ItemLoader.BADGER_SPAWN_EGG);
//                    })
//                    .build());
    public static final List<ItemStack> BUILDING_CONTENTS = new LinkedList<>();
    public static final ItemGroup EDUMIA_BUILDING_BLOCKS = FabricItemGroup.builder()
                    .displayName(Text.literal("Edumia Building Blocks"))
                    .icon(() -> new ItemStack(BlockLoader.GREEN_BASALT_BRICKS)).entries((displayContext, entries) -> {
                        for (ItemStack item : BUILDING_CONTENTS) {
                            entries.add(item);
                        }
                        entries.add(BlockLoader.BRICK_PILLAR);
                        entries.add(BlockLoader.STONE_PILLAR);

                        entries.add(BlockLoader.BASALT_BRICKS);
                        entries.add(BlockLoader.BASALT_BRICKS_SLAB);
                        entries.add(BlockLoader.BASALT_BRICKS_STAIRS);
                        entries.add(BlockLoader.BASALT_BRICKS_WALL);

                        entries.add(BlockLoader.GREEN_BASALT_BRICKS);
                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_WALL);
                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_SLAB);
                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_STAIRS);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_GOTHIC_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_SEGMENTAL_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_ROUND_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_SMALL_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_TWO_METER_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_ARROWSLIT);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_BALUSTRADE);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_PILLAR);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_WALL);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_LARGE_PILLAR);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_PILAR);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_SMALL_PILLAR);
//                        entries.add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_WALL);

                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE);
                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL);
                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB);
                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS);

                        entries.add(BlockLoader.LIGHT_GRAY_STONE_BRICKS);
                        entries.add(BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB);
                        entries.add(BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS);
                        entries.add(BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL);

                        entries.add(BlockLoader.BLUE_BRICK);
                        entries.add(BlockLoader.BLUE_BRICK_SLAB);
                        entries.add(BlockLoader.BLUE_BRICK_STAIRS);
                        entries.add(BlockLoader.BLUE_BRICK_WALL);

                        entries.add(BlockLoader.BROWN_STONE);
                        entries.add(BlockLoader.BROWN_STONE_SLAB);
                        entries.add(BlockLoader.BROWN_STONE_STAIRS);
                        entries.add(BlockLoader.BROWN_STONE_WALL);

                        entries.add(BlockLoader.YELLOW_STONE_BRICKS_2);
                        entries.add(BlockLoader.YELLOW_STONE_BRICKS_2_SLAB);
                        entries.add(BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS);
                        entries.add(BlockLoader.YELLOW_STONE_BRICKS_2_WALL);

                        entries.add(BlockLoader.YELLOW_STONE_BRICKS);
                        entries.add(BlockLoader.YELLOW_STONE_BRICKS_SLAB);
                        entries.add(BlockLoader.YELLOW_STONE_BRICKS_STAIRS);
                        entries.add(BlockLoader.YELLOW_STONE_BRICKS_WALL);

                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_SLAB);
//
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_ROUND_ARCH);
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH);
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_GOTHIC_ARCH);
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_SMALL_ARCH);
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICKS_TWO_METER_ARCH);
//
                        entries.add(BlockLoader.HIGH_ELVEN_PILLAR);
//                        entries.add(BlockLoader.HIGH_ELVEN_BALUSTRADE);
//                        entries.add(BlockLoader.HIGH_ELVEN_BRICK_ARROWSLIT);

                        entries.add(BlockLoader.SMALL_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS);

                        entries.add(BlockLoader.HIGH_ELVEN_BRICK_TILING);
                        entries.add(BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS);
                        entries.add(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB);

                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_PILLAR);
//                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BALUSTRADE);

                        entries.add(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS);

                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS);

                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.DARK_HIGH_ELVEN_PILLAR);
//                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BALUSTRADE);

                        entries.add(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS);
                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB);

                        entries.add(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS);

                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB);

                        entries.add(BlockLoader.CRACKED_GREEN_BASALT);
                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_SLAB);
                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_WALL);

                        entries.add(BlockLoader.CHISELED_BASALT);

                        entries.add(BlockLoader.MOSSY_BASALT_BRICKS);
                        entries.add(BlockLoader.MOSSY_BASALT_BRICKS_SLAB);
                        entries.add(BlockLoader.MOSSY_BASALT_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_BASALT_BRICKS_WALL);

                        entries.add(BlockLoader.CHALK_BRICKS);
                        entries.add(BlockLoader.CHALK_BRICKS_STAIRS);
                        entries.add(BlockLoader.CHALK_BRICKS_WALL);
                        entries.add(BlockLoader.CHALK_BRICKS_SLAB);
                        entries.add(BlockLoader.CHALK_PILLAR);

                        entries.add(BlockLoader.BROWN_SANDSTONE_BRICKS);
                        entries.add(BlockLoader.BROWN_SANDSTONE_BRICKS_STAIRS);
                        entries.add(BlockLoader.BROWN_SANDSTONE_BRICKS_WALL);
                        entries.add(BlockLoader.BROWN_SANDSTONE_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS);
                        entries.add(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS);
                        entries.add(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_SLAB);

                        entries.add(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS);

                        entries.add(BlockLoader.CACHOLONG_BRICKS);
                        entries.add(BlockLoader.CACHOLONG_BRICKS_STAIRS);
                        entries.add(BlockLoader.CACHOLONG_BRICKS_WALL);
                        entries.add(BlockLoader.CACHOLONG_BRICKS_SLAB);
                        entries.add(BlockLoader.CACHOLONG_PILLAR);

                        entries.add(BlockLoader.CRACKED_CACHOLONG_BRICKS);
                        entries.add(BlockLoader.CRACKED_CACHOLONG_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_CACHOLONG_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_CACHOLONG_BRICKS);
                        entries.add(BlockLoader.MOSSY_CACHOLONG_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_CACHOLONG_BRICKS_SLAB);

                        entries.add(BlockLoader.CARVED_CACHOLONG_BRICKS);

                        entries.add(BlockLoader.BLACK_DEMON_BRICKS);
                        entries.add(BlockLoader.BLACK_DEMON_BRICKS_STAIRS);
                        entries.add(BlockLoader.BLACK_DEMON_BRICKS_WALL);
                        entries.add(BlockLoader.BLACK_DEMON_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_BLACK_DEMON_BRICKS);
                        entries.add(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_BLACK_DEMON_BRICKS);
                        entries.add(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_SLAB);

                        entries.add(BlockLoader.CARVED_BLACK_DEMON_BRICKS);

                        entries.add(BlockLoader.BLUE_BRICKS);
                        entries.add(BlockLoader.BLUE_BRICKS_STAIRS);
                        entries.add(BlockLoader.BLUE_BRICKS_WALL);
                        entries.add(BlockLoader.BLUE_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_BLUE_BRICKS);
                        entries.add(BlockLoader.CRACKED_BLUE_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_BLUE_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_BLUE_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_BLUE_BRICKS);
                        entries.add(BlockLoader.MOSSY_BLUE_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_BLUE_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_BLUE_BRICKS_SLAB);

                        entries.add(BlockLoader.CARVED_BLUE_BRICKS);

                        entries.add(BlockLoader.DEMON_BASALT_BRICKS);
                        entries.add(BlockLoader.DEMON_BASALT_BRICKS_STAIRS);
                        entries.add(BlockLoader.DEMON_BASALT_BRICKS_WALL);
                        entries.add(BlockLoader.DEMON_BASALT_BRICKS_SLAB);

                        entries.add(BlockLoader.CARVED_DEMON_BASALT_BRICKS);

                        entries.add(BlockLoader.VULCANIC_DEMON_BRICKS);
                        entries.add(BlockLoader.VULCANIC_DEMON_BRICKS_STAIRS);
                        entries.add(BlockLoader.VULCANIC_DEMON_BRICKS_WALL);
                        entries.add(BlockLoader.VULCANIC_DEMON_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS);
                        entries.add(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS);
                        entries.add(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_SLAB);

                        entries.add(BlockLoader.CARVED_VULCANIC_DEMON_BRICKS);

                        entries.add(BlockLoader.RED_BRICKS);
                        entries.add(BlockLoader.RED_BRICKS_STAIRS);
                        entries.add(BlockLoader.RED_BRICKS_WALL);
                        entries.add(BlockLoader.RED_BRICKS_SLAB);
                        entries.add(BlockLoader.RED_PILLAR);

                        entries.add(BlockLoader.CRACKED_RED_BRICKS);
                        entries.add(BlockLoader.CRACKED_RED_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_RED_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_RED_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_RED_BRICKS);
                        entries.add(BlockLoader.MOSSY_RED_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_RED_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_RED_BRICKS_SLAB);

                        entries.add(BlockLoader.CARVED_RED_BRICKS);

                        entries.add(BlockLoader.DESERT_MUD_BRICKS);
                        entries.add(BlockLoader.DESERT_MUD_BRICKS_STAIRS);
                        entries.add(BlockLoader.DESERT_MUD_BRICKS_WALL);
                        entries.add(BlockLoader.DESERT_MUD_BRICKS_SLAB);

                        entries.add(BlockLoader.CRACKED_DESERT_MUD_BRICKS);
                        entries.add(BlockLoader.CRACKED_DESERT_MUD_BRICKS_STAIRS);
                        entries.add(BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL);
                        entries.add(BlockLoader.CRACKED_DESERT_MUD_BRICKS_SLAB);

                        entries.add(BlockLoader.MOSSY_DESERT_MUD_BRICKS);
                        entries.add(BlockLoader.MOSSY_DESERT_MUD_BRICKS_STAIRS);
                        entries.add(BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL);
                        entries.add(BlockLoader.MOSSY_DESERT_MUD_BRICKS_SLAB);

                        entries.add(BlockLoader.CLAY_TILING);
                        entries.add(BlockLoader.CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.CLAY_TILING_SLAB);
                        entries.add(BlockLoader.CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.BLACK_CLAY_TILING);
                        entries.add(BlockLoader.BLACK_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.BLACK_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.BLACK_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.BLUE_CLAY_TILING);
                        entries.add(BlockLoader.BLUE_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.BLUE_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.BLUE_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.BROWN_CLAY_TILING);
                        entries.add(BlockLoader.BROWN_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.BROWN_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.BROWN_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.CYAN_CLAY_TILING);
                        entries.add(BlockLoader.CYAN_CLAY_TILING_STAIRS );
                        entries.add(BlockLoader.CYAN_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.CYAN_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.GRAY_CLAY_TILING);
                        entries.add(BlockLoader.GRAY_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.GRAY_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.GRAY_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.GREEN_CLAY_TILING);
                        entries.add(BlockLoader.GREEN_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.GREEN_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.GREEN_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.LIGHT_BLUE_CLAY_TILING);
                        entries.add(BlockLoader.LIGHT_BLUE_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.LIGHT_BLUE_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER);


                        entries.add(BlockLoader.LIGHT_GRAY_CLAY_TILING);
                        entries.add(BlockLoader.LIGHT_GRAY_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.LIGHT_GRAY_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.LIME_CLAY_TILING);
                        entries.add(BlockLoader.LIME_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.LIME_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.LIME_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.MAGENTA_CLAY_TILING);
                        entries.add(BlockLoader.MAGENTA_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.MAGENTA_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.MAGENTA_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.ORANGE_CLAY_TILING);
                        entries.add(BlockLoader.ORANGE_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.ORANGE_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.ORANGE_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.PINK_CLAY_TILING);
                        entries.add(BlockLoader.PINK_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.PINK_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.PINK_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.PURPLE_CLAY_TILING);
                        entries.add(BlockLoader.PURPLE_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.PURPLE_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.PURPLE_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.RED_CLAY_TILING);
                        entries.add(BlockLoader.RED_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.RED_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.RED_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.WHITE_CLAY_TILING);
                        entries.add(BlockLoader.WHITE_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.WHITE_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.WHITE_CLAY_TILING_VERTICAL_CORNER);

                        entries.add(BlockLoader.YELLOW_CLAY_TILING);
                        entries.add(BlockLoader.YELLOW_CLAY_TILING_STAIRS);
                        entries.add(BlockLoader.YELLOW_CLAY_TILING_SLAB);
                        entries.add(BlockLoader.YELLOW_CLAY_TILING_VERTICAL_CORNER);






                    }).build();

    public static final List<ItemStack> WOOD_BLOCKS_CONTENTS = new LinkedList<>();
    public static final ItemGroup EDUMIA_WOOD_BLOCKS = FabricItemGroup.builder()
            .displayName(Text.literal("Edumia Wood Blocks"))
                    .icon(() -> new ItemStack(WoodBlockSets.APPLE.planks().asItem()))
                    .entries((displayContext, entries) ->  {
                        for (ItemStack item: WOOD_BLOCKS_CONTENTS){
                            entries.add(item);
                        }
                    }).build();

    public static final List<ItemStack> NATURAL_STONE_BLOCKS_CONTENTS = new LinkedList<>();
    public static final ItemGroup EDUMIA_NATURAL_STONE_BLOCKS = FabricItemGroup.builder()
            .displayName(Text.literal("Edumia Natural stone blocks"))
                    .icon(() -> new ItemStack(BlockLoader.WHITE_SAND)).entries((displayContext, entries) -> {
                        for (ItemStack item : NATURAL_STONE_BLOCKS_CONTENTS){
                            entries.add(item);
                        }

//                        entries.add(BlockLoader.TOPAZ_ORE);
//                        entries.add(BlockLoader.ORE_VEIL);
//
//                        entries.add(BlockLoader.ALEXANDRITE_BLOCK);
//                        entries.add(BlockLoader.ALEXANDRITE_ORE);
//                        entries.add(BlockLoader.RAW_ALEXANDRITE_BLOCK);
//
                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE);
                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL);
                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB);
                        entries.add(BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS);

                        entries.add(BlockLoader.GREEN_BASALT);
                        entries.add(BlockLoader.GREEN_BASALT_STAIRS);
                        entries.add(BlockLoader.GREEN_BASALT_WALL);
                        entries.add(BlockLoader.GREEN_BASALT_SLAB);
                        entries.add(BlockLoader.GREEN_BASALT_BALUSTRADE);
                        entries.add(BlockLoader.GREEN_BASALT_ARROWSLIT);
                        entries.add(BlockLoader.GREEN_BASALT_SMALL_ARCH);
                        entries.add(BlockLoader.GREEN_BASALT_TWO_METER_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_ROUND_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_GOTHIC_ARCH);
//                        entries.add(BlockLoader.GREEN_BASALT_SEGMENTAL_ARCH);

                        entries.add(BlockLoader.LIGHT_GRAY_STONE);
                        entries.add(BlockLoader.LIGHT_GRAY_STONE_SLAB);
                        entries.add(BlockLoader.LIGHT_GRAY_STONE_STAIRS);
                        entries.add(BlockLoader.LIGHT_GRAY_STONE_WALL);

                        entries.add(BlockLoader.BLUE_STONE);
                        entries.add(BlockLoader.BLUE_STONE_SLAB);
                        entries.add(BlockLoader.BLUE_STONE_STAIRS);
                        entries.add(BlockLoader.BLUE_STONE_WALL);

                        entries.add(BlockLoader.CYAN_STONE);
                        entries.add(BlockLoader.CYAN_STONE_SLAB);
                        entries.add(BlockLoader.CYAN_STONE_STAIRS);
                        entries.add(BlockLoader.CYAN_STONE_WALL);

                        entries.add(BlockLoader.BROWN_STONE);
                        entries.add(BlockLoader.BROWN_STONE_SLAB);
                        entries.add(BlockLoader.BROWN_STONE_STAIRS);
                        entries.add(BlockLoader.BROWN_STONE_WALL);

                        entries.add(BlockLoader.YELLOW_STONE_2);
                        entries.add(BlockLoader.YELLOW_STONE_2_SLAB);
                        entries.add(BlockLoader.YELLOW_STONE_2_STAIRS);
                        entries.add(BlockLoader.YELLOW_STONE_2_WALL);

                        entries.add(BlockLoader.YELLOW_STONE);
                        entries.add(BlockLoader.YELLOW_STONE_SLAB);
                        entries.add(BlockLoader.YELLOW_STONE_STAIRS);
                        entries.add(BlockLoader.YELLOW_STONE_WALL);

                        entries.add(BlockLoader.YELLOW_COBBLE);
                        entries.add(BlockLoader.YELLOW_COBBLE_SLAB);
                        entries.add(BlockLoader.YELLOW_COBBLE_STAIRS);
                        entries.add(BlockLoader.YELLOW_COBBLE_WALL);

                        entries.add(BlockLoader.ORANGE_ROCK);
                        entries.add(BlockLoader.ORANGE_ROCK_SLAB);
                        entries.add(BlockLoader.ORANGE_ROCK_STAIRS);
                        entries.add(BlockLoader.ORANGE_ROCK_WALL);

                        entries.add(BlockLoader.RED_ROCK);
                        entries.add(BlockLoader.RED_ROCK_SLAB);
                        entries.add(BlockLoader.RED_ROCK_STAIRS);
                        entries.add(BlockLoader.RED_ROCK_WALL);

                        entries.add(BlockLoader.CRACKED_GREEN_BASALT);
                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_SLAB);
                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
                        entries.add(BlockLoader.CRACKED_GREEN_BASALT_WALL);

                        entries.add(BlockLoader.CHISELED_BASALT);

                        entries.add(BlockLoader.GNEISS);
                        entries.add(BlockLoader.GNEISS_SLAB);
                        entries.add(BlockLoader.GNEISS_STAIRS);
                        entries.add(BlockLoader.GNEISS_WALL);

//                        entries.add(BlockLoader.LIMESTONE);
//                        entries.add(BlockLoader.LIMESTONE_SLAB);
//                        entries.add(BlockLoader.LIMESTONE_WALL);
//                        entries.add(BlockLoader.LIMESTONE_STAIRS);

//                        entries.add((BlockLoader.MARBLE_PINK));

                        entries.add(BlockLoader.CHALK);
                        entries.add(BlockLoader.CHALK_SLAB);
                        entries.add(BlockLoader.CHALK_WALL);
                        entries.add(BlockLoader.CHALK_STAIRS);

//                        entries.add(BlockLoader.BROWN_SANDSTONE_SLATES);

                        entries.add(BlockLoader.HIGH_ELVEN_ROCK);
                        entries.add(BlockLoader.HIGH_ELVEN_ROCK_STAIRS);
                        entries.add(BlockLoader.HIGH_ELVEN_ROCK_WALL);
                        entries.add(BlockLoader.HIGH_ELVEN_ROCK_SLAB);

                        entries.add(BlockLoader.DARK_HIGH_ELVEN_ROCK);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB);

                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_ROCK);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB);

                        entries.add(BlockLoader.HIGH_ELVEN_COBBLESTONE);
                        entries.add(BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS);
                        entries.add(BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL);
                        entries.add(BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB);

                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE);
                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS);
                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL);
                        entries.add(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB);

                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL);
                        entries.add(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB);

                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE);
                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL);
                        entries.add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB);

                        entries.add(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL);
                        entries.add(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB);

                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE);
                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL);
                        entries.add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB);

                        entries.add(BlockLoader.VULCANIC_ROCK);
                        entries.add(BlockLoader.VULCANIC_ROCK_STAIRS);
                        entries.add(BlockLoader.VULCANIC_ROCK_WALL);
                        entries.add(BlockLoader.VULCANIC_ROCK_SLAB);
//
                        entries.add(BlockLoader.SAND_LAYER);
                        entries.add(BlockLoader.RED_SAND_LAYER);
                        entries.add(BlockLoader.WHITE_SAND);
                        entries.add(BlockLoader.WHITE_SAND_LAYER);
                    })
                    .build();


    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(Edumia.MOD_ID, "edumia_rewards"),LEGENDS_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Edumia.MOD_ID, "edumia_plants"), EDUMIA_PLANTS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Edumia.MOD_ID,"edumia_gems"), EDUMIA_GEMS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Edumia.MOD_ID, "edumia_building_blocks"), EDUMIA_BUILDING_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Edumia.MOD_ID, "edumia_wood_blocks"), EDUMIA_WOOD_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Edumia.MOD_ID, "edumia_natural_stone_blocks"), EDUMIA_NATURAL_STONE_BLOCKS);
    }
}
