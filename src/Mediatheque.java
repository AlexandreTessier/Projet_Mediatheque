import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mediatheque
{
        private ArrayList<Adherent> Adherents;
        private ArrayList<Bibliothecaire> Bibliothecaires;
        private ArrayList<Auteur> Auteurs;
        private ArrayList<Roman> Romans;
        private ArrayList<CD> CDs;
        private ArrayList<Emprunt> Emprunts;
        private ArrayList<Reservation> Reservations;
        public Mediatheque() throws IOException
        {
                this.Adherents = new ArrayList();
                this.Bibliothecaires = new ArrayList();
                this.Auteurs = new ArrayList();
                this.Romans = new ArrayList();
                this.CDs = new ArrayList();
                this.Emprunts = new ArrayList();
                this.Reservations = new ArrayList();
                this.recupeAdh();
                this.recupeBib();
                this.recupeAut();
                this.recupeRom();
                this.recupeCD();
                this.recupeEmp();
                this.recupeResa();
                
        }
        
        public void recupeAdh()
        {
                try
                {
                        File f = new File ("Adherents.txt");
                        FileReader fr = new FileReader (f);
                        BufferedReader br = new BufferedReader (fr);
                        try
                        {
                                String line = br.readLine();
                                line = br.readLine();
                                while (line != null)
                                {
                                        String[] Temp = line.split("\t");
                                        String[] pDate = Temp[2].split("-");
                                        int year = Integer.parseInt(pDate[0]);
                                        int month = Integer.parseInt(pDate[1]);
                                        int day = Integer.parseInt(pDate[2]);
                                        LocalDate date = LocalDate.of(year, month, day);
                                        int iD = Integer.parseInt(Temp[5]);
                                        Adherent Ad = new Adherent(Temp[0], Temp[1], date, Temp[3], Temp[4], iD, Temp[6]);
                                        this.Adherents.add(Ad);
                                        
                                        System.out.println();
                                        line = br.readLine();
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (FileNotFoundException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void recupeBib()
        {
                try
                {
                        File f = new File ("Bibliothecaires.txt");
                        FileReader fr = new FileReader (f);
                        BufferedReader br = new BufferedReader (fr);
                        try
                        {
                                String line = br.readLine();
                                line = br.readLine();
                                while (line != null)
                                {
                                        String[] Temp = line.split("\t");
                                        String[] pDate = Temp[2].split("-");
                                        int year = Integer.parseInt(pDate[0]);
                                        int month = Integer.parseInt(pDate[1]);
                                        int day = Integer.parseInt(pDate[2]);
                                        LocalDate date = LocalDate.of(year, month, day);
                                        Bibliothecaire Bi = new Bibliothecaire(Temp[0], Temp[1], date, Temp[3], Temp[4]);
                                        this.Bibliothecaires.add(Bi);
                                        line = br.readLine();
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (FileNotFoundException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void recupeAut()
        {
                try
                {
                        File f = new File ("Auteurs.txt");
                        FileReader fr = new FileReader (f);
                        BufferedReader br = new BufferedReader (fr);
                        try
                        {
                                String line = br.readLine();
                                line = br.readLine();
                                while (line != null)
                                {
                                        String[] Temp = line.split("\t");
                                        String[] pDate = Temp[2].split("-");
                                        int year = Integer.parseInt(pDate[0]);
                                        int month = Integer.parseInt(pDate[1]);
                                        int day = Integer.parseInt(pDate[2]);
                                        LocalDate date = LocalDate.of(year, month, day);
                                        int num = Integer.parseInt(Temp[3]);
                                        Auteur Aut = new Auteur(Temp[0], Temp[1], date, num, Temp[4]);
                                        this.Auteurs.add(Aut);
                                        line = br.readLine();
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (FileNotFoundException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        public void recupeRom()
        {
                try
                {
                        File f = new File ("Romans.txt");
                        FileReader fr = new FileReader (f);
                        BufferedReader br = new BufferedReader (fr);
                        try
                        {
                                String line = br.readLine();
                                line = br.readLine();
                                while (line != null)
                                {
                                        String[] Temp = line.split("\t");
                                        int pNum = Integer.parseInt(Temp[0]);
                                        Auteur pAut = this.rechercheAuteur(Integer.parseInt(Temp[2]));
                                        int nombrePages = Integer.parseInt(Temp[4]);
                                        boolean bool = Boolean.parseBoolean(Temp[6]);
                                        Roman Rom = new Roman(pNum, Temp[1], pAut, Temp[3], nombrePages, Temp [5], bool);
                                        this.Romans.add(Rom);
                                        line = br.readLine();
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (FileNotFoundException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void recupeCD()
        {
                try
                {
                        File f = new File ("CDs.txt");
                        FileReader fr = new FileReader (f);
                        BufferedReader br = new BufferedReader (fr);
                        try
                        {
                                String line = br.readLine();
                                line = br.readLine();
                                while (line != null)
                                {
                                        String[] Temp = line.split("\t");
                                        int pNum = Integer.parseInt(Temp[0]);
                                        Auteur pAut = this.rechercheAuteur(Integer.parseInt(Temp[2]));
                                        boolean bool = Boolean.parseBoolean(Temp[4]);
                                        ArrayList<String> Liste = new ArrayList();
                                        for(int i=5; i<Temp.length; i++)
                                        {
                                                Liste.add(Temp[i]);
                                        }
                                        CD Cd = new CD(pNum, Temp[1], pAut, Temp[3], bool, Liste);
                                        this.CDs.add(Cd);
                                        line = br.readLine();
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (FileNotFoundException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void recupeEmp()
        {
                try
                {
                        File f = new File ("Emprunts.txt");
                        FileReader fr = new FileReader (f);
                        BufferedReader br = new BufferedReader (fr);
                        try
                        {
                                String line = br.readLine();
                                line = br.readLine();
                                while (line != null)
                                {
                                        String[] Temp = line.split("\t");
                                        Adherent pAd = this.rechercheAdherent(Integer.parseInt(Temp[0]));
                                        Ouvrage pOuv = this.rechercheOuvrage(Integer.parseInt(Temp[1]), Temp[4]);
                                        String[] pDate = Temp[2].split("-");
                                        int year = Integer.parseInt(pDate[0]);
                                        int month = Integer.parseInt(pDate[1]);
                                        int day = Integer.parseInt(pDate[2]);
                                        LocalDate dateEmp = LocalDate.of(year, month, day);
                                        pDate = Temp[3].split("-");
                                        year = Integer.parseInt(pDate[0]);
                                        month = Integer.parseInt(pDate[1]);
                                        day = Integer.parseInt(pDate[2]);
                                        LocalDate dateRet = LocalDate.of(year, month, day);
                                        Emprunt Emp = new Emprunt(pAd, pOuv, dateEmp, dateRet);
                                        this.Emprunts.add(Emp);
                                        line = br.readLine();
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (FileNotFoundException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void recupeResa()
        {
                try
                {
                        File f = new File ("Reservations.txt");
                        FileReader fr = new FileReader (f);
                        BufferedReader br = new BufferedReader (fr);
                        try
                        {
                                String line = br.readLine();
                                line = br.readLine();
                                while (line != null)
                                {
                                        String[] Temp = line.split("\t");
                                        Adherent pAd = this.rechercheAdherent(Integer.parseInt(Temp[0]));
                                        Ouvrage pOuv = this.rechercheOuvrage(Integer.parseInt(Temp[1]), Temp[2]);
                                        Reservation Resa = new Reservation(pAd, pOuv);
                                        this.Reservations.add(Resa);
                                        line = br.readLine();
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (FileNotFoundException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void ecriture()
        {
                this.ecritureAdh();
                this.ecritureBib();
                this.ecritureAut();
                this.ecritureRom();
                this.ecritureCD();
                this.ecritureEmp();
                this.ecritureResa();
        }
        
        public void ecritureAdh()
        {
                try
                {
                        File f = new File ("Adherents.txt");
                        FileWriter fr = new FileWriter (f);
                        BufferedWriter br = new BufferedWriter (fr);
                        try
                        {
                                String line = "Nom\tPrenom\tDate_Naissance\tMail\tMdP\tID\tTel";
                                br.write(line);
                                for(int i=0; i<this.Adherents.size(); i++)
                                {
                                        br.newLine();
                                        String pNom = this.Adherents.get(i).getNom();
                                        String pPrenom = this.Adherents.get(i).getPrenom();
                                        String pDate = this.Adherents.get(i).getdate().toString();
                                        String pMail = this.Adherents.get(i).getMail();
                                        String pMDP = this.Adherents.get(i).getMDP();
                                        String pID = Integer.toString(this.Adherents.get(i).getNum());
                                        String pTel = this.Adherents.get(i).getTel();
                                        line = pNom+"\t"+pPrenom+"\t"+pDate+"\t"+pMail+"\t"+pMDP+"\t"+pID+"\t"+pTel;
                                        br.write(line);
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (IOException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void ecritureBib()
        {
                try
                {
                        File f = new File ("Bibliothecaires.txt");
                        FileWriter fr = new FileWriter (f);
                        BufferedWriter br = new BufferedWriter (fr);
                        try
                        {
                                String line = "Nom\tPrenom\tDate_Naissance\tMail\tMdP";
                                br.write(line);
                                for(int i=0; i<this.Bibliothecaires.size(); i++)
                                {
                                        br.newLine();
                                        String pNom = this.Bibliothecaires.get(i).getNom();
                                        String pPrenom = this.Bibliothecaires.get(i).getPrenom();
                                        String pDate = this.Bibliothecaires.get(i).getdate().toString();
                                        String pMail = this.Bibliothecaires.get(i).getMail();
                                        String pMDP = this.Bibliothecaires.get(i).getMDP();
                                        line = pNom+"\t"+pPrenom+"\t"+pDate+"\t"+pMail+"\t"+pMDP;
                                        br.write(line);
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (IOException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void ecritureAut()
        {
                try
                {
                        File f = new File ("Auteurs.txt");
                        FileWriter fr = new FileWriter (f);
                        BufferedWriter br = new BufferedWriter (fr);
                        try
                        {
                                String line = "Nom\tPrenom\tDate_Naissance\tNuméro\tStyle";
                                br.write(line);
                                for(int i=0; i<this.Auteurs.size(); i++)
                                {
                                        br.newLine();
                                        String pNom = this.Auteurs.get(i).getNom();
                                        String pPrenom = this.Auteurs.get(i).getPrenom();
                                        String pDate = this.Auteurs.get(i).getdate().toString();
                                        String pID = Integer.toString(this.Auteurs.get(i).getNum());
                                        String pStyle = this.Auteurs.get(i).getStyle();
                                        line = pNom+"\t"+pPrenom+"\t"+pDate+"\t"+pID+"\t"+pStyle;
                                        br.write(line);
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (IOException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void ecritureRom()
        {
                try
                {
                        File f = new File ("Romans.txt");
                        FileWriter fr = new FileWriter (f);
                        BufferedWriter br = new BufferedWriter (fr);
                        try
                        {
                                String line = "Numéro\tTitre\tnumAut\tEditeur\tNombrePages\tGenre\tDisponibilité";
                                br.write(line);
                                for(int i=0; i<this.Romans.size(); i++)
                                {
                                        br.newLine();
                                        String pNum = Integer.toString(this.Romans.get(i).getNum());
                                        String pTitre = this.Romans.get(i).getTitre();
                                        String pAut = Integer.toString(this.Romans.get(i).getAut().getNum());
                                        String pEdit = this.Romans.get(i).getEdit();
                                        String pNbre = Integer.toString(this.Romans.get(i).getNbre());
                                        String pGenre = this.Romans.get(i).getGenre();
                                        String pDispo = Boolean.toString(this.Romans.get(i).getDispo());
                                        line = pNum+"\t"+pTitre+"\t"+pAut+"\t"+pEdit+"\t"+pNbre+"\t"+pGenre+"\t"+pDispo;
                                        br.write(line);
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (IOException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void ecritureCD()
        {
                try
                {
                        File f = new File ("CDs.txt");
                        FileWriter fr = new FileWriter (f);
                        BufferedWriter br = new BufferedWriter (fr);
                        try
                        {
                                String line = "Numéro\tTitre\tnumAut\tEditeur\tDisponibilité\tListe_Chansons";
                                br.write(line);
                                for(int i=0; i<this.CDs.size(); i++)
                                {
                                        br.newLine();
                                        String pNum = Integer.toString(this.CDs.get(i).getNum());
                                        String pTitre = this.CDs.get(i).getTitre();
                                        String pAut = Integer.toString(this.CDs.get(i).getAut().getNum());
                                        String pEdit = this.CDs.get(i).getEdit();
                                        String pDispo = Boolean.toString(this.CDs.get(i).getDispo());
                                        String pListe = "";
                                        for(int j=0; j<this.CDs.get(i).getListe().size(); j++)
                                        {
                                                pListe = pListe+"\t"+this.CDs.get(i).getListe().get(j);
                                        }
                                        line = pNum+"\t"+pTitre+"\t"+pAut+"\t"+pEdit+"\t"+pDispo+pListe;
                                        br.write(line);
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (IOException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void ecritureEmp()
        {
                try
                {
                        File f = new File ("Emprunts.txt");
                        FileWriter fr = new FileWriter (f);
                        BufferedWriter br = new BufferedWriter (fr);
                        try
                        {
                                String line = "Numéro_Adh\tNuméro_Ouv\tDate_Emprunt\tDate_Retour\tType_Ouvrage";
                                br.write(line);
                                for(int i=0; i<this.Emprunts.size(); i++)
                                {
                                        br.newLine();
                                        String pNumAdh = Integer.toString(this.Emprunts.get(i).getAdh().getNum());
                                        String pNumOuv = Integer.toString(this.Emprunts.get(i).getOuv().getNum());
                                        String pDateE = this.Emprunts.get(i).getDateE().toString();
                                        String pDateR = this.Emprunts.get(i).getDateR().toString();
                                        String pType = this.Emprunts.get(i).getType();
                                        line = pNumAdh+"\t"+pNumOuv+"\t"+pDateE+"\t"+pDateR+"\t"+pType;
                                        br.write(line);
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (IOException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public void ecritureResa()
        {
                try
                {
                        File f = new File ("Reservations.txt");
                        FileWriter fr = new FileWriter (f);
                        BufferedWriter br = new BufferedWriter (fr);
                        try
                        {
                                String line = "Numéro_Adh\tNuméro_Ouv\tType_Ouvrage";
                                br.write(line);
                                for(int i=0; i<this.Reservations.size(); i++)
                                {
                                        br.newLine();
                                        String pNumAdh = Integer.toString(this.Reservations.get(i).getAdh().getNum());
                                        String pNumOuv = Integer.toString(this.Reservations.get(i).getOuv().getNum());
                                        String pType = this.Reservations.get(i).getType();
                                        line = pNumAdh+"\t"+pNumOuv+"\t"+pType;
                                        br.write(line);
                                }
                                br.close();
                                fr.close();
                        }
                        catch (IOException exception)
                        {
                                System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                        }
                }
                catch (IOException exception)
                {
                        System.out.println ("Le fichier n'a pas été trouvé");
                }
        }
        
        public Auteur rechercheAuteur(int pnum)
        {
                for(int i=0; i<this.Auteurs.size(); i++){
                        if(pnum == this.Auteurs.get(i).getNum())
                        {
                                return this.Auteurs.get(i);
                        }
                }
                return null;
        }
        public Adherent rechercheAdherent(int pnum)
        {
                for(int i=0; i<this.Adherents.size(); i++){
                        if(pnum == this.Adherents.get(i).getNum())
                        {
                                return this.Adherents.get(i);
                        }
                }
                return null;
        }
        public Ouvrage rechercheOuvrage(int pnum, String pGenre)
        {
                if(pGenre.equals("Roman"))
                {
                        for(int i=0; i<this.Romans.size(); i++){
                                if(pnum == this.Romans.get(i).getNum())
                                {
                                        return this.Romans.get(i);
                                }
                        }
                }
                else
                {
                       for(int i=0; i<this.CDs.size(); i++){
                                if(pnum == this.CDs.get(i).getNum())
                                {
                                        return this.CDs.get(i);
                                }
                        } 
                }
                return null;
        }
        
}
