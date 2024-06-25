package space.typro.typicallauncher.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lombok.CustomLog;
import space.typro.typicallauncher.events.EventDispatcher;
import space.typro.typicallauncher.events.InternetEvent;
import space.typro.typicallauncher.events.SettingsEvent;
import space.typro.typicallauncher.events.UserEvent;
import space.typro.typicallauncher.utils.LauncherAlert;

import java.net.URL;
import java.util.ResourceBundle;

@CustomLog
public abstract class BaseController implements InternetEvent, UserEvent, SettingsEvent, Initializable {

    public void initialize() {
        EventDispatcher.subscribe(EventDispatcher.EventType.INTERNET_SENSITIVITY, this);
        EventDispatcher.subscribe(EventDispatcher.EventType.USER_EVENT, this);
        EventDispatcher.subscribe(EventDispatcher.EventType.SETTINGS_EVENT, this);
    }
    public abstract void initialize(URL url, ResourceBundle resourceBundle);
    public void onInternetEvent(InternetEventInfo internetEventInfo) {}
    public void onUserEvent(UserEventInfo userEventInfo) {}
    public void onSettingsEvent(SettingsEventInfo settingsEventInfo) {}

    protected void showErrorAlert(String message) {
        new LauncherAlert(Alert.AlertType.ERROR, message, ButtonType.OK).showAndWait();
    }
}