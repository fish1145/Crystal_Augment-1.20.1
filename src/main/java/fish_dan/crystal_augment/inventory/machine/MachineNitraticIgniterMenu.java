package fish_dan.crystal_augment.inventory.machine;

import cofh.core.common.inventory.BlockEntityCoFHMenu;
import cofh.lib.common.inventory.SlotCoFH;
import cofh.lib.common.inventory.SlotRemoveOnly;
import cofh.lib.common.inventory.wrapper.InvWrapperCoFH;
import cofh.thermal.lib.common.block.entity.Reconfigurable4WayBlockEntity;
import fish_dan.crystal_augment.init.Crystal_AugmentContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class MachineNitraticIgniterMenu extends BlockEntityCoFHMenu {

    public final Reconfigurable4WayBlockEntity tile;

    public MachineNitraticIgniterMenu(int windowId, Level level, BlockPos pos, Inventory inventory, Player player) {

        super(Crystal_AugmentContainers.NITRATIC_IGNITER_CONTAINER.get(), windowId, level, pos, inventory, player);
        this.tile = (Reconfigurable4WayBlockEntity) level.getBlockEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotCoFH(tileInv, 0, 53, 17));
        addSlot(new SlotCoFH(tileInv, 1, 35, 17));
        addSlot(new SlotCoFH(tileInv, 2, 71, 17));

        addSlot(new SlotCoFH(tileInv, 3, 53, 53));

        addSlot(new SlotRemoveOnly(tileInv, 4, 125, 26));
        addSlot(new SlotRemoveOnly(tileInv, 5, 143, 26));
        addSlot(new SlotRemoveOnly(tileInv, 6, 125, 44));
        addSlot(new SlotRemoveOnly(tileInv, 7, 143, 44));

        addSlot(new SlotCoFH(tileInv, 8, 8, 53));

        bindAugmentSlots(tileInv, 9, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
