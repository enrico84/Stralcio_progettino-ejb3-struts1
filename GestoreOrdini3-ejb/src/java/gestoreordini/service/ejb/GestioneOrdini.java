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
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utility.Data;
import utility.Lista;

/**
 *
 * @author Enrico
 */
@Stateless
public class GestioneOrdini implements GestioneOrdiniLocal, GestioneOrdiniRemote {

    @PersistenceContext(unitName = "GestoreOrdini3-ejbPU")
    private EntityManager em;
    
    
    @Override
    public Ordine[] getOrdini() {
        List<Ordine> ordini = em.createNamedQuery("Ordine.findAll").getResultList();
        
        return ordini.toArray(new Ordine[ordini.size()]);
    }

    
    @Override
    public Ordine inserisciOrdine(int numeroOrdine, Data dataSpedizione, String indirizzo, Cliente cliente) {
        Ordine ordine = new Ordine(numeroOrdine, dataSpedizione, indirizzo, cliente);
        em.persist(ordine);
        em.flush();
        
        return ordine;
    }

    
    @Override
    public int verificaDisponibilita(Prodotto p) {
        return p.getDisponibilita();
    }

    
    @Override
    public void modificaIndirizzoOrdine(Ordine ordine, String indirizzo) {
        ordine.setIndirizzo(indirizzo);
        em.merge(ordine);
        em.flush();
    }
    
    
    @Override
    public void modificaDataOrdine(Ordine ordine, Data dataSpedizione) {
//        ordine = em.find(Ordine.class, ordine.getId());
//        Date newData = new Date(new GregorianCalendar(
//                                            ordine.getDataSpedizione().getAnno(), 
//                                            ordine.getDataSpedizione().getMese()-1,
//                                            ordine.getDataSpedizione().getGiorno()).getGregorianChange().getTime());

        ordine.setDataSpedizione(dataSpedizione);
        em.merge(ordine);
        em.flush();
        
    }
    

    @Override
    public Cliente[] getClienti() {
        List<Cliente> clienti = em.createNamedQuery("Cliente.findAll").getResultList();
        return clienti.toArray(new Cliente[clienti.size()]);
    }

    
    @Override
    public Prodotto[] getProdotti() {
        List<Prodotto> prodotti = em.createNamedQuery("Prodotto.findAll").getResultList();
        return prodotti.toArray(new Prodotto[prodotti.size()]);
    }

    
//    @Override
//    //Torna una lista di prodotti dell'ordine
//    public List getProdotti(int codice) {
//        List<Prodotto> prodotti = (List<Prodotto>) em.createNamedQuery("OrdineProdotto.findByProdottoId").
//                setParameter("ordineId", codice).getSingleResult();
//        
//        return prodotti;
//    }

    
    @Override
    //Dato un ordine specifico, ritorna un array di prodotti ordinati
    public OrdineProdotto[] getProdotti(Ordine ordine) {
        List prodottiOrdinati = 
          (List) em.createNamedQuery("OrdineProdotto.findByOrdineId")
                  .setParameter("ordineId", ordine.getId()).getResultList();
           
        ordine.setProdottiOrdinati(prodottiOrdinati);
        return (OrdineProdotto[]) prodottiOrdinati.toArray(new OrdineProdotto[prodottiOrdinati.size()]);
    }

    
    @Override
    //Se ci sono problemi togliere la riga 'setDisponibilita(0) in CGestioneProdotti
    public OrdineProdotto aggiungiProdottoOrdinato(Integer quantita, Double costoUnitario, Ordine ordine, Prodotto prodotto)
    {
        OrdineProdotto ordProd; 
        ordine = em.find(Ordine.class, ordine.getId());
        prodotto = em.find(Prodotto.class, prodotto.getId());
        if(prodotto.getDisponibilita() < quantita)
            {
                System.out.println("Hai ordinato una quantità maggiore della disponibilita'."
                                    + "\nQuantita' massima ordinabile:" + prodotto.getDisponibilita());
                ordProd = null;
            }
        else
        { 
           ordProd = new OrdineProdotto(ordine, prodotto, costoUnitario, quantita);
           ordine.aggiungiProdottoOrdinato(ordProd);
           prodotto.setDisponibilita(prodotto.getDisponibilita() - quantita);
           
           ordProd.setProdotto(prodotto);
           ordProd.setOrdine(ordine);
           ordProd.setQuantita(quantita);
           ordProd.setCostoUnitario(costoUnitario);

           em.persist(ordProd);
//           em.persist(ordine);
//           em.merge(ordProd);
           em.merge(ordine);
           em.merge(prodotto);
           em.flush();
        }   
        return ordProd;
    }
    
    
     //MODIFICO SOLO LA QUANTITA' DEL PRODOTTO ORDINATO
    @Override
     //Se ci sono problemi togliere la riga 'setDisponibilita(0) in CGestioneProdotti
     public void modificaOrdine(Ordine ordine, OrdineProdotto ordProd, int quantita){
         ordProd = em.find(OrdineProdotto.class, ordProd.getOrdineProdottoPK());
         int dispProdotto = ordProd.getProdotto().getDisponibilita();
         if(quantita > dispProdotto){
              System.out.println("Hai ordinato una quantità maggiore della disponibilità."
                                 + "\nQuantita' massima ordinabile:" + dispProdotto);
         }
         else
         {
             ordProd.getProdotto().setDisponibilita(dispProdotto + (ordProd.getQuantita()-quantita));
             ordProd.setQuantita(quantita);
             em.merge(ordProd);
             em.merge(ordProd.getProdotto()); 
             em.flush();
         }        
     }
     
    @Override
     //Se ci sono problemi togliere la riga 'setDisponibilita(0) in CGestioneProdotti
     public void modificaProdottoOrdinato(Ordine ordine, OrdineProdotto ordProd, double costoUnitario) { 
        ordProd = em.find(OrdineProdotto.class, ordProd.getOrdineProdottoPK());
        ordProd.setCostoUnitario(costoUnitario);
        em.merge(ordProd);
        em.flush();          
     }
     

    @Override
     public void eliminaProdottoOrdinato(OrdineProdotto ordProd){
         Prodotto p;
         ordProd = em.find(OrdineProdotto.class, ordProd.getOrdineProdottoPK());
         
         p=ordProd.getProdotto();
         
         p.setDisponibilita(p.getDisponibilita() + ordProd.getQuantita());
         
         Ordine ordine = ordProd.getOrdine();
         ordine = em.find(Ordine.class, ordine.getId());
         
         ordine.eliminaProdottoOrdinato(ordProd);
         em.remove(ordProd);
         em.merge(ordine);
         em.merge(p);
         em.flush();
         
     }
    
    
    @Override
    public void eliminaOrdine(Ordine ordine) {
        ordine = em.find(Ordine.class, ordine.getId());
        OrdineProdotto[] prodottiAcquistati = this.getProdotti(ordine);
        if(prodottiAcquistati.length > 0)
        {
            for(OrdineProdotto ord: prodottiAcquistati)
            {
                eliminaProdottoOrdinato(ord);
            }
        }
        em.remove(ordine);
        em.flush();
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
