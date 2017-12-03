import java.time.*;
import java.util.ArrayList;

public class CD extends Ouvrage
{
	private ArrayList<String> listeChansons;
    
	public CD(int pNum, String pTitre, Auteur pAuteur, String pEditeur, boolean pDispo, ArrayList<String> pListe) 
	{
		this.numero=pNum;
		this.titre=pTitre;
		this.auteur=pAuteur;
		this.disponibilite=pDispo;
		this.editeur=pEditeur;
		this.listeChansons=pListe;
	}
	
	public String toString()
	{
		return "CD";
	}
}