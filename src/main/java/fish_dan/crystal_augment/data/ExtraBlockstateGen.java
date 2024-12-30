package fish_dan.crystal_augment.data;

import cofh.lib.init.data.BlockStateProviderCoFH;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.init.Crystal_AugmentBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ExtraBlockstateGen extends BlockStateProviderCoFH {

    public ExtraBlockstateGen(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, Crystal_Augment.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get());
        this.simpleBlock(Crystal_AugmentBlocks.SHELLITE_BLOCK.get());
        this.simpleBlock(Crystal_AugmentBlocks.TWINITE_BLOCK.get());
        this.simpleBlock(Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get());
        this.simpleBlock(Crystal_AugmentBlocks.ABYSSAL_BLOCK.get());

        this.translucentBlock(Crystal_AugmentBlocks.SOUL_INFUSED_GLASS.get());
        this.translucentBlock(Crystal_AugmentBlocks.SHELLITE_GLASS.get());
        this.translucentBlock(Crystal_AugmentBlocks.TWINITE_GLASS.get());
        this.translucentBlock(Crystal_AugmentBlocks.DRAGONSTEEL_GLASS.get());
        this.translucentBlock(Crystal_AugmentBlocks.ABYSSAL_GLASS.get());
    }

    public void translucentBlock(Block block) {
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        this.simpleBlock(block, models().cubeAll(name(block), blockTexture(block)).renderType("translucent"));
        this.itemModels().withExistingParent("crystal_augment:item/"+registryName.getPath(), "crystal_augment:block/"+registryName.getPath());
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    @Override
    public void simpleBlock(Block block) {
        simpleBlock(block, cubeAll(block));
        ResourceLocation registryName = ForgeRegistries.BLOCKS.getKey(block);
        this.itemModels().withExistingParent("crystal_augment:item/"+registryName.getPath(), "crystal_augment:block/"+registryName.getPath());
    }
}
