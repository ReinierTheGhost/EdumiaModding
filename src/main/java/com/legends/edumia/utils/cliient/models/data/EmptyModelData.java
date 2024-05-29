package com.legends.edumia.utils.cliient.models.data;

import org.jetbrains.annotations.Nullable;

public enum EmptyModelData implements IModelData{
    INSTANCE;

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
