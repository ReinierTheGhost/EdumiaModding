package com.legends.edumia.world.map;

import com.legends.edumia.utils.resources.FileUtils;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.joml.Vector2i;

import java.awt.image.BufferedImage;
import java.util.List;

public class EdumiaMapUtils {
    private static EdumiaMapUtils single_instance = null;

    private final float ratioX;
    private final float ratioZ;
    private final int maxImageCoordinateX;
    private final int maxImageCoordinateZ;
    private MinecraftServer server;
    public static synchronized EdumiaMapUtils getInstance()
    {
        if (single_instance == null)
            single_instance = new EdumiaMapUtils();

        return single_instance;
    }
    public EdumiaMapUtils(){
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            this.server = server;
        });

        BufferedImage initial = FileUtils.getInstance().getResourceImage(EdumiaMapConfigs.INITIAL_IMAGE);
        ratioX = (float) (EdumiaMapConfigs.REGION_SIZE / initial.getWidth() * Math.pow(2, EdumiaMapConfigs.MAP_ITERATION) * EdumiaMapConfigs.PIXEL_WEIGHT);
        ratioZ = (float) (EdumiaMapConfigs.REGION_SIZE / initial.getHeight() * Math.pow(2, EdumiaMapConfigs.MAP_ITERATION) * EdumiaMapConfigs.PIXEL_WEIGHT);
        maxImageCoordinateX = (int) (initial.getWidth() * ratioX);
        maxImageCoordinateZ = (int) (initial.getHeight() * ratioZ);
    }

    public List<ServerPlayerEntity> getPlayers() {
        return server.getPlayerManager().getPlayerList();
    }
    public int getTick() {
        if(server == null) return 1;
        return server.getTicks();
    }

    public Vector2i getWorldCoordinateFromInitialMap(int x, int z){
        return new Vector2i((int) (x * ratioX), (int) (z * ratioZ));
    }

    public Vector2i getRegionByWorldCoordinate(int x, int z){
        Vector2i region = new Vector2i();
        x /= EdumiaMapConfigs.PIXEL_WEIGHT;
        z /= EdumiaMapConfigs.PIXEL_WEIGHT;
        region.x = (int)((x - (x % EdumiaMapConfigs.REGION_SIZE)) / EdumiaMapConfigs.REGION_SIZE);
        region.y = (int)((z - (z % EdumiaMapConfigs.REGION_SIZE)) / EdumiaMapConfigs.REGION_SIZE);
        return region;
    }

    public boolean isWorldCoordinateInBorder(int x, int z) {
        if(x < 0 || z < 0) return false;
        return (x < maxImageCoordinateX && z < maxImageCoordinateZ);
    }
}
