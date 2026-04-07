package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Borsa - rappresenta la borsa del giocatore.
 * Contiene gli attrezzi raccolti e ha un peso massimo che non puo' essere superato.
 *
 * @author studente
 * @version base
 */
public class Borsa {

    public final static int DEFAULT_PESO_MAX_BORSA = 10;

    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;
    private int pesoMax;

    /**
     * Crea una borsa con peso massimo di default.
     */
    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    /**
     * Crea una borsa con un peso massimo specificato.
     * @param pesoMax il peso massimo che la borsa puo' contenere
     */
    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new Attrezzo[10]; //speriamo bastino...
        this.numeroAttrezzi = 0;
    }

    /**
     * Aggiunge un attrezzo alla borsa se non si supera il peso massimo.
     * @param attrezzo l'attrezzo da aggiungere
     * @return true se l'attrezzo e' stato aggiunto, false altrimenti
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        if (this.numeroAttrezzi == 10)
            return false;
        this.attrezzi[this.numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
        return true;
    }

    /**
     * Restituisce il peso massimo della borsa.
     * @return il peso massimo
     */
    public int getPesoMax() {
        return this.pesoMax;
    }

    /**
     * Cerca e restituisce un attrezzo nella borsa in base al nome.
     * @param nomeAttrezzo il nome dell'attrezzo da cercare
     * @return l'attrezzo trovato, null se non esiste
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++)
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
                return this.attrezzi[i];
        return null;
    }

    /**
     * Calcola e restituisce il peso totale degli attrezzi nella borsa.
     * @return il peso totale
     */
    public int getPeso() {
        int peso = 0;
        for (int i = 0; i < this.numeroAttrezzi; i++)
            peso += this.attrezzi[i].getPeso();
        return peso;
    }

    /**
     * Controlla se la borsa e' vuota.
     * @return true se non ci sono attrezzi, false altrimenti
     */
    public boolean isEmpty() {
        return this.numeroAttrezzi == 0;
    }

    /**
     * Controlla se un attrezzo con il nome indicato e' presente nella borsa.
     * @param nomeAttrezzo il nome dell'attrezzo da cercare
     * @return true se l'attrezzo e' presente, false altrimenti
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    /**
     * Rimuove dalla borsa l'attrezzo con il nome indicato e lo restituisce.
     * @param nomeAttrezzo il nome dell'attrezzo da rimuovere
     * @return l'attrezzo rimosso, null se non trovato
     */
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                Attrezzo rimosso = this.attrezzi[i];
                this.attrezzi[i] = this.attrezzi[this.numeroAttrezzi - 1];
                this.attrezzi[this.numeroAttrezzi - 1] = null;
                this.numeroAttrezzi--;
                return rimosso;
            }
        }
        return null;
    }

    /**
     * Restituisce una rappresentazione stringa della borsa con il suo contenuto.
     * @return la rappresentazione stringa
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (!this.isEmpty()) {
            s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (int i = 0; i < this.numeroAttrezzi; i++)
                s.append(this.attrezzi[i].toString() + " ");
        } else {
            s.append("Borsa vuota");
        }
        return s.toString();
    }
}
