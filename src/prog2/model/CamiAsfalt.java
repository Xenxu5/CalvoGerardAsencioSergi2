package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    /**
     * Constructor de Cami Asfalt
     */
    public CamiAsfalt(String nom, boolean estat, int metresAsfalt) {
        super(nom, estat, metresAsfalt);
    }

    /**
     * @return que no te acces amb el cotxe
     */
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
