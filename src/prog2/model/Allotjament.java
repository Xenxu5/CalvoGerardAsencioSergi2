package prog2.model;

import java.io.Serializable;

public abstract class Allotjament implements InAllotjament, Serializable {

    /**
     * Atributs privats
     */
    //Ja existents
    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;
    // Nous
    private boolean operatiu;
    private String iluminacio;


    /**
     * Constructor de allotjament
     */
    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa,
                       boolean operatiu, String iluminacio) {
        //Ja existents
        this.nom = nom;
        this.id = id;
        setEstadaMinima(estadaMinimaAlta, estadaMinimaBaixa);
        // Nou
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;

    }


    /**
     * Getters i setters de nom i de id del allotjament
     */
    @Override
    public String getNom() {return nom;}

    @Override
    public void setNom(String nom) {this.nom = nom;}

    @Override
    public String getId() {return id;}

    @Override
    public void setId(String id) {this.id = id;}


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

    /* Estat del allotjament **/

    /**
     * @return si es operatiu o no
     */
    public boolean isOperatiu() {
        return operatiu;
    }

    public String getIluminacio() {
        return iluminacio;
    }


    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     *
     * @param tasca Objecte de tipus TascaManteniment.
     */
    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
        operatiu = false;
        iluminacio = tasca.getIluminacioAllotjament();
    }

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    @Override
    public void obrirAllotjament() {
        operatiu = true;
        iluminacio = "100%";
    }

    /**
     * Mètode per mostrar informació de l'allotjament i ser aprofitat en cada subclasse d'aquest
     * @return String amb la informació de l'allotjament
     */
    @Override
    public String toString() {
        // Mètode que es cridarà en les subclasses ja que aquestes variables les tenen totes les subclasses

        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: "
                + estadaMinimaAlta + ", estada mínima en temp BAIXA: " + estadaMinimaBaixa +
                ", operatiu=" + operatiu + ", iluminacio=" + iluminacio + ".";
    }
}


