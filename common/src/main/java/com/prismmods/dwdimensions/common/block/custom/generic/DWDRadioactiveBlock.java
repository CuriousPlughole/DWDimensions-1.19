package com.prismmods.dwdimensions.common.block.custom.generic;

import com.prismmods.dwdimensions.api.RadiationHandler;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapability;
import com.prismmods.dwdimensions.common.capability.radiation.RadiationCapabilityProvider;
import com.prismmods.dwdimensions.common.particle.DWDParticles;
import com.prismmods.dwdimensions.network.Network;
import com.prismmods.dwdimensions.network.messages.RadiationDataMessage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class DWDRadioactiveBlock extends Block {

    //Background count on skaro is 0.001
    private float radiationRate;

    public DWDRadioactiveBlock(Properties properties, float radiationStrength) {
        super(properties);
        this.radiationRate = radiationStrength;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {

            RadiationHandler.applyRadiation(player, radiationRate);

            return InteractionResult.CONSUME;
        }
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState state, Entity entity) {

        if(!level.isClientSide) {
            if (entity instanceof LivingEntity) {
                RadiationHandler.applyRadiation((LivingEntity)entity, radiationRate*0.2f);
            }
        }

        super.stepOn(level, blockPos, state, entity);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        //Could add strength of radioactive block paramater, where stronger = more frequent particles
        if(rand.nextInt(4) == 1) {
            for (int i = 0; i < 4; ++i) {
                double d0 = (double) pos.getX() + rand.nextDouble();
                double d1 = (double) pos.getY() + rand.nextDouble();
                double d2 = (double) pos.getZ() + rand.nextDouble();
                double d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
                double d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
                double d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
                level.addParticle(DWDParticles.RADIOACTIVE_PARTICLES.get(), d0, d1, d2, d3, d4, d5);
            }
        }
    }
}
