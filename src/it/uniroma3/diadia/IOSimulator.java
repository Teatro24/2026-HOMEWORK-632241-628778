package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

    private String[] righeInput;
    private int indiceLettura;
    private List<String> messaggiOutput;

    public IOSimulator(String[] righeInput) {
        this.righeInput = righeInput;
        this.indiceLettura = 0;
        this.messaggiOutput = new ArrayList<>();
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiOutput.add(messaggio);
    }

    @Override
    public String leggiRiga() {
        if (this.indiceLettura < this.righeInput.length) {
            return this.righeInput[this.indiceLettura++];
        }
        return "fine";
    }

    public List<String> getMessaggi() {
        return this.messaggiOutput;
    }

    public List<String> getMessaggiOutput() {
        return this.messaggiOutput;
    }

    public String getMessaggio(int indice) {
        return this.messaggiOutput.get(indice);
    }

    public int getNumeroMessaggi() {
        return this.messaggiOutput.size();
    }
}
