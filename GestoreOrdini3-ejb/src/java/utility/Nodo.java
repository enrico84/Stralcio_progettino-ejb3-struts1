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
public class Nodo implements Serializable{
    
    private Object info;
    private Nodo next;
    
    Nodo(Object info, Nodo next) {
        this.info = info;
        this.next = next;
    }
    
    Nodo() {}

    Object getInfo() {
        return info;
    }

    void setInfo(Object info) {
        this.info = info;
    }

    Nodo getNext() {
        return next;
    }

    void setNext(Nodo next) {
        this.next = next;
    }
    
}
