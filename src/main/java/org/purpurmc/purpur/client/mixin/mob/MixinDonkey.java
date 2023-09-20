package org.purpurmc.purpur.client.mixin.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.DonkeyEntity;
import net.minecraft.world.World;
import org.joml.Vector3f;
import org.purpurmc.purpur.client.entity.RidableEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DonkeyEntity.class)
public abstract class MixinDonkey extends MobEntity implements RidableEntity {
    public MixinDonkey(EntityType<? extends DonkeyEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Vector3f getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        return super.getPassengerAttachmentPos(passenger, dimensions, scaleFactor).add(0, dimensions.height + (float) getSeats().donkey.y, 0);
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        updatePassengerPosition(passenger, getSeats().donkey);
    }
}
