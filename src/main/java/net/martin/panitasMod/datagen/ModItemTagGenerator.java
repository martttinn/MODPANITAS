package net.martin.panitasMod.datagen;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.items.ModItems;
import net.martin.panitasMod.panitasMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider
{

    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, panitasMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        // TAG PARA ARMADURA
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CASCO_MARIHUANA.get(),
                        ModItems.PECHERA_MARIHUANA.get(),
                        ModItems.PANTALONES_MARIHUANA.get(),
                        ModItems.BOTAS_MARIHUANA.get());

        // TAG PARA MADERA INFLAMABLE
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASTRALON_LOG.get().asItem())
                .add(ModBlocks.ASTRALON_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ASTRALON_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ASTRALON_WOOD.get().asItem());

        // TAG PARA PLANKS
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.ASTRALON_PLANKS.get().asItem());
    }
}
