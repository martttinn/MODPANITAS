package net.martin.panitasMod.datagen;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.panitasMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, panitasMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // SECCION BLOQUES MISCELANEOS
        blockWithItem(ModBlocks.WEED_BLOCK);

        // SECCION DE MADERAS

        //--- MADERA DE ASTRALON ---
        logBlock(((RotatedPillarBlock)ModBlocks.ASTRALON_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.ASTRALON_WOOD.get()), blockTexture(ModBlocks.ASTRALON_LOG.get()),
                blockTexture(ModBlocks.ASTRALON_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ASTRALON_LOG.get()), blockTexture(ModBlocks.STRIPPED_ASTRALON_LOG.get()),
                new ResourceLocation(panitasMod.MOD_ID,"block/stripped_astralon_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ASTRALON_WOOD.get()), blockTexture(ModBlocks.STRIPPED_ASTRALON_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_ASTRALON_LOG.get()));

        blockItem(ModBlocks.ASTRALON_LOG);
        blockItem(ModBlocks.ASTRALON_WOOD);
        blockItem(ModBlocks.STRIPPED_ASTRALON_LOG);
        blockItem(ModBlocks.STRIPPED_ASTRALON_WOOD);

        blockWithItem(ModBlocks.ASTRALON_PLANKS);

        leavesBlock(ModBlocks.ASTRALON_LEAVES);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(panitasMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
