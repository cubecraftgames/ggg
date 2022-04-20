/*
 * Decompiled with CFR 0.150.
 */
package clientname.gui.hud;

import clientname.gui.hud.IRenderConfig;
import clientname.gui.hud.ScreenPosition;

public interface IRenderer
extends IRenderConfig {
    public int getWidth();

    public int getHeight();

    public void render(ScreenPosition var1);

    default public void renderDummy(ScreenPosition pos) {
        this.render(pos);
    }

    default public boolean isEnabled() {
        return true;
    }
}

