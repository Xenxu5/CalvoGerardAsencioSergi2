package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {

    /**
     * Atribut privat (Arraylist)
     */
    private ArrayList<TascaManteniment> tasques;

    /**
     * Constructor de LlistaTasquesManteniment
     */
    public LlistaTasquesManteniment() { tasques = new ArrayList<>(); }


    /**
     * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
     * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
     *
     * @param num         Número d'identificació de la tasca.
     * @param tipus       Aquest String permet crear el enum TipusTascaManteniment
     * @param allotjament Allotjament on s'afegeix la tasca
     * @param data        Data quan genera la tasca
     * @param dies        Número de dies esperats per completar la tasca
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {

        // Comprovar si l'allotjament ja té una tasca activa
        for (TascaManteniment t : tasques) {
            if (t.getAllotjament().getId().equals(allotjament.getId())) {
                throw new ExcepcioCamping("Aquest allotjament ja té una tasca de manteniment activa.");
            }
        }

        // Comprovació del String tipus
        TascaManteniment.TipusTascaManteniment tipusEnum = null;
        boolean tipusTrobat = false;

        for (TascaManteniment.TipusTascaManteniment t : TascaManteniment.TipusTascaManteniment.values()) {
            // Si és un valor del enum, el tipus està bé
            if (t.name().equalsIgnoreCase(tipus)) {
                tipusEnum = t;
                tipusTrobat = true;
                break; // Si el trobem, parem de buscar
            }
        }

        if (!tipusTrobat) {
            throw new ExcepcioCamping("El tipus de tasca que es vol afegir no existeix.");
        }

        // Creem i afegim la tasca
        TascaManteniment novaTasca = new TascaManteniment(num, tipusEnum, allotjament, data, dies);
        tasques.add(novaTasca);

        // Actualitzar estat
        allotjament.tancarAllotjament(novaTasca);
    }

    /**
     * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     *
     * @param tasca Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {

        if (tasca == null) {
            throw new ExcepcioCamping("La tasca indicada no és vàlida.");
        }

        if (!tasques.contains(tasca)) {
            throw new ExcepcioCamping("La tasca indicada no existeix.");
        }

        // Tornem a obrir l'allotjament abans d'eliminar la tasca
        tasca.getAllotjament().obrirAllotjament();

        // Eliminem la tasca de la llista
        tasques.remove(tasca);
    }


    /**
     * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
     * En cas que no hi hagi cap tasca llança una excepció.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {

        String resultat = "";
        for (TascaManteniment t : tasques) { // Com no hi ha condició d'estat, els mostrem tots
            resultat += t.toString() + "\n";
        }

        if (resultat.isEmpty()) {
            throw new ExcepcioCamping("No hi ha tasques de manteniment a la llista.");
        }

        return resultat;
    }

    /**
     * Busca la tasca amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     *
     * @param num Número d'identificació de la tasca.
     * @return Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
     */
    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {

        for (TascaManteniment t : tasques) {
            if (t.getNum() == num) {
                return t;
            }
        }
        throw new ExcepcioCamping("No existeix cap tasca amb el número passat per paràmetre.");
    }
}
