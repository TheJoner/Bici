import java.util.Date;

public class Noleggio {
    //attributi
    private Date dataInizio, dataFine;
    private int targaBici;
    private int smartCard;
    private int daStazione;
    private int aStazione;

    //metodi
    public Noleggio(Date dataOggi, int targaBici, int codiceCard, int daStazione) {
        dataInizio = dataOggi;
        this.targaBici = targaBici;
        smartCard = codiceCard;
        this.daStazione = daStazione;

    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public int getTargaBici() {
        return targaBici;
    }

    public int getSmartCard() {
        return smartCard;
    }

    public int getDaStazione() {
        return daStazione;
    }

    public int getaStazione() {
        return aStazione;
    }

    public void setaStazione(int aStazione) {
        this.aStazione = aStazione;
    }
}