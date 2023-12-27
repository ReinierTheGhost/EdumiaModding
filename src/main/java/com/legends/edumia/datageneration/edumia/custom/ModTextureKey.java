package com.legends.edumia.datageneration.edumia.custom;

import net.minecraft.data.client.TextureKey;
import org.jetbrains.annotations.Nullable;

public final class ModTextureKey {
    public static final ModTextureKey KEYSTONES;
    public static final ModTextureKey KEYSTONES2;
    public static final ModTextureKey KEYSTONES3;

    public static final ModTextureKey UNDERSIDE1;
    public static final ModTextureKey UNDERSIDE2;
    public static final ModTextureKey UNDERSIDE3;



    private final String name;
    @Nullable
    private final TextureKey parent;

    public static ModTextureKey of(String name) {
        return new ModTextureKey(name, null);
    }

    public static ModTextureKey of(String name, TextureKey parent) {
        return new ModTextureKey(name, parent.getParent());
    }

    private ModTextureKey(String name, @Nullable TextureKey parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public TextureKey getParent() {
        return this.parent;
    }

    public String toString() {
        return "#" + this.name;
    }

    static {
        KEYSTONES = of("keystones", TextureKey.ALL);
        KEYSTONES2 = of("keystones2", TextureKey.ALL);
        KEYSTONES3 = of("keystones3", TextureKey.ALL);
        UNDERSIDE1 = of("underside1", TextureKey.ALL);
        UNDERSIDE2 = of("underside2", TextureKey.ALL);
        UNDERSIDE3 = of("underside3", TextureKey.ALL);
    }
}
