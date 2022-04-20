/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package clientname.event.impl;

import clientname.event.EventCancelable;
import org.lwjgl.input.Mouse;

public class MouseEvent
extends EventCancelable {
    public final int x = Mouse.getEventX();
    public final int y = Mouse.getEventY();
    public final int dx = Mouse.getEventDX();
    public final int dy = Mouse.getEventDY();
    public final int dwheel = Mouse.getEventDWheel();
    public final int button = Mouse.getEventButton();
    public final boolean buttonstate = Mouse.getEventButtonState();
    public final long nanoseconds = Mouse.getEventNanoseconds();
}

