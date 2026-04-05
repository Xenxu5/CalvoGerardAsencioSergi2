package prog2.model;

public abstract class AccesAsfalt extends Acces{
    /**
     * Atribut privat dels metres d'asfalt
     */
    private float metresAsfalt;

    /**
     * Constructor d'acces asfalt
     */
    public AccesAsfalt(String nom, boolean estat, float metresAsfalt) {
        super(nom, estat);
        this.metresAsfalt = metresAsfalt;
    }

    /**
     * Getter i setter dels metres d'asfalt
     */
    public float getMetresAsfalt() {
        return metresAsfalt;
    }

    public void setMetresAsfalt(int metresAsfalt) {
        this.metresAsfalt = metresAsfalt;
    }

    /**
     * @return els metres que té d'asfalt
     */
    @Override
    public String toString() {
        return super.toString() + ", metres asfalt:" + metresAsfalt + "m²";
    }
}

