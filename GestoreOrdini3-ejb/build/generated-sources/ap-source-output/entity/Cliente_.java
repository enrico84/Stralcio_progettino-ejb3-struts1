package entity;

import entity.Ordine;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-17T16:51:45")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile CollectionAttribute<Cliente, Ordine> ordineCollection;
    public static volatile SingularAttribute<Cliente, String> cf;
    public static volatile SingularAttribute<Cliente, String> cognome;
    public static volatile SingularAttribute<Cliente, String> indirizzo;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile SingularAttribute<Cliente, String> email;

}