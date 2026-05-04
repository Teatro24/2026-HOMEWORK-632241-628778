package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

public class ComandoVaiTest {

    private Partita partita;
    private IO io;

    @BeforeEach
    public void setUp() {
        this.partita = new Partita();
        this.io = new IOSimulator(new String[]{});
    }

    @Test
    public void testVaiNordRaggiungeBiblioteca() {
        ComandoVai cmd = new ComandoVai("nord");
        cmd.esegui(this.partita, this.io);
        assertEquals("Biblioteca", this.partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testVaiDirezioneInesistente() {
        ComandoVai cmd = new ComandoVai("nord");
        cmd.esegui(this.partita, this.io);
        // da Biblioteca non c'e' nord
        ComandoVai cmd2 = new ComandoVai("nord");
        String stanzaPrima = this.partita.getStanzaCorrente().getNome();
        cmd2.esegui(this.partita, this.io);
        assertEquals(stanzaPrima, this.partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testVaiSenzaParametroNonSiMuove() {
        String stanzaPrima = this.partita.getStanzaCorrente().getNome();
        ComandoVai cmd = new ComandoVai(null);
        cmd.esegui(this.partita, this.io);
        assertEquals(stanzaPrima, this.partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testVaiDecrementa1Cfu() {
        int cfuPrima = this.partita.getCfu();
        ComandoVai cmd = new ComandoVai("nord");
        cmd.esegui(this.partita, this.io);
        assertEquals(cfuPrima - 1, this.partita.getCfu());
    }

    @Test
    public void testGetNome() {
        ComandoVai cmd = new ComandoVai("nord");
        assertEquals("vai", cmd.getNome());
    }

    @Test
    public void testGetParametro() {
        ComandoVai cmd = new ComandoVai("est");
        assertEquals("est", cmd.getParametro());
    }
}
