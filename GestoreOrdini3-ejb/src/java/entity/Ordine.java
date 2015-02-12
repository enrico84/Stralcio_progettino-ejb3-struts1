/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import gestoreordini.service.ejb.GestioneOrdini;
import gestoreordini.service.ejb.GestioneOrdiniRemote;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import service.CGestioneOrdini;
import utility.Data;

/**
 *
 * @author Enrico
 */
@Entity
@Table(name = "ordine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordine.findAll", query = "SELECT o FROM Ordine o"),
    @NamedQuery(name = "Ordine.findById", query = "SELECT o FROM Ordine o WHERE o.id = :id"),
    @NamedQuery(name = "Ordine.findByNumeroOrdine", query = "SELECT o FROM Ordine o WHERE o.numeroOrdine = :numeroOrdine"),
    @NamedQuery(name = "Ordine.findByDataSpedizione", query = "SELECT o FROM Ordine o WHERE o.dataSpedizione = :dataSpedizione"),
    @NamedQuery(name = "Ordine.findByIndirizzo", query = "SELECT o FROM Ordine o WHERE o.indirizzo = :indirizzo")})
public class Ordine implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroOrdine")
    private int numeroOrdine;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataSpedizione")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSpedizione;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "indirizzo")
    private String indirizzo;
    
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordine", fetch=FetchType.EAGER)
    private Collection<OrdineProdotto> prodottiOrdinati;
    

    public Ordine() {
    }

    public Ordine(Integer id) {
        this.id = id;
    }

     //Ordine senza cliente
    public Ordine(int numeroOrdine, Data dataSpedizione, String indirizzo) {
        this.id=0;
        this.numeroOrdine = numeroOrdine;
        setDataSpedizione(dataSpedizione);
        this.indirizzo = indirizzo;
    }
    
    //Ordine con il cliente
    public Ordine(int numeroOrdine, Data dataSpedizione, String indirizzo, Cliente clienteId) {
        this.id=0;
        this.numeroOrdine = numeroOrdine;
        setDataSpedizione(dataSpedizione);
        this.indirizzo = indirizzo;
        this.clienteId=clienteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(int numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public Data getDataSpedizione() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dataSpedizione);
        return new Data(
                gc.get(GregorianCalendar.YEAR), 
                gc.get(GregorianCalendar.MONTH)+1,
                gc.get(GregorianCalendar.DATE));
    }

    
    public void setDataSpedizione(Data dataSpedizione) {
        this.dataSpedizione = new Date(new GregorianCalendar(
            dataSpedizione.getAnno(),
            dataSpedizione.getMese()-1,
            dataSpedizione.getGiorno()).getTimeInMillis());
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Cliente getCliente() {
        return clienteId;
    }

    public void setCliente(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    
//Necessario se c'è la NAVIGABILITA' da Ordine a OrdineProdotto
//    @XmlTransient
//    public Collection<Ordineprodotto> getOrdineprodottoCollection() {
//        return ordineprodottoCollection;
//    }
//
//    public void setOrdineprodottoCollection(Collection<Ordineprodotto> ordineprodottoCollection) {
//        this.ordineprodottoCollection = ordineprodottoCollection;
//    }
    
    
//    @XmlTransient
//    public OrdineProdotto[] getProdottiOrdinati() {
//        return prodottiOrdinati.toArray(new OrdineProdotto[prodottiOrdinati.size()]);
//    }
    
//     private CGestioneOrdini gest= new CGestioneOrdini();
     
//        try
//        {
//            gestioneOrdini = (GestioneOrdiniRemote) new InitialContext().
//                    lookup("gestoreordini.service.ejb.GestioneOrdiniRemote");   
//        }
//        catch(NamingException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
    
    
    @XmlTransient
    public OrdineProdotto[] getProdottiAcquistati() {
        return prodottiOrdinati.toArray(new OrdineProdotto[prodottiOrdinati.size()]);
        
//        OrdineProdotto[] prodottiOrdinati1 = prodottiOrdinati.toArray(new OrdineProdotto[prodottiOrdinati.size()]);
//        prodottiOrdinati1 = gest.getProdotti(this);
//        return prodottiOrdinati1;
        
    }

    public void setProdottiOrdinati(Collection<OrdineProdotto> prodottiOrdinati) {
        this.prodottiOrdinati = prodottiOrdinati;
    }
    

//     public void setProdottiOrdinati(Collection<OrdineProdotto> prodottiOrdinati) {
//        this.prodottiOrdinati = prodottiOrdinati;
//     }
     
     
    public void aggiungiProdottoOrdinato(OrdineProdotto prodottiOrdinato) {
        prodottiOrdinati.add(prodottiOrdinato);
    }
    
    
    public void eliminaProdottoOrdinato(OrdineProdotto prodottiOrdinato) {
        prodottiOrdinati.remove(prodottiOrdinato);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordine)) {
            return false;
        }
        Ordine other = (Ordine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordine[ id=" + id + " ]";
    }
    
}
