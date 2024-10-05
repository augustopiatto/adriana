module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens controller.javafx to javafx.fxml;
    exports controller.javafx;
}