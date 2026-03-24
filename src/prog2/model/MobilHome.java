package prog2.model;

public class MobilHome extends Casa {
    // Atributs MobilHome
    private boolean terrassaBarbacoa;

    // Constructor
    public MobilHome (String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom_, idAllotjament_, 5L, 3L, mida, habitacions, placesPersones);

        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Getters i Setters
    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }

    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Mètode concret d'objecte: correcteFuncionament()

    /**
     * Mètode que comprova el correcte funcionament de MobilHome
     * @return isCorrecte (true/false)
     */
    @Override
    public boolean correcteFuncionament() {
        boolean isCorrecte = false;  // Inicialitzem una variable en fals

        if (terrassaBarbacoa) {  // Comprovació
            isCorrecte = true;
        }

        return isCorrecte;
    }

    /**
     * Mètode toString per mostrar informació de les classes pares i de MobilHome
     * @return String amb la informació de l'allotjament en concret
     */
    @Override
    public String toString() {
        return super.toString() + " Mobil-Home {terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}
