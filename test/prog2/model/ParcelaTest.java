package prog2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParcelaTest {

    private Parcela parcela;

    @BeforeEach
    void setUp() {
        // Constructor correcte a la pràctica 2
        parcela = new Parcela("Parcela A", "P001", true, "100%", 50.0f, true);
    }

    // -------------------------
    // Constructor i getters
    // -------------------------
    @Test
    void constructorValid() {
        Parcela p = new Parcela("Parcela B", "P002", true, "100%", 30.5f, false);

        assertEquals("Parcela B", p.getNom());
        assertEquals("P002", p.getId());
        assertEquals(30.5f, p.getMetres());
        assertFalse(p.isConnexioElectrica());
        assertTrue(p.isOperatiu());
        assertEquals("100%", p.getIluminacio());
    }

    // -------------------------
    // Atributs propis
    // -------------------------
    @Test
    void testGetMetres() {
        assertEquals(50.0f, parcela.getMetres());
    }

    @Test
    void testSetMetres() {
        parcela.setMetres(60.0f);
        assertEquals(60.0f, parcela.getMetres());
    }

    @Test
    void testIsConnexioElectrica() {
        assertTrue(parcela.isConnexioElectrica());
    }

    @Test
    void testSetConnexioElectrica() {
        parcela.setConnexioElectrica(false);
        assertFalse(parcela.isConnexioElectrica());
    }

    // -------------------------
    // Herència d'Allotjament
    // -------------------------
    @Test
    void testEstadaMinima() {
        assertEquals(4, parcela.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(2, parcela.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }

    // -------------------------
    // Estat operatiu
    // -------------------------
    @Test
    void testOperatiuInicial() {
        assertTrue(parcela.isOperatiu());
        assertEquals("100%", parcela.getIluminacio());
    }

    // -------------------------
    // toString
    // -------------------------
    @Test
    void testToString() {
        String text = parcela.toString();
        assertTrue(text.contains("Parcela A"));
        assertTrue(text.contains("P001"));
        assertTrue(text.contains("100%"));
    }
}