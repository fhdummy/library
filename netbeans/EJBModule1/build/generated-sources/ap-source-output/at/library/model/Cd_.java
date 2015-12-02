package at.library.model;

import at.library.model.CdPK;
import at.library.model.Medium;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T23:14:02")
@StaticMetamodel(Cd.class)
public class Cd_ { 

    public static volatile SingularAttribute<Cd, Integer> regalId;
    public static volatile SingularAttribute<Cd, String> album;
    public static volatile SingularAttribute<Cd, Medium> medium;
    public static volatile SingularAttribute<Cd, Date> laenge;
    public static volatile SingularAttribute<Cd, Integer> jahr;
    public static volatile SingularAttribute<Cd, CdPK> cdPK;
    public static volatile SingularAttribute<Cd, String> titel;
    public static volatile SingularAttribute<Cd, String> interpret;
    public static volatile SingularAttribute<Cd, Date> endsollzeit;
    public static volatile SingularAttribute<Cd, Float> strafe;
    public static volatile SingularAttribute<Cd, Date> endistzeit;
    public static volatile SingularAttribute<Cd, Integer> kundeId;
    public static volatile SingularAttribute<Cd, Date> startzeit;

}