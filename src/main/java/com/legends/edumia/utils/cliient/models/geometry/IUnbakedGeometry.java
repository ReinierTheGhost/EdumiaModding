package com.legends.edumia.utils.cliient.models.geometry;

import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

import java.util.Set;
import java.util.function.Function;

/**
 * General interface for any model that can be baked, superset of vanilla {@link UnbakedModel}.
 * <p>
 * Instances of this class ar usually created via {@link IGeometryLoader}.
 *
 * @see IGeometryLoader
 * @see IGeometryBakingContext
 */
public interface IUnbakedGeometry<T extends IUnbakedGeometry<T>>
{
    BakedModel bake(IGeometryBakingContext context, Baker baker, Function<SpriteIdentifier, Sprite> spriteGetter, ModelBakeSettings modelState,
                    ModelOverrideList overrides, Identifier modelLocation);

    /**
     * Resolve parents of nested {@link JsonUnbakedModel}s which are later used in
     * {@link IUnbakedGeometry#bake(IGeometryBakingContext, Baker, Function, ModelBakeSettings, ModelOverrideList, Identifier)}
     * via {@link JsonUnbakedModel#setParents(Function)}
     */
    default void resolveParents(Function<Identifier, UnbakedModel> modelGetter, IGeometryBakingContext context)
    {

    }

    /**
     * {@return a set of all the components whose visibility may be configured via {@link IGeometryBakingContext}}
     */
    default Set<String> getConfigurableComponentNames()
    {
        return Set.of();
    }
}
