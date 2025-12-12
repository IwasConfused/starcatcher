package com.wdiscute.starcatcher.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.datafixers.util.Either;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.io.network.FishingStartedPayload;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ResourceOrTagKeyArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Optional;

public class MinigameCommand
{
    private static final DynamicCommandExceptionType ERROR_ROD = new DynamicCommandExceptionType(
            component -> Component.translatableEscape("commands.starcatcher.rod_not_found", component)
    );

    private static final DynamicCommandExceptionType ERROR_FISH_ENTRY_INVALID = new DynamicCommandExceptionType(
            p_304258_ -> Component.translatableEscape("commands.starcatcher.fish_entry_not_found", p_304258_)
    );

    public static final LiteralArgumentBuilder<CommandSourceStack>
            COMMAND = Commands.literal("starcatcher")
            .requires(sourceStack -> sourceStack.hasPermission(2))
            .then(
                    Commands.argument("fish_entry", ResourceOrTagKeyArgument.resourceOrTagKey(Starcatcher.FISH_REGISTRY))
                            .executes(context ->
                                    startMinigame(
                                            context.getSource().getPlayerOrException(),
                                            ResourceOrTagKeyArgument.getResourceOrTagKey(
                                                    context,
                                                    "fish_entry",
                                                    Starcatcher.FISH_REGISTRY,
                                                    ERROR_FISH_ENTRY_INVALID)
                                    )
                            ));

    private static int startMinigame(ServerPlayer player, ResourceOrTagKeyArgument.Result<FishProperties> fishPropertiesResult) throws CommandSyntaxException
    {
        //serverside
        Level level = player.level();

        if (!player.getMainHandItem().is(StarcatcherTags.RODS)) throw ERROR_ROD.create(null);

        Either<ResourceKey<FishProperties>, TagKey<FishProperties>> unwrap = fishPropertiesResult.unwrap();
        Optional<ResourceKey<FishProperties>> left = unwrap.left();

        if (left.isPresent())
        {
            ResourceLocation location = left.get().location();
            Optional<FishProperties> rl = level.registryAccess().registryOrThrow(Starcatcher.FISH_REGISTRY).getOptional(location);

            if (rl.isPresent())
            {
                PacketDistributor.sendToPlayer(
                        player,
                        new FishingStartedPayload(rl.get(), player.getMainHandItem()));
                return 1;
            }
            else
            {
                throw ERROR_FISH_ENTRY_INVALID.create(rl);
            }
        }
        throw ERROR_FISH_ENTRY_INVALID.create(unwrap.right());
    }
}
