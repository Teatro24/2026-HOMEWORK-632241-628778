package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

    private Partita partita;
    private IO io;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.io = new IOSimulator(new String[]{});
    }

    @Test
    public void testPrendiAttrezzoPresente() {
        // l'Atrio (stanza iniziale) ha l'osso
        ComandoPrendi cmd = new ComandoPrendi("osso");
        cmd.esegui(this.partita, this.io);
        assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("osso"));
        assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
    }

    @Test
    public void testPrendiAttrezzoAssente() {
        ComandoPrendi cmd = new ComandoPrendi("spada");
        cmd.esegui(this.partita, this.io);
        assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
    }

    @Test
    public void testPrendiSenzaParametro() {
        boolean borsaVuota = this.partita.getGiocatore().getBorsa().isEmpty();
        ComandoPrendi cmd = new ComandoPrendi(null);
        cmd.esegui(this.partita, this.io);
        assertEquals(borsaVuota, this.partita.getGiocatore().getBorsa().isEmpty());
    }

    @Test
    public void testGetNome() {
        assertEquals("prendi", new ComandoPrendi("osso").getNome());
    }

    @Test
    public void testGetParametro() {
        assertEquals("osso", new ComandoPrendi("osso").getParametro());
    }
}
