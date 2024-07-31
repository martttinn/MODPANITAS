package net.martin.panitasMod;

import com.mojang.logging.LogUtils;
import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.entity.ModEntities;
import net.martin.panitasMod.entity.client.StoneGolemRenderer;
import net.martin.panitasMod.event.ModEventHandler;
import net.martin.panitasMod.items.ModCreativeModeTabs;
import net.martin.panitasMod.items.ModItems;
import net.martin.panitasMod.painting.ModPaintings;
import net.martin.panitasMod.sound.ModSounds;
import net.martin.panitasMod.villager.ModVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.model.renderable.ITextureRenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(panitasMod.MOD_ID)
public class panitasMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "panitas";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public panitasMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModPaintings.register(modEventBus);
        ModSounds.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModEntities.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(new ModEventHandler());

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEED_CROP.get(),RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOBBACCO_CROP.get(),RenderType.cutout());
            EntityRenderers.register(ModEntities.GOLEM_PIEDRA.get(), StoneGolemRenderer::new);
        }
    }
}
