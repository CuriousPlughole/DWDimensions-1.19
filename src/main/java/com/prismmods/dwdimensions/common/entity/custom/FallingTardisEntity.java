package com.prismmods.dwdimensions.common.entity.custom;

import com.prismmods.dwdimensions.DWDimensions;
import com.prismmods.dwdimensions.common.block.DWDBlocks;
import com.prismmods.dwdimensions.common.block.custom.TardisBlock;
import com.prismmods.dwdimensions.common.blockentities.tardis.Chameleon;
import com.prismmods.dwdimensions.common.blockentities.tardis.DoorStatus;
import com.prismmods.dwdimensions.common.blockentities.tardis.TardisBlockEntity;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import net.minecraft.CrashReportCategory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Rotations;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.DirectionalPlaceContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Predicate;

public class FallingTardisEntity extends Entity {


    private BlockState blockState; //= DWDBlocks.TARDIS.get().defaultBlockState();
    public int time;
    private boolean hurtEntities;
    private int fallDamageMax = 40;
    private float fallDamagePerDistance;

    //DATA stuff. All Tardis blockentity data should be saved to the falling tardis entity
    @Nullable
    public CompoundTag blockData;
    private Chameleon chameleon;
    private DoorStatus doorState;
    private Boolean lightsOn;
    private float rotation;
    private int tardisID;

    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(FallingTardisEntity.class, EntityDataSerializers.BLOCK_POS);
    protected static final EntityDataAccessor<String> CHAMELEON = SynchedEntityData.defineId(FallingTardisEntity.class, EntityDataSerializers.STRING);
    protected static final EntityDataAccessor<Boolean> LIGHTS = SynchedEntityData.defineId(FallingTardisEntity.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<String> DOOR = SynchedEntityData.defineId(FallingTardisEntity.class, EntityDataSerializers.STRING);
    protected static final EntityDataAccessor<Float> ROTATION = SynchedEntityData.defineId(FallingTardisEntity.class, EntityDataSerializers.FLOAT);
    protected static final EntityDataAccessor<Integer> TARDIS_ID = SynchedEntityData.defineId(FallingTardisEntity.class, EntityDataSerializers.INT);

    public FallingTardisEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    private FallingTardisEntity(Level level, double xPos, double yPos, double zPos, BlockState state) {
        this(DWDEntityTypes.FALLING_TARDIS.get(), level);
        this.blockState = state;
        this.blocksBuilding = true;
        this.setPos(xPos, yPos, zPos);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = xPos;
        this.yo = yPos;
        this.zo = zPos;
        this.setStartPos(this.blockPosition());

        if(state.getBlock() == DWDBlocks.TARDIS.get()) {
            BlockEntity blockEntity = level.getBlockEntity(new BlockPos(xo, yo, zo));
            if(blockEntity instanceof TardisBlockEntity) {
                TardisBlockEntity tardisBlockEntity = (TardisBlockEntity) blockEntity;
                this.chameleon = tardisBlockEntity.getChameleon();
                this.doorState = tardisBlockEntity.getDoorState();
                this.lightsOn = tardisBlockEntity.getLightState();
                this.rotation = tardisBlockEntity.getRotationInDeg();
                this.tardisID = tardisBlockEntity.getTardisID();
                this.entityData.set(CHAMELEON, chameleon.getNbtName());
                this.entityData.set(LIGHTS, lightsOn);
                this.entityData.set(DOOR, doorState.getNbtName());
                this.entityData.set(ROTATION, rotation);
                this.entityData.set(TARDIS_ID, tardisID);
            }
        }
    }

    public static FallingTardisEntity fall(Level level, BlockPos pos, BlockState state) {
        FallingTardisEntity fallingtardisentity = new FallingTardisEntity(level, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, state);
        level.setBlock(pos, state.getFluidState().createLegacyBlock(), 3);
        level.addFreshEntity(fallingtardisentity);
        return fallingtardisentity;
    }

    public boolean isAttackable() {
        return false;
    }
    public void setStartPos(BlockPos pos) {
        this.entityData.set(DATA_START_POS, pos);
    }
    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }
    public boolean isPickable() {
        return !this.isRemoved();
    }

