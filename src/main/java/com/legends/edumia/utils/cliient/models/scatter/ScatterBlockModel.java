package com.legends.edumia.utils.cliient.models.scatter;

import com.google.common.math.LongMath;
import com.jozufozu.flywheel.core.materials.model.ModelData;
import com.legends.edumia.utils.cliient.models.BlockModelQuadsHolder;
import com.legends.edumia.utils.cliient.models.data.EmptyModelData;
import com.legends.edumia.utils.cliient.models.data.IModelData;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

public class ScatterBlockModel extends BasicBakedModel {
    private final List<BlockModelQuadsHolder> scatterVariantModels;
    public ScatterBlockModel(List<BlockModelQuadsHolder> scatterVariantModels, boolean usesAo, boolean isSideLit, boolean hasDepth, Sprite sprite, ModelTransformation transformation, ModelOverrideList itemPropertyOverrides) {
        super(new ArrayList<>(), new HashMap<>(), usesAo, isSideLit, hasDepth, sprite, transformation, itemPropertyOverrides);
        this.scatterVariantModels = scatterVariantModels;
        if (scatterVariantModels.isEmpty()){
            throw new IllegalArgumentException("Model variant list cannot be empty!");
        }
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return this.getQuads(state, face, random, ScatterPositionContext.newEmptyContext());
    }

    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random, IModelData extraData) {
        if (extraData instanceof ScatterPositionContext){
            ScatterPositionContext posContext = (ScatterPositionContext) extraData;
            long hash = posContext.getPositionHash();
            int index = LongMath.mod(hash, this.scatterVariantModels.size());
            return (this.scatterVariantModels.get(index)).getQuads(face);
        } else if (extraData instanceof EmptyModelData) {
            return this.getQuads(state, face, random);
        } else{
            throw new IllegalArgumentException("ScatterBlockModel can only take ScatterPositionContext model data or EmptyModelData, but " + extraData.getClass().getName() + " was supplied");
        }
    }

    public IModelData getModelData(BlockRenderView world, BlockPos pos, BlockState state, IModelData tileData){
        return ScatterPositionContext.forPosition(world, pos, state);
    }


}
