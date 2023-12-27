package com.legends.edumia.utils.cliient;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

/**
 * Manager for named {@link RenderLayer render types}.
 * <p>
 * Provides a lookup.
 */
public final class NamedRenderTypeManager
{
    private static ImmutableMap<Identifier, RenderTypeGroup> RENDER_TYPES;


    /**
     * Finds the {@link RenderTypeGroup} for a given name, or the {@link RenderTypeGroup#EMPTY empty group} if not found.
     */
    public static RenderTypeGroup get(Identifier name)
    {
        return RENDER_TYPES.getOrDefault(name, RenderTypeGroup.EMPTY);
    }
}
