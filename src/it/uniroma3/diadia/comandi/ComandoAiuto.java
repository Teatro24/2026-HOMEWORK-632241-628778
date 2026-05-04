package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

    private static final String NOME = "aiuto";
    static final String[] ELENCO_COMANDI = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};

    @Override
    public void esegui(Partita partita, IO io) {
        StringBuilder sb = new StringBuilder("Comandi disponibili: ");
        for (String cmd : ELENCO_COMANDI)
            sb.append(cmd).append("  ");
        io.mostraMessaggio(sb.toString());
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
