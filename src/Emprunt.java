import java.time.*;

public class Emprunt 
{
	private Adherent emprunteur;
	private Ouvrage emprunte;
	private LocalDate date_Emprunt;
	private LocalDate date_Retour;
	private String type_Ouvrage;
        //Constructeur classique
	public Emprunt(Adherent pEmprunteur, Ouvrage pEmprunte)
	{
		this.emprunteur=pEmprunteur;
		this.emprunte=pEmprunte;
		this.date_Emprunt=LocalDate.now();
		this.date_Retour=this.date_Emprunt.plusWeeks(4);
                if(pEmprunte instanceof Roman)
                {
                        this.type_Ouvrage="Roman";
                }
                else
                {
                        this.type_Ouvrage="CD";
                }
	}
        //Constructeur pour la lecture du fichier texte
        public Emprunt(Adherent pEmprunteur, Ouvrage pEmprunte, LocalDate pEmprunt, LocalDate pRetour)
        {
                this.emprunteur=pEmprunteur;
		this.emprunte=pEmprunte;
		this.date_Emprunt=pEmprunt;
		this.date_Retour=pRetour;
                if(pEmprunte instanceof Roman)
                {
                        this.type_Ouvrage="Roman";
                }
                else
                {
                        this.type_Ouvrage="CD";
                }
        }
        //Methode toString()
	public String toString()
	{
		return "[Emprunt: Adhérent: "+this.emprunteur.getNum()+", Ouvrage: "+this.emprunte.getNum()+"\n"
                        + "Date 1: "+this.date_Emprunt+", Date 2: "+this.date_Retour+"\n"
                        + "Type :"+this.type_Ouvrage+"]"; 
	}
        
        public Adherent getAdh()
        {
                return this.emprunteur;
        }
        public Ouvrage getOuv()
        {
                return this.emprunte;
        }
        public LocalDate getDateE()
        {
                return this.date_Emprunt;
        }
        public LocalDate getDateR()
        {
                return this.date_Retour;
        }
        public String getType()
        {
                return this.type_Ouvrage;
        }
        
        public void prolonge()
	{
		this.date_Retour=this.date_Retour.plusDays(28);
	}
}
