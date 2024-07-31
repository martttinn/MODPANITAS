package net.martin.panitasMod.painting;

import net.martin.panitasMod.panitasMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {

    public  static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, panitasMod.MOD_ID);

    public static  final RegistryObject<PaintingVariant> CUCHILLO_KOKE = PAINTING_VARIANTS.register("cuchillo_koke",() -> new PaintingVariant(32,32));
    public static  final RegistryObject<PaintingVariant> WOPPA = PAINTING_VARIANTS.register("woppa",() -> new PaintingVariant(16,32));
    public static  final RegistryObject<PaintingVariant> JUANMA_COCHE = PAINTING_VARIANTS.register("juanma",() -> new PaintingVariant(16,32));
    public static  final RegistryObject<PaintingVariant> HERMANA_KOKE = PAINTING_VARIANTS.register("hermana_koke",() -> new PaintingVariant(16,32));
    public static  final RegistryObject<PaintingVariant> ALFONSO = PAINTING_VARIANTS.register("alfonso",() -> new PaintingVariant(16,16));
    public static  final RegistryObject<PaintingVariant> PEDRO = PAINTING_VARIANTS.register("pedro",() -> new PaintingVariant(16,16));

    public static void register(IEventBus eventBus)
    {
        PAINTING_VARIANTS.register(eventBus);
    }
}
