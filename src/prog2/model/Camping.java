package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping {
    /**
     * Atributs del model camping
     */
    private String nom;
    private ArrayList<Client> llistaClients;
    private ArrayList<Allotjament> llistaAllotjaments;


    /**
     * Constructor que crea un camping e inicialitza les coleccions
     */
    public Camping(String _nom) {
        this.llistaClients = new ArrayList<>();
        this.llistaAllotjaments = new ArrayList<>();

        this.nom = _nom;
    }

    /**
     * Retorna el nom del càmping.
     *
     * @return el nom del càmping.
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retorna la llista d'allotjaments del camping.
     */
    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    /**
     * Retorna la llista de clients del camping.
     *
     * @return
     */
    @Override
    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    /**
     * Retorna el número total d'allotjaments del càmping.
     *
     * @return el número total d'allotjaments.
     */
    @Override
    public int getNumAllotjaments() {
        return llistaAllotjaments.size();
    }

    /**
     * Retorna el número total de clients del càmping.
     *
     * @return el número total de clients.
     */
    @Override
    public int getNumClients() { return llistaClients.size() ; }

    // Mètodes implementats
    /**
     * Cerca els allotjament.
     *
     * @param id el id del allotjament.
     */
    private Allotjament buscarAllotjament(String id) {
        //Inicialitzem un iterator per recorrer la llista
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        //Iterem fins que no hi hagin elements
        while (itr.hasNext()) {
            Allotjament espaiTmp = itr.next();
            //
            if (espaiTmp.getId().equals(id)) {
                return espaiTmp;
            }
        }
        return null;
    }
    /**
     * Cerca els clients.
     *
     * @param dni_ el DNI del client.
     */
    private Client buscarClient(String dni_){
        // Si no hi ha dni no buca res (evitem posibles errorS)
        if (dni_ == null) return null;

        //Inicialitzem un iterator per recorrer la llista
        Iterator<Client> itr = llistaClients.iterator();

        //Iterem fins que no hi hagin elements
        while (itr.hasNext()) {
            Client c = itr.next();
            //Si el dni coincideix retornem el client trobat
            if (dni_.equals(c.getDni())) {
                return c;
            }
        }

        return null;
    }



    /**
     * Crea un nou objecte de tipus Client i l'afegeix a la llista de clients.
     *
     * @param nom_ el nom del nou client.
     * @param dni_ el DNI del nou client.
     */
    @Override
    public void afegirClient(String nom_, String dni_)throws ExcepcioCamping {
        // llença excepció si el dni no és valid
        if (!dniValid(dni_)) {
            throw new ExcepcioCamping("El DNI ha de tenir 9 caràcters: " + dni_);
        }
        //llença excepcio si el dni ja existeix al camping
        if (buscarClient(dni_) != null) {
            throw new ExcepcioCamping("El client amb DNI: " + dni_ + " , ja existeix al càmping.");
        }
        Client nouClie = new Client(nom_, dni_);
        llistaClients.add(nouClie);
    }
    /**
     * Valida el dni
     *
     * @param dni   el dni introduït.
     * @return si es valid o no el dni
     */
    private boolean dniValid(String dni) {
        //si no hay dni o si no tiene 9 caracteres
        return dni != null && dni.length() == 9;
    }

    /**
     * Afegeix una nova parcel·la a la llista d'allotjaments.
     *
     * @param nom_              el nom de la parcela.
     * @param idAllotjament_    l'identificador únic de l'allotjament.
     * @param metres            la mida de la parcela.
     * @param connexioElectrica true si disposa de connexió elèctrica, false altrament.
     */
    @Override
    public  void afegirParcela(String nom_, String idAllotjament_,boolean operatiu, String iluminacio, float metres, boolean connexioElectrica) {
        // Generem objecte
        Parcela parcela = new Parcela (nom_ ,idAllotjament_, operatiu, iluminacio, metres, connexioElectrica);
        // Afegim la parcela a la llista d'allotjaments
        llistaAllotjaments.add(parcela);
    }

    /**
     * Afegeix un nou bungalow a la llista d'allotjaments.
     *
     * @param nom_           el nom del bungalow.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param mida           la mida del bungalow.
     * @param habitacions    el nombre d'habitacions del bungalow.
     * @param placesPersones el nombre màxim de places per a persones.
     * @param placesParquing el nombre de places de pàrquing disponibles.
     * @param terrassa       true si disposa de terrassa, false altrament.
     * @param tv             true si disposa de televisió, false altrament.
     * @param aireFred       true si disposa d'aire condicionat, false altrament.
     */
    @Override
    public void afegirBungalow(String nom_, String idAllotjament_,boolean operatiu, String iluminacio, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        // Generem objecte
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_,operatiu, iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        // Afegim el bungalow a la llista d'allotjaments
        llistaAllotjaments.add(bungalow);
    }

    /**
     * Afegeix un bungalow premium a la llista d'allotjaments.
     *
     * @param nom_
     * @param idAllotjament_
     * @param mida
     * @param habitacions
     * @param placesPersones
     * @param placesParquing
     * @param terrassa
     * @param tv
     * @param aireFred
     * @param serveisExtra   true si ofereix serveis extra.
     * @param codiWifi       el codi de la xarxa Wi-Fi.
     *                       (Altres paràmetres igual que `afegirBungalow`)
     */
    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_,boolean operatiu, String iluminacio, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        // Generem objecte
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_,operatiu, iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        // // Afegim el bungalowPremium a la llista d'allotjaments
        llistaAllotjaments.add(bungalowPremium);
    }

    /**
     * Afegeix una casa glamping a la llista d'allotjaments.
     *
     * @param nom_
     * @param idAllotjament_
     * @param mida
     * @param habitacions
     * @param placesPersones
     * @param material       el material del que està fet.
     * @param casaMascota    true si accepta mascotes.
     *                       (Altres paràmetres igual que `afegirBungalow`)
     */
    @Override
    public void afegirGlamping(String nom_, String idAllotjament_,boolean operatiu, String iluminacio, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        // Generem l'objecte
        Glamping glamping = new Glamping(nom_, idAllotjament_, operatiu, iluminacio, mida, habitacions, placesPersones, material, casaMascota);
        // Afegim el glamping a la llista d'allotjaments
        llistaAllotjaments.add(glamping);
    }

    /**
     * Afegeix una mobil-home a la llista d'allotjaments.
     *
     * @param nom_
     * @param idAllotjament_
     * @param mida
     * @param habitacions
     * @param placesPersones
     * @param terrassaBarbacoa true si disposa de terrassa amb barbacoa.
     *                         (Altres paràmetres igual que `afegirBungalow`)
     */
    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_,boolean operatiu, String iluminacio, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        // Generem l'objecte
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_,operatiu, iluminacio, mida, habitacions, placesPersones, terrassaBarbacoa);
        // Afegim el mobilHome a la llista d'allotjaments
        llistaAllotjaments.add(mobilHome);
    }


    /**
     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius.
     *
     * @return el nombre de serveis operatius.
     */
    @Override
    public int calculAllotjamentsOperatius() {

        int allotjamentsOperatius = 0;  // Inicialitzem la variable amb 0 i la incrementarem amb cada aparició
        // Utilitzem iteradors per recòrrer la llista
        Iterator<Allotjament> itr = llistaAllotjaments.iterator();
        while (itr.hasNext()) {
            Allotjament allotjament = itr.next(); // Agafa un element de la llista. Com no sabem quin és exactament, fem servir la classe Allotjament com a tipus (el pare de tots)
            if (allotjament.correcteFuncionament()) {  // Si l'ajutllament en concret passa el mètode de correcteFuncionament, sumem 1 al valor inicial
                allotjamentsOperatius++; // Incrementem la variable
            }

        }
        return allotjamentsOperatius;
    }


    /**
     * Cerca i retorna l'allotjament amb estada mínima de la temporada alta més curta.
     *
     * @param temp
     * @return l'allotjament amb estada mínima de la temporada baixa més curta.
     */
    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {

        Iterator<Allotjament> itr = llistaAllotjaments.iterator();

        // Si la llista está buida (evitem posibles errors)
        if (!itr.hasNext()) {
            return null;
        }

        // Agafem el primer element
        Allotjament millor = itr.next();
        long minima = millor.getEstadaMinima(temp);

        // Comprovem tots el següents elements
        while (itr.hasNext()) {
            Allotjament a = itr.next();
            long estada = a.getEstadaMinima(temp);
            //es queda amb l'estada més curta
            if (estada < minima) {
                minima = estada;
                millor = a;
            }

        }

        return millor;
    }
    /**
     * Retornarà la temporada corresponent a la data passada com a paràmetre
     *
     * @param data
     * @return la temporada corresponent
     */
    public static InAllotjament.Temp getTemporada(LocalDate data){

        int mes  = data.getMonthValue();   // 1 al 12
        int dia  = data.getDayOfMonth();   // 1 al 31

        // Alta: del 21 de març al 20 de septembre
        boolean enMarzAlta      = (mes == 3  && dia >= 21); //la ç dona error
        boolean entreAbriliAgost = (mes > 3  && mes < 9);
        boolean enSeptembreAlta = (mes == 9  && dia <= 20);

        // Aqui si la data es troba dins dels parametres retorna temporada alta
        if (enMarzAlta || entreAbriliAgost  || enSeptembreAlta) {
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }


    // PARTE NUEVA

    /**
     * Retorna el nom del càmping.
     *
     * @return String
     */
    @Override
    public String getNomCamping() {
        return "";
    }

    /**
     * Llista els allotjaments segons el seu estat.
     *
     * @param estat Estat dels allotjaments a llistar. (Operatiu, No Operatiu)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
    }

    /**
     * Llista els accessos segons l'estat indicat.
     *
     * @param infoEstat Estat dels accessos a llistar. (Obert, Tancat)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return "";
    }

    /**
     * Llista les tasques registrades al càmping.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return "";
    }

    /**
     * Afegeix una nova tasca al registre del càmping.
     *
     * @param num           Número identificador de la tasca.
     * @param tipus         Tipus de tasca (en format string)
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data          Data en què s'ha registrat la tasca.
     * @param dies          Número esperat de dies per completar la tasca
     * @throws ExcepcioCamping
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {

    }

    /**
     * Completa una tasca de manteniment existent identificada pel seu número.
     *
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {

    }

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     *
     * @return El nombre d'accessos accessibles. (int)
     */
    @Override
    public int calculaAccessosNoAccessibles() {
        return 0;
    }

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     *
     * @return La quantitat de metres. (float)
     */
    @Override
    public float calculaMetresTerra() {
        return 0;
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {

    }

    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     */
    @Override
    public void inicialitzaDadesCamping() {

    }
}

