package net.martin.panitasMod.sound;

import net.martin.panitasMod.panitasMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, panitasMod.MOD_ID);

    // SONIDO PARA CADA HIT DE LA ESPADA DILDO
    public static final RegistryObject<SoundEvent> GEMIDO_HENTAI = registerSoundEvents("gemido_hentai");

    // SONIDO PARA EL DISCO DE MUSICA CUSTOM
    public static final RegistryObject<SoundEvent> GEMA_ES_MUJER  = registerSoundEvents("gema_es_mujer");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name)
    {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(panitasMod.MOD_ID,name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }

}
