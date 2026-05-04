package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

    private static final String NOME = "non valido";
    private String parametro;

    public ComandoNonValido() {
        this.parametro = null;
    }

    @Override
    public void esegui(Partita partita, IO io) {
        io.mostraMessaggio("Comando non riconosciuto.");
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
