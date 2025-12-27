module com.planeshootinggame {
    requires javafx.controls;
    requires javafx.media;
    requires javafx.fxml;

    opens com.planeshootinggame to javafx.fxml;
    exports com.planeshootinggame;
}
