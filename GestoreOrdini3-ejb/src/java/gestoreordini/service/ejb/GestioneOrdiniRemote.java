/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestoreordini.service.ejb;

import entity.Cliente;
import entity.Ordine;
import entity.OrdineProdotto;
import entity.Prodotto;
import java.util.List;
import javax.ejb.Remote;
import utility.Data;
import utility.Lista;

/**
 *
 * @author Enrico
 */
@Remote
public interface GestioneOrdiniRemote {
    
    public Ordine[] getOrdini();
    
    public Ordine inserisciOrdine(int numeroOrdine, Data dataSpedizione,
                            String indirizzo, Cliente cliente);
    
    public int verificaDisponibilita(Prodotto p);
    
    public void modificaIndirizzoOrdine(Ordine ordine, String indirizzo);
    
    public void modificaDataOrdine(Ordine ordine, Data dataSpedizione);
     
    public Cliente[] getClienti();
     
    public Prodotto[] getProdotti();
    
    //Torna una lista di prodotti dell'ordine
//    public List getProdotti(int codice);
    
    //Dato un ordine specifico, ritorna un array di prodotti ordinati
    public OrdineProdotto[] getProdotti(Ordine ordine);
    
    public void eliminaOrdine(Ordine ordine);
    
    public OrdineProdotto aggiungiProdottoOrdinato(Integer quantita, Double costoUnitario, Ordine ordine, Prodotto prodotto);
    
    //MODIFICO SOLO LA QUANTITA' DEL PRODOTTO ORDINATO
    public void modificaOrdine(Ordine ordine, OrdineProdotto ordProd, int quantita);
     
    public void modificaProdottoOrdinato(Ordine ordine, OrdineProdotto ordProd, double costoUnitario);
     
    public void eliminaProdottoOrdinato(OrdineProdotto ordProd);
    
}
