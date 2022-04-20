/*
 * Decompiled with CFR 0.150.
 */
package clientname.gui.gui;

import clientname.Client;
import clientname.gui.gui.GuiCosmetics;
import clientname.gui.gui.GuiIngameMods;
import clientname.gui.gui.GuiOtherMods;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.resources.I18n;
import net.minecraft.realms.RealmsBridge;

public class GUIToggle
extends GuiScreen {
    private GuiScreen guiscreen;
    private boolean clear;
    private final GuiScreen field_146598_a;
    private static String Cape = "Cape";
    private static String Wings = "Wings";
    private static String ToggleSprint = "Toggle Sprint";
    private static String Halo = "Halo";
    private static String FPS = "FPS";
    private static String Keystrokes = "Keystrokes";
    private static String Ping = "Ping";
    private static String ArmorStatus = "Armor Status";
    private static String Time = "Time";
    private static String PotionStatus = "Potion Status";
    private static String ModPosition = "ModPosition";
    private GuiButton field_146596_f;
    private GuiButton field_146597_g;
    private String field_146599_h = "survival";
    private boolean field_146600_i;

    public GUIToggle(GuiScreen p_i1055_1_) {
        this.field_146598_a = p_i1055_1_;
    }

    public void openConfigScreen() {
        this.mc.displayGuiScreen(new GUIToggle(this));
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(2001, this.width / 2 - 125, this.height / 2 - 90, 250, 20, I18n.format("Ingame Mods", new Object[0])));
        this.buttonList.add(new GuiButton(2002, this.width / 2 - 125, this.height / 2 - 65, 250, 20, I18n.format("Cosmetics", new Object[0])));
        this.buttonList.add(new GuiButton(2004, this.width / 2 - 125, this.height / 2 - 40, 250, 20, I18n.format("Other Mods", new Object[0])));
        this.buttonList.add(new GuiButton(2003, this.width / 2 - 75, this.height / 2 - 15, 150, 20, I18n.format("Customize Modposition", new Object[0])));
    }

    private void func_146595_g() {
        this.field_146597_g.displayString = String.valueOf(I18n.format("selectWorld.gameMode", new Object[0])) + " " + I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
        this.field_146596_f.displayString = String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0])) + " ";
        this.field_146596_f.displayString = this.field_146600_i ? String.valueOf(this.field_146596_f.displayString) + I18n.format("options.on", new Object[0]) : String.valueOf(this.field_146596_f.displayString) + I18n.format("options.off", new Object[0]);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 0: {
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            }
            case 1: {
                boolean flag = this.mc.isIntegratedServerRunning();
                boolean flag1 = this.mc.func_181540_al();
                button.enabled = false;
                this.mc.theWorld.sendQuittingDisconnectingPacket();
                this.mc.loadWorld(null);
                if (flag) {
                    this.mc.displayGuiScreen(new GuiMainMenu());
                    break;
                }
                if (flag1) {
                    RealmsBridge realmsbridge = new RealmsBridge();
                    realmsbridge.switchToRealms(new GuiMainMenu());
                    break;
                }
                this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
            }
            default: {
                break;
            }
            case 4: {
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            }
            case 5: {
                this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            }
            case 6: {
                this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            }
            case 7: {
                this.mc.displayGuiScreen(new GuiShareToLan(this));
                break;
            }
            case 1001: {
                Client.CosmeticWings = !Client.CosmeticWings;
                break;
            }
            case 1002: {
                Client.ToggleSprint = !Client.ToggleSprint;
                break;
            }
            case 1003: {
                Client.CosmeticCape = !Client.CosmeticCape;
                break;
            }
            case 1004: {
                Client.CosmeticHalo = !Client.CosmeticHalo;
                break;
            }
            case 8: {
                this.mc.displayGuiScreen(new GUIToggle(this));
                break;
            }
            case 1005: {
                Client.ModFPS = !Client.ModFPS;
                break;
            }
            case 1006: {
                Client.ModKeystrokes = !Client.ModKeystrokes;
                break;
            }
            case 1007: {
                Client.ModPing = !Client.ModPing;
                break;
            }
            case 1008: {
                Client.ModArmorStatus = !Client.ModArmorStatus;
                break;
            }
            case 1009: {
                Client.ModTimeShow = !Client.ModTimeShow;
                break;
            }
            case 1010: {
                Client.ModPotionstatus = !Client.ModPotionstatus;
                break;
            }
            case 1011: {
                Client.ModPosition = !Client.ModPosition;
                break;
            }
            case 1012: {
                Client.ItemPhysics = !Client.ItemPhysics;
                break;
            }
            case 1013: {
                Client.BetterAnimations = !Client.BetterAnimations;
                break;
            }
            case 1014: {
                Client.DiamondHead = !Client.DiamondHead;
                break;
            }
            case 1015: {
                Client.ChatBackground = !Client.ChatBackground;
                break;
            }
            case 1016: {
                Client.CosmeticWitchHat = !Client.CosmeticWitchHat;
                break;
            }
            case 1017: {
                Client.ChromaText = !Client.ChromaText;
                break;
            }
            case 1018: {
                Client.LeftHand = !Client.LeftHand;
                break;
            }
            case 1019: {
                Client.WidePlayer = !Client.WidePlayer;
                break;
            }
            case 1020: {
                Client.DynamicFOV = !Client.DynamicFOV;
                break;
            }
            case 1021: {
                Client.ModBiom = !Client.ModBiom;
                break;
            }
            case 2001: {
                this.mc.displayGuiScreen(new GuiIngameMods(this));
                break;
            }
            case 2002: {
                this.mc.displayGuiScreen(new GuiCosmetics(this));
                break;
            }
            case 2004: {
                this.mc.displayGuiScreen(new GuiOtherMods(this));
                break;
            }
            case 2003: {
                if (this.guiscreen instanceof GuiMainMenu) {
                    Client.getInstance().getHudManager().openConfigScreenPaused();
                    break;
                }
                Client.getInstance().getHudManager().openConfigScreen();
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + Client.ClientName + " Settings", this.width / 2 - Client.guiToggleClientName, this.height / 2 - 130, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}

