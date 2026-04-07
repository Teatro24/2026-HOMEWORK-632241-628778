package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale del gioco DiaDia, un semplice gioco di ruolo ambientato al DIA.
 * Per giocare bisogna creare un'istanza di questa classe e chiamare il metodo gioca().
 *
 * Questa classe gestisce il ciclo principale del gioco e l'esecuzione dei comandi.
 * L'I/O e' centralizzato nell'istanza di IOConsole ricevuta dal costruttore.
 *
 * @author studente
 * (da un'idea di Michael Kolling and David J. Barnes)
 * @version base
 */
public class DiaDia {

    static final private String MESSAGGIO_BENVENUTO = "" +
            "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
            "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n" +
            "I locali sono popolati da strani personaggi, " +
            "alcuni amici, altri... chissa'!\n" +
            "Ci sono attrezzi che potrebbero servirti nell'impresa:\n" +
            "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
            "o regalarli se pensi che possano ingraziarti qualcuno.\n\n" +
            "Per conoscere le istruzioni usa il comando 'aiuto'.";

    static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

    private Partita partita;
    private IOConsole io;

    /**
     * Crea una nuova istanza del gioco con la console di I/O specificata.
     * @param io l'unica istanza di IOConsole usata per tutto l'I/O del gioco
     * 
     * !!!test levo paramentro formale IOConsole io da DIADIA e lo metto in gioca
     */
    public DiaDia() {
        this.partita = new Partita();
        //this.io = io;
    }

    /**
     * Avvia e gestisce il ciclo principale del gioco:
     * mostra il benvenuto e continua a leggere comandi finche' la partita non finisce.
     */
    public void gioca(IOConsole io) {
    	this.io = io;
        String istruzione;
        this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
        this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
        do {
            istruzione = this.io.leggiRiga();
        } while (!processaIstruzione(istruzione));
    }

    /**
     * Processa una istruzione inserita dal giocatore.
     * @param istruzione la stringa digitata dall'utente
     * @return true se il gioco deve terminare, false se deve continuare
     */
    private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire = new Comando(istruzione);

        if (comandoDaEseguire.getNome() == null) {
            this.io.mostraMessaggio("Comando non riconosciuto.");
            return false;
        }

        switch (comandoDaEseguire.getNome()) {
            case "fine":
                this.fine();
                return true;
            case "vai":
                this.vai(comandoDaEseguire.getParametro());
                break;
            case "aiuto":
                this.aiuto();
                break;
            case "prendi":
                this.prendi(comandoDaEseguire.getParametro());
                break;
            case "posa":
                this.posa(comandoDaEseguire.getParametro());
                break;
            default:
                this.io.mostraMessaggio("Comando sconosciuto.");
        }

        if (this.partita.vinta()) {
            this.io.mostraMessaggio("Hai vinto!");
            return true;
        }
        if (this.partita.getCfu() == 0) {
            this.io.mostraMessaggio("Hai esaurito i CFU. Hai perso!");
            return true;
        }
        return false;
    }

    /**
     * Mostra i comandi disponibili.
     */
    private void aiuto() {
        StringBuilder sb = new StringBuilder("Comandi disponibili: ");
        for (String cmd : elencoComandi)
            sb.append(cmd + "  ");
        this.io.mostraMessaggio(sb.toString());
    }

    /**
     * Sposta il giocatore nella direzione indicata, se esiste.
     * Ad ogni spostamento vengono sottratti 1 CFU.
     * @param direzione la direzione verso cui spostarsi
     */
    private void vai(String direzione) {
        if (direzione == null) {
            this.io.mostraMessaggio("Dove vuoi andare? Specifica una direzione.");
            return;
        }
        Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
        if (prossimaStanza == null) {
            this.io.mostraMessaggio("Direzione inesistente.");
        } else {
            this.partita.setStanzaCorrente(prossimaStanza);
            this.partita.setCfu(this.partita.getCfu() - 1);
        }
        this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
    }

    /**
     * Prende un attrezzo dalla stanza corrente e lo mette nella borsa del giocatore.
     * @param nomeAttrezzo il nome dell'attrezzo da prendere
     */
    private void prendi(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            this.io.mostraMessaggio("Quale attrezzo vuoi prendere?");
            return;
        }
        Stanza stanzaCorrente = this.partita.getStanzaCorrente();
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
        if (attrezzo == null) {
            this.io.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non si trova in questa stanza.");
            return;
        }
        Borsa borsa = this.partita.getGiocatore().getBorsa();
        if (borsa.addAttrezzo(attrezzo)) {
            stanzaCorrente.removeAttrezzo(attrezzo);
            this.io.mostraMessaggio("Hai preso: " + attrezzo.getNome());
            this.io.mostraMessaggio(borsa.toString());
        } else {
            this.io.mostraMessaggio("Non puoi prendere '" + nomeAttrezzo + "': la borsa e' piena o l'attrezzo e' troppo pesante.");
        }
    }

    /**
     * Posa un attrezzo dalla borsa del giocatore nella stanza corrente.
     * @param nomeAttrezzo il nome dell'attrezzo da posare
     */
    private void posa(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            this.io.mostraMessaggio("Quale attrezzo vuoi posare?");
            return;
        }
        Borsa borsa = this.partita.getGiocatore().getBorsa();
        Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
        if (attrezzo == null) {
            this.io.mostraMessaggio("L'attrezzo '" + nomeAttrezzo + "' non e' nella tua borsa.");
            return;
        }
        this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
        this.io.mostraMessaggio("Hai posato: " + attrezzo.getNome());
        this.io.mostraMessaggio(borsa.toString());
    }

    /**
     * Esegue il comando "fine": termina il gioco.
     */
    private void fine() {
        this.io.mostraMessaggio("Grazie di aver giocato!");
    }

    /**
     * Punto di ingresso del programma.
     * Crea UNA SOLA istanza di IOConsole e la passa al gioco.
     */
    public static void main(String[] args) {
        IOConsole io = new IOConsole();
        DiaDia gioco = new DiaDia();
        gioco.gioca(io);
    }
}
