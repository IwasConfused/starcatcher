package com.wdiscute.starcatcher.minigame.modifiers;

import com.wdiscute.starcatcher.minigame.FishingHitZone;
import com.wdiscute.starcatcher.minigame.FishingMinigameScreen;
import com.wdiscute.starcatcher.registry.ModItems;

public class ShinyHookModifier extends PermanentFishingModifier{
    public ShinyHookModifier(FishingMinigameScreen screen) {
        super(screen);
    }

    @Override
    public void onHit(FishingHitZone zone, boolean isFirstHit) {
        super.onHit(zone, isFirstHit);

        if (isFirstHit){
            if (screen.consecutiveHits == 3 && !screen.treasureActive){
                screen.addTreasure();
            }
        }
    }
}