    public void tick() {
        if (this.blockState.isAir()) {
            this.discard();
        } else {
            Block block = this.blockState.getBlock();
            ++this.time;
            if (!this.isNoGravity()) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
            }

            this.move(MoverType.SELF, this.getDeltaMovement());
            if (!this.level.isClientSide) {
                BlockPos blockpos = this.blockPosition();

                double d0 = this.getDeltaMovement().lengthSqr();

                //If the tardis has been floating for > 100 and is below the world, or has been floating for > 1000 and is above build height,
                //Then drop the tardis as an item (if allowed by gamerule). Otherwise just delete the tardis entity. -> Will need to be recoverable (summon with key etc)
                if (!this.onGround) {
                    if (!this.level.isClientSide && (this.time > 100 && (blockpos.getY() <= this.level.getMinBuildHeight() || blockpos.getY() > this.level.getMaxBuildHeight()) || this.time > 1000)) {
                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            this.spawnAtLocation(block);
                        }
                        this.discard();
                    }
                }
                //If the entity is on the ground,
                else {
                    BlockState blockstate = this.level.getBlockState(blockpos);
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.7D, -0.5D, 0.7D));
                    if (!blockstate.is(Blocks.MOVING_PISTON)) {

                            boolean flag3 = TardisBlockEntity.isFree(this.level.getBlockState(blockpos.below()));

                                //set block to landed tardis
                                if (this.level.setBlock(blockpos, this.blockState, 3)) {
                                    ((ServerLevel)this.level).getChunkSource().chunkMap.broadcast(this, new ClientboundBlockUpdatePacket(blockpos, this.level.getBlockState(blockpos)));
                                    this.discard();
                                    if (block instanceof TardisBlock) {
                                        TardisBlock tardisBlock = (TardisBlock) block;
                                       tardisBlock.onLand(this.level, blockpos, this.blockState, blockstate, this);
                                    }

                                    if (this.blockData != null && this.blockState.hasBlockEntity()) {
                                        BlockEntity blockentity = this.level.getBlockEntity(blockpos);

                                        if (blockentity != null) {
                                            CompoundTag compoundtag = blockentity.saveWithoutMetadata();
                                            for(String s : this.blockData.getAllKeys()) {
                                                compoundtag.put(s, this.blockData.get(s).copy());
                                            }
                                            try {
                                                blockentity.load(compoundtag);
                                            } catch (Exception exception) {
                                                DWDimensions.LOGGER.error("Failed to load block entity from falling block", (Throwable)exception);
                                            }
                                            blockentity.setChanged();
                                        }
                                    }
                                }
                                //If there was a block in the way, and the tardis was unable to land normally
                                else {
                                    this.discard();
                                    System.out.println("Block in the way! " + blockstate);
                                    if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                                        this.spawnAtLocation(block);
                                    }
                                }
                    }
                }
            }
            this.setDeltaMovement(this.getDeltaMovement().scale(0.98D));
        }
    }

    public boolean causeFallDamage(float p_149643_, float p_149644_, DamageSource damageSource) {
        if (!this.hurtEntities) {
            return false;
        } else {
            int i = Mth.ceil(p_149643_ - 1.0F);
            if (i < 0) {
                return false;
            } else {
                Predicate<Entity> predicate;
                DamageSource damagesource;
                if (this.blockState.getBlock() instanceof Fallable) {
                    Fallable fallable = (Fallable)this.blockState.getBlock();
                    predicate = fallable.getHurtsEntitySelector();
                    damagesource = fallable.getFallDamageSource();
                } else {
                    predicate = EntitySelector.NO_SPECTATORS;
                    damagesource = DamageSource.FALLING_BLOCK;
                }

                float f = (float)Math.min(Mth.floor((float)i * this.fallDamagePerDistance), this.fallDamageMax);
                this.level.getEntities(this, this.getBoundingBox(), predicate).forEach((p_149649_) -> {
                    p_149649_.hurt(damagesource, f);
                });
                /*
                boolean flag = this.blockState.is(BlockTags.ANVIL);
                if (flag && f > 0.0F && this.random.nextFloat() < 0.05F + (float)i * 0.05F) {
                    BlockState blockstate = AnvilBlock.damage(this.blockState);
                    if (blockstate == null) {
                        this.cancelDrop = true;
                    } else {
                        this.blockState = blockstate;
                    }
                }*/

                return false;
            }
        }
    }


    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_START_POS, BlockPos.ZERO);
        getEntityData().define(CHAMELEON, Chameleon.ECCLESTON.getNbtName());
        getEntityData().define(LIGHTS, false);
        getEntityData().define(DOOR, DoorStatus.OPEN.getNbtName());
        getEntityData().define(TARDIS_ID, 0);
        getEntityData().define(ROTATION, 0.0f);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        this.blockState = NbtUtils.readBlockState(tag.getCompound("BlockState"));
        this.time = tag.getInt("Time");
        if (tag.contains("HurtEntities", 99)) {
            this.hurtEntities = tag.getBoolean("HurtEntities");
            this.fallDamagePerDistance = tag.getFloat("FallHurtAmount");
            this.fallDamageMax = tag.getInt("FallHurtMax");
        } else if (this.blockState.is(BlockTags.ANVIL)) {
            this.hurtEntities = true;
        }
        if (tag.contains("TileEntityData", 10)) {
            this.blockData = tag.getCompound("TileEntityData");
        }

        if (this.blockState.isAir()) {
            this.blockState = Blocks.SAND.defaultBlockState();
        }

        if(tag.contains("chameleon")) {this.entityData.set(CHAMELEON, tag.getString("chameleon"));}
        if(tag.contains("lightsOn")) {this.entityData.set(LIGHTS, tag.getBoolean("lightsOn"));}
        if(tag.contains("door")) {this.entityData.set(DOOR, tag.getString("door"));}
        if(tag.contains("tardisID")) {this.entityData.set(TARDIS_ID, tag.getInt("tardisID"));}
        if(tag.contains("rotation")) {this.entityData.set(ROTATION, tag.getFloat("rotation"));}
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.put("BlockState", NbtUtils.writeBlockState(this.blockState));
        tag.putInt("Time", this.time);
        tag.putBoolean("HurtEntities", this.hurtEntities);
        tag.putFloat("FallHurtAmount", this.fallDamagePerDistance);
        tag.putInt("FallHurtMax", this.fallDamageMax);
        if (this.blockData != null) {
            tag.put("TileEntityData", this.blockData);
        }

        tag.putString("chameleon", this.chameleon.getNbtName());
        tag.putBoolean("lightsOn", this.lightsOn);
        tag.putString("door", this.doorState.getNbtName());
        tag.putInt("tardisID", this.tardisID);
        tag.putFloat("rotation", this.rotation);
    }

    public String getChameleon() {
        return this.entityData.get(CHAMELEON);
    }
    public boolean getLights() {
        return this.entityData.get(LIGHTS);
    }
    public String getDoorState() {
        return this.entityData.get(DOOR);
    }

    public float getRotation() {
        return this.entityData.get(ROTATION);
    }

    public int getTardisID() {
        return this.entityData.get(TARDIS_ID);
    }

    public void setHurtsEntities(float p_149657_, int p_149658_) {
        this.hurtEntities = true;
        this.fallDamagePerDistance = p_149657_;
        this.fallDamageMax = p_149658_;
    }

    public boolean displayFireAnimation() {
        return false;
    }

    public void fillCrashReportCategory(CrashReportCategory p_31962_) {
        super.fillCrashReportCategory(p_31962_);
        p_31962_.setDetail("Immitating BlockState", this.blockState.toString());
    }

    public BlockState getBlockState() {
        return this.blockState;
    }

    public boolean onlyOpCanSetNbt() {
        return true;
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, Block.getId(this.getBlockState()));
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_149654_) {
        super.recreateFromPacket(p_149654_);
        this.blockState = Block.stateById(p_149654_.getData());
        this.blocksBuilding = true;
        double d0 = p_149654_.getX();
        double d1 = p_149654_.getY();
        double d2 = p_149654_.getZ();
        this.setPos(d0, d1, d2);
        this.setStartPos(this.blockPosition());
        this.entityData.set(CHAMELEON, getChameleon());
        this.entityData.set(LIGHTS, getLights());
        this.entityData.set(DOOR, getDoorState());
        this.entityData.set(ROTATION, getRotation());
        this.entityData.set(TARDIS_ID, getTardisID());

    }

}
