module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.DAOs to javafx.fxml;
    exports app.DAOs;
    exports app.controllers;
    opens app.controllers to javafx.fxml;
}