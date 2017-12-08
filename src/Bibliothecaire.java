import java.time.*;

public class Bibliothecaire extends Personne
{
	private String email;
	private String mdP;
    
	public Bibliothecaire(String pNom, String pPrenom, LocalDate pDate, String pMail, String pMDP)
	{
		this.nom=pNom;
		this.prenom=pPrenom;
		this.date_Naissance=pDate;
		this.email=pMail;
		this.mdP=pMDP;
	}
	
	@Override
	public String toString() 
	{
		return "Admin";
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
        public String getMail()
        {
                return this.email;
        }
        public String getMDP()
        {
                return this.mdP;
        }
        
	public void gerer_base_donnee()
	{
        
	}
    
	public void ajouterOuvrage(Ouvrage pOuvrage)
	{
        
	}
    
	public void supprimerOuvrage(int pNumero)
	{
        
	}
    
	public void afficher_Adherents()
	{
        
	}
    
	public void supprimer_Adherent()
	{
        
	}
}
