package fish_dan.crystal_augment.init;

import cofh.lib.util.DeferredRegisterCoFH;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.block.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Crystal_AugmentBlockEntities {

    public static DeferredRegisterCoFH<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegisterCoFH.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Crystal_Augment.MOD_ID);

    public static RegistryObject<BlockEntityType<?>> DYNAMO_COLD = BLOCK_ENTITIES.register("dynamo_frost", () -> BlockEntityType.Builder.of(DynamoColdBlockEntity::new, Crystal_AugmentBlocks.DYNAMO_COLD.get()).build(null));
    public static RegistryObject<BlockEntityType<?>> ADVANCED_REFINERY = BLOCK_ENTITIES.register("advanced_refinery", () -> BlockEntityType.Builder.of(MachineAdvancedRefineryBlockEntity::new, Crystal_AugmentBlocks.BLOCKS.get("advanced_refinery")).build(null));
    public static RegistryObject<BlockEntityType<?>> NITRATIC_IGNITER = BLOCK_ENTITIES.register("nitratic_igniter", () -> BlockEntityType.Builder.of(MachineNitraticIgniterBlockEntity::new, Crystal_AugmentBlocks.BLOCKS.get("nitratic_igniter")).build(null));
    public static RegistryObject<BlockEntityType<?>> FLUID_MIXER = BLOCK_ENTITIES.register("fluid_mixer", () -> BlockEntityType.Builder.of(MachineFluidMixerBlockEntity::new, Crystal_AugmentBlocks.BLOCKS.get("fluid_mixer")).build(null));
    public static RegistryObject<BlockEntityType<?>> COMPONENT_ASSEMBLY = BLOCK_ENTITIES.register("component_assembly", () -> BlockEntityType.Builder.of(MachineComponentAssemblyBlockEntity::new, Crystal_AugmentBlocks.BLOCKS.get("component_assembly")).build(null));
    public static RegistryObject<BlockEntityType<?>> ENDOTHERMIC_DEHYDRATOR = BLOCK_ENTITIES.register("endothermic_dehydrator", () -> BlockEntityType.Builder.of(MachineEndothermicDehydratorBlockEntity::new, Crystal_AugmentBlocks.BLOCKS.get("endothermic_dehydrator")).build(null));

    public static RegistryObject<BlockEntityType<?>> LAVA_GEN = BLOCK_ENTITIES.register("lava_gen", () -> BlockEntityType.Builder.of(DeviceLavaGenBlockEntity::new, Crystal_AugmentBlocks.BLOCKS.get("device_lava_gen")).build(null));

}
