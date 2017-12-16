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
        @Override
	public String toString()
	{
                return "Numero : "+this.numero+"; Titre : "+this.titre+"; Auteur : "+this.auteur.toString()+"; Disponibilité : "+this.disponibilite+"Genre : " + this.genre;
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
        public int getNbre()
        {
                return this.nombre_pages;
        }
        public String getGenre()
        {
                return this.genre;
        }
        @Override
        public boolean getDispo()
        {
                return this.disponibilite;
        }
        @Override
        public String getType()
        {
                return "Roman";
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
