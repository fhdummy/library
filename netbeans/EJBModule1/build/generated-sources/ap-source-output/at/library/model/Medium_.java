package at.library.model;

import at.library.model.Buch;
import at.library.model.Cd;
import at.library.model.Film;
import at.library.model.Kunde;
import at.library.model.Regal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T23:14:02")
@StaticMetamodel(Medium.class)
public class Medium_ { 

    public static volatile SingularAttribute<Medium, Regal> regalId;
    public static volatile CollectionAttribute<Medium, Film> filmCollection;
    public static volatile SingularAttribute<Medium, Integer> mediumId;
    public static volatile SingularAttribute<Medium, Date> endsollzeit;
    public static volatile SingularAttribute<Medium, Float> strafe;
    public static volatile CollectionAttribute<Medium, Buch> buchCollection;
    public static volatile SingularAttribute<Medium, Date> endistzeit;
    public static volatile SingularAttribute<Medium, Date> startzeit;
    public static volatile SingularAttribute<Medium, Kunde> kundeId;
    public static volatile CollectionAttribute<Medium, Cd> cdCollection;

}