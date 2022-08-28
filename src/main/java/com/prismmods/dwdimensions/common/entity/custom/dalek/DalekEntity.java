package com.prismmods.dwdimensions.common.entity.custom.dalek;

import com.prismmods.dwdimensions.common.sound.DWDSounds;
import com.prismmods.dwdimensions.common.sound.DalekDrivingSoundInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.MinecartSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class DalekEntity extends Monster implements RangedAttackMob {

    private static final Predicate<LivingEntity> NOT_DALEK = (livingEntity) -> !(livingEntity instanceof DalekEntity) && livingEntity.attackable();
    private static final EntityDataAccessor<String> DALEK_TYPE = SynchedEntityData.defineId(DalekEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Float> SPECIAL_STATE = SynchedEntityData.defineId(DalekEntity.class, EntityDataSerializers.FLOAT);
    //The special state data is a float that can be used in future for further custom animations etc.
    //For now, if it has a value of 0.5f, the dalek is encumbered

    public static LivingEntity targetedEntity;
    public AnimationState encumberedAnimationState = new AnimationState();

    public DalekEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.targetedEntity = null;
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket((LivingEntity)this, this.getSpecialState()==0.5f ? 1 : 0);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        if (packet.getData() == 1) {
            this.setSpecialState(0.5f);
        }
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> accessor) {
        if(SPECIAL_STATE.equals(accessor)) {
            if(this.getSpecialState() == 0.5f) {
                this.encumberedAnimationState.start(this.tickCount);
            }
        }
        super.onSyncedDataUpdated(accessor);
    }

    //TODO: Make custom laser. Using arrow for now

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(this.targetedEntity != target) {
            this.targetedEntity = target;
            this.playSound(DWDSounds.DALEK_EXTERMINATE_VOCAL.get(), 0.5f, 1.0f);
        }

        AbstractArrow arrow = ProjectileUtil.getMobArrow(this, Items.ARROW.getDefaultInstance(), 1);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333D) - arrow.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        arrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level.getDifficulty().getId() * 4));
        this.level.addFreshEntity(arrow);
        this.playSound(DWDSounds.DALEK_SHOOT.get(), 0.5f, 1.0f);
    }

    public static AttributeSupplier createAttributes() {
        return createMonsterAttributes().
                add(Attributes.MAX_HEALTH, 40.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 5.0D).
                add(Attributes.MOVEMENT_SPEED, 0.18D).
                add(Attributes.ATTACK_DAMAGE, 6.0D).build();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1, 5));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, NOT_DALEK));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 20, 15.0F));
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    /**
    SOUNDS
     */

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return DWDSounds.DALEK_ATTACKED.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if(this.getSpecialState() != 0.5f) {
            return DWDSounds.DALEK_MECHANICAL.get();
        } else {
            return null;
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DWDSounds.DALEK_SCREAM.get();
    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState state) {
        super.playStepSound(blockPos, state);
        //FIXME: May have to handle this elsewhere

        //Minecraft.getInstance().getSoundManager().play(new DalekDrivingSoundInstance(this));
    }

    /**
     * DATA
     */
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(DALEK_TYPE, this.getRandomDalekType());
        getEntityData().define(SPECIAL_STATE, 0.0f);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putString("dalek_type", this.getDalekType());
        compoundTag.putFloat("special_state", this.getSpecialState());
        super.addAdditionalSaveData(compoundTag);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        if(compoundTag.contains("dalek_type")) {
            this.setDalekType(compoundTag.getString("dalek_type"));
        }
        if(compoundTag.contains("special_state")) {
            this.setSpecialState(compoundTag.getFloat("special_state"));
        }
        super.readAdditionalSaveData(compoundTag);
    }
    public void setDalekType(String type) {
        this.entityData.set(DALEK_TYPE, type);
    }
    public String getDalekType() {
        return this.entityData.get(DALEK_TYPE);
    }

    public void setSpecialState(Float state) {
        this.entityData.set(SPECIAL_STATE, state);
    }
    public Float getSpecialState() {
        return this.entityData.get(SPECIAL_STATE);
    }

    //TODO: Have this actually generate random types etc
    public String getRandomDalekType() {
        return "time_war";
    }




}
