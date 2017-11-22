import java.time.*;

public class Reservation
{
	//Attribut d'instance
	private Adherent emprunteur;
	private Ouvrage emprunte;
	//Constructeur 
	public Reservation(Adherent pEmprunteur, Ouvrage pEmprunte)
	{
		this.emprunteur=pEmprunteur;
		this.emprunte=pEmprunte;
	}
	//Methode qui annule la reservation
	public void anullerReservation()
	{
		//this=null;
	}
	//Methode toString()
	public String toString()
	{
		return "Reservation";
	}
}
