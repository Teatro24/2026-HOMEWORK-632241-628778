package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto; 
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe Partita - modella una partita del gioco DiaDia.
 * Contiene un riferimento al Labirinto (che gestisce le stanze)
 * e un riferimento al Giocatore (che gestisce CFU e borsa).
 * Tiene traccia della stanza corrente e dello stato della partita.
 *
 * @author studente
 * @version base
 */
public class Partita {

    private Labirinto labirinto;
    private Giocatore giocatore;
    private Stanza stanzaCorrente;
    private boolean finita;

    /**
     * Crea una nuova partita: inizializza il labirinto, il giocatore
     * e posiziona il giocatore nella stanza iniziale.
     */
    public Partita() {
        this.labirinto = new Labirinto();
        this.giocatore = new Giocatore();
        this.stanzaCorrente = this.labirinto.getStanzaIniziale();
        this.finita = false;
    }

    /**
     * Restituisce la stanza corrente in cui si trova il giocatore.
     * @return la stanza corrente
     */
    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    /**
     * Imposta la stanza corrente (usato quando il giocatore si sposta).
     * @param stanzaCorrente la nuova stanza corrente
     */
    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    /**
     * Restituisce la stanza vincente del labirinto.
     * @return la stanza che fa vincere la partita
     */
    public Stanza getStanzaVincente() {
        return this.labirinto.getStanzaVincente();
    }

    /**
     * Restituisce il giocatore.
     * @return il giocatore
     */
    public Giocatore getGiocatore() {
        return this.giocatore;
    }

    /**
     * Restituisce il labirinto.
     * @return il labirinto
     */
    public Labirinto getLabirinto() {
        return this.labirinto;
    }

    /**
     * Restituisce vero se e solo se la partita e' stata vinta.
     * La partita e' vinta quando il giocatore si trova nella stanza vincente.
     * @return true se la partita e' vinta
     */
    public boolean vinta() {
        return this.stanzaCorrente == this.labirinto.getStanzaVincente();
    }

    /**
     * Restituisce vero se e solo se la partita e' finita.
     * La partita finisce se: e' stata vinta, i CFU sono esauriti,
     * oppure e' stato esplicitamente chiamato setFinita().
     * @return true se la partita e' finita
     */
    public boolean isFinita() {
        return this.finita || this.vinta() || (this.giocatore.getCfu() == 0);
    }

    /**
     * Imposta la partita come finita (es. quando il giocatore usa il comando "fine").
     */
    public void setFinita() {
        this.finita = true;
    }

    /**
     * Restituisce i CFU del giocatore (metodo di comodo per accedere a Giocatore).
     * @return i CFU attuali
     */
    public int getCfu() {
        return this.giocatore.getCfu();
    }

    /**
     * Imposta i CFU del giocatore (metodo di comodo per accedere a Giocatore).
     * @param cfu il nuovo valore dei CFU
     */
    public void setCfu(int cfu) {
        this.giocatore.setCfu(cfu);
    }

    public boolean giocatoreIsVivo() {
        return this.giocatore.getCfu() > 0;
    }
}
