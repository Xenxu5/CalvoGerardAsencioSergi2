package prog2.model;

public abstract class Casa extends Allotjament {
    // Atributs de casa
    private String mida;
    private int habitacions, placesPersones;

    // Constructor
    // Hem d'afegir estadaMinimaAlta i baixa perquè casa és un intermediari i depenent del tipus de casa, aquestes variables varien
    public Casa (String nom_, String idAllotjament, boolean operatiu, String iluminacio, long estadaMinimaAlta,
                 long estadaMinimaBaixa, String mida, int habitacions, int placesPersones) {

        // Cridem al constructor pare
        super(nom_, idAllotjament, estadaMinimaAlta, estadaMinimaBaixa, operatiu, iluminacio);

        setMida(mida);  // Utilitzem setMida per controlar els valors d'aquest atribut
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    // Getters i setters
    public String getMida() { return mida; }

    public void setMida(String mida) {
        // Utilitzem un switch per assegurar-nos que l'usuari introdueix petita, mitjana o gran
        switch (mida.toLowerCase()) {
            case "petita":
                this.mida = mida;
                break;
            case "mitjana":
                this.mida = mida;
                break;
            case "gran":
                this.mida = mida;
                break;
            default:  // Si no és una opció vàlida, donem mitjana per defecte
                this.mida = "mitjana";
                break;
        }
    }

    public int getHabitacions() { return habitacions; }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public int getPlacesPersones() { return placesPersones; }

    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }

    /**
     * Mètode per mostrar informació de l'allotjament i ser aprofitat en cada subclasse de casa
     * @return String amb la informació de casa
     */
    @Override
    public String toString() {
        return super.toString() + " Casa {mida=" + mida + ", habitacions=" + habitacions + ", placesPersones=" + placesPersones + "}";
    }
}
