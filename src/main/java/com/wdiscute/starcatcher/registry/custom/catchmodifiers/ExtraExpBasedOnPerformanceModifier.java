package com.wdiscute.starcatcher.registry.custom.catchmodifiers;

import net.minecraft.server.level.ServerPlayer;

public class ExtraExpBasedOnPerformanceModifier extends AbstractCatchModifier
{
    @Override
    public void onSuccessfulMinigameCompletion(ServerPlayer player, int time, boolean completedTreasure, boolean perfectCatch, int hits)
    {
        super.onSuccessfulMinigameCompletion(player, time, completedTreasure, perfectCatch, hits);
        player.giveExperiencePoints(instance.fpToFish.rarity().getXp() * (hits / 3) + 1);
    }
}

