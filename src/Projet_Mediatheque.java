import java.time.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Projet_Mediatheque {

    
    public static void main(String[] args) throws IOException {
        Mediatheque Med = new Mediatheque();
        Adherent Ad = new Adherent("pNom", "pPrenom", LocalDate.now(), "pMail", "pMDP", 01, 06);
        Auteur Aut = new Auteur("pNom", "pPrenom", LocalDate.now(), 01, "pStyle");
        Roman Rom = new Roman(01, "pTitre" , Aut, "pEditeur", 01, "pGenre", true);
        Emprunt Emp = new Emprunt(Ad, Rom);
        System.out.println(Emp.toString());
    }
    
}
