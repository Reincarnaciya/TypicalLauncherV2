package space.typro.typicallauncher.events;

import java.util.ArrayList;

public class EventDispatcher {
    private static final ArrayList<InternetSensitivity> internetSubscribed = new ArrayList<>();

    public static void subscribe(EventType type, Object toSubscribe){
        switch (type){
            case INTERNET_SENSITIVITY:
                internetSubscribed.add((InternetSensitivity) toSubscribe);
                break;
        }
    }

    public static void onInternetLostConnection(){
        internetSubscribed.forEach(InternetSensitivity::onInternetLostConnection);
    }
    public static void onInternetReturnConnection(){
        internetSubscribed.forEach(InternetSensitivity::onInternetReturnedConnection);
    }

    public enum EventType{
        INTERNET_SENSITIVITY
    }
}
