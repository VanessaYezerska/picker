module com.example.picker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.picker to javafx.fxml;
    exports com.example.picker;
}