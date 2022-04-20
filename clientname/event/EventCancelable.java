/*
 * Decompiled with CFR 0.150.
 */
package clientname.event;

import clientname.event.Event;

public class EventCancelable
extends Event {
    private boolean cancelled = false;

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}

