package at.library.model;

import at.library.model.BuchPK;
import at.library.model.Medium;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T23:14:02")
@StaticMetamodel(Buch.class)
public class Buch_ { 

    public static volatile SingularAttribute<Buch, Integer> jahr;
    public static volatile SingularAttribute<Buch, String> titel;
    public static volatile SingularAttribute<Buch, Integer> regalId;
    public static volatile SingularAttribute<Buch, Date> endsollzeit;
    public static volatile SingularAttribute<Buch, BuchPK> buchPK;
    public static volatile SingularAttribute<Buch, String> typ;
    public static volatile SingularAttribute<Buch, Float> strafe;
    public static volatile SingularAttribute<Buch, Medium> medium;
    public static volatile SingularAttribute<Buch, Date> endistzeit;
    public static volatile SingularAttribute<Buch, String> autor;
    public static volatile SingularAttribute<Buch, Integer> kundeId;
    public static volatile SingularAttribute<Buch, Date> startzeit;

}