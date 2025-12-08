package com.wdiscute.starcatcher.items;

import com.wdiscute.starcatcher.items.helper.SingleStackBasicItem;
import com.wdiscute.starcatcher.minigame.FishingHitZone;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import com.wdiscute.starcatcher.minigame.modifiers.AbstractFishingModifier;
import com.wdiscute.starcatcher.rod.IStarcatcherRodEquipable;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class StabilizingHookItem extends SingleStackBasicItem implements IStarcatcherRodEquipable {
    @Override
    public void onInitializeMinigame(ItemStack equipable, FishingMinigameScreen screen, List<FishingHitZone> hitZones, List<AbstractFishingModifier> modifiers) {
        screen.changeRotation = false;
    }
}
