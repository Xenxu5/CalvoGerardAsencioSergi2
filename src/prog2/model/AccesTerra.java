package prog2.model;

public abstract class AccesTerra extends Acces {
    /**
     * Atribut privat de la longitud
     */
    private float longitud;

    /**
     * Constructor d'acces terra
     */
    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Getter i setter de la lontigut
     */
    public float getLongitud() {return longitud;}

    public void setLongitud(float longitud) {this.longitud = longitud;}

    /**
     * @return la longitud del cami
     */
    @Override
    public String toString() {
        return super.toString() + ", longitud:" + longitud + " m";
    }
}
