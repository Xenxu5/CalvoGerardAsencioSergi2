package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public class Camping implements InCamping, Serializable {

    /**
     * Atributs privats
     */
    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;

    /**
     * Constructor Camping
     */
    public Camping(String nom) {
        this.nom = nom;
        llistaAllotjaments = new LlistaAllotjaments();
        llistaAccessos = new LlistaAccessos();
        llistaTasquesManteniment = new LlistaTasquesManteniment();
    }

    // Getter

    /**
     * Retorna el nom del camping
     *
     * @return
     */
    @Override
    public String getNomCamping() {
        return nom;
    }

    // Mètodes llistar

    /**
     * Retorna informació dels allotjaments de la llista segons l'estat (operatiu o no operatiu)
     *
     * @param estat Estat dels allotjaments a llistar. (Operatiu, No Operatiu)
     * @return
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Retorna informació dels accessos de la llista segons l'estat (obert o tancat)
     *
     * @param infoEstat Estat dels accessos a llistar. (Obert, Tancat)
     * @return
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        // El paràmetre és un String ("Obert" o "Tancat")
        // però la nostra llista necessita un boolean
        boolean estatBool = infoEstat.equalsIgnoreCase("Obert");
        return llistaAccessos.llistarAccessos(estatBool);
    }

    /**
     * Retorna informació de les tasques de manteniment de la llista
     *
     * @return
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    // Mètodes de les tasques

    /**
     * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
     *
     * @param numTasca      Número identificador de la tasca.
     * @param tipus         Tipus de tasca (en format string)
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data          Data en què s'ha registrat la tasca.
     * @param dies          Número esperat de dies per completar la tasca
     * @throws ExcepcioCamping
     */
    @Override
    public void afegirTascaManteniment(int numTasca, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {

        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasquesManteniment.afegirTascaManteniment(numTasca, tipus, allotjament, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Completa la tasca de manteniment identificada amb el número passat per paràmetre
     *
     * @param numTasca Número identificador de la tasca a completar.
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(int numTasca) throws ExcepcioCamping {

        TascaManteniment tasca = llistaTasquesManteniment.getTascaManteniment(numTasca);
        llistaTasquesManteniment.completarTascaManteniment(tasca);
        llistaAccessos.actualitzaEstatAccessos();
    }

    // Mètodes de càlcul

    /**
     * Retorna el nombre d'accessos no accessibles amb vehicle
     *
     * @return
     */
    @Override
    public int calculaAccessosNoAccessibles() {
        return llistaAccessos.calculaAccessosNoAccessibles();
    }

    /**
     * Retorna el nombre total de metres de terra
     *
     * @return
     */
    @Override
    public float calculaMetresTerra() {
        return llistaAccessos.calculaMetresTerra();
    }

    // Mètodes de fitxers

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        try {
            File fitxer = new File(camiDesti);
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(this);

            oos.close();
            fout.close();
        } catch (IOException e) {
            throw new ExcepcioCamping("Error en guardar el fitxer: " + e.getMessage());
        }
    }

    /**
     * Carrega l'estat d'un càmping des d'un fitxer.
     *
     * @param camiOrigen
     * @return
     * @throws ExcepcioCamping
     */
    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        try {
            File fitxer = new File(camiOrigen);
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);

            Camping campingCarregat = (Camping) ois.readObject();

            ois.close();
            fin.close();

            return campingCarregat;
        } catch (IOException | ClassNotFoundException e) {
            throw new ExcepcioCamping("Error en carregar el fitxer: " + e.getMessage());
        }
    }

    // Mètode inicialització

    /**
     * Mètode que inicialitza dades
     */
    @Override
    public void inicialitzaDadesCamping() {
        // Utilitzem try/catch ja que a la interface no utilitza throw a la capçalera i com utilitzem mètodes que poden llençar excepcions, hem d'utilitzar try-catch
        try {
            llistaAccessos.buidar();

            float asfalt = 200;
            Acces Acc1 = new CamiAsfalt("A1", true, asfalt);
            llistaAccessos.afegirAcces(Acc1);

            asfalt = 800;
            float pesMaxim = 10000;
            Acces Acc2 = new CarreteraAsfalt("A2", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc2);

            float longitud = 100;
            Acces Acc3 = new CamiTerra("A3", true, longitud);
            llistaAccessos.afegirAcces(Acc3);

            longitud = 200;
            float amplada = 3;
            Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc4);

            asfalt = 350;
            Acces Acc5 = new CamiAsfalt("A5", true, asfalt);
            llistaAccessos.afegirAcces(Acc5);

            asfalt = 800;
            pesMaxim = 12000;
            Acces Acc6 = new CarreteraAsfalt("A6", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc6);

            asfalt = 100;
            Acces Acc7 = new CamiAsfalt("A7", true, asfalt);
            llistaAccessos.afegirAcces(Acc7);

            asfalt = 800;
            pesMaxim = 10000;
            Acces Acc8 = new CarreteraAsfalt("A8", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc8);

            longitud = 50;
            Acces Acc9 = new CamiTerra("A9", true, longitud);
            llistaAccessos.afegirAcces(Acc9);

            longitud = 400;
            amplada = 4;
            Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc10);

            longitud = 80;
            Acces Acc11 = new CamiTerra("A11", true, longitud);
            llistaAccessos.afegirAcces(Acc11);

            longitud = 800;
            amplada = 5;
            Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc12);


            /* Pistes */
            llistaAllotjaments.buidar();


            // Afegir parcel·les:
            //------------------------------

            String nom = "Parcel·la Nord";
            String idAllotjament = "ALL1";
            float mida = 64.0f;
            boolean connexioElectrica = true;

            Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            llistaAllotjaments.afegirAllotjament(ALL1);

            nom = "Parcel·la Sud";
            idAllotjament = "ALL2";

            Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            llistaAllotjaments.afegirAllotjament(ALL2);

            // Afegir bungalows:
            //------------------------------

            nom = "Bungalow Nord";
            idAllotjament = "ALL3";
            mida = 22f;
            int habitacions = 2;
            int placesPersones = 4;
            int placesParquing = 1;
            boolean terrassa = true;
            boolean tv = true;
            boolean aireFred = true;

            Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            llistaAllotjaments.afegirAllotjament(ALL3);


            // Afegir bungalows premium:
            //------------------------------
            nom = "Bungallow Sud";
            idAllotjament = "ALL4";
            mida = 27f;
            habitacions = 2;
            placesPersones = 6;
            placesParquing = 1;
            terrassa = true;
            tv = true;
            aireFred = true;
            boolean serveisExtra = true;
            String codiWifi = "CampingDelMarBP1";

            BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            llistaAllotjaments.afegirAllotjament(ALL4);

            // Afegir Glamping:
            //------------------------------

            nom = "Glamping Nord";
            idAllotjament = "ALL5";
            mida = 20f;
            habitacions = 1;
            placesPersones = 2;
            String material = "Tela";
            boolean casaMascota = true;

            Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
            llistaAllotjaments.afegirAllotjament(ALL5);


            // Afegir Mobil-Home:
            //------------------------------

            nom = "Mobil-Home Sud";
            idAllotjament = "ALL6";
            mida = 20f;
            habitacions = 2;
            placesPersones = 4;
            boolean terrassaBarbacoa = true;

            MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
            llistaAllotjaments.afegirAllotjament(ALL6);

            /* Accés */
            Acc1.afegirAllotjament(ALL1);
            Acc1.afegirAllotjament(ALL2);
            Acc2.afegirAllotjament(ALL1);
            Acc2.afegirAllotjament(ALL2);
            Acc3.afegirAllotjament(ALL3);
            Acc4.afegirAllotjament(ALL3);
            Acc5.afegirAllotjament(ALL4);
            Acc6.afegirAllotjament(ALL4);
            Acc7.afegirAllotjament(ALL5);
            Acc7.afegirAllotjament(ALL6);
            Acc8.afegirAllotjament(ALL5);
            Acc8.afegirAllotjament(ALL6);
            Acc9.afegirAllotjament(ALL2);
            Acc10.afegirAllotjament(ALL2);
            Acc11.afegirAllotjament(ALL6);
            Acc12.afegirAllotjament(ALL6);
        } catch (ExcepcioCamping e) {
            System.out.println("Error inesperat carregant les dades inicials: " + e.getMessage());
        }
    }
}



