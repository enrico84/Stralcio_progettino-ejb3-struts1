/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static entity.OrdineProdottoPK_.ordineId;
import static entity.OrdineProdottoPK_.prodottoId;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrico
 */
@Entity
@Table(name = "ordineprodotto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdineProdotto.findAll", query = "SELECT o FROM OrdineProdotto o"),
    @NamedQuery(name = "OrdineProdotto.findByQuantita", query = "SELECT o FROM OrdineProdotto o WHERE o.quantita = :quantita"),
    @NamedQuery(name = "OrdineProdotto.findByCostoUnitario", query = "SELECT o FROM OrdineProdotto o WHERE o.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "OrdineProdotto.findByOrdineId", query = "SELECT o FROM OrdineProdotto o WHERE o.ordineprodottoPK.ordineId = :ordineId"),
    @NamedQuery(name = "OrdineProdotto.findByProdottoId", query = "SELECT o FROM OrdineProdotto o WHERE o.ordineprodottoPK.prodottoId = :prodottoId")
})
public class OrdineProdotto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected OrdineProdottoPK ordineprodottoPK;
    
    @Column(name = "quantita")
    private Integer quantita;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costoUnitario")
    private Double costoUnitario;
    
    @JoinColumn(name = "ordine_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordine ordine;
    
    @JoinColumn(name = "prodotto_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prodotto prodotto;

    public OrdineProdotto() {
    }

   
    public OrdineProdotto(int idOrdine, int idProdotto) 
    {
        this.ordineprodottoPK = new OrdineProdottoPK(idOrdine, idProdotto);     
    }
              
    
    public OrdineProdotto(Ordine ordine, Prodotto prodotto, Double costoUnitario, Integer quantita) { 
        this.ordine=ordine;
        this.prodotto = prodotto;
        this.quantita=quantita;
        this.costoUnitario=costoUnitario;
        this.ordineprodottoPK=new OrdineProdottoPK(ordine.getId(), prodotto.getId());
    }

    
    public OrdineProdottoPK getOrdineProdottoPK() {
        return ordineprodottoPK;
    }

    public void setOrdineProdottoPK(OrdineProdottoPK ordineprodottoPK) {
        this.ordineprodottoPK = ordineprodottoPK;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordineprodottoPK != null ? ordineprodottoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdineProdotto)) {
            return false;
        }
        OrdineProdotto other = (OrdineProdotto) object;
        if ((this.ordineprodottoPK == null && other.ordineprodottoPK != null) || 
            (this.ordineprodottoPK != null && !this.ordineprodottoPK.equals(other.ordineprodottoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdineProdotto[ ordineprodottoPK=" + ordineprodottoPK + " ]";
    }
    
}
