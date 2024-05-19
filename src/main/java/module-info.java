module handle {
    requires javafx.controls;
    requires javafx.fxml;

    opens handle to javafx.fxml;
    exports handle;
}
