package fish_dan.crystal_augment.recipe;

import cofh.lib.common.fluid.FluidIngredient;
import cofh.lib.util.helpers.MathHelper;
import cofh.thermal.lib.util.recipes.ThermalFuel;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeSerializers;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ColdFuel extends ThermalFuel {

    public ColdFuel(ResourceLocation recipeId, int energy, @Nullable List<Ingredient> inputItems, @Nullable List<FluidIngredient> inputFluids) {

        super(recipeId, energy, inputItems, inputFluids);

        int minEnergy = ColdFuelManager.MIN_ENERGY;
        int maxEnergy = ColdFuelManager.MAX_ENERGY;

        if (this.energy < minEnergy || this.energy > maxEnergy) {
            Crystal_Augment.LOGGER.warn("Energy value for " + recipeId + " was out of allowable range and has been clamped between + " + minEnergy + " and " + maxEnergy + ".");
            this.energy = MathHelper.clamp(this.energy, minEnergy, maxEnergy);
        }
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getSerializer() {

        return Crystal_AugmentRecipeSerializers.COLD_FUEL_SERIALIZER.get();
    }

    @Nonnull
    @Override
    public RecipeType<?> getType() {

        return Crystal_AugmentRecipeTypes.COLD_FUEL.get();
    }
}
