package fish_dan.crystal_augment.recipe;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.api.fluid.IFluidStackHolder;
import cofh.lib.api.inventory.IItemStackHolder;
import cofh.lib.util.crafting.ComparableItemStack;
import cofh.thermal.core.common.item.SlotSealItem;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.IMachineRecipe;
import cofh.thermal.lib.util.recipes.internal.SimpleMachineRecipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.*;

import static java.util.Arrays.asList;

public class EndothermicDehydratorRecipeManager extends AbstractManager implements IRecipeManager {

    private static final EndothermicDehydratorRecipeManager INSTANCE = new EndothermicDehydratorRecipeManager();
    protected static final int DEFAULT_ENERGY = 4000;

    protected Map<List<Integer>, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Set<Fluid> validFluids = new ObjectOpenHashSet<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

    protected int maxOutputItems;
    protected int maxOutputFluids;

    public static EndothermicDehydratorRecipeManager instance() {

        return INSTANCE;
    }

    private EndothermicDehydratorRecipeManager() {

        super(DEFAULT_ENERGY);
        this.maxOutputItems = 6;
        this.maxOutputFluids = 1;
    }

    public boolean validItem(ItemStack item) {

        return validItems.contains(makeComparable(item));
    }

    public boolean validFluid(FluidStack fluid) {

        return validFluids.contains(fluid.getFluid());
    }

    protected void clear() {

        recipeMap.clear();
        validFluids.clear();
        validItems.clear();
    }

    // region RECIPES
    public void addRecipe(ThermalRecipe recipe) {

        if (!recipe.getInputFluids().isEmpty()) {
            for (FluidStack fluidInput : recipe.getInputFluids().get(0).getFluids()) {
                if (!recipe.getInputItems().isEmpty()) {
                    for (ItemStack recipeInput : recipe.getInputItems().get(0).getItems()) {
                        addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.singletonList(recipeInput), Collections.singletonList(fluidInput), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                    }
                } else {
                    addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.emptyList(), Collections.singletonList(fluidInput), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
                }
            }
        } else if (!recipe.getInputItems().isEmpty()) {
            for (ItemStack recipeInput : recipe.getInputItems().get(0).getItems()) {
                addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.singletonList(recipeInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids());
            }
        }
    }

    // region RECIPES
    protected IMachineRecipe getRecipe(List<? extends IItemStackHolder> inputSlots, List<? extends IFluidStackHolder> inputTanks) {

        if (inputSlots.isEmpty() && inputTanks.isEmpty() || inputSlots.get(0).isEmpty() && inputTanks.get(0).isEmpty()) {
            return null;
        }
        if (inputTanks.isEmpty() || inputTanks.get(0).isEmpty()) {
            ItemStack inputItem = inputSlots.get(0).getItemStack();
            return recipeMap.get(Collections.singletonList(makeComparable(inputItem).hashCode()));
        }
        if (inputSlots.isEmpty() || inputSlots.get(0).isEmpty() || inputSlots.get(0).getItemStack().getItem() instanceof SlotSealItem) {
            FluidStack inputFluid = inputTanks.get(0).getFluidStack();
            return recipeMap.get(Collections.singletonList(FluidHelper.fluidHashcode(inputFluid)));
        }
        ItemStack inputItem = inputSlots.get(0).getItemStack();
        FluidStack inputFluid = inputTanks.get(0).getFluidStack();
        return recipeMap.get(asList(makeComparable(inputItem).hashCode(), FluidHelper.fluidHashcode(inputFluid)));
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> chance, List<FluidStack> outputFluids) {

        if (inputItems.isEmpty() && inputFluids.isEmpty() || outputItems.size() > maxOutputItems || outputFluids.size() > maxOutputFluids || energy <= 0) {
            return null;
        }
        List<Integer> key;
        if (inputFluids.isEmpty()) {
            ItemStack inputItem = inputItems.get(0);
            if (inputItem.isEmpty()) {
                return null;
            }
            validItems.add(makeComparable(inputItem));
            key = Collections.singletonList(makeComparable(inputItem).hashCode());
        } else if (inputItems.isEmpty()) {
            FluidStack inputFluid = inputFluids.get(0);
            if (inputFluid.isEmpty()) {
                return null;
            }
            validFluids.add(inputFluid.getFluid());
            key = Collections.singletonList(FluidHelper.fluidHashcode(inputFluid));
        } else {
            ItemStack inputItem = inputItems.get(0);
            if (inputItem.isEmpty()) {
                return null;
            }
            FluidStack inputFluid = inputFluids.get(0);
            if (inputFluid.isEmpty()) {
                return null;
            }
            validItems.add(makeComparable(inputItem));
            validFluids.add(inputFluid.getFluid());
            key = asList(makeComparable(inputItem).hashCode(), FluidHelper.fluidHashcode(inputFluid));
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        energy = (int) (energy * getDefaultScale());

        SimpleMachineRecipe recipe = new SimpleMachineRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        recipeMap.put(key, recipe);
        return recipe;
    }
    // endregion

    // region IRecipeManager
    @Override
    public IMachineRecipe getRecipe(IThermalInventory inventory) {

        return getRecipe(inventory.inputSlots(), inventory.inputTanks());
    }

    @Override
    public List<IMachineRecipe> getRecipeList() {

        return new ArrayList<>(recipeMap.values());
    }
    // endregion

    // region IManager
    @Override
    public void refresh(RecipeManager recipeManager) {

        clear();
        var recipes = recipeManager.getAllRecipesFor(Crystal_AugmentRecipeTypes.ENDOTHERMIC_DEHYDRATOR.get());
        for (var entry : recipes) {
            addRecipe(entry);
        }
    }
    // endregion
}
