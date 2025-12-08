package com.wdiscute.starcatcher.items;

import com.wdiscute.starcatcher.items.helper.SingleStackBasicItem;
import com.wdiscute.starcatcher.minigame.FishingHitZone;
import com.wdiscute.starcatcher.rod.IStarcatcherRodEquipable;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.world.item.ItemStack;

public class ClearBobberItem extends SingleStackBasicItem implements IStarcatcherRodEquipable {

    @Override
    public void onHitZoneCreation(ItemStack equipable, FishingHitZone hitZone, FishProperties properties, FishProperties.Difficulty difficulty) {
        if (hitZone.isVanishing){
            hitZone.setVanishing(true, hitZone.vanishingRate / 2, hitZone.removeOnVanish);
        }
    }
}
