/*
 * Decompiled with CFR 0.150.
 */
package clientname.cosmetics;

import clientname.Client;
import clientname.cosmetics.Cosmetic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CosmeticHat
extends Cosmetic {
    ModelRenderer Shape1;
    ModelRenderer Shape2;

    public CosmeticHat(RenderPlayer player) {
        super(player);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1 = new ModelRenderer(this, 0, 0);
        this.Shape1.addBox(0.0f, 0.0f, 0.0f, 10, 1, 10);
        this.Shape1.setRotationPoint(-5.0f, -9.0f, -5.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.Shape2 = new ModelRenderer(this, 0, 0);
        this.Shape2.addBox(0.0f, 0.0f, 0.0f, 8, 5, 8);
        this.Shape2.setRotationPoint(-4.0f, -14.0f, -4.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
    }

    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
        if (Client.CosmeticHat) {
            GlStateManager.pushMatrix();
            float f = partialTicks;
            float f1 = this.getFirstRotationX(player, f);
            float f2 = this.getSecondRotationX(player, f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.setRotationAngles(limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, player);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("cap.png"));
            GlStateManager.rotate(f1, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(f2, 1.0f, 0.0f, 0.0f);
            GlStateManager.disableLighting();
            if (player.isSneaking()) {
                GlStateManager.translate(0.0, 0.26, -0.047);
            }
            this.Shape1.render(scale);
            this.Shape2.render(scale);
            GlStateManager.popMatrix();
        }
    }

    private float getFirstRotationX(AbstractClientPlayer Player, float partialTicks) {
        float f = this.interpolateRotation(Player.prevRenderYawOffset, Player.renderYawOffset, partialTicks);
        float f1 = this.interpolateRotation(Player.prevRotationYawHead, Player.rotationYawHead, partialTicks);
        float f2 = f1 - f;
        if (Player.isRiding() && Player.ridingEntity instanceof EntityLivingBase) {
            EntityLivingBase entitylivingbase = (EntityLivingBase)Player.ridingEntity;
            f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
            f2 = f1 - f;
            float f3 = MathHelper.wrapAngleTo180_float(f2);
            if (f3 < -85.0f) {
                f3 = -85.0f;
            }
            if (f3 >= 85.0f) {
                f3 = 85.0f;
            }
            f = f1 - f3;
            if (f3 * f3 > 2500.0f) {
                float f4 = f + f3 * 0.2f;
            }
        }
        return f2;
    }

    private float getSecondRotationX(AbstractClientPlayer Player, float partialTicks) {
        return Player.prevRotationPitch + (Player.rotationPitch - Player.prevRotationPitch) * partialTicks;
    }

    private float interpolateRotation(float par1, float par2, float par3) {
        float f;
        for (f = par2 - par1; f < -180.0f; f += 360.0f) {
        }
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        return par1 + par3 * f;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}

