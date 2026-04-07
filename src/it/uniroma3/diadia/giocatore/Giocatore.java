package it.uniroma3.diadia.giocatore;

/**
 * Classe Giocatore - rappresenta il giocatore del gioco DiaDia.
 * Ha la responsabilita' di gestire i CFU del giocatore e di
 * memorizzare gli attrezzi raccolti in una Borsa.
 *
 * @author studente
 * @version base
 */
public class Giocatore {

    private static final int CFU_INIZIALI = 20;

    private int cfu;
    private Borsa borsa;

    /**
     * Crea un nuovo giocatore con i CFU iniziali e una borsa vuota.
     */
    public Giocatore() {
        this.cfu = CFU_INIZIALI;
        this.borsa = new Borsa();
    }

    /**
     * Restituisce i CFU attuali del giocatore.
     * @return il numero di CFU
     */
    public int getCfu() {
        return this.cfu;
    }

    /**
     * Imposta i CFU del giocatore.
     * @param cfu il nuovo valore dei CFU
     */
    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    /**
     * Restituisce la borsa del giocatore.
     * @return la borsa con gli attrezzi raccolti
     */
    public Borsa getBorsa() {
        return this.borsa;
    }
}
