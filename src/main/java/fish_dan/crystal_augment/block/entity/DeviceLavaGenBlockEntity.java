package fish_dan.crystal_augment.block.entity;

import cofh.core.util.helpers.AugmentDataHelper;
import cofh.core.util.helpers.FluidHelper;
import cofh.lib.api.block.entity.ITickableTile;
import cofh.lib.client.sounds.ConditionalSoundInstance;
import cofh.lib.common.fluid.FluidStorageCoFH;
import cofh.lib.common.inventory.ItemStorageCoFH;
import cofh.thermal.core.common.config.ThermalCoreConfig;
import cofh.thermal.lib.common.block.entity.DeviceBlockEntity;
import fish_dan.crystal_augment.init.Crystal_AugmentBlockEntities;
import fish_dan.crystal_augment.inventory.device.DeviceLavaGenMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static cofh.core.client.renderer.model.ModelUtils.FLUID;
import static cofh.lib.api.StorageGroup.INTERNAL;
import static cofh.lib.api.StorageGroup.OUTPUT;
import static cofh.lib.util.Constants.BUCKET_VOLUME;
import static cofh.lib.util.Constants.TANK_SMALL;
import static cofh.lib.util.constants.NBTTags.*;
import static cofh.thermal.core.init.registries.TCoreSounds.SOUND_DEVICE_WATER_GEN;
import static cofh.thermal.lib.util.ThermalAugmentRules.createAllowValidator;
import static net.minecraftforge.fluids.capability.IFluidHandler.FluidAction.EXECUTE;

public class DeviceLavaGenBlockEntity extends DeviceBlockEntity implements ITickableTile.IServerTickable {

    public static final BiPredicate<ItemStack, List<ItemStack>> AUG_VALIDATOR = createAllowValidator(TAG_AUGMENT_TYPE_UPGRADE, TAG_AUGMENT_TYPE_FLUID, TAG_AUGMENT_TYPE_FILTER);

    protected static final int GENERATION_RATE = 10;
    protected static final int GENERATION_RATE_NETHER = 40;
    protected static final Supplier<FluidStack> LAVA = () -> new FluidStack(Fluids.LAVA, 0);

    protected ItemStorageCoFH fillSlot = new ItemStorageCoFH(1, FluidHelper::hasFluidHandlerCap);
    protected FluidStorageCoFH tank = new FluidStorageCoFH(TANK_SMALL, e -> false).setEmptyFluid(LAVA).setEnabled(() -> isActive);

    protected boolean cached;
    protected boolean valid;

    public DeviceLavaGenBlockEntity(BlockPos pos, BlockState state) {

        super(Crystal_AugmentBlockEntities.LAVA_GEN.get(), pos, state);

        inventory.addSlot(fillSlot, INTERNAL);

        tankInv.addTank(tank, OUTPUT);

        addAugmentSlots(ThermalCoreConfig.deviceAugments);
        initHandlers();

        renderFluid = new FluidStack(Fluids.LAVA, BUCKET_VOLUME);
    }

    @Override
    protected void updateValidity() {

        if (level == null || !level.isAreaLoaded(worldPosition, 1)) {
            return;
        }
        int adjLavaSource = 0;
        valid = false;

        BlockPos[] cardinals = new BlockPos[]{
                worldPosition.north(),
                worldPosition.south(),
                worldPosition.west(),
                worldPosition.east(),
        };
        for (BlockPos adj : cardinals) {
            FluidState state = level.getFluidState(adj);
            if (state.getType().equals(Fluids.LAVA)) {
                ++adjLavaSource;
            }
        }
        if (adjLavaSource > 1) {
            valid = true;
        } else {
            tank.clear();
        }
        cached = true;
    }

    @Override
    protected void updateActiveState() {

        if (!cached) {
            updateValidity();
        }
        boolean curActive = isActive;
        isActive = redstoneControl.getState() && isValid();
        updateActiveState(curActive);
    }

    @Override
    protected boolean isValid() {

        return valid;
    }

    protected void fillFluid() {

        if (!fillSlot.isEmpty()) {
            fillSlot.getItemStack()
                    .getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM, null)
                    .ifPresent(c -> {
                        tank.drain(c.fill(new FluidStack(tank.getFluidStack(), (int) (BUCKET_VOLUME * baseMod)), EXECUTE), EXECUTE);
                        fillSlot.setItemStack(c.getContainer());
                    });
        }
    }

    @Override
    public void tickServer() {

        updateActiveState();

        if (isActive) {
            int rate = GENERATION_RATE;

            if(this.level != null && this.level.dimensionTypeId().equals(BuiltinDimensionTypes.NETHER)) {
                rate = GENERATION_RATE_NETHER;
            }

            tank.modify((int) (rate * baseMod));
            fillFluid();
        }
    }

    @Nonnull
    @Override
    public ModelData getModelData() {

        return ModelData.builder()
                .with(FLUID, renderFluid)
                .build();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {

        return new DeviceLavaGenMenu(i, level, worldPosition, inventory, player);
    }

    @Override
    protected Object getSound() {

        return new ConditionalSoundInstance(SOUND_DEVICE_WATER_GEN.get(), SoundSource.AMBIENT, this, () -> !remove && isActive);
    }

    // region AUGMENTS
    @Override
    protected Predicate<ItemStack> augValidator() {

        return item -> AugmentDataHelper.hasAugmentData(item) && AUG_VALIDATOR.test(item, getAugmentsAsList());
    }
    // endregion
}
