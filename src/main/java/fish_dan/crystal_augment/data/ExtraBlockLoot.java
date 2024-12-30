package fish_dan.crystal_augment.data;

import cofh.core.common.block.EntityBlockActive4Way;
import cofh.core.common.block.EntityBlockActive6Way;
import cofh.lib.init.data.loot.BlockLootSubProviderCoFH;
import fish_dan.crystal_augment.Crystal_Augment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ExtraBlockLoot extends BlockLootSubProviderCoFH {

    @Override
    protected void generate() {
        ForgeRegistries.BLOCKS.getKeys().stream().filter(key -> key.getNamespace().equals(Crystal_Augment.MOD_ID))
                .map(ForgeRegistries.BLOCKS::getValue).toList().forEach(block -> {
                    if(block instanceof GlassBlock) {
                        dropWhenSilkTouch(block);
                    }
                    else if(block instanceof EntityBlockActive6Way || block instanceof EntityBlockActive4Way) {
                        createSyncDropTable(block);
                    }
                    else {
                        dropSelf(block);
                    }
                });
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getKeys().stream().filter(key -> key.getNamespace().equals(Crystal_Augment.MOD_ID))
                .map(ForgeRegistries.BLOCKS::getValue).toList();
    }
}
