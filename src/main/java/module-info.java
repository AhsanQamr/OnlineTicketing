module com.example.deliverable {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.deliverable to javafx.fxml;
    exports com.example.deliverable;
}