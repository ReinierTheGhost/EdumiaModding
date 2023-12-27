package com.legends.edumia.datageneration.edumia.custom;

import com.google.common.collect.ImmutableSet;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.Set;

public class ModModel {

    private final Optional<Identifier> parent;
    private final Set<ModTextureKey> requiredTextures;
    private final Optional<String> variant;
    public ModModel(Optional<Identifier> parent, Optional<String> variant, ModTextureKey... requiredTextureKeys) {
        this.parent = parent;
        this.variant = variant;
        this.requiredTextures = ImmutableSet.copyOf(requiredTextureKeys);
    }
}
