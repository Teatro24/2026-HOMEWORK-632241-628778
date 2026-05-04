package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

    private static final String NOME = "guarda";

    @Override
    public void esegui(Partita partita, IO io) {
        io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        io.mostraMessaggio("CFU rimanenti: " + partita.getCfu());
        io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    }

    @Override
    public String getNome() {
        return NOME;
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void setParametro(String parametro) {
        // nessun parametro
    }
}
