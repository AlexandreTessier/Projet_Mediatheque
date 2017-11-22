import java.time.*;

public class Bibliothécaire extends Personne{
    private String email;
    private String mot_de_passe;
    
    public Bibliothécaire(String pNom, String pPrenom, LocalDate pDate, String pMail, String pMDP){
        this.nom=pNom;
        this.prenom=pPrenom;
        this.date_Naissance=pDate;
        this.email=pMail;
        this.mot_de_passe=pMDP;
    }

    @Override
    public String toString() {
        return "Admin";
    }
    
    public void gerer_base_donnee(){
        
    }
    
    public void ajouterOuvrage(Ouvrage pOuvrage){
        
    }
    
    public void supprimerOuvrage(int pNumero){
        
    }
    
    public void afficher_Adherents(){
        
    }
    
    public void supprimer_Adherent(){
        
    }
}

