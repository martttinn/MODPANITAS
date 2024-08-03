package net.martin.panitasMod.entity.custom;

import net.minecraft.client.gui.screens.social.PlayerEntry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

public class StoneGolemEntity extends IronGolem {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public StoneGolemEntity(EntityType<? extends IronGolem> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide())
        {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates()
    {
        if (idleAnimationTimeout <= 0)
        {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        }
        else
        {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING)
        {
            f = Math.min(pPartialTick, 0.20f);
        }
        else
        {
            f = 0f;
        }

        this.walkAnimation.update(f,0.2f);
    }

    @Override
    public double getMeleeAttackRangeSqr(LivingEntity pEntity) {
        return 5.0f;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2,new WaterAvoidingRandomStrollGoal(this,0.20D));
        this.goalSelector.addGoal(2,new RandomStrollGoal(this,0.20D));
        this.goalSelector.addGoal(0,new CustomMeleeAttackGoal(this,0.20D, false ));
        this.goalSelector.addGoal(1,new NearestAttackableTargetGoal<>(this, Monster.class,true));
        this.goalSelector.addGoal(1,new HurtByTargetGoal(this));
        this.goalSelector.addGoal(2,new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2,new LookAtPlayerGoal(this, Player.class,2.0f));

    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return IronGolem.createMobAttributes()
                .add(Attributes.MAX_HEALTH,100D)
                .add(Attributes.MOVEMENT_SPEED,0.25D)
                .add(Attributes.ATTACK_DAMAGE,8.0f)
                .add(Attributes.ARMOR_TOUGHNESS,0.1f)
                .add(Attributes.ARMOR, 1.0f)
                .add(Attributes.ATTACK_KNOCKBACK,1.0D)
                .add(Attributes.FOLLOW_RANGE,35.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE,2.0D);
    }

    class CustomMeleeAttackGoal extends MeleeAttackGoal
    {

        public CustomMeleeAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
            super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity pAttackTarget) {
            return StoneGolemEntity.this.getMeleeAttackRangeSqr(pAttackTarget);
        }
    }
}
