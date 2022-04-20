/*
 * Decompiled with CFR 0.150.
 */
package clientname;

import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ChromaText {
    public static void drawChromaString(String string, int x, int y, boolean shadow) {
        Minecraft mc = Minecraft.getMinecraft();
        int xTmp = x;
        for (char textChar : string.toCharArray()) {
            long l = System.currentTimeMillis() - (long)(xTmp * 10 - y * 10);
            int i = Color.HSBtoRGB((float)(l % 2000L) / 2000.0f, 0.8f, 0.8f);
            String tmp = String.valueOf(textChar);
            mc.fontRendererObj.drawString(tmp, xTmp, y, i, shadow);
            xTmp += mc.fontRendererObj.getCharWidth(textChar);
        }
    }
}

