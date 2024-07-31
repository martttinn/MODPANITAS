package net.martin.panitasMod.datagen;

import net.martin.panitasMod.blocks.ModBlocks;
import net.martin.panitasMod.items.ModItems;
import net.martin.panitasMod.panitasMod;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{

    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter)
    {
        // RECETAS CON FORMA ------------------------------------------------------------------------

        // RECETA BLUNT
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUNT.get())
                .pattern("XX")
                .pattern("YY")
                .define('X',ModItems.COGOLLO.get())
                .define('Y',ModItems.HOJA_TABACO.get())
                .unlockedBy(getHasName(ModItems.COGOLLO.get()), has(ModItems.COGOLLO.get()))
                .save(pWriter);

        // RECETA ROLLING_STATION
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROLLING_STATION.get())
                .pattern("XXX")
                .pattern("YYY")
                .pattern("Z Z")
                .define('X',ModItems.BLUNT.get())
                .define('Y',Ingredient.of(Items.OAK_PLANKS))
                .define('Z',Ingredient.of(Items.OAK_SLAB))
                .unlockedBy(getHasName(ModItems.COGOLLO.get()), has(ModItems.COGOLLO.get()))
                .unlockedBy(getHasName(ModItems.HOJA_TABACO.get()), has(ModItems.HOJA_TABACO.get()))
                .save(pWriter);

        // RECETAS SIN FORMA ------------------------------------------------------------------------

        // 9 COGOLLOS -> 1 BLOQUE DE MARIHUANA
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.WEED_BLOCK.get(),1)
                .requires(ModItems.COGOLLO.get(),9)
                .unlockedBy(getHasName(ModItems.COGOLLO.get()), has(ModItems.COGOLLO.get()))
                .save(pWriter);

        // 1 BLOQUE DE MARIHUANA -> 9 COGOLLOS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COGOLLO.get(),9)
                .requires(ModBlocks.WEED_BLOCK.get(),1)
                .unlockedBy(getHasName(ModItems.COGOLLO.get()), has(ModItems.COGOLLO.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, panitasMod.MOD_ID + ":" +  getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


}
