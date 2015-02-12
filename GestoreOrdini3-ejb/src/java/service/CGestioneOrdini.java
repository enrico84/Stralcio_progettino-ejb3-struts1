/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Cliente;
import entity.Ordine;
import entity.OrdineProdotto;
import entity.Prodotto;
import gestoreordini.service.ejb.GestioneOrdiniRemote;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import utility.Data;
import utility.Lista;

/**
 *
 * @author Enrico
 */
public class CGestioneOrdini {
    
    private GestioneOrdiniRemote gestioneOrdini;
    
    public CGestioneOrdini() throws RuntimeException {
        try
        {
            gestioneOrdini = (GestioneOrdiniRemote) new InitialContext().
                    lookup("gestoreordini.service.ejb.GestioneOrdiniRemote");   
        }
        catch(NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    public Ordine[] getOrdini(){
        return gestioneOrdini.getOrdini();
    }
    
    
    public Ordine inserisciOrdine(int numeroOrdine, Data dataSpedizione,
                            String indirizzo, Cliente cliente) {
        
        return gestioneOrdini.inserisciOrdine(numeroOrdine, dataSpedizione, indirizzo, cliente);
    }
    
    
     public int verificaDisponibilita(Prodotto p) {
         return gestioneOrdini.verificaDisponibilita(p);
     }
     
     
     public void modificaIndirizzoOrdine(Ordine ordine, String indirizzo)
     {
         gestioneOrdini.modificaIndirizzoOrdine(ordine, indirizzo);
     }
     
     
     public void modificaDataOrdine(Ordine ordine, Data dataSpedizione)
     {
         gestioneOrdini.modificaDataOrdine(ordine, dataSpedizione);
     }
     
     
     public Cliente[] getClienti()
     {
         return gestioneOrdini.getClienti();
     }
     
     
     public Prodotto[] getProdotti()
     {
         return gestioneOrdini.getProdotti();
     }
     
     
     //CONTROLLARE questo metodo che ritorna "List" nei progetti vecchi  
//     public List getProdotti(int codice){
//         return gestioneOrdini.getProdotti(codice);
//     }
//     
     //Dato un ordine specifico, ritorna un array di prodotti ordinati
     public OrdineProdotto[] getProdotti(Ordine ordine)
     {
         return gestioneOrdini.getProdotti(ordine);
     }
     
     
    public OrdineProdotto aggiungiProdottoOrdinato(Integer quantita, Double costoUnitario, Ordine ordine, Prodotto prodotto)
     {
         return gestioneOrdini.aggiungiProdottoOrdinato(quantita, costoUnitario, ordine, prodotto);
     }
    
    //MODIFICO SOLO LA QUANTITA' DEL PRODOTTO ORDINATO
    public void modificaOrdine(Ordine ordine, OrdineProdotto ordProd, int quantita)
    {
        gestioneOrdini.modificaOrdine(ordine, ordProd, quantita);
    }
     
    public void modificaProdottoOrdinato(Ordine ordine, OrdineProdotto ordProd, double costoUnitario)
    {
        gestioneOrdini.modificaProdottoOrdinato(ordine, ordProd, costoUnitario);
    }
     
    public void eliminaProdottoOrdinato(OrdineProdotto ordProd)
    {
        gestioneOrdini.eliminaProdottoOrdinato(ordProd);
    }
    
    
    //FARE l'eliminazione a catena dei prodottiOrdinati nella classe GestioneOrdini
     public void eliminaOrdine(Ordine ordine)
     {
         gestioneOrdini.eliminaOrdine(ordine);
     }
        
}
