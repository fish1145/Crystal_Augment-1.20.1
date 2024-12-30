package fish_dan.crystal_augment.data;

import cofh.thermal.lib.util.references.ThermalTags;
import fish_dan.crystal_augment.Crystal_Augment;
import fish_dan.crystal_augment.init.Crystal_AugmentBlocks;
import fish_dan.crystal_augment.init.Crystal_AugmentFluids;
import fish_dan.crystal_augment.init.Crystal_AugmentItems;
import fish_dan.crystal_augment.init.Crystal_AugmentTags;
import fish_dan.crystal_augment.item.ToolSetObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
//import slimeknights.tconstruct.common.TinkerTags;

public class ExtraTagGen {

    public static class EntityTags extends EntityTypeTagsProvider {

        public EntityTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(pOutput, pProvider, Crystal_Augment.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

            tag(Crystal_AugmentTags.EntityTypes.ENDER_MOBS).add(EntityType.ENDERMAN, EntityType.ENDER_DRAGON, EntityType.ENDERMITE, EntityType.SHULKER);
        }
    }

    public static class FluidTags extends FluidTagsProvider {

        public FluidTags(PackOutput gen, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, completableFuture, Crystal_Augment.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(Crystal_AugmentTags.Fluids.SOUL_INFUSED).add(Crystal_AugmentFluids.MOLTEN_SOUL_INFUSED.still().get());
            tag(Crystal_AugmentTags.Fluids.SHELLITE).add(Crystal_AugmentFluids.MOLTEN_SHELLITE.still().get());
            tag(Crystal_AugmentTags.Fluids.TWINITE).add(Crystal_AugmentFluids.MOLTEN_TWINITE.still().get());
            tag(Crystal_AugmentTags.Fluids.DRAGONSTEEL).add(Crystal_AugmentFluids.MOLTEN_DRAGONSTEEL.still().get());
            tag(Crystal_AugmentTags.Fluids.ABYSSAL).add(Crystal_AugmentFluids.MOLTEN_ABYSSAL.still().get());

            //tag();
        }
    }

    public static class ItemTags extends ItemTagsProvider {

