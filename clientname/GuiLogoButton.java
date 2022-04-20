/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package clientname;

import clientname.GuiButtonScope;
import clientname.ScaledResolution;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiLogoButton
extends GuiButtonScope {
    ScaledResolution scaledResolution;
    ResourceLocation location;
    boolean isHead;

    public GuiLogoButton(int buttonId, ScaledResolution scaledResolution, int x, int y, int widthIn, int heightIn, ResourceLocation location, boolean isHead) {
        super(buttonId, x, y, widthIn, heightIn, "");
        this.scaledResolution = scaledResolution;
        this.location = location;
        this.isHead = isHead;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.visible) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int i = 106;
            if (flag) {
                i += this.height;
            }
            mc.getTextureManager().bindTexture(this.location);
            if (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height) {
                if (this.isHead) {
                    GL11.glPushMatrix();
                    GL11.glScissor((int)0, (int)((int)(575.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor()), (int)((int)(62.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor() + 2), (int)100);
                    GL11.glEnable((int)3089);
                }
                Gui.drawScaledCustomSizeModalRect(this.xPosition - 10, this.yPosition - 10, -5.0f, -5.0f, this.width + 10, this.height + 10, this.width + 10, this.height + 10, this.width + 10, this.height + 10);
            } else {
                if (this.isHead) {
                    GL11.glPushMatrix();
                    GL11.glScissor((int)0, (int)((int)(580.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor()), (int)((int)(60.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor() + 2), (int)100);
                    GL11.glEnable((int)3089);
                }
                Gui.drawScaledCustomSizeModalRect(this.xPosition, this.yPosition, 0.0f, 0.0f, this.width, this.height, this.width, this.height, this.width, this.height);
            }
            if (this.isHead) {
                GL11.glDisable((int)3089);
                GL11.glPopMatrix();
            }
        }
    }
}

