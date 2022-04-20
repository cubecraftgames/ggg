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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CosmeticWitchHat
extends Cosmetic {
    public ModelRenderer witchHat;
    private final ResourceLocation witchTextures = new ResourceLocation("textures/entity/witch.png");

    public CosmeticWitchHat(RenderPlayer player) {
        super(player);
        this.witchHat = new ModelRenderer(this).setTextureSize(64, 128);
        this.witchHat.setRotationPoint(-5.0f, -10.03125f, -5.0f);
        this.witchHat.setTextureOffset(0, 64).addBox(0.0f, 0.0f, 0.0f, 10, 2, 10);
        ModelRenderer modelrenderer = new ModelRenderer(this).setTextureSize(64, 128);
        modelrenderer.setRotationPoint(1.75f, -4.0f, 2.0f);
        modelrenderer.setTextureOffset(0, 76).addBox(0.0f, 0.0f, 0.0f, 7, 4, 7);
        modelrenderer.rotateAngleX = -0.05235988f;
        modelrenderer.rotateAngleZ = 0.02617994f;
        this.witchHat.addChild(modelrenderer);
        ModelRenderer modelrenderer1 = new ModelRenderer(this).setTextureSize(64, 128);
        modelrenderer1.setRotationPoint(1.75f, -4.0f, 2.0f);
        modelrenderer1.setTextureOffset(0, 87).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        modelrenderer1.rotateAngleX = -0.10471976f;
        modelrenderer1.rotateAngleZ = 0.05235988f;
        modelrenderer.addChild(modelrenderer1);
        ModelRenderer modelrenderer2 = new ModelRenderer(this).setTextureSize(64, 128);
        modelrenderer2.setRotationPoint(1.75f, -2.0f, 2.0f);
        modelrenderer2.setTextureOffset(0, 95).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.25f);
        modelrenderer2.rotateAngleX = -0.20943952f;
        modelrenderer2.rotateAngleZ = 0.10471976f;
        modelrenderer1.addChild(modelrenderer2);
        this.witchHat.isHidden = true;
        this.playerModel.bipedHead.addChild(this.witchHat);
    }

    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
        if (player.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && Client.CosmeticWitchHat) {
            GlStateManager.pushMatrix();
            float f = partialTicks;
            float f1 = this.getFirstRotationX(player, f);
            float f2 = this.getSecondRotationX(player, f);
            Minecraft.getMinecraft().getTextureManager().bindTexture(this.witchTextures);
            if (player.isSneaking()) {
                GlStateManager.translate(0.0f, 0.27f, 0.0f);
            }
            GlStateManager.rotate(f1, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(f2, 1.0f, 0.0f, 0.0f);
            this.witchHat.isHidden = false;
            this.witchHat.render(scale);
            this.witchHat.isHidden = true;
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
}

