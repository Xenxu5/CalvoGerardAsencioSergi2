package prog2.model;

public class Bungalow extends Casa{
    // Atributs
    private int placesParquing;
    private boolean terrassa, tv, aireFred;

    // Constructor
    public Bungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        super(nom_, idAllotjament_, 7L, 4L, mida, habitacions, placesPersones);

        setPlacesParquing(placesParquing);  // Utilitzem el set peer controlar així els valors possibles de placesParquing
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    // Getters i setters
    public int getPlacesParquing() { return placesParquing; }

    public void setPlacesParquing(int placesParquing) {
        // Les places de parquing han de ser dos com a màxim i una com a mínim
        switch (placesParquing) {
            case 2:
                this.placesParquing = placesParquing;
                break;
            case 1:
                this.placesParquing = placesParquing;
                break;
            default:
                System.out.println("El nùmero de places de parquing '" + placesParquing + "' no és vàlid.\nAssignació d'una plaça de parquing per defecte.");
                this.placesParquing = 1;
                break;
        }
    }

    public boolean isTerrassa() { return terrassa; }

    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTv() { return tv; }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isAireFred() { return aireFred; }

    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    // Mètode concret d'objecte: correcteFuncionament()

    /**
     * Mètode que comprova el correcte funcionament de bungalow
     * @return isCorrecte -> true o false (funciona correctament o no)
     */
    @Override
    public boolean correcteFuncionament() {
        boolean isCorrecte = false; // Inicialitzem en fals
        if (aireFred) {  // Comprovació
            isCorrecte = true;
        }

        return isCorrecte;
    }

    /**
     * Mètode toString per mostrar informació de les classes pares i de Bungalow
     * @return String amb la informació de l'allotjament en concret
     */
    @Override
    public String toString() {
        return super.toString() + " Bungalow {placesParquing=" + placesParquing + ", terrasa=" + terrassa + ", tv=" + tv + ", aireFred=" + aireFred + "}";
    }
}
