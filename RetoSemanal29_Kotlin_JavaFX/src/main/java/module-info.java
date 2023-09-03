module com.example.retosemanal29_kotlin_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    // Koin
    requires koin.core.jvm;
    requires java.sql;

    opens com.example.retosemanal29_kotlin_javafx.controller to javafx.fxml;

    exports com.example.retosemanal29_kotlin_javafx;
}