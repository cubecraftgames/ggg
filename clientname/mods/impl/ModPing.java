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

public class ModPing
extends ModDraggable {
    @Override
    public int getWidth() {
        return font.getStringWidth("Ping: " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime());
    }

    @Override
    public int getHeight() {
        return ModPing.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.ModPing) {
            if (!Client.ChromaText) {
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Ping" + Client.KlammerFarbe + "] " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
                GlStateManager.popMatrix();
            } else {
                ChromaText.drawChromaString("[Ping] " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}

