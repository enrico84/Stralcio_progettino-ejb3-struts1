package entity;

import entity.Ordine;
import entity.OrdineProdottoPK;
import entity.Prodotto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-17T16:51:45")
@StaticMetamodel(OrdineProdotto.class)
public class OrdineProdotto_ { 

    public static volatile SingularAttribute<OrdineProdotto, Ordine> ordine;
    public static volatile SingularAttribute<OrdineProdotto, OrdineProdottoPK> ordineprodottoPK;
    public static volatile SingularAttribute<OrdineProdotto, Integer> quantita;
    public static volatile SingularAttribute<OrdineProdotto, Double> costoUnitario;
    public static volatile SingularAttribute<OrdineProdotto, Prodotto> prodotto;

}