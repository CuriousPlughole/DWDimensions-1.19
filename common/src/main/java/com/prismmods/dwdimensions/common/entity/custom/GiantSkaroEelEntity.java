package com.prismmods.dwdimensions.common.entity.custom;

import com.prismmods.dwdimensions.common.item.DWDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class GiantSkaroEelEntity extends WaterAnimal implements Saddleable, ContainerListener {

    protected SimpleContainer inventory;
    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;
    public static final int INV_SLOT_SADDLE = 0;
    public static final int INV_SLOT_ARMOR = 1;
    public static final int INV_BASE_COUNT = 2;
    private static final int FLAG_SADDLE = 4;
    private static final Ingredient FOOD_ITEMS = Ingredient.of(DWDItems.HANDMINE.get());

    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(GiantSkaroEelEntity.class, EntityDataSerializers.BYTE);

    public GiantSkaroEelEntity(EntityType<? extends WaterAnimal> p_30341_, Level p_30342_) {
        super(p_30341_, p_30342_);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.createInventory();
    }

    //TODO: LOOK AT DOLPHIN GOALS
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0D, 10));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(5, new FloatGoal(this));
    }

    @Override
    public int getMaxAirSupply() {
        return 4800;
    }

    @Override
    protected int increaseAirSupply(int p_21307_) {
        return this.getMaxAirSupply();
    }

    @Override
    public @NotNull AttributeMap getAttributes() {
        return new AttributeMap((createAttributes()));
    }

    public static AttributeSupplier createAttributes() {
        return createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 8.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2.0d)
                .add(Attributes.ATTACK_DAMAGE, 7.0D)
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .build();

    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_FLAGS, (byte)0);
    }

    protected boolean getFlag(int flag) {
        return (this.entityData.get(DATA_ID_FLAGS) & flag) != 0;
    }

    protected void setFlag(int flag, boolean p_30599_) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (p_30599_) {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 | flag));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 & ~flag));
        }

    }

    public boolean isPushable() {
        return !this.isVehicle();
    }


    @Override
    public boolean isSaddleable() {
        return true;
    }

    @Override
    public void equipSaddle(@Nullable SoundSource sound) {
        this.inventory.setItem(0, new ItemStack(Items.SADDLE));
        if (sound != null) {
            this.level.playSound((Player)null, this, SoundEvents.STRIDER_SADDLE, sound, 0.5F, 1.0F);
        }
    }

    protected int getInventorySize() {
        return 2;
    }

    protected void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

            for(int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }

        this.inventory.addListener(this);
        this.updateContainerEquipment();
        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
    }

    protected void updateContainerEquipment() {
        if (!this.level.isClientSide) {
            this.setFlag(4, !this.inventory.getItem(0).isEmpty());
        }
    }

    public void containerChanged(Container p_30548_) {
        boolean flag = this.isSaddled();
        this.updateContainerEquipment();
        if (this.tickCount > 20 && !flag && this.isSaddled()) {
            this.playSound(SoundEvents.HORSE_SADDLE, 0.5F, 1.0F);
        }

    }

    @Override
    public boolean isSaddled() {
        return this.isAlive() && !this.isBaby();
    }

    public void openCustomInventoryScreen(Player player) {
        if (!this.level.isClientSide && (!this.isVehicle() || this.hasPassenger(player))) {
            //player.openHorseInventory(this, this.inventory);
            //TODO: open inventory hook
        }

    }

    protected void doPlayerRide(Player player) {
        if (!this.level.isClientSide) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
            player.startRiding(this);
        }
    }

    @Override
    protected boolean isImmobile() {
        return super.isImmobile() && this.isVehicle() && this.isSaddled(); //|| this.isEating() || this.isStanding();
    }

    @Override
    public void travel(Vec3 vec3) {
        if (this.isAlive()) {
            //TODO: check LivingEntity cast
            LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
            if (this.isVehicle() && livingentity != null) {
                this.setYRot(livingentity.getYRot());
                this.yRotO = this.getYRot();
                this.setXRot(livingentity.getXRot() * 0.5F);
                this.setRot(this.getYRot(), this.getXRot());
                this.yBodyRot = this.getYRot();
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                    //this.gallopSoundCounter = 0;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vec3((double)f, vec3.y, (double)f1));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(Vec3.ZERO);
                }

                this.calculateEntityAnimation(this, false);
                this.tryCheckInsideBlocks();
            } else {
                this.flyingSpeed = 0.02F;
                super.travel(vec3);
            }
        }
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        if (!this.inventory.getItem(0).isEmpty()) {
            tag.put("SaddleItem", this.inventory.getItem(0).save(new CompoundTag()));
        }

    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (tag.contains("SaddleItem", 10)) {
            ItemStack itemstack = ItemStack.of(tag.getCompound("SaddleItem"));
            if (itemstack.is(Items.SADDLE)) {
                this.inventory.setItem(0, itemstack);
            }
        }

        this.updateContainerEquipment();
    }


    public boolean canWearArmor() {
        return false;
    }

    public boolean isWearingArmor() {
        return !this.getItemBySlot(EquipmentSlot.CHEST).isEmpty();
    }

    public boolean isArmor(ItemStack p_30645_) {
        return false;
    }

    private SlotAccess createEquipmentSlotAccess(final int p_149503_, final Predicate<ItemStack> p_149504_) {
        return new SlotAccess() {
            public ItemStack get() {
                return GiantSkaroEelEntity.this.inventory.getItem(p_149503_);
            }

            public boolean set(ItemStack p_149528_) {
                if (!p_149504_.test(p_149528_)) {
                    return false;
                } else {
                    GiantSkaroEelEntity.this.inventory.setItem(p_149503_, p_149528_);
                    GiantSkaroEelEntity.this.updateContainerEquipment();
                    return true;
                }
            }
        };
    }

    public SlotAccess getSlot(int p_149514_) {
        int i = p_149514_ - 400;
        if (i >= 0 && i < 2 && i < this.inventory.getContainerSize()) {
            if (i == 0) {
                return this.createEquipmentSlotAccess(i, (p_149518_) -> {
                    return p_149518_.isEmpty() || p_149518_.is(Items.SADDLE);
                });
            }

            if (i == 1) {
                if (!this.canWearArmor()) {
                    return SlotAccess.NULL;
                }

                return this.createEquipmentSlotAccess(i, (p_149516_) -> {
                    return p_149516_.isEmpty() || this.isArmor(p_149516_);
                });
            }
        }

        int j = p_149514_ - 500 + 2;
        return j >= 2 && j < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, j) : super.getSlot(p_149514_);
    }

    @javax.annotation.Nullable
    public LivingEntity getControllingPassenger() {
        if (this.isSaddled()) {
            Entity entity = this.getFirstPassenger();
            if (entity instanceof LivingEntity) {
                return (LivingEntity)entity;
            }
        }

        return null;
    }






}
