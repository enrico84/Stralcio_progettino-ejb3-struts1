/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import service.CGestioneProdotti;
import entity.OrdineProdotto;
import entity.Prodotto;

/**
 *
 * @author Enrico
 */
public class MainGestioneProdotti {
    
     public static void main(String[] args)
    {
        CGestioneProdotti cGP = new CGestioneProdotti();
        
        //Attenzione, nel DB il Prodotto è inserito solo se il il CODICE e la DESCRIZIONE
        //sono diversi da quelli già inseriti!
        Prodotto[] p = cGP.getProdotti();
//        cGP.inserisciProdotto("000", 2, "mela", "1 kg", 20);
//        cGP.inserisciProdotto("001", 1.5, "pera", "1kg", 15);
//        cGP.inserisciProdotto("002", 4, "anguria", "6kg", 10);
//          cGP.inserisciProdotto("004", 1.0, "patate", "2kg", 60);
      
          p=cGP.getProdotti();
//          stampaElencoProdotti(p);
//        
//        stampaDettaglioProdotto(p[0]);
//        stampaDettaglioProdotto(p[2]);
//        stampaDettaglioProdotto(p[7]);
          
//          Sfrutto l'overload
        cGP.modificaProdotto(p[5], 2.0, 40);
         p=cGP.getProdotti();
        stampaDettaglioProdotto(p[5]);
        
//        cGP.modificaProdotto(p[5], 37);
////        p=cGP.getProdotti();
//        stampaDettaglioProdotto(p[5]);
//
//        cGP.modificaProdotto(p[5], 1.1);
//        stampaDettaglioProdotto(p[5]);
        
//        stampaElencoProdotti(p);
//        cGP.eliminaProdotto(p[3]);
//        p=cGP.getProdotti();
//        stampaElencoProdotti(p);

//        cGP.modificaProdotto(p[1], 1.5, 35);
//        stampaElencoProdotti(p);
    
    }
    
    
     public static void stampaElencoProdotti(Prodotto[] p)
    {
        System.out.println("---------- Elenco Prodotti ----------");
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getDescrizione());
        }
        System.out.println("-------------------------------------");
    }
    
    
    public static void stampaDettaglioProdotto(Prodotto p)
    {
        System.out.println("---------- Dettaglio Prodotto ----------");
        System.out.println(p.getCodice()+ "\n" + p.getDescrizione()+ "\nPeso singolo pezzo " + p.getUnitaMisura()+ 
                "\nCosto singolo pezzo: " +p.getCostoUnitario()+ "\n" + 
                "Disponibilità attuale: " +p.getDisponibilita());
        System.out.println("-------------");
    }
    
    //Da usare SOLO in MainGestioneOrdini.stampaDettaglioOrdine per stampare 
    //il nome dei prodotti acquistati per ordine
    public static void stampaNomeProdotto(Prodotto p)
    {
        System.out.println("Nome prodotto acquistato: "+ p.getDescrizione());
    }
    
    
//    public static void stampaDettaglioProdottoAcquistato(OrdineProdotto op)
//    {
//        System.out.println("---------- Dettaglio Prodotto acquistato ----------");
//        
//        System.out.println("Quantità acquistata: " +op.getQuantita()+ "\n" + "Costo pagato: " +op.getCostoUnitario());
//                            
//        //stampaDettaglioProdotto(op.getProdotto_id());
////                "\nPeso singolo pezzo " + p.getUnitaMisura()+ 
////                "\nCosto singolo pezzo: " +p.getCostoUnitario()+ "\n" + 
////                "Disponibilità attuale: " +p.getDisponibilita());
//        System.out.println("-------------------------------------");
//    }
    
}
