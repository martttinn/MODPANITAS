package net.martin.panitasMod.blocks;

import net.martin.panitasMod.blocks.custom.TobbaccoCropBlock;
import net.martin.panitasMod.blocks.custom.WeedCropBlock;
import net.martin.panitasMod.items.ModItems;
import net.martin.panitasMod.panitasMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, panitasMod.MOD_ID);

    // SECCION BLOQUES FUNCIONALES
    public static final RegistryObject<Block> ROLLING_STATION = registerBlock("rolling_station", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));

    // SECCION DE BLOQUES DE COSECHA
    public static final RegistryObject<Block> WEED_CROP = BLOCKS.register("weed_crop", () -> new WeedCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> TOBBACCO_CROP = BLOCKS.register("tobbacco_crop", () -> new TobbaccoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> WEED_BLOCK = registerBlock("weed_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ACACIA_LEAVES)));

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }


}
