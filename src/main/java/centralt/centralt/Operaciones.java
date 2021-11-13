package centralt.centralt;

import javafx.scene.control.Label;

import java.util.Date;

public class Operaciones {
    private long start;

    public void startTime() {
        start = System.currentTimeMillis();
    }

    public Date calculateSecs(long end) {
        return new Date(end-start);
    }

    public String tiempo(Label timer, boolean flag) {
        int minutos = 0;
        int segundos = 0;
        int horas = 0;
        double c1 = 0.0;
        double c2 = 0.0;
        double costo = 0.0;
        String s = null;

        for(horas=0; horas < 60; horas++) {
            for (minutos = 0; minutos < 60; minutos++) {
                for (segundos = 0; segundos < 60; segundos++) {
                    if (minutos > 0 || segundos > 0) {
                        c1 = minutos*1.50;
                        c2 = segundos*0.025;
                        costo = c1+c2;
                    }

                    if (flag) {
                        retraso();
                    } else break;
                }
            }
        }

        return ("Tiempo: " + horas + ":" + minutos + ":" + segundos + " | Costo llamada: $ " + String.format("%.2f", costo));
    }

    private static void retraso() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){System.out.println("error");}
    }
}
