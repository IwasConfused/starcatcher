package com.wdiscute.starcatcher.items;

import com.wdiscute.starcatcher.items.helper.SingleStackBasicItem;
import com.wdiscute.starcatcher.minigame.FishingHitZone;
import com.wdiscute.starcatcher.rod.IStarcatcherRodEquipable;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.world.item.ItemStack;

public class StoneHookItem extends SingleStackBasicItem implements IStarcatcherRodEquipable {
    @Override
    public void onHitZoneCreation(ItemStack equipable, FishingHitZone hitZone, FishProperties properties, FishProperties.Difficulty difficulty) {
        switch (properties.rarity()) {
            case FishProperties.Rarity.COMMON -> hitZone.setGracePeriod(40);
            case FishProperties.Rarity.UNCOMMON -> hitZone.setGracePeriod(20);
            case FishProperties.Rarity.RARE -> hitZone.setGracePeriod(15);
            case FishProperties.Rarity.EPIC -> hitZone.setGracePeriod(10);
            case FishProperties.Rarity.LEGENDARY -> hitZone.setGracePeriod(5);
            default ->  hitZone.setGracePeriod(11);
        }
    }
}
