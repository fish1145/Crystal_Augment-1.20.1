package fish_dan.crystal_augment.client;

import fish_dan.crystal_augment.Crystal_Augment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Crystal_Augment.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void itemTooltipEvent(ItemTooltipEvent event) {
        ResourceLocation item = ForgeRegistries.ITEMS.getKey(event.getItemStack().getItem());

        if(item != null && item.getPath().equals("device_lava_gen")) {
            event.getToolTip().add(1, Component.translatable("info.crystal_augment.lava_gen_nether.0").withStyle(ChatFormatting.GOLD));
        }
    }
}
