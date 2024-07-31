package net.martin.panitasMod.event;

import net.martin.panitasMod.entity.client.ModModelLayers;
import net.martin.panitasMod.entity.client.golem_piedra;
import net.martin.panitasMod.panitasMod;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = panitasMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.GOLEM_PIEDRA_LAYER, golem_piedra::createBodyLayer);
    }
}
