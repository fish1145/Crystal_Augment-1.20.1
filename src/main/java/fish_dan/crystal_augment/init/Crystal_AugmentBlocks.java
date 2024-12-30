package fish_dan.crystal_augment.init;

import cofh.core.common.block.EntityBlockActive4Way;
import cofh.core.common.item.ItemCoFH;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.thermal.core.common.block.HardenedGlassBlock;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.block.DynamoBlock;
import cofh.thermal.lib.common.item.BlockItemAugmentable;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.block.entity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static cofh.lib.util.Utils.itemProperties;
import static cofh.lib.util.constants.BlockStatePropertiesCoFH.ACTIVE;
import static cofh.lib.util.constants.ModIds.ID_THERMAL;
import static cofh.lib.util.helpers.BlockHelper.lightValue;
import static cofh.thermal.lib.util.ThermalAugmentRules.MACHINE_VALIDATOR;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;

public class Crystal_AugmentBlocks {

    public static DeferredRegisterCoFH<Block> BLOCKS = DeferredRegisterCoFH.create(ForgeRegistries.BLOCKS, Crystal_Augment.MOD_ID);


    public static RegistryObject<Block> JADE_GLASS = registerGlass("jade_glass");
    public static RegistryObject<Block> TOURMALINE_GLASS = registerGlass("tourmaline_glass");
    public static RegistryObject<Block> KUNZITE_GLASS = registerGlass("kunzite_glass");
    public static RegistryObject<Block> SODALITE_GLASS = registerGlass("sodalite_glass");
    public static RegistryObject<Block> MORGAN_GLASS = registerGlass("morgan_glass");
    public static RegistryObject<Block> INDIGO_GLASS = registerGlass("indigo_glass");
    public static RegistryObject<Block> PURPLE_AGATE_GLASS = registerGlass("purple_agate_glass");
    public static RegistryObject<Block> ABYSS_GLASS = registerGlass("abyss_glass");
    public static RegistryObject<Block> SKY_BLUE_GLASS = registerGlass("sky_blue_glass");
    public static RegistryObject<Block> AMBER_GLASS = registerGlass("amber_glass");


    public static RegistryObject<Block> SOUL_INFUSED_BLOCK = register("soul_infused_block");
    public static RegistryObject<Block> SHELLITE_BLOCK = register("shellite_block");
    public static RegistryObject<Block> TWINITE_BLOCK = register("twinite_block");
    public static RegistryObject<Block> DRAGONSTEEL_BLOCK = register("dragonsteel_block");
    public static RegistryObject<Block> ABYSSAL_BLOCK = register("abyssal_block");
    public static RegistryObject<Block> SOUL_INFUSED_GLASS = registerGlass("soul_infused_glass");
    public static RegistryObject<Block> SHELLITE_GLASS = registerGlass("shellite_glass");
    public static RegistryObject<Block> TWINITE_GLASS = registerGlass("twinite_glass");
    public static RegistryObject<Block> DRAGONSTEEL_GLASS = registerGlass("dragonsteel_glass");
    public static RegistryObject<Block> ABYSSAL_GLASS = registerGlass("abyssal_glass");

    public static RegistryObject<DynamoBlock> DYNAMO_COLD = BLOCKS.register("dynamo_frost", () -> new DynamoBlock(of().sound(SoundType.NETHERITE_BLOCK).strength(2.0F).lightLevel(lightValue(ACTIVE, 7)), DynamoColdBlockEntity.class, Crystal_AugmentBlockEntities.DYNAMO_COLD));

