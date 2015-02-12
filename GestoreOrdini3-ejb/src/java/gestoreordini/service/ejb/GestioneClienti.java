/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestoreordini.service.ejb;

import entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Enrico
 */
@Stateless
public class GestioneClienti implements GestioneClientiLocal, GestioneClientiRemote {

    @PersistenceContext(unitName = "GestoreOrdini3-ejbPU")
    private EntityManager em;

    @Override
    public Cliente[] getClienti() {
        List<Cliente> clienti = em.createNamedQuery("Cliente.findAll").getResultList();
        return clienti.toArray(new Cliente[clienti.size()]);
    }

    @Override
    public Cliente inserisciCliente(String cf, String nome, String cognome, String email, String indirizzo) {
        Cliente cliente = new Cliente(cf, nome, cognome, email, indirizzo);
        em.persist(cliente);
        em.flush();
        return cliente;
    }

    @Override
    public void modificaCliente(Cliente cliente, String email, String indirizzo) {
        cliente.setEmail(email);
        cliente.setIndirizzo(indirizzo);
        em.merge(cliente);
        em.flush();
        
    }

    @Override
    public void eliminaCliente(Cliente cliente) {
        cliente = em.find(Cliente.class, cliente.getId());
        em.remove(cliente);
        em.flush();
    }        
            
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
