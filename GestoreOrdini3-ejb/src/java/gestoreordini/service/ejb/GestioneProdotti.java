/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestoreordini.service.ejb;

import entity.Prodotto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Enrico
 */
@Stateless

public class GestioneProdotti implements GestioneProdottiLocal, GestioneProdottiRemote {
    
    @PersistenceContext(unitName = "GestoreOrdini3-ejbPU")
    private EntityManager em;
    
    @Override
    public Prodotto[] getProdotti() {
        List<Prodotto> prodotti = em.createNamedQuery("Prodotto.findAll").getResultList();
        return prodotti.toArray(new Prodotto[prodotti.size()]);
    }

    
    @Override
    public Prodotto getProdotto(Prodotto p) {
        Prodotto prodotto = (Prodotto) em.createNamedQuery("Prodotto.findById").
                setParameter("id", p.getId()).getSingleResult();
        return prodotto;
    }
    
    
    @Override
    public Prodotto inserisciProdotto(String codice, Double costoUnitario, String descrizione, 
            String unitaMisura, Integer disponibilita) {
        Prodotto prodotto = new Prodotto(codice, costoUnitario, descrizione, unitaMisura, disponibilita);
        em.persist(prodotto);
        em.flush();
        return prodotto;
    }
    
    
    @Override
    public Prodotto inserisciProdotto(String codice) {
        Prodotto prodotto = new Prodotto(codice);
        em.persist(prodotto);
        em.flush();
        return prodotto;
    }

    
    @Override
    public void modificaProdotto(Prodotto prodotto, Double costoUnitario, Integer disponibilita) {
        prodotto.setCostoUnitario(costoUnitario);
        prodotto.setDisponibilita(disponibilita);
        em.merge(prodotto);
        em.flush();
 
    }

//    @Override
//    public void modificaProdotto(Prodotto prodotto, Integer disponibilita) {
//        prodotto.setDisponibilita(disponibilita);
//        em.merge(prodotto);
//        em.flush();
//    }
//
//    @Override
//    public void modificaProdotto(Prodotto prodotto, Double costoUnitario) {
//        prodotto.setCostoUnitario(costoUnitario);
//        em.merge(prodotto);
//        em.flush();
//        
//    }

    
    @Override
    public void eliminaProdotto(Prodotto prodotto) {
        prodotto = em.find(Prodotto.class, prodotto.getId());
        em.remove(prodotto);
        em.flush();
    }

       
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
