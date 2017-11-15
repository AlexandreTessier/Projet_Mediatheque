package Operations;
import Personne.*;
import Ouvrage.*;
import java.time.*;

public class Emprunt {
    private Adherent emprunteur;
    private Ouvrage emprunte;
    private LocalDate date_Emprunt;
    private LocalDate date_Retour;
    private String type_Ouvrage;
    
    public Emprunt(Adherent pEmprunteur, Ouvrage pEmprunte){
        this.emprunteur=pEmprunteur;
        this.emprunte=pEmprunte;
        this.date_Emprunt=LocalDate.now();
        this.date_Retour=this.date_Emprunt.plusWeeks(4);
        this.type_Ouvrage="Ouvrage";
    }
    
    public void prolonge(){
        this.date_Retour=this.date_Retour.plusDays(28);
    }
}
