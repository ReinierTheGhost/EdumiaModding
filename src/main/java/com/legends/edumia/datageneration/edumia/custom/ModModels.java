package com.legends.edumia.datageneration.edumia.custom;

import com.legends.edumia.Edumia;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels {
    public static final Model CRYSTAL_CLUSTER;
    public static final Model SMALL_ARCH;
    public static final Model TWO_METER_ARCH;
    public static final Model TWO_METER_ARCH_HALF_LEFT;
    public static final Model TWO_METER_ARCH_HALF_RIGHT;
    public static final Model LAYER_HEIGHT2;
    public static final Model LAYER_HEIGHT4;
    public static final Model LAYER_HEIGHT6;
    public static final Model LAYER_HEIGHT8;
    public static final Model LAYER_HEIGHT10;
    public static final Model LAYER_HEIGHT12;
    public static final Model LAYER_HEIGHT14;

    public static final Model BALUSTRADE;
    public static final Model BALUSTRADE_BASE;
    public static final Model BALUSTRADE_BASE_OVERLAY_TOP;
    public static final Model BALUSTRADE_OVERLAY_TOP;
    public static final Model BALUSTRADE_OVERLAY_TOP_INVERTED;
    public static final Model SMALL_ARCH_HALF;
    public static final Model SMOOTH_GOTHIC_ARCH_1;
    public static final Model SMOOTH_GOTHIC_ARCH_2;
    public static final Model SMOOTH_GOTHIC_ARCH_3;
    public static final Model SMOOTH_GOTHIC_ARCH_3_MIDDLE;
    public static final Model SMOOTH_ROUND_ARCH_1;
    public static final Model SMOOTH_ROUND_ARCH_2;
    public static final Model SMOOTH_ROUND_ARCH_3;
    public static final Model SMOOTH_ROUND_ARCH_3_MIDDLE;
    public static final Model SMOOTH_SEGMENTAL_ARCH_1;
    public static final Model SMOOTH_SEGMENTAL_ARCH_2;
    public static final Model SMOOTH_SEGMENTAL_ARCH_3;
    public static final Model SMOOTH_SEGMENTAL_ARCH_3_MIDDLE;
    public static final Model TEMPLATE_ARROWSLIT;
    public static final Model TEMPLATE_FALLEN_LEAVES;
    public static final Model TEMPLATE_VERTICAL_CORNER_1;
    public static final Model TEMPLATE_VERTICAL_CORNER_2;
    public static final Model TEMPLATE_VERTICAL_CORNER_4;
    public static final Model TEMPLATE_VERTICAL_CORNER_6;
    public static final Model THIN_BLOCK;



    public ModModels(){

    }

    private static Model make(TextureKey... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(Edumia.MOD_ID, "block/template/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(Edumia.MOD_ID, "item/template/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(Edumia.MOD_ID, "block/template/" + parent)), Optional.of(variant), requiredTextureKeys);
    }

    static {
        CRYSTAL_CLUSTER = block("template_crystal_cluster", TextureKey.TEXTURE);
        SMALL_ARCH = block("arch_small_parent", TextureKey.PARTICLE, TextureKey.TEXTURE, TextureKey.TOP);
        TWO_METER_ARCH = block("arch_twometer_shape", TextureKey.SIDE);
        TWO_METER_ARCH_HALF_LEFT = block("arch_twometer_half_left_shape", TextureKey.SIDE);
        TWO_METER_ARCH_HALF_RIGHT = block("arch_twometer_half_right_shape", TextureKey.SIDE);
        LAYER_HEIGHT2 = block("layer_height2", TextureKey.TEXTURE, TextureKey.PARTICLE);
        LAYER_HEIGHT4 = block("layer_height4", TextureKey.TEXTURE, TextureKey.PARTICLE);
        LAYER_HEIGHT6 = block("layer_height6", TextureKey.TEXTURE, TextureKey.PARTICLE);
        LAYER_HEIGHT8 = block("layer_height8", TextureKey.TEXTURE, TextureKey.PARTICLE);
        LAYER_HEIGHT10 = block("layer_height10", TextureKey.TEXTURE, TextureKey.PARTICLE);
        LAYER_HEIGHT12 = block("layer_height12", TextureKey.TEXTURE, TextureKey.PARTICLE);
        LAYER_HEIGHT14 = block("layer_height14", TextureKey.TEXTURE, TextureKey.PARTICLE);

        BALUSTRADE = block("parent_balustrade", TextureKey.PARTICLE, TextureKey.TOP, TextureKey.SIDE);
        BALUSTRADE_BASE = block("parent_balustrade_base", TextureKey.PARTICLE, TextureKey.TOP, TextureKey.SIDE);
        BALUSTRADE_BASE_OVERLAY_TOP = block("parent_balustrade_base_overlay_top", TextureKey.PARTICLE, TextureKey.TOP);
        BALUSTRADE_OVERLAY_TOP = block("parent_balustrade_overlay_top", TextureKey.PARTICLE, TextureKey.TOP);
        BALUSTRADE_OVERLAY_TOP_INVERTED = block("parent_balustrade_overlay_top_inverted", TextureKey.PARTICLE, TextureKey.TOP);
        SMALL_ARCH_HALF = block("small_arch_half", TextureKey.SIDE);

        SMOOTH_GOTHIC_ARCH_1 = block("smooth_gothic_arch_1", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_GOTHIC_ARCH_2 = block("smooth_gothic_arch_2", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_GOTHIC_ARCH_3 = block("smooth_gothic_arch_3", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_GOTHIC_ARCH_3_MIDDLE = block("smooth_gothic_arch_3_middle", TextureKey.PARTICLE, TextureKey.TEXTURE);

        SMOOTH_ROUND_ARCH_1 = block("smooth_round_arch_1", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_ROUND_ARCH_2 = block("smooth_round_arch_2", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_ROUND_ARCH_3 = block("smooth_round_arch_3", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_ROUND_ARCH_3_MIDDLE = block("smooth_round_arch_3_middle", TextureKey.PARTICLE, TextureKey.TEXTURE);

        SMOOTH_SEGMENTAL_ARCH_1 = block("smooth_segmental_arch_1", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_SEGMENTAL_ARCH_2 = block("smooth_segmental_arch_2", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_SEGMENTAL_ARCH_3 = block("smooth_segmental_arch_3", TextureKey.PARTICLE, TextureKey.TEXTURE);
        SMOOTH_SEGMENTAL_ARCH_3_MIDDLE = block("smooth_segmental_arch_3_middle", TextureKey.PARTICLE, TextureKey.TEXTURE);

        TEMPLATE_ARROWSLIT = block("template_arrowslit", TextureKey.TEXTURE, TextureKey.BOTTOM, TextureKey.TOP, TextureKey.PARTICLE);
        TEMPLATE_FALLEN_LEAVES = block("template_fallen_leaves", TextureKey.ALL);

        TEMPLATE_VERTICAL_CORNER_1 = block("template_vertical_corner_1", TextureKey.NORTH, TextureKey.EAST, TextureKey.SOUTH,
                TextureKey.WEST, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.PARTICLE);
        TEMPLATE_VERTICAL_CORNER_2 = block("template_vertical_corner_2", TextureKey.NORTH, TextureKey.EAST, TextureKey.SOUTH,
                TextureKey.WEST, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.PARTICLE);
        TEMPLATE_VERTICAL_CORNER_4 = block("template_vertical_corner_4", TextureKey.NORTH, TextureKey.EAST, TextureKey.SOUTH,
                TextureKey.WEST, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.PARTICLE);
        TEMPLATE_VERTICAL_CORNER_6 = block("template_vertical_corner_6", TextureKey.NORTH, TextureKey.EAST, TextureKey.SOUTH,
                TextureKey.WEST, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.PARTICLE);
        THIN_BLOCK = block("thin_block", TextureKey.TEXTURE, TextureKey.PARTICLE);
    }
}
