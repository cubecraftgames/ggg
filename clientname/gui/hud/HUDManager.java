/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Sets
 */
package clientname.gui.hud;

import clientname.event.EventManager;
import clientname.event.EventTarget;
import clientname.event.impl.RenderEvent;
import clientname.gui.hud.HUDConfigScreen;
import clientname.gui.hud.IRenderer;
import clientname.gui.hud.ScreenPosition;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;

public class HUDManager {
    private static HUDManager instance = null;
    private static boolean isPaused;
    private Set<IRenderer> registeredRenderers = Sets.newHashSet();
    private Minecraft mc = Minecraft.getMinecraft();

    private HUDManager() {
    }

    public static HUDManager getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new HUDManager();
        EventManager.register(instance);
        return instance;
    }

    public void register(IRenderer ... renderers) {
        IRenderer[] arriRenderer = renderers;
        int n = renderers.length;
        for (int i = 0; i < n; ++i) {
            IRenderer render = arriRenderer[i];
            this.registeredRenderers.add(render);
        }
    }

    public void unreister(IRenderer ... renderers) {
        IRenderer[] arriRenderer = renderers;
        int n = renderers.length;
        for (int i = 0; i < n; ++i) {
            IRenderer render = arriRenderer[i];
            this.registeredRenderers.remove(render);
        }
    }

    public Collection<IRenderer> getRegisteredRenderers() {
        return Sets.newHashSet(this.registeredRenderers);
    }

    public void openConfigScreen() {
        isPaused = false;
        this.mc.displayGuiScreen(new HUDConfigScreen(this, true));
    }

    public void openConfigScreenPaused() {
        isPaused = true;
        this.mc.displayGuiScreen(new HUDConfigScreen(this, false));
    }

    @EventTarget
    public void onRender(RenderEvent e) {
        if ((this.mc.currentScreen == null || this.mc.currentScreen instanceof GuiContainer) && (this.mc.currentScreen == null || this.mc.currentScreen instanceof GuiChat)) {
            if (this.mc.gameSettings.showDebugInfo) {
                return;
            }
            for (IRenderer renderer : this.registeredRenderers) {
                this.callRenderer(renderer);
            }
        }
    }

    private void callRenderer(IRenderer renderer) {
        if (!renderer.isEnabled()) {
            return;
        }
        ScreenPosition pos = renderer.load();
        if (pos == null) {
            pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
        }
        renderer.render(pos);
    }
}

