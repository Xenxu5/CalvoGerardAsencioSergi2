package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAccessosTest {

    private LlistaAccessos llista;
    private Acces accesObert;
    private Acces accesTancat;

    @BeforeEach
    void setUp() throws ExcepcioCamping {
        llista = new LlistaAccessos();

        // Accés obert
        accesObert = new CamiAsfalt("A1", true, 100f);

        // Accés tancat
        accesTancat = new CamiTerra("A2", false, 50f);

        llista.afegirAcces(accesObert);
        llista.afegirAcces(accesTancat);
    }

    @Test
    void testAfegirAcces() {
        assertEquals("A1", accesObert.getNom());
        assertEquals("A2", accesTancat.getNom());
    }

    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String resultat = llista.llistarAccessos(true);

        assertTrue(resultat.contains("A1"));
        assertFalse(resultat.contains("A2"));
    }

    @Test
    void testLlistarAccessosTancats() throws ExcepcioCamping {
        String resultat = llista.llistarAccessos(false);

        assertTrue(resultat.contains("A2"));
        assertFalse(resultat.contains("A1"));
    }

    @Test
    void testCalculAccessosNoAccessibles() {
        int noAccessibles = llista.calculaAccessosNoAccessibles();
        assertTrue(noAccessibles >= 0);
    }

    @Test
    void testCalculMetresTerra() {
        float metres = llista.calculaMetresTerra();
        assertTrue(metres >= 0);
    }
}