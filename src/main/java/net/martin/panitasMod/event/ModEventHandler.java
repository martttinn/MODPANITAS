package net.martin.panitasMod.event;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.martin.panitasMod.items.ModItems;
import net.martin.panitasMod.panitasMod;
import net.martin.panitasMod.sound.ModSounds;
import net.martin.panitasMod.villager.ModVillagers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = panitasMod.MOD_ID)
public class ModEventHandler
{
    private static final Random RANDOM = new Random();

    // METODO QUE SE EJECUTA CADA VEZ QUE SE ATACA A UNA ENTIDAD
    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event)
    {
        // OBTENEMOS EL JUGADOR
        Player player = (Player)event.getEntity();

        //OBTENEMOS EL MUNDO(NIVEL) DEL JUGADOR
        Level world = player.level();

        // OBTENEMOS EL ITEM SOSTENIDO EN LA MANO PRINCIPAL
        ItemStack mainHandItem = player.getMainHandItem();

        // COMPROBAMOS QUE EL ITEM SOSTENIDO SEA EL DESEADO
        if (mainHandItem.getItem() == ModItems.ESPADA_DILDO.get())
        {
            // REPRODUCIMOS EL SONIDO DESEADO
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSounds.GEMIDO_HENTAI.get(), player.getSoundSource(), 3.0f, 1.0f);

            // SPAWNEAMOS LA CANTIDAD DE PARTICULAS EQUIVALENTE AL NUMERO DE ITERACIONES
            for (int i = 0; i < 100; i++)
            {
                // SPAWNEAMOS LA PARTICULA EN LA POSICION DEL ENEMIGO CON CIERTO OFFSET ALEATORIO PARA CADA PARTICULA
                world.addParticle(ParticleTypes.END_ROD,
                        event.getTarget().getX() + world.random.nextGaussian() * 0.6,
                        event.getTarget().getY() + world.random.nextGaussian() * 0.6 + 2.0,
                        event.getTarget().getZ() + world.random.nextGaussian() * 0.6,
                        0.0D, 0.0D, 0.0D);
            }
        }
    }

    // METODO QUE SE EJECUTA CADA VEZ QUE SE UTILIZA UN ITEM
    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event)
    {
        // OBTENEMOS LA ENTIDAD QUE HA USADO EL ITEM
        LivingEntity entity = event.getEntity();

        // OBTENEMOS EL MUNDO(LEVEL) DE LA ENTIDAD
        Level world = entity.level();

        // OBTENEMOS EL ITEM USADO POR LA ENTIDAD
        ItemStack usedItem = event.getItem();

        if (world instanceof ServerLevel serverWorld)
        {
            if (usedItem.getItem() == ModItems.LIT_BLUNT.get())
            {
                for (int i = 0; i < 100; i++) {
                    double offsetX = entity.getX() + (world.random.nextDouble() - 0.5) * 2.0;
                    double offsetY = entity.getY() + 1.0 + world.random.nextDouble();
                    double offsetZ = entity.getZ() + (world.random.nextDouble() - 0.5) * 2.0;

                    serverWorld.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, offsetX, offsetY, offsetZ, 1, 0.0, 0.0, 0.0, 0.01);
                }
            }
        }
    }

    // METODO QUE SE EJECUTA CADA VEZ QUE MUERE UNA ENTIDAD, ACTUA EN EL MOMENTO JUSTO ANTERIOR A QUE APAREZCAN LOS ITEMS DROPEADOS DE LA ENTIDAD
    @SubscribeEvent
    public static void onPlayerDeath(LivingDropsEvent event) {
        if (event.getEntity() instanceof Player player) {
            player.getInventory().items.forEach(stack -> {
                if (stack.getItem() == ModItems.PIGGY_BANK.get()) {
                    event.getDrops().removeIf(itemEntity -> itemEntity.getItem().equals(stack));
                }
            });
        }
    }

    // METODO QUE SE EJECUTA CUANDO SE RESPAWNEA UN JUGADOR
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            ItemStack piggyBank = ItemStack.EMPTY;
            for (ItemStack stack : event.getOriginal().getInventory().items) {
                if (stack.getItem() == ModItems.PIGGY_BANK.get()) {
                    piggyBank = stack.copy();
                    break;
                }
            }

            if (!piggyBank.isEmpty()) {
                event.getEntity().getInventory().add(piggyBank);
            }
        }
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        // ESTO ES PARA DEFINIR QUE TIPO DE ALDEANO TENDRA QUE TRADES
        if (event.getType() == ModVillagers.PLUG.get())
        {
            // ESTO SIEMPRE ES ASI
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // ESTO ES EL TRADE CON SUS PARAMETROS
            trades.get(1).add((pTrader,pRandom) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_NUGGET,5),
                    new ItemStack(ModItems.BLUNT.get(), 3),
                    1000,10,0.02f
            ));

            // ESTO ES EL TRADE CON SUS PARAMETROS
            trades.get(1).add((pTrader,pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.WEED_SEEDS.get(),23),
                    new ItemStack(ModItems.MONEDA.get(), 3),
                    1000,10,0.02f
            ));

            // ESTO ES EL TRADE CON SUS PARAMETROS
            trades.get(1).add((pTrader,pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.HOJA_TABACO.get(),32),
                    new ItemStack(ModItems.MONEDA.get(), 4),
                    1000,10,0.02f
            ));

            trades.get(2).add((pTrader,pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.MONEDA.get(),30),
                    new ItemStack(ModItems.ESPADA_DILDO.get(), 1),
                    1000,10,0.02f
            ));
        }
    }
}
