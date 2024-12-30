package fish_dan.crystal_augment.filter;

import cofh.core.util.filter.FilterHolderType;
import cofh.core.util.filter.ItemFilter;
import fish_dan.crystal_augment.inventory.AdvancedItemFilterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class AdvancedItemFilter extends ItemFilter {

    public static final Component DISPLAY_NAME = Component.translatable("info.thermal_extra.item_filter");

    public AdvancedItemFilter(int size, FilterHolderType holderType, int id, BlockPos pos) {
        super(size, holderType, id, pos);
    }

    @Override
    public Component getDisplayName() {

        return DISPLAY_NAME;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new AdvancedItemFilterMenu(i, player.level(), inventory, player, holderType.ordinal(), id, pos);
    }
}
