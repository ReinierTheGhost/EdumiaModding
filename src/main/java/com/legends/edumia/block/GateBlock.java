package com.legends.edumia.block;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Waterloggable;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.Map;

public class GateBlock extends Block implements Waterloggable {
    public static final DirectionProperty FACING = Properties.FACING;
    public static final BooleanProperty OPEN = EdumiaBlockStates.GATE_OPEN;
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;
    public static final BooleanProperty NORTH = Properties.NORTH;
    public static final BooleanProperty SOUTH = Properties.SOUTH;
    public static final BooleanProperty WEST = Properties.WEST;
    public static final BooleanProperty EAST = Properties.EAST;

    private static final Map<Direction, BooleanProperty> CONNECTED_DIRECTION_TO_PROPERTY_MAP = Util.make(Maps.newEnumMap(Direction.class), (map) -> {
        map.put(Direction.UP, UP);
        map.put(Direction.DOWN, DOWN);
        map.put(Direction.NORTH, NORTH);
        map.put(Direction.SOUTH, SOUTH);
        map.put(Direction.WEST, WEST);
        map.put(Direction.EAST, EAST);
    });
    private static final VoxelShape TOP_SHAPE =
            Block.createCuboidShape(0.0, 12.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape BOTTOM_SHAPE =
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);
    private static final VoxelShape WEST_EAST_SHAPE =
            Block.createCuboidShape(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);
    private static final VoxelShape NORTH_SOUTH_SHAPE  =
            Block.createCuboidShape(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
    public final boolean fullBlockGate = false;
    private final boolean isCutoutGate;

    public GateBlock(Settings settings, boolean isCutoutGate) {
        super(settings);
        this.isCutoutGate = isCutoutGate;
    }


}
