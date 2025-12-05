package com.wdiscute.starcatcher;

import com.wdiscute.libtooltips.Tooltips;
import com.wdiscute.starcatcher.blocks.ModBlockEntities;
import com.wdiscute.starcatcher.blocks.ModBlocks;
import com.wdiscute.starcatcher.bob.FishingBobModel;
import com.wdiscute.starcatcher.bob.FishingBobRenderer;
import com.wdiscute.starcatcher.fishentity.FishEntity;
import com.wdiscute.starcatcher.fishentity.FishRenderer;
import com.wdiscute.starcatcher.fishentity.fishmodels.*;
import com.wdiscute.starcatcher.fishspotter.FishTrackerLayer;
import com.wdiscute.starcatcher.guide.FishCaughtToast;
import com.wdiscute.starcatcher.guide.SettingsScreen;
import com.wdiscute.starcatcher.io.*;
import com.wdiscute.starcatcher.io.network.*;
import com.wdiscute.starcatcher.io.network.tournament.*;
import com.wdiscute.starcatcher.io.network.tournament.stand.*;
import com.wdiscute.starcatcher.particles.FishingBitingLavaParticles;
import com.wdiscute.starcatcher.particles.FishingBitingParticles;
import com.wdiscute.starcatcher.particles.FishingNotificationParticles;
import com.wdiscute.starcatcher.registry.*;
import com.wdiscute.starcatcher.rod.FishingRodScreen;
import com.wdiscute.starcatcher.storage.FishProperties;
import com.wdiscute.starcatcher.storage.TrophyProperties;
import com.wdiscute.starcatcher.tournament.StandScreen;
import com.wdiscute.starcatcher.tournament.TournamentHandler;
import com.wdiscute.starcatcher.tournament.TournamentOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

import java.util.List;
import java.util.Random;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Starcatcher.MOD_ID)
public class Starcatcher {
    public static final String MOD_ID = "starcatcher";

    public static final ResourceKey<Registry<FishProperties>> FISH_REGISTRY =
            ResourceKey.createRegistryKey(Starcatcher.rl("fish"));

    public static final ResourceKey<Registry<TrophyProperties>> TROPHY_REGISTRY =
            ResourceKey.createRegistryKey(Starcatcher.rl("trophy"));

    public static final Random r = new Random();

    public static double truncatedNormal(double mean, double deviation) {
        while (true) {
            double value = mean + deviation * r.nextGaussian();
            if (value >= mean - deviation && value <= mean + deviation) {
                return value;
            }
        }
    }

    public static ResourceLocation rl(String s) {
        return ResourceLocation.fromNamespaceAndPath(Starcatcher.MOD_ID, s);
    }

    @OnlyIn(Dist.CLIENT)
    public static void fishCaughtToast(FishProperties fp, boolean newFish, int sizeCM, int weightCM) {
        if (newFish) Minecraft.getInstance().getToasts().addToast(new FishCaughtToast(fp));

        SettingsScreen.Units units = Config.UNIT.get();

        String size = units.getSizeAsString(sizeCM);
        String weight = units.getWeightAsString(weightCM);

        Minecraft.getInstance().player.displayClientMessage(
                Component.literal("")
                        .append(Component.translatable(fp.catchInfo().fish().value().getDescriptionId()).withStyle(fp.rarity().getColor()))
                        .append(Component.literal(" - " + size + " - " + weight))
                , true);

        Minecraft.getInstance().gui.overlayMessageTime = 180;

    }


    public Starcatcher(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeModeTabs.register(modEventBus);
        ModItems.ITEMS_REGISTRY.register(modEventBus);
        ModItems.RODS_REGISTRY.register(modEventBus);
        ModItems.OTHERS_REGISTRY.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);
        ModParticles.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModDataAttachments.register(modEventBus);
        ModCriterionTriggers.REGISTRY.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC_SERVER);
    }
}
