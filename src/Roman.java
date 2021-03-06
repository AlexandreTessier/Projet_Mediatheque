import java.time.*;

public class Roman extends Ouvrage
{
	private int nombre_pages;
        private String genre;
	//Constructeur
	public Roman(int pNum, String pTitre, Auteur pAuteur, String pEditeur, int pNombre, String pGenre, boolean pDispo) 
	{
		super.numero = pNum;
		super.titre = pTitre;
		super.auteur = pAuteur;
		super.disponibilite = pDispo;
		super.editeur = pEditeur;
		this.nombre_pages = pNombre;
		this.genre = pGenre;
	}
	//Methode toString()
	public String toString()
	{
		return "[Roman] Titre: "+this.titre+"; Auteur: "+this.auteur+"; Genre: " + this.genre+"; Editeur: "+this.editeur+"; Disponibilité: "+this.disponibilite;
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
        public int getNbre()
        {
                return this.nombre_pages;
        }
        public String getGenre()
        {
                return this.genre;
        }
        public boolean getDispo()
        {
                return this.disponibilite;
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
