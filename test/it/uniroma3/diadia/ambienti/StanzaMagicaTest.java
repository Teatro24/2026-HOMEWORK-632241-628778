package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

    private StanzaMagica stanzaMagica;

    @BeforeEach
    public void setUp() {
        this.stanzaMagica = new StanzaMagica("Stanza Magica");
    }

    @Test
    public void testPrimoAttrezzoNonModificato() {
        Attrezzo chiave = new Attrezzo("chiave", 2);
        this.stanzaMagica.addAttrezzo(chiave);
        assertTrue(this.stanzaMagica.hasAttrezzo("chiave"));
    }

    @Test
    public void testSecondoAttrezzoNonModificato() {
        this.stanzaMagica.addAttrezzo(new Attrezzo("chiave", 2));
        this.stanzaMagica.addAttrezzo(new Attrezzo("spada", 3));
        assertTrue(this.stanzaMagica.hasAttrezzo("spada"));
    }

    @Test
    public void testTerzoAttrezzoNonModificato() {
        this.stanzaMagica.addAttrezzo(new Attrezzo("chiave", 2));
        this.stanzaMagica.addAttrezzo(new Attrezzo("spada", 3));
        this.stanzaMagica.addAttrezzo(new Attrezzo("osso", 1));
        assertTrue(this.stanzaMagica.hasAttrezzo("osso"));
    }

    @Test
    public void testQuartoAttrezzoModificatoNomeInvertito() {
        this.stanzaMagica.addAttrezzo(new Attrezzo("chiave", 2));
        this.stanzaMagica.addAttrezzo(new Attrezzo("spada", 3));
        this.stanzaMagica.addAttrezzo(new Attrezzo("osso", 1));
        this.stanzaMagica.addAttrezzo(new Attrezzo("chiave", 2));
        assertFalse(this.stanzaMagica.hasAttrezzo("chiave"));
        assertTrue(this.stanzaMagica.hasAttrezzo("evaihc"));
    }

    @Test
    public void testQuartoAttrezzoModificatoPesoRaddoppiato() {
        this.stanzaMagica.addAttrezzo(new Attrezzo("chiave", 2));
        this.stanzaMagica.addAttrezzo(new Attrezzo("spada", 3));
        this.stanzaMagica.addAttrezzo(new Attrezzo("osso", 1));
        this.stanzaMagica.addAttrezzo(new Attrezzo("chiave", 2));
        Attrezzo modificato = this.stanzaMagica.getAttrezzo("evaihc");
        assertNotNull(modificato);
        assertEquals(4, modificato.getPeso());
    }

    @Test
    public void testSogliaPersonalizzata() {
        StanzaMagica stanzaConSoglia1 = new StanzaMagica("Test", 1);
        stanzaConSoglia1.addAttrezzo(new Attrezzo("osso", 1));
        stanzaConSoglia1.addAttrezzo(new Attrezzo("chiave", 2));
        assertFalse(stanzaConSoglia1.hasAttrezzo("chiave"));
        assertTrue(stanzaConSoglia1.hasAttrezzo("evaihc"));
    }
}
