package space.typro.typicallauncher.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher {
    private static final Map<EventType, List<EventListener<? extends EventData>>> subscribers = new HashMap<>();

    public static <T extends EventData> void subscribe(EventType type, EventListener<T> listener) {
        subscribers.computeIfAbsent(type, k -> new ArrayList<>()).add(listener);
    }

    public static <T extends EventData> void throwEvent(EventType type, T eventData) {
        List<EventListener<? extends EventData>> listeners = subscribers.get(type);
        if (listeners != null) {
            for (EventListener<? extends EventData> listener : listeners) {
                @SuppressWarnings("unchecked")
                EventListener<T> typedListener = (EventListener<T>) listener;
                typedListener.onEvent(eventData);
            }
        }
    }

    public enum EventType {
        INTERNET_SENSITIVITY, USER_EVENT, SETTINGS_EVENT
    }
}