package com.wdiscute.starcatcher.registry.custom.catchmodifiers;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.bob.FishingBobEntity;
import com.wdiscute.starcatcher.io.FishCaughtCounter;
import com.wdiscute.starcatcher.io.ModDataAttachments;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public abstract class AbstractCatchModifier
{
    FishingBobEntity instance;

    //server and client
    public void onAdd(FishingBobEntity fishingBobEntity)
    {
        this.instance = fishingBobEntity;
    }

    //server only
    public int adjustMinTicksToFish(int minTicksToFish)
    {
        return minTicksToFish;
    }

    //server only
    public int adjustMaxTicksToFish(int maxTicksToFish)
    {
        return maxTicksToFish;
    }

    //server only
    public int adjustChanceToFishEachTick(int chanceToFishEachTick)
    {
        return chanceToFishEachTick;
    }

    //server only
    public void onReel()
    {

    }

    //server only
    public void onReelStart()
    {

    }

    //server only
    public void onReelAfterTreasureCheck()
    {

    }

    //server only
    public void beforeChoosingTheCatch(List<FishProperties> available)
    {
    }

    //server only
    public void afterChoosingTheCatch(List<FishProperties> available)
    {
    }

    //server only
    public boolean forceSkipMinigame(Boolean enableMinigameConfig)
    {
        return false;
    }

    //server only
    public boolean shouldStopFishing()
    {
        return false;
    }

    //server only
    public boolean forceSpawnEntity()
    {
        return false;
    }

    //server only
    public void onFailedMinigame()
    {
    }

    //server only
    public void onSuccessfulMinigameCompletion(ServerPlayer player, int time, boolean completedTreasure, boolean perfectCatch, int hits)
    {
    }

    //server only
    public boolean shouldCancelAfterSuccessfulMinigameCompletion(ServerPlayer player, int time, boolean completedTreasure, boolean perfectCatch, int hits)
    {
        return false;
    }

    //server only
    public ItemStack modifyItemStack(ItemStack is)
    {
        return is;
    }
}
