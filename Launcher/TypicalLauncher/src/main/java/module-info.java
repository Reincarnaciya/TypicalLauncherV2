module space.typro.typicallauncher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens space.typro.typicallauncher to javafx.fxml;
    exports space.typro.typicallauncher;
}