        public ItemTags(PackOutput gen, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> blocks, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, completableFuture, blocks, Crystal_Augment.MOD_ID, existingFileHelper);
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void addTags(HolderLookup.Provider provider) {

            tag(ThermalTags.Items.MACHINE_CASTS).add(Crystal_AugmentItems.CHILLER_PLATE_CAST.get());

            tag(Tags.Items.INGOTS).add(
                    Crystal_AugmentItems.SOUL_INFUSED_INGOT.get(),
                    Crystal_AugmentItems.SHELLITE_INGOT.get(),
                    Crystal_AugmentItems.TWINITE_INGOT.get(),
                    Crystal_AugmentItems.DRAGONSTEEL_INGOT.get(),
                    Crystal_AugmentItems.ABYSSAL_INGOT.get()
            );

            tag(Tags.Items.NUGGETS).add(
                    Crystal_AugmentItems.SOUL_INFUSED_NUGGET.get(),
                    Crystal_AugmentItems.SHELLITE_NUGGET.get(),
                    Crystal_AugmentItems.TWINITE_NUGGET.get(),
                    Crystal_AugmentItems.DRAGONSTEEL_NUGGET.get(),
                    Crystal_AugmentItems.ABYSSAL_NUGGET.get()
            );

            tag(Crystal_AugmentTags.Items.GEARS).add(
                    Crystal_AugmentItems.SOUL_INFUSED_GEAR.get(),
                    Crystal_AugmentItems.SHELLITE_GEAR.get(),
                    Crystal_AugmentItems.TWINITE_GEAR.get(),
                    Crystal_AugmentItems.DRAGONSTEEL_GEAR.get(),
                    Crystal_AugmentItems.ABYSSAL_GEAR.get()
            );

            tag(Crystal_AugmentTags.Items.COINS).add(
                    Crystal_AugmentItems.SOUL_INFUSED_COIN.get(),
                    Crystal_AugmentItems.SHELLITE_COIN.get(),
                    Crystal_AugmentItems.TWINITE_COIN.get(),
                    Crystal_AugmentItems.DRAGONSTEEL_COIN.get(),
                    Crystal_AugmentItems.ABYSSAL_COIN.get()
            );

            tag(Crystal_AugmentTags.Items.PLATES).add(
                    Crystal_AugmentItems.SOUL_INFUSED_PLATE.get(),
                    Crystal_AugmentItems.SHELLITE_PLATE.get(),
                    Crystal_AugmentItems.TWINITE_PLATE.get(),
                    Crystal_AugmentItems.DRAGONSTEEL_PLATE.get(),
                    Crystal_AugmentItems.ABYSSAL_PLATE.get()
            );

            tag(Tags.Items.DUSTS).add(
                    Crystal_AugmentItems.SOUL_INFUSED_DUST.get(),
                    Crystal_AugmentItems.SHELLITE_DUST.get(),
                    Crystal_AugmentItems.TWINITE_DUST.get(),
                    Crystal_AugmentItems.DRAGONSTEEL_DUST.get(),
                    Crystal_AugmentItems.ABYSSAL_DUST.get(),
                    Crystal_AugmentItems.AMETHYST_DUST.get(),
                    Crystal_AugmentItems.ANCIENT_DUST.get(),
                    Crystal_AugmentItems.OBSIDIAN_DUST.get(),
                    Crystal_AugmentItems.ARCANE_GOLD_DUST.get(),
                    Crystal_AugmentItems.ZINC_DUST.get()
            );

            tag(Crystal_AugmentTags.Items.DUSTS_ARCANE_GOLD).add(Crystal_AugmentItems.ARCANE_GOLD_DUST.get());
            tag(Crystal_AugmentTags.Items.DUSTS_ZINC).add(Crystal_AugmentItems.ZINC_DUST.get());
            tag(Crystal_AugmentTags.Items.DUSTS_OBSIDIAN).add(Crystal_AugmentItems.OBSIDIAN_DUST.get());
            tag(Crystal_AugmentTags.Items.DUSTS_SOUL_SAND).add(Crystal_AugmentItems.SOUL_SAND_DUST.get());
            tag(Crystal_AugmentTags.Items.DUSTS_AMETHYST).add(Crystal_AugmentItems.AMETHYST_DUST.get());

            tag(Crystal_AugmentTags.Items.SIGNALUM_REPAIR_MATERIAL).addOptionalTag(new ResourceLocation("forge:ingots/signalum"));
            tag(Crystal_AugmentTags.Items.LUMIUM_REPAIR_MATERIAL).addOptionalTag(new ResourceLocation("forge:ingots/lumium"));
            tag(Crystal_AugmentTags.Items.ENDERIUM_REPAIR_MATERIAL).addOptionalTag(new ResourceLocation("forge:ingots/enderium"));

            tag(Crystal_AugmentTags.Items.SOUL_INFUSED_INGOT).add(Crystal_AugmentItems.SOUL_INFUSED_INGOT.get());
            tag(Crystal_AugmentTags.Items.SOUL_INFUSED_NUGGET).add(Crystal_AugmentItems.SOUL_INFUSED_NUGGET.get());
            tag(Crystal_AugmentTags.Items.SOUL_INFUSED_DUST).add(Crystal_AugmentItems.SOUL_INFUSED_DUST.get());
            tag(Crystal_AugmentTags.Items.SOUL_INFUSED_GEAR).add(Crystal_AugmentItems.SOUL_INFUSED_GEAR.get());
            tag(Crystal_AugmentTags.Items.SOUL_INFUSED_PLATE).add(Crystal_AugmentItems.SOUL_INFUSED_PLATE.get());
            tag(Crystal_AugmentTags.Items.SOUL_INFUSED_COIN).add(Crystal_AugmentItems.SOUL_INFUSED_COIN.get());
            tag(Crystal_AugmentTags.Items.SOUL_INFUSED_REPAIR_MATERIAL).addTag(Crystal_AugmentTags.Items.SOUL_INFUSED_INGOT);

            tag(Crystal_AugmentTags.Items.SHELLITE_INGOT).add(Crystal_AugmentItems.SHELLITE_INGOT.get());
            tag(Crystal_AugmentTags.Items.SHELLITE_NUGGET).add(Crystal_AugmentItems.SHELLITE_NUGGET.get());
            tag(Crystal_AugmentTags.Items.SHELLITE_DUST).add(Crystal_AugmentItems.SHELLITE_DUST.get());
            tag(Crystal_AugmentTags.Items.SHELLITE_GEAR).add(Crystal_AugmentItems.SHELLITE_GEAR.get());
            tag(Crystal_AugmentTags.Items.SHELLITE_PLATE).add(Crystal_AugmentItems.SHELLITE_PLATE.get());
            tag(Crystal_AugmentTags.Items.SHELLITE_COIN).add(Crystal_AugmentItems.SHELLITE_COIN.get());
            tag(Crystal_AugmentTags.Items.SHELLITE_REPAIR_MATERIAL).addTag(Crystal_AugmentTags.Items.SHELLITE_INGOT);

            tag(Crystal_AugmentTags.Items.TWINITE_INGOT).add(Crystal_AugmentItems.TWINITE_INGOT.get());
            tag(Crystal_AugmentTags.Items.TWINITE_NUGGET).add(Crystal_AugmentItems.TWINITE_NUGGET.get());
            tag(Crystal_AugmentTags.Items.TWINITE_DUST).add(Crystal_AugmentItems.TWINITE_DUST.get());
            tag(Crystal_AugmentTags.Items.TWINITE_GEAR).add(Crystal_AugmentItems.TWINITE_GEAR.get());
            tag(Crystal_AugmentTags.Items.TWINITE_PLATE).add(Crystal_AugmentItems.TWINITE_PLATE.get());
            tag(Crystal_AugmentTags.Items.TWINITE_COIN).add(Crystal_AugmentItems.TWINITE_COIN.get());
            tag(Crystal_AugmentTags.Items.TWINITE_REPAIR_MATERIAL).addTag(Crystal_AugmentTags.Items.TWINITE_INGOT);

            tag(Crystal_AugmentTags.Items.DRAGONSTEEL_INGOT).add(Crystal_AugmentItems.DRAGONSTEEL_INGOT.get());
            tag(Crystal_AugmentTags.Items.DRAGONSTEEL_NUGGET).add(Crystal_AugmentItems.DRAGONSTEEL_NUGGET.get());
            tag(Crystal_AugmentTags.Items.DRAGONSTEEL_DUST).add(Crystal_AugmentItems.DRAGONSTEEL_DUST.get());
            tag(Crystal_AugmentTags.Items.DRAGONSTEEL_GEAR).add(Crystal_AugmentItems.DRAGONSTEEL_GEAR.get());
            tag(Crystal_AugmentTags.Items.DRAGONSTEEL_PLATE).add(Crystal_AugmentItems.DRAGONSTEEL_PLATE.get());
            tag(Crystal_AugmentTags.Items.DRAGONSTEEL_COIN).add(Crystal_AugmentItems.DRAGONSTEEL_COIN.get());
            tag(Crystal_AugmentTags.Items.DRAGONSTEEL_REPAIR_MATERIAL).addTag(Crystal_AugmentTags.Items.DRAGONSTEEL_INGOT);

            tag(Crystal_AugmentTags.Items.ABYSSAL_INGOT).add(Crystal_AugmentItems.ABYSSAL_INGOT.get());
            tag(Crystal_AugmentTags.Items.ABYSSAL_NUGGET).add(Crystal_AugmentItems.ABYSSAL_NUGGET.get());
            tag(Crystal_AugmentTags.Items.ABYSSAL_DUST).add(Crystal_AugmentItems.ABYSSAL_DUST.get());
            tag(Crystal_AugmentTags.Items.ABYSSAL_GEAR).add(Crystal_AugmentItems.ABYSSAL_GEAR.get());
            tag(Crystal_AugmentTags.Items.ABYSSAL_PLATE).add(Crystal_AugmentItems.ABYSSAL_PLATE.get());
            tag(Crystal_AugmentTags.Items.ABYSSAL_COIN).add(Crystal_AugmentItems.ABYSSAL_COIN.get());
            tag(Crystal_AugmentTags.Items.ABYSSAL_REPAIR_MATERIAL).addTag(Crystal_AugmentTags.Items.ABYSSAL_INGOT);

            tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).add(
                    Crystal_AugmentItems.LUMIUM_SET.helmet().get(),
                    Crystal_AugmentItems.LUMIUM_SET.chestplate().get(),
                    Crystal_AugmentItems.LUMIUM_SET.leggings().get(),
                    Crystal_AugmentItems.LUMIUM_SET.boots().get()
            );

