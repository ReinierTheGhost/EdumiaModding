package com.legends.edumia.datageneration.me.content;

import com.legends.edumia.Edumia;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CustomItemModels {
    public static final Model BIG_WEAPON = new Model(Optional.of(
            new Identifier(Edumia.MOD_ID, "item/big_weapon")), Optional.empty(), TextureKey.LAYER0);

    public static final Model TEMPLATE_SPAWN_EGG = new Model(Optional.of(
            new Identifier("minecraft", "item/template_spawn_egg")), Optional.empty());
}
