package com.prismmods.dwdimensions.common.entity.custom;

import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.function.Predicate;

public class HandmineEntity extends Monster implements Enemy {

    private static final Predicate<LivingEntity> NOT_HANDMINE = (livingEntity) -> !(livingEntity instanceof HandmineEntity) && livingEntity.attackable();
    public AnimationState emergeAnimationState = new AnimationState();

    private static final EntityDataAccessor<String> SIDE = SynchedEntityData.defineId(HandmineEntity.class,
            EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Float> EMERGING_MODIFIER = SynchedEntityData.defineId(HandmineEntity.class,
            EntityDataSerializers.FLOAT);

    public HandmineEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket((LivingEntity)this, this.hasPose(Pose.EMERGING) ? 1 : 0);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        if (packet.getData() == 1) {
            this.setPose(Pose.EMERGING);
        }
    }

    public boolean checkSpawnObstruction(LevelReader reader) {
        return super.checkSpawnObstruction(reader) && reader.noCollision(this, this.getType().getDimensions().makeBoundingBox(this.position()));
    }

    public boolean isEmerging() {return this.hasPose(Pose.EMERGING);}


    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> accessor) {
        if(DATA_POSE.equals(accessor)) {
            if(this.getPose() == Pose.EMERGING) {
                this.emergeAnimationState.start(this.tickCount);
            }
        }
        super.onSyncedDataUpdated(accessor);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {

        /*if(spawnType == MobSpawnType.TRIGGERED) {

        }*/
        this.setPose(Pose.EMERGING);

        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, spawnType, groupData, tag);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.1D, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, NOT_HANDMINE));

    }



    @Override
    public @NotNull AttributeMap getAttributes() {
        return new AttributeMap((createAttributes()));
    }

    public static AttributeSupplier createAttributes() {
        return createMonsterAttributes().
                add(Attributes.MAX_HEALTH, 8.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 10.0D).
                add(Attributes.MOVEMENT_SPEED, 0.0D).
                add(Attributes.ATTACK_DAMAGE, 14.0D).build();
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        Random rand = new Random();
        ItemStack stack = player.getItemInHand(hand);
        if(stack.getItem() instanceof ShovelItem) {

            //A 30% chance to just dig up the handmine. Otherwise 70% chance the shovel is instantly broken
            if(rand.nextInt(10) <= 3) {
                this.level.playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.ROOTED_DIRT_PLACE, this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
                if (!this.level.isClientSide) {
                    this.discard();
                    player.addItem(DWDItems.HANDMINE.get().getDefaultInstance()); //handmine item here

                    stack.hurtAndBreak(1, player, (p_32290_) -> {
                        p_32290_.broadcastBreakEvent(hand);
                    });
                }
            } else {

                 //player.hurt(DamageSource.mobAttack((LivingEntity) DWDEntityTypes.HANDMINE.get().create(player.getLevel())));
                //damage the player somehow?
                 stack.hurtAndBreak(stack.getMaxDamage(), player, (p_32290_) -> {
                     p_32290_.broadcastBreakEvent(hand);
                 });
            }
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_33034_) {
        return SoundEvents.SLIME_BLOCK_BREAK;
    }
    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        //NEEDS TESTING
        Boolean isInvulnerable = (source == DamageSource.IN_WALL || source == DamageSource.DROWN) ? true : false;
        return isInvulnerable;
    }

    /*
    DATA FOR LEFT OR RIGHT MODEL TO BE USED
    AND TO DEFINE VARIATION FOR EMERGING FROM THE GROUND
     */

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(SIDE, this.getRandomSide());
        getEntityData().define(EMERGING_MODIFIER, this.getRandomEmergingModifier());
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putString("side", this.getSide());
        compoundTag.putFloat("emerging_modifier", this.getRandomEmergingModifier());
        super.addAdditionalSaveData(compoundTag);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        if(compoundTag.contains("side")) {
            this.setSide(compoundTag.getString("side"));
        }
        if(compoundTag.contains("emerging_modifier")) {
            this.setEmergingModifier(compoundTag.getFloat("emerging_modifier"));
        }
        super.readAdditionalSaveData(compoundTag);
    }
    public void setSide(String sideIn) {
        this.entityData.set(SIDE, sideIn);
    }
    public String getSide() {
        return this.entityData.get(SIDE);
    }
    public String getRandomSide() {
        Random rand = new Random();
        Boolean isRight = rand.nextBoolean();
        if(isRight) return "right";
        else return "left";
    }
    public void setEmergingModifier(Float floatIn) {
        this.entityData.set(EMERGING_MODIFIER, floatIn);
    }
    public Float getEmergingModifier() {
        return this.entityData.get(EMERGING_MODIFIER);
    }
    public Float getRandomEmergingModifier() {
        Random rand = new Random();
        return (rand.nextFloat() * (1.8f)) - 0.9f;
    }



}
