package fish_dan.crystal_augment.recipe;

import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeSerializers;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nonnull;

public class NitraticIgniterCatalyst extends ThermalCatalyst {

    public NitraticIgniterCatalyst(ResourceLocation recipeId, Ingredient ingredient, float primaryMod, float secondaryMod, float energyMod, float minChance, float useChance) {

        super(recipeId, ingredient, primaryMod, secondaryMod, energyMod, minChance, useChance);
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getSerializer() {

        return Crystal_AugmentRecipeSerializers.NITRATIC_IGNITER_CATALYST_SERIALIZER.get();
    }

    @Nonnull
    @Override
    public RecipeType<?> getType() {

        return Crystal_AugmentRecipeTypes.NITRATIC_IGNITER_CATALYST.get();
    }

}
