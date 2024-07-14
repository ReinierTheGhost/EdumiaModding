package com.legends.edumia.world.biomes.surface;

import com.legends.edumia.world.worldgen.placed.TreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.biomes.BiomePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.boulders.BoulderPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.crystrals.CrystalPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.plants.ReedsPlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.BorealTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.OakTreePlacedFeatures;
import com.legends.edumia.world.worldgen.placed.trees.TemperateTreePlacedFeatures;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.ArrayList;
import java.util.List;

public class ModBiomeFeatures {

    public static void addDisks(ArrayList<RegistryKey<PlacedFeature>> ores) {
        ores.add(MiscPlacedFeatures.DISK_SAND);
        ores.add(MiscPlacedFeatures.DISK_CLAY);
        ores.add(MiscPlacedFeatures.DISK_GRAVEL);
    }

    public static void addRiverSand(ArrayList<RegistryKey<PlacedFeature>> ores) {
    }
    public static void addRiverDisks(ArrayList<RegistryKey<PlacedFeature>> ores) {
        ores.add(MiscPlacedFeatures.DISK_CLAY);
        ores.add(MiscPlacedFeatures.DISK_GRAVEL);
    }

    // region TREES
    public static void addAcaciaTrees(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addCommonBeechTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TreePlacedFeatures.COMMON_BEECH_PLACED_TREE_KEY);
    }
    public static void addBeechTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TreePlacedFeatures.BEECH_PLACED_TREE_KEY);
    }
    public static void addRareBeechTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TreePlacedFeatures.RARE_BEECH_PLACED_TREE_KEY);
    }
    public static void addVeryRareBeechTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TreePlacedFeatures.VERY_RARE_BEECH_PLACED_TREE_KEY);
    }
    public static void addBirchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.BIRCH_PLACED_TREE_KEY);
    }
    public static void addSparseBirchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.SPARSE_BIRCH_PLACED_TREE_KEY);
    }
    public static void addRareBirchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.RARE_BIRCH_PLACED_TREE_KEY);
    }
    public static void addVeryRareBirchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.VERY_RARE_BIRCH_PLACED_TREE_KEY);
    }
    public static void addMegaBirchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.MEGA_BIRCH_PLACED_TREE_KEY);
    }
    public static void addMegaBirchCommonTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.MEGA_BIRCH_PLACED_COMMON_TREE_KEY);
    }
    public static void addMegaDarkOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.MEGA_DARK_OAK_PLACED_TREE_KEY);
    }
    public static void addMegaDarkOakCommonTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.MEGA_DARK_OAK_PLACED_COMMON_TREE_KEY);
    }
    public static void addCommonLarchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.COMMON_LARCH_PLACED_TREE_KEY);
    }
    public static void addLarchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.LARCH_PLACED_TREE_KEY);
    }
    public static void addSparseLarchTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.SPARSE_LARCH_PLACED_TREE_KEY);
    }
    public static void addBlackthornTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.BLACKTHORN_PLACED_TREE_KEY);
    }
    public static void addCommonBlackthornTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.COMMON_BLACKTHORN_PLACED_TREE_KEY);
    }
    public static void addRareBlackthornTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.RARE_BLACKTHORN_PLACED_TREE_KEY);
    }
    public static void addWhiteAshTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.WHITE_ASH_PLACED_TREE_KEY);
    }
    public static void addSmallWhiteAshTress(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.SMALL_WHITE_ASH_PLACED_TREE_KEY);
    }
    public static void addMegaWhiteAshTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.MEGA_WHITE_ASH_PLACED_TREE_KEY);
    }
    public static void addWhiteAshBushes(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.WHITE_ASH_BUSH_PLACED_TREE_KEY);
    }
    public static void addMapleTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.MAPLE_PLACED_TREE_KEY);
    }

    public static void addDarkElvenOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BiomePlacedFeatures.DARK_ELVEN_OAK_TREES_KEY);
    }
    public static void addSmallRedOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.SMALL_RED_OAK_PLACED_TREE_KEY);
    }
    public static void addRedOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.RED_OAK_PLACED_TREE_KEY);
    }
    public static void addSparseRedOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.SPARSE_RED_OAK_PLACED_TREE_KEY);
    }
    public static void addMegaRedOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.MEGA_RED_OAK_PLACED_TREE_KEY);
    }

    public static void addSmallGreenOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.SMALL_GREEN_OAK_PLACED_TREE_KEY);
    }
    public static void addGreenOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.GREEN_OAK_PLACED_TREE_KEY);
    }
    public static void addSparseGreenOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.SPARSE_GREEN_OAK_PLACED_TREE_KEY);
    }
    public static void addMegaGreenOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.MEGA_GREEN_OAK_PLACED_TREE_KEY);
    }

    public static void addSmallBlackOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.SMALL_BLACK_OAK_PLACED_TREE_KEY);
    }
    public static void addBlackOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.BLACK_OAK_PLACED_TREE_KEY);
    }
    public static void addSparseBlackOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.SPARSE_BLACK_OAK_PLACED_TREE_KEY);
    }
    public static void addMegaBlackOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.MEGA_BLACK_OAK_PLACED_TREE_KEY);
    }

    public static void addCommonOakBush(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.OAK_BUSH_COMMON_PLACED_TREE_KEY);
    }
    public static void addOakBushes(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.OAK_BUSH_PLACED_TREE_KEY);
    }
    public static void addCommonOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.COMMON_OAK_PLACED_TREE_KEY);
    }
    public static void addOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.OAK_PLACED_TREE_KEY);
    }
    public static void addRareOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.RARE_OAK_PLACED_TREE_KEY);
    }
    public static void addOakVinesTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.OAK_VINES_PLACED_TREE_KEY);
    }
    public static void addMegaOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.MEGA_OAK_PLACED_TREE_KEY);
    }
    public static void addMegaOakCommonTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.MEGA_OAK_COMMON_PLACED_TREE_KEY);
    }
    public static void addRareMegaOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.RARE_MEGA_OAK_PLACED_TREE_KEY);
    }
    public static void addVeryRareMegaOakTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(OakTreePlacedFeatures.VERY_RARE_MEGA_OAK_PLACED_TREE_KEY);
    }

    public static void addPalmTrees(List<RegistryKey<PlacedFeature>> vegetation) {
    }

    public static void addAbundantPineTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.ABUNDANT_PINE_PLACED_TREE_KEY);
    }
    public static void addCommonPineTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.COMMON_PINE_PLACED_TREE_KEY);
    }
    public static void addPineTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.PINE_PLACED_TREE_KEY);
    }
    public static void addDeadPineTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.DEAD_PINE_PLACED_TREE_KEY);
    }

    public static void addAbundantSpruceTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.FOOTHILLS_SPRUCE_PLACED_TREE_KEY);
    }
    public static void addCommonSpruceTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.COMMON_SPRUCE_PLACED_TREE_KEY);
    }
    public static void addSpruceTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.SPRUCE_PLACED_TREE_KEY);
    }
    public static void addSparsePineTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.SPARSE_PINE_PLACED_TREE_KEY);
    }
    public static void addScarceSpruceTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.SCARCE_SPRUCE_PLACED_TREE_KEY);
    }
    public static void addRareSpruceTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.RARE_SPRUCE_PLACED_TREE_KEY);
    }
    public static void addCommonSpruceBushes(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.COMMON_SPRUCE_BUSH_PLACED_TREE_KEY);
    }
    public static void addSpruceBushes(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.SPRUCE_BUSH_PLACED_TREE_KEY);
    }
    public static void addVeryRareSpruceTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BorealTreePlacedFeatures.VERY_RARE_SPRUCE_PLACED_TREE_KEY);
    }
    public static void addWillowTrees(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(TemperateTreePlacedFeatures.WILLOW_PLACED_TREE_KEY);
    }
    // endregion TREES

    public static void addReeds(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(ReedsPlacedFeatures.REEDS);
    }
    public static void addElvenCrystal(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(CrystalPlacedFeatures.ELVEN_CRYSTAL);
    }

    // region BOULDERS
    public static void addAndesiteBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.ANDESITE_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_ANDESITE_BOULDER);
    }
    public static void addCalciteBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.CALCITE_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_CALCITE_BOULDER);
    }
    public static void addDioriteBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.DIORITE_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_DIORITE_BOULDER);
    }
    public static void addGraniteBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.GRANITE_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_GRANITE_BOULDER);
    }
    public static void addLimestoneBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.LIMESTONE_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_LIMESTONE_BOULDER);
    }
    public static void addMirkwoodRoots(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addSandStoneBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.SANDSTONE_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_SANDSTONE_BOULDER);
    }
    public static void addStoneBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.STONE_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_STONE_BOULDER);
    }
    public static void addMossyBoulder(List<RegistryKey<PlacedFeature>> vegetation) {
        vegetation.add(BoulderPlacedFeatures.MOSSY_BOULDER);
        vegetation.add(BoulderPlacedFeatures.BIG_MOSSY_BOULDER);
    }
    // endregion

    // region FOLIAGE
    public static void addWaterDelta(List<RegistryKey<PlacedFeature>> vegetation) {
    }

    public static void addCornflower(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addFlowerGreenJewel(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addFlowerDorwinion(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addLebenninFlowers(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addFlowerMeadow(List<RegistryKey<PlacedFeature>> vegetation) {
    }

    public static void addBasaltPile(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addBlackStonePile(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addHaradFoliage(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addCoastalFoliage(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addCorruptedMoss(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addDryGrass(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addDyingGrass(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addForestMoss(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addForestBlockMoss(List<RegistryKey<PlacedFeature>> vegetation) {
    }

    public static void addRareForestMoss(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addHeather(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addRareHeather(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addHeatherBush(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addRedHeather(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addMallos(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addStrawberries(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addToughBerries(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addCommonToughBerries(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addToughBerriesRare(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addTuftGrass(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addMordorLichen(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addReedsFoliage(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWheatGrass(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildGrass(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWilderGrass(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    // endregion

    // region MUSHROOMS
    public static void addBrownBolete(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addMorsel(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWhiteMushroom(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addRareMorsel(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addRareWhiteMushroom(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    // endregion

    // region WILD CROPS
    public static void addWildBeetroot(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildBellPepper(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildCarrot(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildCucumber(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildFlax(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildGarlic(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildLeek(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildLettuce(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildOnion(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildPipeweed(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildPotato(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWildTomato(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    // endregion

    // region ORES
    public static void addAndesiteOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addAshBlockOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addAshenDirtOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addAshenDirtStoneOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addBasaltOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addSmoothBasaltOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addBlackSand(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addBlueTuff(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addCalciteOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addRareCalciteOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addCoarseDirtOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addDioriteOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addDolomiteOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addDripstoneOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addDryDirtOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addFrozenStone(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addGraniteOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addGravelOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addStoneGrassOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addStoneGrassAbundantOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addLimestoneOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addAbundantMudOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addMudOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addPackedMudOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addPodzolOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addPowderSnowOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addOldPodzolOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addSnowOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addSandOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addCalciteStoneOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addGrassStoneOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addTerracottaOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addTuffOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addAbundantTuffOre(List<RegistryKey<PlacedFeature>> vegetation) {
    }
    public static void addWhiteSand(List<RegistryKey<PlacedFeature>> vegetation) {

    }
    // endregion

    // region MISC
    public static void addLavaMagmaLake(GenerationSettings.LookupBackedBuilder generationSettings) {
    }
    // endregion
}
