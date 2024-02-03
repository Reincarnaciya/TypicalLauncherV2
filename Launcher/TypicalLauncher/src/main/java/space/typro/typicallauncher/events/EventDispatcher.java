package space.typro.typicallauncher.events;

import java.util.ArrayList;

public class EventDispatcher {
    private static final ArrayList<InternetSensitivity> internetSubscribed = new ArrayList<>();
    private static final ArrayList<UserEvent> userSubscribed = new ArrayList<>();

    public static void subscribe(EventType type, Object toSubscribe){
        switch (type){
            case INTERNET_SENSITIVITY:
                internetSubscribed.add((InternetSensitivity) toSubscribe);
                break;
            case USER_EVENT:
                userSubscribed.add((UserEvent) toSubscribe);
                break;
        }
    }

    public static void throwEvent(EventType type, EventData data){
        switch (type){
            case INTERNET_SENSITIVITY -> internetSubscribed.forEach(internetSensitivity -> internetSensitivity.onInternetEvent
                    (
                            new InternetSensitivity.InternetEventInfo
                                    (
                                            (InternetSensitivity.InternetEventInfo.InternetEventData) data
                                    )
                    )
            );
            case USER_EVENT -> userSubscribed.forEach(userEvent -> userEvent.onUserEvent
                    (
                            new UserEvent.UserEventInfo
                                    (
                                            (UserEvent.UserEventInfo.UserData) data
                                    )
                    )
            );
        }
    }

    public enum EventType{
        INTERNET_SENSITIVITY, USER_EVENT
    }
}
