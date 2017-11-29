import java.time.*;

public class Adherent extends Personne
{
	//Attribut d'instance
	private String email;
	private String mdP;
	private int num_identifiant;
	private int num_tel;
	private Emprunt[] liste_Emprunts;
	//Construction
	public Adherent(String pNom, String pPrenom, LocalDate pDate, String pMail, String pMDP, int pId, int pTel)
	{
		this.nom=pNom;
		this.prenom=pPrenom;
		this.date_Naissance=pDate;
		this.liste_Emprunts = new Emprunt[10];
		this.email=pMail;
		this.mdP=pMDP;
		this.num_identifiant=pId;
		this.num_tel=pTel;
	}
	//Methode toString()
	@Override
	public String toString() 
	{
		return "Adhérent n° : " + num_identifiant + " : " + nom + " " + prenom;
	}
}
