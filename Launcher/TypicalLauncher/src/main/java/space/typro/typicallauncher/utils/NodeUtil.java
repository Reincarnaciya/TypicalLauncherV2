package space.typro.typicallauncher.utils;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class NodeUtil {

    /**
     * Заменяет ноду в родительском контейнере.
     *
     * @param parent      Родительский контейнер, в котором находится нода.
     * @param whatReplace Нода, которая будет заменена.
     * @param replaceTo   Нода, на которую будет произведена замена.
     * @return Возвращает ноду, на которую была произведена замена.
     */
    public static Node replaceNode(Pane parent, Node whatReplace, Node replaceTo) {
        if (parent == null || whatReplace == null || replaceTo == null) {
            throw new IllegalArgumentException("Parent, whatReplace, and replaceTo cannot be null");
        }

        Platform.runLater(() -> {
            int index = parent.getChildren().indexOf(whatReplace);
            if (index != -1) {
                replaceTo.setLayoutX(whatReplace.getLayoutX());
                replaceTo.setLayoutY(whatReplace.getLayoutY());

                replaceTo.setTranslateX(whatReplace.getTranslateX());
                replaceTo.setTranslateY(whatReplace.getTranslateY());

                replaceTo.setRotate(whatReplace.getRotate());

                replaceTo.setScaleX(whatReplace.getScaleX());
                replaceTo.setScaleY(whatReplace.getScaleY());

                replaceTo.setVisible(true);

                parent.getChildren().set(index, replaceTo);
            }
        });

        return replaceTo;
    }
}