            tag(Tags.Items.TOOLS).addTags(
                    Crystal_AugmentTags.Items.ABYSSAL_TOOLS,
                    Crystal_AugmentTags.Items.DRAGONSTEEL_TOOLS,
                    Crystal_AugmentTags.Items.TWINITE_TOOLS,
                    Crystal_AugmentTags.Items.SHELLITE_TOOLS,
                    Crystal_AugmentTags.Items.SOUL_INFUSED_TOOLS,
                    Crystal_AugmentTags.Items.ENDERIUM_TOOLS,
                    Crystal_AugmentTags.Items.LUMIUM_TOOLS,
                    Crystal_AugmentTags.Items.SIGNALUM_TOOLS
            );

            toolsetTags(Crystal_AugmentItems.SIGNALUM_SET, Crystal_AugmentTags.Items.SIGNALUM_TOOLS, Crystal_AugmentTags.Items.SIGNALUM_ARMOR);
            toolsetTags(Crystal_AugmentItems.LUMIUM_SET, Crystal_AugmentTags.Items.LUMIUM_TOOLS, Crystal_AugmentTags.Items.LUMIUM_ARMOR);
            toolsetTags(Crystal_AugmentItems.ENDERIUM_SET, Crystal_AugmentTags.Items.ENDERIUM_TOOLS, Crystal_AugmentTags.Items.ENDERIUM_ARMOR);

