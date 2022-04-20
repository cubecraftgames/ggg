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

public class ModClientName
extends ModDraggable {
    @Override
    public int getWidth() {
        return font.getStringWidth(String.valueOf(String.valueOf(Client.ModFarbe)) + Client.ClientName);
    }

    @Override
    public int getHeight() {
        return ModClientName.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (!Client.ChromaText) {
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.ModFarbe)) + Client.ClientName, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
            GlStateManager.popMatrix();
        } else {
            ChromaText.drawChromaString(Client.ClientName, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
        }
    }
}

