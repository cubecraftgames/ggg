/*
 * Decompiled with CFR 0.150.
 */
package clientname.event;

import clientname.event.Event;
import clientname.event.EventData;
import clientname.event.EventPriority;
import clientname.event.EventTarget;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EventManager {
    private static final Map<Class<? extends Event>, ArrayList<EventData>> REGISTRY_MAP = new HashMap<Class<? extends Event>, ArrayList<EventData>>();

    private static void sortListValue(Class<? extends Event> clazz) {
        ArrayList<EventData> flexableArray = new ArrayList<EventData>();
        byte[] arrby = EventPriority.VALUE_ARRAY;
        int n = EventPriority.VALUE_ARRAY.length;
        for (int i = 0; i < n; ++i) {
            byte b = arrby[i];
            for (EventData methodData : REGISTRY_MAP.get(clazz)) {
                if (methodData.priority != b) continue;
                flexableArray.add(methodData);
            }
        }
        REGISTRY_MAP.put(clazz, flexableArray);
    }

    private static boolean isMethodBad(Method method) {
        return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventTarget.class);
    }

    private static boolean isMethodBad(Method method, Class<? extends Event> clazz) {
        return EventManager.isMethodBad(method) || method.getParameterTypes()[0].equals(clazz);
    }

    public static ArrayList<EventData> get(Class<? extends Event> clazz) {
        return REGISTRY_MAP.get(clazz);
    }

    public static void cleanMap(boolean removeOnlyEmptyValues) {
        Iterator<Map.Entry<Class<? extends Event>, ArrayList<EventData>>> iterator = REGISTRY_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            if (removeOnlyEmptyValues && !iterator.next().getValue().isEmpty()) continue;
            iterator.remove();
        }
    }

    public static void unregister(Object o, Class<? extends Event> clazz) {
        if (REGISTRY_MAP.containsKey(clazz)) {
            for (EventData methodData : REGISTRY_MAP.get(clazz)) {
                if (!methodData.source.equals(o)) continue;
                REGISTRY_MAP.get(clazz).remove(methodData);
            }
        }
        EventManager.cleanMap(true);
    }

    public static void unregister(Object o) {
        for (ArrayList<EventData> flexableArray : REGISTRY_MAP.values()) {
            for (int i = flexableArray.size() - 1; i >= 0; --i) {
                if (!flexableArray.get((int)i).source.equals(o)) continue;
                flexableArray.remove(i);
            }
        }
        EventManager.cleanMap(true);
    }

    public static void register(Method method, Object o) {
        Class<?> clazz = method.getParameterTypes()[0];
        EventData methodData = new EventData(o, method, method.getAnnotation(EventTarget.class).value());
        if (!methodData.target.isAccessible()) {
            methodData.target.setAccessible(true);
        }
        if (REGISTRY_MAP.containsKey(clazz)) {
            if (!REGISTRY_MAP.get(clazz).contains(methodData)) {
                REGISTRY_MAP.get(clazz).add(methodData);
                EventManager.sortListValue(clazz);
            }
        } else {
            REGISTRY_MAP.put(clazz, new ArrayList<EventData>(methodData){
                {
                    this.add(eventData);
                }
            });
        }
    }

    public static void register(Object o, Class<? extends Event> clazz) {
        for (Method method : o.getClass().getMethods()) {
            if (EventManager.isMethodBad(method, clazz)) continue;
            EventManager.register(method, o);
        }
    }

    public static void register(Object o) {
        for (Method method : o.getClass().getMethods()) {
            if (EventManager.isMethodBad(method)) continue;
            EventManager.register(method, o);
        }
    }
}