            toolsetTags(Crystal_AugmentItems.SOUL_INFUSED_SET, Crystal_AugmentTags.Items.SOUL_INFUSED_TOOLS, Crystal_AugmentTags.Items.SOUL_INFUSED_ARMOR);
            toolsetTags(Crystal_AugmentItems.SHELLITE_SET, Crystal_AugmentTags.Items.SHELLITE_TOOLS, Crystal_AugmentTags.Items.SHELLITE_ARMOR);
            toolsetTags(Crystal_AugmentItems.TWINITE_SET, Crystal_AugmentTags.Items.TWINITE_TOOLS, Crystal_AugmentTags.Items.TWINITE_ARMOR);
            toolsetTags(Crystal_AugmentItems.DRAGONSTEEL_SET, Crystal_AugmentTags.Items.DRAGONSTEEL_TOOLS, Crystal_AugmentTags.Items.DRAGONSTEEL_ARMOR);
            toolsetTags(Crystal_AugmentItems.ABYSSAL_SET, Crystal_AugmentTags.Items.ABYSSAL_TOOLS, Crystal_AugmentTags.Items.ABYSSAL_ARMOR);

            tag(ThermalTags.Items.MACHINE_DIES).add(Crystal_AugmentItems.PRESS_ROD_DIE.get());

            tag(Tags.Items.RODS).add(
                    Crystal_AugmentItems.COPPER_ROD.get(),
                    Crystal_AugmentItems.IRON_ROD.get(),
                    Crystal_AugmentItems.GOLD_ROD.get(),
                    Crystal_AugmentItems.DIAMOND_ROD.get(),
                    Crystal_AugmentItems.EMERALD_ROD.get(),
                    Crystal_AugmentItems.NETHERITE_ROD.get(),
                    Crystal_AugmentItems.LEAD_ROD.get(),
                    Crystal_AugmentItems.TIN_ROD.get(),
                    Crystal_AugmentItems.SILVER_ROD.get(),
                    Crystal_AugmentItems.NICKEL_ROD.get(),
                    Crystal_AugmentItems.BRONZE_ROD.get(),
                    Crystal_AugmentItems.ELECTRUM_ROD.get(),
                    Crystal_AugmentItems.CONSTANTAN_ROD.get(),
                    Crystal_AugmentItems.INVAR_ROD.get(),
                    Crystal_AugmentItems.SIGNALUM_ROD.get(),
                    Crystal_AugmentItems.LUMIUM_ROD.get(),
                    Crystal_AugmentItems.ENDERIUM_ROD.get(),
                    Crystal_AugmentItems.SOUL_INFUSED_ROD.get(),
                    Crystal_AugmentItems.SHELLITE_ROD.get(),
                    Crystal_AugmentItems.TWINITE_ROD.get(),
                    Crystal_AugmentItems.DRAGONSTEEL_ROD.get(),
                    Crystal_AugmentItems.ABYSSAL_ROD.get()
            );

