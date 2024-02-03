package space.typro.typicallauncher.controllers.scenes.subscenes;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import space.typro.typicallauncher.Main;
import space.typro.typicallauncher.controllers.scenes.BaseController;
import space.typro.typicallauncher.controllers.scenes.LauncherController;

public class SettingsController extends BaseController {

    @FXML
    private Slider ramSlider;
    @FXML
    private TextField ramTextField;
    @FXML
    private TextField widthTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private CheckBox fullscreenCheckBox;
    @FXML
    private CheckBox hideLauncherCheckBox;
    @FXML
    private Button openLauncherFolderButton;
    @FXML
    private Hyperlink clientPathHyperlink;
    @FXML
    private Button saveButton;
    @FXML
    private Button resetButton;
    @FXML
    private Text launcherVersionText;

    @FXML
    public void initialize() {
        super.initialize();

        launcherVersionText.setText(launcherVersionText.getText() + " " + Main.LAUNCHER_VERSION);

        openLauncherFolderButton.setOnMouseClicked(this::openLauncherDir);



    }

    private void openLauncherDir(MouseEvent mouseEvent) {

    }
}