package at.library.model;

import at.library.model.Konto;
import at.library.model.Medium;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T23:14:02")
@StaticMetamodel(Kunde.class)
public class Kunde_ { 

    public static volatile SingularAttribute<Kunde, String> ort;
    public static volatile SingularAttribute<Kunde, Date> geburtstag;
    public static volatile SingularAttribute<Kunde, Short> student;
    public static volatile SingularAttribute<Kunde, String> strasse;
    public static volatile CollectionAttribute<Kunde, Medium> mediumCollection;
    public static volatile SingularAttribute<Kunde, String> vorname;
    public static volatile SingularAttribute<Kunde, Konto> kontoId;
    public static volatile SingularAttribute<Kunde, String> nachname;
    public static volatile SingularAttribute<Kunde, String> land;
    public static volatile SingularAttribute<Kunde, Integer> kundeId;
    public static volatile SingularAttribute<Kunde, Integer> plz;
    public static volatile CollectionAttribute<Kunde, Konto> kontoCollection;

}