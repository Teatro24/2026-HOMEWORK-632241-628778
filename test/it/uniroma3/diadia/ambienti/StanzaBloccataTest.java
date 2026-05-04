package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaNord;

    @BeforeEach
    public void setUp() {
        this.stanzaBloccata = new StanzaBloccata("Atrio", "nord", "passepartout");
        this.stanzaNord = new Stanza("Biblioteca");
        this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanzaNord);
    }

    @Test
    public void testDirezioneBloccataSenzaAttrezzoRitornaStanzaCorrente() {
        Stanza risultato = this.stanzaBloccata.getStanzaAdiacente("nord");
        assertSame(this.stanzaBloccata, risultato);
    }

    @Test
    public void testDirezioneBloccataConAttrezzoPassaAllaStanzaSuccessiva() {
        this.stanzaBloccata.addAttrezzo(new Attrezzo("passepartout", 1));
        Stanza risultato = this.stanzaBloccata.getStanzaAdiacente("nord");
        assertSame(this.stanzaNord, risultato);
    }

    @Test
    public void testDirezioneNonBloccataFunzionaNormalmente() {
        Stanza stanzaEst = new Stanza("Aula");
        this.stanzaBloccata.impostaStanzaAdiacente("est", stanzaEst);
        assertSame(stanzaEst, this.stanzaBloccata.getStanzaAdiacente("est"));
    }

    @Test
    public void testDescrizioneIndicaDirezioneBloccata() {
        assertTrue(this.stanzaBloccata.getDescrizione().contains("nord"));
    }

    @Test
    public void testDescrizioneConAttrezzoNonIndicaBloccata() {
        this.stanzaBloccata.addAttrezzo(new Attrezzo("passepartout", 1));
        assertFalse(this.stanzaBloccata.getDescrizione().contains("bloccata"));
    }
}
