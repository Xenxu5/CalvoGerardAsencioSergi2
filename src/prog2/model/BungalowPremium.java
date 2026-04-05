package prog2.model;

public class BungalowPremium extends Bungalow{
    // Atributs
    private boolean serveisExtra;
    private String codiWifi;

    // Constructor
    public BungalowPremium(String nom_, String idAllotjament_, boolean operatiu, String iluminacio,
                           float mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa,
                           boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {

        super(nom_, idAllotjament_, operatiu, iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);

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


    /**
     * Mètode toString per mostrar informació de les classes pares i de BungalowPremium
     * @return String amb la informació de l'allotjament en concret
     */
    @Override
    public String toString() {
        return super.toString() + " BungalowPremium {serveisExtra=" + serveisExtra + ",codiWifi=" + codiWifi + "}";
    }
}
