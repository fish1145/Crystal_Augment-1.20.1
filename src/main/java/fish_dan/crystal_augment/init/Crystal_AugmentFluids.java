package fish_dan.crystal_augment.init;

import cofh.lib.util.DeferredRegisterCoFH;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.fluid.FluidCrystal_Augment;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;

public class Crystal_AugmentFluids {
    public static final DeferredRegisterCoFH<Fluid> FLUIDS = DeferredRegisterCoFH.create(ForgeRegistries.FLUIDS, Crystal_Augment.MOD_ID);
    public static final DeferredRegisterCoFH<FluidType> FLUID_TYPES = DeferredRegisterCoFH.create(ForgeRegistries.Keys.FLUID_TYPES, Crystal_Augment.MOD_ID);

    public static FluidCrystal_Augment MOLTEN_SOUL_INFUSED = registerFluid("soul_infused", 1000);
    public static FluidCrystal_Augment MOLTEN_SHELLITE = registerFluid("shellite", 1100);
    public static FluidCrystal_Augment MOLTEN_TWINITE = registerFluid("twinite", 1300);
    public static FluidCrystal_Augment MOLTEN_DRAGONSTEEL = registerFluid("dragonsteel", 1500);
    public static FluidCrystal_Augment MOLTEN_ABYSSAL = registerFluid("abyssal", 1500);
    public static FluidCrystal_Augment SUNFLOWER_OIL = registerFluid("sunflower_oil", 400);
    public static FluidCrystal_Augment CRYSTALLIZED_SUNFLOWER_OIL = registerFluid("crystallized_sunflower_oil", 500);
    public static FluidCrystal_Augment REFINED_SUNFLOWER_OIL = registerFluid("refined_sunflower_oil", 500);
    public static FluidCrystal_Augment FLUX_INFUSED_OIL = registerFluid("flux_infused_oil", 500);
    public static FluidCrystal_Augment DIESEL = registerFluid("diesel", 1000);
    public static FluidCrystal_Augment POLYOLEFIN = registerFluid("polyolefin", 500);
    public static FluidCrystal_Augment RAW_ALUMINUM = registerFluid("raw_aluminum", 500);
    public static FluidCrystal_Augment RAW_ARCANE_GOLD = registerFluid("raw_arcane_gold", 500);
    public static FluidCrystal_Augment RAW_COPPER = registerFluid("raw_copper", 500);
    public static FluidCrystal_Augment RAW_GOLD = registerFluid("raw_gold", 500);
    public static FluidCrystal_Augment RAW_IRON = registerFluid("raw_iron", 500);
    public static FluidCrystal_Augment RAW_LEAD = registerFluid("raw_lead", 500);
    public static FluidCrystal_Augment RAW_NICKEL = registerFluid("raw_nickel", 500);
    public static FluidCrystal_Augment RAW_OSMIUM = registerFluid("raw_osmium", 500);
    public static FluidCrystal_Augment RAW_SILVER = registerFluid("raw_silver", 500);
    public static FluidCrystal_Augment RAW_TIN = registerFluid("raw_tin", 500);
    public static FluidCrystal_Augment RAW_URANIUM = registerFluid("raw_uranium", 500);
    public static FluidCrystal_Augment RAW_ZINC = registerFluid("raw_zinc", 500);

    public static FluidCrystal_Augment registerFluid(String name, int temp) {
        return new FluidCrystal_Augment(name, String.format("thermal_extra:block/fluids/%s_still", name), String.format("thermal:block/fluids/%s_flow", name), temp);
    }
}
