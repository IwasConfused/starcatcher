package com.wdiscute.starcatcher.tournament;

import com.mojang.authlib.GameProfile;
import com.wdiscute.starcatcher.io.FishProperties;
import com.wdiscute.starcatcher.io.SingleStackContainer;
import com.wdiscute.starcatcher.io.network.TournamentUpdatePayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.GameProfileCache;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.*;

public class TournamentHandler
{
    private static final List<Tournament> finishedTournaments = new ArrayList<>();
    private static final List<Tournament> activeTournaments = new ArrayList<>();
    private static final List<Tournament> setupTournaments = new ArrayList<>();

    public static Tournament getTournament(UUID uuid)
    {
        for (Tournament t : setupTournaments)
        {
            if (t.tournamentUUID.equals(uuid)) return t;
        }

        for (Tournament t : activeTournaments)
        {
            if (t.tournamentUUID.equals(uuid)) return t;
        }

        for (Tournament t : finishedTournaments)
        {
            if (t.tournamentUUID.equals(uuid)) return t;
        }

        Tournament tournament = new Tournament(
                uuid,
                "Unnamed Tournament",
                Tournament.Status.SETUP,
                null,
                new HashMap<>(),
                new TournamentSettings(
                        TournamentSettings.Scoring.SIMPLE,
                        110660,
                        0,
                        0,
                        SingleStackContainer.EMPTY_LIST),
                SingleStackContainer.EMPTY_LIST,
                200
        );

        setupTournaments.add(tournament);
        return tournament;
    }

    public static void startTournament(Tournament tournament)
    {
        activeTournaments.add(tournament);
        setupTournaments.remove(tournament);
        tournament.status = Tournament.Status.ACTIVE;
        System.out.println("tournament: " + tournament.name + " has started");
    }


    public static void addScore(Player player, FishProperties fp, boolean perfectCatch, int size, int weight)
    {
        if(player.level().isClientSide) return;
        for (Tournament t : activeTournaments)
        {
            if (t.playerScores.containsKey(player.getUUID()))
            {
                if (t.settings.scoring.equals(TournamentSettings.Scoring.SIMPLE))
                {
                    t.playerScores.get(player.getUUID()).addScore(1);
                }
            }
        }
    }

    public static void setName(ServerPlayer player, UUID uuid, String name)
    {
        if(player.level().isClientSide) return;
        for (Tournament t : setupTournaments)
        {
            if(t.tournamentUUID.equals(uuid) && player.getUUID().equals(t.owner))
            {
                t.name = name;
                PacketDistributor.sendToAllPlayers(TournamentUpdatePayload.helper(player, t));
            }
        }
    }

    public static void setScoring(ServerPlayer player, UUID uuid, TournamentSettings.Scoring scoringType)
    {
        if(player.level().isClientSide) return;
        for (Tournament t : setupTournaments)
        {
            if(t.tournamentUUID.equals(uuid) && player.getUUID().equals(t.owner))
            {
                t.settings.scoring = scoringType;
                PacketDistributor.sendToAllPlayers(TournamentUpdatePayload.helper(player, t));
            }
        }
    }

    public static void tick(ServerTickEvent.Post event)
    {
        long levelTicks = event.getServer().getTickCount();
        if (levelTicks % 20 != 0) return;

        List<Tournament> finishedTournaments = new ArrayList<>();
        for (Tournament t : activeTournaments)
        {
            if (levelTicks >= t.lastsUntil)
            {
                finishedTournaments.add(t);
                System.out.println("tournament: " + t.name + " has ended");

                UUID winner = null;
                int bestScore = 0;

                for (Map.Entry<UUID, TournamentPlayerScore> entry : t.playerScores.entrySet())
                {
                    if (entry.getValue().score > bestScore)
                    {
                        bestScore = entry.getValue().score;
                        winner = entry.getKey();
                    }
                }

                Level level = null;

                if (winner == null)
                {
                    System.out.println("no one won :(");
                }
                else
                {
                    GameProfileCache profileCache = event.getServer().getProfileCache();

                    if (profileCache == null)
                    {
                        System.out.println("unknown player won looooooool who tf is that " + winner);
                    }
                    else
                    {
                        Optional<GameProfile> gameProfile = event.getServer().getProfileCache().get(winner);

                        if (gameProfile.isPresent())
                        {
                            System.out.println("Winner is " + gameProfile.get().getName());
                        }
                        else
                        {
                            System.out.println("unknown player won looooooool who tf is that " + winner);
                        }
                    }


                }


            }
        }

        activeTournaments.removeAll(finishedTournaments);
    }

}
