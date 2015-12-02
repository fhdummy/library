package at.library.model;

import at.library.model.Medium;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T23:14:02")
@StaticMetamodel(Regal.class)
public class Regal_ { 

    public static volatile SingularAttribute<Regal, Integer> regalId;
    public static volatile SingularAttribute<Regal, String> reihe;
    public static volatile CollectionAttribute<Regal, Medium> mediumCollection;
    public static volatile SingularAttribute<Regal, String> platz;
    public static volatile SingularAttribute<Regal, Integer> menge;

}