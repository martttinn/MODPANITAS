package net.martin.panitasMod.entity.custom;

import net.minecraft.client.gui.screens.social.PlayerEntry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

public class StoneGolemEntity extends Animal {
    public StoneGolemEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new WaterAvoidingRandomStrollGoal(this,0.20D));
        this.goalSelector.addGoal(1,new MeleeAttackGoal(this,0.25D, false ));
        this.goalSelector.addGoal(1,new NearestAttackableTargetGoal<>(this, Monster.class,true));
        this.goalSelector.addGoal(1,new HurtByTargetGoal(this));
        this.goalSelector.addGoal(2,new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2,new LookAtPlayerGoal(this, Player.class,2.0f));

    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,100D)
                .add(Attributes.MOVEMENT_SPEED,0.20D)
                .add(Attributes.ATTACK_DAMAGE,8.0f)
                .add(Attributes.ARMOR_TOUGHNESS,0.1f)
                .add(Attributes.ARMOR, 1.0f)
                .add(Attributes.ATTACK_KNOCKBACK,1.0D)
                .add(Attributes.FOLLOW_RANGE,35.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE,2.0D);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
