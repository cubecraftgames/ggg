/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods.impl;

import clientname.ChromaText;
import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class ModFPS
extends ModDraggable {
    @Override
    public int getWidth() {
        return 50;
    }

    @Override
    public int getHeight() {
        return ModFPS.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.ModFPS) {
            if (!Client.ChromaText) {
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "FPS" + Client.KlammerFarbe + "] " + Minecraft.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
                GlStateManager.popMatrix();
            } else {
                ChromaText.drawChromaString("[FPS] " + Minecraft.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}

