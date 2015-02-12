/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Enrico
 */
@Embeddable
public class OrdineProdottoPK implements Serializable {
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordine_id")
    private int ordineId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodotto_id")
    private int prodottoId;

    public OrdineProdottoPK() {
    }

    public OrdineProdottoPK(int ordineId, int prodottoId) {
        this.ordineId = ordineId;
        this.prodottoId = prodottoId;
    }

    public int getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(int ordineId) {
        this.ordineId = ordineId;
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ordineId;
        hash += (int) prodottoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdineProdottoPK)) {
            return false;
        }
        OrdineProdottoPK other = (OrdineProdottoPK) object;
        if (this.ordineId != other.ordineId) {
            return false;
        }
        if (this.prodottoId != other.prodottoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdineProdottoPK[ ordineId=" + ordineId + ", prodottoId=" + prodottoId + " ]";
    }
    
}
