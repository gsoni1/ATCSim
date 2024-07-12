module atc.atcsim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens atc.atcsim to javafx.fxml;
    exports atc.atcsim;
}