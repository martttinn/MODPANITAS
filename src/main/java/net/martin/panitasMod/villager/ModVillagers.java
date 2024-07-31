package net.martin.panitasMod.villager;

import com.google.common.collect.ImmutableSet;
import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.panitasMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, panitasMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,panitasMod.MOD_ID);

    public static final RegistryObject<PoiType> PLUG_POI = POI_TYPES.register("plug_poi",()-> new PoiType(ImmutableSet.of(ModBlocks.ROLLING_STATION.get().defaultBlockState()),1,1));

    public static final RegistryObject<VillagerProfession> PLUG = VILLAGER_PROFESSIONS.register("plug",() -> new VillagerProfession("plug",holder -> holder.get() == PLUG_POI.get(), holder -> holder.get() == PLUG_POI.get(), ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
