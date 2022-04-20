/*
 * Decompiled with CFR 0.150.
 */
package clientname;

import clientname.DiscordRP;
import clientname.FileManager;
import clientname.event.EventManager;
import clientname.event.EventTarget;
import clientname.event.impl.ClientTickEvent;
import clientname.gui.SplashProgress;
import clientname.gui.gui.GUIToggle;
import clientname.gui.hud.HUDManager;
import clientname.mods.ModInstances;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class Client {
    private static final Client INSTANCE = new Client();
    public static boolean ChromaText = false;
    public static boolean LeftHand = false;
    public static boolean WidePlayer = false;
    public static boolean DynamicFOV = false;
    public static boolean CosmeticGhostWings = false;
    public static boolean CosmeticCap = false;
    public static boolean LogoButtons = true;
    public static int ConfigScreenColor = -43521;
    public static Color SplashColor = new Color(255, 85, 255);
    public static int guiToggleClientName = 45;
    public static String ClientName = "AxisClient";
    public static String KlammerFarbe = "\u00a7f";
    public static String ModFarbe = "\u00a7d";
    public static int ButtonHover = 0xFF55FF;
    public static String DiscordID = "834893021371301928";
    public static boolean CosmeticHat;
    public static boolean CosmeticWitchHat;
    public static boolean DiamondHead;
    public static boolean ChatBackground;
    public static boolean BetterAnimations;
    public static boolean ItemPhysics;
    public static boolean ToggleSprint;
    public static boolean CosmeticWings;
    public static boolean CosmeticHalo;
    public static boolean CosmeticCape;
    public static boolean CosmeticCape2;
    public static boolean CosmeticCape3;
    public static boolean CosmeticCape4;
    public static boolean ModBiom;
    public static boolean ModFPS;
    public static boolean ModPing;
    public static boolean ModPotionstatus;
    public static boolean ModTimeShow;
    public static boolean ModPosition;
    public static boolean ModArmorStatus;
    public static boolean ModKeystrokes;
    public static String Background;
    public static String Cape;
    public static String SplashScreen;
    public static String Logo;
    private DiscordRP discordRP = new DiscordRP();
    private HUDManager hudManager;
    int scrollTotal = 4;
    private static boolean prevIsKeyDown;
    private static float savedFOV;

    static {
        ModBiom = true;
        ModFPS = true;
        ModPing = true;
        ModPotionstatus = true;
        ModTimeShow = true;
        ModPosition = true;
        ModArmorStatus = true;
        ModKeystrokes = true;
        Background = "background.png";
        Cape = "cape.png";
        SplashScreen = "splash.png";
        Logo = "tollerzitronens-01.jpeg";
        prevIsKeyDown = false;
        savedFOV = 0.0f;
    }

    public static final Client getInstance() {
        return INSTANCE;
    }

    public HUDManager getHudManager() {
        return this.hudManager;
    }

    public void init() {
        SplashProgress.setProgress(1, String.valueOf(ClientName) + " - Discord Initialisation");
        FileManager.init();
        this.discordRP.start();
        EventManager.register(this);
    }

    public void start() {
        this.hudManager = HUDManager.getInstance();
        ModInstances.register(this.hudManager);
    }

    public void shutdown() {
        this.discordRP.shutdown();
    }

    public DiscordRP getDiscordRP() {
        return this.discordRP;
    }

    @EventTarget
    public void onTick(ClientTickEvent e) {
        boolean isKeyDown;
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
            this.hudManager.openConfigScreen();
        }
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_SETTINGS.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new GUIToggle(null));
        }
        if (prevIsKeyDown != (isKeyDown = Minecraft.getMinecraft().gameSettings.ZOOM.isKeyDown())) {
            if (isKeyDown) {
                savedFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
                Minecraft.getMinecraft().gameSettings.fovSetting = 30.0f;
                Minecraft.getMinecraft().gameSettings.smoothCamera = true;
            } else {
                Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
                Minecraft.getMinecraft().gameSettings.smoothCamera = false;
            }
        }
        prevIsKeyDown = isKeyDown;
    }
}

