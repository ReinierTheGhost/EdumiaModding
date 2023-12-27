package com.legends.edumia.statusEffects;

import com.legends.edumia.utils.HallucinationData;
import com.legends.edumia.utils.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Map;

public class Hallucination extends StatusEffect {
    public Hallucination(){
        super(
                StatusEffectCategory.HARMFUL,
                0x006666
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity){
            Map<StatusEffect, StatusEffectInstance> map = entity.getActiveStatusEffects();
            int ticksLeft = map.get(this).getDuration();
            if(ticksLeft != -1 && ticksLeft < HallucinationData.STOPPING_TICK)
                HallucinationData.addHallucination((IEntityDataSaver) entity, -2);
            else{
                HallucinationData.addHallucination((IEntityDataSaver) entity, 2);
            }
        }
    }
    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        HallucinationData.resetHallucination((IEntityDataSaver) entity);
        HallucinationData.addHallucination((IEntityDataSaver) entity, -100);

        super.onRemoved(entity, attributes, amplifier);
    }

    public void stop(LivingEntity entity){
        HallucinationData.stopHallucination((IEntityDataSaver) entity);
    }


}
