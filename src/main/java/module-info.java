module centralt.centralt {
    requires javafx.controls;
    requires javafx.fxml;


    opens centralt.centralt to javafx.fxml;
    exports centralt.centralt;
}