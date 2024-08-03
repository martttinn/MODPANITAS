package net.martin.panitasMod.datagen;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.panitasMod;
import net.martin.panitasMod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider
{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, panitasMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        // TAG PARA CROPS
        this.tag(BlockTags.CROPS)
                .add(ModBlocks.WEED_CROP.get())
                .add(ModBlocks.TOBBACCO_CROP.get());

        // TAG PARA MADERAS INFLAMABLES
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASTRALON_LOG.get())
                .add(ModBlocks.ASTRALON_WOOD.get())
                .add(ModBlocks.STRIPPED_ASTRALON_LOG.get())
                .add(ModBlocks.STRIPPED_ASTRALON_WOOD.get());

        // TAG PARA PLANKS
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ASTRALON_PLANKS.get());

        // TAG PARA HOJAS
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.ASTRALON_LEAVES.get());
    }
}
