/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods.impl;

import clientname.ChromaText;
import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;

public class FovMod
extends ModDraggable {
    private static float savedFOV = 0.0f;

    @Override
    public int getWidth() {
        return font.getStringWidth("[DynamicFov On]");
    }

    @Override
    public int getHeight() {
        return FovMod.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.DynamicFOV) {
            if (!Client.ChromaText) {
                font.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "DynamicFov On" + Client.KlammerFarbe + "]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
            } else {
                ChromaText.drawChromaString("DynamicFov On", pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
            savedFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
            if (this.mc.thePlayer.isSprinting()) {
                Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
            } else if (this.mc.thePlayer.isPotionActive(1)) {
                Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
            } else if (this.mc.thePlayer.capabilities.isFlying) {
                Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
            }
        }
    }
}

