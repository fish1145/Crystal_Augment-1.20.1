package fish_dan.crystal_augment.init;

import fish_dan.crystal_augment.recipe.*;

import static cofh.thermal.lib.util.ThermalRecipeManagers.registerManager;

public class Crystal_AugmentRecipeManagers {

    public static void register() {
        registerManager(ColdFuelManager.instance());
        registerManager(AdvancedRefineryRecipeManager.instance());
        registerManager(NitraticIgniterRecipeManager.instance());
        registerManager(FluidMixerRecipeManager.instance());
        registerManager(ComponentAssemblyRecipeManager.instance());
        registerManager(EndothermicDehydratorRecipeManager.instance());
    }
}
