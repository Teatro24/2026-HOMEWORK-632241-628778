package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {

    private static final String NOME = "posa";
    private String parametro;

    public ComandoPosa() {
    }

    public ComandoPosa(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void esegui(Partita partita, IO io) {
        if (this.parametro == null) {
            io.mostraMessaggio("Quale attrezzo vuoi posare?");
            return;
        }
        Borsa borsa = partita.getGiocatore().getBorsa();
        Attrezzo attrezzo = borsa.removeAttrezzo(this.parametro);
        if (attrezzo == null) {
            io.mostraMessaggio("L'attrezzo '" + this.parametro + "' non e' nella tua borsa.");
            return;
        }
        partita.getStanzaCorrente().addAttrezzo(attrezzo);
        io.mostraMessaggio("Hai posato: " + attrezzo.getNome());
        io.mostraMessaggio(borsa.toString());
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
