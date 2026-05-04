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

    @Test
    public void testGetStanzaIniziale_nonNull() {
        assertNotNull(labirinto.getStanzaIniziale());
    }

    @Test
    public void testGetStanzaIniziale_nomeCorretto() {
        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
    }

    @Test
    public void testGetStanzaVincente_nonNull() {
        assertNotNull(labirinto.getStanzaVincente());
    }

    @Test
    public void testGetStanzaVincente_nomeCorretto() {
        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
    }

    @Test
    public void testStanzaIniziale_diversaDaVincente() {
        assertNotEquals(labirinto.getStanzaIniziale(), labirinto.getStanzaVincente());
    }

    @Test
    public void testPercorsoVersoBiblioteca_passaPerCorridoioMagico() {
        // Atrio -> nord -> Corridoio Magico (StanzaMagica)
        Stanza corridoioMagico = labirinto.getStanzaIniziale().getStanzaAdiacente("nord");
        assertEquals("Corridoio Magico", corridoioMagico.getNome());
    }

    @Test
    public void testAulaN10_eStanzaBuia() {
        Stanza aulaN10 = labirinto.getStanzaIniziale().getStanzaAdiacente("sud");
        assertTrue(aulaN10 instanceof StanzaBuia);
    }

    @Test
    public void testCorridoioMagico_eStanzaMagica() {
        Stanza corridoio = labirinto.getStanzaIniziale().getStanzaAdiacente("nord");
        assertTrue(corridoio instanceof StanzaMagica);
    }

    @Test
    public void testLabirintoHaLanternaInLaboratorio() {
        Stanza laboratorio = labirinto.getStanzaIniziale().getStanzaAdiacente("ovest");
        assertTrue(laboratorio.hasAttrezzo("lanterna"));
    }

    @Test
    public void testLabirintoHaPassepartoutInAulaN11() {
        Stanza aulaN11 = labirinto.getStanzaIniziale().getStanzaAdiacente("est");
        assertTrue(aulaN11.hasAttrezzo("passepartout"));
    }
}
