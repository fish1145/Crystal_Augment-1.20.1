package fish_dan.crystal_augment.data;

import cofh.lib.init.data.ItemModelProviderCoFH;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.init.Crystal_AugmentBlocks;
import fish_dan.crystal_augment.init.Crystal_AugmentFluids;
import fish_dan.crystal_augment.init.Crystal_AugmentItems;
import fish_dan.crystal_augment.item.ToolSetObject;
import fish_dan.crystal_augment.item.augment.EnumAugment;
import fish_dan.crystal_augment.item.augment.ExtraAugmentType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class ExtraModelGen extends ItemModelProviderCoFH {

    public ExtraModelGen(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Crystal_Augment.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemModel(Crystal_AugmentItems.BEEF_JERKY);
        itemModel(Crystal_AugmentItems.CHICKEN_JERKY);
        itemModel(Crystal_AugmentItems.COD_JERKY);
        itemModel(Crystal_AugmentItems.MUTTON_JERKY);
        itemModel(Crystal_AugmentItems.PORK_JERKY);
        itemModel(Crystal_AugmentItems.RABBIT_JERKY);
        itemModel(Crystal_AugmentItems.SALMON_JERKY);
        itemModel(Crystal_AugmentItems.AUGMENT_TEMPLATE);

        itemModel(Crystal_AugmentItems.ANCIENT_DUST);
        itemModel(Crystal_AugmentItems.OBSIDIAN_DUST);
        itemModel(Crystal_AugmentItems.PRESS_ROD_DIE);

        itemModel(Crystal_AugmentItems.SOUL_INFUSED_ROD);
        itemModel(Crystal_AugmentItems.TWINITE_ROD);
        itemModel(Crystal_AugmentItems.SHELLITE_ROD);
        itemModel(Crystal_AugmentItems.DRAGONSTEEL_ROD);
        itemModel(Crystal_AugmentItems.ABYSSAL_ROD);
        itemModel(Crystal_AugmentItems.COPPER_ROD);
        itemModel(Crystal_AugmentItems.IRON_ROD);
        itemModel(Crystal_AugmentItems.GOLD_ROD);
        itemModel(Crystal_AugmentItems.DIAMOND_ROD);
        itemModel(Crystal_AugmentItems.EMERALD_ROD);
        itemModel(Crystal_AugmentItems.NETHERITE_ROD);
        itemModel(Crystal_AugmentItems.LEAD_ROD);
        itemModel(Crystal_AugmentItems.TIN_ROD);
        itemModel(Crystal_AugmentItems.SILVER_ROD);
        itemModel(Crystal_AugmentItems.NICKEL_ROD);
        itemModel(Crystal_AugmentItems.BRONZE_ROD);
        itemModel(Crystal_AugmentItems.ELECTRUM_ROD);
        itemModel(Crystal_AugmentItems.CONSTANTAN_ROD);
        itemModel(Crystal_AugmentItems.INVAR_ROD);
        itemModel(Crystal_AugmentItems.SIGNALUM_ROD);
        itemModel(Crystal_AugmentItems.LUMIUM_ROD);
        itemModel(Crystal_AugmentItems.ENDERIUM_ROD);

        itemModel(Crystal_AugmentItems.COPPER_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.IRON_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.GOLD_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.TIN_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.LEAD_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.SILVER_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.NICKEL_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.ALUMINUM_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.URANIUM_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.OSMIUM_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.ARCANE_GOLD_ORE_CHUNK);
        itemModel(Crystal_AugmentItems.ZINC_ORE_CHUNK);

        for(EnumAugment e: EnumAugment.values()) {
            for (ExtraAugmentType type : ExtraAugmentType.VALUES) {
                itemModel(Crystal_AugmentItems.AUGMENTS.get(e).get(type),
                        new ResourceLocation(Crystal_Augment.MOD_ID, "item/%s/%s".formatted(type.name().toLowerCase(Locale.ROOT), e.name().toLowerCase(Locale.ROOT))));
            }
        }

        toolset(Crystal_AugmentItems.SIGNALUM_SET);
        toolset(Crystal_AugmentItems.LUMIUM_SET);
        toolset(Crystal_AugmentItems.ENDERIUM_SET);

        itemModel(Crystal_AugmentItems.SOUL_INFUSED_INGOT);
        itemModel(Crystal_AugmentItems.SOUL_INFUSED_GEAR);
        itemModel(Crystal_AugmentItems.SOUL_INFUSED_DUST);
        itemModel(Crystal_AugmentItems.SOUL_INFUSED_NUGGET);
        toolset(Crystal_AugmentItems.SOUL_INFUSED_SET);

        itemModel(Crystal_AugmentItems.SHELLITE_INGOT);
        itemModel(Crystal_AugmentItems.SHELLITE_GEAR);
        itemModel(Crystal_AugmentItems.SHELLITE_DUST);
        itemModel(Crystal_AugmentItems.SHELLITE_NUGGET);
        toolset(Crystal_AugmentItems.SHELLITE_SET);

        itemModel(Crystal_AugmentItems.TWINITE_INGOT);
        itemModel(Crystal_AugmentItems.TWINITE_GEAR);
        itemModel(Crystal_AugmentItems.TWINITE_DUST);
        itemModel(Crystal_AugmentItems.TWINITE_NUGGET);
        toolset(Crystal_AugmentItems.TWINITE_SET);

        itemModel(Crystal_AugmentItems.DRAGONSTEEL_GEAR);
        itemModel(Crystal_AugmentItems.DRAGONSTEEL_INGOT);
        itemModel(Crystal_AugmentItems.DRAGONSTEEL_DUST);
        itemModel(Crystal_AugmentItems.DRAGONSTEEL_NUGGET);
        toolset(Crystal_AugmentItems.DRAGONSTEEL_SET);

        itemModel(Crystal_AugmentItems.ABYSSAL_GEAR);
        itemModel(Crystal_AugmentItems.ABYSSAL_INGOT);
        itemModel(Crystal_AugmentItems.ABYSSAL_DUST);
        itemModel(Crystal_AugmentItems.ABYSSAL_NUGGET);
        toolset(Crystal_AugmentItems.ABYSSAL_SET);

        itemModel(Crystal_AugmentItems.ARCANE_GOLD_DUST);
        itemModel(Crystal_AugmentItems.ZINC_DUST);
        itemModel(Crystal_AugmentItems.SOUL_SAND_DUST);
        itemModel(Crystal_AugmentItems.AMETHYST_DUST);
        itemModel(Crystal_AugmentItems.STICKY_BALL);
        itemModel(Crystal_AugmentItems.CHILLER_PLATE_CAST);

        itemModel(Crystal_AugmentItems.JADE_ITEM_FILTER_AUGMENT);

        itemModel(Crystal_AugmentFluids.CRYSTALLIZED_SUNFLOWER_OIL.getBucket());
        itemModel(Crystal_AugmentFluids.SUNFLOWER_OIL.getBucket());
        itemModel(Crystal_AugmentFluids.CRYSTALLIZED_SUNFLOWER_OIL.getBucket());
        itemModel(Crystal_AugmentFluids.REFINED_SUNFLOWER_OIL.getBucket());
        itemModel(Crystal_AugmentFluids.MOLTEN_ABYSSAL.getBucket());
        itemModel(Crystal_AugmentFluids.MOLTEN_SOUL_INFUSED.getBucket());
        itemModel(Crystal_AugmentFluids.MOLTEN_SHELLITE.getBucket());
        itemModel(Crystal_AugmentFluids.MOLTEN_TWINITE.getBucket());
        itemModel(Crystal_AugmentFluids.MOLTEN_DRAGONSTEEL.getBucket());
        itemModel(Crystal_AugmentFluids.FLUX_INFUSED_OIL.getBucket());
        itemModel(Crystal_AugmentFluids.DIESEL.getBucket());
        itemModel(Crystal_AugmentFluids.POLYOLEFIN.getBucket());

        itemModel(Crystal_AugmentFluids.RAW_ALUMINUM.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_ARCANE_GOLD.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_COPPER.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_GOLD.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_IRON.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_LEAD.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_NICKEL.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_OSMIUM.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_SILVER.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_TIN.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_URANIUM.getBucket());
        itemModel(Crystal_AugmentFluids.RAW_ZINC.getBucket());

        blockItem(Crystal_AugmentBlocks.DYNAMO_COLD);
    }

    private void toolset(ToolSetObject set) {
        handheld(set.axe());
        handheld(set.pickaxe());
        handheld(set.shovel());
        handheld(set.hoe());
        handheld(set.sword());
        handheld(set.excavator());
        handheld(set.hammer());
        handheld(set.knife());
        handheld(set.sickle());
        generated(set.helmet());
        generated(set.chestplate());
        generated(set.leggings());
        generated(set.boots());
    }

    public void itemModel(RegistryObject<? extends Item> registryObject) {
        this.itemModel(registryObject, "item/generated");
    }

    private void itemModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void itemModel(RegistryObject<? extends Item> registryObject, ResourceLocation textureLoc) {
        this.itemModel(registryObject, "item/generated", textureLoc);
    }

    private void itemModel(RegistryObject<? extends Item> registryObject, String model, ResourceLocation textureLoc) {
        ResourceLocation id = registryObject.getId();
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLoc);
    }
}
