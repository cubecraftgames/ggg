/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package clientname.mods.impl;

import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class ModKeystrokes
extends ModDraggable {
    private KeystrokesMode mode = KeystrokesMode.WASD_SPRINT_MOUSE;
    private List<Long> clicksLMB = new ArrayList<Long>();
    private boolean wasPressedLMB;
    private long lastPressedLMB;
    private List<Long> clicksRMB = new ArrayList<Long>();
    private boolean wasPressedRMB;
    private long lastPressedRMB;

    public void setMode(KeystrokesMode mode) {
        this.mode = mode;
    }

    @Override
    public int getWidth() {
        return this.mode.getWidth();
    }

    @Override
    public int getHeight() {
        return this.mode.getHeight();
    }

    private int getCPSLMB() {
        long time = System.currentTimeMillis();
        this.clicksLMB.removeIf(aLong -> aLong + 1000L < time);
        return this.clicksLMB.size();
    }

    private int getCPSRMB() {
        long time = System.currentTimeMillis();
        this.clicksRMB.removeIf(aLong -> aLong + 1000L < time);
        return this.clicksRMB.size();
    }

    @Override
    public void render(ScreenPosition pos) {
        GL11.glPushMatrix();
        if (Client.ModKeystrokes) {
            boolean pressedLMB = Mouse.isButtonDown((int)0);
            if (pressedLMB != this.wasPressedLMB) {
                this.lastPressedLMB = System.currentTimeMillis();
                this.wasPressedLMB = pressedLMB;
                if (pressedLMB) {
                    this.clicksLMB.add(this.lastPressedLMB);
                }
            }
            Gui.drawRect(pos.getAbsoluteX() + Key.LMBCPS.getX(), pos.getAbsoluteY() + Key.LMBCPS.getY(), pos.getAbsoluteX() + Key.LMBCPS.getX() + Key.LMBCPS.getWidth(), pos.getAbsoluteY() + Key.LMBCPS.getY() + Key.LMBCPS.getHeight(), new Color(0, 0, 0, 142).getRGB());
            font.drawString(String.valueOf(this.getCPSLMB()), pos.getAbsoluteX() + Key.LMBCPS.getX() + Key.LMBCPS.getWidth() / 2 - font.getStringWidth("000") / 2, pos.getAbsoluteY() + Key.LMBCPS.getY() + Key.LMBCPS.getHeight() / 2 - 4, -1);
            boolean pressedRMB = Mouse.isButtonDown((int)1);
            if (pressedRMB != this.wasPressedRMB) {
                this.lastPressedRMB = System.currentTimeMillis();
                this.wasPressedRMB = pressedRMB;
                if (pressedRMB) {
                    this.clicksRMB.add(this.lastPressedRMB);
                }
            }
            Gui.drawRect(pos.getAbsoluteX() + Key.RMBCPS.getX(), pos.getAbsoluteY() + Key.RMBCPS.getY(), pos.getAbsoluteX() + Key.RMBCPS.getX() + Key.RMBCPS.getWidth(), pos.getAbsoluteY() + Key.RMBCPS.getY() + Key.RMBCPS.getHeight(), new Color(0, 0, 0, 142).getRGB());
            font.drawString(String.valueOf(this.getCPSRMB()), pos.getAbsoluteX() + Key.RMBCPS.getX() + Key.RMBCPS.getWidth() / 2 - font.getStringWidth("000") / 2, pos.getAbsoluteY() + Key.RMBCPS.getY() + Key.RMBCPS.getHeight() / 2 - 4, -1);
            for (Key key : this.mode.getKeys()) {
                if (key == Key.LMBCPS || key == Key.RMBCPS) continue;
                int textWidth = font.getStringWidth(key.getName());
                Gui.drawRect(pos.getAbsoluteX() + key.getX(), pos.getAbsoluteY() + key.getY(), pos.getAbsoluteX() + key.getX() + key.getWidth(), pos.getAbsoluteY() + key.getY() + key.getHeight(), key.isDown() ? new Color(255, 255, 255, 102).getRGB() : new Color(0, 0, 0, 102).getRGB());
                font.drawString(key.getName(), pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4, key.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        GL11.glPopMatrix();
    }

    private static class Key {
        private static final Key W = new Key("W", Minecraft.getMinecraft().gameSettings.keyBindForward, 21, 1, 18, 18);
        private static final Key A = new Key("A", Minecraft.getMinecraft().gameSettings.keyBindLeft, 1, 21, 18, 18);
        private static final Key S = new Key("S", Minecraft.getMinecraft().gameSettings.keyBindBack, 21, 21, 18, 18);
        private static final Key D = new Key("D", Minecraft.getMinecraft().gameSettings.keyBindRight, 41, 21, 18, 18);
        private static final Key LMB = new Key("LMB", Minecraft.getMinecraft().gameSettings.keyBindAttack, 1, 41, 28, 18);
        private static final Key RMB = new Key("RMB", Minecraft.getMinecraft().gameSettings.keyBindUseItem, 31, 41, 28, 18);
        private static final Key LMBCPS = new Key("0", Minecraft.getMinecraft().gameSettings.keyBindAttack, 1, 61, 28, 18);
        private static final Key RMBCPS = new Key("0", Minecraft.getMinecraft().gameSettings.keyBindUseItem, 31, 61, 28, 18);
        private final String name;
        private final KeyBinding keyBind;
        private final int x;
        private final int y;
        private final int width;
        private final int height;

        public Key(String name, KeyBinding keyBind, int x, int y, int width, int height) {
            this.name = name;
            this.keyBind = keyBind;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public boolean isDown() {
            return this.keyBind.isKeyDown();
        }

        public int getHeight() {
            return this.height;
        }

        public String getName() {
            return this.name;
        }

        public int getWidth() {
            return this.width;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        static /* synthetic */ Key access$0() {
            return W;
        }

        static /* synthetic */ Key access$1() {
            return A;
        }

        static /* synthetic */ Key access$2() {
            return S;
        }

        static /* synthetic */ Key access$3() {
            return D;
        }

        static /* synthetic */ Key access$4() {
            return LMB;
        }

        static /* synthetic */ Key access$5() {
            return RMB;
        }
    }

    public static enum KeystrokesMode {
        WASD(Key.access$0(), Key.access$1(), Key.access$2(), Key.access$3()),
        WASD_Mouse(Key.access$0(), Key.access$1(), Key.access$2(), Key.access$3(), Key.access$4(), Key.access$5()),
        WASD_SPRINT(Key.access$0(), Key.access$1(), Key.access$2(), Key.access$3(), new Key("Sprint", Minecraft.getMinecraft().gameSettings.keyBindSprint, 1, 41, 58, 18)),
        WASD_SPRINT_MOUSE(Key.access$0(), Key.access$1(), Key.access$2(), Key.access$3(), Key.access$4(), Key.access$5(), Key.access$6(), Key.access$7());

        private final Key[] keys;
        private int width = 0;
        private int height = 0;

        private KeystrokesMode(Key ... keysIn) {
            Key[] arrkey = this.keys = keysIn;
            int n2 = this.keys.length;
            for (int i = 0; i < n2; ++i) {
                Key key = arrkey[i];
                this.width = Math.max(this.width, key.getX() + key.getWidth());
                this.height = Math.max(this.height, key.getY() + key.getHeight());
            }
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public Key[] getKeys() {
            return this.keys;
        }
    }
}

