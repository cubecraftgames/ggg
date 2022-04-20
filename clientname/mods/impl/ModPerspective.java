/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.Display
 */
package clientname.mods.impl;

import clientname.event.EventTarget;
import clientname.event.impl.KeyEvent;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class ModPerspective
extends ModDraggable {
    private boolean returnOnRelease = true;
    public static boolean perspectiveToggled = false;
    private float cameraYaw = 0.0f;
    private float cameraPitch = 0.0f;
    private int previousPerspective = 0;

    @EventTarget
    public void keyboardEvent(KeyEvent e) {
        if (e.getKey() == this.mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode()) {
            if (Keyboard.getEventKeyState()) {
                perspectiveToggled = !perspectiveToggled;
                this.cameraYaw = this.mc.thePlayer.rotationYaw;
                this.cameraPitch = this.mc.thePlayer.rotationPitch;
                if (perspectiveToggled) {
                    this.previousPerspective = this.mc.gameSettings.thirdPersonView;
                    this.mc.gameSettings.thirdPersonView = 1;
                } else {
                    this.mc.gameSettings.thirdPersonView = this.previousPerspective;
                }
            } else if (this.returnOnRelease) {
                perspectiveToggled = false;
                this.mc.gameSettings.thirdPersonView = this.previousPerspective;
            }
        }
        if (Keyboard.getEventKey() == this.mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
            perspectiveToggled = false;
        }
    }

    public float getCameraYaw() {
        return perspectiveToggled ? this.cameraYaw : this.mc.thePlayer.rotationYaw;
    }

    public float getCameraPitch() {
        return perspectiveToggled ? this.cameraPitch : this.mc.thePlayer.rotationPitch;
    }

    public boolean overrideMouse() {
        if (this.mc.inGameHasFocus && Display.isActive()) {
            if (!perspectiveToggled) {
                return true;
            }
            this.mc.mouseHelper.mouseXYChange();
            float f1 = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            float f2 = f1 * f1 * f1 * 8.0f;
            float f3 = (float)this.mc.mouseHelper.deltaX * f2;
            float f4 = (float)this.mc.mouseHelper.deltaY * f2;
            this.cameraYaw += f3 * 0.15f;
            this.cameraPitch += f4 * 0.15f;
            if (this.cameraPitch > 90.0f) {
                this.cameraPitch = 90.0f;
            }
            if (this.cameraPitch < -90.0f) {
                this.cameraPitch = -90.0f;
            }
        }
        if (this.cameraYaw < -90.0f) {
            this.cameraYaw = -90.0f;
        }
        return false;
    }

    @Override
    public int getWidth() {
        return font.getStringWidth("");
    }

    @Override
    public int getHeight() {
        return ModPerspective.font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (perspectiveToggled) {
            this.mc.fontRendererObj.drawStringWithShadow("", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
        }
    }
}

