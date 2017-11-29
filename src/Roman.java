import java.time.*;

public class Roman extends Ouvrage
{
	private int nombre_pages;
	//Constructeur
	public Roman(int pNum, String pTitre, Auteur pAuteur, String pEditeur, int pNombre) 
	{
		super.numero = pNum;
		super.titre = pTitre;
		super.auteur = pAuteur;
		super.disponibilite = true;
		super.editeur = pEditeur;
		this.nombre_pages = pNombre;
		super.genre = "Roman";
	}
	//Methode toString()
	public String toString()
	{
		return "Titre : " + this.titre + "; Genre : " + this.genre;
	}
}
