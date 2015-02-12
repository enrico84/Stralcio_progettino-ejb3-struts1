/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import service.CGestioneOrdini;
import entity.Cliente;
import entity.Ordine;
import entity.OrdineProdotto;
import entity.Prodotto;
import utility.Data;

/**
 *
 * @author Enrico
 */
public class MainGestioneOrdini {
    
    public static void main(String[] args){
        
        CGestioneOrdini sGO = new CGestioneOrdini();
        
        Ordine[] ordini = sGO.getOrdini();
        
//        stampaElencoOrdini(ordini);
        
        Cliente[] clienti = sGO.getClienti();
        
        Data data = new Data(2016, 10, 1);
        Data data1 = new Data(2016, 1, 31);
        
         //ATTENZIONE, nel DB l'Ordine è inserito solo se il numeroOrdine E'DIVERSO da quelli già inseriti!
//        Ordine ord1 = sGO.inserisciOrdine(5, data, "via Foro Italico", clienti[5]);
//        Ordine ord2 = sGO.inserisciOrdine(6, data1, "via Piazza di Spagna", clienti[6]);
        
        ordini = sGO.getOrdini();

//        stampaElencoOrdini(ordini);
        
//        Data data2 = new Data(2018, 2, 20);
//        sGO.modificaDataOrdine(ordini[5], data2);
//        sGO.modificaIndirizzoOrdine(ordini[5], "via Foro Italico 1");
//        sGO.eliminaOrdine(ordini[4]);
//        
//        ordini = sGO.getOrdini();
//        stampaElencoOrdini(ordini);
        
          Prodotto[] prodotti = sGO.getProdotti();  //prodotti per ordine
          
          //ATTENZIONE, nel DB non si possono inserire due Prodotti con lo stesso nome e costoUnitario
//        OrdineProdotto melaOrd = sGO.aggiungiProdottoOrdinato(3, 1.5, ordini[4], prodotti[0]);    
//        OrdineProdotto peraOrd = sGO.aggiungiProdottoOrdinato(4, 1.5, ordini[5], prodotti[1]);
//          OrdineProdotto bananaOrd = sGO.aggiungiProdottoOrdinato(1, 1.1, ordini[4], prodotti[3]);
//          OrdineProdotto angOrd = sGO.aggiungiProdottoOrdinato(1, 2.0, ordini[4], prodotti[2]);
          
//        OrdineProdotto[] prodottoOrd4 = sGO.getProdotti(ordini[4]);
//        OrdineProdotto[] prodottoOrd5 = sGO.getProdotti(ordini[5]);
//        stampaDettaglioOrdine(ordini[4]);
//        stampaDettaglioOrdine(ordini[5]);
//       
        //Funziona OK
//        sGO.eliminaProdottoOrdinato(prodottoOrd5[0]);
//        stampaDettaglioOrdine(ordini[5]);
        
        //Funziona Ok
//        sGO.modificaOrdine(ordini[4], prodottoOrd4[1], 3);
//        sGO.modificaProdottoOrdinato(ordini[4], prodottoOrd4[0], 1.3);
//          stampaDettaglioOrdine(ordini[4]);
          
          
//          OrdineProdotto melaOrd = sGO.aggiungiProdottoOrdinato(1, 1.5, ordini[2], prodotti[0]);    
//          OrdineProdotto peraOrd = sGO.aggiungiProdottoOrdinato(1, 1.5, ordini[2], prodotti[1]);
           stampaDettaglioOrdine(ordini[2]);
           sGO.eliminaOrdine(ordini[2]);
           stampaElencoOrdini(ordini);
           
//           ordini[1].getProdottiAcquistati();
    }
    
    
     public static void stampaElencoOrdini(Ordine[] ordini)
     {
           System.out.println("***************** Elenco ORDINI *******************");
            for(Ordine ord : ordini)
            {
                System.out.println("Numero ordine " +ord.getNumeroOrdine());
                if(ord.getDataSpedizione() != null)
                { 
                    System.out.println("Data spedizione: ");
                    stampaDataSpedizione(ord.getDataSpedizione());
                }
                if(ord.getIndirizzo() != null)
                {
                    System.out.println("Indirizzo di spedizione: " +
                                            ord.getIndirizzo()); 
                }
                System.out.println("Cliente: " +ord.getCliente().getNome()+" " 
                        +ord.getCliente().getCognome());
                System.out.println();
            }    
        System.out.println("***************************************************");
     }
     
     
     public static void stampaDettaglioOrdine(Ordine ordine)
     {
         
        CGestioneOrdini sGO = new CGestioneOrdini();
        
        System.out.println("******************* Dettaglio ORDINE *******************");
        System.out.println("Numero ordine:"+ordine.getNumeroOrdine());
        if(ordine.getIndirizzo() != null)
        {
             System.out.print("Indirizzo di spedizione: " +ordine.getIndirizzo());
        }
        if(ordine.getDataSpedizione() != null)
        {
            System.out.println();
            System.out.print("Data: " +ordine.getDataSpedizione());     
        }
        System.out.println();
        MainGestioneClienti.stampaInfoCliente(ordine.getCliente());
        
        if(sGO.getProdotti(ordine).length > 0 )
        {        
            stampaProdottiAcquistati(ordine);
        }
        System.out.println("********************************************************");
         
     }
     
     
     public static void stampaProdottiAcquistati(Ordine ordine){
         CGestioneOrdini sGO = new CGestioneOrdini();
         OrdineProdotto op;
         int size=sGO.getProdotti(ordine).length;
 
         System.out.println("Prodotti acquistati: " +size);
            for(int i=0; i<size; i++)
            {       
                op = (OrdineProdotto)sGO.getProdotti(ordine)[i];
                System.out.println("Prodotto: " +op.getProdotto().getDescrizione()+ ", quantita':" +op.getQuantita()+ 
                        ", " +op.getProdotto().getUnitaMisura()+ ", costo ordine: " +op.getCostoUnitario()+"€");              
            }
     }
     
     
     private static void stampaDataSpedizione(Data dataSpedizione)
     {
         System.out.println(dataSpedizione.toString());
     }
    
}
