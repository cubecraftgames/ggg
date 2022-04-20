/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods.impl;

import clientname.ChromaText;
import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;

public class ModToggleSpirnt
extends ModDraggable {
    @Override
    public int getWidth() {
        return font.getStringWidth("[Sprinting Toggled]");
    }

    @Override
    public int getHeight() {
        return ModToggleSpirnt.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.ToggleSprint) {
            if (!Client.ChromaText) {
                this.mc.fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Sprinting Toggled" + Client.KlammerFarbe + "]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
            } else {
                ChromaText.drawChromaString("[Sprinting Toggled]", pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}

