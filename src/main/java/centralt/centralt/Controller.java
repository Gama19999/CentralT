package centralt.centralt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.Date;

public class Controller {
    Operaciones obj1 = new Operaciones();

    // BUTTONS
    @FXML // fx:id="conect1"
    private Button conect1;
    @FXML // fx:id="conect2"
    private Button conect2;
    @FXML
    private Button colgarU11;
    @FXML
    private Button colgarU12;
    @FXML
    private Button colgarU13;
    @FXML
    private Button colgarU14;
    @FXML
    private Button colgarU21;
    @FXML
    private Button colgarU22;
    @FXML
    private Button colgarU23;
    @FXML
    private Button colgarU24;

    // COMBOBOXES
    @FXML // fx:id="users1"
    private ComboBox<String> users1;

    @FXML // fx:id="users2"
    private ComboBox<String> users2;

    // LABELS
    @FXML // fx:id="timer"
    protected Label timer;


    // METHODS
    @FXML
    protected void conect1Pressed() {
        System.out.println("Conectado User 1!");
        obj1.startTime();
    }

    @FXML
    protected void conect2Pressed() {
        System.out.println("Conectado  User2!");
        obj1.startTime();
    }

    @FXML
    protected void colgar(ActionEvent e) {
        System.out.println((e.getSource()));

        Date t = obj1.calculateSecs(System.currentTimeMillis());
        timer.setText(String.format("Segundos transcurridos %d:%d", t.getMinutes(), t.getSeconds()));
    }

    @FXML
    protected void user1Selected(ActionEvent e) {
        String selected = users1.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        System.out.println(e.toString());
    }

    @FXML
    protected void user2Selected(ActionEvent e) {
        String selected = users2.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        System.out.println(e.toString());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    public void initialize() {
        users1.getItems().removeAll(users1.getItems());
        users1.getItems().addAll("Jorge","Oscar","Christian","Gama");
        users1.getSelectionModel().select("Usuario 1");

        users2.getItems().removeAll(users2.getItems());
        users2.getItems().addAll("Sebastian","Raul","Rossi","Diego");
        users2.getSelectionModel().select("Usuario 2");
    }
}