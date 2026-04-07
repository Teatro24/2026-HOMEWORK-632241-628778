package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

    // --- TEST PER vinta() ---

    @Test
    public void testVinta_InizioPartita() {
        assertFalse(new Partita().vinta());
    }

    @Test
    public void testVinta_StanzaVincente() {
        Partita p = new Partita();
        p.setStanzaCorrente(p.getStanzaVincente());
        assertTrue(p.vinta());
    }

    @Test
    public void testVinta_StanzaDiversaDaVincente() {
        Partita p = new Partita();
        p.setStanzaCorrente(new Stanza("altra stanza"));
        assertFalse(p.vinta());
    }

    // --- TEST PER isFinita() ---

    @Test
    public void testIsFinita_CfuZero() {
        Partita p = new Partita();
        p.setCfu(0);
        assertTrue(p.isFinita());
    }

    @Test
    public void testIsFinita_SetFinita() {
        Partita p = new Partita();
        p.setFinita();
        assertTrue(p.isFinita());
    }

    @Test
    public void testIsFinita_CfuPositiviNonFinita() {
        Partita p = new Partita();
        p.setCfu(1);
        assertFalse(p.isFinita());
    }

    // --- TEST PER getCfu() / setCfu() ---

    @Test
    public void testGetCfu_ValoreIniziale() {
        Partita p = new Partita();
        assertEquals(20, p.getCfu());
    }

    @Test
    public void testSetCfu_ModificaValore() {
        Partita p = new Partita();
        p.setCfu(15);
        assertEquals(15, p.getCfu());
    }

    @Test
    public void testSetCfu_Zero() {
        Partita p = new Partita();
        p.setCfu(0);
        assertEquals(0, p.getCfu());
    }
}
