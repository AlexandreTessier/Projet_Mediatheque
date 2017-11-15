import java.time.*;

public abstract class Ouvrage {
    protected int numero;
    protected String titre;
    protected boolean disponibilite;
    protected Auteur auteur;
    protected String editeur;
    private String toString;
}
