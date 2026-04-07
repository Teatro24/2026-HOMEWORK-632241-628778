package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Classe IOConsole - centralizza tutta la gestione dell'input e dell'output.
 * Invece di usare System.out e System.in direttamente in tutto il codice,
 * si usa questa classe come unico punto di accesso all'I/O.
 *
 *
 * @author docente di POO
 * @version base
 */
public class IOConsole {

    /**
     * Stampa un messaggio a video andando a capo alla fine.
     * @param msg il messaggio da mostrare
     */
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }

    /**
     * Legge una riga di testo inserita dall'utente da tastiera.
     * @return la riga letta come stringa
     */
    public String leggiRiga() {
        Scanner scannerDiLinee = new Scanner(System.in);
        String riga = scannerDiLinee.nextLine();
        
     // scannerDiLinee.close(); // omesso come indicato nel PowerPoint
  
        return riga;
        
        
    }
}
