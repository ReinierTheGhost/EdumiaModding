package com.legends.edumia.world.waypoints;

import com.legends.edumia.world.map.SelectableMapObject;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public interface Waypoint extends SelectableMapObject {
    String getRawName();
    Text getDisplayName();

    @Nullable
    Text getDisplayLore();

    @Nullable
    Text getDisplayOwnership();

    double getMapX();

    double getMapZ();

    @Override
    int getWorldX();

    @Override
    int getWorldZ();

    default  Text getCoordsText(){
        return Text.translatable("gui.edumia.map.coords", new Object[]{this.getWorldX(), this.getWorldZ()});
    }

    default double getDistanceFromPlayer(PlayerEntity player){
        Vec3d playerPos = player.getPos();
        double x = (double) this.getWorldX() + 0.5;
        double z = (double) this.getWorldZ() + 0.5;
        Vec3d pos = new Vec3d(x, playerPos.y, z);
        return pos.distanceTo(playerPos);
    }

    @Nullable
    BlockPos getTravelPosition(ServerWorld var1, PlayerEntity var2);

    default boolean verifyFastTravellable(ServerWorld world, PlayerEntity player){
        return true;
    }

    boolean hasPlayerUnlocked(PlayerEntity var1);

    Text getNotUnlockedMessage(PlayerEntity var1);

    boolean isCustom();

    boolean isSharedCustom();

    boolean isSharedHidden();

    WaypointDisplayState getDisplayState(@Nullable PlayerEntity var1);

    WaypointNetworkType<?> getNetworkType();

    @Override
    default int getMapIconWidth(){
        return 6;
    }

    public static enum WaypointDisplayState{
        HIDDEN(0, 0),
        STANDARD(0, 200),
        STANDARD_LOCKED(6, 200),
        STANDARD_LOCKED_TO_ENEMIES(12, 200),
        STANDARD_CONQUERED(18, 200),
        CUSTOM(24, 200),
        CUSTOM_LOCKED(30, 200),
        SHARED_CUSTOM(36, 200),
        SHARED_CUSTOM_LOCKED(42, 200);

        public final int iconU;
        public final int iconV;
        public final int highlightIconU;
        public final int highlightIconV;

        WaypointDisplayState(int iconU, int iconV) {
            this.iconU = iconU;
            this.iconV = iconV;
            this.highlightIconU = this.iconU;
            this.highlightIconV = this.iconV + 6;
        }

        public boolean isHidden(){
            return this == HIDDEN;
        }
    }

}
