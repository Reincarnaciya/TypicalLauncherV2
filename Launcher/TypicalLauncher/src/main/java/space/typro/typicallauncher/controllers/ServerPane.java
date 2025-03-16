package space.typro.typicallauncher.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.CustomLog;
import lombok.Setter;
import space.typro.typicallauncher.ResourceHelper;
import space.typro.typicallauncher.managers.DirManager;
import space.typro.typicallauncher.models.Server;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@CustomLog
public class ServerPane extends BaseController { // Наследуемся от VBox, так как это корневой элемент FXML
    @FXML private ImageView server_image;
    @FXML private Button play;
    @FXML private Button settings;

    // Обновляем интерфейс, если нужно
    @Setter
    private String serverName;
    // Обновляем интерфейс, если нужно
    @Setter
    private Server.ServerVersion serverVersion;
    private Image serverImage;

    public ServerPane(String serverName, Server.ServerVersion serverVersion, Image serverImage) {
        this.serverName = serverName;
        this.serverVersion = serverVersion;
        this.serverImage = serverImage;

        // Загружаем FXML
        FXMLLoader loader = new FXMLLoader(
                ResourceHelper.getResourceUrlByType(ResourceHelper.ResourceFolder.SCENES, "server-pane.fxml")
        );
        loader.setController(this);

        try {
            loader.load(); // Загружаем FXML
        } catch (IOException e) {
            log.error("Failed to load FXML file", e);
            throw new RuntimeException("Failed to load FXML file", e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Инициализация элементов интерфейса
        if (serverImage != null) {
            server_image.setImage(serverImage);
        }
        // Дополнительная настройка элементов
    }

    public void setServerImage(Image serverImage) {
        this.serverImage = serverImage;
        if (server_image != null) {
            server_image.setImage(serverImage);
        }
    }


}