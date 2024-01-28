package space.typro.typicallauncher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private double xOffset;
    private double yOffset;

    private static Stage GLOBAL_STAGE;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("scenes/launcher-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);

        });
        GLOBAL_STAGE = stage;
        stage.setTitle("TypicalLauncher");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.IMAGES, "ico.png")));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void exit(){
        GLOBAL_STAGE.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}
