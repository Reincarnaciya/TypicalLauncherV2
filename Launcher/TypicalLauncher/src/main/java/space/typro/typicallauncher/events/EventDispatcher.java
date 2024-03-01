package space.typro.typicallauncher.events;

import lombok.CustomLog;

import java.util.ArrayList;
@CustomLog
public class EventDispatcher {
    private static final ArrayList<InternetEvent> internetSubscribed = new ArrayList<>();
    private static final ArrayList<UserEvent> userSubscribed = new ArrayList<>();

    public static void subscribe(EventType type, Object toSubscribe){
        switch (type) {
            case INTERNET_SENSITIVITY -> internetSubscribed.add((InternetEvent) toSubscribe);
            case USER_EVENT -> userSubscribed.add((UserEvent) toSubscribe);
        }
    }

    public static void throwEvent(EventType type, EventData data) {
        switch (type) {
            case INTERNET_SENSITIVITY -> {
                InternetEvent.InternetEventInfo internetEventInfo = new InternetEvent.InternetEventInfo((InternetEvent.InternetEventInfo.InternetData) data);
                internetSubscribed.forEach(internetEvent -> internetEvent.onInternetEvent(internetEventInfo));
            }
            case USER_EVENT -> {
                UserEvent.UserEventInfo userEventInfo = new UserEvent.UserEventInfo((UserEvent.UserEventInfo.UserData) data);
                userSubscribed.forEach(userEvent -> userEvent.onUserEvent(userEventInfo));
            }
        }
    }

    public enum EventType{
        INTERNET_SENSITIVITY, USER_EVENT, SETTINGS_EVENT
    }
}
