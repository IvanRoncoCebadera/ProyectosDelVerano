module com.example.practicajavafxenverano {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    // Logger
    requires io.github.microutils.kotlinlogging;
    requires koin.logger.slf4j;
    requires org.slf4j;

    // Koin
    requires koin.core.jvm;
    requires java.sql;

    // Result
    requires kotlin.result.jvm;

    // Gson
    requires com.google.gson;

    opens com.example.practicajavafxenverano to javafx.fxml;
    exports com.example.practicajavafxenverano;

    // dtos, abrimos a Gson
    opens com.example.practicajavafxenverano.dto.models to com.google.gson;

    opens com.example.practicajavafxenverano.models to javafx.fxml;
    exports com.example.practicajavafxenverano.models;
}