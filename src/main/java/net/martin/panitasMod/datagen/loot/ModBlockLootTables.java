package net.martin.panitasMod.datagen.loot;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.blocks.custom.WeedCropBlock;
import net.martin.panitasMod.items.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        //SECCION BLOQUES GENERICOS
        this.dropSelf(ModBlocks.ROLLING_STATION.get());
        this.dropSelf(ModBlocks.WEED_BLOCK.get());
        this.dropSelf(ModBlocks.ASTRALON_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ASTRALON_LOG.get());
        this.dropSelf(ModBlocks.ASTRALON_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ASTRALON_WOOD.get());
        this.dropSelf(ModBlocks.ASTRALON_PLANKS.get());

        //SECCION DE HOJAS DE ARBOL
        this.add(ModBlocks.ASTRALON_LEAVES.get(), block ->
                createLeavesDrops(block,ModBlocks.WEED_BLOCK.get(),NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: CAMBIAR AL SAPPLING

        //SECCION DE CROPS
        LootItemCondition.Builder Wlootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.WEED_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WeedCropBlock.AGE,5));
        this.add(ModBlocks.WEED_CROP.get(), createCropDrops(ModBlocks.WEED_CROP.get(), ModItems.COGOLLO.get()
                ,ModItems.WEED_SEEDS.get(),Wlootitemcondition$builder));

        LootItemCondition.Builder Tlootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TOBBACCO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WeedCropBlock.AGE,4));
        this.add(ModBlocks.TOBBACCO_CROP.get(), createCropDrops(ModBlocks.TOBBACCO_CROP.get(), ModItems.HOJA_TABACO.get()
                ,ModItems.TOBBACCO_SEEDS.get(),Tlootitemcondition$builder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
