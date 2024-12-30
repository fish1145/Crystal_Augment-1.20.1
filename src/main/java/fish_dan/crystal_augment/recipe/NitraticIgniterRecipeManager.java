package fish_dan.crystal_augment.recipe;

import cofh.lib.api.fluid.IFluidStackHolder;
import cofh.lib.api.inventory.IItemStackHolder;
import cofh.lib.util.crafting.ComparableItemStack;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.CatalyzedRecipeManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalCatalyst;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.*;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import fish_dan.crystal_augment.init.Crystal_AugmentRecipeTypes;
import fish_dan.crystal_augment.util.CompoundMapWrapper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.*;

import static java.util.Arrays.asList;

public class NitraticIgniterRecipeManager extends AbstractManager implements IRecipeManager, CatalyzedRecipeManager {

    private static final NitraticIgniterRecipeManager INSTANCE = new NitraticIgniterRecipeManager();
    protected static final int DEFAULT_ENERGY = 3200;

    protected Map<CompoundMapWrapper, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Map<ComparableItemStack, IRecipeCatalyst> catalystMap = new Object2ObjectOpenHashMap<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();

    protected int maxInputItems;
    protected int maxOutputItems;
    protected int maxOutputFluids;

    public static NitraticIgniterRecipeManager instance() {

        return INSTANCE;
    }

    private NitraticIgniterRecipeManager() {

        super(DEFAULT_ENERGY);
        this.maxInputItems = 3;
        this.maxOutputItems = 4;
        this.maxOutputFluids = 0;
    }