            tag(Crystal_AugmentTags.Items.RODS_COPPER).add(Crystal_AugmentItems.COPPER_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_IRON).add(Crystal_AugmentItems.IRON_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_GOLD).add(Crystal_AugmentItems.GOLD_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_DIAMOND).add(Crystal_AugmentItems.DIAMOND_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_EMERALD).add(Crystal_AugmentItems.EMERALD_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_NETHERITE).add(Crystal_AugmentItems.NETHERITE_ROD.get());

            tag(Crystal_AugmentTags.Items.RODS_LEAD).add(Crystal_AugmentItems.LEAD_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_TIN).add(Crystal_AugmentItems.TIN_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_SILVER).add(Crystal_AugmentItems.SILVER_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_NICKEL).add(Crystal_AugmentItems.NICKEL_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_BRONZE).add(Crystal_AugmentItems.BRONZE_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_ELECTRUM).add(Crystal_AugmentItems.ELECTRUM_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_CONSTANTAN).add(Crystal_AugmentItems.CONSTANTAN_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_INVAR).add(Crystal_AugmentItems.INVAR_ROD.get());

            tag(Crystal_AugmentTags.Items.RODS_SIGNALUM).add(Crystal_AugmentItems.SIGNALUM_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_LUMIUM).add(Crystal_AugmentItems.LUMIUM_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_ENDERIUM).add(Crystal_AugmentItems.ENDERIUM_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_SOUL_INFUSED).add(Crystal_AugmentItems.SOUL_INFUSED_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_SHELLITE).add(Crystal_AugmentItems.SHELLITE_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_TWINITE).add(Crystal_AugmentItems.TWINITE_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_DRAGONSTEEL).add(Crystal_AugmentItems.DRAGONSTEEL_ROD.get());
            tag(Crystal_AugmentTags.Items.RODS_ABYSSAL).add(Crystal_AugmentItems.ABYSSAL_ROD.get());

            tag(Tags.Items.STORAGE_BLOCKS).add(
                    Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get().asItem(),
                    Crystal_AugmentBlocks.SHELLITE_BLOCK.get().asItem(),
                    Crystal_AugmentBlocks.TWINITE_BLOCK.get().asItem(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get().asItem(),
                    Crystal_AugmentBlocks.ABYSSAL_BLOCK.get().asItem()
            );

//            tag(TinkerTags.Items.ANVIL_METAL).add(
//                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get().asItem(),
//                    ThermalExtraBlocks.SHELLITE_BLOCK.get().asItem(),
//                    ThermalExtraBlocks.TWINITE_BLOCK.get().asItem(),
//                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get().asItem()
//            );

            tag(ThermalTags.Items.HARDENED_GLASS).add(
                    Crystal_AugmentBlocks.SOUL_INFUSED_GLASS.get().asItem(),
                    Crystal_AugmentBlocks.SHELLITE_GLASS.get().asItem(),
                    Crystal_AugmentBlocks.TWINITE_GLASS.get().asItem(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_GLASS.get().asItem(),
                    Crystal_AugmentBlocks.ABYSSAL_GLASS.get().asItem()
            );

            tag(Crystal_AugmentTags.Items.STORAGE_BLOCKS_SOUL_INFUSED).add(Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get().asItem());
            tag(Crystal_AugmentTags.Items.STORAGE_BLOCKS_SHELLITE).add(Crystal_AugmentBlocks.SHELLITE_BLOCK.get().asItem());
            tag(Crystal_AugmentTags.Items.STORAGE_BLOCKS_TWINITE).add(Crystal_AugmentBlocks.TWINITE_BLOCK.get().asItem());
            tag(Crystal_AugmentTags.Items.STORAGE_BLOCKS_DRAGONSTEEL).add(Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get().asItem());
            tag(Crystal_AugmentTags.Items.STORAGE_BLOCKS_ABYSSAL).add(Crystal_AugmentBlocks.ABYSSAL_BLOCK.get().asItem());
        }

        private void toolsetTags(ToolSetObject set, TagKey<Item> tool, TagKey<Item> armor) {
            tag(tool).add(
                    set.axe().get(),
                    set.pickaxe().get(),
                    set.shovel().get(),
                    set.hoe().get(),
                    set.sword().get(),
                    set.excavator().get(),
                    set.hammer().get(),
                    set.knife().get(),
                    set.sickle().get()
            );

            tag(armor).add(
                    set.helmet().get(),
                    set.chestplate().get(),
                    set.leggings().get(),
                    set.boots().get()
            );
        }
    }

