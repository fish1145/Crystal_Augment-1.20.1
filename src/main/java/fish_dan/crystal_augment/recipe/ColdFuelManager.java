package fish_dan.crystal_augment.recipe;

import cofh.thermal.lib.util.managers.SingleItemFuelManager;
import cofh.thermal.lib.util.recipes.internal.IDynamoFuel;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

public class ColdFuelManager extends SingleItemFuelManager {

    private static final ColdFuelManager INSTANCE = new ColdFuelManager();
    protected static final int DEFAULT_ENERGY = 16000;

    public static ColdFuelManager instance() {

        return INSTANCE;
    }

    private ColdFuelManager() {

        super(DEFAULT_ENERGY);
    }

    public int getEnergy(ItemStack stack) {

        IDynamoFuel fuel = getFuel(stack);
        return fuel != null ? fuel.getEnergy() : 0;
    }

    // region IManager
    @Override
    public void refresh(RecipeManager recipeManager) {

        clear();
        var recipes = recipeManager.getAllRecipesFor(Crystal_AugmentRecipeTypes.COLD_FUEL.get());
        if(!recipes.isEmpty()) {
            for (var entry : recipes) {
                addFuel(entry);
            }
        }
    }
    // endregion
}
