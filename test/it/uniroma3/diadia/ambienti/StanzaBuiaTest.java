package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;

    @BeforeEach
    public void setUp() {
        this.stanzaBuia = new StanzaBuia("Corridoio Oscuro", "lanterna");
    }

    @Test
    public void testDescrizioneSenzaLanternaBuio() {
        assertEquals("qui c'e' buio pesto", this.stanzaBuia.getDescrizione());
    }

    @Test
    public void testDescrizioneConLanternaVisibile() {
        this.stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 3));
        assertNotEquals("qui c'e' buio pesto", this.stanzaBuia.getDescrizione());
        assertTrue(this.stanzaBuia.getDescrizione().contains("Corridoio Oscuro"));
    }

    @Test
    public void testDescrizioneDopoRimozioneLanternaTornaOscuro() {
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        this.stanzaBuia.addAttrezzo(lanterna);
        this.stanzaBuia.removeAttrezzo(lanterna);
        assertEquals("qui c'e' buio pesto", this.stanzaBuia.getDescrizione());
    }

    @Test
    public void testAltroAttrezzoNonIllumina() {
        this.stanzaBuia.addAttrezzo(new Attrezzo("torcia", 1));
        assertEquals("qui c'e' buio pesto", this.stanzaBuia.getDescrizione());
    }

    @Test
    public void testStanzaBuiaEreditaGetNome() {
        assertEquals("Corridoio Oscuro", this.stanzaBuia.getNome());
    }
}
