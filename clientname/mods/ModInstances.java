/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods;

import clientname.gui.hud.HUDManager;
import clientname.mods.impl.FovMod;
import clientname.mods.impl.ModArmorStatus;
import clientname.mods.impl.ModBiom;
import clientname.mods.impl.ModClientName;
import clientname.mods.impl.ModFPS;
import clientname.mods.impl.ModKeystrokes;
import clientname.mods.impl.ModPerspective;
import clientname.mods.impl.ModPing;
import clientname.mods.impl.ModPotionStatus;
import clientname.mods.impl.ModProjectL;
import clientname.mods.impl.ModTimeShow;
import clientname.mods.impl.ModToggleSpirnt;
import clientname.mods.impl.ModX;
import clientname.mods.impl.ModY;
import clientname.mods.impl.ModZ;
import net.minecraft.client.Minecraft;

public class ModInstances {
    public static Minecraft mc;
    private static ModClientName modHelloWorld;
    private static ModArmorStatus modArmorStatus;
    private static ModFPS modFPS;
    private static ModToggleSpirnt modToggleSprint;
    private static ModKeystrokes modKeystrokes;
    private static FovMod fovMod;
    private static ModBiom modBiom;
    private static ModPing modPing;
    private static ModTimeShow modTimeShow;
    private static ModPotionStatus modPotionStatus;
    private static ModX modX;
    private static ModProjectL modProjectL;
    private static ModY modY;
    private static ModZ modZ;
    private static ModPerspective modPerspective;

    public static void register(HUDManager api) {
        modHelloWorld = new ModClientName();
        api.register(modHelloWorld);
        modArmorStatus = new ModArmorStatus();
        api.register(modArmorStatus);
        modToggleSprint = new ModToggleSpirnt();
        api.register(modToggleSprint);
        modFPS = new ModFPS();
        api.register(modFPS);
        modX = new ModX();
        api.register(modX);
        modY = new ModY();
        api.register(modY);
        modZ = new ModZ();
        api.register(modZ);
        modKeystrokes = new ModKeystrokes();
        api.register(modKeystrokes);
        modPing = new ModPing();
        api.register(modPing);
        modTimeShow = new ModTimeShow();
        api.register(modTimeShow);
        modPotionStatus = new ModPotionStatus();
        api.register(modPotionStatus);
        modPerspective = new ModPerspective();
        api.register(modPerspective);
        modProjectL = new ModProjectL();
        api.register(modProjectL);
        fovMod = new FovMod();
        api.register(fovMod);
        modBiom = new ModBiom();
        api.register(modBiom);
    }

    public static ModPerspective getModPerspective() {
        return modPerspective;
    }
}

