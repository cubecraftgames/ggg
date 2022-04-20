/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods.impl;

import clientname.ChromaText;
import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class ModTimeShow
extends ModDraggable {
    @Override
    public int getWidth() {
        return font.getStringWidth("Time: AA:AA:AA AA ");
    }

    @Override
    public int getHeight() {
        return ModTimeShow.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.ModTimeShow) {
            if (!Client.ChromaText) {
                String pattern = "hh:mm:ss a ";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String time = simpleDateFormat.format(new Date());
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Time" + Client.KlammerFarbe + "] " + time, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
                GlStateManager.popMatrix();
            } else {
                String pattern = "hh:mm:ss a ";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String time = simpleDateFormat.format(new Date());
                ChromaText.drawChromaString("[Time] " + time, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}

