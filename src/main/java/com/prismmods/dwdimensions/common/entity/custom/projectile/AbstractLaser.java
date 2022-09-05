package com.prismmods.dwdimensions.common.entity.custom.projectile;

import com.prismmods.dwdimensions.common.entity.effect.DWDDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.annotation.Nullable;

public class AbstractLaser extends Projectile {

    private static final EntityDataAccessor<Integer> MAX_BOUNCES = SynchedEntityData.defineId(AbstractLaser.class, EntityDataSerializers.INT);

    private int life;
    private double baseDamage = 2.0D;
    private BlockState lastState;

    protected AbstractLaser(EntityType<? extends AbstractLaser> laser, Level level) {
        super(laser, level);
    }

    protected AbstractLaser(EntityType<? extends AbstractLaser> laser, double x, double y, double z, Level level) {
        this(laser, level);
        this.setPos(x, y, z);
    }

    protected AbstractLaser(EntityType<? extends AbstractLaser> laser, LivingEntity entity, Level level) {
        this(laser, entity.getX(), entity.getEyeY() - (double)0.1F, entity.getZ(), level);
        this.setOwner(entity);
    }

    public boolean shouldRenderAtSqrDistance(double p_36726_) {
        /*
        double d0 = this.getBoundingBox().getSize() * 10.0D;
        if (Double.isNaN(d0)) {
            d0 = 1.0D;
        }
        d0 *= 64.0D * getViewScale();
        return p_36726_ < d0 * d0;*/
        return true;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(MAX_BOUNCES, 0);
    }

    @Override
    public void shoot(double x, double y, double z, float p_37269_, float p_37270_) {
        super.shoot(x, y, z, p_37269_, p_37270_);
        this.life = 0;
    }

    @Override
    public void lerpTo(double x, double y, double z, float rotY, float rotX, int p_19901_, boolean p_19902_) {
        this.setPos(x, y, z);
        this.setRot(rotY, rotX);
    }

    @Override
    public void lerpMotion(double x, double y, double z) {
        super.lerpMotion(x, y, z);
        this.life = 0;
    }

    //TODO: May want to mess with the math for trajectories
    @Override
    public void tick() {
        super.tick();

        Vec3 vec3 = this.getDeltaMovement();

        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d0 = vec3.horizontalDistance();
            this.setYRot((float)(Mth.atan2(vec3.x, vec3.z) * (double)(180F / (float)Math.PI)));
            this.setXRot((float)(Mth.atan2(vec3.y, d0) * (double)(180F / (float)Math.PI)));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        BlockPos blockpos = this.blockPosition();
        BlockState blockstate = this.level.getBlockState(blockpos);
        if (!blockstate.isAir()) {
            VoxelShape voxelshape = blockstate.getCollisionShape(this.level, blockpos);
            if (!voxelshape.isEmpty()) {
                Vec3 vec31 = this.position();

                for(AABB aabb : voxelshape.toAabbs()) {
                    if (aabb.move(blockpos).contains(vec31)) {
                        //TODO: Laser has collided with something, so make it rebound
                        break;
                    }
                }
            }
        }

        if(!this.level.isClientSide) {
           tickDespawn();
        }

        Vec3 vec32 = this.position();
        Vec3 vec33 = vec32.add(vec3);
        HitResult hitresult = this.level.clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (hitresult.getType() != HitResult.Type.MISS) {
            vec33 = hitresult.getLocation();
        }

        while(!this.isRemoved()) {
            EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
            if (entityhitresult != null) {
                hitresult = entityhitresult;
            }

            if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
                Entity entity = ((EntityHitResult)hitresult).getEntity();
                Entity entity1 = this.getOwner();
                if (entity instanceof Player && entity1 instanceof Player && !((Player)entity1).canHarmPlayer((Player)entity)) {
                    hitresult = null;
                    entityhitresult = null;
                }
            }

            if (hitresult != null && hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
                this.onHit(hitresult);
                this.hasImpulse = true;
            }

            if (entityhitresult == null) {
                break;
            }

            hitresult = null;
        }

        vec3 = this.getDeltaMovement();
        double d5 = vec3.x;
        double d6 = vec3.y;
        double d1 = vec3.z;
        double d7 = this.getX() + d5;
        double d2 = this.getY() + d6;
        double d3 = this.getZ() + d1;
        double d4 = vec3.horizontalDistance();

