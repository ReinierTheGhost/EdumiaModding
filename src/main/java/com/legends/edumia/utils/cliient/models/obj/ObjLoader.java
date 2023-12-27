package com.legends.edumia.utils.cliient.models.obj;

import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.legends.edumia.utils.cliient.models.geometry.IGeometryLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;

import java.io.IOException;
import java.util.Map;

public class ObjLoader implements IGeometryLoader<ObjModel>, SynchronousResourceReloader {

    public static ObjLoader INSTANCE = new ObjLoader();

    private final Map<ObjModel.ModelSettings, ObjModel> modelCache = Maps.newConcurrentMap();
    private final Map<Identifier, ObjMaterialLibrary> materialCache = Maps.newConcurrentMap();

    private ResourceManager manager = MinecraftClient.getInstance().getResourceManager();

    @Override
    public void reload(ResourceManager resourceManager) {
        modelCache.clear();
        materialCache.clear();
        manager = resourceManager;
    }
    @Override
    public ObjModel read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) {
        if (!jsonObject.has("model"))
            throw new JsonParseException("OBJ Loader requires a 'model' key that points to a valid .OBJ model.");

        String modelLocation = jsonObject.get("model").getAsString();

        boolean automaticCulling = JsonHelper.getBoolean(jsonObject, "automatic_culling", true);
        boolean shadeQuads = JsonHelper.getBoolean(jsonObject, "shade_quads", true);
        boolean flipV = JsonHelper.getBoolean(jsonObject, "flip_v", true);
        boolean emissiveAmbient = JsonHelper.getBoolean(jsonObject, "emissive_ambient", true);
        String mltOverride = JsonHelper.getString(jsonObject, "mtl_override", null);

        return loadModel(new ObjModel.ModelSettings(new Identifier(modelLocation), automaticCulling, shadeQuads, flipV, emissiveAmbient, mltOverride));
    }

    public ObjModel loadModel(ObjModel.ModelSettings settings) {
        return modelCache.computeIfAbsent(settings, (data) -> {
            Resource resource = manager.getResource(settings.modelLocation()).orElseThrow();
            try (ObjTokenizer tokenizer = new ObjTokenizer(resource.getInputStream())){
                return ObjModel.parse(tokenizer, settings);
            } catch (IOException e) {
                throw new RuntimeException("Could not find OBJ model", e);
            } catch (Exception e) {
                throw new RuntimeException("Could not read OBJ model", e);
            }
        });
    }


}
