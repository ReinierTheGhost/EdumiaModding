package com.legends.edumia.datageneration.edumia.custom;

import com.legends.edumia.block.blocksets.*;
import com.legends.edumia.datageneration.edumia.custom.models.SimpleAxisSlabModel;
import com.legends.edumia.datageneration.edumia.custom.models.SimpleCornerBlockModel;
import com.legends.edumia.datageneration.edumia.custom.models.SimplePillarModels;
import com.legends.edumia.datageneration.edumia.custom.models.SimpleWoodBlockModel;
import com.legends.edumia.datageneration.edumia.custom.tags.Leaves;
import com.legends.edumia.datageneration.edumia.custom.tags.Pillar;
import com.legends.edumia.datageneration.edumia.custom.tags.RequiresIronTool;
import com.legends.edumia.datageneration.me.content.loot_tables.BlockDrops;
import com.legends.edumia.datageneration.me.content.loot_tables.LeavesDrops;
import com.legends.edumia.datageneration.me.content.models.*;
import com.legends.edumia.datageneration.me.content.tags.*;

public class EdumiaHelpingGenerator {
    public static void generateFiles() {
        for (WoodBlockSets.SimpleVanilaBlocks beam : WoodBlockSets.beams){
            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(beam.beam()));
        }

        for (ClayTilingSets.ClayTilingSet set : ClayTilingSets.sets){
            SimpleBlockModel.blocks.add(set.block());
            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block(), set.slab()));
            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block(), set.stairs()));
            SimpleCornerBlockModel.blocks.add(new SimpleCornerBlockModel.Corner(set.block(), set.corner()));

            BlockDrops.blocks.add(set.block());
            BlockDrops.blocks.add(set.slab());
            BlockDrops.blocks.add(set.stairs());
            BlockDrops.blocks.add(set.corner());

            MineablePickaxe.blocks.add(set.block());
            MineablePickaxe.blocks.add(set.slab());
            MineablePickaxe.blocks.add(set.stairs());
            MineablePickaxe.blocks.add(set.corner());

            RequiresIronTool.blocks.add(set.block());
            RequiresIronTool.blocks.add(set.slab());
            RequiresIronTool.blocks.add(set.stairs());
            RequiresIronTool.blocks.add(set.corner());

        }

        for (WoodBlockSets.SimpleBlockSet set : WoodBlockSets.sets){
            if(set.leaves() != null) {
                SimpleLeavesModel.blocks.add(set.leaves());
                LeavesDrops.blocks.add(set.leaves());
                Leaves.leaves.add(set.leaves());
            }
            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(set.log()));
            SimpleWoodBlockModel.blocks.add(new SimpleWoodBlockModel.WoodBlocks(set.log(), set.wood()));
            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(set.strippedLog()));
            SimpleWoodBlockModel.blocks.add(new SimpleWoodBlockModel.WoodBlocks(set.strippedLog(), set.strippedWood()));
            SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.log(), set.woodWall()));
            SimpleFenceModel.blocks.add(new SimpleFenceModel.Fence(set.wood(), set.woodFence()));
            SimpleBlockModel.blocks.add(set.planks());
            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.planks(), set.planksSlab()));
            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.planks(), set.planksStairs()));
            SimpleFenceModel.blocks.add(new SimpleFenceModel.Fence(set.planks(), set.planksFence()));
            SimpleFenceGateModel.blocks.add(new SimpleFenceGateModel.FenceGate(set.planks(), set.planksGate()));
            SimpleButtonModel.blocks.add(new SimpleButtonModel.Button(set.planks(), set.button()));
            SimplePressurePlateModel.blocks.add(new SimplePressurePlateModel.PressurePlate(set.planks(), set.pressurePlate()));
            SimplePillarModel.blocks.add(new SimplePillarModel.Pillar(set.beam()));

            BlockDrops.blocks.add(set.log());
            BlockDrops.blocks.add(set.wood());
            BlockDrops.blocks.add(set.strippedLog());
            BlockDrops.blocks.add(set.strippedWood());
            BlockDrops.blocks.add(set.woodWall());
            BlockDrops.blocks.add(set.woodFence());
            BlockDrops.blocks.add(set.planks());
            BlockDrops.blocks.add(set.planksSlab());
            BlockDrops.blocks.add(set.planksStairs());
            BlockDrops.blocks.add(set.planksFence());
            BlockDrops.blocks.add(set.planksGate());
            BlockDrops.blocks.add(set.button());
            BlockDrops.blocks.add(set.pressurePlate());

            MineableAxe.blocks.add(set.log());
            MineableAxe.blocks.add(set.wood());
            MineableAxe.blocks.add(set.strippedLog());
            MineableAxe.blocks.add(set.strippedWood());
            MineableAxe.blocks.add(set.woodWall());
            MineableAxe.blocks.add(set.woodFence());
            MineableAxe.blocks.add(set.planks());
            MineableAxe.blocks.add(set.planksSlab());
            MineableAxe.blocks.add(set.planksStairs());
            MineableAxe.blocks.add(set.planksFence());
            MineableAxe.blocks.add(set.planksGate());
            MineableAxe.blocks.add(set.button());
            MineableAxe.blocks.add(set.pressurePlate());

            Buttons.buttons.add(set.button());
            Fences.fences.add(set.woodFence());
            Fences.fences.add(set.planksFence());
            FenceGates.fenceGates.add(set.planksGate());
            Logs.logs.add(set.log());
            Logs.logs.add(set.wood());
            Logs.logs.add(set.woodWall());
            PressurePlates.pressurePlates.add(set.pressurePlate());
            Walls.walls.add(set.woodWall());
            Planks.planks.add(set.planks());
        }

        for (BuildingSets.BuildSet set : BuildingSets.buildSets){
            SimpleBlockModel.blocks.add(set.block());
            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block(), set.slab()));
            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block(), set.stair()));
            SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.block(), set.wall()));

            BlockDrops.blocks.add(set.block());
            BlockDrops.blocks.add(set.slab());
            BlockDrops.blocks.add(set.stair());
            BlockDrops.blocks.add(set.wall());

            MineablePickaxe.blocks.add(set.block());
            MineablePickaxe.blocks.add(set.slab());
            MineablePickaxe.blocks.add(set.stair());
            MineablePickaxe.blocks.add(set.wall());

            RequiresIronTool.blocks.add(set.block());
            RequiresIronTool.blocks.add(set.slab());
            RequiresIronTool.blocks.add(set.stair());
            RequiresIronTool.blocks.add(set.wall());

            Walls.walls.add(set.wall());

            if (set.pillar() != null){
                SimplePillarModels.blocks.add(new SimplePillarModels.Pillar(set.pillar()));
                BlockDrops.blocks.add(set.pillar());
                Pillar.pillars.add(set.pillar());
                MineablePickaxe.blocks.add(set.pillar());
                RequiresIronTool.blocks.add(set.pillar());
            }
        }

        for (NotBrickBuildingSets.BuildSet set : NotBrickBuildingSets.buildSets){
            SimpleBlockModel.blocks.add(set.block());
            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block(), set.slab()));
            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block(), set.stair()));

            BlockDrops.blocks.add(set.block());
            BlockDrops.blocks.add(set.slab());
            BlockDrops.blocks.add(set.stair());

            MineablePickaxe.blocks.add(set.block());
            MineablePickaxe.blocks.add(set.slab());
            MineablePickaxe.blocks.add(set.stair());

            if (set.wall() != null){
                SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.block(), set.wall()));
                BlockDrops.blocks.add(set.wall());
                MineablePickaxe.blocks.add(set.wall());
                RequiresIronTool.blocks.add(set.wall());
                Walls.walls.add(set.wall());
            }

        }

        for (OreRockSets.CompleteOreRockSet set : OreRockSets.vanillaSets) {
            SimpleBlockModel.blocks.add(set.tin_ore());

            MineablePickaxe.blocks.add(set.tin_ore());
        }

        for (StoneSets.StoneSet set : StoneSets.naturalSets){
            SimpleBlockModel.blocks.add(set.block());
            SimpleAxisSlabModel.blocks.add(new SimpleAxisSlabModel.Slab(set.block(), set.slab()));
            SimpleStairModel.blocks.add(new SimpleStairModel.Stair(set.block(), set.stair()));
            SimpleWallModel.blocks.add(new SimpleWallModel.Wall(set.block(), set.wall()));

            BlockDrops.blocks.add(set.block());
            BlockDrops.blocks.add(set.slab());
            BlockDrops.blocks.add(set.stair());
            BlockDrops.blocks.add(set.wall());

            MineablePickaxe.blocks.add(set.block());
            MineablePickaxe.blocks.add(set.slab());
            MineablePickaxe.blocks.add(set.stair());
            MineablePickaxe.blocks.add(set.wall());

            RequiresIronTool.blocks.add(set.block());
            RequiresIronTool.blocks.add(set.slab());
            RequiresIronTool.blocks.add(set.stair());
            RequiresIronTool.blocks.add(set.wall());


            Walls.walls.add(set.wall());
        }
    }
}