    public static class BlockTags extends BlockTagsProvider {

        public BlockTags(PackOutput gen, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(gen, completableFuture, Crystal_Augment.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {

            tag(ThermalTags.Blocks.HARDENED_GLASS).add(
                    Crystal_AugmentBlocks.SOUL_INFUSED_GLASS.get(),
                    Crystal_AugmentBlocks.SHELLITE_GLASS.get(),
                    Crystal_AugmentBlocks.TWINITE_GLASS.get(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_GLASS.get(),
                    Crystal_AugmentBlocks.ABYSSAL_GLASS.get()
            );

            tag(Tags.Blocks.GLASS).add(
                    Crystal_AugmentBlocks.SOUL_INFUSED_GLASS.get(),
                    Crystal_AugmentBlocks.SHELLITE_GLASS.get(),
                    Crystal_AugmentBlocks.TWINITE_GLASS.get(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_GLASS.get(),
                    Crystal_AugmentBlocks.ABYSSAL_GLASS.get()
            );

//            tag(TinkerTags.Blocks.ANVIL_METAL).add(
//                    ThermalExtraBlocks.SOUL_INFUSED_BLOCK.get(),
//                    ThermalExtraBlocks.SHELLITE_BLOCK.get(),
//                    ThermalExtraBlocks.TWINITE_BLOCK.get(),
//                    ThermalExtraBlocks.DRAGONSTEEL_BLOCK.get()
//            );

            tag(Tags.Blocks.STORAGE_BLOCKS).add(
                    Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get(),
                    Crystal_AugmentBlocks.SHELLITE_BLOCK.get(),
                    Crystal_AugmentBlocks.TWINITE_BLOCK.get(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get(),
                    Crystal_AugmentBlocks.ABYSSAL_BLOCK.get()
            );

            tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(
                    Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get(),
                    Crystal_AugmentBlocks.SHELLITE_BLOCK.get(),
                    Crystal_AugmentBlocks.TWINITE_BLOCK.get(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get(),
                    Crystal_AugmentBlocks.ABYSSAL_BLOCK.get()
            );

            tag(Crystal_AugmentTags.Blocks.SOUL_INFUSED_BLOCK).add(Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get());
            tag(Crystal_AugmentTags.Blocks.SHELLITE_BLOCK).add(Crystal_AugmentBlocks.SHELLITE_BLOCK.get());
            tag(Crystal_AugmentTags.Blocks.TWINITE_BLOCK).add(Crystal_AugmentBlocks.TWINITE_BLOCK.get());
            tag(Crystal_AugmentTags.Blocks.DRAGONSTEEL_BLOCK).add(Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get());
            tag(Crystal_AugmentTags.Blocks.ABYSSAL_BLOCK).add(Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get());

            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
                    Crystal_AugmentBlocks.SOUL_INFUSED_BLOCK.get(),
                    Crystal_AugmentBlocks.SHELLITE_BLOCK.get(),
                    Crystal_AugmentBlocks.TWINITE_BLOCK.get(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_BLOCK.get(),
                    Crystal_AugmentBlocks.SOUL_INFUSED_GLASS.get(),
                    Crystal_AugmentBlocks.SHELLITE_GLASS.get(),
                    Crystal_AugmentBlocks.TWINITE_GLASS.get(),
                    Crystal_AugmentBlocks.DRAGONSTEEL_GLASS.get(),
                    Crystal_AugmentBlocks.ABYSSAL_BLOCK.get(),
                    Crystal_AugmentBlocks.DYNAMO_COLD.get(),
                    Crystal_AugmentBlocks.BLOCKS.get("device_lava_gen"),
                    Crystal_AugmentBlocks.BLOCKS.get("component_assembly"),
                    Crystal_AugmentBlocks.BLOCKS.get("endothermic_dehydrator"),
                    Crystal_AugmentBlocks.BLOCKS.get("nitratic_igniter"),
                    Crystal_AugmentBlocks.BLOCKS.get("advanced_refinery"),
                    Crystal_AugmentBlocks.BLOCKS.get("fluid_mixer")
            );
        }
    }
}
