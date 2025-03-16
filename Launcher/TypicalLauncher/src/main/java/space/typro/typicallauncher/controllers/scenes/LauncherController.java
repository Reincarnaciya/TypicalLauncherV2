package space.typro.typicallauncher.controllers.scenes;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import lombok.CustomLog;
import space.typro.typicallauncher.Main;
import space.typro.typicallauncher.ResourceHelper;
import space.typro.typicallauncher.controllers.BaseController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

@CustomLog
public class LauncherController extends BaseController {
    public static LauncherController instance;

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
    public Text upperText;
    @FXML
    private AnchorPane lineBelowText;
    @FXML
    private Pane exitButton;
    @FXML
    private Pane subscene;
    @FXML
    private Pane hideLauncherButton;

    private static Subscene currentSubscene = null;
    private static Subscene previosSubscene = Subscene.NONE; //TODO: лист прошлых сцен



    public void initialize(URL var1, ResourceBundle var2) {
        super.initialize();
        instance = this;
        this.loadLeftPanels();
        this.loadTopPane();
        hideLauncherButton.setOnMouseClicked(this::hideLauncher);
        //TODO: Проверка на авторизованность пользователя, если авторизован - то в профиль, иначе в авторизацию
        loadSubscene(Subscene.LOGIN);
    }

    private void hideLauncher(MouseEvent mouseEvent) {
        Main.GLOBAL_STAGE.setIconified(true);
    }
    /**
     * @param whatToLoad Сабсцена для загрузки
     */
    public static void loadSubscene(final Subscene whatToLoad) {
        if (whatToLoad.equals(currentSubscene)){
            return;
        }

        Platform.runLater(() -> {
            try {
                Subscene toLoad = whatToLoad;
                if (whatToLoad == Subscene.PREVIOS_SUBSCENE && previosSubscene != Subscene.NONE){
                    toLoad = previosSubscene;
                }else if (whatToLoad == Subscene.PREVIOS_SUBSCENE){
                    return;
                }
                FXMLLoader fxmlLoader = new FXMLLoader(new URI(ResourceHelper.getResourceByType(ResourceHelper.ResourceFolder.SUB_SCENES, toLoad.fxml)).toURL());
                Parent tempContent = fxmlLoader.load();
                instance.subscene.getChildren().setAll(tempContent);
                instance.upperText.setText(
                        switch (toLoad){
                            case LOGIN -> "Авторизация";
                            case PROFILE -> "Профиль";
                            case REGISTER -> "Регистрация";
                            case NEWS -> "Новости";
                            case FORUM -> "Форум";
                            case FRIENDS -> "Друзья";
                            case SETTINGS -> "Настройки";
                            case PLAY -> "Играть";
                            default -> "Неизвестное окно..Ты как сюда забрался?";
                        }
                );
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
                                        ResourceHelper.ResourceFolder.LEFT_PANEL_IMAGE_P, imgName
                                ) :
                                        ResourceHelper.getResourceByType(
                                                ResourceHelper.ResourceFolder.LEFT_PANEL_IMAGE_NP, imgName
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