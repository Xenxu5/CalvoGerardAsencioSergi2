package prog2.model;

public class Parcela extends Allotjament{
    // Atributs de parcela
    private float metres;
    private boolean connexioElectrica;

    // Constructor
    public Parcela (String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        // Cridem al constructor pare (Allotjament) amb "super"
        super(nom_, idAllotjament_, 4L, 2L); // Com els dies són constants en parceles diferents, passem el valor tal qual

        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    // Getters i setters
    public float getMetres() { return metres; }

    public void setMetres(float metres) {
        this.metres = metres;
    }

    public boolean isConnexioElectrica() { return connexioElectrica; }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }

    // Mètode obligatori de les subclasses no abstractes per comprovar el seu correcte funcionament
    /**
     * Comprova si l'allotjament funciona correctament.
     * La implementació dependrà dels criteris específics de cada tipus d'allotjament.
     *
     * @return true si l'allotjament funciona correctament, false altrament.
     */
    @Override
    public boolean correcteFuncionament() {
        // Si hi ha connexió elèctrica, el funcionament és correcte, si no, no ho és
        boolean isCorrecte = false;

        if (connexioElectrica) {  // Comprovació
            isCorrecte = true;
        }

        return isCorrecte;
    }

    // Mètode toString() amb ampliació de les variables de la subclasse parcela

    /**
     * Mètode toString per mostrar informació de les classes pares i de Parcela
     * @return String amb la informació de l'allotjament en concret
     */
    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + metres + ", connexioElectrica=" + connexioElectrica + "}";
    }
}
