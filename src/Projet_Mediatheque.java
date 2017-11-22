import java.time.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Projet_Mediatheque {

    
    public static void main(String[] args) throws IOException {
        int Connexion = connexion();
    }
    
    public static int connexion() throws FileNotFoundException, IOException{
        // Boolean qui vérifie si la connexion est effectuée ou non.
        Boolean Connexion = false;
        // Entier qui vérifie de façon ternaire les identifiants de l'utilisateur.
        int Confirmation=0;
        do{
            System.out.println("Rentrez votre mail puis votre MDP");
            String Mail = Lire.S();
            String MDP = Lire.S();
            String Chemin="C:\\Users\\"+System.getProperty("user.name")+"\\Desktop";
            String Nom="Projet_Mediatheque";
            FileInputStream fichier = new FileInputStream(new File(Chemin+"\\"+Nom+".xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(fichier);
            XSSFSheet sheet = wb.getSheet("Adhérents");
            int iLigne=1;
            while(Confirmation==0){
                Row Ligne = sheet.getRow(iLigne);
                String cell=Ligne.getCell(3).getStringCellValue();
                String cell2=Ligne.getCell(4).getStringCellValue();
                if(cell.equals(Mail) && cell2.equals(MDP)){
                    Confirmation=2;
                }else if(!cell.equals("")){
                    iLigne++;
                }else{
                    Confirmation=3;
                }
            }
            if(Confirmation==3){
                sheet=wb.getSheet("Bibliothécaires");
                iLigne=1;
                while(Confirmation==3){
                    Row Ligne = sheet.getRow(iLigne);
                    Cell Cell=Ligne.getCell(3);
                    Cell Cell2=Ligne.getCell(4);
                    if(Cell.getStringCellValue().equals(Mail) && Cell2.getStringCellValue().equals(MDP)){
                        Confirmation=1;
                    }else if(!Cell.getStringCellValue().equals("")){
                        iLigne++;
                    }else{
                        Confirmation=0;
                    }
                }
            }
            switch(Confirmation){
                case 0:
                    System.out.println("Mauvais email ou mot de passe, veuillez réessayer");
                    break;
                case 1:
                    System.out.println("Vous êtes bien connecté en tant que bibliothécaire");
                    Connexion=true;
                    break;
                case 2:
                    System.out.println("Vous êtes bien connecté en tant qu'adhérent");
                    Connexion=true;
                    break;
            }
        }while(Connexion);
        return Confirmation;
    }
}
