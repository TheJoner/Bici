public class Main {
    public static void main(String[] args) {
        Sistema comune = new Sistema(100, 100, 10, 100, 10);
        comune.creaBici();                  //creo le bici da mettere nelle stazioni
        comune.creaStazioni();              //creo le stazioni
        comune.mettiBiciInStazioni();       //metto le bici nele stazioni (quelle che posso)

        //inserisco samrtCard 1,2,3
        comune.inserisciSmartCard(10, "nome1", "cognome1");
        comune.inserisciSmartCard(10, "nome2", "cognome2");
        comune.inserisciSmartCard(10, "nome3", "cognome3");

        //elimino smartCard 1
        comune.eliminaSmartCard(0);
        comune.inserisciSmartCard(10, "nome4", "cognome4");
        comune.getNomSmartCard(0);
        comune.getNomSmartCard(1);
        comune.getNomSmartCard(2);
        
        //prendo una bici
        comune.creaNoleggio(0, 1, 0);
        comune.trovaBici(0);
        
    }
}