import java.time.*;
import java.util.ArrayList;

public class CD extends Ouvrage
{
	private ArrayList listeChansons;
    
	public CD(int pNum, String pTitre, Auteur pAuteur, String pEditeur, boolean pDispo, ArrayList pListe) 
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
		return "[CD] Titre: "+this.titre+"; Auteur :"+this.auteur+"; Editeur: "+this.editeur+"; Disponibilité: "+this.disponibilite;
	}
        public int getNum(){
                return this.numero;
        }
        public String getTitre()
        {
                return this.titre;
        }
        public Auteur getAut()
        {
                return this.auteur;
        }
        public String getEdit()
        {
                return this.editeur;
        }
        public boolean getDispo()
        {
                return this.disponibilite;
        }
        public ArrayList getListe()
        {
                return this.listeChansons;
        }
        public void nonDispo()
        {
                this.disponibilite=false;
        }
        public void dispo()
        {
                this.disponibilite=true;
        }
}