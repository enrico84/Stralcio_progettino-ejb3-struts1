package entity;

import entity.Cliente;
import entity.OrdineProdotto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-17T16:51:45")
@StaticMetamodel(Ordine.class)
public class Ordine_ { 

    public static volatile CollectionAttribute<Ordine, OrdineProdotto> prodottiOrdinati;
    public static volatile SingularAttribute<Ordine, Cliente> clienteId;
    public static volatile SingularAttribute<Ordine, Integer> numeroOrdine;
    public static volatile SingularAttribute<Ordine, String> indirizzo;
    public static volatile SingularAttribute<Ordine, Integer> id;
    public static volatile SingularAttribute<Ordine, Date> dataSpedizione;

}