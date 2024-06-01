package com.legends.edumia.utils.cliient.models.scatter;

import com.google.common.math.LongMath;
import com.jozufozu.flywheel.core.materials.model.ModelData;
import com.legends.edumia.utils.cliient.models.BlockModelQuadsHolder;
import com.legends.edumia.utils.cliient.models.data.EmptyModelData;
import com.legends.edumia.utils.cliient.models.data.IModelData;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BasicBakedModel;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScatterBlockModel implements BakedModel, FabricBakedModel {
    private final List<BlockModelQuadsHolder> scatterVariantModels;
    private final boolean ambientOcclusion;
    private final boolean sideLit;
    private final boolean gui3d;
    private final Sprite particleSprite;
    private final ModelTransformation transformation;
    private final ModelOverrideList overrides;

    public ScatterBlockModel(List<BlockModelQuadsHolder> scatterVariantModels, boolean ambientOcclusion, boolean sideLit,
                             boolean gui3d, Sprite particleSprite, ModelTransformation transformation, ModelOverrideList overrides) {
        this.scatterVariantModels = scatterVariantModels;
        this.ambientOcclusion = ambientOcclusion;
        this.sideLit = sideLit;
        this.gui3d = gui3d;
        this.particleSprite = particleSprite;
        this.transformation = transformation;
        this.overrides = overrides;
        if (scatterVariantModels.isEmpty()){
            throw new IllegalArgumentException("Model variant list cannot be empty!");
        }
    }


    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return this.getQuads(state, face, random, ScatterPositionContext.newEmptyContext());
    }

    public List<BakedQuad> getQuads(BlockState state, Direction face, Random random, IModelData extraData) {
        if (extraData instanceof ScatterPositionContext){
            ScatterPositionContext posContext = (ScatterPositionContext) extraData;
            long hash = posContext.getPositionHash();
            int index = LongMath.mod(hash, this.scatterVariantModels.size());
            return this.scatterVariantModels.get(index).getQuads(face);
        } else {
            return this.getQuads(state, face, random);
        }
    }
    @Override
    public boolean useAmbientOcclusion() {
        return this.ambientOcclusion;
    }

    @Override
    public boolean hasDepth() {
        return this.gui3d;
    }

    @Override
    public boolean isSideLit() {
        return this.sideLit;
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public Sprite getParticleSprite() {
        return this.particleSprite;
    }

    @Override
    public ModelTransformation getTransformation() {
        return this.transformation;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return this.overrides;
    }




}
