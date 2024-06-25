package space.typro.typicallauncher.utils;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class NodeUtil {

    /**
     *
     * @param parent Где находится нода "whatReplace"
     * @param whatReplace Нода, которая будет заменена на replaceTo
     * @param replaceTo Нода, на которую заменяется whatReplace
     * @return вернет replaceTo
     */
    public static Node replaceNode(Pane parent, Node whatReplace, Node replaceTo) {
        Platform.runLater(()->{
            if (parent != null && whatReplace != null && replaceTo != null) {
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
            }
        });
        return replaceTo;
    }

}