    public void addRecipe(ThermalRecipe recipe, BaseMachineRecipe.RecipeType type) {

        switch (recipe.getInputItems().size()) {
            case 1 -> {
                for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                    addRecipe(recipe.getEnergy(), recipe.getXp(), Collections.singletonList(firstInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids(), type);
                }
            }
            case 2 -> {
                for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                    for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                        addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids(), type);
                    }
                }
            }
            case 3 -> {
                for (ItemStack firstInput : recipe.getInputItems().get(0).getItems()) {
                    for (ItemStack secondInput : recipe.getInputItems().get(1).getItems()) {
                        for (ItemStack thirdInput : recipe.getInputItems().get(2).getItems()) {
                            addRecipe(recipe.getEnergy(), recipe.getXp(), asList(firstInput, secondInput, thirdInput), Collections.emptyList(), recipe.getOutputItems(), recipe.getOutputItemChances(), recipe.getOutputFluids(), type);
                        }
                    }
                }
            }
            default -> {
            }
        }
    }

    public boolean validItem(ItemStack item) {

        return validItems.contains(makeNBTComparable(item)) || validItems.contains(makeComparable(item));
    }

    protected void clear() {

        recipeMap.clear();
        catalystMap.clear();
        validItems.clear();
    }

    // region RECIPES
    protected IMachineRecipe getRecipe(List<? extends IItemStackHolder> inputSlots, List<? extends IFluidStackHolder> inputTanks) {

        if (inputSlots.isEmpty()) {
            return null;
        }
        List<ComparableItemStack> convertedItems = new ArrayList<>(maxInputItems);
        for (int i = 0; i < maxInputItems; ++i) {
            if (!inputSlots.get(i).isEmpty()) {
                ComparableItemStack compStack = makeNBTComparable(inputSlots.get(i).getItemStack());
                convertedItems.add(compStack);
            }
        }
        if (convertedItems.isEmpty()) {
            return null;
        }
        IMachineRecipe ret = recipeMap.get(CompoundMapWrapper.of(convertedItems));

        if (ret == null) {
            convertedItems.clear();
            for (int i = 0; i < maxInputItems; ++i) {
                if (!inputSlots.get(i).isEmpty()) {
                    ComparableItemStack compStack = makeComparable(inputSlots.get(i).getItemStack());
                    convertedItems.add(compStack);
                }
            }
            if (convertedItems.isEmpty()) {
                return null;
            }
            ret = recipeMap.get(CompoundMapWrapper.of(convertedItems));
        }
        return ret;
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<FluidStack> inputFluids, List<ItemStack> outputItems, List<Float> chance, List<FluidStack> outputFluids, BaseMachineRecipe.RecipeType type) {

        if (inputItems.isEmpty() || outputItems.isEmpty() || outputItems.size() > maxOutputItems || outputFluids.size() > maxOutputFluids || energy <= 0) {
            return null;
        }
        for (ItemStack stack : inputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        List<ComparableItemStack> convertedItems = new ArrayList<>(inputItems.size());
        for (ItemStack stack : inputItems) {
            if (!inputItems.isEmpty()) {
                ComparableItemStack compStack = type == BaseMachineRecipe.RecipeType.DISENCHANT ? makeComparable(stack) : makeNBTComparable(stack);
                validItems.add(compStack);
                convertedItems.add(compStack);
            }
        }
        energy = (int) (energy * getDefaultScale());

        IMachineRecipe recipe;
        if (type == BaseMachineRecipe.RecipeType.DISENCHANT) {
            recipe = new DisenchantMachineRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        } else {
            recipe = new InternalNitraticIgniterRecipe(energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        }
        recipeMap.put(CompoundMapWrapper.of(convertedItems), recipe);
        return recipe;
    }
    // endregion

    @Override
    public List<ItemStack> getCatalysts() {

        List<ItemStack> ret = new ArrayList<>(catalystMap.size());
        catalystMap.keySet().forEach(stack -> ret.add(stack.toItemStack()));
        return ret;
    }

    // region CATALYSTS
    @Override
    public IRecipeCatalyst getCatalyst(IItemStackHolder input) {

        return catalystMap.get(makeNBTComparable(input.getItemStack()));
    }

    @Override
    public IRecipeCatalyst getCatalyst(ItemStack input) {

        return catalystMap.get(makeNBTComparable(input));
    }

    public void addCatalyst(ThermalCatalyst catalyst) {

        for (ItemStack ingredient : catalyst.getIngredient().getItems()) {
            addCatalyst(ingredient, catalyst.getPrimaryMod(), catalyst.getSecondaryMod(), catalyst.getEnergyMod(), catalyst.getMinChance(), catalyst.getUseChance());
        }
    }

    public IRecipeCatalyst addCatalyst(ItemStack input, float primaryMod, float secondaryMod, float energyMod, float minChance, float useChance) {

        if (input == null || input.isEmpty()) {
            return null;
        }
        BaseMachineCatalyst catalyst = new BaseMachineCatalyst(primaryMod, secondaryMod, energyMod, minChance, useChance);
        catalystMap.put(makeNBTComparable(input), catalyst);
        return catalyst;
    }

    public boolean validCatalyst(ItemStack input) {

        return getCatalyst(input) != null;
    }

    public IRecipeCatalyst removeCatalyst(ItemStack input) {

        return catalystMap.remove(makeNBTComparable(input));
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
        var recipes = recipeManager.getAllRecipesFor(Crystal_AugmentRecipeTypes.NITRATIC_IGNITER.get());
        for (var entry : recipes) {
            addRecipe(entry, BaseMachineRecipe.RecipeType.CATALYZED);
        }
        var catalysts = recipeManager.getAllRecipesFor(Crystal_AugmentRecipeTypes.NITRATIC_IGNITER_CATALYST.get());
        for (var entry : catalysts) {
            addCatalyst(entry);
        }
    }
    // endregion

    // endregion

    // region CATALYZED RECIPE
    protected static class InternalNitraticIgniterRecipe extends CatalyzedMachineRecipe {

        public InternalNitraticIgniterRecipe(int energy, float experience, @Nullable List<ItemStack> inputItems, @Nullable List<FluidStack> inputFluids, @Nullable List<ItemStack> outputItems, @Nullable List<Float> chance, @Nullable List<FluidStack> outputFluids) {

            super(3, energy, experience, inputItems, inputFluids, outputItems, chance, outputFluids);
        }

        @Override
        public IRecipeCatalyst getCatalyst(ItemStack input) {

            return instance().getCatalyst(input);
        }

    }
    // endregion
}
