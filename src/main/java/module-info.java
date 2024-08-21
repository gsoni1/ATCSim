module atc.atcsim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
//    requires com.formdev.flatlaf;
//    requires com.formdev.flatlaf;
//    requires org.apiguardian.api;

    opens atc.atcsim to javafx.fxml;
    exports atc.atcsim;
}