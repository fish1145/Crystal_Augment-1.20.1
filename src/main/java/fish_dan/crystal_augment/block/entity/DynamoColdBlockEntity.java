package fish_dan.crystal_augment.block.entity;

import cofh.lib.common.inventory.ItemStorageCoFH;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.block.entity.DynamoBlockEntity;
import fish_dan.crystal_augment.inventory.DynamoFrostMenu;
import fish_dan.crystal_augment.init.Crystal_AugmentBlockEntities;
import fish_dan.crystal_augment.recipe.ColdFuelManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

import static cofh.lib.api.StorageGroup.INPUT;

public class DynamoColdBlockEntity  extends DynamoBlockEntity {

    protected ItemStorageCoFH fuelSlot = new ItemStorageCoFH(item -> filter.valid(item) && ColdFuelManager.instance().validFuel(item));

    public DynamoColdBlockEntity(BlockPos pos, BlockState state) {

        super(Crystal_AugmentBlockEntities.DYNAMO_COLD.get(), pos, state);

        inventory.addSlot(fuelSlot, INPUT);

        addAugmentSlots(ThermalCoreConfig.dynamoAugments);
        initHandlers();
    }

    @Override
    protected int getBaseProcessTick() {

        return ColdFuelManager.instance().getBasePower();
    }

    // region PROCESS
    @Override
    protected boolean canProcessStart() {

        return ColdFuelManager.instance().getEnergy(fuelSlot.getItemStack()) > 0;
    }

    @Override
    protected void processStart() {

        int fuelVal = Math.round(ColdFuelManager.instance().getEnergy(fuelSlot.getItemStack()) * energyMod);
        processTick = Math.min(baseProcessTick, fuelVal);
        fuel += fuelMax = fuelVal;
        fuelSlot.consume(1);
    }
    // endregion

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new DynamoFrostMenu(i, level, worldPosition, inventory, player);
    }
}
