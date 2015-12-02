package at.library.model;

import at.library.model.Kunde;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T23:14:02")
@StaticMetamodel(Konto.class)
public class Konto_ { 

    public static volatile CollectionAttribute<Konto, Kunde> kundeCollection;
    public static volatile SingularAttribute<Konto, Integer> kontoId;
    public static volatile SingularAttribute<Konto, Float> sollbetrag;
    public static volatile SingularAttribute<Konto, Float> istbetrag;
    public static volatile SingularAttribute<Konto, Kunde> kundeId;

}