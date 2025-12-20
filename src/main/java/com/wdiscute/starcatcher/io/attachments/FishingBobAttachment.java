package com.wdiscute.starcatcher.io.attachments;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.UUID;

public class FishingBobAttachment {
    private String uuid;

    public FishingBobAttachment(String uuid) {
        this.uuid = uuid;
    }

    public static final Codec<FishingBobAttachment> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("uuid").forGetter(data -> data.uuid)
            ).apply(instance, FishingBobAttachment::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, FishingBobAttachment> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, data -> data.uuid,
            FishingBobAttachment::new
    );

    public boolean isEmpty() {
        return uuid.isEmpty();
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid.toString();
    }

    public UUID getUuid() {
        return UUID.fromString(uuid);
    }

}
