package prog2.model;

public class CarreteraTerra extends AccesTerra {
    /**
     * Atribut privat de l'amplada
     */
    private int amplada; // en metres

    /**
     * Constructor de carretera de terra
     */
    public CarreteraTerra(String nom, boolean estat, int longitud, int amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    /**
     * Geter i setter de l'amplada
     */
    public int getAmplada() {
        return amplada;
    }

    public void setAmplada(int amplada) {
        this.amplada = amplada;
    }

    /**
     * @return es accessible per cotxes
     */
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    /**
     * @return l'amplada de la carretera de terra
     */
    @Override
    public String toString() {
        return super.toString() + ", amplada:" + amplada + " m";
    }
}

