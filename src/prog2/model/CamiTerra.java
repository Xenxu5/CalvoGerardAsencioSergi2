package prog2.model;

public class CamiTerra extends AccesTerra {

    /**
     * Constructor de Cami de terra
     */
    public CamiTerra(String nom, boolean estat, int longitud) {
        super(nom, estat, longitud);
    }

    /**
     * @return que no te acces amb el cotxe
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}

