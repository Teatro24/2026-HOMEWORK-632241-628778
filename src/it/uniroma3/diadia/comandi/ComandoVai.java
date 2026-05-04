package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    private static final String NOME = "vai";
    private String parametro;

    public ComandoVai() {
    }

    public ComandoVai(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void esegui(Partita partita, IO io) {
        if (this.parametro == null) {
            io.mostraMessaggio("Dove vuoi andare? Specifica una direzione.");
            return;
        }
        Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.parametro);
        if (prossimaStanza == null) {
            io.mostraMessaggio("Direzione inesistente.");
        } else {
            partita.setStanzaCorrente(prossimaStanza);
            partita.setCfu(partita.getCfu() - 1);
        }
        io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
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
