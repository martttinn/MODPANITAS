package net.martin.panitasMod.blocks.custom;

import net.martin.panitasMod.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;


public class WeedCropBlock extends CropBlock {

    public static final int MAX_AGE = 5;

    // SE USA INTEGERPROPPERTY PARA EVITAR QUE TODAS LAS CROPS DE ESTE TIPO MADUREN AL MISMO TIEMPO.
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public WeedCropBlock(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public int getAge(BlockState pState) {
        return pState.getValue(this.getAgeProperty());
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        // Define on which blocks the crop can be planted (e.g., farmland)
        return state.is(Blocks.FARMLAND);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.WEED_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }
}
