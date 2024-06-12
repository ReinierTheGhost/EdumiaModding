package com.legends.edumia.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class NpcEntity  extends PathAwareEntity implements RangedAttackMob {
    protected NpcEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {

    }
}
