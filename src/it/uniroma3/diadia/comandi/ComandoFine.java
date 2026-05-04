package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

    private static final String NOME = "fine";

    @Override
    public void esegui(Partita partita, IO io) {
        partita.setFinita();
        io.mostraMessaggio("Grazie di aver giocato!");
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
