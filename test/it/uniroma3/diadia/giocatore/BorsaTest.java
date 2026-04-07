package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

    // --- TEST PER isEmpty() ---

    @Test
    public void testIsEmpty_BorsaVuota() {
        Borsa borsa = new Borsa();
        assertTrue(borsa.isEmpty());
    }

    @Test
    public void testIsEmpty_BorsaConAttrezzo() {
        Borsa borsa = new Borsa();
        borsa.addAttrezzo(new Attrezzo("osso", 1));
        assertFalse(borsa.isEmpty());
    }

    @Test
    public void testIsEmpty_DopoRimozione() {
        Borsa borsa = new Borsa();
        borsa.addAttrezzo(new Attrezzo("osso", 1));
        borsa.removeAttrezzo("osso");
        assertTrue(borsa.isEmpty());
    }

    // --- TEST PER addAttrezzo() ---

    @Test
    public void testAddAttrezzo_PesoNeiLimiti() {
        Borsa borsa = new Borsa(10);
        assertTrue(borsa.addAttrezzo(new Attrezzo("piuma", 1)));
    }

    @Test
    public void testAddAttrezzo_PesoEccessivo() {
        Borsa borsa = new Borsa(10);
        assertFalse(borsa.addAttrezzo(new Attrezzo("incudine", 11)));
    }

    @Test
    public void testAddAttrezzo_BorsaPiena() {
        Borsa borsa = new Borsa(100);
        for (int i = 0; i < 10; i++)
            borsa.addAttrezzo(new Attrezzo("att" + i, 1));
        assertFalse(borsa.addAttrezzo(new Attrezzo("undicesimo", 1)));
    }

    // --- TEST PER getPeso() ---

    @Test
    public void testGetPeso_BorsaVuota() {
        Borsa borsa = new Borsa();
        assertEquals(0, borsa.getPeso());
    }

    @Test
    public void testGetPeso_ConUnAttrezzo() {
        Borsa borsa = new Borsa();
        borsa.addAttrezzo(new Attrezzo("osso", 3));
        assertEquals(3, borsa.getPeso());
    }

    @Test
    public void testGetPeso_ConPiuAttrezzi() {
        Borsa borsa = new Borsa(10);
        borsa.addAttrezzo(new Attrezzo("osso", 2));
        borsa.addAttrezzo(new Attrezzo("lanterna", 3));
        assertEquals(5, borsa.getPeso());
    }

    // --- TEST PER removeAttrezzo() ---

    @Test
    public void testRemoveAttrezzo_AttrezzoPresente() {
        Borsa borsa = new Borsa();
        Attrezzo osso = new Attrezzo("osso", 1);
        borsa.addAttrezzo(osso);
        assertEquals(osso, borsa.removeAttrezzo("osso"));
    }

    @Test
    public void testRemoveAttrezzo_AttrezzoNonPresente() {
        Borsa borsa = new Borsa();
        assertNull(borsa.removeAttrezzo("osso"));
    }

    @Test
    public void testRemoveAttrezzo_DopoRimozioneSparisce() {
        Borsa borsa = new Borsa();
        borsa.addAttrezzo(new Attrezzo("osso", 1));
        borsa.removeAttrezzo("osso");
        assertFalse(borsa.hasAttrezzo("osso"));
    }
}
