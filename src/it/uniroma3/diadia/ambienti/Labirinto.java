package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Labirinto - rappresenta il labirinto del gioco.
 * Ha la responsabilita' di creare tutte le stanze, collegarle tra loro
 * e memorizzare qual e' la stanza iniziale (entrata) e quella finale (uscita).
 *
 * @author studente
 * @version base
 */
public class Labirinto {

    private Stanza stanzaIniziale;
    private Stanza stanzaVincente;

    /**
     * Costruisce il labirinto creando e collegando tutte le stanze.
     */
    public Labirinto() {
        this.creaStanze();
    }

    /**
     * Crea tutte le stanze, le collega tra loro e posiziona gli attrezzi.
     */
    private void creaStanze() {

        /* crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        Attrezzo osso = new Attrezzo("osso", 1);

        /* crea le stanze del labirinto */
        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new Stanza("Laboratorio Campus");
        Stanza biblioteca = new Stanza("Biblioteca");

        /* collega le stanze tramite le direzioni */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);
        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);
        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
        laboratorio.impostaStanzaAdiacente("est", atrio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* posiziona gli attrezzi nelle stanze */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);

        /* imposta l'entrata e l'uscita del labirinto */
        this.stanzaIniziale = atrio;
        this.stanzaVincente = biblioteca;
    }

    /**
     * Restituisce la stanza iniziale (entrata) del labirinto.
     * @return la stanza di partenza
     */
    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    /**
     * Restituisce la stanza vincente (uscita) del labirinto.
     * @return la stanza che fa vincere la partita
     */
    public Stanza getStanzaVincente() {
        return this.stanzaVincente;
    }
}
