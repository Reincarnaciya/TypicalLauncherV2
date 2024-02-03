module space.typro.typicallauncher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires lombok;

    opens space.typro.typicallauncher to javafx.fxml;
    exports space.typro.typicallauncher;
    exports space.typro.typicallauncher.controllers.scenes.subscenes;
    opens space.typro.typicallauncher.controllers.scenes.subscenes to javafx.fxml;
    exports space.typro.typicallauncher.controllers.scenes;
    opens space.typro.typicallauncher.controllers.scenes to javafx.fxml;
}
