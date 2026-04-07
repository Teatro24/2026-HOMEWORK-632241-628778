package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    public void setUp() {
        this.giocatore = new Giocatore();
    }

    // --- TEST PER getCfu() ---
    @Test
    public void testGetCfu_ValoreIniziale() {
        assertEquals(20, giocatore.getCfu());
    }

    @Test
    public void testGetCfu_DopoDecremento() {
        giocatore.setCfu(giocatore.getCfu() - 1);
        assertEquals(19, giocatore.getCfu());
    }

    @Test
    public void testGetCfu_Zero() {
        giocatore.setCfu(0);
        assertEquals(0, giocatore.getCfu());
    }

    // --- TEST PER setBorsa() / getBorsa() ---
    @Test
    public void testGetBorsa_NonNull() {
        assertNotNull(giocatore.getBorsa());
    }

    @Test
    public void testGetBorsa_InizialmenterVuota() {
        assertTrue(giocatore.getBorsa().isEmpty());
    }

    @Test
    public void testGetBorsa_StessaIstanza() {
        Borsa b = giocatore.getBorsa();
        assertSame(b, giocatore.getBorsa());
    }
    
}
