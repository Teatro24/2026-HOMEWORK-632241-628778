package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandiFisarmonica fabbrica;

    @BeforeEach
    public void setUp() {
        this.fabbrica = new FabbricaDiComandiFisarmonica();
    }

    @Test
    public void testRiconoscimentoVai() {
        Comando cmd = fabbrica.costruisciComando("vai nord");
        assertEquals("vai", cmd.getNome());
        assertEquals("nord", cmd.getParametro());
    }

    @Test
    public void testRiconoscimentoVaiSenzaParametro() {
        Comando cmd = fabbrica.costruisciComando("vai");
        assertEquals("vai", cmd.getNome());
        assertNull(cmd.getParametro());
    }

    @Test
    public void testRiconoscimentoAiuto() {
        Comando cmd = fabbrica.costruisciComando("aiuto");
        assertEquals("aiuto", cmd.getNome());
    }

    @Test
    public void testRiconoscimentoFine() {
        Comando cmd = fabbrica.costruisciComando("fine");
        assertEquals("fine", cmd.getNome());
    }

    @Test
    public void testRiconoscimentoPrendi() {
        Comando cmd = fabbrica.costruisciComando("prendi osso");
        assertEquals("prendi", cmd.getNome());
        assertEquals("osso", cmd.getParametro());
    }

    @Test
    public void testRiconoscimentoPosa() {
        Comando cmd = fabbrica.costruisciComando("posa lanterna");
        assertEquals("posa", cmd.getNome());
        assertEquals("lanterna", cmd.getParametro());
    }

    @Test
    public void testRiconoscimentoGuarda() {
        Comando cmd = fabbrica.costruisciComando("guarda");
        assertEquals("guarda", cmd.getNome());
    }

    @Test
    public void testComandoSconosciuto() {
        Comando cmd = fabbrica.costruisciComando("xyzzy");
        assertEquals("non valido", cmd.getNome());
    }

    @Test
    public void testStringaVuota() {
        Comando cmd = fabbrica.costruisciComando("");
        assertEquals("non valido", cmd.getNome());
    }
}
