package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

    // --- TEST PER addAttrezzo() ---

    @Test
    public void testAddAttrezzo_StanzaVuota() {
        Stanza stanza = new Stanza("stanza");
        assertTrue(stanza.addAttrezzo(new Attrezzo("osso", 1)));
    }

    @Test
    public void testAddAttrezzo_StanzaPiena() {
        Stanza stanza = new Stanza("stanza");
        for (int i = 0; i < 10; i++)
            stanza.addAttrezzo(new Attrezzo("att" + i, 1));
        assertFalse(stanza.addAttrezzo(new Attrezzo("undicesimo", 1)));
    }

    @Test
    public void testAddAttrezzo_AttrezzoPresenteDopoAggiunta() {
        Stanza stanza = new Stanza("stanza");
        Attrezzo osso = new Attrezzo("osso", 1);
        stanza.addAttrezzo(osso);
        assertTrue(stanza.hasAttrezzo("osso"));
    }

    // --- TEST PER hasAttrezzo() ---

    @Test
    public void testHasAttrezzo_StanzaVuota() {
        Stanza stanza = new Stanza("stanza");
        assertFalse(stanza.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzo_AttrezzoPresente() {
        Stanza stanza = new Stanza("stanza");
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        assertTrue(stanza.hasAttrezzo("osso"));
    }

    @Test
    public void testHasAttrezzo_AttrezzoAssente() {
        Stanza stanza = new Stanza("stanza");
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        assertFalse(stanza.hasAttrezzo("lanterna"));
    }

    // --- TEST PER getAttrezzo() ---

    @Test
    public void testGetAttrezzo_StanzaVuota() {
        Stanza stanza = new Stanza("stanza");
        assertNull(stanza.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzo_AttrezzoPresente() {
        Stanza stanza = new Stanza("stanza");
        Attrezzo osso = new Attrezzo("osso", 1);
        stanza.addAttrezzo(osso);
        assertEquals(osso, stanza.getAttrezzo("osso"));
    }

    @Test
    public void testGetAttrezzo_AttrezzoSbagliato() {
        Stanza stanza = new Stanza("stanza");
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        assertNull(stanza.getAttrezzo("lanterna"));
    }

    // --- TEST PER removeAttrezzo() ---

    @Test
    public void testRemoveAttrezzo_AttrezzoPresente() {
        Stanza stanza = new Stanza("stanza");
        Attrezzo osso = new Attrezzo("osso", 1);
        stanza.addAttrezzo(osso);
        assertTrue(stanza.removeAttrezzo(osso));
    }

    @Test
    public void testRemoveAttrezzo_AttrezzoNonPresente() {
        Stanza stanza = new Stanza("stanza");
        assertFalse(stanza.removeAttrezzo(new Attrezzo("osso", 1)));
    }

    @Test
    public void testRemoveAttrezzo_DopoRimozioneSparisce() {
        Stanza stanza = new Stanza("stanza");
        Attrezzo osso = new Attrezzo("osso", 1);
        stanza.addAttrezzo(osso);
        stanza.removeAttrezzo(osso);
        assertFalse(stanza.hasAttrezzo("osso"));
    }

    // --- TEST PER impostaStanzaAdiacente() / getStanzaAdiacente() ---

    @Test
    public void testGetStanzaAdiacente_DirezionePresenteRitornaStanza() {
        Stanza stanza = new Stanza("atrio");
        Stanza nord = new Stanza("biblioteca");
        stanza.impostaStanzaAdiacente("nord", nord);
        assertEquals(nord, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacente_DirezioneAssenteRitornaNull() {
        Stanza stanza = new Stanza("atrio");
        assertNull(stanza.getStanzaAdiacente("nord"));
    }

    @Test
    public void testImpostaStanzaAdiacente_SovrascriveDirezioneEsistente() {
        Stanza stanza = new Stanza("atrio");
        Stanza prima = new Stanza("aula1");
        Stanza dopo = new Stanza("aula2");
        stanza.impostaStanzaAdiacente("nord", prima);
        stanza.impostaStanzaAdiacente("nord", dopo);
        assertEquals(dopo, stanza.getStanzaAdiacente("nord"));
    }
}
