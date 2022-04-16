module com.example.deliverable {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.deliverable to javafx.fxml;
    exports com.example.deliverable;
}