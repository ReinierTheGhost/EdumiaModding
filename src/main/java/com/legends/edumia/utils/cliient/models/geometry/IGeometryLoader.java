package com.legends.edumia.utils.cliient.models.geometry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.resource.SynchronousResourceReloader;

/**
 * A loader for custom {@linkplain IUnbakedGeometry model geometries}.
 * <p>
 * If you do any caching, you should implement {@link SynchronousResourceReloader} and register it with
 * {@link RegisterClientReloadListenersEvent}.
 *
 * @see RegisterGeometryLoaders
 * @see RegisterClientReloadListenersEvent
 */
public interface IGeometryLoader<T extends IUnbakedGeometry<T>>
{
    T read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) throws JsonParseException;
}
