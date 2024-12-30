package fish_dan.crystal_augment.compat.jei.category;


import cofh.thermal.lib.compat.jei.ThermalCatalystCategory;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import fish_dan.crystal_augment.init.Crystal_AugmentBlocks;
import fish_dan.crystal_augment.recipe.NitraticIgniterCatalyst;
import net.minecraft.world.item.ItemStack;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;

public class NitraticIgniterCatalystCategory extends ThermalCatalystCategory<NitraticIgniterCatalyst> {

    public NitraticIgniterCatalystCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<NitraticIgniterCatalyst> type) {

        super(guiHelper, icon, type);

        name = getTextComponent(Crystal_AugmentBlocks.BLOCKS.get("nitratic_igniter").getDescriptionId()).append(": ").append(getTextComponent("info.thermal.catalysts"));
    }

    @Override
    public RecipeType<NitraticIgniterCatalyst> getRecipeType() {

        return type;
    }

}
