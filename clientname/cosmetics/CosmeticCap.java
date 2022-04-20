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

public class CosmeticCap
extends Cosmetic {
    ModelRenderer Cap1;
    ModelRenderer Cap2;
    ModelRenderer Cap3;
    ModelRenderer Cap4;
    ModelRenderer Cap5;
    ModelRenderer Cap6;
    ModelRenderer cap7;

    public CosmeticCap(RenderPlayer player) {
        super(player);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Cap1 = new ModelRenderer(this, 0, 0);
        this.Cap1.addBox(0.0f, 0.0f, 0.0f, 8, 1, 11);
        this.Cap1.setRotationPoint(-4.0f, -9.0f, -7.0f);
        this.Cap1.setTextureSize(64, 32);
        this.Cap1.mirror = true;
        this.Cap2 = new ModelRenderer(this, 0, 0);
        this.Cap2.addBox(0.0f, 0.0f, 0.0f, 8, 1, 1);
        this.Cap2.setRotationPoint(-4.0f, -9.0f, -8.0f);
        this.Cap2.setTextureSize(64, 32);
        this.Cap2.mirror = true;
        this.Cap3 = new ModelRenderer(this, 0, 0);
        this.Cap3.addBox(0.0f, 0.0f, 0.0f, 8, 3, 1);
        this.Cap3.setRotationPoint(-4.0f, -12.0f, -4.0f);
        this.Cap3.setTextureSize(64, 32);
        this.Cap3.mirror = true;
        this.Cap4 = new ModelRenderer(this, 0, 0);
        this.Cap4.addBox(0.0f, 0.0f, 0.0f, 8, 3, 1);
        this.Cap4.setRotationPoint(-4.0f, -12.0f, 3.0f);
        this.Cap4.setTextureSize(64, 32);
        this.Cap4.mirror = true;
        this.Cap5 = new ModelRenderer(this, 0, 0);
        this.Cap5.addBox(0.0f, 0.0f, 0.0f, 1, 3, 6);
        this.Cap5.setRotationPoint(-4.0f, -12.0f, -3.0f);
        this.Cap5.setTextureSize(64, 32);
        this.Cap5.mirror = true;
        this.Cap6 = new ModelRenderer(this, 0, 0);
        this.Cap6.addBox(0.0f, 0.0f, 0.0f, 1, 3, 6);
        this.Cap6.setRotationPoint(3.0f, -12.0f, -3.0f);
        this.Cap6.setTextureSize(64, 32);
        this.Cap6.mirror = true;
        this.cap7 = new ModelRenderer(this, 0, 0);
        this.cap7.addBox(0.0f, 0.0f, 0.0f, 6, 1, 6);
        this.cap7.setRotationPoint(-3.0f, -12.0f, -3.0f);
        this.cap7.setTextureSize(64, 32);
        this.cap7.mirror = true;
    }

    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
        if (Client.CosmeticCap) {
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
            this.Cap1.render(scale);
            this.Cap2.render(scale);
            this.Cap3.render(scale);
            this.Cap4.render(scale);
            this.Cap5.render(scale);
            this.Cap6.render(scale);
            this.cap7.render(scale);
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

