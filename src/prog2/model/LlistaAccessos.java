package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos{

    /**
     * Atribut privat (arraylist)
     */
    private ArrayList<Acces> accessos;

    /**
     * Constructor de LlistaAccesos
     */
    public LlistaAccessos() {
        accessos = new ArrayList<>();
    }



    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     *
     * @param acc Objecte de tipus Acces.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (acc == null) {
            throw new ExcepcioCamping("L'accés no es vàlid.");
        }
        accessos.add(acc);
    }

    /**
     * Buida la llista d'accessos
     */
    @Override
    public void buidar() {
        accessos.clear();
    }

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat boolean
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     *
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String resultat = "";
        for (Acces acces : accessos) {
            if (acces.getEstat() == estat) {
                resultat += acces.toString() + "\n";
            }
        }

        if (resultat.isEmpty()) {
            throw new ExcepcioCamping("No hi ha accessos en l'estat indicat.");
        }

        return resultat;

    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {

        for (Acces acces : accessos) {

            // Primer tanquem l'accés
            acces.tancarAcces();

            // Només s'obre si dona accés a algun allotjament operatiu
            if (acces.getAAllotjaments().containsAllotjamentOperatiu()) {
                acces.obrirAcces();
            }
        }


    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     *
     * @return int
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int comptador = 0;

        for (Acces acces : accessos) {
            if (!acces.isAccessibilitat()) {
                comptador++;
            }
        }

        return comptador;
    }


    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     *
     * @return float amb els metres totals.
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float total = 0;

        for (Acces acces : accessos) {
            if (acces instanceof AccesTerra) {
                AccesTerra terra = (AccesTerra) acces;
                total += terra.getLongitud();
            }
        }

        return total;
    }

}
