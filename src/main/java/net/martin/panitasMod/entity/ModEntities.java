package net.martin.panitasMod.entity;

import net.martin.panitasMod.entity.custom.StoneGolemEntity;
import net.martin.panitasMod.panitasMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, panitasMod.MOD_ID);

    public static final RegistryObject<EntityType<StoneGolemEntity>> GOLEM_PIEDRA = ENTITY_TYPES.register("golem_piedra",
            () -> EntityType.Builder.of(StoneGolemEntity::new, MobCategory.CREATURE).sized(2.3f,3.0f).build(panitasMod.MOD_ID + ":golem_piedra"));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
