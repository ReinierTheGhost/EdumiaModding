package com.legends.edumia.utils.cliient;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormat;

/**
 * A set of functionally equivalent shaders. One using {@link VertexFormat//#BLOCK},
 * and the other two using {@link VertexFormat//#NEW_ENTITY}.
 * {@code entityFabulous} may support custom render targets and other aspects of the fabulous pipeline, or can otherwise
 * be the same as {@code entity}.
 */
public record RenderTypeGroup(RenderLayer block, RenderLayer entity, RenderLayer entityFabulous)
{
    public static RenderTypeGroup EMPTY = new RenderTypeGroup(null, null, null);
}
