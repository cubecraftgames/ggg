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

public class GuiCosmetics
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

    public GuiCosmetics(GuiScreen p_i1055_1_) {
        this.field_146598_a = p_i1055_1_;
    }

    @Override
    public void initGui() {
        if (Client.CosmeticHalo) {
            this.buttonList.add(new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: OFF", new Object[0])));
        }
        if (Client.DiamondHead) {
            this.buttonList.add(new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: OFF", new Object[0])));
        }
        if (Client.CosmeticWitchHat) {
            this.buttonList.add(new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: OFF", new Object[0])));
        }
        if (Client.CosmeticCape) {
            this.buttonList.add(new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: OFF", new Object[0])));
        }
        if (Client.CosmeticWings) {
            this.buttonList.add(new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: OFF", new Object[0])));
        }
        if (Client.CosmeticGhostWings) {
            this.buttonList.add(new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: OFF", new Object[0])));
        }
        if (Client.CosmeticCap) {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: OFF", new Object[0])));
        }
        if (Client.CosmeticHat) {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: ON", new Object[0])));
        } else {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: OFF", new Object[0])));
        }
        this.buttonList.add(new GuiButton(8, this.width / 2 - 91, this.height / 2 + 102, 180, 20, I18n.format("Back", new Object[0])));
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
                boolean bl = Client.CosmeticWings = !Client.CosmeticWings;
                if (Client.CosmeticWings) {
                    this.buttonList.set(4, new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(4, new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: OFF", new Object[0])));
                break;
            }
            case 1003: {
                boolean bl = Client.CosmeticCape = !Client.CosmeticCape;
                if (Client.CosmeticCape) {
                    this.buttonList.set(3, new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(3, new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: OFF", new Object[0])));
                break;
            }
            case 1004: {
                boolean bl = Client.CosmeticHalo = !Client.CosmeticHalo;
                if (Client.CosmeticHalo) {
                    this.buttonList.set(0, new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(0, new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: OFF", new Object[0])));
                break;
            }
            case 8: {
                this.mc.displayGuiScreen(new GUIToggle(this));
                break;
            }
            case 1014: {
                boolean bl = Client.DiamondHead = !Client.DiamondHead;
                if (Client.DiamondHead) {
                    this.buttonList.set(1, new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(1, new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: OFF", new Object[0])));
                break;
            }
            case 1016: {
                boolean bl = Client.CosmeticWitchHat = !Client.CosmeticWitchHat;
                if (Client.CosmeticWitchHat) {
                    this.buttonList.set(2, new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(2, new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: OFF", new Object[0])));
                break;
            }
            case 1002: {
                boolean bl = Client.CosmeticGhostWings = !Client.CosmeticGhostWings;
                if (Client.CosmeticGhostWings) {
                    this.buttonList.set(5, new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(5, new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: OFF", new Object[0])));
                break;
            }
            case 1005: {
                boolean bl = Client.CosmeticCap = !Client.CosmeticCap;
                if (Client.CosmeticCap) {
                    this.buttonList.set(6, new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(6, new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: OFF", new Object[0])));
                break;
            }
            case 1006: {
                boolean bl = Client.CosmeticHat = !Client.CosmeticHat;
                if (Client.CosmeticHat) {
                    this.buttonList.set(7, new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(7, new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: OFF", new Object[0])));
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
        this.drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + "Cosmetics", this.width / 2 - 23, this.height / 2 - 120, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}

