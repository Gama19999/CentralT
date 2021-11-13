package centralt.centralt;

import javafx.scene.control.Label;

public class Operaciones {


    public void Tiempo(Label timer, boolean flag)
    {
        int minutos=0;
        int segundos=0;
        int horas=0;
        Double c1=0.0;
        Double c2=0.0;
        Double costo=0.0;

        for(horas=0;horas<60;horas++) {
            for (minutos = 0; minutos < 60; minutos++) {
                for (segundos = 0; segundos < 60; segundos++) {
                    if (minutos>0 || segundos>0)
                    {
                        c1=minutos*1.50;
                        c2=segundos*0.025;
                        costo=c1+c2;
                    }
                    if(flag) {
                        timer.setText("Tiempo: " + horas + ":" + minutos + ":" + segundos + " |costo llamada: $ " + String.format("%.3f", costo));
                        retraso();
                    }
                }
            }
        }
    }

    public static void retraso()
    {
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e){System.out.println("error");}
    }
}
