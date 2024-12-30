package fish_dan.crystal_augment.inventory.machine;

import cofh.core.common.inventory.BlockEntityCoFHMenu;
import cofh.lib.common.inventory.SlotCoFH;
import cofh.lib.common.inventory.wrapper.InvWrapperCoFH;
import cofh.thermal.lib.common.block.entity.Reconfigurable4WayBlockEntity;
import fish_dan.crystal_augment.init.Crystal_AugmentContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MachineFluidMixerMenu extends BlockEntityCoFHMenu {

    public final Reconfigurable4WayBlockEntity tile;

    public MachineFluidMixerMenu(int windowId, Level level, BlockPos pos, Inventory inventory, Player player) {

        super(Crystal_AugmentContainers.FLUID_MIXER_CONTAINER.get(), windowId, level, pos, inventory, player);
        this.tile = (Reconfigurable4WayBlockEntity) level.getBlockEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotCoFH(tileInv, 0, 8, 53));

        bindAugmentSlots(tileInv, 1, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
