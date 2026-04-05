package prog2.model;


import java.io.Serializable;
import java.util.ArrayList;
import prog2.vista.ExcepcioCamping;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    /**
     * Atribut privat (arraylist)
     */
    private ArrayList<Allotjament> allotjaments;

    /**
     * Constructor de LlistaAllotjaments
     */
    public LlistaAllotjaments() {
        allotjaments = new ArrayList<>();
    }


    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     *
     * @param allotjament Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

        if (allotjament == null) {
            throw new ExcepcioCamping("No es pot afegir l'allotjament ");
        }

        if (contains(allotjament)) {
            throw new ExcepcioCamping("L'allotjament ja existeix.");
        }

        allotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        allotjaments.clear();
    }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String resultat = "";



        for (Allotjament a : allotjaments) {
            // Aquest if ens permet mostrar tots si l'estat és tots i així podem complir la primera opció del menu
            if (estat.equalsIgnoreCase("Tots")) {
                resultat += a.toString() + "\n";
            }
            // Filtrem els allotjaments segons si és operatiu o no
            else {
                boolean operatiuBuscat = estat.equalsIgnoreCase("Operatiu"); // Si posen operatiu, l'estat és true, sino no ho és
                if (a.isOperatiu() == operatiuBuscat) {
                    resultat += a.toString() + "\n";
                }
            }
        }

        if (resultat.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments en l'estat indicat.");
        }

        return resultat;

    }


    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     *
     * @return boolean
     */
    @Override
    public boolean containsAllotjamentOperatiu() {

        for (Allotjament a : allotjaments) {
            if (a.isOperatiu()) {
                return true;
            }
        }
        return false;

    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     *
     * @param allotjament
     *
     * @return boolean
     */
    @Override
    public boolean contains(Allotjament allotjament) {

        if (allotjament == null) {return false;}

        for (Allotjament a : allotjaments) {
            if (a.getId().equals(allotjament.getId())) {
                return true;
            }
        }
        return false;

    }

    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     *
     * @param id String amb el id de l'allotjament
     * @return Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {

        for (Allotjament a : allotjaments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        throw new ExcepcioCamping("No existeix cap allotjament amb aquest id.");
    }

}
