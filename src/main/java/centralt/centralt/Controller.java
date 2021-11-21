package centralt.centralt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Line;

import java.util.*;

public class Controller {
    private int x = -1;

    // PERSONAS
    private HashMap<String, Boolean> personas;

    // ENLACES
    private ArrayList<Enlace> links;

    // BUTTONS
    @FXML
    private Button conect1;
    @FXML
    private Button conect2;
    @FXML
    private Button liberarE1;
    @FXML
    private Button liberarE2;
    @FXML
    private Button liberarE3;
    @FXML
    private Button liberarE4;
    @FXML
    private Button paid1;
    @FXML
    private Button paid2;
    @FXML
    private Button paid3;
    @FXML
    private Button paid4;

    private ArrayList<Button> buttons;
    private ArrayList<Button> paids;

    // COMBOBOXES
    @FXML // fx:id="users1"
    private ComboBox<String> users1;

    @FXML // fx:id="users2"
    private ComboBox<String> users2;

    // LABELS
    @FXML
    protected Label info;
    @FXML
    protected Label enlace1;
    @FXML
    protected Label enlace2;
    @FXML
    protected Label enlace3;
    @FXML
    protected Label enlace4;
    @FXML
    protected Label enlaceEspera1;
    @FXML
    protected Label enlaceEspera2;
    @FXML
    protected Label enlaceEspera3;

    private ArrayList<Label> labels;

    int aux = 0; // Línea cambio

    // METHODS
    @FXML
    protected void conectPressed() {
        String involucrado1 = users1.getSelectionModel().getSelectedItem();
        String involucrado2 = users2.getSelectionModel().getSelectedItem();

        // Enlaces llenos
        if (x == 3) {
            info.setText("¡Enlaces disponibles ocupados!");
            return;
        }

        // No se selecciono algun usuario en los comboboxes
        if (involucrado1.equals("Usuario 1") || involucrado2.equals("Usuario 2")) {
            info.setText("Usuarios no seleccionados");
            return;
        }

        // Verificando disponibilidad del enlace

        if(personas.get(involucrado1)){
            if(personas.get(involucrado2)){
                for(int i=0; i<4; i++){
                    if(!paids.get(i).isVisible()){
                        links.add(new Enlace(involucrado1, involucrado2, i));
                        info.setText("Enlace Establecido");
                        x++;

                        personas.replace(involucrado1, false);
                        personas.replace(involucrado2, false);

                        labels.get(i).setText("Enlace " + i + ": " + involucrado1 + " conectado con " + involucrado2);
                        labels.get(i).setVisible(true);
                        buttons.get(i).setVisible(true);
                        break;
                    }
                }
            } else {
                info.setText("¡" + involucrado2 + " está ocupado!");
            }
        } else {
            info.setText("¡" + involucrado1 + " está ocupado!");
        }

        // TODO inicializar ruta

        // Regresando comboboxes al original
        users1.getSelectionModel().select("Usuario 1");
        users2.getSelectionModel().select("Usuario 2");
    }

    @FXML
    protected void colgar(ActionEvent e) {

        info.setText("Enlace Liberado. Presione Pagado.");

        int minutos = 0;
        int segundos = 0;
        float price = 0.0f;
        int buttonNumber = -1;
        int indexToFree = -1;

        // Verifica que boton se presiono
        for (int i = 0; i < buttons.size(); ++i) {
            buttonNumber = e.getSource().equals(buttons.get(i)) ? i : -1;
            System.out.println(e.getSource().toString());
            System.out.println("Boton presionado" + buttonNumber);
            if (buttonNumber != -1) break;
        }

        if (x == -1) { // No hay enlaces
            info.setText("¡No hay enlaces activos!");
        } else {
            // Verificar que enlace se libera
            for (int s = 0; s < links.size(); ++s) {
                indexToFree = buttonNumber == links.get(s).getNumLink() ? s : -1;
                System.out.println("Enlace a liberar" + indexToFree);
                if (indexToFree != -1) break;
            }

            x--; // Resta un enlace

            // Generando factura
            Date timer = links.get(indexToFree).finalizarTimer();
            minutos = timer.getMinutes();
            segundos = timer.getSeconds();
            price = (timer.getMinutes() * 1.5f) + (timer.getSeconds() * 0.75f);

            // TODO terminar ruta

            // Actualizando estado de usuario a libre
            personas.replace(links.get(indexToFree).getInvolucrados().getKey(), true);
            personas.replace(links.get(indexToFree).getInvolucrados().getValue(), true);
            links.remove(indexToFree);

            // Actualizando elementos graficos
            String t = "Enlace liberado en " + minutos + ":" + segundos + " | Factura: $" + String.format("%.2f", price);
            labels.get(buttonNumber).setText(t);
            buttons.get(buttonNumber).setVisible(false);
            paids.get(buttonNumber).setVisible(true);
        }
    }

    @FXML
    protected void pagar(ActionEvent e) {
        int source = -1;

        // Verifica que boton de pagar se acciona
        for (int i = 0; i < paids.size(); ++i) {
            source = e.getSource().equals(paids.get(i)) ? i : -1;
            if (source != -1) break;
        }

        info.setText("¡Enlace " + source + " pagado!");
        paids.get(source).setVisible(false);
        labels.get(source).setVisible(false);
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
        // USUARIOS
        personas = new HashMap<>(){{
            put("Jorge", true);
            put("Oscar", true);
            put("Christian", true);
            put("Gamaliel", true);
            put("Sebas", true);
            put("Raul", true);
            put("Rossi", true);
            put("Diego", true);
        }};

        // LINKS
        links = new ArrayList<>();

        // BUTTONS
        buttons = new ArrayList<>(Arrays.asList(liberarE1,liberarE2,liberarE3,liberarE4));
        paids = new ArrayList<>(Arrays.asList(paid1,paid2,paid3,paid4));

        // LABELS
        labels = new ArrayList<>(Arrays.asList(
                enlace1,enlace2,enlace3,enlace4,enlaceEspera1,enlaceEspera2,enlaceEspera3
        ));

        // INICIALIZANDO COMBOBOXES
        users1.getItems().removeAll(users1.getItems());
        users1.getItems().addAll("Jorge","Oscar","Christian","Gamaliel");
        users1.getSelectionModel().select("Usuario 1");

        users2.getItems().removeAll(users2.getItems());
        users2.getItems().addAll("Sebas","Raul","Rossi","Diego");
        users2.getSelectionModel().select("Usuario 2");
    }
}