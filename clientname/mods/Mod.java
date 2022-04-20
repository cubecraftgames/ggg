/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods;

import clientname.Client;
import clientname.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {
    private boolean isEnabled = true;
    protected final Minecraft mc = Minecraft.getMinecraft();
    protected static FontRenderer font;
    protected final Client client;

    public Mod() {
        font = this.mc.fontRendererObj;
        this.client = Client.getInstance();
        this.setEnabled(this.isEnabled);
    }

    private void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        if (isEnabled) {
            EventManager.register(this);
        } else {
            EventManager.unregister(this);
        }
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }
}