        this.setYRot((float)(Mth.atan2(d5, d1) * (double)(180F / (float)Math.PI)));


        this.setXRot((float)(Mth.atan2(d6, d4) * (double)(180F / (float)Math.PI)));
        this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
        this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
        float f = 0.99F;
        float f1 = 0.05F;
        if (this.isInWater()) {
            for(int j = 0; j < 4; ++j) {
                float f2 = 0.25F;
                this.level.addParticle(ParticleTypes.BUBBLE, d7 - d5 * 0.25D, d2 - d6 * 0.25D, d3 - d1 * 0.25D, d5, d6, d1);
            }

            f = this.getWaterInertia();
        }

        this.setDeltaMovement(vec3.scale((double)f));
        if (!this.isNoGravity()) {
            Vec3 vec34 = this.getDeltaMovement();
            this.setDeltaMovement(vec34.x, vec34.y - (double)0.05F, vec34.z);
        }

        this.setPos(d7, d2, d3);
        this.checkInsideBlocks();
    }

    protected float getWaterInertia() {
        return 0.96F;
    }

    protected void tickDespawn() {
        ++this.life;
        if(this.life >= 1200) {
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity entity = hitResult.getEntity();
        float f = (float)this.getDeltaMovement().length();
        int i = Mth.ceil(Mth.clamp((double)f * this.baseDamage, 0.0D, 2.147483647E9D));

        Entity sourceEntity = this.getOwner();
        DamageSource damageSource;
        if(sourceEntity == null) {
            damageSource = DWDDamageSources.laser(this, this);
        } else {
            damageSource = DWDDamageSources.laser(this, sourceEntity);
            if(sourceEntity instanceof LivingEntity) {
                ((LivingEntity)sourceEntity).setLastHurtMob(entity);
            }
        }

        if(entity.hurt(damageSource, (float)i)) {
            //Knockback, enchantment handling etc
            if(entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;

                if(sourceEntity != null && livingEntity != sourceEntity && livingEntity instanceof Player && sourceEntity instanceof ServerPlayer && !this.isSilent()) {
                    ((ServerPlayer)sourceEntity).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0f));
                }
            }

            //TODO: CUSTOM SOUND
            //this.playSound(this.soundEvent, 1.0f, 1.2f/(this.random.nextFloat()*0.2f + 0.9f));
        } else {
            this.setDeltaMovement(this.getDeltaMovement().scale(-0.1D));
            this.setYRot(this.getYRot()+180.0F);
            this.yRotO += 180.0F;
            if(!this.level.isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7D) {
                this.discard();
            }
        }
    }

    //TODO: Make laser rebound
    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        this.lastState = this.level.getBlockState(hitResult.getBlockPos());
        super.onHitBlock(hitResult);
        Vec3 vec3 = hitResult.getLocation().add(90.0d, 90.0d, 90.0d);
        this.setDeltaMovement(vec3);
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 vec3_1, Vec3 vec3_2) {
        return ProjectileUtil.getEntityHitResult(this.level, this, vec3_1, vec3_2,
                this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), this::canHitEntity);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putShort("life", (short)this.life);
        tag.putDouble("damage", this.baseDamage);
        //TODO:
        //tag.putString("SoundEvent", Registry.SOUND_EVENT.getKey(this.soundEvent).toString());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.life = tag.getShort("life");
        if(tag.contains("damage", 99)) {
            this.baseDamage = tag.getDouble("damage");
        }
        //TODO:
        /*
        if (tag.contains("SoundEvent", 8)) {
            this.soundEvent = Registry.SOUND_EVENT.getOptional(new ResourceLocation(tag.getString("SoundEvent"))).orElse(this.getDefaultHitGroundSoundEvent());
        }*/
    }

    @Override
    protected MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }
    public double getBaseDamage() {
        return this.baseDamage;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    //TODO: what is this float???
    @Override
    protected float getEyeHeight(Pose pose, EntityDimensions dimensions) {
        return 0.13F;
    }

    @NonNull
    @Override
    public Packet<?> getAddEntityPacket() {
        //return super.getAddEntityPacket();
        //return NetworkHooks.getEntitySpawningPacket(this);
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
    }
}
