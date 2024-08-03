package net.martin.panitasMod.event;

import net.martin.panitasMod.entity.ModEntities;
import net.martin.panitasMod.entity.custom.StoneGolemEntity;
import net.martin.panitasMod.panitasMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = panitasMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GOLEM_PIEDRA.get(), StoneGolemEntity.createAttributes().build());
    }
}
