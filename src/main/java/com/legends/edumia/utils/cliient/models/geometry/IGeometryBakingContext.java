package com.legends.edumia.utils.cliient.models.geometry;

import com.legends.edumia.utils.cliient.NamedRenderTypeManager;
import com.legends.edumia.utils.cliient.RenderTypeGroup;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AffineTransformation;
import org.jetbrains.annotations.Nullable;

/**
 * The context in which a geometry is being baked, providing information such as lighting and
 * {@linkplain ModelTransformation transforms}, and allowing the user to create {@linkplain SpriteIdentifier materials} and query
 * {@linkplain RenderTypeGroup render types}.
 *
 * @see StandaloneGeometryBakingContext
 * @see BlockGeometryBakingContext
 */
public interface IGeometryBakingContext
{
    /**
     * {@return the name of the model being baked for logging and caching purposes.}
     */
    String getModelName();

    /**
     * Checks if a material is present in the model.
     *
     * @param name The name of the material
     * @return true if the material is present, false otherwise
     */
    boolean hasMaterial(String name);

    /**
     * Resolves the final texture name, taking into account texture aliases and replacements.
     *
     * @param name The name of the material
     * @return The material, or the missing texture if not found
     */
    SpriteIdentifier getMaterial(String name);

    /**
     * {@return true if this model should render in 3D in a GUI, false otherwise}
     */
    boolean isGui3d();

    /**
     * {@return true if block lighting should be used for this model, false otherwise}
     */
    boolean useBlockLight();

    /**
     * {@return true if per-vertex ambient occlusion should be used for this model, false otherwise}
     */
    boolean useAmbientOcclusion();

    /**
     * {@return the transforms for display in item form.}
     */
    ModelTransformation getTransforms();

    /**
     * {@return the root transformation to be applied to all variants of this model, regardless of item transforms.}
     */
    AffineTransformation getRootTransform();

    /**
     * {@return a hint of the render type this model should use. Custom loaders may ignore this.}
     */
    @Nullable
    Identifier getRenderTypeHint();

    /**
     * Queries the visibility of a component of this model.
     *
     * @param component The component for which to query visibility
     * @param fallback  The default visibility if an override isn't found
     * @return The visibility of the component
     */
    boolean isComponentVisible(String component, boolean fallback);

    /**
     * {@return a {@link RenderTypeGroup} with the given name, or the empty group if not found.}
     */
    default RenderTypeGroup getRenderType(Identifier name)
    {
        return NamedRenderTypeManager.get(name);
    }
}
