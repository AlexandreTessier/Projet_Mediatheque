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
                boolean Quitter=false;
                while(!Quitter)
                {
                       System.out.println("Bienvenue dans le logiciel système de la médiathèque. Veuillez indiquer par 1 ou 2 votre choix.\n"
                                + "\t1-Se connecter.\n"
                                + "\t2-S'inscrire.\n"
                                + "\t3-Quitter le logiciel.");
                        int logIn=Lire.i();
                        Personne Utilisateur = null;
                        switch(logIn)
                        {
                                case 1:
                                        Utilisateur = logIn(Med);
                                        if(Utilisateur instanceof Adherent)
                                        {
                                                menuAdherent(Med, (Adherent)Utilisateur);
                                        }
                                        else
                                        {
                                                menuBibliothecaire(Med, (Bibliothecaire)Utilisateur);
                                        }
                                break;
                                case 2:
                                        Utilisateur = signIn(Med);
                                        menuAdherent(Med, (Adherent)Utilisateur);
                                break;
                                case 3:
                                        Quitter=true;
                                break;
                                default:
                                        System.out.println("Commande non-reconnue, veuillez ré-essayer.");
                                break;
                        }
                }
		
		Med.ecriture();
	}
        //Méthode qui connecte un utilisateur déjà inscrit
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
        //Méthode qui fait s'inscrire un nouvel adhérent
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
                        else
                        {
                                System.out.println("Les deux mots de passe donnés ne correspontent pas.");
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
        //Menu qui apparaît si l'utilisateur est un adhérent
	public static void menuAdherent(Mediatheque Med, Adherent Adh)
	{
                boolean Quitter=false;
                while(!Quitter)
                {
                        clear();
                        System.out.println("Bonjour, "+Adh.getPrenom()+". Vous êtes sur le menu de la médiathèque, veuillez indiquer votre choix d'opération.\n"
                                + "\t1-Emprunter.\n"
                                + "\t2-Réserver.\n"
                                + "\t3-Effectuer une recherche.\n"
                                + "\t4-Rendre un document.\n"
                                + "\t5-Annuler une réservation.\n"
                                + "\t6-Se déconnecter.");
                        int Choix=Lire.i();
                        switch(Choix)
                        {
                                case 1:
                                        emprunter(Med, Adh);
                                break;
                                case 2:
                                        //Regarder les emprunts en retard
                                        //Compter les réservations
                                        //S'il n'y en a pas: réserver si ouvrage dispo
                                break;
                                case 3:
                                        //Caractéristiques dispo: num auteur, type ouvrage, genre ouvrage, 
                                break;
                                case 4:
                                        //Affiche les emprunts
                                        //Rends l'ouvrage grâce à son numéro
                                break;
                                case 5:
                                        //Affiche les réservations
                                        //Annule la résa grâce à son num
                                break;
                                case 6:
                                        Quitter=true;
                                        System.out.println("Vous avez été déconnecté avec succès.");
                                break;
                                default:
                                        System.out.println("Commande non-reconnue, veuillez ré-essayer.");
                                break;
                        }
                }
		
		
		
	}
        //Menu qui apparaît si l'utilisateur est un bibliothécaire
        public static void menuBibliothecaire(Mediatheque Med, Bibliothecaire Bib)
        {
                clear();
                System.out.println("BONJOUR JE SUIS UNE PUTAIN DE MEDIATHEQUE");
                //Ajouter un ouvrage
                //Supprimer ouvrage: troll on ne peut pas car j'ai mal programmé la gestion des numéros des bouquins
		System.out.println();
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
        //Methode qui vérifie les possibilités d'emprunt, et qui rajoute un emprunt si possible
        public static void emprunter(Mediatheque Med, Adherent Adh)
        {
                boolean T = true;
                int nbreEmprunts=0, choix=0;
                String S="";
                if(Med.comparerDatesEmprunts(Adh))
                {
                        System.out.println("Vous avez un ou plusieurs ouvrage en retard, emprunt impossible.");
                }
                else
                {
                        while(T)
                        {
                                System.out.println("Veuillez renseigner le type d'Ouvrage que vous voulez emprunter.\n"
                                + "\t1-Roman,\n"
                                + "\t2-CD.");
                                choix=Lire.i();
                                switch(choix)
                                {
                                        case 1:
                                                T=false;
                                                S="Roman";
                                        break;
                                        case 2:
                                                T=false;
                                                S="CD";

                                        break;
                                        default:
                                                System.out.println("Commande non reconnue, veuillez taper 1 ou 2.");
                                        break;
                                }
                        }
                        nbreEmprunts = Med.rechercheEmprunts(Adh, S);
                        if(nbreEmprunts>=5)
                        {
                                System.out.println("Vous avez emprunté trop de "+S+"s, échec de l'emprunt.");
                        }
                        else
                        {
                                System.out.println("Veuillez renseigner le numéro de l'ouvrage que vous voulez emprunter.");
                                int num=Lire.i();
                                switch(choix)
                                {
                                        case 1:
                                                if(Med.getRom().size()>=num)
                                                {
                                                        T=Med.getRom().get(num-1).getDispo();
                                                        if(T)
                                                        {
                                                                Emprunt Emp = new Emprunt(Adh, Med.getRom().get(num-1));
                                                                Med.ajouteEmp(Emp);
                                                                System.out.println("L'emprunt est un succès.");
                                                        }
                                                        else
                                                        {
                                                                System.out.println("Le roman demandé n'est pas disponible, l'emprunt est donc impossible.");
                                                        }
                                                }
                                                else
                                                {
                                                        System.out.println("Il n'y a pas de roman portant le numéro "+num+". Emprunt impossible.");
                                                }
                                        break;
                                        case 2:
                                                if(Med.getCD().size()>=num)
                                                {
                                                        T=Med.getCD().get(num-1).getDispo();
                                                        if(T)
                                                        {
                                                                Emprunt Emp = new Emprunt(Adh, Med.getCD().get(num-1));
                                                                Med.ajouteEmp(Emp);
                                                                System.out.println("L'emprunt est un succès.");
                                                        }
                                                        else
                                                        {
                                                                System.out.println("Le CD demandé n'est pas disponible, l'emprunt est donc impossible.");
                                                        }
                                                }
                                                else
                                                {
                                                        System.out.println("Il n'y a pas de CD portant le numéro "+num+". Emprunt impossible.");
                                                }
                                        break;
                                }
                        }
                }
        }
}
