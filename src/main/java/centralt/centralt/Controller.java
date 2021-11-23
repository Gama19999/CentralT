package centralt.centralt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class Controller {
    private int x = -1;

    // COLORES
    private final String def = "#042b54";
    private final Color jorge = Color.RED;
    private final Color oscar = Color.GREENYELLOW;
    private final Color chris = Color.ORANGE;
    private final Color gama = Color.CHOCOLATE;

    // VARIABLES ROUTERS
    private boolean routerCol1_1 = true;
    private boolean routerCol1_2 = true;
    private boolean routerCol1_3 = true;
    private boolean vacio1 = true;
    private boolean routerCol2_1 = true;
    private boolean routerCol2_2 = true;
    private boolean routerCol2_3 = true;
    private boolean routerCol2_4 = true;
    private boolean routerCol3_1 = true;
    private boolean routerCol3_2 = true;
    private boolean routerCol3_3 = true;
    private boolean routerCol3_4 = true;
    private boolean routerCol4_1 = true;
    private boolean routerCol4_2 = true;
    private boolean routerCol4_3 = true;
    private boolean routerCol4_4 = true;
    private boolean routerCol5_1 = true;
    private boolean routerCol5_2 = true;
    private boolean routerCol5_3 = true;
    private boolean vacio2 = true;

    private ArrayList<Boolean> rutasRouterCol1;
    private ArrayList<Boolean> rutasRouterCol2;
    private ArrayList<Boolean> rutasRouterCol3;
    private ArrayList<Boolean> rutasRouterCol4;
    private ArrayList<Boolean> rutasRouterCol5;


    // NUMERO DE ROUTER QUE TOMARON (Oscar, Christian) 1,2,3
    private int[] routeJor;
    private int[] routeOsc;
    private int[] routeChr;
    private int[] routeGam;

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

    // LINES
    @FXML
    protected Line col1_1;
    @FXML
    protected Line col1_2;
    @FXML
    protected Line col1_3;
    @FXML
    protected Line col1_4;
    @FXML
    protected Line col1_5;
    @FXML
    protected Line col1_6;

    @FXML
    protected Line col2_1;
    @FXML
    protected Line col2_2;
    @FXML
    protected Line col2_3;
    @FXML
    protected Line col2_4;
    @FXML
    protected Line col2_5;
    @FXML
    protected Line col2_6;

    @FXML
    protected Line col3_1;
    @FXML
    protected Line col3_2;
    @FXML
    protected Line col3_3;
    @FXML
    protected Line col3_4;
    @FXML
    protected Line col3_5;
    @FXML
    protected Line col3_6;
    @FXML
    protected Line col3_7;
    @FXML
    protected Line col3_8;

    @FXML
    protected Line col4_1;
    @FXML
    protected Line col4_2;
    @FXML
    protected Line col4_3;
    @FXML
    protected Line col4_4;
    @FXML
    protected Line col4_5;
    @FXML
    protected Line col4_6;
    @FXML
    protected Line col4_7;
    @FXML
    protected Line col4_8;

    @FXML
    protected Line col5_1;
    @FXML
    protected Line col5_2;
    @FXML
    protected Line col5_3;
    @FXML
    protected Line col5_4;
    @FXML
    protected Line col5_5;
    @FXML
    protected Line col5_6;

    @FXML
    protected Line col6_1;
    @FXML
    protected Line col6_2;
    @FXML
    protected Line col6_3;
    @FXML
    protected Line col6_4;
    @FXML
    protected Line col6_5;
    @FXML
    protected Line col6_6;

    // LINEAS ARRAYLIST
    private ArrayList<Line> lineasAll;

    // METHODS
    @FXML
    protected void conectPressed() {
        String involucrado1 = users1.getSelectionModel().getSelectedItem();
        String involucrado2 = users2.getSelectionModel().getSelectedItem();

        // Enlaces llenos
        if (x == 3) {
            info.setText("¡Enlaces disponibles ocupados o sin pagar!");
            return;
        }

        // No se selecciono algun usuario en los comboboxes
        if (involucrado1.equals("Usuario 1") || involucrado2.equals("Usuario 2")) {
            info.setText("Usuarios no seleccionados");
            return;
        }

        System.out.println(rutasRouterCol1.toString());
        System.out.println(rutasRouterCol2.toString());

        // TODO inicializar ruta
        int possible = 0;
        if (involucrado1.equals("Jorge")) {
            possible = rutaJorge(involucrado2);
            if (possible == -1) return;
        }
        if (involucrado1.equals("Oscar")) {
            possible = rutaOscar(involucrado2);
            if (possible == -1) return;
        }
        if (involucrado1.equals("Christian")) {
            possible = rutaChristian(involucrado2);
            if (possible == -1) return;
        }
        if (involucrado1.equals("Gamaliel")) {
            possible = rutaGama(involucrado2);
            if (possible == -1) return;
        }

        // Verificando disponibilidad del enlace
        if(personas.get(involucrado1)) {
            if(personas.get(involucrado2)) {
                for(int i=0; i<4; i++) {
                    if(!buttons.get(i).isVisible()) {
                        if(!paids.get(i).isVisible()) {
                            links.add(new Enlace(involucrado1, involucrado2, i));
                            info.setText("Enlace Establecido");
                            x++;

                            // Establece usuarios en ocupado
                            personas.replace(involucrado1, false);
                            personas.replace(involucrado2, false);

                            labels.get(i).setText("Llamada " + i + ": " + involucrado1 + " conectado con " + involucrado2);
                            labels.get(i).setVisible(true);
                            buttons.get(i).setVisible(true);
                            break;
                        }
                    }
                }
            } else {
                info.setText("¡" + involucrado2 + " está ocupado!");
            }
        } else {
            info.setText("¡" + involucrado1 + " está ocupado!");
        }

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

            // x--; // Resta un enlace

            // Generando factura
            Date timer = links.get(indexToFree).finalizarTimer();
            minutos = timer.getMinutes();
            segundos = timer.getSeconds();
            price = (timer.getMinutes() * 1.5f) + (timer.getSeconds() * 0.75f);

            // TODO terminar ruta
            limpiarRuta(links.get(indexToFree).getInvolucrados().getKey());
            System.out.println("Se liberaron los routes");

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

        // Regresa al default la Etiqueta
        labels.get(source).setText("Enlace");

        x--; // Libera un enlace, porque ya se pago

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

    /**
     * Colorea la ruta (si disponible) entre usuario Jorge y Usuario 2
     * @param usuario2 String con el usuario2
     * @return Devuelve 0 si hay una ruta diponible. Devuelve -1 si no hay ruta disponible.
     */
    private int rutaJorge(String usuario2) {
        switch (usuario2) {
            case "Sebas" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(0)) {
                        if (rutasRouterCol4.get(0)) {
                            rutasRouterCol1.set(0, false);
                            rutasRouterCol2.set(0, false);
                            rutasRouterCol3.set(0, false);
                            rutasRouterCol4.set(0, false);
                            rutasRouterCol5.set(0, false);

                            System.out.println("Se convirtieron a false");

                            for (int p = 0; p < 5; ++p) routeJor[p] = 0;

                            col1_1.setStroke(jorge);
                            col2_1.setStroke(jorge);
                            col3_1.setStroke(jorge);
                            col4_1.setStroke(jorge);
                            col5_1.setStroke(jorge);
                            col6_1.setStroke(jorge);
                            return 0;
                        } else {
                            info.setText("Ruta no disponible para enlace Jorge y Sebas");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Jorge y Sebas");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Jorge y Sebas");
                    return -1;
                }
            }
            case "Raul" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(0)) {
                        if (rutasRouterCol4.get(0)) {
                            rutasRouterCol1.set(0, false);
                            rutasRouterCol2.set(0, false);
                            rutasRouterCol3.set(0, false);
                            rutasRouterCol4.set(0, false);
                            rutasRouterCol5.set(0, false);
                            System.out.println("Se convirtieron a false");

                            for (int p = 0; p < 5; ++p) routeJor[p] = 0;

                            col1_1.setStroke(jorge);
                            col2_1.setStroke(jorge);
                            col3_1.setStroke(jorge);
                            col4_1.setStroke(jorge);
                            col5_1.setStroke(jorge);
                            col6_2.setStroke(jorge);
                            return 0;
                        } else {
                            info.setText("Ruta no disponible para enlace Jorge y Sebas");
                            return -1;
                        }
                    }  else {
                        info.setText("Ruta no disponible para enlace Jorge y Raul");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Jorge y Raul");
                    return -1;
                }
            }
            case "Rossi" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(0)) {
                        if (rutasRouterCol4.get(1)) {
                            if (rutasRouterCol5.get(1)) {
                                rutasRouterCol1.set(0, false);
                                rutasRouterCol2.set(0, false);
                                rutasRouterCol3.set(0, false);
                                rutasRouterCol4.set(0, false);
                                rutasRouterCol5.set(0, false);
                                System.out.println("Se convirtieron a false");

                                for (int p = 0; p < 5; ++p) {
                                    if (p == 3 || p == 4) routeJor[p] = 1;
                                    else routeJor[p] = 0;
                                }

                                col1_1.setStroke(jorge);
                                col2_1.setStroke(jorge);
                                col3_1.setStroke(jorge);
                                col4_2.setStroke(jorge);
                                col5_3.setStroke(jorge);
                                col6_4.setStroke(jorge);
                                return 0;
                            } else {
                                info.setText("Ruta no disponible para enlace Jorge y Sebas");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Jorge y Sebas");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Jorge y Rossi");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Jorge y Rossi");
                    return -1;
                }
            }
            case "Diego" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(1)) {
                        if (rutasRouterCol4.get(2)) {
                            if (rutasRouterCol5.get(2)) {
                                rutasRouterCol1.set(0, false);
                                rutasRouterCol2.set(0, false);
                                rutasRouterCol3.set(1, false);
                                rutasRouterCol4.set(2, false);
                                rutasRouterCol5.set(2, false);
                                System.out.println("Se convirtieron a false");

                                for (int p = 0; p < 5; ++p) {
                                    if (p == 2) routeJor[p] = 1;
                                    else if (p == 3 || p == 4) routeJor[p] = 2;
                                    else routeJor[p] = 0;
                                }

                                col1_1.setStroke(jorge);
                                col2_1.setStroke(jorge);
                                col3_2.setStroke(jorge);
                                col4_4.setStroke(jorge);
                                col5_5.setStroke(jorge);
                                col6_6.setStroke(jorge);
                                return 0;
                            } else {
                                info.setText("Ruta no disponible para enlace Jorge y Sebas");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Jorge y Sebas");
                            return -1;
                        }
                    }  else {
                        info.setText("Ruta no disponible para enlace Jorge y Diego");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Jorge y Diego");
                    return -1;
                }
            }
            default -> {
                return -1;
            }
        }
    }

    /**
     * Colorea la ruta (si disponible) entre usuario Oscar y Usuario 2
     * @param usuario2 String con el usuario2
     * @return Devuelve 0 si hay una ruta diponible. Devuelve -1 si no hay ruta disponible.
     */
    private int rutaOscar(String usuario2) {
        switch (usuario2) {
            case "Sebas" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(0)) {
                        if (rutasRouterCol4.get(0)) {
                            if (rutasRouterCol5.get(0)) {
                                rutasRouterCol1.set(0, false);
                                rutasRouterCol2.set(0, false);
                                rutasRouterCol3.set(0, false);
                                rutasRouterCol4.set(0, false);
                                rutasRouterCol5.set(0, false);

                                for (int p = 0; p < 5; ++p) {
                                    routeOsc[p] = 0;
                                }

                                col1_2.setStroke(oscar);
                                col2_1.setStroke(oscar);
                                col3_1.setStroke(oscar);
                                col4_1.setStroke(oscar);
                                col5_1.setStroke(oscar);
                                col6_1.setStroke(oscar);
                                return 0;
                            } else {
                                info.setText("Ruta no disponible para enlace Oscar y Sebas");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Oscar y Sebas");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Oscar y Sebas");
                        return -1;
                    }
                } else if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(1)) {
                        if (rutasRouterCol3.get(0)) {
                            if (rutasRouterCol4.get(0)) {
                                if (rutasRouterCol5.get(0)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(1, false);
                                    rutasRouterCol3.set(0, false);
                                    rutasRouterCol4.set(0, false);
                                    rutasRouterCol5.set(0, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p >= 2) routeOsc[p] = 0;
                                        else routeOsc[p] = 1;
                                    }

                                    col1_3.setStroke(oscar);
                                    col2_3.setStroke(oscar);
                                    col3_3.setStroke(oscar);
                                    col4_1.setStroke(oscar);
                                    col5_1.setStroke(oscar);
                                    col6_1.setStroke(oscar);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Oscar y Sebas");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Oscar y Sebas");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Oscar y Sebas");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Oscar y Sebas");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Oscar y Sebas");
                    return -1;
                }
            }
            case "Raul" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(0)) {
                        if (rutasRouterCol4.get(0)) {
                            if (rutasRouterCol5.get(0)) {
                                rutasRouterCol1.set(0, false);
                                rutasRouterCol2.set(0, false);
                                rutasRouterCol3.set(0, false);
                                rutasRouterCol4.set(0, false);
                                rutasRouterCol5.set(0, false);

                                for (int p = 0; p < 5; ++p) {
                                    routeOsc[p] = 0;
                                }

                                col1_2.setStroke(oscar);
                                col2_1.setStroke(oscar);
                                col3_1.setStroke(oscar);
                                col4_1.setStroke(oscar);
                                col5_1.setStroke(oscar);
                                col6_2.setStroke(oscar);
                                return 0;
                            } else {
                                info.setText("Ruta no disponible para enlace Oscar y Raul");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Oscar y Raul");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Oscar y Raul");
                        return -1;
                    }
                }
                else if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(1)) {
                        if (rutasRouterCol3.get(0)) {
                            if (rutasRouterCol4.get(0)) {
                                if (rutasRouterCol5.get(0)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(1, false);
                                    rutasRouterCol3.set(0, false);
                                    rutasRouterCol4.set(0, false);
                                    rutasRouterCol5.set(0, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p >= 2) routeOsc[p] = 0;
                                        else routeOsc[p] = 1;
                                    }

                                    col1_3.setStroke(oscar);
                                    col2_3.setStroke(oscar);
                                    col3_3.setStroke(oscar);
                                    col4_1.setStroke(oscar);
                                    col5_1.setStroke(oscar);
                                    col6_2.setStroke(oscar);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Oscar y Raul");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Oscar y Raul");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Oscar y Raul");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Oscar y Raul");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Oscar y Raul");
                    return -1;
                }
            }
            case "Rossi" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(0)) {
                        if (rutasRouterCol4.get(1)) {
                            if (rutasRouterCol5.get(1)) {
                                rutasRouterCol1.set(0, false);
                                rutasRouterCol2.set(0, false);
                                rutasRouterCol3.set(0, false);
                                rutasRouterCol4.set(1, false);
                                rutasRouterCol5.set(1, false);

                                for (int p = 0; p < 5; ++p) {
                                    if (p >= 3) routeOsc[p] = 1;
                                    else routeOsc[p] = 0;
                                }

                                col1_2.setStroke(oscar);
                                col2_1.setStroke(oscar);
                                col3_1.setStroke(oscar);
                                col4_2.setStroke(oscar);
                                col5_3.setStroke(oscar);
                                col6_4.setStroke(oscar);
                                return 0;
                            } else {
                                info.setText("Ruta no disponible para enlace Oscar y Rossi");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Oscar y Rossi");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Oscar y Rossi");
                        return -1;
                    }
                } else if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(1)) {
                        if (rutasRouterCol3.get(0)) {
                            if (rutasRouterCol4.get(1)) {
                                if (rutasRouterCol5.get(1)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(1, false);
                                    rutasRouterCol3.set(0, false);
                                    rutasRouterCol4.set(1, false);
                                    rutasRouterCol5.set(1, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 2) routeOsc[p] = 0;
                                        else routeOsc[p] = 1;
                                    }

                                    col1_3.setStroke(oscar);
                                    col2_3.setStroke(oscar);
                                    col3_3.setStroke(oscar);
                                    col4_2.setStroke(oscar);
                                    col5_3.setStroke(oscar);
                                    col6_4.setStroke(oscar);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Oscar y Rossi");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Oscar y Rossi");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Oscar y Rossi");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Oscar y Rossi");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Oscar y Rossi");
                    return -1;
                }
            }
            case "Diego" -> {
                if (rutasRouterCol1.get(0)) {
                    if (rutasRouterCol3.get(1)) {
                        if (rutasRouterCol4.get(2)) {
                            if (rutasRouterCol5.get(2)) {
                                rutasRouterCol1.set(0, false);
                                rutasRouterCol2.set(0, false);
                                rutasRouterCol3.set(1, false);
                                rutasRouterCol4.set(2, false);
                                rutasRouterCol5.set(2, false);

                                for (int p = 0; p < 5; ++p) {
                                    if (p == 2) routeOsc[p] = 1;
                                    else if (p > 2) routeOsc[p] = 2;
                                    else routeOsc[p] = 0;
                                }

                                col1_2.setStroke(oscar);
                                col2_1.setStroke(oscar);
                                col3_2.setStroke(oscar);
                                col4_4.setStroke(oscar);
                                col5_5.setStroke(oscar);
                                col6_6.setStroke(oscar);
                                return 0;
                            }  else {
                                info.setText("Ruta no disponible para enlace Oscar y Diego");
                                return -1;
                            }
                        }  else {
                            info.setText("Ruta no disponible para enlace Oscar y Diego");
                            return -1;
                        }
                    }  else {
                        info.setText("Ruta no disponible para enlace Oscar y Diego");
                        return -1;
                    }
                } else if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(1)) {
                        if (rutasRouterCol3.get(2)) {
                            if (rutasRouterCol4.get(3)) {
                                if (rutasRouterCol5.get(2)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(1, false);
                                    rutasRouterCol3.set(2, false);
                                    rutasRouterCol4.set(3, false);
                                    rutasRouterCol5.set(2, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 3) routeOsc[p] = 3;
                                        else if (p == 2 || p == 4) routeOsc[p] = 2;
                                        else routeOsc[p] = 1;
                                    }

                                    col1_3.setStroke(oscar);
                                    col2_3.setStroke(oscar);
                                    col3_4.setStroke(oscar);
                                    col4_6.setStroke(oscar);
                                    col5_6.setStroke(oscar);
                                    col6_6.setStroke(oscar);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Oscar y Diego");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Oscar y Diego");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Oscar y Diego");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Oscar y Diego");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Oscar y Diego");
                    return -1;
                }
            }
            default -> {
                return -1;
            }
        }
    }

    private int rutaChristian(String usuario2) {
        switch (usuario2) {
            case "Sebas" -> {
                if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(1)) {
                        if (rutasRouterCol3.get(0)) {
                            if (rutasRouterCol4.get(1)) {
                                if (rutasRouterCol5.get(0)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(1, false);
                                    rutasRouterCol3.set(0, false);
                                    rutasRouterCol4.set(1, false);
                                    rutasRouterCol5.set(0, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 2 || p == 4) routeChr[p] = 0;
                                        else routeChr[p] = 1;
                                    }

                                    col1_4.setStroke(chris);
                                    col2_3.setStroke(chris);
                                    col3_3.setStroke(chris);
                                    col4_2.setStroke(chris);
                                    col5_2.setStroke(chris);
                                    col6_1.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Sebas");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Sebas");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Sebas");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Sebas");
                        return -1;
                    }
                } else if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(2)) {
                        if (rutasRouterCol3.get(1)) {
                            if (rutasRouterCol4.get(0)) {
                                if (rutasRouterCol5.get(0)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(2, false);
                                    rutasRouterCol3.set(1, false);
                                    rutasRouterCol4.set(0, false);
                                    rutasRouterCol5.set(0, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p <= 1) routeChr[p] = 2;
                                        else if (p == 2) routeChr[p] = 1;
                                        else routeChr[p] = 0;
                                    }

                                    col1_5.setStroke(chris);
                                    col2_5.setStroke(chris);
                                    col3_5.setStroke(chris);
                                    col4_3.setStroke(chris);
                                    col5_1.setStroke(chris);
                                    col6_1.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Sebas");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Sebas");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Sebas");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Sebas");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Christian y Sebas");
                    return -1;
                }
            }
            case "Raul" -> {
                if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(1)) {
                        if (rutasRouterCol3.get(0)) {
                            if (rutasRouterCol4.get(0)) {
                                if (rutasRouterCol5.get(0)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(1, false);
                                    rutasRouterCol3.set(1, false);
                                    rutasRouterCol4.set(0, false);
                                    rutasRouterCol5.set(0, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p <= 2) routeChr[p] = 1;
                                        else routeChr[p] = 0;
                                    }

                                    col1_4.setStroke(chris);
                                    col2_3.setStroke(chris);
                                    col3_3.setStroke(chris);
                                    col4_1.setStroke(chris);
                                    col5_1.setStroke(chris);
                                    col6_2.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Raul");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Raul");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Raul");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Raul");
                        return -1;
                    }
                } else if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(2)) {
                        if (rutasRouterCol3.get(1)) {
                            if (rutasRouterCol4.get(2)) {
                                if (rutasRouterCol5.get(1)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(2, false);
                                    rutasRouterCol3.set(1, false);
                                    rutasRouterCol4.set(2, false);
                                    rutasRouterCol5.set(1, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 2 || p == 4) routeChr[p] = 1;
                                        else routeChr[p] = 2;
                                    }

                                    col1_5.setStroke(chris);
                                    col2_5.setStroke(chris);
                                    col3_5.setStroke(chris);
                                    col4_4.setStroke(chris);
                                    col5_4.setStroke(chris);
                                    col6_3.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Raul");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Raul");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Raul");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Raul");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Christian y Raul");
                    return -1;
                }
            }
            case "Rossi" -> {
                if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(2)) {
                        if (rutasRouterCol3.get(1)) {
                            if (rutasRouterCol4.get(2)) {
                                if (rutasRouterCol5.get(1)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(2, false);
                                    rutasRouterCol3.set(1, false);
                                    rutasRouterCol4.set(2, false);
                                    rutasRouterCol5.set(1, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 1 || p == 3) routeChr[p] = 2;
                                        else routeChr[p] = 1;
                                    }

                                    col1_4.setStroke(chris);
                                    col2_4.setStroke(chris);
                                    col3_5.setStroke(chris);
                                    col4_4.setStroke(chris);
                                    col5_4.setStroke(chris);
                                    col6_4.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Rossi");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Rossi");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Rossi");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Rossi");
                        return -1;
                    }
                } else if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(3)) {
                        if (rutasRouterCol3.get(3)) {
                            if (rutasRouterCol4.get(3)) {
                                if (rutasRouterCol5.get(2)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(3, false);
                                    rutasRouterCol3.set(3, false);
                                    rutasRouterCol4.set(3, false);
                                    rutasRouterCol5.set(2, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 0 || p == 4) routeChr[p] = 2;
                                        else routeChr[p] = 3;
                                    }

                                    col1_5.setStroke(chris);
                                    col2_6.setStroke(chris);
                                    col3_8.setStroke(chris);
                                    col4_8.setStroke(chris);
                                    col5_6.setStroke(chris);
                                    col6_5.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Rossi");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Rossi");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Rossi");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Rossi");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Christian y Rossi");
                    return -1;
                }
            }
            case "Diego" -> {
                if (rutasRouterCol1.get(1)) {
                    if (rutasRouterCol2.get(2)) {
                        if (rutasRouterCol3.get(3)) {
                            if (rutasRouterCol4.get(2)) {
                                if (rutasRouterCol5.get(2)) {
                                    rutasRouterCol1.set(1, false);
                                    rutasRouterCol2.set(2, false);
                                    rutasRouterCol3.set(3, false);
                                    rutasRouterCol4.set(2, false);
                                    rutasRouterCol5.set(2, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 0) routeChr[p] = 1;
                                        else if (p == 2) routeChr[p] = 3;
                                        else routeChr[p] = 2;
                                    }

                                    col1_4.setStroke(chris);
                                    col2_4.setStroke(chris);
                                    col3_6.setStroke(chris);
                                    col4_7.setStroke(chris);
                                    col5_5.setStroke(chris);
                                    col6_6.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Diego");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Diego");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Diego");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Diego");
                        return -1;
                    }
                } else if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(3)) {
                        if (rutasRouterCol3.get(3)) {
                            if (rutasRouterCol4.get(3)) {
                                if (rutasRouterCol5.get(2)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(3, false);
                                    rutasRouterCol3.set(3, false);
                                    rutasRouterCol4.set(3, false);
                                    rutasRouterCol5.set(2, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 0 || p == 4) routeChr[p] = 2;
                                        else routeChr[p] = 3;
                                    }

                                    col1_5.setStroke(chris);
                                    col2_6.setStroke(chris);
                                    col3_8.setStroke(chris);
                                    col4_8.setStroke(chris);
                                    col5_6.setStroke(chris);
                                    col6_6.setStroke(chris);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Christian y Diego");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Christian y Diego");
                                return -1;
                            }
                        } else {
                            info.setText("Ruta no disponible para enlace Christian y Diego");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Christian y Diego");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Christian y Diego");
                    return -1;
                }
            }
            default -> {
                return -1;
            }
        }
    }

    private int rutaGama(String usuario2) {
        switch (usuario2) {
            case "Sebas" -> {
                if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(3)) {
                        if (rutasRouterCol3.get(2)) {
                            if (rutasRouterCol4.get(1)) {
                                if (rutasRouterCol5.get(0)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(3, false);
                                    rutasRouterCol3.set(2, false);
                                    rutasRouterCol4.set(1, false);
                                    rutasRouterCol5.set(0, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 0 || p == 2) routeGam[p] = 2;
                                        else if (p == 1) routeGam[p] = 3;
                                        else if (p == 3) routeGam[p] = 1;
                                        else routeGam[p] = 0;
                                    }

                                    col1_6.setStroke(gama);
                                    col2_6.setStroke(gama);
                                    col3_7.setStroke(gama);
                                    col4_5.setStroke(gama);
                                    col5_2.setStroke(gama);
                                    col6_1.setStroke(gama);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Gamaliel y Sebas");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Gamaliel y Sebas");
                                return -1;
                            }
                        }else {
                            info.setText("Ruta no disponible para enlace Gamaliel y Sebas");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Gamaliel y Sebas");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Gamaliel y Sebas");
                    return -1;
                }
            }
            case "Raul" -> {
                if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(3)) {
                        if (rutasRouterCol3.get(2)) {
                            if (rutasRouterCol4.get(1)) {
                                if (rutasRouterCol5.get(0)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(3, false);
                                    rutasRouterCol3.set(2, false);
                                    rutasRouterCol4.set(1, false);
                                    rutasRouterCol5.set(0, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 0 || p == 2) routeGam[p] = 2;
                                        else if (p == 1) routeGam[p] = 3;
                                        else if (p == 3) routeGam[p] = 1;
                                        else routeGam[p] = 0;
                                    }

                                    col1_6.setStroke(gama);
                                    col2_6.setStroke(gama);
                                    col3_7.setStroke(gama);
                                    col4_5.setStroke(gama);
                                    col5_2.setStroke(gama);
                                    col6_2.setStroke(gama);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Gamaliel y Raul");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Gamaliel y Raul");
                                return -1;
                            }
                        }else {
                            info.setText("Ruta no disponible para enlace Gamaliel y Raul");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Gamaliel y Raul");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Gamaliel y Raul");
                    return -1;
                }
            }
            case "Rossi" -> {
                if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(3)) {
                        if (rutasRouterCol3.get(3)) {
                            if (rutasRouterCol4.get(2)) {
                                if (rutasRouterCol5.get(1)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(3, false);
                                    rutasRouterCol3.set(3, false);
                                    rutasRouterCol4.set(2, false);
                                    rutasRouterCol5.set(1, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 0 || p == 3) routeGam[p] = 2;
                                        else if (p == 1 || p == 2) routeGam[p] = 3;
                                        else routeGam[p] = 1;
                                    }

                                    col1_6.setStroke(gama);
                                    col2_6.setStroke(gama);
                                    col3_8.setStroke(gama);
                                    col4_7.setStroke(gama);
                                    col5_4.setStroke(gama);
                                    col6_4.setStroke(gama);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Gamaliel y Rossi");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Gamaliel y Rossi");
                                return -1;
                            }
                        }else {
                            info.setText("Ruta no disponible para enlace Gamaliel y Rossi");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Gamaliel y Rossi");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Gamaliel y Rossi");
                    return -1;
                }
            }
            case "Diego" -> {
                if (rutasRouterCol1.get(2)) {
                    if (rutasRouterCol2.get(3)) {
                        if (rutasRouterCol3.get(3)) {
                            if (rutasRouterCol4.get(3)) {
                                if (rutasRouterCol5.get(2)) {
                                    rutasRouterCol1.set(2, false);
                                    rutasRouterCol2.set(3, false);
                                    rutasRouterCol3.set(3, false);
                                    rutasRouterCol4.set(3, false);
                                    rutasRouterCol5.set(2, false);

                                    for (int p = 0; p < 5; ++p) {
                                        if (p == 0 || p == 4) routeGam[p] = 2;
                                        else routeGam[p] = 3;
                                    }

                                    col1_6.setStroke(gama);
                                    col2_6.setStroke(gama);
                                    col3_8.setStroke(gama);
                                    col4_8.setStroke(gama);
                                    col5_6.setStroke(gama);
                                    col6_6.setStroke(gama);
                                    return 0;
                                } else {
                                    info.setText("Ruta no disponible para enlace Gamaliel y Diego");
                                    return -1;
                                }
                            } else {
                                info.setText("Ruta no disponible para enlace Gamaliel y Diego");
                                return -1;
                            }
                        }else {
                            info.setText("Ruta no disponible para enlace Gamaliel y Diego");
                            return -1;
                        }
                    } else {
                        info.setText("Ruta no disponible para enlace Gamaliel y Diego");
                        return -1;
                    }
                } else {
                    info.setText("Ruta no disponible para enlace Gamaliel y Diego");
                    return -1;
                }
            }
            default -> {
                return -1;
            }
        }
    }

    /**
     * Colorea al default la ruta liberada
     * @param usuario1 String con el usuario1 a liberar
     */
    private void limpiarRuta(String usuario1) {
        switch (usuario1) {
            case "Jorge" -> {
                for (int i = 0; i < routeJor.length; i++) { // Libera los nodos Router usados
                    if (routeJor[i] != -1) {
                        switch (i) {
                            case 0 -> rutasRouterCol1.set(routeJor[i], true);
                            case 1 -> rutasRouterCol2.set(routeJor[i], true);
                            case 2 -> rutasRouterCol3.set(routeJor[i], true);
                            case 3 -> rutasRouterCol4.set(routeJor[i], true);
                            case 4 -> rutasRouterCol5.set(routeJor[i], true);
                        }
                    }
                }

                // CAMBIA COLOR LINEAS AL DEFAULT
                for (Line l : lineasAll) {
                    if (l.getStroke().equals(jorge)) l.setStroke(Paint.valueOf(def)); // Cambia color linea
                }
            }
            case "Oscar" -> {
                for (int i = 0; i < routeOsc.length; i++) { // Libera los nodos Router usados
                    if (routeOsc[i] != -1) {
                        switch (i) {
                            case 0 -> rutasRouterCol1.set(routeOsc[i], true);
                            case 1 -> rutasRouterCol2.set(routeOsc[i], true);
                            case 2 -> rutasRouterCol3.set(routeOsc[i], true);
                            case 3 -> rutasRouterCol4.set(routeOsc[i], true);
                            case 4 -> rutasRouterCol5.set(routeOsc[i], true);
                        }
                    }
                }

                // CAMBIA COLOR LINEAS AL DEFAULT
                for (Line l : lineasAll) {
                    if (l.getStroke().equals(oscar)) l.setStroke(Paint.valueOf(def));
                }
            }
            case "Christian" -> {
                for (int i = 0; i < routeChr.length; i++) { // Libera los nodos Router usados
                    if (routeChr[i] != -1) {
                        switch (i) {
                            case 0 -> rutasRouterCol1.set(routeChr[i], true);
                            case 1 -> rutasRouterCol2.set(routeChr[i], true);
                            case 2 -> rutasRouterCol3.set(routeChr[i], true);
                            case 3 -> rutasRouterCol4.set(routeChr[i], true);
                            case 4 -> rutasRouterCol5.set(routeChr[i], true);
                        }
                    }
                }

                // CAMBIA COLOR LINEAS AL DEFAULT
                for (Line l : lineasAll) {
                    if (l.getStroke().equals(chris)) l.setStroke(Paint.valueOf(def));
                }
            }
            case "Gamaliel" -> {
                for (int i = 0; i < routeGam.length; i++) { // Libera los nodos Router usados
                    if (routeGam[i] != -1) {
                        switch (i) {
                            case 0 -> rutasRouterCol1.set(routeGam[i], true);
                            case 1 -> rutasRouterCol2.set(routeGam[i], true);
                            case 2 -> rutasRouterCol3.set(routeGam[i], true);
                            case 3 -> rutasRouterCol4.set(routeGam[i], true);
                            case 4 -> rutasRouterCol5.set(routeGam[i], true);
                        }
                    }
                }

                // CAMBIA COLOR LINEAS AL DEFAULT
                for (Line l : lineasAll) {
                    if (l.getStroke().equals(gama)) l.setStroke(Paint.valueOf(def));
                }
            }
            default -> {
                System.out.println("Ningun usuario a despintar");
            }
        }
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

        // RUTAs
        rutasRouterCol1 = new ArrayList<>(Arrays.asList(routerCol1_1,routerCol1_2,routerCol1_3,vacio1));
        rutasRouterCol2 = new ArrayList<>(Arrays.asList(routerCol2_1,routerCol2_2,routerCol2_3,routerCol2_4));
        rutasRouterCol3 = new ArrayList<>(Arrays.asList(routerCol3_1,routerCol3_2,routerCol3_3,routerCol3_4));
        rutasRouterCol4 = new ArrayList<>(Arrays.asList(routerCol4_1,routerCol4_2,routerCol4_3,routerCol4_4));
        rutasRouterCol5 = new ArrayList<>(Arrays.asList(routerCol5_1,routerCol5_2,routerCol5_3,vacio2));

        routeJor = new int[]{-1, -1, -1, -1, -1};
        routeOsc = new int[]{-1, -1, -1, -1, -1};
        routeChr = new int[]{-1, -1, -1, -1, -1};
        routeGam = new int[]{-1, -1, -1, -1, -1};

        // LINEAS DE CADA USER 1
        lineasAll = new ArrayList<>(Arrays.asList(
                col1_1,col1_2,col1_3,col1_4,col1_5,col1_6,
                col2_1,col2_2,col2_3,col2_4,col2_5,col2_6,
                col3_1,col3_2,col3_3,col3_4,col3_5,col3_6,col3_7,col3_8,
                col4_1,col4_2,col4_3,col4_4,col4_5,col4_6,col4_7,col4_8,
                col5_1,col5_2,col5_3,col5_4,col5_5,col5_6,
                col6_1,col6_2,col6_3,col6_4,col6_5,col6_6));

        // INICIALIZANDO COMBOBOXES
        users1.getItems().removeAll(users1.getItems());
        users1.getItems().addAll("Jorge","Oscar","Christian","Gamaliel");
        users1.getSelectionModel().select("Usuario 1");

        users2.getItems().removeAll(users2.getItems());
        users2.getItems().addAll("Sebas","Raul","Rossi","Diego");
        users2.getSelectionModel().select("Usuario 2");
    }
}