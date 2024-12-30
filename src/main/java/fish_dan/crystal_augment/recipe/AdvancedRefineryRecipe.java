package fish_dan.crystal_augment.recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeSerializers;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;

public class AdvancedRefineryRecipe extends ThermalRecipe {

    public AdvancedRefineryRecipe(ResourceLocation recipeId, int energy, float experience, List<Ingredient> inputItems, List<FluidIngredient> inputFluids, List<ItemStack> outputItems, List<Float> outputItemChances, List<FluidStack> outputFluids) {

        super(recipeId, energy, experience, inputItems, inputFluids, outputItems, outputItemChances, outputFluids);

        if (this.energy <= 0) {
            int defaultEnergy = AdvancedRefineryRecipeManager.instance().getDefaultEnergy();
            ThermalCore.LOG.warn("Energy value for " + recipeId + " was out of allowable range and has been set to a default value of " + defaultEnergy + ".");
            this.energy = defaultEnergy;
        }
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getSerializer() {
        return Crystal_AugmentRecipeSerializers.ADVANCED_REFINERY_RECIPE_SERIALIZER.get();
    }

    @Nonnull
    @Override
    public RecipeType<?> getType() {

        return Crystal_AugmentRecipeTypes.ADVANCED_REFINERY.get();
    }

}
