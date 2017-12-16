import java.time.*;

public class Auteur extends Personne
{
    private int numero;
    private String style_Artistique;
    
    public Auteur(String pNom, String pPrenom, LocalDate pDate, int pNombre, String pStyle)
    {
            this.nom=pNom;
            this.prenom=pPrenom;
            this.date_Naissance=pDate;
            this.numero=pNombre;
            this.style_Artistique=pStyle;
    }
    
    @Override
    public String toString() {
        return "Auteur";
    }
    
    public String getNom()
    {
            return this.nom;
    }
    public String getPrenom()
    {
            return this.prenom;
    }
    public LocalDate getdate()
    {
            return this.date_Naissance;
    }
    public int getNum()
    {
            return this.numero;
    }
    public String getStyle()
    {
            return this.style_Artistique;
    }
}
