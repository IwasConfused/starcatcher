package com.wdiscute.starcatcher.event;

import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.fishentity.FishEntity;
import com.wdiscute.starcatcher.io.network.FPsSeenPayload;
import com.wdiscute.starcatcher.io.network.FishCaughtPayload;
import com.wdiscute.starcatcher.io.network.FishingCompletedPayload;
import com.wdiscute.starcatcher.io.network.FishingPayload;
import com.wdiscute.starcatcher.io.network.tournament.CBActiveTournamentUpdatePayload;
import com.wdiscute.starcatcher.io.network.tournament.stand.*;
import com.wdiscute.starcatcher.registry.ModEntities;
import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.TrophyProperties;
import com.wdiscute.starcatcher.tournament.TournamentHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

@EventBusSubscriber(modid = Starcatcher.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void levelTick(ServerTickEvent.Post event) {
        TournamentHandler.tick(event);
    }

    @SubscribeEvent
    public static void addRegistry(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(
                Starcatcher.FISH_REGISTRY, FishProperties.CODEC, FishProperties.CODEC,
                builder -> builder.maxId(512));

        event.dataPackRegistry(
                Starcatcher.TROPHY_REGISTRY, TrophyProperties.CODEC, TrophyProperties.CODEC,
                builder -> builder.maxId(256));
    }

    @SubscribeEvent
    public static void registerAttributed(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FISH.get(), FishEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerPayloads(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(
                FishingPayload.TYPE,
                FishingPayload.STREAM_CODEC,
                FishingPayload::handle
        );

        registrar.playToServer(
                FishingCompletedPayload.TYPE,
                FishingCompletedPayload.STREAM_CODEC,
                FishingCompletedPayload::handle
        );

        registrar.playToClient(
                FishCaughtPayload.TYPE,
                FishCaughtPayload.STREAM_CODEC,
                FishCaughtPayload::handle
        );

        registrar.playToServer(
                FPsSeenPayload.TYPE,
                FPsSeenPayload.STREAM_CODEC,
                FPsSeenPayload::handle
        );

        registrar.playToClient(
                CBStandTournamentUpdatePayload.TYPE,
                CBStandTournamentUpdatePayload.STREAM_CODEC,
                CBStandTournamentUpdatePayload::handle
        );

        registrar.playToServer(
                SBStandTournamentNameChangePayload.TYPE,
                SBStandTournamentNameChangePayload.STREAM_CODEC,
                SBStandTournamentNameChangePayload::handle
        );

        registrar.playToServer(
                SBStandTournamentDurationChangePayload.TYPE,
                SBStandTournamentDurationChangePayload.STREAM_CODEC,
                SBStandTournamentDurationChangePayload::handle
        );

        registrar.playToServer(
                SBStandTournamentScoringTypeChangePayload.TYPE,
                SBStandTournamentScoringTypeChangePayload.STREAM_CODEC,
                SBStandTournamentScoringTypeChangePayload::handle
        );

        registrar.playToClient(
                CBActiveTournamentUpdatePayload.TYPE,
                CBActiveTournamentUpdatePayload.STREAM_CODEC,
                CBActiveTournamentUpdatePayload::handle
        );

        registrar.playToServer(
                SBStandTournamentStartCancelPayload.TYPE,
                SBStandTournamentStartCancelPayload.STREAM_CODEC,
                SBStandTournamentStartCancelPayload::handle
        );
    }

}
