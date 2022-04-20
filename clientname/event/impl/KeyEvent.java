/*
 * Decompiled with CFR 0.150.
 */
package clientname.event.impl;

import clientname.event.EventCancelable;

public class KeyEvent
extends EventCancelable {
    private final int key;

    public KeyEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }
}

