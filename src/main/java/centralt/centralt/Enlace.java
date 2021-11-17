package centralt.centralt;

import javafx.util.Pair;

import java.util.Date;

public class Enlace {
    private final long start;
    private final int numLink;
    private final Pair<String, String> involucrados;

    Enlace(String usr1, String usr2, int numLink) {
        start = System.currentTimeMillis();
        involucrados = new Pair<>(usr1, usr2);
        this.numLink = numLink;
    }

    public Date finalizarTimer() {
        long end = System.currentTimeMillis() - start;
        return new Date(end);
    }

    public Pair<String, String> getInvolucrados() {
        return involucrados;
    }

    public int getNumLink() {
        return numLink;
    }
}
