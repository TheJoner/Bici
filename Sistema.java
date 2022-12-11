import java.util.Date;

public class Sistema {
    //attributi
    private Bici[] biciclette;      //magazzino bici
    private SmartCard[] smartCards;
    private Stazione[] stazioni;
    private Noleggio[] noleggi;
    private int tB, tSM, tS, tN, tBPS;    //totali
    private int iSM = 0;                //indici
    private int iN = 0;                 //indici

    //eccezioni

    //metodi
    public Sistema(int tB, int tSM, int tS, int tN){
        this.tB = tB;
        biciclette = new Bici[tB];
        this.tSM = tSM;
        smartCards = new SmartCard[tSM];
        this.tS = tS;
        stazioni = new Stazione[tS];
        this.tN= tN;
        noleggi = new Noleggio[tN];

    }

    //creo le biciclette
    public void creaBici(){

        for(int i = 0; i < this.tB; i++){
            biciclette[i] = new Bici(i);
        }
    }
    
    //creo le stazioni
    public void creaStazioni(){
        for(int i = 0; i < this.tS; i++){
            stazioni[i] = new Stazione(i, tBPS, 0);
            
        }
    }

    //metto le Bici nelle stazioni e setto gli occupati
    public void mettiBiciInStazioni() {
        for(int i = 0; i < tB; i++){        //ciclo per le stazioni
            for(int o = 0; o < tS; o++){    //ciclo per le bici
                if(biciclette[o]!=null){
                    biciclette[o] = null;
                    stazioni[i].setBiciclettaS(i, o);
                }
            }
        }
        int occupatiS = 0;
        for(int o = 0; o < tS; o++){
            for(int i = 0; i < tBPS; i++){
                if(stazioni[i] != null){
                    occupatiS++;
                }
            }
            occupatiS = 0;
            stazioni[o]=stazioni[o].setOccupati(occupatiS);
        }
    }

    public void inserisciSmartCard(int credito, String nome, String cognome){
        //eccezione se arrivi al massimo di SmartCard

        //mette la SmarCard nel primo posto libero
        for(int i = 0; i < tSM; i++){
            if(smartCards[i] == null){
                iSM = i;
                break;
            }
        }

        smartCards[iSM] = new SmartCard(iSM, credito, nome, cognome);
        iSM++;
        
        String a = "Hai inserito la SmartCard di "+smartCards[iSM].getNominativo();
        System.out.println(a);
    }
    
    public void eliminaSmartCard(int codiceCard){
        String a = "Hai eliminato la SmartCard di "+smartCards[codiceCard].getNominativo();

        smartCards[codiceCard] = null;

        System.out.println(a);
    }

    public void ricaricaSmartCard(int codiceCard, int credito){
        smartCards[codiceCard] = smartCards[codiceCard].setCredito(credito);
    }


    public void eliminaStazione(int codiceStazione){
        String a = "Hai eliminato la Stazione "+smartCards[codiceStazione].getNominativo();

        stazioni[codiceStazione] = null;

        System.out.println(a);
    }

    public void creaNoleggio(int targa, int codiceCard, int stazionePartenza){
        //eccezione se arrivi al massimo di Noleggi
        //eccezione se c'é la bici (if "-1") allora la bici non è nella stazionePartenza
        
        if(stazioni[stazionePartenza].eQuaLaBici(targa) == false){
            //eccezione
            //la bici non è in quella stazione
        }
        
        stazioni[stazionePartenza].togliBici(stazionePartenza);
        Date dataInizio;
        dataInizio = new Date();
        noleggi[iN] = new Noleggio(dataInizio, targa, codiceCard, stazionePartenza);
        iN++;
    }

    public void fineNoleggio(Noleggio noleggioIniziato, int stazioneArrivo){
        Date dataFine;
        dataFine = new Date();
        noleggioIniziato.setDataFine(dataFine);
        noleggioIniziato.setaStazione(stazioneArrivo);
    }

    //le Bici
    public Bici[] getBiciclette() {
        return biciclette;
    }

    //le SmartCard
    public SmartCard[] getSmartCards() {
        return smartCards;
    }

    //quante bici ha la stazione in quel momento richiesta
    public int getPostiOStazione(int codiceStazione){
        int occupati = stazioni[codiceStazione].getOccupati();
        return occupati;
    }

    //quanti posti liberi
    public int getPostiLStazione(int codiceStazione){
        int liberi = stazioni[codiceStazione].getLiberi();
        return liberi;
    }

    //le stazioni
    public Stazione[] getStazioni() {
        return stazioni;
    }

    //i noleggi
    public Noleggio[] getNoleggi() {
        return noleggi;
    }

    //totale Bici
    public int gettB() {
        return tB;
    }

    //totale SmartCard
    public int gettSM() {
        return tSM;
    }

    //quante SmartCard possibili ancora
    public int getSmartCardPossibili(){
        int SMDisponibili = 0;
        SMDisponibili = tSM-iSM;
        return SMDisponibili;
    }
    //totale Stazioni
    public int gettS() {
        return tS;
    }

    //totale noleggi possibili
    public int gettN() {
        return tN;
    }

    //quanti noleggi possibili ancora
    public int getNoleggiDisponibili(){
        int noleggiDisponibili = 0;
        noleggiDisponibili = tN-iN;
        return noleggiDisponibili;
    }

    //restitruisci noleggio
    public Noleggio getNoleggioScelto(int posizioneNoleggio){
        return noleggi[posizioneNoleggio];
    }


    //quante SmartCard sono state create
    public int getiSM() {
        return iSM;
    }

    //di chi è la SmartCard
    public String getNomSmartCard(int codiceCard){
        String nominativo = smartCards[codiceCard].getNominativo();
        return nominativo;
    }

    //quanti Noleggi sono stati creati
    public int getiN() {
        return iN;
    }

    public String trovaBici(int targa){
        String posizioneBici = "La bici non esiste";
        for(int i = 0; i < tS; i++){
            for(int o = 0; o < tBPS; o++){
                if(stazioni[i].eQuaLaBici(targa) == true){
                    posizioneBici = "La bici di targa "+targa+" si trova nella stazione "+i;
                    return posizioneBici;
                }
            }
        }
        if(posizioneBici == "La bici non esiste"){
            for(int i = 0; i < tN; i++){
                if(noleggi[i].getTargaBici() == targa){
                    posizioneBici = "La bici è noleggiata a "+getNomSmartCard(noleggi[i].getSmartCard());
                }
            }
        }
        return posizioneBici;
    }

    //persona con + credito
    public String personaConCredito(){
        int credito = 0;
        String pCC = "";
        for(int i = 0; i < tSM; i++){
            if(smartCards[i].getCredito() > credito){
                credito = smartCards[i].getCredito();
                pCC = smartCards[i].getNominativo();
            }
        }
        return pCC;
    }
}