import java.time.*;

public abstract class Personne 
{
	//Atribut herite
	protected String nom;
	protected String prenom;
	protected LocalDate date_Naissance;
	//Methode abstraite
	public abstract String toString();
}