    public static RegistryObject<Item> ADVANCED_REFINERY = registerAugmentableBlock("advanced_refinery", () -> new EntityBlockActive4Way(of().sound(SoundType.NETHERITE_BLOCK).strength(2.0F).lightLevel(lightValue(ACTIVE, 5)), MachineAdvancedRefineryBlockEntity.class, Crystal_AugmentBlockEntities.ADVANCED_REFINERY), () -> ThermalCoreConfig.machineAugments, MACHINE_VALIDATOR, Crystal_Augment.MOD_ID);
    public static RegistryObject<Item> NITRATIC_IGNITER = registerAugmentableBlock("nitratic_igniter", () -> new EntityBlockActive4Way(of().sound(SoundType.NETHERITE_BLOCK).strength(2.0F).lightLevel(lightValue(ACTIVE, 0)), MachineNitraticIgniterBlockEntity.class, Crystal_AugmentBlockEntities.NITRATIC_IGNITER), () -> ThermalCoreConfig.machineAugments, MACHINE_VALIDATOR, Crystal_Augment.MOD_ID);
    public static RegistryObject<Item> FLUID_MIXER = registerAugmentableBlock("fluid_mixer", () -> new EntityBlockActive4Way(of().sound(SoundType.NETHERITE_BLOCK).strength(2.0F).lightLevel(lightValue(ACTIVE, 0)), MachineFluidMixerBlockEntity.class, Crystal_AugmentBlockEntities.FLUID_MIXER), () -> ThermalCoreConfig.machineAugments, MACHINE_VALIDATOR, Crystal_Augment.MOD_ID);
    public static RegistryObject<Item> COMPONENT_ASSEMBLY = registerAugmentableBlock("component_assembly", () -> new EntityBlockActive4Way(of().sound(SoundType.NETHERITE_BLOCK).strength(2.0F).lightLevel(lightValue(ACTIVE, 0)), MachineComponentAssemblyBlockEntity.class, Crystal_AugmentBlockEntities.COMPONENT_ASSEMBLY), () -> ThermalCoreConfig.machineAugments, MACHINE_VALIDATOR, Crystal_Augment.MOD_ID);
    public static RegistryObject<Item> ENDOTHERMIC_DEHYDRATOR = registerAugmentableBlock("endothermic_dehydrator", () -> new EntityBlockActive4Way(of().sound(SoundType.NETHERITE_BLOCK).strength(2.0F).lightLevel(lightValue(ACTIVE, 0)), MachineEndothermicDehydratorBlockEntity.class, Crystal_AugmentBlockEntities.ENDOTHERMIC_DEHYDRATOR), () -> ThermalCoreConfig.machineAugments, MACHINE_VALIDATOR, Crystal_Augment.MOD_ID);
    public static RegistryObject<Item> LAVA_GEN = registerAugmentableBlock("device_lava_gen", () -> new EntityBlockActive4Way(of().sound(SoundType.LANTERN).strength(2.0F), DeviceLavaGenBlockEntity.class, Crystal_AugmentBlockEntities.LAVA_GEN), () -> ThermalCoreConfig.deviceAugments, DeviceLavaGenBlockEntity.AUG_VALIDATOR);

    private static Rarity getRarity(String name) {

        if(name.contains("jade")) {
            return Crystal_AugmentItems.green;
        }
        else if(name.contains("tourmaline")) {
            return Crystal_AugmentItems.blue;
        }
        else if(name.contains("kunzite")) {
            return Crystal_AugmentItems.dark_purple;
        }
        else if(name.contains("sodalite")) {
            return Crystal_AugmentItems.dark_blue;
        }
        else if(name.contains("morgan")) {
            return Crystal_AugmentItems.light_purple;
        }
        else if(name.contains("indigo")) {
            return Crystal_AugmentItems.dark_aqua;
        }
        else if(name.contains("purple_agate")) {
            return Crystal_AugmentItems.dark_purple;
        }
        else if(name.contains("abyss")) {
            return Crystal_AugmentItems.dark_gray;
        }
        else if(name.contains("sky_blue")) {
            return Crystal_AugmentItems.aqua;
        }
        else if(name.contains("amber")) {
            return Crystal_AugmentItems.gold;
        }


        return Crystal_AugmentItems.yellow;
    }

    public static RegistryObject<Block> registerGlass(String name) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new HardenedGlassBlock(Block.Properties.copy(Blocks.GLASS)
                .isValidSpawn(Crystal_AugmentBlocks::neverAllowSpawn)
                .isRedstoneConductor(Crystal_AugmentBlocks::isNotSolid)
                .isSuffocating(Crystal_AugmentBlocks::isNotSolid)
                .isViewBlocking(Crystal_AugmentBlocks::isNotSolid)));
        Rarity rarity = getRarity(name);
        Crystal_AugmentItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        return block;
    }

    public static RegistryObject<Block> register(String name) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f, 5f).sound(SoundType.METAL)));
        Rarity rarity = getRarity(name);
        Crystal_AugmentItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        return block;
    }

    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return false;
    }
    private static boolean isNotSolid(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }

    public static RegistryObject<Item> registerAugmentableBlock(String name, Supplier<Block> sup, IntSupplier numSlots, BiPredicate<ItemStack, List<ItemStack>> validAugment) {

        return registerAugmentableBlock(name, sup, numSlots, validAugment, ID_THERMAL);
    }

    public static RegistryObject<Item> registerAugmentableBlock(String name, Supplier<Block> sup, IntSupplier numSlots, BiPredicate<ItemStack, List<ItemStack>> validAugment, String modId) {

        return registerAugmentableBlock(name, sup, numSlots, validAugment, Rarity.COMMON, modId);
    }

    public static RegistryObject<Item> registerAugmentableBlock(String name, Supplier<Block> sup, IntSupplier numSlots, BiPredicate<ItemStack, List<ItemStack>> validAugment, Rarity rarity, String modId) {

        BLOCKS.register(name, sup);
        return registerItem(name, () -> new BlockItemAugmentable(BLOCKS.get(name), itemProperties().rarity(rarity)).setNumSlots(numSlots).setAugValidator(validAugment).setModId(modId));
    }

    public static RegistryObject<Item> registerItem(String name, Supplier<Item> sup) {

        return Crystal_AugmentItems.ITEMS.register(name, sup);
    }

    public static RegistryObject<Item> registerItem(String name) {

        return registerItem(name, Rarity.COMMON);
    }

    public static RegistryObject<Item> registerItem(String name, Rarity rarity) {

        return registerItem(name, () -> new ItemCoFH(itemProperties().rarity(rarity)));
    }
}
