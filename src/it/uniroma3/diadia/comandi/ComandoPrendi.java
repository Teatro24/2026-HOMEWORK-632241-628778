package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {

    private static final String NOME = "prendi";
    private String parametro;

    public ComandoPrendi() {
    }

    public ComandoPrendi(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void esegui(Partita partita, IO io) {
        if (this.parametro == null) {
            io.mostraMessaggio("Quale attrezzo vuoi prendere?");
            return;
        }
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(this.parametro);
        if (attrezzo == null) {
            io.mostraMessaggio("L'attrezzo '" + this.parametro + "' non si trova in questa stanza.");
            return;
        }
        Borsa borsa = partita.getGiocatore().getBorsa();
        if (borsa.addAttrezzo(attrezzo)) {
            stanzaCorrente.removeAttrezzo(attrezzo);
            io.mostraMessaggio("Hai preso: " + attrezzo.getNome());
            io.mostraMessaggio(borsa.toString());
        } else {
            io.mostraMessaggio("Non puoi prendere '" + this.parametro + "': la borsa e' piena o l'attrezzo e' troppo pesante.");
        }
    }

    @Override
    public String getNome() {
        return NOME;
    }

    @Override
    public String getParametro() {
        return this.parametro;
    }

    @Override
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
}
