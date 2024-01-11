package com.legends.edumia.utils.cliient.models;

import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Map;

public class BlockModelQuadsHolder {

    public final List<BakedQuad> generalQuads;
    public final Map<Direction, List<BakedQuad>> faceQuads;

    public BlockModelQuadsHolder(List<BakedQuad> generalQuads, Map<Direction, List<BakedQuad>> faceQuads) {
        this.generalQuads = generalQuads;
        this.faceQuads = faceQuads;
    }

    public List<BakedQuad> getQuads(Direction side){
        return side == null ? this.generalQuads : this.faceQuads.get(side);
    }
}
