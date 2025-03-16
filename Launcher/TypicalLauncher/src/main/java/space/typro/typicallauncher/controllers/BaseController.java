package space.typro.typicallauncher.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import lombok.CustomLog;
import space.typro.typicallauncher.events.EventDispatcher;
import space.typro.typicallauncher.utils.LauncherAlert;

import java.net.URL;
import java.util.ResourceBundle;

@CustomLog
public abstract class BaseController implements Initializable {

    public void initialize() {

    }
    public abstract void initialize(URL url, ResourceBundle resourceBundle);

    protected void showErrorAlert(String message) {
        new LauncherAlert(Alert.AlertType.ERROR, message, ButtonType.OK).showAndWait();
    }
}