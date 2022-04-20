/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package clientname.cosmetics;

import clientname.Client;
import clientname.cosmetics.util.CosmeticBase;
import clientname.cosmetics.util.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticHalo
extends CosmeticBase {
    private final HaloRenderer haloModel;

    public CosmeticHalo(RenderPlayer renderPlayer) {
        super(renderPlayer);
        this.haloModel = new HaloRenderer(renderPlayer);
    }

    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GL11.glPushMatrix();
        if (player.isSneaking()) {
            GlStateManager.translate(0.0, 0.225, 0.0);
        }
        if (Client.CosmeticHalo) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Halo.png"));
            GlStateManager.color(1.0f, 1.0f, 1.0f);
            this.haloModel.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
        GL11.glPopMatrix();
    }

    public class HaloRenderer
    extends CosmeticModelBase {
        ModelRenderer head;
        ModelRenderer body;
        ModelRenderer rightarm;
        ModelRenderer leftarm;
        ModelRenderer rightleg;
        ModelRenderer leftleg;
        ModelRenderer Shape1;
        ModelRenderer Shape2;
        ModelRenderer Shape3;
        ModelRenderer Shape4;
        ModelRenderer Shape6;

        public HaloRenderer(RenderPlayer player) {
            super(player);
            this.textureWidth = 64;
            this.textureHeight = 32;
            this.Shape1 = new ModelRenderer(this, 0, 0);
            this.Shape1.addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
            this.Shape1.setRotationPoint(0.0f, 0.0f, 0.0f);
            this.Shape1.setTextureSize(64, 32);
            this.Shape1.mirror = true;
            this.Shape2 = new ModelRenderer(this, 0, 0);
            this.Shape2.addBox(0.0f, 0.0f, 0.0f, 6, 1, 1);
            this.Shape2.setRotationPoint(-3.0f, -11.0f, -4.0f);
            this.Shape2.setTextureSize(64, 32);
            this.Shape2.mirror = true;
            this.Shape3 = new ModelRenderer(this, 0, 0);
            this.Shape3.addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
            this.Shape3.setRotationPoint(-4.0f, -11.0f, -3.0f);
            this.Shape3.setTextureSize(64, 32);
            this.Shape3.mirror = true;
            this.Shape4 = new ModelRenderer(this, 0, 0);
            this.Shape4.addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
            this.Shape4.setRotationPoint(3.0f, -11.0f, -3.0f);
            this.Shape4.setTextureSize(64, 32);
            this.Shape4.mirror = true;
            this.Shape6 = new ModelRenderer(this, 0, 0);
            this.Shape6.addBox(0.0f, 0.0f, 0.0f, 6, 1, 1);
            this.Shape6.setRotationPoint(-3.0f, -11.0f, 3.0f);
            this.Shape6.setTextureSize(64, 32);
            this.Shape6.mirror = true;
        }

        @Override
        public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
            if (entityIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
                GlStateManager.pushMatrix();
                float f1 = ageInTicks / 100.0f;
                float f6 = f1 * (float)Math.PI + 1.0f;
                GlStateManager.translate(0.0f, -((float)(Math.sin(f6 + 1.0f) + 0.5)) * 0.08f, 0.0f);
                this.Shape1.render(scale);
                this.Shape2.render(scale);
                this.Shape3.render(scale);
                this.Shape4.render(scale);
                this.Shape6.render(scale);
                GlStateManager.popMatrix();
            }
        }
    }
}

