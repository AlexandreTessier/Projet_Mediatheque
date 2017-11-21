import java.time.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Projet_Mediatheque {

    
    public static void main(String[] args) throws IOException {
        System.out.println("Rentrez votre mail puis votre MDP");
        String Mail = Lire.S();
        String MDP = Lire.S();
        String Chemin="C:\\Users\\"+System.getProperty("user.name")+"\\Desktop";
        String Nom="Projet_Mediatheque";
        FileInputStream fichier = new FileInputStream(new File(Chemin+"\\"+Nom+".xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fichier);
        XSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        int iLigne=1;
        Boolean Confirmation=false;
        while(Confirmation){
            Row Ligne = sheet.getRow(iLigne);
            Cell Cell=Ligne.getCell(3);
            if(Cell.getStringCellValue() == Mail){
                Cell=Ligne.getCell(4);
                if(Cell.getStringCellValue() == MDP){
                    Confirmation = true;
                }
            }else{
                iLigne++;
            }
        }
        System.out.println("Vous êtes bien connecté");
    }
}
