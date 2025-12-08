package com.wdiscute.starcatcher.items;

import com.wdiscute.starcatcher.items.helper.SingleStackBasicItem;
import com.wdiscute.starcatcher.minigame.FishingHitZone;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import com.wdiscute.starcatcher.minigame.HitZoneType;
import com.wdiscute.starcatcher.minigame.modifiers.AbstractFishingModifier;
import com.wdiscute.starcatcher.rod.IStarcatcherRodEquipable;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.world.item.ItemStack;

import java.util.List;

import static com.wdiscute.starcatcher.minigame.HitZoneType.Presets.*;

public class SteadyBobberItem extends SingleStackBasicItem implements IStarcatcherRodEquipable {
    @Override
    public void onInitializeMinigame(ItemStack equipable, FishingMinigameScreen screen, List<FishingHitZone> hitZones, List<AbstractFishingModifier> modifiers) {
    }

    @Override
    public void onHitZoneCreation(ItemStack equipable, FishingHitZone zone, FishProperties properties, FishProperties.Difficulty difficulty) {
        if (zone.type == HitZoneType.NORMAL){
            zone.setRendering(makeDefaultRenderConsumer(FishingMinigameScreen.TEXTURE, 0, 0));
            zone.setForgiving(SIZE_4);
        }

        if (zone.type == HitZoneType.THIN){
            zone.setRendering(makeDefaultRenderConsumer(FishingMinigameScreen.TEXTURE, 32, 0));
            zone.setForgiving(SIZE_2);
        }
    }
}
