package com.legends.edumia.world.dimension;

import com.legends.edumia.Edumia;
import com.legends.edumia.world.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.world.chunkgen.map.EdumiaHeightMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import org.joml.Vector3i;


public class ModDimensions {
    public static final Vector3i ME_SPAWN_LOCATION = new Vector3i(440, 90, 350);
    public static final String PATH = "edumia";

    public static final RegistryKey<DimensionOptions> DIMENSION_KEY =
            RegistryKey.of(RegistryKeys.DIMENSION, new Identifier(Edumia.MOD_ID, PATH));

    public static RegistryKey<World> WORLD_KEY =
            RegistryKey.of(RegistryKeys.WORLD, DIMENSION_KEY.getValue());

    public static void register() {
        Registry.register(Registries.CHUNK_GENERATOR, new Identifier(Edumia.MOD_ID, PATH), EdumiaChunkGenerator.CODEC);
        WORLD_KEY = RegistryKey.of(RegistryKeys.WORLD, new Identifier(Edumia.MOD_ID, PATH));

        Edumia.LOGGER.debug("Registering ModDimensions for " + Edumia.MOD_ID);
    }

    public static void teleportPlayerToME(PlayerEntity player) {
        if(!player.getWorld().isClient()) {
            RegistryKey<World> registryKey = player.getWorld().getRegistryKey() == WORLD_KEY ? World.OVERWORLD : WORLD_KEY;
            ServerWorld serverWorld = (ServerWorld) player.getWorld();
            if (serverWorld != null) {
                serverWorld = serverWorld.getServer().getWorld(registryKey);

                Vector3i targetPos = getSpawnCoordinate();
                if(registryKey != WORLD_KEY) targetPos = new Vector3i(serverWorld.getSpawnPos().getX(), 80, serverWorld.getSpawnPos().getZ());

                player.wakeUp();
                ((ServerPlayerEntity) player).teleport(serverWorld, targetPos.x, targetPos.y + 10, targetPos.z, 0, 0);
                World targetWorld =  player.getWorld();
                int highY = 1 + getHighestYAtXZ(targetPos.x, targetPos.z);

                player.refreshPositionAfterTeleport(targetPos.x, highY, targetPos.z);
            }
        }
    }

    public static int getHighestYAtXZ(int x, int z) {
        return (int) EdumiaHeightMap.getHeight(x, z);
    }

    public static Vector3i getSpawnCoordinate(){
        double worldIteration = Math.pow(2, Edumia.MAP_ITERATION);
        int x = (int)((ME_SPAWN_LOCATION.x * worldIteration));
        int z = (int)((ME_SPAWN_LOCATION.z * worldIteration));

        return new Vector3i(x, ME_SPAWN_LOCATION.y, z);
    }
}
