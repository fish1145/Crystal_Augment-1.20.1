package fish_dan.crystal_augment;

import cofh.core.client.event.CoreClientEvents;
import cofh.core.common.config.ConfigManager;
import fish_dan.crystal_augment.client.screens.AdvancedItemFilterScreen;
import fish_dan.crystal_augment.client.screens.DynamoFrostScreen;
import fish_dan.crystal_augment.client.screens.device.DeviceLavaGenScreen;
import fish_dan.crystal_augment.client.screens.machine.*;
import fish_dan.crystal_augment.filter.AdvancedFilter;
import fish_dan.crystal_augment.init.*;
import fish_dan.crystal_augment.util.ThermalExtraConfig;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.NewRegistryEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Crystal_Augment.MOD_ID)
public class Crystal_Augment {

	public static final String MOD_ID = "crystal_augment";
	public static final Logger LOGGER = LogManager.getLogger();

	public static final ConfigManager CONFIG_MANAGER = new ConfigManager();

	public Crystal_Augment() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Crystal_AugmentItems.ITEMS.register(bus);
		Crystal_AugmentBlocks.BLOCKS.register(bus);
		Crystal_AugmentFluids.FLUIDS.register(bus);
		Crystal_AugmentFluids.FLUID_TYPES.register(bus);
		Crystal_AugmentBlockEntities.BLOCK_ENTITIES.register(bus);
		Crystal_AugmentContainers.CONTAINERS.register(bus);
		Crystal_AugmentRecipeTypes.RECIPE_TYPES.register(bus);
		Crystal_AugmentRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
		Crystal_AugmentCreativeTabs.CREATIVE_TABS.register(bus);
		AdvancedFilter.init();
		Crystal_AugmentRecipeManagers.register();

		CONFIG_MANAGER.register(bus)
				.addServerConfig(new ThermalExtraConfig());

		bus.addListener(this::clientSetup);
		bus.addListener(this::registrySetup);
	}

	public void setup(FMLCommonSetupEvent event) {
		
	}

	public void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			CoreClientEvents.addNamespace(Crystal_Augment.MOD_ID);
			MenuScreens.register(Crystal_AugmentContainers.ADVANCED_REFINERY_CONTAINER.get(), MachineAdvancedRefineryScreen::new);
			MenuScreens.register(Crystal_AugmentContainers.NITRATIC_IGNITER_CONTAINER.get(), MachineNitraticIgniterScreen::new);
			MenuScreens.register(Crystal_AugmentContainers.FLUID_MIXER_CONTAINER.get(), MachineFluidMixerScreen::new);
			MenuScreens.register(Crystal_AugmentContainers.DYNAMO_FROST_CONTAINER.get(), DynamoFrostScreen::new);
			MenuScreens.register(Crystal_AugmentContainers.ADVANCED_ITEM_FILTER_CONTAINER.get(), AdvancedItemFilterScreen::new);
			MenuScreens.register(Crystal_AugmentContainers.LAVA_GEN_CONTAINER.get(), DeviceLavaGenScreen::new);
			MenuScreens.register(Crystal_AugmentContainers.COMPONENT_ASSEMBLY_CONTAINER.get(), MachineComponentAssemblyScreen::new);
			MenuScreens.register(Crystal_AugmentContainers.ENDOTHERMIC_DEHYDRATOR_CONTAINER.get(), MachineEndothermicDehydratorScreen::new);
		});
	}

	private void registrySetup(final NewRegistryEvent event) {
		CONFIG_MANAGER.setupClient();
		CONFIG_MANAGER.setupServer();
		CONFIG_MANAGER.setupCommon();
	}
}
