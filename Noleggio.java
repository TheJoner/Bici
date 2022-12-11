import java.time.LocalDate;

public class Noleggio {
    //attributi
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private int targaBici;
    private int smartCard;
    private int daStazione;
    private int aStazione;

    //metodi
    public Noleggio(LocalDate dataInizio, int targaBici, int codiceCard, int daStazione) {
        this.dataInizio = dataInizio;
        this.targaBici = targaBici;
        smartCard = codiceCard;
        this.daStazione = daStazione;

    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
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