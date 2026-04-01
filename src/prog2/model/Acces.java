package prog2.model;

public abstract class Acces implements InAcces{
    /**
     * Atributs privats
     */
    private String nom;
    private boolean estat;
    private LlistaAllotjaments aAllotjaments;

    /**
     * Constructor d'acces
     */

    public Acces (String nom, boolean estat){
        this.nom = nom;
        this.estat= estat;
        this.aAllotjaments = new LlistaAllotjaments();
    }


    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        if (allotjament != null) {
            aAllotjaments.afegirAllotjament(allotjament);
        }
    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() {
        this.estat =false;
    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() {
        this.estat =true;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return
     */
    @Override
    public abstract boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     *
     * @return
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return
     */
    @Override
    public boolean getEstat() {
        return estat;
    }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return aAllotjaments;
    }
}
