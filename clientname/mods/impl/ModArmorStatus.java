/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package clientname.mods.impl;

import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModArmorStatus
extends ModDraggable {
    @Override
    public int getWidth() {
        return 64;
    }

    @Override
    public int getHeight() {
        return 64;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.ModArmorStatus) {
            for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
                ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
                this.renderItemStack(pos, i, itemStack);
            }
        }
    }

    @Override
    public void renderDummy(ScreenPosition pos) {
        this.renderItemStack(pos, 3, new ItemStack(Items.chainmail_helmet));
        this.renderItemStack(pos, 2, new ItemStack(Items.chainmail_chestplate));
        this.renderItemStack(pos, 1, new ItemStack(Items.chainmail_leggings));
        this.renderItemStack(pos, 0, new ItemStack(Items.chainmail_boots));
    }

    private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
        if (is == null) {
            return;
        }
        GL11.glPushMatrix();
        int yAdd = -16 * i + 48;
        if (is.getItem().isDamageable()) {
            double damage = (double)(is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0;
            font.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
        GL11.glPopMatrix();
    }
}

