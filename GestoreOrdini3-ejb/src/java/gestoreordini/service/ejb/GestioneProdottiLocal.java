/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestoreordini.service.ejb;

import entity.Prodotto;
import javax.ejb.Local;

/**
 *
 * @author Enrico
 */
@Local
public interface GestioneProdottiLocal {
    
    public Prodotto[] getProdotti();
    
    public Prodotto getProdotto(Prodotto p);
     
    public Prodotto inserisciProdotto(String codice, Double costoUnitario, String descrizione, 
            String unitaMisura, Integer disponibilita);
    
    public Prodotto inserisciProdotto(String codice);
    
    public void modificaProdotto(Prodotto prodotto, Double costoUnitario, Integer disponibilita);
    
//    public void modificaProdotto(Prodotto prodotto, Integer disponibilita);
//    
//    public void modificaProdotto(Prodotto prodotto, Double costoUnitario);
    
    public void eliminaProdotto(Prodotto prodotto);
}
