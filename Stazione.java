public class Stazione {
    //attributi
    private int codice;
    private final int totPosti;
    private int occupati;
    private Bici[] bicicletteS;

    //metodi
    public Stazione(int codice, int totPosti, int occupati) {
        this.codice = codice;
        this.occupati = occupati;
        this.totPosti = totPosti;
        bicicletteS = new Bici[totPosti];
    }

    public int getCodice() {
        return codice;
    }

    public int getTotPosti() {
        return totPosti;
    }

    public int getOccupati() {
        for(int i = 0; i < totPosti; i++){
            if(bicicletteS[i] == null){
                this.occupati++;
            }
        }
        return this.occupati;
    }

    public int getLiberi(){
        int postiLiberi = 0;
        for(int i = 0; i < totPosti; i++){
            if(bicicletteS[i]!=null){
                postiLiberi++;
            }
        }
        return postiLiberi;
    }
    
    public Stazione setOccupati(int occupati) {
        this.occupati = occupati;
        return null;
    }

    public Bici[] getBiciclette() {
        return bicicletteS;
    }

    public void setBiciclettaS(int posizioneBici, int targaBici) {
        bicicletteS[posizioneBici] = new Bici(targaBici);
    }
    
    public void togliBici(int posizioneBici){

        bicicletteS[posizioneBici] = null;
    }

    //posizione bici
    public int getPoisioneBici(int targa){
        int posizioneBici = -1;
        for(int i = 0; i < totPosti; i ++){
            if(bicicletteS[i].getTarga() == targa){
                posizioneBici = i;
            }
        }
        return posizioneBici;
    }

    //la bici si trova qua
    public boolean eQuaLaBici(int targa){
        boolean o = false;
        for(int i = 0; i < totPosti; i ++){
            if(bicicletteS[i].getTarga() == targa){
                o = true;
            }
        }
        return o;
    }
}