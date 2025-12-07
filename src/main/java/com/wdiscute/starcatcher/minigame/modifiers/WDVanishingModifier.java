package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;

// Makes vanish zones reappear on miss
public class WDVanishingModifier extends PermanentFishingModifier{
    public WDVanishingModifier(FishingMinigameScreen screen) {
        super(screen);
    }

    @Override
    public void onMissClick() {
        screen.fishingHitZones.forEach(zone -> zone.setVanishValue(1f));
    }
}
