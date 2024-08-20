module atc.atcsim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens atc.atcsim to javafx.fxml;
    exports atc.atcsim;
}