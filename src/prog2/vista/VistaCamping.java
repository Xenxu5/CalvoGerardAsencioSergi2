package prog2.vista;

import prog2.model.Camping;
import java.util.Scanner;

public class VistaCamping {

    // Declaració opcions menu
    private enum OpcionsMenu {
        MENU_LLISTAR_TOTS,
        MENU_LLISTAR_OPERATIUS,
        MENU_LLISTAR_NO_OPERATIUS,
        MENU_LLISTAR_ACCESOS_OBERTS,
        MENU_LLISTAR_ACCESOS_TANCATS,
        MENU_LLISTAR_TASQUES,
        MENU_AFEGIR_TASCA,
        MENU_COMPLETAR_TASCA,
        MENU_CALCULAR_SENSE_VEHICLE,
        MENU_CALCULAR_METRES_TERRA,
        MENU_GUARDAR,
        MENU_RECUPERAR,
        MENU_SORTIR
    }

    // Descripcions personalitzades de cada una de les funcions del menu
    private static final String[] descripcionsMenu = {
            "Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Llistar la informació de les tasques de manteniment actives",
            "Afegir una tasca de manteniment",
            "Completar una tasca de manteniment",
            "Calcular i mostrar el número total d'accessos sense accessibilitat amb vehicle",
            "Calcular i mostrar el número total de metres dels accessos de terra",
            "Guardar càmping",
            "Recuperar càmping",
            "Sortir de l'aplicació"
    };

    /**
     * Atribut privat
     */
    private Camping camping;

    /**
     * Constructor VistaCamping
     */
    public VistaCamping(String nomCamping) {
        // Inicialitzem l'objecte Camping amb el nom que ens passen ("Green")
        this.camping = new Camping(nomCamping);
        // Cridem el mètode de càrrega de dades per defecte
        this.camping.inicialitzaDadesCamping();
    }

    // Mètode que s'encarrega del bucle principal

