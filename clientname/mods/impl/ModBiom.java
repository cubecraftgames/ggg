/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods.impl;

import clientname.ChromaText;
import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;

public class ModBiom
extends ModDraggable {
    @Override
    public int getWidth() {
        BlockPos blockpos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
        Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
        return font.getStringWidth("Biom" + chunk.getBiome((BlockPos)blockpos, (WorldChunkManager)this.mc.theWorld.getWorldChunkManager()).biomeName);
    }

    @Override
    public int getHeight() {
        return ModBiom.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.ModBiom) {
            if (!Client.ChromaText) {
                BlockPos blockpos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
                Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "Biom" + Client.KlammerFarbe + "] " + chunk.getBiome((BlockPos)blockpos, (WorldChunkManager)this.mc.theWorld.getWorldChunkManager()).biomeName, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
            } else {
                BlockPos blockpos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
                Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
                ChromaText.drawChromaString("[Biom] " + chunk.getBiome((BlockPos)blockpos, (WorldChunkManager)this.mc.theWorld.getWorldChunkManager()).biomeName, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}

