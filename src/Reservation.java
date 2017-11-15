import java.time.*;

public class Reservation {
    private Adherent emprunteur;
    private Ouvrage emprunte;
    
    public Reservation(Adherent pEmprunteur, Ouvrage pEmprunte){
        this.emprunteur=pEmprunteur;
        this.emprunte=pEmprunte;
    }
    
    public void anullerReservation(){
        //this=null;
    }
    
    public String toString(){
        return "Emprunt";
    }
}
