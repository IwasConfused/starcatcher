package com.wdiscute.starcatcher.io.attachments;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.io.FishCaughtCounter;
import com.wdiscute.starcatcher.io.ModDataAttachments;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class FishingGuideAttachment {
    public List<FishCaughtCounter> fishesCaught;
    public List<ResourceLocation> trophiesCaught;
    public List<ResourceLocation> fishNotifications;
    public boolean receivedGuide;

    public FishingGuideAttachment(List<FishCaughtCounter> fishesCaught,  List<ResourceLocation> trophiesCaught, List<ResourceLocation> fishNotifications, boolean receivedGuide ) {
        this.fishesCaught = new ArrayList<>(fishesCaught); // makes sure the list is always mutable
        this.trophiesCaught = new ArrayList<>(trophiesCaught);
        this.fishNotifications = new ArrayList<>(fishNotifications);
        this.receivedGuide = receivedGuide;
    }

    public static FishingGuideAttachment createDefault() {
        return new FishingGuideAttachment(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                false);
    }

    public static final Codec<FishingGuideAttachment> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FishCaughtCounter.LIST_CODEC.fieldOf("fishes_caught").forGetter(data -> data.fishesCaught),
                    ResourceLocation.CODEC.listOf().fieldOf("trophies_caught").forGetter(data -> data.trophiesCaught),
                    ResourceLocation.CODEC.listOf().fieldOf("trophies_notifs").forGetter(data -> data.fishNotifications),
                    Codec.BOOL.lenientOptionalFieldOf("recieved_guide", false).forGetter(data -> data.receivedGuide)
            ).apply(instance, FishingGuideAttachment::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, FishingGuideAttachment> STREAM_CODEC = StreamCodec.composite(
            FishCaughtCounter.LIST_STREAM_CODEC, data -> data.fishesCaught,
            ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()), data -> data.trophiesCaught,
            ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()), data -> data.fishNotifications,
            ByteBufCodecs.BOOL, data -> data.receivedGuide,

            FishingGuideAttachment::new
    );

    public static FishingGuideAttachment get(Entity holder){
        return holder.getData(ModDataAttachments.FISHING_GUIDE);
    }

    public static void sync(Player player){
        player.syncData(ModDataAttachments.FISHING_GUIDE);
    }

    @SuppressWarnings("deprecation")
    public static boolean hasLegacyData(Player player){
        return ModDataAttachments.get(player, ModDataAttachments.RECEIVED_GUIDE) || ModDataAttachments.get(player, ModDataAttachments.FISHING_GUIDE).fishesCaught.size() > 1;
    }

    @SuppressWarnings("deprecation")
    public void loadFromLegacy(Player player){
        fishesCaught.addAll(ModDataAttachments.get(player, ModDataAttachments.FISHES_CAUGHT));
        fishNotifications.addAll(ModDataAttachments.get(player, ModDataAttachments.FISHES_NOTIFICATION));
        trophiesCaught.addAll(ModDataAttachments.get(player, ModDataAttachments.TROPHIES_CAUGHT));
        receivedGuide = ModDataAttachments.get(player, ModDataAttachments.RECEIVED_GUIDE) || receivedGuide;

        ModDataAttachments.remove(player, ModDataAttachments.FISHES_CAUGHT);
        ModDataAttachments.remove(player, ModDataAttachments.FISHES_NOTIFICATION);
        ModDataAttachments.remove(player, ModDataAttachments.TROPHIES_CAUGHT);
        ModDataAttachments.remove(player, ModDataAttachments.RECEIVED_GUIDE);
    }

}
