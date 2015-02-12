/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.Serializable;

/**
 *
 * @author Enrico
 */
public class Lista implements Serializable{
    private Nodo primo;
    private int size;
     
    
    public Lista()
    {
        primo=null;
        size=0;
    } 
    
    public int getDimensione() {
        Nodo aux = primo;
        int i;
        for (i = 0; aux != null; i++) {
            aux = aux.getNext();
        }
        return i;
    }

    public Object getElemento(int pos) {
        if (pos < 0) {
            System.out.println(
                    "posizione specificata per l'elemento non valida");
        }
        Nodo aux = primo;
        for (int i = 0; aux != null && i < pos; i++) {
            aux = aux.getNext();
        }
        if (aux != null) { // i == pos
            return aux.getInfo();
        } else {
            throw new RuntimeException("posizione specificata per l'elemento non valida");
        }
    }

    public void addElemento(Object el) {
        if (primo == null) {
            primo = new Nodo(el, primo); 
        } else { // primo != null
            Nodo aux = primo;
            for (; aux.getNext() != null; aux = aux.getNext()) {
            }
            aux.setNext(new Nodo(el, aux.getNext()));
        }
    }

    public void addElemento(Object el, int pos) {
        if (pos == 0) {
            primo = new Nodo(el, primo);
        } else if (pos > 0) {
            Nodo aux = primo;
            for (int i = 0; aux != null && i < pos - 1; i++) {
                aux = aux.getNext();
            }
            if (aux != null) { // i == pos - 1
                aux.setNext(new Nodo(el, aux.getNext()));
            } else { // pos >= dimensione della lista + 1
                System.out.println("posizione specificata per l'inserimento non valida");
            }
        } else { // pos < 0
            System.out.println("posizione specificata per l'inserimento non valida");
        }
    }
    
    
    public boolean isEmpty()
    {
        if(size==0)
            return true;
        
        return false;
    }
    

    public void removeElemento(int pos) {
        if (pos == 0 && primo != null) {
            primo = primo.getNext();
        } else if (pos > 0 && primo != null) {
            Nodo aux = primo;
            for (int i = 0; aux.getNext() != null && i < pos - 1;
                         aux = aux.getNext(), i++) {
            }
            if (aux.getNext() != null) { // i == pos - 1
                aux.setNext(aux.getNext().getNext());
            } else { // pos >= dimensione della lista
                System.out.println("posizione specificata per l'eliminazione non valida");
            }
        } else { // pos < 0 || primo == null
            System.out.println("posizione specificata per l'eliminazione non valida");
        }
    }

    public void removeElemento(Object el) {
        if (primo != null && primo.getInfo().equals(el)) {
            primo = primo.getNext();
        } else if (primo != null) {
            Nodo aux = primo;
            for (; aux.getNext() != null && !aux.getNext().getInfo().equals(el);
                 aux = aux.getNext()) {
            }
            if (aux.getNext() != null) { // aux.getNext().getInfo() == el
                aux.setNext(aux.getNext().getNext());
            } else { // nessun elemento uguale a el nella lista
                System.out.println("posizione specificata per l'eliminazione non valida");
            }
        } else { // primo == null
            System.out.println("posizione specificata per l'eliminazione non valida");
        }
    }

    @Override
    public String toString() {
        String s = "( ";
        for (Nodo aux = primo; aux != null; aux = aux.getNext()) {
            s = s + aux.getInfo() + " ";
        }
        s = s + ")";
        return s;
    }

    public Object[] toArray() {
        Object[] elementi = new Object[getDimensione()];
        Nodo aux = primo;
        for (int i = 0; aux != null; aux = aux.getNext(), i++) {
            elementi[i] = aux.getInfo();
        }
        return elementi;
    }

    public Object[] toArray(Object[] elementi) {
        Nodo aux = primo;
        for (int i = 0; aux != null; aux = aux.getNext(), i++) {
            elementi[i] = aux.getInfo();
        }
        return elementi;
    }
    
}
