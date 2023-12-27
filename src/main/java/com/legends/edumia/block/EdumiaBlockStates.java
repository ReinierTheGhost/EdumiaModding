package com.legends.edumia.block;

import com.legends.edumia.block.plants.ReedsBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class EdumiaBlockStates {
    public static final  EnumProperty<ReedsBlock.Type> REEDS_TYPE = EnumProperty.of("type", ReedsBlock.Type.class);
    public static final EnumProperty<Direction.Axis> SLAB_AXIS = Properties.AXIS;
    public static final BooleanProperty PILLAR_ABOVE = BooleanProperty.of("above");
    public static final BooleanProperty PILLAR_BELOW = BooleanProperty.of("below");
}
