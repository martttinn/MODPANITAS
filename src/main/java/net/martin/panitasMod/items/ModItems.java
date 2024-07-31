package net.martin.panitasMod.items;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.items.custom.BluntItem;
import net.martin.panitasMod.items.custom.ModArmorItem;
import net.martin.panitasMod.items.custom.TagDetectorItem;
import net.martin.panitasMod.panitasMod;
import net.martin.panitasMod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, panitasMod.MOD_ID);

    // SECCION ITEMS DE COMBATE O HERRAMIENTAS
    public static final RegistryObject<Item> ESPADA_DILDO = ITEMS.register("espada_dildo",() -> new SwordItem(Tiers.NETHERITE,10,-3.4f, new Item.Properties().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> CASCO_MARIHUANA = ITEMS.register("casco_marihuana", () -> new ModArmorItem(ModArmorMaterials.COGOLLO, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PECHERA_MARIHUANA = ITEMS.register("pechera_marihuana", () -> new ArmorItem(ModArmorMaterials.COGOLLO, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PANTALONES_MARIHUANA = ITEMS.register("pantalones_marihuana", () -> new ArmorItem(ModArmorMaterials.COGOLLO, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BOTAS_MARIHUANA = ITEMS.register("botas_marihuana", () -> new ArmorItem(ModArmorMaterials.COGOLLO, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> TAG_DETECTOR = ITEMS.register("tag_detector", () -> new TagDetectorItem(new Item.Properties()));
    // SECCION ITEMS DE COMIDA
    public static final RegistryObject<Item> SETA = ITEMS.register("seta",() -> new Item(new Item.Properties().food(ModFoods.SETA_PROPERTIES)));

    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt",() -> new BluntItem(new Item.Properties(),false));

    public static final RegistryObject<Item> LIT_BLUNT = ITEMS.register("lit_blunt",() -> new BluntItem(new Item.Properties().food(ModFoods.BLUNT_PROPERTIES),true));

    // SECCION ITEMS MISCELANEOS
    public static final RegistryObject<Item> MONEDA = ITEMS.register("moneda",() -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> PIGGY_BANK = ITEMS.register("piggy_bank",() -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    // SECCION ITEMS MUSICA
    public static final RegistryObject<Item> GEMA_ES_MUJER_DISCO = ITEMS.register("gema_es_mujer_disco",() -> new RecordItem(15, ModSounds.GEMA_ES_MUJER,new Item.Properties().stacksTo(1),2240));

    // SECCION ITEMS DE COSECHA
    public static final RegistryObject<Item> WEED_SEEDS = ITEMS.register("weed_seeds",() -> new ItemNameBlockItem(ModBlocks.WEED_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> COGOLLO = ITEMS.register("cogollo",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOBBACCO_SEEDS = ITEMS.register("tobbacco_seeds",() -> new ItemNameBlockItem(ModBlocks.TOBBACCO_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> HOJA_TABACO = ITEMS.register("hoja_tabaco",() -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
