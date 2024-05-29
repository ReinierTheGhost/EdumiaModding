package com.legends.edumia.utils.cliient.models.scatter;

import com.legends.edumia.utils.cliient.models.data.IModelData;
import com.legends.edumia.utils.cliient.models.data.ModelProperty;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class ScatterPositionContext implements IModelData {

    private final long positionHash;

    public ScatterPositionContext(long hash) {
        this.positionHash = hash;
    }

    public static ScatterPositionContext newEmptyContext() {
        return new ScatterPositionContext(0);
    }

    public static IModelData forPosition(BlockRenderView world, BlockPos pos, BlockState state) {
        long hash = MathHelper.hashCode(pos);
        return new ScatterPositionContext(hash);
    }

    public long getPositionHash(){
        return this.positionHash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }else if (obj != null && obj.getClass() == this.getClass()){
            ScatterPositionContext otherData = (ScatterPositionContext) obj;
            return this.positionHash == otherData.positionHash;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.positionHash);
    }

    @Override
    public String toString() {
        return String.format("ScatterPositionContext[%d]", this.positionHash);
    }

    @Override
    public boolean hasProperty(ModelProperty<?> prop) {
        return false;
    }

    @Override
    public <T> @Nullable T getData(ModelProperty<T> prop) {
        return null;
    }

    @Override
    public <T> @Nullable T setData(ModelProperty<T> prop, T data) {
        return null;
    }
}
