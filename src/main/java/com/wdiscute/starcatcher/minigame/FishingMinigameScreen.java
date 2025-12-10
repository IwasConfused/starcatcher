package com.wdiscute.starcatcher.minigame;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.wdiscute.libtooltips.Tooltips;
import com.wdiscute.starcatcher.Config;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.StarcatcherTags;
import com.wdiscute.starcatcher.io.ModDataComponents;
import com.wdiscute.starcatcher.io.network.FishingCompletedPayload;
import com.wdiscute.starcatcher.items.ColorfulSmithingTemplate;
import com.wdiscute.starcatcher.minigame.modifiers.FreezeModifier;
import com.wdiscute.starcatcher.minigame.modifiers.FrozenSweetSpotModifier;
import com.wdiscute.starcatcher.registry.ModItems;
import com.wdiscute.starcatcher.registry.ModKeymappings;
import com.wdiscute.starcatcher.minigame.modifiers.AbstractModifier;
import com.wdiscute.starcatcher.storage.FishProperties;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.network.PacketDistributor;
import org.joml.Quaternionf;
import org.joml.Random;
import org.joml.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class FishingMinigameScreen extends Screen implements GuiEventListener
{
    public static final Random r = new Random();

    public static final ResourceLocation TEXTURE = Starcatcher.rl("textures/gui/minigame/minigame.png");
    private static final ResourceLocation NETHER = Starcatcher.rl("textures/gui/minigame/nether.png");
    private static final ResourceLocation CAVE = Starcatcher.rl("textures/gui/minigame/cave.png");
    private static final ResourceLocation SURFACE = Starcatcher.rl("textures/gui/minigame/surface.png");
    public ResourceLocation tankTexture = SURFACE;

    public final FishProperties fishProperties;
    public FishProperties.Difficulty difficulty;

    public final ItemStack itemBeingFished;
    public final ItemStack bobber;
    public final ItemStack bobberSkin;
    public final ItemStack bait;
    public final ItemStack hook;
    public final ItemStack treasureIS;

    public final InteractionHand hand;

    public int penalty;
    public int decay;

    public boolean changeRotation;

    public float lastHitMarkerPos = 0;
    public float missedHitAlpha = 0;
    private float landedHitAlpha = 0;

    public int gracePeriod = 80;
    public boolean minigameStarted;

    public float pointerSpeed;
    public final float pointerBaseSpeed;

    public int tickCount = 0;
    public int pointerPos = 0;
    public int currentRotation = 1;
    public float partial;
    public float hitDelay;

    public int completion = 20;
    public int completionSmooth = 20;

    public boolean perfectCatch = true;
    public int consecutiveHits = 0;

    public boolean treasureActive;
    public int treasureProgress = 0;
    public int treasureProgressSmooth = 0;

    List<HitFakeParticle> hitParticles = new ArrayList<>();

    public int previousGuiScale;


    // Nikdo53 values, these are mine dont steal them
    public final int holdingDelay = 6;
    public int holdingTicks = 0;
    private boolean isHoldingKey = false;
    private boolean isHoldingMouse = false;

    public List<ActiveSweetSpot> activeSweetSpots = new ArrayList<>();
    public List<AbstractModifier> modifiers = new ArrayList<>();

    public FishingMinigameScreen(FishProperties fp, ItemStack rod)
    {
        super(Component.empty());

        previousGuiScale = Minecraft.getInstance().options.guiScale().get();
        if (!ModList.get().isLoaded("distanthorizons"))
            Minecraft.getInstance().options.guiScale().set(Config.MINIGAME_GUI_SCALE.get());

        hitDelay = Config.HIT_DELAY.get().floatValue();

        this.fishProperties = fp;
        this.difficulty = fp.dif();

        //if override is not missingno (default) then use the override item set
        if (!fp.catchInfo().overrideMinigameWith().is(ModItems.MISSINGNO.getKey()))
            this.itemBeingFished = new ItemStack(fp.catchInfo().overrideMinigameWith());
        else
            this.itemBeingFished = new ItemStack(fp.catchInfo().fish());

        this.bobber = rod.get(ModDataComponents.BOBBER).stack().copy();
        this.bobberSkin = rod.get(ModDataComponents.BOBBER_SKIN).stack().copy();
        this.bait = rod.get(ModDataComponents.BAIT).stack().copy();
        this.hook = rod.get(ModDataComponents.HOOK).stack().copy();

        treasureIS = new ItemStack(BuiltInRegistries.ITEM.get(fp.dif().treasure().loot()));

        //tank texture change
        ClientLevel level = Minecraft.getInstance().level;
        ResourceKey<Level> dim = level.dimension();
        Player player = Minecraft.getInstance().player;
        if (player.getY() < 50 && dim.equals(Level.OVERWORLD))
            tankTexture = CAVE;

        if (dim.equals(Level.NETHER))
            tankTexture = NETHER;

        //base - a lot of these are now hitZone-based
        this.pointerSpeed = difficulty.speed();
        this.pointerBaseSpeed = difficulty.speed();
        this.penalty = difficulty.penalty();
        this.decay = difficulty.decay();

        //add sweet spots from fp
        for (FishProperties.SweetSpot ss : fp.dif().sweetSpots())
        {
            activeSweetSpots.add(new ActiveSweetSpot(ss, bobber, bait, hook, this));
        }

        //add modifiers from fp
        for (ResourceLocation rl : fp.dif().modifiers())
        {
            modifiers.add(level.registryAccess().registryOrThrow(Starcatcher.MODIFIERS).get(rl));
        }


        activeSweetSpots.add(new ActiveSweetSpot(FishProperties.SweetSpot.NORMAL, bobber, bait, hook, this));
        activeSweetSpots.add(new ActiveSweetSpot(FishProperties.SweetSpot.THIN, bobber, bait, hook, this));

        modifiers.add(new FrozenSweetSpotModifier());


        hand = Minecraft.getInstance().player.getMainHandItem().is(StarcatcherTags.RODS) ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
    }

    public int getRandomFreePosition()
    {
        for (int i = 0; i < 100; i++)
        {
            int posBeingChecked = r.nextInt(360);

            //change 50 and 310 to be based on sweet spot size
            if (activeSweetSpots.stream().anyMatch(zone -> (Math.abs(zone.pos - posBeingChecked) < 50 || Math.abs(zone.pos - posBeingChecked) > 310)))
            {
                continue;
            }

            return posBeingChecked;
        }

        return r.nextInt(360);
    }

    //region render

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
    {
        super.renderBackground(guiGraphics, mouseX, mouseY, partialTick);

        PoseStack poseStack = guiGraphics.pose();
        partial = partialTick;

        if (treasureActive) renderTreasure(guiGraphics);

        renderMainElements(guiGraphics, width, height, isHoldingKey, tankTexture);

        //render all hit zones
        activeSweetSpots.forEach(zone -> zone.render(this, guiGraphics, partialTick, width, height));
        activeSweetSpots.forEach(zone -> zone.sweetSpotType.render(this, guiGraphics, partialTick, width, height));

        //wheel second layer
        guiGraphics.blit(
                TEXTURE, width / 2 - 32, height / 2 - 32,
                64, 64, 64, 192, 64, 64, 256, 256);

        //POINTER
        renderPointer(guiGraphics, partialTick, poseStack);

        //KIMBE MARKER
        renderHitMarker(guiGraphics, poseStack, width, height, missedHitAlpha, lastHitMarkerPos, bobber, 1, 0, 0);
        renderHitMarker(guiGraphics, poseStack, width, height, landedHitAlpha, lastHitMarkerPos, bobber, 0, 1, 0);

        renderDecor(guiGraphics, width, height, completionSmooth, itemBeingFished);

        if (consecutiveHits >= 3)
        {
            //todo render combo
            //renderCombo(guiGraphics, consecutiveHits, partialTick + tickCount);
        }

        //render modifiers
        modifiers.forEach(modifier -> modifier.render(this, guiGraphics, partialTick, poseStack, width, height));

        //render particles
        for (HitFakeParticle instance : hitParticles)
        {
            renderParticle(guiGraphics, instance, poseStack, width, height);
        }
    }

    private void renderCombo(GuiGraphics guiGraphics, int consecutiveHits, float delta)
    {
        PoseStack pose = guiGraphics.pose();
        pose.translate(width / 2f + 20, height / 2f - 40, 0);
        pose.mulPose(Axis.ZP.rotationDegrees(30));
        float f = 1.8F - Mth.abs(Mth.sin(delta % 20) * ((float) Math.PI * 2F) * 0.01F);
        pose.scale(f, f, 1);
        guiGraphics.drawCenteredString(this.font, Component.translatable("fishing.combo", consecutiveHits).withStyle(ChatFormatting.GOLD), 0, -5, -1);
    }

    public static void renderParticle(GuiGraphics guiGraphics, HitFakeParticle instance, PoseStack poseStack, int width, int height)
    {
        poseStack.pushPose();
        poseStack.translate(instance.pos.x, instance.pos.y, 0);
        RenderSystem.setShaderColor(instance.r, instance.g, instance.b, instance.a);

        guiGraphics.blit(
                TEXTURE, width / 2 - 8, height / 2 - 8,
                16, 16, 80, 160, 16, 16, 256, 256);

        RenderSystem.setShaderColor(1, 1, 1, 1);
        poseStack.popPose();
    }

    public static void renderPosTreasure(GuiGraphics guiGraphics, PoseStack poseStack, int width, int height, int posTreasure)
    {
        poseStack.pushPose();

        float centerX = width / 2f;
        float centerY = height / 2f;

        poseStack.translate(centerX, centerY, 0);
        poseStack.mulPose(new Quaternionf().rotateZ((float) Math.toRadians(posTreasure)));
        poseStack.translate(-centerX, -centerY, 0);

        guiGraphics.blit(
                TEXTURE, width / 2 - 8, height / 2 - 8 - 25,
                16, 16, 64, 160, 16, 16, 256, 256);

        poseStack.popPose();
    }

    public static void renderHitPos(GuiGraphics guiGraphics, float partialTick, PoseStack poseStack, int width, int height, int currentRotation, int moveRate, int difficultyBobberOffset, float hitPos, float hitPosVanishing, boolean isThin)
    {
        poseStack.pushPose();

        float centerX = width / 2f;
        float centerY = height / 2f;


        poseStack.translate(centerX, centerY, 0);
        poseStack.mulPose(new Quaternionf().rotateZ((float) Math.toRadians(hitPos - partialTick * currentRotation * moveRate)));
        poseStack.translate(-centerX, -centerY, 0);
        RenderSystem.setShaderColor(1, 1, 1, hitPosVanishing);
        RenderSystem.enableBlend();

        guiGraphics.blit(
                TEXTURE, width / 2 - 8, height / 2 - 8 - 25,
                16, 16, (isThin ? 48 : 16) - difficultyBobberOffset, 160, 16, 16, 256, 256);

        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
        poseStack.popPose();
    }

    public static void renderMainElements(GuiGraphics guiGraphics, int width, int height, boolean isHoldingSpace, ResourceLocation tankTexture)
    {
        //tank background
        guiGraphics.blit(
                tankTexture, width / 2 - 42 - 100, height / 2 - 48,
                85, 97, 0, 0, 85, 97, 85, 97);

        //wheel background
        guiGraphics.blit(
                TEXTURE, width / 2 - 32, height / 2 - 32,
                64, 64, 0, 192, 64, 64, 256, 256);

        //spacebar
        guiGraphics.blit(
                TEXTURE, width / 2 - 16, height / 2 + 40,
                32, 16, isHoldingSpace ? 48 : 0, 112, 32, 16, 256, 256);
    }

    public void renderTreasure(GuiGraphics guiGraphics)
    {
        renderTreasure(guiGraphics, width, height, treasureProgress, treasureProgressSmooth, treasureIS, bobber);
    }

    public static void renderTreasure(GuiGraphics guiGraphics, int width, int height, float treasureProgress, int treasureProgressSmooth, ItemStack treasureIS, ItemStack bobberSkin)
    {
        //treasure bar
        guiGraphics.blit(
                TEXTURE, width / 2 - 158, height / 2 - 42 + (int) (64 - (64f * treasureProgressSmooth) / 100),
                5, 64 * treasureProgressSmooth / 100,
                141, 6 + 64 - (float) (64 * treasureProgressSmooth) / 100,
                5, 64 * treasureProgressSmooth / 100,
                256, 256);

        //treasure chest?
        guiGraphics.blit(
                TEXTURE, width / 2 - 16 - 155, height / 2 - 48,
                32, 96, 96, 0, 32, 96, 256, 256);

        //render treasure on top of bar
        guiGraphics.renderItem(treasureIS, width / 2 - 163, ((int) ((float) height / 2 - (64f * treasureProgressSmooth) / 100) + 15));

        int color = Tooltips.hueToRGBInt(Tooltips.hue);
        if (bobberSkin.is(ModItems.PEARL_BOBBER_SMITHING_TEMPLATE))
            RenderSystem.setShaderColor(
                    (float) FastColor.ARGB32.red(color) / 255,
                    (float) FastColor.ARGB32.green(color) / 255,
                    (float) FastColor.ARGB32.blue(color) / 255,
                    1);
        if (bobberSkin.is(ModItems.COLORFUL_BOBBER_SMITHING_TEMPLATE))
            color = bobberSkin.get(ModDataComponents.BOBBER_COLOR).getColorAsInt();
        if (bobberSkin.is(ModItems.COLORFUL_BOBBER_SMITHING_TEMPLATE))
            RenderSystem.setShaderColor(
                    (float) FastColor.ARGB32.red(color) / 255,
                    (float) FastColor.ARGB32.green(color) / 255,
                    (float) FastColor.ARGB32.blue(color) / 255,
                    1);

        //outline when treasure complete
        if (treasureProgress > 99)
            guiGraphics.blit(
                    TEXTURE, width / 2 - 16 - 155, height / 2 - 48,
                    32, 96, 64, 0, 32, 96, 256, 256);

        if (bobberSkin.is(ModItems.COLORFUL_BOBBER_SMITHING_TEMPLATE) || bobberSkin.is(ModItems.PEARL_BOBBER_SMITHING_TEMPLATE))
            RenderSystem.setShaderColor(1, 1, 1, 1);
    }

    public static void renderDecor(GuiGraphics guiGraphics, int width, int height, int completionSmooth, ItemStack itemBeingFished)
    {
        //silver thing on top
        guiGraphics.blit(
                TEXTURE, width / 2 - 16, height / 2 - 16,
                32, 32, 208, 208, 32, 32, 256, 256);

        //fishing rod
        guiGraphics.blit(
                TEXTURE, width / 2 - 32 - 70, height / 2 - 24 - 57,
                64, 48, 192, 0, 64, 48, 256, 256);

        //fishing line
        guiGraphics.blit(
                TEXTURE, width / 2 - 6 - 102, height / 2 - 56 - 18,
                16, 112 - completionSmooth,
                176, 0 + completionSmooth,
                16, 112 - completionSmooth,
                256, 256);

        //Twitch chat didn't force me to write this comment
        //Lies, kuko010 force me to write said comment
        //FISH
        guiGraphics.renderItem(itemBeingFished, width / 2 - 8 - 100, height / 2 - 8 + 35 - completionSmooth);
    }

    public static void renderHitMarker(GuiGraphics guiGraphics, PoseStack poseStack, int width, int height, float color, float lastHitMarkerPos, ItemStack bobber, float r, float g, float b)
    {
        poseStack.pushPose();

        float centerX = width / 2f;
        float centerY = height / 2f;

        poseStack.translate(centerX, centerY, 0);
        poseStack.mulPose(new Quaternionf().rotateZ((float) Math.toRadians(lastHitMarkerPos)));
        poseStack.translate(-centerX, -centerY, 0);

        RenderSystem.setShaderColor(r, g, b, color);
        RenderSystem.enableBlend();

        //16 offset on y for texture centering
        if (!bobber.is(ModItems.KIMBE_BOBBER_SMITHING_TEMPLATE))
        {
            guiGraphics.blit(
                    TEXTURE, width / 2 - 32, height / 2 - 32 - 16,
                    64, 64, 128, 128, 64, 64, 256, 256);
        }

        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.disableBlend();

        poseStack.popPose();
    }

    public void renderPointer(GuiGraphics guiGraphics, float partialTick, PoseStack poseStack)
    {
        renderPointer(guiGraphics, partialTick, poseStack, width, height, isHoldingKey, pointerPos, pointerSpeed, currentRotation);
    }

    public static void renderPointer(GuiGraphics guiGraphics, float partialTick, PoseStack poseStack, int width, int height, boolean isHoldingSpace, int pointerPos, float speed, int currentRotation)
    {
        //TODO make it not use the partial ticks from rendering thread of whatever honestly its just nerd stuff that no one will care about
        //What other partial ticks would it use??

        poseStack.pushPose();

        float centerX = width / 2f;
        float centerY = height / 2f;

        poseStack.translate(centerX, centerY, 0);
        // if (isHoldingSpace) poseStack.scale(0.8f, 1f, 1f);

        poseStack.mulPose(new Quaternionf().rotateZ((float) Math.toRadians(pointerPos + ((speed * partialTick) * currentRotation))));
        poseStack.translate(-centerX, -centerY, 0);


        //16 offset on y for texture centering
        guiGraphics.blit(
                TEXTURE, width / 2 - 32, height / 2 - 32 - 16,
                64, 64, 128, 192, 64, 64, 256, 256);

        poseStack.popPose();
    }

    //endregion

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers)
    {
        if (keyCode == ModKeymappings.MINIGAME_HIT.getKey().getValue())
        {
            isHoldingKey = false;
            holdingTicks = 0;
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button)
    {
        isHoldingMouse = false;
        holdingTicks = 0;
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        inputPressed();
        isHoldingMouse = true;
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        //closes when pressing E
        InputConstants.Key mouseKey = InputConstants.getKey(keyCode, scanCode);
        if (this.minecraft.options.keyInventory.isActiveAndMatches(mouseKey))
        {
            this.onClose();
            return true;
        }

        //hit input
        if (ModKeymappings.MINIGAME_HIT.isActiveAndMatches(mouseKey))
        {
            if (!isHoldingKey) inputPressed();

            isHoldingKey = true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    private void inputPressed()
    {
        if (gracePeriod > 0) gracePeriod = 0;

        Minecraft.getInstance().player.swing(hand, true);

        boolean hitSomething = false;

        Vec3 pos = Minecraft.getInstance().player.position();
        ClientLevel level = Minecraft.getInstance().level;

        lastHitMarkerPos = getPointerPosPrecise();

        for (ActiveSweetSpot ass : activeSweetSpots)
        {
            if (isHitSuccessful(ass.pos, ass.size))
            {
                modifiers.forEach(modifier -> modifier.onHit(this, ass));

                ass.sweetSpotType.onHit(this, ass);

                if (changeRotation && ass.isFlip) currentRotation *= -1;
                if (changeRotation && ass.isFlip) ass.currentRotation *= -1;

                completion += ass.reward;
                treasureProgress += ass.reward;
                hitSomething = true;
                ass.pos = getRandomFreePosition();
                landedHitAlpha = 1;
            }
        }

        if (!hitSomething)
        {
            this.modifiers.forEach(modifier -> modifier.onMiss(this));

            if (bobber.is(ModItems.KIMBE_BOBBER_SMITHING_TEMPLATE))
                Minecraft.getInstance().player.playSound(SoundEvents.VILLAGER_NO, 1, 1);
            missedHitAlpha = 1;
            consecutiveHits = 0;
            level.playLocalSound(pos.x, pos.y, pos.z, SoundEvents.COMPARATOR_CLICK, SoundSource.BLOCKS, 1, 1, false);
            completion -= penalty;
            perfectCatch = false;
        }
    }

    public float getPointerPosPrecise()
    {
        float pointerPosPrecise = (pointerPos + ((pointerSpeed * partial) * currentRotation));

        pointerPosPrecise += hitDelay * pointerSpeed * currentRotation;
        return pointerPosPrecise;
    }

    public void addTreasure()
    {
        treasureActive = true;
        treasureProgress = 0;
        treasureProgressSmooth = 0;
    }

    public boolean isHitSuccessful(float hitPos, int forgiving)
    {
        return isHitSuccessful(getPointerPosPrecise(), hitPos, forgiving);
    }

    public static boolean isHitSuccessful(float pointerPrecise, float hitPos, int forgiving)
    {
        return Math.abs(hitPos - pointerPrecise) < forgiving || Math.abs(hitPos - pointerPrecise) > 360 - forgiving;
    }

    @Override
    public void tick()
    {
        if (isHoldingInput())
        { //mimics the keyboard behaviour
            holdingTicks++;
            if (holdingTicks > holdingDelay) inputPressed();
        }

        //tick modifiers
        modifiers.forEach(m -> m.tick(this));
        //tick sweetSpotType
        activeSweetSpots.forEach(s -> s.sweetSpotType.tick(this));
        //tick activeSweetSpots
        activeSweetSpots.forEach(s -> s.tick(this));
        //remove activeSweetSpots marked for removal
        activeSweetSpots.removeIf(s -> s.removed);

        pointerPos += (int) (pointerSpeed * currentRotation);

        missedHitAlpha -= 0.1f;
        landedHitAlpha -= 0.1f;

        if (pointerPos > 360) pointerPos -= 360;
        if (pointerPos < 0) pointerPos += 360;

        gracePeriod--;

        tickCount++;

        completionSmooth += (int) Math.signum(completion - completionSmooth);
        completionSmooth += (int) Math.signum(completion - completionSmooth);

        treasureProgressSmooth += (int) Math.signum(treasureProgress - treasureProgressSmooth);

        if (tickCount % 5 == 0 && gracePeriod < 0)
        {
            completion -= decay;
        }

        if (completionSmooth < 0)
        {
            this.onClose();
        }

        if (completionSmooth > 75)
        {
            //if completed treasure minigame, or is a perfect catch with the mossy hook
            boolean awardTreasure = treasureProgress > 100;

            PacketDistributor.sendToServer(new FishingCompletedPayload(tickCount, awardTreasure, perfectCatch, consecutiveHits));
            this.onClose();
        }

        hitParticles.removeIf(HitFakeParticle::tick);
    }

    @Override
    public void onClose()
    {
        if (!ModList.get().isLoaded("distanthorizons"))
            Minecraft.getInstance().options.guiScale().set(previousGuiScale);

        PacketDistributor.sendToServer(new FishingCompletedPayload(-1, false, false, consecutiveHits));
        this.minecraft.popGuiLayer();
    }

    public void addParticles(float posInDegrees, int count)
    {
        int xPos = (int) (30 * Math.cos(Math.toRadians(posInDegrees - 90)));
        int yPos = (int) (30 * Math.sin(Math.toRadians(posInDegrees - 90)));

        for (int i = 0; i < count; i++)
        {
            if (bobber.is(ModItems.PEARL_BOBBER_SMITHING_TEMPLATE))
            {
                hitParticles.add(new HitFakeParticle(
                        xPos, yPos, new Vector2d(r.nextFloat() * 2 - 1, r.nextFloat() * 2 - 1),
                        r.nextFloat(),
                        r.nextFloat(),
                        r.nextFloat(),
                        1
                ));
                continue;
            }

            if (bobber.is(ModItems.COLORFUL_BOBBER_SMITHING_TEMPLATE))
            {
                ColorfulSmithingTemplate.BobberColor color = bobber.get(ModDataComponents.BOBBER_COLOR);
                hitParticles.add(new HitFakeParticle(
                        xPos, yPos, new Vector2d(r.nextFloat() * 2 - 1, r.nextFloat() * 2 - 1),
                        color.r(),
                        color.g(),
                        color.b(),
                        1
                ));
                continue;
            }

            //todo if(treasure)
            if (false)
            {
                //red particles if treasure sweet spot was hit
                hitParticles.add(new HitFakeParticle(
                        xPos, yPos, new Vector2d(r.nextFloat() * 2 - 1, r.nextFloat() * 2 - 1),
                        0.7f + r.nextFloat() / 3, 0.5f, 0.5f, 1
                ));
            }
            else
            {
                hitParticles.add(new HitFakeParticle(xPos, yPos, new Vector2d(r.nextFloat() * 2 - 1, r.nextFloat() * 2 - 1)));
            }

        }
    }

    public boolean isHoldingInput()
    {
        return isHoldingMouse || isHoldingKey;
    }

    public static int normalizePos(int pos)
    {
        int ret = pos % 360;

        if (ret < 0) ret += 360;

        return ret;
    }

    @Override
    public boolean isPauseScreen()
    {
        return false;
    }

}
