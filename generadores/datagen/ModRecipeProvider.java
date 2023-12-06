package net.frizzkop.kamumod.datagen;

import net.frizzkop.kamumod.block.ModBlocks;
import net.frizzkop.kamumod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }



    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOQUE_PRUEBA.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.WEED_BUD.get())
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_BUD.get(), 9)
                .requires(ModBlocks.BLOQUE_PRUEBA.get())
                .unlockedBy(getHasName(ModBlocks.BLOQUE_PRUEBA.get()), has(ModBlocks.BLOQUE_PRUEBA.get()))
                .save(pWriter);

    }
}
