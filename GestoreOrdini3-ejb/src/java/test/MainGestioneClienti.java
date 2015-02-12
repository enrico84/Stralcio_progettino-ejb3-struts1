/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import service.CGestioneClienti;
import entity.Cliente;

/**
 *
 * @author Enrico
 */
public class MainGestioneClienti {
    
    public static void main(String[] args) {
        
        CGestioneClienti cGC = new CGestioneClienti();
          
        Cliente[] c =cGC.getClienti();
//        cGC.inserisciCliente("frkrbr", "Frank", "Ribery", "franck@francia.it", "via Monaco");
//        cGC.inserisciCliente("rynrbn", "Arjen", "Robben", "robben@gmail.it", "via Bayern");
        
        c = cGC.getClienti();
//        stampaElencoClienti(c);
        
//        stampaDettaglioCliente(c[6]);
        stampaDettaglioCliente(c[6]);
        
//        cGC.eliminaCliente(c[4]);
//        c = cGC.getClienti();
//        stampaElencoClienti(c);
//        
        cGC.modificaCliente(c[6], "robben@bayern.com", "via Bayern 2");
        c = cGC.getClienti();
//        stampaDettaglioCliente(c[1]);
        stampaDettaglioCliente(c[6]);
//        stampaElencoClienti(c); 
        
    }    
        
    
    public static void stampaElencoClienti(Cliente[] clienti)
        {
            System.out.println("---------- Elenco Clienti ----------");
            for (int i = 0; i < clienti.length; i++) {
                System.out.println(clienti[i].getNome()+ " "
                +clienti[i].getCognome());
            }
            System.out.println("-------------------------------------");
        }
    
    
    //Da usare in MainGestioneOrdine
    public static void stampaInfoCliente(Cliente c)
    {
        System.out.println("-------Dettaglio Cliente-------");
        System.out.println("CF: " +c.getCf()+ "\n" +c.getNome()+ "\n" +c.getCognome());
        System.out.println("-------------------------------");
    }
    
        
    public static void stampaDettaglioCliente(Cliente c)
    {
        System.out.println("-------Dettaglio Cliente-------");
        System.out.println("CF:" +c.getCf()+ "\n" +c.getNome()+ "\n" +c.getCognome()+ "\nemail: " +c.getEmail()+ 
                "\nIndirizzo: " +c.getIndirizzo());
        System.out.println("-------------------------------");
    }
}
