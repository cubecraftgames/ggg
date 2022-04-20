/*
 * Decompiled with CFR 0.150.
 */
package clientname.event;

import clientname.event.EventData;
import clientname.event.EventManager;
import java.util.ArrayList;

public class Event {
    public Event call() {
        ArrayList<EventData> dataList = EventManager.get(this.getClass());
        if (dataList != null) {
            for (EventData data : dataList) {
                try {
                    data.target.invoke(data.source, this);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
}

