/**
package com.prismmods.dwdimensions.common.entity.custom.dalek;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.monster.piglin.StartAdmiringItemIfSeen;
import net.minecraft.world.entity.monster.piglin.StopHoldingItemIfNoLongerAdmiring;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Activity;

import java.util.Optional;

import static com.google.common.base.Optional.of;

public class DalekAI {

    private static final UniformInt TIME_BETWEEN_COMPUTER_USAGE = TimeUtil.rangeOfSeconds(20, 80);

    protected static Brain<?> makeBrain(DalekEntity dalek, Brain<DalekEntity> brain) {
        initCoreActivity(brain);
        initIdleActivity(brain);
        initFightActivity(dalek, brain);
        initRespondAlarmActivity(brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.useDefaultActivity();
        return brain;
    }

    protected static void initMemories(DalekEntity dalek, RandomSource rand) {
        int i = TIME_BETWEEN_COMPUTER_USAGE.sample(rand);
        dalek.getBrain().setMemoryWithExpiry(MemoryModuleType.LAST_WORKED_AT_POI, (long)i, i);
    }

    private static void initCoreActivity(Brain<DalekEntity> brain) {
        brain.addActivity(Activity.CORE, 0, ImmutableList.of(new LookAtTargetSink(45, 90), new MoveToTargetSink(), new InteractWithDoor()));
    }

    private static void initIdleActivity(Brain<DalekEntity> brain) {
        brain.addActivity(Activity.IDLE, 10, ImmutableList.of(new SetEntityLookTarget(DalekEntity.NOT_DALEK, 14.0f), new StartAttacking<>(DalekEntity::isAbleToAttack, DalekAI::findNearestValidAttackTarget), createIdleLookBehaviors(), createIdleMovementBehaviors()));
    }

    public static void initFightActivity(DalekEntity dalek, Brain<DalekEntity> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10, ImmutableList.of(new StopAttackingIfTargetInvalid<DalekEntity>(a -> {
            return !isNearestValidAttackTarget(dalek, a);
        }), new RunIf<>(DalekAI::hasRangedWeapon, new BackUpIfTooClose<>(5, 0.75F)), new SetWalkTargetFromAttackTargetIfTargetOutOfReach(1.0F), new MeleeAttack(20), new CrossbowAttack()));
    }



    private static Optional<? extends LivingEntity> findNearestValidAttackTarget(DalekEntity dalek) {
        Brain<DalekEntity> brain = dalek.getBrain();
        Optional<Mob> optional = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
        if (optional.isPresent()) {
            return optional;
        } else {
            Optional<Player> optional2 = brain.getMemory(MemoryModuleType.NEAREST_TARGETABLE_PLAYER_NOT_DISGUISED_AS_DALEK);
            return optional2.isPresent() && Sensor.isEntityAttackable(dalek, optional2.get()) ? optional2 : Optional.empty();
        }
    }

    private static boolean isNearestValidAttackTarget(DalekEntity dalek, LivingEntity target) {
        return findNearestValidAttackTarget(dalek).filter((p_34887_) -> {
            return p_34887_ == target;
        }).isPresent();
    }

    //In future may have disarmed daleks
    private static boolean hasRangedWeapon(LivingEntity dalek) {
        return true;
    }

    private static RunOne<DalekEntity> createIdleLookBehaviors() {
        return new RunOne<>(ImmutableList.of(Pair.of(new SetEntityLookTarget(EntityType.PLAYER, 8.0F), 1),
                Pair.of(new SetEntityLookTarget(DWDEntityTypes.DALEK.get(), 8.0F), 1), Pair.of(new SetEntityLookTarget(8.0F), 1), Pair.of(new DoNothing(30, 60), 1)));
    }

    private static RunOne<DalekEntity> createIdleMovementBehaviors() {
        return new RunOne<>(ImmutableList.of(Pair.of(new RandomStroll(0.6F), 2),
                Pair.of(InteractWith.of(DWDEntityTypes.DALEK.get(), 8, MemoryModuleType.INTERACTION_TARGET, 0.6F, 2), 2),
                Pair.of(new DoNothing(30, 60), 1)));
                //Pair.of(new RunIf<>(PiglinAi::doesntSeeAnyPlayerHoldingLovedItem, new SetWalkTargetFromLookTarget(0.6F, 3)), 2), Pair.of(new DoNothing(30, 60), 1)));
        //TODO: COMPUTER STUFF TO GO HERE?
    }




}
**/