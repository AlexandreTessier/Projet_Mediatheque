import java.time.*;

public class Auteur extends Personne{
    private int nombre_publications;
    private String style_Artistique;
    
    public Auteur(String pNom, String pPrenom, LocalDate pDate, int pNombre, String pStyle){
        this.nom=pNom;
        this.prenom=pPrenom;
        this.date_Naissance=pDate;
        this.nombre_publications=pNombre;
        this.style_Artistique=pStyle;
    }
    
    @Override
    public String toString() {
        return "Auteur";
    }
    
}
