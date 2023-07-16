module com.example.libraryui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.libraryui.model to javafx.base;
    exports com.example.libraryui;
    opens com.example.libraryui to javafx.base, javafx.fxml;
}