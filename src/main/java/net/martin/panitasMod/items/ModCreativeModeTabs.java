package net.martin.panitasMod.items;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.panitasMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, panitasMod.MOD_ID);

    // PAGINA DEL MENU CREATIVO PARA LOS ITEMS DE COMIDA
    public static final RegistryObject<CreativeModeTab> MOD_FOODS_TAB = CREATIVE_MODE_TABS.register("foods_tab",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLUNT.get()))
            .title(Component.translatable("creativetab.foods_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.BLUNT.get());
                output.accept(ModItems.LIT_BLUNT.get());
                output.accept(ModItems.SETA.get());
            }).build());

    //PAGINA DEL MENU CREATIVO PARA ARMAS Y COMBATE
    public static final RegistryObject<CreativeModeTab> MOD_WEAPONS_TAB = CREATIVE_MODE_TABS.register("weapons_tab",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ESPADA_DILDO.get()))
            .title(Component.translatable("creativetab.weapons_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.ESPADA_DILDO.get());
                output.accept(ModItems.TAG_DETECTOR.get());
                output.accept(ModItems.CASCO_MARIHUANA.get());
                output.accept(ModItems.PECHERA_MARIHUANA.get());
                output.accept(ModItems.PANTALONES_MARIHUANA.get());
                output.accept(ModItems.BOTAS_MARIHUANA.get());
            }).build());

    //PAGINA DEL MENU CREATIVO PARA MUSICA
    public static final RegistryObject<CreativeModeTab> MOD_MUSIC_TAB = CREATIVE_MODE_TABS.register("music_tab",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GEMA_ES_MUJER_DISCO.get()))
            .title(Component.translatable("creativetab.music_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.GEMA_ES_MUJER_DISCO.get());
            }).build());

    //PAGINA DEL MENU CREATIVO PARA MISCELANIO
    public static final RegistryObject<CreativeModeTab> MOD_MISC_TAB = CREATIVE_MODE_TABS.register("misc_tab",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MONEDA.get()))
            .title(Component.translatable("creativetab.misc_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.MONEDA.get());
            }).build());

    //PAGINA DEL MENU CREATIVO PARA COSECHAS
    public static final RegistryObject<CreativeModeTab> MOD_CROPS_TAB = CREATIVE_MODE_TABS.register("crops_tab",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COGOLLO.get()))
            .title(Component.translatable("creativetab.crops_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.WEED_SEEDS.get());
                output.accept(ModItems.COGOLLO.get());
                output.accept(ModItems.TOBBACCO_SEEDS.get());
                output.accept(ModItems.HOJA_TABACO.get());
                output.accept(ModBlocks.WEED_BLOCK.get());


            }).build());

    //PAGINA DEL MENU CREATIVO PARA BLOQUES FUNCIONALES
    public static final RegistryObject<CreativeModeTab> MOD_FUNCTIONAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("functional_blocks_tab",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ROLLING_STATION.get()))
            .title(Component.translatable("creativetab.functional_blocks_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.ROLLING_STATION.get());
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
