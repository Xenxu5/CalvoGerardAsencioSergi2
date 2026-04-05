package prog2.model;

public class Glamping extends Casa {
    // Atributs Glamping
    private boolean casaMascota;
    private String material;

    // Constructor
    public Glamping(String nom_, String idAllotjament_, boolean operatiu, String iluminacio,
                    float mida, int habitacions, int placesPersones, String material, boolean casaMascota) {

        super(nom_, idAllotjament_, operatiu, iluminacio, 3L, 3L,
                mida, habitacions, placesPersones);

        this.casaMascota = casaMascota;
        setMaterial(material);  // Utilitzem setMaterial per controlar el valor de l'atribut material
    }

    // Getters i setters

    public boolean isCasaMascota() { return casaMascota; }

    public void setCasaMascota( boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    public String getMaterial() { return material; }

    public void setMaterial(String material) {
        switch (material.toLowerCase()) { // Assegurem amb un switch que el material sigui fusta o tela
            case "fusta":
                this.material = material;
                break;
            case "tela":
                this.material = material;
                break;
            default: // Per defecte, donem fusta
                this.material = "fusta";
                break;
        }
    }


    /**
     * Mètode toString per mostrar informació de les classes pares i de Glamping
     * @return String amb la informació de l'allotjament en concret
     */
    @Override
    public String toString() {
        return super.toString() + " Glamping {casaMascota=" + casaMascota + ", material=" + material + "}";
    }


}
