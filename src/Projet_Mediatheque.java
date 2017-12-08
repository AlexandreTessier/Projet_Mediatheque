import java.time.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Projet_Mediatheque 
{
	public static void main(String[] args) throws IOException 
	{
		Mediatheque Med = new Mediatheque();
		System.out.println("Bienvenue dans le logiciel système de la médiathèque. Veuillez indiquer par 1 ou 2 votre choix.\n"
                        + "\t1-Se connecter.\n"
                        + "\t2-S'inscrire.");
                int logIn=Lire.i();
                Personne Utilisateur;
                if(logIn==1)
                {
                     Utilisateur = logIn(Med);   
                }
                else
                {
                        Utilisateur = signIn(Med);
                }
                if(Utilisateur instanceof Adherent)
                {
                        menuAdherent(Med, (Adherent)Utilisateur);
                }
                else
                {
                        menuBibliothecaire(Med, (Bibliothecaire)Utilisateur);
                }
                System.out.println(logIn);
		Med.ecriture();
	}
        
	public static void menuAdherent(Mediatheque Med, Adherent Adh)
	{
		clear();
		System.out.println("BONJOUR JE SUIS UNE MEDIATHEQUE");
		System.out.println();
		
		
		
		
		
		
		
	}
        public static void menuBibliothecaire(Mediatheque Med, Bibliothecaire Bib)
        {
                clear();
                System.out.println("BONJOUR JE SUIS UNE PUTAIN DE MEDIATHEQUE");
		System.out.println();
        }
        public static Personne logIn(Mediatheque Med)
        {
                clear();
                System.out.println("Connexion");
                while(true)
                {
                        System.out.println("Veuillez donner votre mail");
                        String eMail=Lire.S();
                        System.out.println("Veuillez donner votre mot de passe");
                        String mdP=Lire.S();
                        for(int i=0; i<Med.getBib().size(); i++)
                        {
                                if(eMail.equals(Med.getBib().get(i).getMail()) && mdP.equals(Med.getBib().get(i).getMDP()))
                                        {
                                                return Med.getBib().get(i);
                                        }
                        }
                        for(int i=0; i<Med.getAdh().size(); i++)
                        {
                                if(eMail.equals(Med.getAdh().get(i).getMail()) && mdP.equals(Med.getAdh().get(i).getMDP()))
                                        {
                                                return Med.getAdh().get(i);
                                        }
                        }
                        System.out.println("Le mail ou le mot de passe est incorrect");
                }
        }
        public static Personne signIn(Mediatheque Med)
        {
                clear();
                System.out.println("Inscription");
                boolean bool;
                System.out.println("Veuillez donner votre Nom");
                String pNom=Lire.S();
                System.out.println("Veuillez donner votre Prénom");
                String pPrenom=Lire.S();
                System.out.println("Date de naissance: veuillez le jour");
                int pJour=Lire.i();
                System.out.println("Veuillez le mois");
                int pMois=Lire.i();
                System.out.println("Veuillez l'année");
                int pAnnee=Lire.i();
                LocalDate pDate = LocalDate.of(pAnnee, pMois, pJour);
                String eMail, mdP;
                do
                {
                        bool=false;
                        System.out.println("Veuillez donner votre mail");
                        eMail=Lire.S();
                        for(int i=0; i<Med.getBib().size(); i++)
                        {
                                if(eMail.equals(Med.getBib().get(i).getMail()))
                                {
                                        bool=true;
                                }
                        }
                        for(int i=0; i<Med.getAdh().size(); i++)
                        {
                                if(eMail.equals(Med.getAdh().get(i).getMail()))
                                {
                                        bool=true;
                                }
                        }
                        if(bool==true)
                        {
                                System.out.println("Ce mail est déjà utilisé, veuillez en chosir un autre.");
                        }
                }
                while(bool);
                do
                {
                        bool=false;
                        System.out.println("Veuillez donner votre mot de passe");
                        mdP=Lire.S();
                        System.out.println("Veuillez confirmer votre mot de passe");
                        String mdP2=Lire.S();
                        if(mdP.equals(mdP2))
                        {
                                bool=true;
                        }
                }
                while(!bool);
                int pID = Med.getAdh().size()+1;
                System.out.println("Veuillez donner votre numéro de téléphone");
                String pTel=Lire.S();
                Adherent Ad = new Adherent(pNom, pPrenom, pDate, eMail, mdP, pID, pTel);
                Med.ajouteAdh(Ad);
                return Ad;
        }
	//Methode qui nettoie l'affichage
	public static void clear()
	{
		String os = System.getProperty("os.name");
		if(os.contains("Windows"))
		{/*
			System.out.println("Va te faire foutre");
			Runtime.getRuntime().exec("cls");
		*/}
		else
		{
			System.out.print("\u001b[2J" + "\u001b[H");
			System.out.flush();
		}
	}
}
