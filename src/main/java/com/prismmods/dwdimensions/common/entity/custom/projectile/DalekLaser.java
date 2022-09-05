package com.prismmods.dwdimensions.common.entity.custom.projectile;

import com.prismmods.dwdimensions.common.entity.DWDEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class DalekLaser extends AbstractLaser{

    public DalekLaser(EntityType<? extends DalekLaser> laser, Level level) {
        super(laser, level);
    }

    public DalekLaser(Level level, double x, double y, double z) {
        super(DWDEntityTypes.DALEK_LASER.get(), x, y, z, level);
    }

    public DalekLaser(Level level, LivingEntity entity) {
        super(DWDEntityTypes.DALEK_LASER.get(), entity, level);
    }



}
