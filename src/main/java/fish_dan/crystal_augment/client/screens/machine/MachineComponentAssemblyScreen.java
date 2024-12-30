package fish_dan.crystal_augment.client.screens.machine;

import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.inventory.machine.MachineComponentAssemblyMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static cofh.core.util.helpers.GuiHelper.*;

public class MachineComponentAssemblyScreen extends MachineScreen<MachineComponentAssemblyMenu> {

    public static final String TEX_PATH = Crystal_Augment.MOD_ID + ":textures/gui/container/component_assembly.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineComponentAssemblyScreen(MachineComponentAssemblyMenu container, Inventory inv, Component titleIn) {

        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.crystal_augment.machine_metal_infuser");
        name = "component_assembly";
    }

    @Override
    public void init() {

        super.init();

        addElement(createInputSlot(this, 62, 17, tile));
        addElement(createInputSlot(this, 62, 35, tile));
        addElement(createInputSlot(this, 62, 53, tile));
        addElement(createInputSlot(this, 80, 17, tile));
        addElement(createInputSlot(this, 80, 35, tile));
        addElement(createInputSlot(this, 80, 53, tile));

        addElement(createLargeOutputSlot(this, 130, 35, tile));

        addElement(setClearable(createMediumInputFluidStorage(this, 34, 22, tile.getTank(0), tile), tile, 0));
        addElement(setClearable(createMediumInputFluidStorage(this, 153, 22, tile.getTank(1), tile), tile, 1));

        addElement(ThermalGuiHelper.createDefaultFluidProgress(this, 98, 35, PROG_ARROW_FLUID_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultProgress(this, 98, 35, PROG_ARROW_RIGHT, tile));
    }

}
