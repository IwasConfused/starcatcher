package com.wdiscute.starcatcher.items;

import com.wdiscute.starcatcher.items.helper.SingleStackBasicItem;
import com.wdiscute.starcatcher.minigame.FishingHitZone;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import com.wdiscute.starcatcher.minigame.modifiers.AbstractFishingModifier;
import com.wdiscute.starcatcher.minigame.modifiers.PermanentFishingModifier;
import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.rod.IStarcatcherRodEquipable;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class MossyHookItem extends SingleStackBasicItem implements IStarcatcherRodEquipable {
    @Override
    public void onHitZoneCreation(ItemStack equipable, FishingHitZone hitZone, FishProperties properties, FishProperties.Difficulty difficulty) {
        if (hitZone.isMoving && hitZone.moveRate < 3){
            hitZone.setMoving(true, 3f);
        }
    }

    @Override
    public void onInitializeMinigame(ItemStack equipable, FishingMinigameScreen screen, List<FishingHitZone> hitZones, List<AbstractFishingModifier> modifiers) {
        screen.difficulty = (screen.fishProperties.rarity().getId() < 3) ? FishProperties.Difficulty.MEDIUM_VANISHING_MOVING : screen.difficulty;

        hitZones.forEach(zone -> zone.setFromProperties(screen, screen.equipables));

        new PermanentFishingModifier(screen){
            @Override
            public boolean onSuccessfulCatch(boolean shouldAwardTreasure) {
                return screen.perfectCatch;
            }
        }
        .addModifier();
    }
}
