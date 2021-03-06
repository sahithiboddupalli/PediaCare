module com.example.pediacare {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.apache.poi.ooxml;
    requires java.prefs;

    opens com.example.pediacare to javafx.fxml;
    exports com.example.pediacare;
}