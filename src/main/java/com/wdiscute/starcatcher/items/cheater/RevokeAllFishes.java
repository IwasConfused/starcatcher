package com.wdiscute.starcatcher.items.cheater;

import com.wdiscute.starcatcher.io.*;
import com.wdiscute.starcatcher.io.attachments.FishingGuideAttachment;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class RevokeAllFishes extends Item
{
    public RevokeAllFishes()
    {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
    {
        //reset fishes caught
        FishingGuideAttachment fishingGuideAttachment = ModDataAttachments.get(player, ModDataAttachments.FISHING_GUIDE);
        fishingGuideAttachment.fishesCaught.clear();
        fishingGuideAttachment.fishNotifications.clear();

        FishingGuideAttachment.sync(player);

        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }

}
