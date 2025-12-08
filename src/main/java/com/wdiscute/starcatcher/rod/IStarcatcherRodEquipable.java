package com.wdiscute.starcatcher.rod;

import com.wdiscute.starcatcher.minigame.FishingHitZone;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import com.wdiscute.starcatcher.minigame.modifiers.AbstractFishingModifier;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface IStarcatcherRodEquipable {

    default void onInitializeMinigame(ItemStack equipable, FishingMinigameScreen screen, List<FishingHitZone> hitZones, List<AbstractFishingModifier> modifiers) {

    }

    default void onHitZoneCreation(ItemStack equipable, FishingHitZone hitZone, FishProperties properties, FishProperties.Difficulty difficulty){

    }
}
