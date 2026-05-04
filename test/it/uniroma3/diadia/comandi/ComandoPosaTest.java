package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

    private Partita partita;
    private IO io;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.io = new IOSimulator(new String[]{});
        // prendiamo l'osso dalla stanza iniziale per averlo in borsa
        this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("osso", 1));
    }

    @Test
    public void testPosaAttrezzoInBorsa() {
        ComandoPosa cmd = new ComandoPosa("osso");
        cmd.esegui(this.partita, this.io);
        assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("osso"));
        assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
    }

    @Test
    public void testPosaAttrezzoNonInBorsa() {
        ComandoPosa cmd = new ComandoPosa("spada");
        cmd.esegui(this.partita, this.io);
        assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
    }

    @Test
    public void testPosaSenzaParametro() {
        boolean borsaPrima = this.partita.getGiocatore().getBorsa().isEmpty();
        ComandoPosa cmd = new ComandoPosa(null);
        cmd.esegui(this.partita, this.io);
        // borsa invariata
        assertEquals(borsaPrima, this.partita.getGiocatore().getBorsa().isEmpty());
    }

    @Test
    public void testGetNome() {
        assertEquals("posa", new ComandoPosa("osso").getNome());
    }

    @Test
    public void testGetParametro() {
        assertEquals("osso", new ComandoPosa("osso").getParametro());
    }
}
