package fish_dan.crystal_augment.client.screens;


import cofh.core.client.gui.ContainerScreenCoFH;
import cofh.core.client.gui.element.ElementButton;
import cofh.core.client.gui.element.ElementTexture;
import cofh.core.client.gui.element.SimpleTooltip;
import cofh.core.common.network.packet.server.FilterableGuiTogglePacket;
import cofh.core.util.helpers.FilterHelper;
import cofh.core.util.helpers.RenderHelper;
import com.mojang.blaze3d.platform.GlStateManager;
import fish_dan.crystal_augment.inventory.AdvancedItemFilterMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

import java.util.Collections;

import static cofh.core.util.helpers.GuiHelper.*;
import static cofh.lib.util.Constants.PATH_ELEMENTS;
import static cofh.lib.util.Constants.PATH_GUI;
import static cofh.lib.util.helpers.SoundHelper.playClickSound;

public class AdvancedItemFilterScreen extends ContainerScreenCoFH<AdvancedItemFilterMenu> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(PATH_GUI + "generic.png");
    public static final ResourceLocation SLOT_OVERLAY = new ResourceLocation(PATH_ELEMENTS + "locked_overlay_slot.png");

    public static final ResourceLocation TEX_DENY_LIST = new ResourceLocation(PATH_GUI + "filters/filter_deny_list.png");
    public static final ResourceLocation TEX_ALLOW_LIST = new ResourceLocation(PATH_GUI + "filters/filter_allow_list.png");
    public static final ResourceLocation TEX_IGNORE_NBT = new ResourceLocation(PATH_GUI + "filters/filter_ignore_nbt.png");
    public static final ResourceLocation TEX_USE_NBT = new ResourceLocation(PATH_GUI + "filters/filter_use_nbt.png");

    public AdvancedItemFilterScreen(AdvancedItemFilterMenu container, Inventory inv, Component titleIn) {

        super(container, inv, titleIn);

        texture = TEXTURE;
        info = generatePanelInfo("info.cofh_core.item_filter");
    }

    @Override
    public void init() {

        super.init();

        for (int i = 0; i < menu.getFilterSize(); ++i) {
            Slot slot = menu.slots.get(i);
            addElement(createSlot(this, slot.x, slot.y));
        }
        addButtons();

        switch (menu.type) {
            case ITEM -> {
                if (menu.getFilterableItem().hasGui(menu.getFilterStack())) {
                    // Filter Tab
                    addElement(new ElementTexture(this, 4, -21)
                            .setUV(24, 0)
                            .setSize(24, 21)
                            .setTexture(TAB_TOP, 48, 32)
                            .setVisible(() -> FilterHelper.hasFilter(menu.getFilterStack())));
                    addElement(new ElementTexture(this, 8, -17) {

                        @Override
                        public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                            FilterableGuiTogglePacket.openGui(menu.getFilterStack());
                            return true;
                        }
                    }
                            .setSize(16, 16)
                            .setTexture(NAV_BACK, 16, 16)
                            .setTooltipFactory((element, mouseX, mouseY) -> menu.getFilterableItem() instanceof MenuProvider menuProvider ? Collections.singletonList(menuProvider.getDisplayName()) : Collections.emptyList())
                            .setVisible(() -> FilterHelper.hasFilter(menu.getFilterStack())));
                }
            }
            case TILE, ENTITY -> {
                if (menu.getFilterable().hasGui()) {
                    // Filter Tab
                    addElement(new ElementTexture(this, 4, -21)
                            .setUV(24, 0)
                            .setSize(24, 21)
                            .setTexture(TAB_TOP, 48, 32)
                            .setVisible(() -> FilterHelper.hasFilter(menu.getFilterable())));
                    addElement(new ElementTexture(this, 8, -17) {

                        @Override
                        public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                            FilterableGuiTogglePacket.openGui(menu.getFilterable());
                            return true;
                        }
                    }
                            .setSize(16, 16)
                            .setTexture(NAV_BACK, 16, 16)
                            .setTooltipFactory((element, mouseX, mouseY) -> menu.getFilterable() instanceof MenuProvider menuProvider ? Collections.singletonList(menuProvider.getDisplayName()) : Collections.emptyList())
                            .setVisible(() -> FilterHelper.hasFilter(menu.getFilterable())));
                }
            }
        }
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int mouseX, int mouseY) {

        super.renderLabels(pGuiGraphics, mouseX, mouseY);

        if (menu.lockedSlot != null) {
            GlStateManager._enableBlend();
            RenderHelper.setPosTexShader();
            RenderHelper.setShaderTexture0(SLOT_OVERLAY);
            drawTexturedModalRect(pGuiGraphics.pose(), menu.lockedSlot.x, menu.lockedSlot.y, 0, 0, 16, 16, 16, 16);
            GlStateManager._disableBlend();
        }
    }

    // region ELEMENTS
    protected void addButtons() {

        addElement(new ElementButton(this, 152, 22) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                menu.setAllowList(true);
                playClickSound(0.7F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_DENY_LIST, 40, 20)
                .setTooltipFactory(new SimpleTooltip(Component.translatable("info.cofh.filter.allowlist.0")))
                .setVisible(() -> !menu.getAllowList()));

        addElement(new ElementButton(this, 152, 22) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                menu.setAllowList(false);
                playClickSound(0.4F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_ALLOW_LIST, 40, 20)
                .setTooltipFactory(new SimpleTooltip(Component.translatable("info.cofh.filter.allowlist.1")))
                .setVisible(menu::getAllowList));

        addElement(new ElementButton(this, 152, 44) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                menu.setCheckNBT(true);
                playClickSound(0.7F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_IGNORE_NBT, 40, 20)
                .setTooltipFactory(new SimpleTooltip(Component.translatable("info.cofh.filter.checkNBT.0")))
                .setVisible(() -> !menu.getCheckNBT()));

        addElement(new ElementButton(this, 152, 44) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                menu.setCheckNBT(false);
                playClickSound(0.4F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_USE_NBT, 40, 20)
                .setTooltipFactory(new SimpleTooltip(Component.translatable("info.cofh.filter.checkNBT.1")))
                .setVisible(menu::getCheckNBT));
    }
    // endregion
}

