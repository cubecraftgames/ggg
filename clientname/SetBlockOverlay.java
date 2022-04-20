/*
 * Decompiled with CFR 0.150.
 */
package clientname;

public class SetBlockOverlay {
    public static float ro = 255.0f;
    public static float go = 255.0f;
    public static float bo = 255.0f;
    public static float ao = 0.4f;
    public static float THICCNESS = 3.0f;

    public void setBlockOverlay(float r, float g, float b, float a, float THICCNESSS) {
        ro = r;
        go = g;
        bo = b;
        ao = a;
        THICCNESS = THICCNESSS;
    }
}

