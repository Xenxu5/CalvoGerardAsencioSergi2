package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {
    /**
     * Atribut privat del pes maxim
     */
    private float pesMaxim; // en kg

    /**
     * Constructor de carretera d'asfalt
     */
    public CarreteraAsfalt(String nom, boolean estat, float metresAsfalt, float pesMaxim) {
        super(nom, estat, metresAsfalt);
        this.pesMaxim = pesMaxim;
    }

    /**
     * Geter i setter del pes maxim
     */
    public float getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    /**
     * @return es accessible per cotxes
     */
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    /**
     * @return el pes maxim de la carretera d'asfalt
     */
    @Override
    public String toString() {
        return super.toString() + ", pes màxim:" + pesMaxim + " kg";
    }
}