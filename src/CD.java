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
	
        @Override
	public String toString()
	{
		return "Titre : " + this.titre +"; Editeur : " + this.editeur;
	}
        @Override
        public int getNum(){
                return this.numero;
        }
        @Override
        public String getTitre()
        {
                return this.titre;
        }
        @Override
        public Auteur getAut()
        {
                return this.auteur;
        }
        @Override
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
        @Override
        public String getType()
        {
                return "CD";
        }
        @Override
        public void nonDispo()
        {
                this.disponibilite=false;
        }
        @Override
        public void dispo()
        {
                this.disponibilite=true;
        }
}