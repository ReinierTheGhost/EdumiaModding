package com.legends.edumia.utils.cliient.models.scatter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.client.render.model.json.ModelElement;
import net.minecraft.client.render.model.json.ModelElementFace;
import net.minecraft.client.render.model.json.ModelElementTexture;
import net.minecraft.client.render.model.json.ModelRotation;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScatterModelGenerator {

    private final Random rand = new Random();
    private final int minElements;
    private final int maxElements;
    private final int minXSize;
    private final int maxXSize;
    private final int minYSize;
    private final int maxYSize;
    private final int minZSize;
    private final int maxZSize;


    public ScatterModelGenerator(int minElements, int maxElements, int minXSize, int maxXSize, int minYSize, int maxYSize, int minZSize, int maxZSize) {
        this.minElements = minElements;
        this.maxElements = maxElements;
        this.minXSize = minXSize;
        this.maxXSize = maxXSize;
        this.minYSize = minYSize;
        this.maxYSize = maxYSize;
        this.minZSize = minZSize;
        this.maxZSize = maxZSize;
        if (minElements >= 0 && minElements <= maxElements) {
            if (minXSize >= 0 && maxXSize <= 16 && minXSize <= maxXSize){
                if (minYSize >= 0 && maxYSize <= 16 && minYSize <= maxYSize){
                    if (minZSize < 0 || maxZSize > 16 || minZSize > maxZSize){
                        throw new IllegalArgumentException("Invalid z-size range");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid y-size range");
                }
            }else {
                throw new IllegalArgumentException("Invalid x-size range");
            }
        }else {
            throw new IllegalArgumentException("Invalid num-elements range");
        }
    }

    public static ScatterModelGenerator parse(JsonObject json){
        int[] elementsRange = parseIntRange(json, "num_elements_range");
        int[] xSizeRange = parseIntRange(json, "x_size_range");
        int[] ySizeRange = parseIntRangeOrDefault(json, "y_size_range", 0, 0);
        int[] zSizeRange = parseIntRange(json, "z_size_range");
        return new ScatterModelGenerator(elementsRange[0], elementsRange[1], xSizeRange[0], xSizeRange[1], ySizeRange[0], ySizeRange[1],
                zSizeRange[0], zSizeRange[1]);
    }

    private static int[] parseIntRange(JsonObject json, String key) {
        JsonArray array = json.get(key).getAsJsonArray();
        if (array.size() != 2){
            throw new IllegalArgumentException("Range " + key + " should be an array of 2 values");
        } else {
            int min = array.get(0).getAsInt();
            int max = array.get(1).getAsInt();
            return new int[]{min, max};
        }
    }

    private static int[] parseIntRangeOrDefault(JsonObject json, String key, int defaultMin, int defaultMax) {
        return json.has(key) ? parseIntRange(json, key) : new int[]{defaultMin, defaultMax};
    }

    public List<List<ModelElement>> generateNRandomModels(int n, String texture) {
        this.rand.setSeed(5251224673490637827L);
        this.rand.setSeed(this.rand.nextLong() ^ ((long) texture.hashCode() * (1156258289 + n)));
        boolean hasHeight = this.minYSize > 0 || this.maxYSize > 0;
        return IntStream.range(0, n).mapToObj((i) -> {
            int elements = MathHelper.nextInt((net.minecraft.util.math.random.Random) this.rand, this.minElements, this.maxElements);
            return IntStream.range(0, elements).mapToObj((e) -> {
                float elementFrac = (float) e / elements;
                float posX = MathHelper.nextFloat((net.minecraft.util.math.random.Random) this.rand, 0.0F, 16.0F);
                float posZ = MathHelper.nextFloat((net.minecraft.util.math.random.Random) this.rand, 0.0F, 16.0F);
                float posY = hasHeight ? 0.0F + elementFrac * 0.1F : 0.16F + elementFrac * 1.6F;
                int xSize = MathHelper.nextInt((net.minecraft.util.math.random.Random) this.rand, this.minXSize, this.maxXSize);
                int ySize = hasHeight ?  MathHelper.nextInt((net.minecraft.util.math.random.Random) this.rand, this.minYSize, this.maxYSize) : 0;
                int zSize = MathHelper.nextInt((net.minecraft.util.math.random.Random) this.rand, this.minZSize, this.maxZSize);
                Map<Direction, ModelElementFace> mapFace = this.generatePartFaceMap(texture, xSize, ySize, zSize);
                float halfXSize = xSize / 2.0F;
                float halfZSize = zSize / 2.0F;
                Vector3f posFrom = new Vector3f(posX - halfXSize, posY, posZ - halfZSize);
                Vector3f posTo = new Vector3f(posX + halfXSize, posY + ySize, posZ + halfZSize);
                float rotAngle = this.rand.nextFloat() * 360.0F;
                Vector3f rotOrigin = new Vector3f(0.5F, 0.5F, 0.5F);
                boolean rescale = false;
                ModelRotation rotation = new ModelRotation(rotOrigin, Direction.Axis.Y, rotAngle, rescale);
                boolean shade = ySize > 0;
                return new ModelElement(posFrom, posTo, mapFace, rotation, shade);
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }

    private Map<Direction, ModelElementFace> generatePartFaceMap(String texture, int xSize, int ySize, int zSize) {
        Direction cullFace = null;
        int tintIndex = 0;
        Stream<Direction> faceDirs = ySize == 0 ? Stream.of(Direction.UP) : Stream.of(Direction.values());
        return faceDirs.collect(Collectors.toMap(UnaryOperator.identity(), (faceDir) ->
                this.generateDirectionalPartFace(faceDir, xSize, ySize, zSize, cullFace, tintIndex, texture)));
    }

    private ModelElementFace generateDirectionalPartFace(Direction faceDir, int xSize, int ySize, int zSize, Direction cullFace, int tintIndex, String texture) {
        ModelElementTexture faceUV = this.generateDirectionalFaceUV(faceDir, xSize, ySize, zSize);
        return new ModelElementFace(cullFace, tintIndex, texture, faceUV);
    }

    private ModelElementTexture generateDirectionalFaceUV(Direction faceDir, int xSize, int ySize, int zSize) {
        Direction.Axis axis = faceDir.getAxis();
        if (axis == Direction.Axis.Y) {
            return this.generateFaceUV(xSize, zSize);
        } else {
            return axis == Direction.Axis.X ? this.generateFaceUV(zSize, ySize) : this.generateFaceUV(xSize, ySize);
        }
    }

    private ModelElementTexture generateFaceUV(int uDirectionalSize, int vDirectionalSize) {
        int minU = MathHelper.nextInt((net.minecraft.util.math.random.Random) this.rand, 0, 16 - uDirectionalSize);
        int minV = MathHelper.nextInt((net.minecraft.util.math.random.Random) this.rand, 0, 16 - vDirectionalSize);
        int maxU = minU + uDirectionalSize;
        int maxV = minV + vDirectionalSize;
        return new ModelElementTexture(new float[]{maxU, minV, maxU, maxV}, 0);
    }
}
