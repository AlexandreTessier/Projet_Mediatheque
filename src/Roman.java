import java.time.*;

public class Roman extends Ouvrage
{
	private int nombre_pages;
	//Constructeur
	public Roman(int pNum, String pTitre, Auteur pAuteur, String pEditeur, int pNombre, String pGenre, boolean pDispo) 
	{
		super.numero = pNum;
		super.titre = pTitre;
		super.auteur = pAuteur;
		super.disponibilite = pDispo;
		super.editeur = pEditeur;
		this.nombre_pages = pNombre;
		super.genre = pGenre;
	}
	//Methode toString()
	public String toString()
	{
		return "Titre : " + this.titre + "; Genre : " + this.genre;
	}
        public int getNum(){
                return this.numero;
        }
}
