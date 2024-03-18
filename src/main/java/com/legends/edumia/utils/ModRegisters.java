package com.legends.edumia.utils;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.ItemLoader;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;

public class ModRegisters {
    public static void registerModStuffs() {
        createPortal();
    }

    private static void createPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(BlockLoader.BLUE_BRICK)
                .lightWithItem(ItemLoader.CHEESE)
                .destDimID(new Identifier(Edumia.MOD_ID, "chaos"))
                .tintColor(0xc76efa)
                .registerPortal();
    }
}
