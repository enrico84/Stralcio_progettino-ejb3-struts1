/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Cliente;
import gestoreordini.service.ejb.GestioneClientiRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Enrico
 */
public class CGestioneClienti {
    
    private GestioneClientiRemote gestioneClienti;
    
    public CGestioneClienti() throws RuntimeException {
        try  {
            gestioneClienti = (GestioneClientiRemote)new InitialContext().lookup("gestoreordini.service.ejb.GestioneClientiRemote");
        }
        catch(NamingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    public Cliente[] getClienti() {
        return gestioneClienti.getClienti();
    }
    
    
    public Cliente inserisciCliente(String cf, String nome, String cognome, String email, String indirizzo)
    {
        return gestioneClienti.inserisciCliente(cf, nome, cognome, email, indirizzo);
    }
    
    
    public void modificaCliente(Cliente cliente, String email, String indirizzo)
    {
        gestioneClienti.modificaCliente(cliente, email, indirizzo);
    }
    
    
    public void eliminaCliente(Cliente cliente)
    {
        gestioneClienti.eliminaCliente(cliente);
    }
    
}
