
import java.time.*;

public class Ouvrage {
    protected int numero;
    protected String titre;
    protected boolean disponibilite;
    protected Personne auteur;
    
    public Ouvrage(int pNum, String pTitre, Personne pAuteur){
        this.numero=pNum;
        this.titre=pTitre;
        this.auteur=pAuteur;
        this.disponibilite=true;
    }
}
