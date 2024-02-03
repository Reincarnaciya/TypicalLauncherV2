package space.typro.typicallauncher.controllers.scenes;

import lombok.CustomLog;
import lombok.ToString;
import lombok.extern.java.Log;
import space.typro.typicallauncher.events.EventDispatcher;
import space.typro.typicallauncher.events.InternetSensitivity;
import space.typro.typicallauncher.events.UserEvent;

public abstract class BaseController implements InternetSensitivity, UserEvent {

    //public abstract Object getInstance();

    public void initialize(){
        EventDispatcher.subscribe(EventDispatcher.EventType.INTERNET_SENSITIVITY, this);
    }
    public void onInternetEvent(InternetEventInfo internetEventInfo){}
    public void onUserEvent(UserEventInfo userEventInfo){}
}