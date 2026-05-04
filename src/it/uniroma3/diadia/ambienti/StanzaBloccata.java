package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

    private String direzioneBloccata;
    private String nomeAttrezzoSbloccante;

    public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
            return this;
        }
        return super.getStanzaAdiacente(direzione);
    }

    @Override
    public String getDescrizione() {
        StringBuilder sb = new StringBuilder(super.getDescrizione());
        if (!this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
            sb.append("\n[Attenzione: la direzione ").append(this.direzioneBloccata)
              .append(" e' bloccata! Serve: ").append(this.nomeAttrezzoSbloccante).append("]");
        }
        return sb.toString();
    }
}
