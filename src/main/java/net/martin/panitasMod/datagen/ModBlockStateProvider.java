package net.martin.panitasMod.datagen;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.panitasMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, panitasMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(ModBlocks.WEED_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
