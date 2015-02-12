/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestoreordini.service.ejb;

import entity.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Enrico
 */
@Local
public interface GestioneClientiLocal {
    
    public Cliente[] getClienti();
    
    public Cliente inserisciCliente(String cf, String nome, String cognome, String email, String indirizzo);
    
    public void modificaCliente(Cliente cliente, String email, String indirizzo);
    
    public void eliminaCliente(Cliente cliente);
    
}
