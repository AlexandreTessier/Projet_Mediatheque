import java.time.*;

public class Reservation
{
	//Attribut d'instance
	private Adherent emprunteur;
	private Ouvrage emprunte;
        private String type_Ouvrage;
	//Constructeur 
	public Reservation(Adherent pEmprunteur, Ouvrage pEmprunte)
	{
		this.emprunteur=pEmprunteur;
		this.emprunte=pEmprunte;
                if(pEmprunte instanceof Roman)
                {
                        this.type_Ouvrage="Roman";
                }
                else
                {
                        this.type_Ouvrage="CD";
                }
	}
	//Methode qui annule la reservation
	public void anulerReservation()
	{
		//this=null;
	}
	//Methode toString()
	public String toString()
	{
		return "Reservation";
	}
        
        public Adherent getAdh()
        {
                return this.emprunteur;
        }
        public Ouvrage getOuv()
        {
                return this.emprunte;
        }
        public String getType()
        {
                return this.type_Ouvrage;
        }
}
