module com.planeshootinggame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.planeshootinggame to javafx.fxml;
    exports com.planeshootinggame;
}
