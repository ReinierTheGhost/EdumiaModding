package com.legends.edumia.block.content.contraptions.bearing;

import com.legends.edumia.block.fundation.block.IBE;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MechanicalBearingBlock extends BearingBlock implements IBE<MechanicalBearingBlockEntity> {
    public MechanicalBearingBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.canModifyBlocks())
            return ActionResult.FAIL;
        if (player.isSneaking())
            return ActionResult.FAIL;
        if (player.getStackInHand(hand).isEmpty()){
            if (world.isClient)
                return ActionResult.SUCCESS;
            withBlockEntityDo(world, pos, be -> {
                if (be.running){
                    be.disassemble();
                    return;
                }
                be.assembleNextTick = true;
            });
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public Class<MechanicalBearingBlockEntity> getBlockEntityClass() {
        return MechanicalBearingBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends MechanicalBearingBlockEntity> getBlockEntityType() {
        return null;
    }

}
