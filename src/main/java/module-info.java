module catlog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens catlog to javafx.fxml;
    exports catlog;
}

