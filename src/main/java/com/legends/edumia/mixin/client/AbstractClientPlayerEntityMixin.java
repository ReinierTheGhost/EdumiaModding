package com.legends.edumia.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import com.legends.edumia.statusEffects.ModStatusEffects;
import com.legends.edumia.utils.HallucinationData;
import com.legends.edumia.utils.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin {

    @Shadow @Final public ClientWorld clientWorld;
    @Inject(method = "getFovMultiplier()F", at =@At("TAIL"), cancellable = true)
    private void injected(CallbackInfoReturnable<Float> cir) {
    PlayerEntity player = MinecraftClient.getInstance().player;
        assert player != null;
        if(player.hasStatusEffect(ModStatusEffects.HALLUCINATION)){
            float intensity = (float) HallucinationData.readHallucination((IEntityDataSaver) player) / 100f;
            cir.setReturnValue(cir.getReturnValue() * (1 - intensity/4));
        }
    }

}
