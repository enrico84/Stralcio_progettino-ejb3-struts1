/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrico
 */
@Entity
@Table(name = "prodotto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodotto.findAll", query = "SELECT p FROM Prodotto p"),
    @NamedQuery(name = "Prodotto.findById", query = "SELECT p FROM Prodotto p WHERE p.id = :id"),
    @NamedQuery(name = "Prodotto.findByCodice", query = "SELECT p FROM Prodotto p WHERE p.codice = :codice"),
    @NamedQuery(name = "Prodotto.findByCostoUnitario", query = "SELECT p FROM Prodotto p WHERE p.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "Prodotto.findByDescrizione", query = "SELECT p FROM Prodotto p WHERE p.descrizione = :descrizione"),
    @NamedQuery(name = "Prodotto.findByUnitaMisura", query = "SELECT p FROM Prodotto p WHERE p.unitaMisura = :unitaMisura"),
    @NamedQuery(name = "Prodotto.findByDisponibilita", query = "SELECT p FROM Prodotto p WHERE p.disponibilita = :disponibilita")})
public class Prodotto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codice")
    private String codice;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costoUnitario")
    private Double costoUnitario;
    
    @Size(max = 100)
    @Column(name = "descrizione")
    private String descrizione;
    
    @Size(max = 20)
    @Column(name = "unitaMisura")
    private String unitaMisura;
    
    @Column(name = "disponibilita")
    private Integer disponibilita;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodotto")
//    private Collection<Ordineprodotto> ordineprodottoCollection;

    public Prodotto() {
    }

    public Prodotto(Integer id) {
        this.id = id;
    }
    
    public Prodotto(String codice) {
        this.id = 0;
        this.codice = codice;
    }

   public Prodotto(String codice, Double costoUnitario, String descrizione, 
            String unitaMisura, Integer disponibilita){
        this.id=0;
        this.codice=codice;
        this.costoUnitario=costoUnitario;
        this.descrizione=descrizione;
        this.unitaMisura=unitaMisura;
        this.disponibilita=disponibilita;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUnitaMisura() {
        return unitaMisura;
    }

    public void setUnitaMisura(String unitaMisura) {
        this.unitaMisura = unitaMisura;
    }

    public Integer getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(Integer disponibilita) {
        this.disponibilita = disponibilita;
    }

    
//Necessario solo se c'è la NAVIGABILITA' da Prodotto ad Ordineprodotto
//    @XmlTransient
//    public Ordineprodotto[] getOrdineprodotti() {
//        return ordineprodottoCollection.toArray(new Ordineprodotto[ordineprodottoCollection.size()]);
//    }
//
//    public void setOrdineprodotto(Ordineprodotto ordineprodottoCollect) {
//        ordineprodottoCollection.add(ordineprodottoCollect);
//    }
//    
//    public void eliminaOrdineprodotto(Ordineprodotto ordineprodottoCollect)
//    {
//        ordineprodottoCollection.remove(ordineprodottoCollect);

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodotto)) {
            return false;
        }
        Prodotto other = (Prodotto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prodotto[ id=" + id + " ]";
    }
    
}
