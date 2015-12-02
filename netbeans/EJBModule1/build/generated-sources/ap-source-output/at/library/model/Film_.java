package at.library.model;

import at.library.model.FilmPK;
import at.library.model.Medium;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-02T23:14:02")
@StaticMetamodel(Film.class)
public class Film_ { 

    public static volatile SingularAttribute<Film, Integer> jahr;
    public static volatile SingularAttribute<Film, String> titel;
    public static volatile SingularAttribute<Film, Integer> regalId;
    public static volatile SingularAttribute<Film, String> regisseur;
    public static volatile SingularAttribute<Film, FilmPK> filmPK;
    public static volatile SingularAttribute<Film, Date> endsollzeit;
    public static volatile SingularAttribute<Film, Float> strafe;
    public static volatile SingularAttribute<Film, Medium> medium;
    public static volatile SingularAttribute<Film, Date> endistzeit;
    public static volatile SingularAttribute<Film, Date> laenge;
    public static volatile SingularAttribute<Film, Integer> kundeId;
    public static volatile SingularAttribute<Film, Date> startzeit;

}