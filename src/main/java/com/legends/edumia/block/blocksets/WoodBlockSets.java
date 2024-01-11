package com.legends.edumia.block.blocksets;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.block.ModNatureBlocks;
import com.legends.edumia.block.WoodBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class WoodBlockSets {
    public static final float WOOD_STRENGTH = 2f;
    public static final float PLATE_BUTTON_STRENGTH = 0.5f;
    public static final float LEAVES_STRENGTH = 0.1f;

    public static SimpleBlockSet APPLE = registerWoodSet("apple", WOOD_STRENGTH, true);
    public static SimpleBlockSet ASPEN = registerWoodSet("aspen", WOOD_STRENGTH, true);
    public static SimpleBlockSet BEECH = registerWoodSet("beech", WOOD_STRENGTH, true);
    public static SimpleBlockSet BLACKTHORN = registerWoodSet("blackthorn", WOOD_STRENGTH, true);
    public static SimpleBlockSet CEDAR = registerWoodSet("cedar", WOOD_STRENGTH, true);
    public static SimpleBlockSet CHERRY = registerWoodSet("cherry", WOOD_STRENGTH, true);
    public static SimpleBlockSet CYPRESS = registerWoodSet("cypress", WOOD_STRENGTH, true);
    public static SimpleBlockSet FIR = registerWoodSet("fir", WOOD_STRENGTH, true);
    public static SimpleBlockSet GHOST_GUM = registerWoodSet("ghost_gum", WOOD_STRENGTH, false);
    public static SimpleBlockSet GREEN_OAK = registerWoodSet("green_oak", WOOD_STRENGTH, true);
    public static SimpleBlockSet HOLLY = registerWoodSet("holly", WOOD_STRENGTH, false);
    public static SimpleBlockSet LARCH = registerWoodSet("larch", WOOD_STRENGTH, true);
    public static SimpleBlockSet MAPLE = registerWoodSet("maple", WOOD_STRENGTH, false);
    public static SimpleBlockSet PEAR = registerWoodSet("pear", WOOD_STRENGTH, true);
    public static SimpleBlockSet PINE = registerWoodSet("pine", WOOD_STRENGTH, true);
    public static SimpleBlockSet RED_OAK = registerWoodSet("red_oak", WOOD_STRENGTH, true);
    public static SimpleBlockSet REDWOOD = registerWoodSet("redwood", WOOD_STRENGTH, true);
    public static SimpleBlockSet SILVER_SPRUCE = registerWoodSet("silver_spruce", WOOD_STRENGTH, true);
    public static SimpleBlockSet WHITE_ASH = registerWoodSet("white_ash", WOOD_STRENGTH, true);
    public static SimpleBlockSet DRAGON_BLOOD = registerWoodSet("dragon_blood", WOOD_STRENGTH, true);

    public static SimpleVanillaBlocks OAK = registerBeams("oak", WOOD_STRENGTH);
    public static SimpleVanillaBlocks ACACIA = registerBeams("acacia", WOOD_STRENGTH);
    public static SimpleVanillaBlocks BIRCH = registerBeams("birch", WOOD_STRENGTH);
    public static SimpleVanillaBlocks SPRUCE = registerBeams("spruce", WOOD_STRENGTH);
    public static SimpleVanillaBlocks DARK_OAK = registerBeams("dark_oak", WOOD_STRENGTH);
    public static SimpleVanillaBlocks JUNGLE = registerBeams("jungle", WOOD_STRENGTH);



    public static SimpleBlockSet[] sets = new SimpleBlockSet[] {
            APPLE,
            ASPEN,
            BEECH,
            BLACKTHORN,
            CEDAR,
            CHERRY,
            CYPRESS,
            DRAGON_BLOOD,
            FIR,
            GHOST_GUM,
            GREEN_OAK,
            HOLLY,
            LARCH,
            MAPLE,
            PEAR,
            PINE,
            RED_OAK,
            REDWOOD,
            SILVER_SPRUCE,
            WHITE_ASH,

    };

    public static SimpleVanillaBlocks[] beams = new SimpleVanillaBlocks[]{
            OAK,
            ACACIA,
            SPRUCE,
            BIRCH,
            JUNGLE,
            DARK_OAK,
    };

    public record SimpleBlockSet(Block leaves, Block log, Block wood, Block woodStairs, Block woodSlab, Block woodWall, Block woodFence,
                                 Block strippedLog, Block strippedWood, Block strippedWoodStairs, Block strippedWoodSlab,
                                 Block strippedWoodWall, Block strippedWoodFence,
                                 Block planks, Block planksSlab, Block planksStairs, Block planksFence, Block planksGate,
                                 Block pressurePlate, Block button, Block beam) {
    }

    public record SimpleVanillaBlocks(Block beam){}

    private static SimpleVanillaBlocks registerBeams(String name, float strength){
        Block beam = WoodBlocks.registerWoodBlock(name + "_beam", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(strength)
                .sounds(BlockSoundGroup.WOOD)));

         return new SimpleVanillaBlocks(beam);
    }


    private static SimpleBlockSet registerWoodSet(String name, float strength, boolean hasLeaves) {
        Block leaves = null;
        if(hasLeaves) {
            leaves = ModNatureBlocks.registerPlantBlock(name + "_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .strength(LEAVES_STRENGTH).sounds(BlockSoundGroup.GRASS)), false);
        }
        Block log = WoodBlocks.registerWoodBlock(name + "_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block wood = WoodBlocks.registerWoodBlock(name + "_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(strength).sounds(BlockSoundGroup.WOOD)));
        Block woodStairs = WoodBlocks.registerWoodBlock(name + "_wood_stairs", new StairsBlock(wood.getDefaultState(),
                FabricBlockSettings.copy(wood).strength(strength).sounds(BlockSoundGroup.WOOD)));
        Block woodSlab = WoodBlocks.registerWoodBlock(name + "_wood_slab", new AxialSlabBlock(wood));
        Block woodWall = WoodBlocks.registerWoodBlock(name + "_wood_wall", new WallBlock(AbstractBlock.Settings.copy(wood).strength(strength).sounds(BlockSoundGroup.WOOD)));
        Block woodFence = WoodBlocks.registerWoodBlock(name + "_wood_fence", new FenceBlock(FabricBlockSettings.copyOf(wood).strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block strippedLog = WoodBlocks.registerWoodBlock("stripped_" + name + "_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block strippedWood = WoodBlocks.registerWoodBlock("stripped_" + name + "_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block strippedWoodStairs = WoodBlocks.registerWoodBlock("stripped_" + name + "_wood_stairs", new StairsBlock(wood.getDefaultState(),
                FabricBlockSettings.copy(wood).strength(strength).sounds(BlockSoundGroup.WOOD)));
        Block strippedWoodSlab = WoodBlocks.registerWoodBlock("stripped_" + name + "_wood_slab", new AxialSlabBlock(strippedWood));
        Block strippedWoodWall = WoodBlocks.registerWoodBlock("stripped_" + name + "_wood_wall", new WallBlock(AbstractBlock.Settings.copy(wood).strength(strength).sounds(BlockSoundGroup.WOOD)));
        Block strippedWoodFence = WoodBlocks.registerWoodBlock("stripped_" + name + "_wood_fence", new FenceBlock(FabricBlockSettings.copyOf(wood).strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block planks = WoodBlocks.registerWoodBlock(name + "_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block slab = WoodBlocks.registerWoodBlock(name + "_slab", new AxialSlabBlock(planks));

        Block stairs = WoodBlocks.registerWoodBlock(name + "_stairs", new StairsBlock(planks.getDefaultState(),
                FabricBlockSettings.copyOf(planks).strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block fence = WoodBlocks.registerWoodBlock(name + "_fence", new FenceBlock(FabricBlockSettings.copyOf(planks)
                .strength(strength).sounds(BlockSoundGroup.WOOD)));

        Block gate = WoodBlocks.registerWoodBlock(name + "_fence_gate",  new FenceGateBlock(FabricBlockSettings.copyOf(planks)
                .strength(strength).sounds(BlockSoundGroup.WOOD), WoodType.OAK));

        Block button = WoodBlocks.registerWoodBlock(name + "_button",  new ButtonBlock(FabricBlockSettings.copyOf(planks).strength(PLATE_BUTTON_STRENGTH)
                .sounds(BlockSoundGroup.WOOD), BlockSetType.OAK, 5, true));

        Block pressurePlate = WoodBlocks.registerWoodBlock(name + "_pressure_plate",  new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                FabricBlockSettings.copyOf(planks).strength(PLATE_BUTTON_STRENGTH).sounds(BlockSoundGroup.WOOD), BlockSetType.OAK));

        Block beam = WoodBlocks.registerWoodBlock(name + "_beam", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(strength)
                .sounds(BlockSoundGroup.WOOD)));

        return new SimpleBlockSet(leaves, log, wood, woodStairs, woodSlab, woodWall,woodFence,
                strippedLog, strippedWood, strippedWoodStairs, strippedWoodSlab, strippedWoodWall, strippedWoodFence, planks, slab, stairs, fence, gate, pressurePlate, button, beam);
    }

    public static void registerModBlockSets() {
        Edumia.LOGGER.debug("Registering WoodBlockSets for " + Edumia.MOD_ID);
    }
}
