import java.time.*;

public class Roman extends Ouvrage
{
	public Roman(int pNum, String pTitre, Auteur pAuteur, String pEditeur, int pNombre) 
	{
		super.numero=pNum;
		super.titre=pTitre;
		super.auteur=pAuteur;
		super.disponibilite=true;
		super.editeur=pEditeur;
		super.nombre_pages=pNombre;
	}
	
	public String toString()
	{
		return "Roman";
	}
}
