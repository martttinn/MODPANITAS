package net.martin.panitasMod.blocks;

import net.martin.panitasMod.blocks.custom.ModFlammableRotatedPillarBlock;
import net.martin.panitasMod.blocks.custom.TobbaccoCropBlock;
import net.martin.panitasMod.blocks.custom.WeedCropBlock;
import net.martin.panitasMod.items.ModItems;
import net.martin.panitasMod.panitasMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    // SECCION DE MADERAS Y ARBOLES
    public static final RegistryObject<Block> ASTRALON_LOG = registerBlock("astralon_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3)));

    public static final RegistryObject<Block> ASTRALON_WOOD = registerBlock("astralon_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3)));

    public static final RegistryObject<Block> STRIPPED_ASTRALON_LOG = registerBlock("stripped_astralon_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3)));

    public static final RegistryObject<Block> STRIPPED_ASTRALON_WOOD = registerBlock("stripped_astralon_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3)));

    public static final RegistryObject<Block> ASTRALON_PLANKS = registerBlock("astralon_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }
    });

    public static final RegistryObject<Block> ASTRALON_LEAVES = registerBlock("astralon_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 60;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 30;
        }
    });

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
