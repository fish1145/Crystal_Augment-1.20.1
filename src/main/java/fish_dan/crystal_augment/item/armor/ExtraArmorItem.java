package fish_dan.crystal_augment.item.armor;

import cofh.core.common.item.ArmorItemCoFH;
import fish_dan.crystal_augment.init.Crystal_AugmentArmorMaterials;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;

public class ExtraArmorItem extends ArmorItemCoFH {

    public ExtraArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return stack.getItem() instanceof ArmorItem && (((ArmorItem) stack.getItem()).getMaterial() == ArmorMaterials.GOLD || ((ArmorItem) stack.getItem()).getMaterial() == Crystal_AugmentArmorMaterials.LUMIUM);
    }
}
