package com.legends.edumia.block.fundation.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Consumer;

public interface IBE <T extends BlockEntity> extends BlockEntityProvider {

    Class<T> getBlockEntityClass();

    BlockEntityType<? extends T> getBlockEntityType();

    default void withBlockEntityDo(BlockView world, BlockPos pos, Consumer<T> action){
        getBlockEntityOptional(world, pos).ifPresent(action);
    }

    default Optional<T> getBlockEntityOptional(BlockView world, BlockPos pos){
        return Optional.ofNullable(getBlockEntity(world, pos));
    }

    @Nullable
    @Override
    default BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return getBlockEntityType().instantiate(pos, state);
    }

    @Nullable
    @Override
    default <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return BlockEntityProvider.super.getTicker(world, state, type);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    default T getBlockEntity(BlockView worldIn, BlockPos pos){
        BlockEntity blockEntity = worldIn.getBlockEntity(pos);
        Class<T> expectedClass = getBlockEntityClass();

        if (blockEntity == null)
            return null;
        if (!expectedClass.isInstance(blockEntity))
            return null;

        return (T) blockEntity;

    }
}
