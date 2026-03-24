package prog2.model;

public abstract class Allotjament implements InAllotjament {
    // Atributs privats
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    // Constructor
    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        setEstadaMinima(estadaMinimaAlta, estadaMinimaBaixa);
    }

    // Mètodes

    /**
     * Obté el nom de l'allotjament.
     *
     * @return el nom de l'allotjament.
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Estableix el nom de l'allotjament.
     *
     * @param nom el nom a assignar.
     */
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obté l'identificador únic de l'allotjament.
     *
     * @return l'identificador únic de l'allotjament.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Estableix l'identificador únic de l'allotjament.
     *
     * @param id l'identificador a assignar.
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obté l'estada mínima segons la temporada.
     *
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    @Override
    public long getEstadaMinima(Temp temp) {  // Variable temp (valor = alta o baixa) del enum Temp
        // Inicialitzem temp a 0
        long tmp = 0;
        switch (temp) {
            case ALTA:
                tmp = estadaMinimaAlta;  // Assignem el nombre minim de dies segons la temporada
                break;
            case BAIXA:
                tmp = estadaMinimaBaixa; // Assignem el nombre minim de dies segons la temporada
                break;
        }
        return tmp;
    }
    /**
     * Estableix l'estada mínima per a cada temporada.
     *
     * @param estadaMinimaALTA_  l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaAlta = estadaMinimaALTA_;
        this.estadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    // No implementem el mètode de correcteFuncionament() ja que és abstracte i l'implementarem a les subclasses

    // Mètodes extra

    /**
     * Mètode per mostrar informació de l'allotjament i ser aprofitat en cada subclasse d'aquest
     * @return String amb la informació de l'allotjament
     */
    @Override
    public String toString() {
        // Mètode que es cridarà en les subclasses ja que aquestes variables les tenen totes les subclasses

        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaAlta + ", estada mínima en temp BAIXA: " + estadaMinimaBaixa + ".";
    }
}


