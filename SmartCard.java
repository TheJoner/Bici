public class SmartCard {
    //attributi
    private int codice;
    private int attivazioni = 0;
    private int credito;
    private String nominativo;

    //metodi
    public SmartCard(int codice, int credito, String nome, String cognome) {
        this.codice = codice;
        this.credito = credito;
        this.nominativo = nome+" "+cognome;
    }

    public int getCodice() {
        return codice;
    }

    public int getAttivazioni() {
        return attivazioni;
    }

    public void setAttivazioni() {
        this.attivazioni ++;
    }

    public int getCredito() {
        return credito;
    }

    public SmartCard setCredito(int credito) {
        this.credito = credito;
        return null;
    }

    public String getNominativo() {
        return nominativo;
    }  

}