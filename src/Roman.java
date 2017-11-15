import java.time.*;

public class Roman extends Ouvrage{
    private int nombre_pages;
    
    public Roman(int pNum, String pTitre, Auteur pAuteur, String pEditeur, int pNombre) {
        this.numero=pNum;
        this.titre=pTitre;
        this.auteur=pAuteur;
        this.disponibilite=true;
        this.editeur=pEditeur;
        this.nombre_pages=pNombre;
    }
    
    public String toString(){
        return "Roman";
    }
}
