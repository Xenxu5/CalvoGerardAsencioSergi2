package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAllotjamentsTest {

    private LlistaAllotjaments llista;
    private Allotjament aOperatiu;
    private Allotjament aNoOperatiu;

    @BeforeEach
    void setUp() throws ExcepcioCamping {
        llista = new LlistaAllotjaments();

        aOperatiu = new Parcela("Parcela Operativa", "ALL1", true, "100%", 50f, true);
        aNoOperatiu = new Parcela("Parcela No Operativa", "ALL2", false, "100%", 40f, true);

        llista.afegirAllotjament(aOperatiu);
        llista.afegirAllotjament(aNoOperatiu);
    }

    @Test
    void testAfegirAllotjament() {
        assertTrue(llista.contains(aOperatiu));
        assertTrue(llista.contains(aNoOperatiu));
    }

    @Test
    void testGetAllotjament() throws ExcepcioCamping {
        Allotjament a = llista.getAllotjament("ALL1");
        assertEquals(aOperatiu, a);
    }

    @Test
    void testContainsAllotjamentOperatiu() {
        assertTrue(llista.containsAllotjamentOperatiu());
    }

    @Test
    void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        String resultat = llista.llistarAllotjaments("Operatiu");
        assertTrue(resultat.contains("ALL1"));
        assertFalse(resultat.contains("ALL2"));
    }

    @Test
    void testLlistarAllotjamentsNoOperatius() throws ExcepcioCamping {
        String resultat = llista.llistarAllotjaments("No Operatiu");
        assertTrue(resultat.contains("ALL2"));
        assertFalse(resultat.contains("ALL1"));
    }
}