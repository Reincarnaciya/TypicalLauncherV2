package space.typro.typicallauncher.controllers.scenes;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import space.typro.typicallauncher.Main;
import space.typro.typicallauncher.ResourceHelper;
import space.typro.typicallauncher.controllers.scenes.BaseController;
import space.typro.typicallauncher.controllers.scenes.subscenes.PlayController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;


public class LauncherController extends BaseController {

    //=========================================================================== Инициализация элементов javafx ===========================================================================
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
    @FXML
    private Pane subscene;
    //=========================================================================== Конец инициализации элементов javaFX ===========================================================================

    private static Subscene currentSubscene = null;
    private static Subscene previosSubscene = Subscene.NONE;


    @Override
    public void initialize() {
        super.initialize();


        this.loadLeftPanels();
        this.loadTopPane();
    }

    /**
     * @param whatToLoad Сабсцена для загрузки
     */
    public void loadSubscene(Subscene whatToLoad) { //TODO: Сменить субсцену на Anchor Pane, ибо подсцена работает некорректно
        if (whatToLoad.equals(currentSubscene)){
            return;
        }
        Platform.runLater(()->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(new URI(ResourceHelper.getResourceByType(ResourceHelper.ResourceType.SUB_SCENES, whatToLoad.fxml)).toURL());
                Parent tempContent = fxmlLoader.load();
                subscene.getChildren().setAll(tempContent);
            } catch (URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
        });

        previosSubscene = Objects.requireNonNullElse(currentSubscene, Subscene.NONE);
        currentSubscene = whatToLoad;
    }

    private void loadTopPane() {
        exitButton.setOnMouseClicked(mouseEvent -> Main.exit());
    }

    private void loadLeftPanels(){
        accountLeftPane.setBackground(getBackground(false, "account.png"));
        accountLeftPane.setOnMouseClicked(this::onAccountClick);

        newsLeftPane.setBackground(getBackground(false, "news.png"));
        newsLeftPane.setOnMouseClicked(this::onNewsClick);

        forumLeftPane.setBackground(getBackground(false, "forum.png"));
        forumLeftPane.setOnMouseClicked(this::onForumClick);

        friendsLeftPane.setBackground(getBackground(false, "account.png"));
        friendsLeftPane.setOnMouseClicked(this::onFriendClick);

        settingsLeftPane.setBackground(getBackground(false, "settings.png"));
        settingsLeftPane.setOnMouseClicked(this::onSettingsClick);

        playLeftPane.setBackground(getBackground(false, "play.png"));
        playLeftPane.setOnMouseClicked(this::onPlayClick);
    }



    private void onAccountClick(MouseEvent mouseEvent) {
        loadSubscene(Subscene.LOGIN);
    }
    private void onNewsClick(MouseEvent mouseEvent) {
        loadSubscene(Subscene.NEWS);
    }
    private void onForumClick(MouseEvent mouseEvent) {
        loadSubscene(Subscene.FORUM);
    }
    private void onFriendClick(MouseEvent mouseEvent) {
        loadSubscene(Subscene.FRIENDS);
    }
    private void onSettingsClick(MouseEvent mouseEvent) {
        loadSubscene(Subscene.SETTINGS);
    }
    private void onPlayClick(MouseEvent mouseEvent) {
        loadSubscene(Subscene.PLAY);
    }

    private static Background getBackground(boolean picked, String imgName){
        return new Background(
                new BackgroundImage(
                        new Image(
                                picked ? ResourceHelper.getResourceByType(
                                        ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_P, imgName
                                ) :
                                        ResourceHelper.getResourceByType(
                                                ResourceHelper.ResourceType.LEFT_PANEL_IMAGE_NP, imgName
                                        )
                        ),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100,100,true, true, true, true)
                )
        );
    }

    public enum Subscene{
        NONE("NULL"),
        PREVIOS_SUBSCENE(""),
        LOGIN("login-view.fxml"),
        PROFILE("profile-view.fxml"),
        REGISTER("registration-view.fxml"),
        NEWS("news-view.fxml"),
        FORUM("forum-view.fxml"),
        FRIENDS("friends-view.fxml"),
        SETTINGS("settings-view.fxml"),
        PLAY("play-view.fxml");
        public final String fxml;
        Subscene(String s){
            fxml = s;
        }
    }


}