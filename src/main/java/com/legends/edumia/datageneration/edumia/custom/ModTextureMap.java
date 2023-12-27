package com.legends.edumia.datageneration.edumia.custom;

import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;

public class ModTextureMap extends TextureMap {

    public static TextureMap archOne(Identifier particle, Identifier keystone, Identifier underside1, Identifier underside2) {
        return (new TextureMap()).put(TextureKey.PARTICLE, particle).put(ModTextureKey.KEYSTONES.getParent(), keystone)
                .put(ModTextureKey.UNDERSIDE1.getParent(), underside1).put(ModTextureKey.UNDERSIDE2.getParent(), underside2);
    }

    public static TextureMap archTwo(Identifier particle, Identifier keystone, Identifier underside1, Identifier underside2, Identifier underside3) {
        return (new TextureMap()).put(TextureKey.PARTICLE, particle).put(ModTextureKey.KEYSTONES.getParent(), keystone)
                .put(ModTextureKey.UNDERSIDE1.getParent(), underside1).put(ModTextureKey.UNDERSIDE2.getParent(), underside2)
                .put(ModTextureKey.UNDERSIDE3.getParent(), underside3);
    }
        public static TextureMap archThree(Identifier particle, Identifier keystone, Identifier keystone2, Identifier keystone3, Identifier underside1, Identifier underside2, Identifier underside3) {
            return (new TextureMap()).put(TextureKey.PARTICLE, particle).put(ModTextureKey.KEYSTONES.getParent(), keystone)
                    .put(ModTextureKey.KEYSTONES2.getParent(), keystone2).put(ModTextureKey.KEYSTONES3.getParent(), keystone3)
                    .put(ModTextureKey.UNDERSIDE1.getParent(), underside1).put(ModTextureKey.UNDERSIDE2.getParent(), underside2)
                    .put(ModTextureKey.UNDERSIDE3.getParent(), underside3);
        }

}
