package com.legends.edumia.utils.cliient.models.scatter;

import com.legends.edumia.utils.cliient.models.data.IModelData;

public class ScatterPositionContext implements IModelData {

    private final long positionHash;

    public ScatterPositionContext(long hash) {
        this.positionHash = hash;
    }

    public static ScatterPositionContext newEmptyContext() {
        return new ScatterPositionContext(0);
    }

    public long getPositionHash(){
        return this.positionHash;
    }
}
