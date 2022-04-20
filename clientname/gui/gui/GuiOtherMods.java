/*
 * Decompiled with CFR 0.150.
 */
package clientname.gui.gui;

import clientname.Client;
import clientname.gui.gui.GUIToggle;
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

public class GuiOtherMods
extends GuiScreen {
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

    public GuiOtherMods(GuiScreen p_i1055_1_) {
        this.field_146598_a = p_i1055_1_;
    }

    @Override
    public void initGui() {
        if (Client.ToggleSprint) {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Toggle Sprint: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Toggle Sprint: OFF", new Object[0])));
        }
        if (Client.ItemPhysics) {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("ItemPhysics: OFF", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("ItemPhysics: ON", new Object[0])));
        }
        if (Client.BetterAnimations) {
            this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("1.7 Animations: OFF", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("1.7 Animations: ON", new Object[0])));
        }
        if (Client.ChatBackground) {
            this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("ChatBackground: OFF", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("ChatBackground: ON", new Object[0])));
        }
        if (Client.ChromaText) {
            this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Chroma Mods: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Chroma Mods: OFF", new Object[0])));
        }
        if (Client.LeftHand) {
            this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Left Hand: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Left Hand: OFF", new Object[0])));
        }
        if (Client.DynamicFOV) {
            this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Dynamic FOV: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Dynamic FOV: OFF", new Object[0])));
        }
        this.buttonList.add(new GuiButton(1022, this.width / 2 - 91, this.height / 2 + 78, 180, 20, I18n.format("Back", new Object[0])));
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
            case 8: {
                this.mc.displayGuiScreen(new GuiOtherMods(this));
                break;
            }
            case 1005: {
                boolean bl = Client.ToggleSprint = !Client.ToggleSprint;
                if (Client.ToggleSprint) {
                    this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Toggle Sprint: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Toggle Sprint: OFF", new Object[0])));
                break;
            }
            case 1006: {
                boolean bl = Client.ItemPhysics = !Client.ItemPhysics;
                if (Client.ItemPhysics) {
                    this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("ItemPhysics: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("ItemPhysics: OFF", new Object[0])));
                break;
            }
            case 1007: {
                boolean bl = Client.BetterAnimations = !Client.BetterAnimations;
                if (Client.BetterAnimations) {
                    this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("1.7 Animations: OFF", new Object[0])));
                    break;
                }
                this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("1.7 Animations: ON", new Object[0])));
                break;
            }
            case 1008: {
                boolean bl = Client.ChatBackground = !Client.ChatBackground;
                if (Client.ChatBackground) {
                    this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("ChatBackground: OFF", new Object[0])));
                    break;
                }
                this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("ChatBackground: ON", new Object[0])));
                break;
            }
            case 1009: {
                boolean bl = Client.ChromaText = !Client.ChromaText;
                if (Client.ChromaText) {
                    this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Chroma Mods: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Chroma Mods: OFF", new Object[0])));
                break;
            }
            case 1010: {
                boolean bl = Client.LeftHand = !Client.LeftHand;
                if (Client.LeftHand) {
                    this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Left Hand: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Left Hand: OFF", new Object[0])));
                break;
            }
            case 1011: {
                boolean bl = Client.DynamicFOV = !Client.DynamicFOV;
                if (Client.DynamicFOV) {
                    this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Dynamic FOV: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Dynamic FOV: OFF", new Object[0])));
                break;
            }
            case 1022: {
                this.mc.displayGuiScreen(new GUIToggle(this));
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + "Ingame Mods", this.width / 2 - 32, this.height / 2 - 120, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}

