package com.legends.edumia.world.dimension;

import com.legends.edumia.Edumia;
import com.legends.edumia.utils.LoggerUtil;
import com.legends.edumia.world.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.world.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.world.map.EdumiaMapConfigs;
import com.legends.edumia.world.map.EdumiaMapUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import org.joml.Vector2i;
import org.joml.Vector3i;

import java.util.OptionalLong;


public class ModDimensions {
    public static final Vector3i ME_SPAWN_LOCATION = new Vector3i(939, 90, 915);
    public static final String PATH = "edumia";

    public static final RegistryKey<DimensionOptions> DIMENSION_KEY =
            RegistryKey.of(RegistryKeys.DIMENSION, new Identifier(Edumia.MOD_ID, PATH));

    public static RegistryKey<World> WORLD_KEY =
            RegistryKey.of(RegistryKeys.WORLD, DIMENSION_KEY.getValue());





    public static void register() {
        Registry.register(Registries.CHUNK_GENERATOR, new Identifier(Edumia.MOD_ID, PATH), EdumiaChunkGenerator.CODEC);
        WORLD_KEY = RegistryKey.of(RegistryKeys.WORLD, new Identifier(Edumia.MOD_ID, PATH));

        LoggerUtil.getInstance().logDebugMsg("Registering ModDimensions for " + Edumia.MOD_ID);
    }

    public static void teleportPlayerToME(PlayerEntity player) {
        Vector2i coordinates = EdumiaMapUtils.getInstance().getWorldCoordinateFromInitialMap(ME_SPAWN_LOCATION.x, ME_SPAWN_LOCATION.z);
        int height = (int) (1 + EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaHeightMap.getHeight(coordinates.x, coordinates.y));
        Vector3i targetCoords = new Vector3i(coordinates.x, height, coordinates.y);
        teleportPlayerToMe(player, targetCoords);
    }

    public static void teleportPlayerToMe(PlayerEntity player, Vector3i coordinates){
        if(!player.getWorld().isClient()) {
            RegistryKey<World> registryKey = WORLD_KEY;
            ServerWorld serverWorld = (ServerWorld) player.getWorld();
            if (serverWorld != null) {
                serverWorld = serverWorld.getServer().getWorld(registryKey);

                player.wakeUp();

                ((ServerPlayerEntity) player).teleport(serverWorld, coordinates.x , coordinates.y, coordinates.z, 0, 0);
                player.refreshPositionAfterTeleport(coordinates.x, coordinates.y, coordinates.z);
            }
        }
    }

    public static int getHighestYAtXZ(int x, int z) {
        return (int) EdumiaHeightMap.getHeight(x, z);
    }

    public static Vector3i getSpawnCoordinate(){
        double worldIteration = Math.pow(2, EdumiaMapConfigs.MAP_ITERATION);
        int x = (int)((ME_SPAWN_LOCATION.x * worldIteration));
        int z = (int)((ME_SPAWN_LOCATION.z * worldIteration));

        return new Vector3i(x, ME_SPAWN_LOCATION.y, z);
    }

    public static boolean isInEdumia(World world){
        return world.getRegistryKey().getValue().equals(WORLD_KEY.getValue());
    }
}
