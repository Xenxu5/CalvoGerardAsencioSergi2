package prog2.model;

public class BungalowPremium extends Bungalow{
    // Atributs
    private boolean serveisExtra;
    private String codiWifi;

    // Constructor
    public BungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);

        this.serveisExtra = serveisExtra;
        this.codiWifi  = codiWifi;
    }

    // Getters i setters
    public boolean isServeisExtra() { return serveisExtra; }

    public void setServeisExtra(boolean serveisExtra) {
        this.serveisExtra = serveisExtra;
    }

    public String getCodiWifi() { return codiWifi; }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    // Mètode concret d'objecte: correcteFuncionament()

    /**
     * Mètode que comprova el correcte funcionament de bungalow premium
     * @return isCorrecte (true/false)
     */
    @Override
    public boolean correcteFuncionament() {
        boolean isCorrecte = false;
        // Condició de bungalow (aire fred) i codiWifi entre 8 i 16 caràcters
        if(super.correcteFuncionament() && codiWifi.length() >= 8 && codiWifi.length() <= 16) {
            isCorrecte = true;
        }

        return isCorrecte;
    }

    /**
     * Mètode toString per mostrar informació de les classes pares i de BungalowPremium
     * @return String amb la informació de l'allotjament en concret
     */
    @Override
    public String toString() {
        return super.toString() + " BungalowPremium {serveisExtra=" + serveisExtra + ",codiWifi=" + codiWifi + "}";
    }
}
