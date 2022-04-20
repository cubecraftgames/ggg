/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods.impl;

import clientname.event.EventTarget;
import clientname.event.impl.MouseEvent;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class ModProjectL
extends ModDraggable {
    @Override
    public int getWidth() {
        return font.getStringWidth("");
    }

    @Override
    public int getHeight() {
        return ModProjectL.font.FONT_HEIGHT;
    }

    @EventTarget
    public void onMouse(MouseEvent event) {
        EntityPlayerSP entity;
        if (this.isEnabled() && (event.dx != 0 || event.dy != 0) && (entity = Minecraft.getMinecraft().thePlayer) != null) {
            entity.prevRenderYawOffset = entity.renderYawOffset;
            entity.prevRotationYawHead = entity.rotationYawHead;
            entity.prevRotationYaw = entity.rotationYaw;
            entity.prevRotationPitch = entity.rotationPitch;
        }
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawString("", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
    }
}

