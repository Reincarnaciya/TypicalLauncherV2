package space.typro.typicallauncher.controllers;

import space.typro.typicallauncher.events.EventDispatcher;
import space.typro.typicallauncher.events.InternetSensitivity;

public abstract class BaseController implements InternetSensitivity {
    public Object getInstance(){
        return this;
    }

    public void initialize(){
        EventDispatcher.subscribe(EventDispatcher.EventType.INTERNET_SENSITIVITY, this);
    }


    @Override
    public void onInternetLostConnection() {

    }

    @Override
    public void onInternetReturnedConnection() {

    }
}