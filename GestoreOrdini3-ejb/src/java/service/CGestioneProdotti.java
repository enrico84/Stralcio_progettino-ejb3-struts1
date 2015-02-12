/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Prodotto;
import gestoreordini.service.ejb.GestioneProdottiRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Enrico
 */
public class CGestioneProdotti {
    
    private GestioneProdottiRemote gestioneProdotti;
    
    public CGestioneProdotti() throws RuntimeException {
        try  {
            gestioneProdotti = (GestioneProdottiRemote)new InitialContext().lookup("gestoreordini.service.ejb.GestioneProdottiRemote");
        }
        catch(NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    public Prodotto[] getProdotti(){
        return gestioneProdotti.getProdotti();
    }
    
    
    public Prodotto getProdotto(Prodotto p){
        return gestioneProdotti.getProdotto(p);
    }
    
    
    public Prodotto inserisciProdotto(String codice, Double costoUnitario, String descrizione, 
            String unitaMisura, Integer disponibilita)
    {
        return gestioneProdotti.inserisciProdotto(codice, costoUnitario, descrizione, unitaMisura, disponibilita);
    }
    
    
    public Prodotto inserisciProdotto(String codice)
    {
        return gestioneProdotti.inserisciProdotto(codice);
    }
    
    
    //Sfrutto l'overload
    public void modificaProdotto(Prodotto prodotto, Double costoUnitario, Integer disponibilita)
    {
        if(costoUnitario > 0 && disponibilita >=0)
        {
            gestioneProdotti.modificaProdotto(prodotto, costoUnitario, disponibilita);
        }
         else
        {
            System.out.println("Inserire un costo o una disponibilità positiva per il prodotto!");
            return;
        }
//        if(disponibilita >= 0)
//        {
//            gestioneProdotti.modificaProdotto(prodotto, disponibilita);
//        }
//        else {
//            System.out.println("Inserire una disponibilità almeno di 0 per il prodotto!");
//            return;
//        }
    }
    
//     //Sfrutto l'overload
//     public void modificaProdotto(Prodotto prodotto, Integer disponibilita)
//    {
//         if(disponibilita >= 0)
//        {
//            gestioneProdotti.modificaProdotto(prodotto, disponibilita);
//        }
//          else
//        {
//            System.out.println("Inserire una disponibilità almeno di 0 per il prodotto!");
//            return;
//        }       
//    }
     
     
//    //Sfrutto l'overload
//    public void modificaProdotto(Prodotto prodotto, Double costoUnitario)
//    {
//         if(costoUnitario > 0)
//        {
//            gestioneProdotti.modificaProdotto(prodotto, costoUnitario);
//        }
//        else
//        {
//            System.out.println("Inserire un costo positivo per il prodotto!");
//            return;
//        }
//    }
    
    
     public void eliminaProdotto(Prodotto prodotto)
    {
        gestioneProdotti.eliminaProdotto(prodotto);
    }
    
}
