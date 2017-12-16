import java.time.*;

public abstract class Ouvrage 
{
	//Atribut 
	protected int numero;
	protected String titre;
	protected boolean disponibilite;
	protected Auteur auteur;
	protected String editeur;
	//Methode de la classe
	public abstract String toString();
        public abstract int getNum();
        public abstract void nonDispo();
        public abstract void dispo();
        public abstract String getType();
}
