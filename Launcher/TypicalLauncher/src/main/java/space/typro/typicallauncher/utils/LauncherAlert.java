package space.typro.typicallauncher.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.CustomLog;
import space.typro.typicallauncher.ResourceHelper;
@CustomLog
public class LauncherAlert extends Alert {
    private final Stage stage;
    private double xOffset;
    private double yOffset;
    public LauncherAlert(AlertType alertType, String s, ButtonType... buttonTypes) {
        super(alertType, s, buttonTypes);
        this.getDialogPane().getStylesheets().setAll(ResourceHelper.getResourceByType(ResourceHelper.ResourceFolder.ROOT, "alert.css"));
        stage = (Stage) this.getDialogPane().getScene().getWindow();
        stage.initStyle(StageStyle.TRANSPARENT);
        setHeaderText(
                switch (alertType){
                    case ERROR -> "Ошибка";
                    case CONFIRMATION -> "Подвтерждение действия";
                    case WARNING -> "Предупреждение";
                    case INFORMATION -> "Информация";
                    case NONE -> "";
                }
        );
        /*
            Делаем так, чтоб окно можно было передвигать в любой точке
        */
        stage.getScene().setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        stage.getScene().setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });
    }




}
