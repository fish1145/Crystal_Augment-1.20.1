package fish_dan.crystal_augment.inventory.device;


import cofh.core.common.inventory.BlockEntityCoFHMenu;
import cofh.lib.common.inventory.SlotCoFH;
import cofh.lib.common.inventory.wrapper.InvWrapperCoFH;
import cofh.thermal.lib.common.block.entity.AugmentableBlockEntity;
import fish_dan.crystal_augment.init.Crystal_AugmentContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DeviceLavaGenMenu extends BlockEntityCoFHMenu {

    public final AugmentableBlockEntity tile;

    public DeviceLavaGenMenu(int windowId, Level world, BlockPos pos, Inventory inventory, Player player) {

        super(Crystal_AugmentContainers.LAVA_GEN_CONTAINER.get(), windowId, world, pos, inventory, player);
        this.tile = (AugmentableBlockEntity) world.getBlockEntity(pos);
        InvWrapperCoFH tileInv = new InvWrapperCoFH(this.tile.getItemInv());

        addSlot(new SlotCoFH(tileInv, 0, 44, 35));

        bindAugmentSlots(tileInv, 1, this.tile.augSize());
        bindPlayerInventory(inventory);
    }

}
