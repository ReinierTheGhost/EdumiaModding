package com.legends.edumia.block;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.trees.BlackOakLeavesBlock;
import com.legends.edumia.core.CreativeTabLoader;
import com.legends.edumia.world.worldgen.treegrowers.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
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
    public static final Block BLACK_OAK_LEAVES = ModNatureBlocks.registerPlantBlock("black_oak_leaves",
            new BlackOakLeavesBlock(), false);

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

    public static final Block TEST_SAPLING = registerPlantBlock("test_sapling",
            new SaplingBlock(new TestTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);
    public static final Block APPLE_SAPLING = registerPlantBlock("apple_sapling",
            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);
    public static final Block BANANA_SAPLING = registerPlantBlock("banana_sapling",
            new SaplingBlock(new AppleTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);

    public static final Block ASPEN_SAPLING = registerPlantBlock("aspen_sapling",
            new SaplingBlock(new AspenTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);

    public static final Block GHOST_GUM_SAPLING = registerPlantBlock("ghost_gum_sapling",
            new SaplingBlock(new GhostGumTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block BEECH_SAPLING = registerPlantBlock("beech_sapling",
            new SaplingBlock(new BeechTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);

    public static final Block BLACKTHORN_SAPLING = registerPlantBlock("blackthorn_sapling",
            new SaplingBlock(new BlackthornTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);
    public static final Block BLACK_OAK_SAPLING = registerPlantBlock("black_oak_sapling",
            new SaplingBlock(new BlackOakTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);

    public static final Block CEDAR_SAPLING = registerPlantBlock("cedar_sapling",
            new SaplingBlock(new CederTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block CHERRY_SAPLING = registerPlantBlock("cherry_sapling",
            new SaplingBlock(null, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block CYPRESS_SAPLING = registerPlantBlock("cypress_sapling",
            new SaplingBlock(new CypressTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);
    public static final Block DRAGON_BLOOD_SAPLING = registerPlantBlock("dragon_blood_sapling",
            new SaplingBlock(new DragonBloodTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block FIR_SAPLING = registerPlantBlock("fir_sapling",
            new SaplingBlock(new FirTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block GREEN_OAK_SAPLING = registerPlantBlock("green_oak_sapling",
            new SaplingBlock(new GreenOakTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block HOLLY_SAPLING = registerPlantBlock("holly_sapling",
            new SaplingBlock(new HollyTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block LARCH_SAPLING = registerPlantBlock("larch_sapling",
            new SaplingBlock(new LarchTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);

    public static final Block MAHOGANY_SAPLING = registerPlantBlock("mahogany_sapling",
            new SaplingBlock(new MahoganyTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);
    public static final Block MAPLE_SAPLING = registerPlantBlock("maple_sapling",
            new SaplingBlock(null, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);
    public static final Block MANGO_SAPLING = registerPlantBlock("mango_sapling",
            new SaplingBlock(new MangoTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block PEAR_SAPLING = registerPlantBlock("pear_sapling",
            new SaplingBlock(null, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);

    public static final Block PALM_SAPLING = registerPlantBlock("palm_sapling",
            new SaplingBlock(new PalmTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);
    public static final Block PINE_SAPLING = registerPlantBlock("pine_sapling",
            new SaplingBlock(new PineTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);



    public static final Block RED_OAK_SAPLING = registerPlantBlock("red_oak_sapling",
            new SaplingBlock(new RedOakTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block REDWOOD_SAPLING = registerPlantBlock("redwood_sapling",
            new SaplingBlock(new RedwoodTreeGrowen(), AbstractBlock.Settings.create()), false);


    public static final Block SILVER_SPRUCE_SAPLING = registerPlantBlock("silver_spruce_sapling",
            new SaplingBlock(new SilverSpruceTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);


    public static final Block WHITE_ASH_SAPLING = registerPlantBlock("white_ash_sapling",
            new SaplingBlock(new WhiteAshTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);

    public static final Block WILLOW_SAPLING = registerPlantBlock("willow_sapling",
            new SaplingBlock(new WillowTreeGrower(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), false);









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
