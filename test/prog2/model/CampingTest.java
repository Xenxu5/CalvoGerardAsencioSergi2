package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class CampingTest {

    private Camping camping;

    @BeforeEach
    void setUp() {
        camping = new Camping("Camping Test");
        camping.inicialitzaDadesCamping();
    }

    // ---------------------------------
    // Constructor i getters
    // ---------------------------------
    @Test
    void testConstructor() {
        assertEquals("Camping Test", camping.getNomCamping());
    }

    // ---------------------------------
    // Allotjaments
    // ---------------------------------
    @Test
    void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        String resultat = camping.llistarAllotjaments("Operatiu");
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    @Test
    void testLlistarAllotjamentsNoOperatiusSenseTasques() {
        assertThrows(ExcepcioCamping.class, () ->
                camping.llistarAllotjaments("No Operatiu")
        );
    }

    // ---------------------------------
    // Tasques de manteniment
    // ---------------------------------
    @Test
    void testAfegirTascaManteniment() throws ExcepcioCamping {

        camping.afegirTascaManteniment(
                1,
                "Reparacio",
                "ALL1",
                "01/04/2026",
                3
        );

        String noOperatius = camping.llistarAllotjaments("No Operatiu");
        assertTrue(noOperatius.contains("ALL1"));
    }

    @Test
    void testCompletarTascaManteniment() throws ExcepcioCamping {

        camping.afegirTascaManteniment(
                2,
                "Neteja",
                "ALL2",
                "02/04/2026",
                2
        );

        camping.completarTascaManteniment(2);

        String operatius = camping.llistarAllotjaments("Operatiu");
        assertTrue(operatius.contains("ALL2"));
    }

    @Test
    void testAfegirDuesTasquesMateixAllotjament() throws ExcepcioCamping {

        camping.afegirTascaManteniment(
                3,
                "Neteja",
                "ALL3",
                "03/04/2026",
                2
        );

        assertThrows(ExcepcioCamping.class, () ->
                camping.afegirTascaManteniment(
                        4,
                        "Reparacio",
                        "ALL3",
                        "04/04/2026",
                        3
                )
        );
    }

    // ---------------------------------
    // Accessos
    // ---------------------------------
    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String resultat = camping.llistarAccessos("Obert");
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    @Test
    void testCalculAccessosNoAccessibles() {
        int noAccessibles = camping.calculaAccessosNoAccessibles();
        assertTrue(noAccessibles >= 0);
    }

    @Test
    void testCalculMetresTerra() {
        float metres = camping.calculaMetresTerra();
        assertTrue(metres > 0);
    }
}