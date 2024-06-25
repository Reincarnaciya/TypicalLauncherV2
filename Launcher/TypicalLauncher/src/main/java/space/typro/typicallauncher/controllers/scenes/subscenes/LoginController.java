package space.typro.typicallauncher.controllers.scenes.subscenes;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lombok.CustomLog;
import space.typro.typicallauncher.ResourceHelper;
import space.typro.typicallauncher.controllers.BaseController;
import space.typro.typicallauncher.models.Account;
import space.typro.typicallauncher.utils.NodeUtil;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

@CustomLog
public class LoginController extends BaseController{

    @FXML
    private ImageView passwordVisibleImage;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private TextField login;
    @FXML
    private CheckBox saveAccount;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox autoLogin;
    @FXML
    private RadioButton withAccount;
    @FXML
    private RadioButton withoutAccount;
    @FXML
    private Hyperlink registr;
    @FXML
    private Button auth;
    @FXML
    private ComboBox<Account> accountList;


    private final TextField passwordShowField = new TextField();
    private PasswordField tempPassField = new PasswordField();


    private static final int minPasswordSize = 6;
    private static final int minNicknameSize = 6;

    private static final int maxNicknameSize = 16;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        auth.setOnMouseClicked(this::onAuthClick);
        setLoginField();
        setRadioButtons();
        setPasswordField();


        updateRadioButtonVisual(null);
    }

    private void setPasswordField() {

        passwordVisibleImage.setOnMousePressed(mouseEvent -> {
            passwordVisibleImage.setImage(new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceFolder.IMAGES, "login/Глаз-открытый.png")));
            tempPassField = password;
            passwordShowField.setPrefWidth(password.getPrefWidth());
            passwordShowField.setPrefHeight(password.getPrefHeight());
            passwordShowField.setText(password.getText());
            NodeUtil.replaceNode((Pane) password.getParent(), password, passwordShowField);
        });
        passwordVisibleImage.setOnMouseReleased(mouseEvent -> {
            passwordVisibleImage.setImage(new Image(ResourceHelper.getResourceByType(ResourceHelper.ResourceFolder.IMAGES, "login/Глаз-закрытый.png")));
            password = tempPassField;

            NodeUtil.replaceNode((Pane) passwordVisibleImage.getParent(), passwordShowField, password);
            password.requestFocus();
        });

        password.textProperty().addListener((observableValue, before, after) -> {
            if (!Pattern.matches("^[a-zA-Z\\d_!]*$", after)) {
                password.setText(before);
            }
        });
    }


    private void setRadioButtons() {
        ToggleGroup group = new ToggleGroup();

        group.getToggles().setAll(withAccount, withoutAccount);
        group.selectToggle(withAccount);

        group.selectedToggleProperty().addListener(this::updateRadioButtonVisual);
    }

    private void updateRadioButtonVisual(Observable observable) {
        password.setDisable(!withAccount.isSelected());
        saveAccount.setDisable(!withAccount.isSelected());
        autoLogin.setDisable(!withAccount.isSelected());
        accountList.setDisable(!withAccount.isSelected());
    }


    private void setLoginField() {
        login.textProperty().addListener((observableValue, before, after) -> {
            if (!Pattern.matches("^[a-zA-Z\\d_]*$", after)) {
                login.setText(before);
            }
        });
    }

    private void onAuthClick(MouseEvent mouseEvent) {


//        if ((password.getText().isEmpty() && !withoutAccount.isSelected()) || login.getText().isEmpty()) {
//            showErrorAlert("Логин или пароль не могут быть пусты");
//            return;
//        }
//        if (password.getLength() < minPasswordSize && !withoutAccount.isSelected()) {
//            showErrorAlert("Длина пароля не может быть меньше " + minPasswordSize);
//            return;
//        }
//        if (login.getLength() < minNicknameSize || login.getLength() > maxNicknameSize) {
//            showErrorAlert(String.format("Длина никнейма должны быть в диапозоне от %s до %s", minNicknameSize, maxNicknameSize));
//            return;
//        }
//
//        Account.User user = new Account.User(password.getText(), login.getText());
    }
}
