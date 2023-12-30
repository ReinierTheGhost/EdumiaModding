package com.legends.edumia.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class EdumiaLeavesBlock extends LeavesBlock {

    private Supplier<? extends ParticleEffect> fallingParticle;
    private int fallingChange;
    public EdumiaLeavesBlock() {
        super(Settings.copy(Blocks.OAK_LEAVES).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque());
    }

    public EdumiaLeavesBlock setFallingParticle(Supplier<? extends ParticleEffect> particle, int change){
        this.fallingParticle = particle;
        this.fallingChange = change;
        return this;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (this.fallingParticle != null && random.nextInt(this.fallingChange) == 0){
            ParticleEffect particle = this.fallingParticle.get();
            double x = (pos.getX() + random.nextFloat());
            double y = (pos.getY() - 0.05);
            double z = (pos.getZ() + random.nextFloat());
            double xSpeed = MathHelper.nextFloat(random, -0.1F, 0.1F);
            double ySpeed = MathHelper.nextFloat(random, -0.03F, -0.01F);
            double zSpeed = MathHelper.nextFloat(random, -0.1F, 0.1F);
            world.addParticle(particle, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
