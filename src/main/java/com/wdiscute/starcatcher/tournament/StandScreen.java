package com.wdiscute.starcatcher.tournament;

import com.wdiscute.starcatcher.Config;
import com.wdiscute.starcatcher.Starcatcher;
import com.wdiscute.starcatcher.io.SingleStackContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.*;

public class StandScreen extends AbstractContainerScreen<StandMenu>
{
    public static Tournament tournamentCache;
    public static Map<UUID, String> gameProfilesCache;
    private final StandMenu standMenu;

    private static String durationCache = "waiting...";
    private EditBox editBox;
    private boolean wasFocused;

    private static final ResourceLocation BACKGROUND = Starcatcher.rl("textures/gui/tournament/background.png");

    int uiX;
    int uiY;

    @Override
    protected void init()
    {
        super.init();
        uiX = (width - imageWidth) / 2;
        uiY = (height - imageHeight) / 2;
        subInit();
    }

    @Override
    public void resize(Minecraft minecraft, int width, int height)
    {
        String s = this.editBox.getValue();
        this.init(minecraft, width, height);
        this.editBox.setValue(s);
    }

    protected void subInit()
    {
        this.editBox = new EditBox(this.font, uiX + 53, uiY + 36, 210, 12, Component.translatable("container.repair"));
        this.editBox.setCanLoseFocus(true);
        this.editBox.setTextColor(0x635040);
        this.editBox.setBordered(false);
        this.editBox.setMaxLength(20);
        this.editBox.setValue("");
        this.editBox.setTextShadow(false);
        this.editBox.setEditable(false);
        this.addWidget(this.editBox);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1)
    {
        this.renderBlurredBackground(i);
    }

    private void onFocusEditBox()
    {
        editBox.setValue(tournamentCache.name);
        tournamentCache.name = "";
    }

