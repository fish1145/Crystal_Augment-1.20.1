package fish_dan.crystal_augment.item.augment;

import fish_dan.crystal_augment.init.Crystal_AugmentItems;
import net.minecraft.world.item.Rarity;

public enum ExtraAugmentType {

    SOUL_INFUSED(Crystal_AugmentItems.yellow),
    TWINITE(Crystal_AugmentItems.aqua),
    SHELLITE(Crystal_AugmentItems.dark_purple),
    DRAGONSTEEL(Crystal_AugmentItems.blue),
    ABYSSAL(Crystal_AugmentItems.green);

    public static final ExtraAugmentType[] VALUES = ExtraAugmentType.values();

    private final Rarity rarity;
    private final int tier;

    ExtraAugmentType(Rarity rarity) {
        this.rarity = rarity;
        this.tier = this.ordinal()+1;
    }

    public int getTier() {
        return tier;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
