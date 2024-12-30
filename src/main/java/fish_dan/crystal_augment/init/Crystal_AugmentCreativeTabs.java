package fish_dan.crystal_augment.init;

import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.item.ToolSetObject;
import fish_dan.crystal_augment.item.augment.EnumAugment;
import fish_dan.crystal_augment.item.augment.ExtraAugmentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Crystal_AugmentCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Crystal_Augment.MOD_ID);

    private static void addToolSet(ToolSetObject set, CreativeModeTab.Output output) {
        output.acceptAll(set.getALLItems().stream().map(obj -> obj.get().asItem()).map(ItemStack::new).toList());
    }

    public static RegistryObject<CreativeModeTab> tab_augments = CREATIVE_TABS.register("augments", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(Crystal_AugmentItems.INDIGO_CRYSTAL_COMPONENT.get()))
            .title(Component.translatable("creative_tab.crystal_augment.augments"))
            .displayItems((feature, output) -> {

                output.accept(Crystal_AugmentItems.INDIGO_CRYSTAL_COMPONENT.get());
                output.accept(Crystal_AugmentItems.PURPLE_AGATE_CRYSTAL_COMPONENT .get());
                output.accept(Crystal_AugmentItems.ADYSS_CRYSTAL_COMPONENT.get());
                output.accept(Crystal_AugmentItems.SKY_BLUE_CRYSTAL_COMPONENT.get());
                output.accept(Crystal_AugmentItems.AMDER_CRYSTAL_COMPONENT.get());



                output.accept(Crystal_AugmentItems.JADE_ITEM_FILTER_AUGMENT.get());

                for(EnumAugment e: EnumAugment.values()) {
                    for(ExtraAugmentType type: ExtraAugmentType.VALUES) {
                        output.accept(Crystal_AugmentItems.AUGMENTS.get(e).get(type).get());
                    }
                }

            })
            .build()
    );

    public static RegistryObject<CreativeModeTab> tab_machines = CREATIVE_TABS.register("machines", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(Crystal_AugmentItems.DYNAMO_COLD.get()))
            .title(Component.translatable("creative_tab.crystal_augment.machines"))
            .displayItems((feature, output) -> {
                output.accept(Crystal_AugmentBlocks.LAVA_GEN.get());
                output.accept(Crystal_AugmentBlocks.DYNAMO_COLD.get());
                output.accept(Crystal_AugmentBlocks.ADVANCED_REFINERY.get());
                output.accept(Crystal_AugmentBlocks.NITRATIC_IGNITER.get());
                output.accept(Crystal_AugmentBlocks.FLUID_MIXER.get());
                output.accept(Crystal_AugmentBlocks.COMPONENT_ASSEMBLY.get());
                output.accept(Crystal_AugmentBlocks.ENDOTHERMIC_DEHYDRATOR.get());
            })
            .build()
    );

    public static RegistryObject<CreativeModeTab> tab_resources = CREATIVE_TABS.register("resources", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(Crystal_AugmentItems.JADE_CRYSTAL.get()))
            .title(Component.translatable("creative_tab.crystal_augment.item_block"))
            .displayItems((feature, output) -> {

                output.accept(Crystal_AugmentItems.JADE_RF_COIL.get());
                output.accept(Crystal_AugmentItems.TOURMALINE_RF_COIL.get());
                output.accept(Crystal_AugmentItems.KUNZITE_RF_COIL.get());
                output.accept(Crystal_AugmentItems.SODALITE_RF_COIL.get());
                output.accept(Crystal_AugmentItems.MORGAN_RF_COIL.get());

                output.accept(Crystal_AugmentItems.JADE_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.TOURMALINE_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.KUNZITE_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.SODALITE_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.MORGAN_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.INDIGO_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.PURPLE_AGATE_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.ADYSS_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.SKY_BLUE_CRYSTAL.get());
                output.accept(Crystal_AugmentItems.AMDER_CRYSTAL.get());


                output.accept(Crystal_AugmentItems.JADE_DUST.get());
                output.accept(Crystal_AugmentItems.TOURMALINE_DUST.get());
                output.accept(Crystal_AugmentItems.KUNZITE_DUST.get());
                output.accept(Crystal_AugmentItems.SODALITE_DUST.get());
                output.accept(Crystal_AugmentItems.MORGAN_DUST.get());
                output.accept(Crystal_AugmentItems.INDIGO_DUST.get());
                output.accept(Crystal_AugmentItems.PURPLE_AGATE_DUST.get());
                output.accept(Crystal_AugmentItems.ADYSS_DUST.get());
                output.accept(Crystal_AugmentItems.SKY_BLUE_DUST.get());
                output.accept(Crystal_AugmentItems.AMDER_DUST.get());


                output.accept(Crystal_AugmentBlocks.JADE_GLASS.get());
                output.accept(Crystal_AugmentBlocks.TOURMALINE_GLASS.get());
                output.accept(Crystal_AugmentBlocks.KUNZITE_GLASS.get());
                output.accept(Crystal_AugmentBlocks.SODALITE_GLASS.get());
                output.accept(Crystal_AugmentBlocks.MORGAN_GLASS.get());
                output.accept(Crystal_AugmentBlocks.INDIGO_GLASS.get());
                output.accept(Crystal_AugmentBlocks.PURPLE_AGATE_GLASS.get());
                output.accept(Crystal_AugmentBlocks.ABYSS_GLASS .get());
                output.accept(Crystal_AugmentBlocks.SKY_BLUE_GLASS.get());
                output.accept(Crystal_AugmentBlocks.AMBER_GLASS.get());



                output.accept(Crystal_AugmentItems.BEEF_JERKY.get());
                output.accept(Crystal_AugmentItems.CHICKEN_JERKY.get());
                output.accept(Crystal_AugmentItems.COD_JERKY.get());
                output.accept(Crystal_AugmentItems.MUTTON_JERKY.get());
                output.accept(Crystal_AugmentItems.PORK_JERKY.get());
                output.accept(Crystal_AugmentItems.RABBIT_JERKY.get());
                output.accept(Crystal_AugmentItems.SALMON_JERKY.get());

                output.accept(Crystal_AugmentItems.COPPER_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.IRON_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.GOLD_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.TIN_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.LEAD_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.SILVER_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.NICKEL_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.ALUMINUM_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.URANIUM_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.OSMIUM_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.ARCANE_GOLD_ORE_CHUNK.get());
                output.accept(Crystal_AugmentItems.ZINC_ORE_CHUNK.get());

                output.accept(Crystal_AugmentItems.ANCIENT_DUST.get());
                output.accept(Crystal_AugmentItems.OBSIDIAN_DUST.get());
                output.accept(Crystal_AugmentItems.AMETHYST_DUST.get());
                output.accept(Crystal_AugmentItems.SOUL_SAND_DUST.get());
                output.accept(Crystal_AugmentItems.STICKY_BALL.get());
                output.accept(Crystal_AugmentItems.CHILLER_PLATE_CAST.get());

                output.accept(Crystal_AugmentItems.SOUL_INFUSED_ROD.get());
                output.accept(Crystal_AugmentItems.TWINITE_ROD.get());
                output.accept(Crystal_AugmentItems.SHELLITE_ROD.get());
                output.accept(Crystal_AugmentItems.DRAGONSTEEL_ROD.get());
                output.accept(Crystal_AugmentItems.ABYSSAL_ROD.get());
                output.accept(Crystal_AugmentItems.COPPER_ROD.get());
                output.accept(Crystal_AugmentItems.IRON_ROD.get());
                output.accept(Crystal_AugmentItems.GOLD_ROD.get());
                output.accept(Crystal_AugmentItems.DIAMOND_ROD.get());
                output.accept(Crystal_AugmentItems.EMERALD_ROD.get());
                output.accept(Crystal_AugmentItems.NETHERITE_ROD.get());
                output.accept(Crystal_AugmentItems.LEAD_ROD.get());
                output.accept(Crystal_AugmentItems.TIN_ROD.get());
                output.accept(Crystal_AugmentItems.SILVER_ROD.get());
                output.accept(Crystal_AugmentItems.NICKEL_ROD.get());
                output.accept(Crystal_AugmentItems.BRONZE_ROD.get());
                output.accept(Crystal_AugmentItems.ELECTRUM_ROD.get());
                output.accept(Crystal_AugmentItems.CONSTANTAN_ROD.get());
                output.accept(Crystal_AugmentItems.INVAR_ROD.get());
                output.accept(Crystal_AugmentItems.SIGNALUM_ROD.get());
                output.accept(Crystal_AugmentItems.LUMIUM_ROD.get());
                output.accept(Crystal_AugmentItems.ENDERIUM_ROD.get());

                addToolSet(Crystal_AugmentItems.SIGNALUM_SET, output);
                addToolSet(Crystal_AugmentItems.LUMIUM_SET, output);
                addToolSet(Crystal_AugmentItems.ENDERIUM_SET, output);

                // metal resources
                output.accept(Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get());
                output.accept(Crystal_AugmentBlocks.SOUL_INFUSED_GLASS.get());
                output.accept(Crystal_AugmentItems.SOUL_INFUSED_INGOT.get());
                output.accept(Crystal_AugmentItems.SOUL_INFUSED_NUGGET.get());
                output.accept(Crystal_AugmentItems.SOUL_INFUSED_DUST.get());
                output.accept(Crystal_AugmentItems.SOUL_INFUSED_PLATE.get());
                output.accept(Crystal_AugmentItems.SOUL_INFUSED_GEAR.get());
                addToolSet(Crystal_AugmentItems.SOUL_INFUSED_SET, output);

                output.accept(Crystal_AugmentBlocks.SHELLITE_BLOCK.get());
                output.accept(Crystal_AugmentBlocks.SHELLITE_GLASS.get());
                output.accept(Crystal_AugmentItems.SHELLITE_INGOT.get());
                output.accept(Crystal_AugmentItems.SHELLITE_NUGGET.get());
                output.accept(Crystal_AugmentItems.SHELLITE_DUST.get());
                output.accept(Crystal_AugmentItems.SHELLITE_PLATE.get());
                output.accept(Crystal_AugmentItems.SHELLITE_GEAR.get());
                addToolSet(Crystal_AugmentItems.SHELLITE_SET, output);

                output.accept(Crystal_AugmentBlocks.TWINITE_BLOCK.get());
                output.accept(Crystal_AugmentBlocks.TWINITE_GLASS.get());
                output.accept(Crystal_AugmentItems.TWINITE_INGOT.get());
                output.accept(Crystal_AugmentItems.TWINITE_NUGGET.get());
                output.accept(Crystal_AugmentItems.TWINITE_DUST.get());
                output.accept(Crystal_AugmentItems.TWINITE_PLATE.get());
                output.accept(Crystal_AugmentItems.TWINITE_GEAR.get());
                addToolSet(Crystal_AugmentItems.TWINITE_SET, output);

                output.accept(Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get());
                output.accept(Crystal_AugmentBlocks.DRAGONSTEEL_GLASS.get());
                output.accept(Crystal_AugmentItems.DRAGONSTEEL_INGOT.get());
                output.accept(Crystal_AugmentItems.DRAGONSTEEL_NUGGET.get());
                output.accept(Crystal_AugmentItems.DRAGONSTEEL_DUST.get());
                output.accept(Crystal_AugmentItems.DRAGONSTEEL_PLATE.get());
                output.accept(Crystal_AugmentItems.DRAGONSTEEL_GEAR.get());
                addToolSet(Crystal_AugmentItems.DRAGONSTEEL_SET, output);

                output.accept(Crystal_AugmentBlocks.ABYSSAL_BLOCK.get());
                output.accept(Crystal_AugmentBlocks.ABYSSAL_GLASS.get());
                output.accept(Crystal_AugmentItems.ABYSSAL_INGOT.get());
                output.accept(Crystal_AugmentItems.ABYSSAL_NUGGET.get());
                output.accept(Crystal_AugmentItems.ABYSSAL_DUST.get());
                output.accept(Crystal_AugmentItems.ABYSSAL_PLATE.get());
                output.accept(Crystal_AugmentItems.ABYSSAL_GEAR.get());
                addToolSet(Crystal_AugmentItems.ABYSSAL_SET, output);

                output.accept(Crystal_AugmentFluids.POLYOLEFIN.getBucket().get());
                output.accept(Crystal_AugmentFluids.FLUX_INFUSED_OIL.getBucket().get());
                output.accept(Crystal_AugmentFluids.DIESEL.getBucket().get());
                output.accept(Crystal_AugmentFluids.MOLTEN_DRAGONSTEEL.getBucket().get());
                output.accept(Crystal_AugmentFluids.MOLTEN_TWINITE.getBucket().get());
                output.accept(Crystal_AugmentFluids.MOLTEN_SHELLITE.getBucket().get());
                output.accept(Crystal_AugmentFluids.MOLTEN_SOUL_INFUSED.getBucket().get());
                output.accept(Crystal_AugmentFluids.SUNFLOWER_OIL.getBucket().get());
                output.accept(Crystal_AugmentFluids.CRYSTALLIZED_SUNFLOWER_OIL.getBucket().get());
                output.accept(Crystal_AugmentFluids.REFINED_SUNFLOWER_OIL.getBucket().get());

                output.accept(Crystal_AugmentFluids.RAW_ALUMINUM.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_ARCANE_GOLD.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_COPPER.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_GOLD.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_IRON.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_LEAD.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_NICKEL.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_OSMIUM.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_SILVER.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_TIN.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_URANIUM.getBucket().get());
                output.accept(Crystal_AugmentFluids.RAW_ZINC.getBucket().get());

                output.accept(Crystal_AugmentItems.ARCANE_GOLD_DUST.get());
                output.accept(Crystal_AugmentItems.ZINC_DUST.get());
                output.accept(Crystal_AugmentItems.AUGMENT_TEMPLATE.get());
            })
            .build()
    );
}
