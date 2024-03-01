package space.typro.typicallauncher.controllers;

import lombok.CustomLog;
import space.typro.typicallauncher.events.EventDispatcher;
import space.typro.typicallauncher.events.InternetEvent;
import space.typro.typicallauncher.events.SettingsEvent;
import space.typro.typicallauncher.events.UserEvent;
@CustomLog

public abstract class BaseController implements InternetEvent, UserEvent, SettingsEvent {

    public void initialize(){
        EventDispatcher.subscribe(EventDispatcher.EventType.INTERNET_SENSITIVITY, this);
        EventDispatcher.subscribe(EventDispatcher.EventType.USER_EVENT, this);
    }
    public void onInternetEvent(InternetEventInfo internetEventInfo){}
    public void onUserEvent(UserEventInfo userEventInfo){}
    public void onSettingsEvent(SettingsEventInfo settingsEventInfo){}
}