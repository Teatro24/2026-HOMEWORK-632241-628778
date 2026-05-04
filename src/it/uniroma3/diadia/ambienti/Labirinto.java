package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Labirinto - rappresenta il labirinto del gioco.
 * Il labirinto include stanze normali e stanze speciali:
 * StanzaMagica, StanzaBuia, StanzaBloccata.
 *
 * Mappa del labirinto:
 *
 *                  [Biblioteca] <- stanza vincente
 *                       |
 *                    (nord)
 *                       |
 *             [Corridoio Segreto] <- StanzaBloccata (serve: passepartout)
 *                       |
 *                    (nord)
 *                       |
 *             [Corridoio Magico] <- StanzaMagica
 *                       |
 *                    (nord)
 *                       |
 *   [Laboratorio] -ovest-[Atrio]-est- [Aula N11]
 *                       |
 *                    (sud)
 *                       |
 *                  [Aula N10] <- StanzaBuia (serve: lanterna nella stanza)
 *
 * Oggetti:
 *   Atrio        : osso
 *   Aula N11     : passepartout  <- serve per sbloccare Corridoio Segreto
 *   Laboratorio  : lanterna      <- serve per illuminare Aula N10
 */
public class Labirinto {

    private Stanza stanzaIniziale;
    private Stanza stanzaVincente;

    public Labirinto() {
        this.creaStanze();
    }

    private void creaStanze() {

        /* attrezzi */
        Attrezzo osso          = new Attrezzo("osso", 1);
        Attrezzo lanterna      = new Attrezzo("lanterna", 3);
        Attrezzo passepartout  = new Attrezzo("passepartout", 1);

        /* stanze normali */
        Stanza atrio      = new Stanza("Atrio");
        Stanza aulaN11    = new Stanza("Aula N11");
        Stanza laboratorio = new Stanza("Laboratorio Campus");
        Stanza biblioteca  = new Stanza("Biblioteca");

        /* stanza speciale: buia (serve lanterna NELLA stanza per vederci) */
        StanzaBuia aulaN10 = new StanzaBuia("Aula N10", "lanterna");

        /* stanza speciale: magica (ogni 3 passaggi inverte la direzione) */
        StanzaMagica corridoioMagico = new StanzaMagica("Corridoio Magico");

        /* stanza speciale: bloccata (serve passepartout NELLA stanza per andare a nord) */
        StanzaBloccata corridoioSegreto = new StanzaBloccata("Corridoio Segreto", "nord", "passepartout");

        /* collegamenti */
        atrio.impostaStanzaAdiacente("nord", corridoioMagico);
        atrio.impostaStanzaAdiacente("est",  aulaN11);
        atrio.impostaStanzaAdiacente("sud",  aulaN10);
        atrio.impostaStanzaAdiacente("ovest", laboratorio);

        corridoioMagico.impostaStanzaAdiacente("nord", corridoioSegreto);
        corridoioMagico.impostaStanzaAdiacente("sud",  atrio);

        corridoioSegreto.impostaStanzaAdiacente("nord", biblioteca);
        corridoioSegreto.impostaStanzaAdiacente("sud",  corridoioMagico);

        aulaN11.impostaStanzaAdiacente("est",  laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);

        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est",  aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);

        laboratorio.impostaStanzaAdiacente("est",  atrio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);

        biblioteca.impostaStanzaAdiacente("sud", corridoioSegreto);

        /* posizionamento attrezzi */
        atrio.addAttrezzo(osso);
        aulaN11.addAttrezzo(passepartout);      // passepartout per sbloccare il Corridoio Segreto
        laboratorio.addAttrezzo(lanterna);      // lanterna per illuminare Aula N10

        this.stanzaIniziale = atrio;
        this.stanzaVincente = biblioteca;
    }

    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    public Stanza getStanzaVincente() {
        return this.stanzaVincente;
    }
}
