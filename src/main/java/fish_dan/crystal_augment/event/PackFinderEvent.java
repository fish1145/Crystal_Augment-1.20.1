package fish_dan.crystal_augment.event;

import fish_dan.crystal_augment.Crystal_Augment;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.resource.PathPackResources;

@Mod.EventBusSubscriber(modid = Crystal_Augment.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PackFinderEvent {
    @SubscribeEvent
    public static void packFinder(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            event.addRepositorySource(consumer -> consumer.accept(Pack.readMetaAndCreate(
                    new ResourceLocation(Crystal_Augment.MOD_ID,"resourcess").toString(),
                    Component.literal("附加材质包"),
                    false,
                    id -> new PathPackResources(
                            id,
                            true,
                            ModList.get()
                                    .getModFileById(Crystal_Augment.MOD_ID)
                                    .getFile()
                                    .findResource("resourcepacks/resourcess")
                    ),
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.TOP,
                    PackSource.BUILT_IN
            )));
        }
    }
}