    private void onUnfocusEditBox()
    {
        //send packet
        tournamentCache.name = editBox.getValue();
        editBox.setValue("");
        System.out.println("should send packet here!");
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
    {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        double x = mouseX - uiX;
        double y = mouseY - uiY;

        if (tournamentCache == null) return;
        if (gameProfilesCache == null) return;

        //handle editbox focusing
        if (wasFocused != editBox.isFocused())
        {
            if (editBox.isFocused())
                onFocusEditBox();
            else
                onUnfocusEditBox();
        }
        wasFocused = editBox.isFocused();

        //render background
        renderImage(guiGraphics, BACKGROUND);

        //render tournament name
        guiGraphics.drawString(this.font, tournamentCache.name, uiX + 53, uiY + 36, 0x635040, false);

        //organizer
        guiGraphics.drawString(this.font, getPlayerFromUUID(tournamentCache.owner), uiX + 55, uiY + 56, 0x635040, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.organizer"), uiX + 55, uiY + 68, 0x9c897c, false);

        //prize pool
        guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.prize_pool"), uiX + 130, uiY + 53, 0x9c897c, false);

        //status
        guiGraphics.drawString(this.font, Component.translatable(tournamentCache.status.getSerializedName()), uiX + 55, uiY + 88, 0x635040, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.status"), uiX + 55, uiY + 100, 0x9c897c, false);

        //duration
        guiGraphics.drawString(this.font, Component.literal(durationCache), uiX + 130, uiY + 88, 0x635040, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.duration"), uiX + 130, uiY + 100, 0x9c897c, false);

        //signup button
        if (tournamentCache.playerScores.containsKey(Minecraft.getInstance().player.getUUID()))
        {
            guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.signed_up"), uiX + 51, uiY + 120, 0x40752c, false);
        }
        else
        {
            int color = tournamentCache.settings.canSignUp(minecraft.player) ? 0x40752c : 0xa34536;
            guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.sign_up"), uiX + 51, uiY + 120, color, false);
        }

        if (x > 48 && x < 98 && y > 117 && y < 127 && !tournamentCache.settings.entryCost.isEmpty())
        {
            List<Component> signUpCostList = new ArrayList<>();

            signUpCostList.add(Component.literal("Sign Up Fee:"));


            for (SingleStackContainer ssc : tournamentCache.settings.entryCost)
            {
                if (!ssc.stack().isEmpty())
                    signUpCostList.add(Component.literal(ssc.stack().getCount() + "x ").append(Component.translatable(ssc.stack().getItem().getDescriptionId())));
            }

            guiGraphics.renderTooltip(this.font, signUpCostList, Optional.empty(), mouseX, mouseY);
        }


        //list of players
        int count = 0;
        int xOffset = 53;
        int yOffset = 132;
        boolean drawOthers = false;
        List<Component> others = new ArrayList<>();
        others.add(Component.translatable("gui.starcatcher.tournament.other"));
        for (var entry : tournamentCache.getPlayerScores().entrySet())
        {
            if (count == 11)
            {
                drawOthers = true;
                others.add(Component.literal(getPlayerFromUUID(entry.getKey())));
                continue;
            }
            guiGraphics.drawString(this.font, getPlayerFromUUID(entry.getKey()), uiX + xOffset, uiY + yOffset, 0x635040, false);
            count++;
            yOffset += 12;
            if (count == 6)
            {
                xOffset += 77;
                yOffset = 132;
            }
        }

        if (drawOthers)
        {
            guiGraphics.drawString(this.font, Component.translatable("gui.guide.hover"), uiX + xOffset, uiY + yOffset, 0x635040, false);
            if (x > 125 && x < 190 && y > 188 && y < 202)
                guiGraphics.renderTooltip(
                        this.font,
                        others,
                        Optional.empty(), mouseX, mouseY);
        }


        //
        //                  ,--.     ,--.   ,--.
        // ,---.   ,---.  ,-'  '-. ,-'  '-. `--' ,--,--,   ,---.   ,---.
        //(  .-'  | .-. : '-.  .-' '-.  .-' ,--. |      \ | .-. | (  .-'
        //.-'  `) \   --.   |  |     |  |   |  | |  ||  | ' '-' ' .-'  `)
        //`----'   `----'   `--'     `--'   `--' `--''--' .`-  /  `----'
        //                                                `---'


        //entry fee
        guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.entry_fee"), uiX + 212, uiY + 147, 0x9c897c, false);

        //inventory
        guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.inventory"), uiX + 212, uiY + 175, 0x9c897c, false);

        //start
        guiGraphics.drawString(this.font, Component.translatable("gui.starcatcher.tournament.start"), uiX + 215, uiY + 50, 0x635040, false);
        if (x > 209 && x < 317 && y > 44 && y < 60)
        {
            List<Component> list = new ArrayList<>();

            list.add(Component.literal("This will start the tournament which will"));
            list.add(Component.literal("automatically end once the duration has"));
            list.add(Component.literal("ended. Settings can not be changed"));
            list.add(Component.literal("once the tournament has started."));
            list.add(Component.literal("Items can still be added to the prize pool."));

            guiGraphics.renderTooltip(this.font, list, Optional.empty(), mouseX, mouseY);
        }

        this.editBox.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    public void onTournamentReceived(Tournament tournament)
    {
        tournamentCache = tournament;
        editBox.setEditable(tournamentCache.owner.equals(Minecraft.getInstance().player.getUUID()));
        updateDurationCache();
    }

    private static void updateDurationCache()
    {
        if (Config.DURATION.get().equals(DurationDisplay.MINUTES))
        {
            String s = "";
            int totalSeconds = tournamentCache.settings.duration / 20;
            int hours = totalSeconds / 3600;

            if (hours > 0)
            {
                totalSeconds -= 3600 * hours;
                s = hours + "h ";
            }

            int minutes = totalSeconds / 60;

            if (minutes > 0)
            {
                totalSeconds -= 60 * minutes;
                s += minutes + "m ";
            }

            s += totalSeconds + "s ";

            durationCache = s;
        }

        if (Config.DURATION.get().equals(DurationDisplay.MINECRAFT_DAYS))
        {
            durationCache = tournamentCache.settings.duration / 24000 + " days";
        }

        if (Config.DURATION.get().equals(DurationDisplay.TICKS))
        {
            durationCache = tournamentCache.settings.duration + " ticks";
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {

        double x = mouseX - uiX;
        double y = mouseY - uiY;

        //System.out.println("clicked relative x:" + x);
        //System.out.println("clicked relative y:" + y);

        //sign up
        if (x > 48 && x < 98 && y > 117 && y < 127)
        {
            minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, 67);
        }

        //start
        if (x > 209 && x < 317 && y > 44 && y < 60)
        {
            minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, 69);
        }

        //duration cycling
        if (x > 123 && x < 189 && y > 84 && y < 108)
        {
            if (button == 0) Config.DURATION.set(Config.DURATION.get().next());
            if (button == 1) Config.DURATION.set(Config.DURATION.get().previous());
            Config.SORT.save();
            updateDurationCache();
        }

        editBox.setFocused(false);

        return super.mouseClicked(mouseX, mouseY, button);
    }

    public static String getPlayerFromUUID(UUID uuid)
    {
        if (gameProfilesCache != null)
        {
            if (gameProfilesCache.containsKey(uuid))
            {
                return gameProfilesCache.get(uuid);
            }
        }
        return "Unknown";
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
    }

    private void renderImage(GuiGraphics guiGraphics, ResourceLocation rl)
    {
        guiGraphics.blit(rl, uiX, uiY, 0, 0, 420, 260, 420, 260);
    }

    private void renderImage(GuiGraphics guiGraphics, ResourceLocation rl, int xOffset, int yOffset)
    {
        guiGraphics.blit(rl, uiX + xOffset, uiY + yOffset, 0, 0, 420, 260, 420, 260);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        if (keyCode == 256)
        {
            this.minecraft.player.closeContainer();
        }

        return this.editBox.keyPressed(keyCode, scanCode, modifiers) || this.editBox.canConsumeInput() || super.keyPressed(keyCode, scanCode, modifiers);
    }


    public enum DurationDisplay
    {
        TICKS,
        MINUTES,
        MINECRAFT_DAYS;

        private static final DurationDisplay[] vals = values();

        public DurationDisplay previous()
        {
            if (this.ordinal() == 0) return vals[vals.length - 1];
            return vals[(this.ordinal() - 1) % vals.length];
        }

        public DurationDisplay next()
        {
            return vals[(this.ordinal() + 1) % vals.length];
        }
    }

    public StandScreen(StandMenu menu, Inventory playerInventory, Component title)
    {
        super(menu, playerInventory, title);
        standMenu = menu;
        imageWidth = 420;
        imageHeight = 260;
    }
}