    /**
     * Mètode per gestionar el menu
     */
    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);

        // Creem el menú indicant l'Enum i les opcions
        Menu<OpcionsMenu> menu = new Menu<>("Menú del Càmping " + camping.getNomCamping(), OpcionsMenu.values());
        menu.setDescripcions(descripcionsMenu);

        OpcionsMenu opcio = null;

        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_LLISTAR_TOTS:
                    llistarTotsAllotjaments();
                    break;
                case MENU_LLISTAR_OPERATIUS:
                    llistarAllotjamentsEstat("Operatiu");
                    break;
                case MENU_LLISTAR_NO_OPERATIUS:
                    llistarAllotjamentsEstat("No Operatiu");
                    break;
                case MENU_LLISTAR_ACCESOS_OBERTS:
                    llistarAccessosEstat("Obert");
                    break;
                case MENU_LLISTAR_ACCESOS_TANCATS:
                    llistarAccessosEstat("Tancat");
                    break;
                case MENU_LLISTAR_TASQUES:
                    llistarTasquesManteniment();
                    break;
                case MENU_AFEGIR_TASCA:
                    afegirTascaManteniment(sc);
                    break;
                case MENU_COMPLETAR_TASCA:
                    completarTascaManteniment(sc);
                    break;
                case MENU_CALCULAR_SENSE_VEHICLE:
                    mostrarAccessosSenseVehicle();
                    break;
                case MENU_CALCULAR_METRES_TERRA:
                    mostrarMetresTerra();
                    break;
                case MENU_GUARDAR:
                    guardarCamping(sc);
                    break;
                case MENU_RECUPERAR:
                    recuperarCamping(sc);
                    break;
                case MENU_SORTIR:
                    System.out.println("Sortint de l'aplicació...");
                    break;
            }
        } while (opcio != OpcionsMenu.MENU_SORTIR);
    }

    // Mètodes privats auxiliars per fer les funcions

    private void llistarTotsAllotjaments() {
        try {
            System.out.println("\n Llista de tots els allotjaments");
            // Utilitzem una paraula clau com "Tots" si el model ho accepta, o llistem directament
            String resultat = camping.llistarAllotjaments("Tots");
            System.out.println(resultat);
        } catch (ExcepcioCamping e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void llistarAllotjamentsEstat(String estat) {
        try {
            System.out.println("\n Llista d'allotjaments (" + estat.toUpperCase() + ")");
            String resultat = camping.llistarAllotjaments(estat);
            System.out.println(resultat);
        } catch (ExcepcioCamping e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void llistarAccessosEstat(String estat) {
        try {
            System.out.println("\n Llista d'accessos (" + estat.toUpperCase() + ")");
            String resultat = camping.llistarAccessos(estat);
            System.out.println(resultat);
        } catch (ExcepcioCamping e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void llistarTasquesManteniment() {
        try {
            System.out.println("\n Tasques manteniment ");
            String resultat = camping.llistarTasquesManteniment();
            System.out.println(resultat);
        } catch (ExcepcioCamping e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void afegirTascaManteniment(Scanner sc) {
        try {
            System.out.println("\n Afegir tasca manteniment ");
            System.out.print("Introdueix el número de la tasca: ");
            int num = Integer.parseInt(sc.nextLine()); // Llegim com a text i convertim a número

            System.out.print("Introdueix el tipus de tasca (Reparacio, Neteja, RevisioTecnica, Desinfeccio): ");
            String tipus = sc.nextLine();

            System.out.print("Introdueix l'ID de l'allotjament: ");
            String idAllotjament = sc.nextLine();

            System.out.print("Introdueix la data (ex: 2026-04-05): ");
            String data = sc.nextLine();

            System.out.print("Introdueix els dies estimats: ");
            int dies = Integer.parseInt(sc.nextLine());

            // Ho enviem al model
            camping.afegirTascaManteniment(num, tipus, idAllotjament, data, dies);
            System.out.println("Tasca afegida correctament!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Has d'introduir un número vàlid.");
        } catch (ExcepcioCamping e) {
            System.out.println("Error en afegir la tasca: " + e.getMessage());
        }
    }

    private void completarTascaManteniment(Scanner sc) {
        try {
            System.out.println("\n Completar tasca de manteniment ");
            // Primer llistem
            System.out.println(camping.llistarTasquesManteniment());

            System.out.print("Introdueix el número de la tasca que vols completar: ");
            int num = Integer.parseInt(sc.nextLine());

            camping.completarTascaManteniment(num);
            System.out.println("Tasca completada correctament!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Has d'introduir un número vàlid.");
        } catch (ExcepcioCamping e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void mostrarAccessosSenseVehicle() {
        try { //
            int quantitat = camping.calculaAccessosNoAccessibles();
            System.out.println("\nHi ha un total de " + quantitat + " accessos sense accessibilitat per a vehicles.");
        } catch (Exception e) {
            System.out.println("Error calculant: " + e.getMessage());
        }
    }

    private void mostrarMetresTerra() {
        try {
            float metres = camping.calculaMetresTerra();
            System.out.println("\nHi ha un total de " + metres + " metres de camins/carreteres de terra.");
        } catch (Exception e) {
            System.out.println("Error calculant: " + e.getMessage());
        }
    }

    private void guardarCamping(Scanner sc) {
        try {
            System.out.println("\n Guardar dades ");
            System.out.print("Introdueix el nom del fitxer (ex: dades.txt): ");
            String nomFitxer = sc.nextLine();

            camping.save(nomFitxer);
            System.out.println("Dades guardades correctament a " + nomFitxer);
        } catch (ExcepcioCamping e) {
            System.out.println("Error en guardar: " + e.getMessage());
        }
    }

    private void recuperarCamping(Scanner sc) {
        try {
            System.out.println("\n Recuperar dades ");
            System.out.print("Introdueix el nom del fitxer a carregar: ");
            String nomFitxer = sc.nextLine();

            this.camping = Camping.load(nomFitxer);
            System.out.println("Dades carregades correctament des de " + nomFitxer);
        } catch (ExcepcioCamping e) {
            System.out.println("Error en carregar: " + e.getMessage());
        }
    }
}
