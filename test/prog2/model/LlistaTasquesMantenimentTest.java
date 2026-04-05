package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaTasquesMantenimentTest {

    private LlistaTasquesManteniment llista;
    private Allotjament allotjament;
    private TascaManteniment tasca;

    @BeforeEach
    void setUp() throws ExcepcioCamping {
        llista = new LlistaTasquesManteniment();

        allotjament = new Parcela("Parcela Test", "ALL1", true,
                "100%", 50f, true);
        tasca = new TascaManteniment(1, TascaManteniment.TipusTascaManteniment.Reparacio,
                allotjament, "2024-03-25", 3);

        llista.afegirTascaManteniment(
                tasca.getNum(),
                tasca.getTipus().name(),
                allotjament,
                tasca.getData(),
                tasca.getDies()
        );
    }

    // -------------------------
    // Afegir tasca
    // -------------------------
    @Test
    void testAfegirTascaManteniment() {
        assertFalse(allotjament.isOperatiu());
    }

    // -------------------------
    // Get tasca
    // -------------------------
    @Test
    void testGetTascaManteniment() throws ExcepcioCamping {
        TascaManteniment resultat = llista.getTascaManteniment(1);
        assertEquals(tasca.getNum(), resultat.getNum());
    }

    // -------------------------
    // Completar tasca
    // -------------------------
    @Test
    void testCompletarTascaManteniment() throws ExcepcioCamping {
        TascaManteniment t = llista.getTascaManteniment(1);
        llista.completarTascaManteniment(t);

        assertTrue(allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }

    // -------------------------
    // Llistar tasques
    // -------------------------
    @Test
    void testLlistarTasquesManteniment() throws ExcepcioCamping {
        String resultat = llista.llistarTasquesManteniment();
        assertTrue(resultat.contains("Tasca"));
    }
}