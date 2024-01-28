package space.typro.typicallauncher.controllers;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import space.typro.typicallauncher.Main;
import space.typro.typicallauncher.ResourceHelper;

public class LauncherController extends BaseController {


    @FXML
    private VBox mainPane;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private Pane accountLeftPane;
    @FXML
    private Pane newsLeftPane;
    @FXML
    private Pane forumLeftPane;
    @FXML
    private Pane friendsLeftPane;
    @FXML
    private Pane settingsLeftPane;
    @FXML
    private Pane playLeftPane;
    @FXML
    private VBox textVBox;
    @FXML
    private Text upperText;
    @FXML
    private AnchorPane lineBelowText;
    @FXML
    private AnchorPane currentContent;
    @FXML
    private Pane exitButton;

    @Override
    public void initialize() {
        super.initialize();


        this.loadLeftPane();
        this.loadTopPane();

    }


    public void loadSubscene(){

    }

    private void loadTopPane() {
        exitButton.setOnMouseClicked(mouseEvent -> Main.exit());
    }

    private void loadLeftPane(){
        accountLeftPane.setBackground(new Background(
                new BackgroundImage(
                        new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, "account.png")),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        ));
        accountLeftPane.setBackground(new Background(
                new BackgroundImage(
                        new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, "account.png")),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        ));
        newsLeftPane.setBackground(new Background(
                new BackgroundImage(
                        new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, "news.png")),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        ));
        forumLeftPane.setBackground(new Background(
                new BackgroundImage(
                        new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, "forum.png")),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        ));
        friendsLeftPane.setBackground(new Background(
                new BackgroundImage(
                        new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, "account.png")),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        ));
        settingsLeftPane.setBackground(new Background(
                new BackgroundImage(
                        new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, "settings.png")),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        ));
        playLeftPane.setBackground(new Background(
                new BackgroundImage(
                        new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, "play.png")),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        ));
    }
    public enum Subscene{
        PREVIOS_SUBSCENE(""), ACCOUNT(""), PROFILE(""), REGISTER(""), NEWS(""), FRIENDS(""), SETTINGS(""), PLAY("");

        public final String fxml;

        Subscene(String s){
            fxml = s;
        }
    }


}