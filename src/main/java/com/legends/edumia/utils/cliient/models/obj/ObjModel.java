package com.legends.edumia.utils.cliient.models.obj;

import com.legends.edumia.utils.cliient.models.geometry.IGeometryBakingContext;
import com.legends.edumia.utils.cliient.models.geometry.SimpleUnbakedGeometry;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.function.Function;

public class ObjModel extends SimpleUnbakedGeometry<ObjModel> {
    private ObjModel(ModelSettings settings) {

    }

    public static ObjModel parse(ObjTokenizer tokenizer, ModelSettings settings) throws IOException {
        var modelLocation = settings.modelLocation;
        var materialLibraryOverride = settings.mtlOverride;
        var model = new ObjModel(settings);

        return model;
    }

    @Override
    public BakedModel bake(IGeometryBakingContext context, Baker baker, Function<SpriteIdentifier, Sprite> spriteGetter, ModelBakeSettings modelState, ModelOverrideList overrides, Identifier modelLocation) {
        return null;
    }

    public record ModelSettings(@NotNull Identifier modelLocation, boolean automaticCulling, boolean shadeQuads, boolean flipV,
                                boolean emissiveAmbient, @Nullable String mtlOverride) {
    }
}

