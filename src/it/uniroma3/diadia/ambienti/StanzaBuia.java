package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    private static final String DESCRIZIONE_BUIO = "qui c'e' buio pesto";
    private String nomeAttrezzoPerVedere;

    public StanzaBuia(String nome, String nomeAttrezzoPerVedere) {
        super(nome);
        this.nomeAttrezzoPerVedere = nomeAttrezzoPerVedere;
    }

    @Override
    public String getDescrizione() {
        if (this.hasAttrezzo(this.nomeAttrezzoPerVedere))
            return super.getDescrizione();
        else
            return DESCRIZIONE_BUIO;
    }
}
