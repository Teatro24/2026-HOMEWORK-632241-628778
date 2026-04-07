package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LabirintoTest {

    private Labirinto labirinto;

    @BeforeEach
    public void setUp() {
        this.labirinto = new Labirinto();
    }

    // Test su getStanzaIniziale()
    @Test
    public void testGetStanzaIniziale_nonNull() {
        assertNotNull(labirinto.getStanzaIniziale());
    }

    @Test
    public void testGetStanzaIniziale_nomeCorretto() {
        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
    }

    @Test
    public void testGetStanzaIniziale_diversaDaVincente() {
        assertNotEquals(labirinto.getStanzaIniziale(), labirinto.getStanzaVincente());
    }

    // Test su getStanzaVincente()
    @Test
    public void testGetStanzaVincente_nonNull() {
        assertNotNull(labirinto.getStanzaVincente());
    }

    @Test
    public void testGetStanzaVincente_nomeCorretto() {
        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
    }

    @Test
    public void testGetStanzaVincente_raggiungibile() {
        Stanza iniziale = labirinto.getStanzaIniziale();
        Stanza vincente = iniziale.getStanzaAdiacente("nord");
        assertEquals(labirinto.getStanzaVincente(), vincente);
    }
}