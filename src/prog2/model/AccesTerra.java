package prog2.model;

public abstract class AccesTerra extends Acces {
    /**
     * Atribut privat de la longitud
     */
    private int longitud;

    /**
     * Constructor d'acces terra
     */
    public AccesTerra(String nom, boolean estat, int longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Getter i setter de la lontigut
     */
    public int getLongitud() {return longitud;}

    public void setLongitud(int longitud) {this.longitud = longitud;}

    /**
     * @return la longitud del cami
     */
    @Override
    public String toString() {
        return super.toString() + ", longitud:" + longitud + " m";
    }
}
