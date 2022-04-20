/*
 * Decompiled with CFR 0.150.
 */
package clientname.gui.hud;

import clientname.gui.hud.ScreenResolution;
import net.minecraft.client.Minecraft;

public class ScreenPosition {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private int x;
    private int y;

    public ScreenPosition(double x, double y) {
        this.setRelative(x, y);
    }

    public ScreenPosition(int x, int y) {
        this.setAbsolute(x, y);
    }

    public static ScreenPosition fromRelativePosition(double x, double y) {
        return new ScreenPosition(x, y);
    }

    public static ScreenPosition fromAbsolute(int x, int y) {
        return new ScreenPosition(x, y);
    }

    public int getAbsoluteX() {
        ScreenResolution resolution = new ScreenResolution(mc);
        return this.x;
    }

    public int getAbsoluteY() {
        ScreenResolution resolution = new ScreenResolution(mc);
        return this.y;
    }

    public double getRelativeX() {
        ScreenResolution res = new ScreenResolution(mc);
        return (int)((double)this.x / res.getScaledWidth_double());
    }

    public double getRelativeY() {
        ScreenResolution res = new ScreenResolution(mc);
        return (int)((double)this.y / res.getScaledHeight_double());
    }

    public void setAbsolute(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setRelative(double x, double y) {
        ScreenResolution res = new ScreenResolution(mc);
        this.x = (int)(x / (double)res.getScaledWidth());
        this.y = (int)(y / (double)res.getScaledHeight());
        System.err.println(x);
        System.out.println(y);
    }
}

