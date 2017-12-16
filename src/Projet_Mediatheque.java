import java.time.*;
import java.io.IOException;
import java.util.ArrayList;

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
                                + "\t4-Rendre un ouvrage.\n"
                                + "\t5-Annuler une réservation.\n"
                                + "\t6-Se déconnecter.");
                        int Choix=Lire.i();
                        switch(Choix)
                        {
                                case 1:
                                        emprunter(Med, Adh);
                                break;
                                case 2:
                                        reserver(Med, Adh);
                                break;
                                case 3:
                                        recherche(Med); 
                                break;
                                case 4:
                                        rendre(Med,Adh);
                                break;
                                case 5:
                                        annulerReservation(Med,Adh);
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
                boolean Quitter=false;
                while(!Quitter)
                {
                        clear();
                        System.out.println("Bonjour, "+Bib.getPrenom()+". Vous êtes sur le menu de la médiathèque, veuillez indiquer votre choix d'opération.\n"
                                + "\t1-Créer bibliothécaire.\n"
                                + "\t2-Changer mot de passe administrateur.\n"
                                + "\t3-Supprimer adhérent.\n"
                                + "\t4-Ajouter ouvrage.\n"
                                + "\t5-Se déconnecter.");
                        int Choix=Lire.i();
                        /*switch(Choix)
                        {
                                case 1:
                                        creerBib(Med, Bib);
                                break;
                                case 2:
                                        if(Bib.getprenom().equals("Admin"))
                                        {
						changerAdmMdp(Med,Bib);
					}
					else
					{
						System.out.println("Accès refusé, vous n'êtes pas administrateur");
					}
                                break;
                                case 3:
                                        supprimeAdh(Med); 
                                break;
                                case 4:
                                        ajouteOuvrage(Med);
                                break;
                                case 5:
                                        Quitter=true;
                                        System.out.println("Vous avez été déconnecté avec succès.");
                                break;
                                default:
                                        System.out.println("Commande non-reconnue, veuillez ré-essayer.");
                                break;
                        }*/
                }
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
        //Methode qui vérifie les possibilités de réservation, et qui rajoute une réservation si possible
        public static void reserver(Mediatheque Med, Adherent Adh)
        {
                int nbreResa=0;
                if(Med.comparerDatesEmprunts(Adh))
                {
                        System.out.println("Vous avez un ou plusieurs ouvrage en retard, réservation impossible.");
                }
                else
                {
                       nbreResa = Med.rechercheResa(Adh);
                        if(nbreResa>=3)
                        {
                                System.out.println("Vous avez réservé trop d'ouvrages, échec de la réservation.");
                        } 
                        else
                        {
                                int choix=0;
                                while(true)
                                {
                                        System.out.println("Veuillez renseigner le type d'Ouvrage que vous voulez emprunter.\n"
                                        + "\t1-Roman,\n"
                                        + "\t2-CD.");
                                        choix=Lire.i();
                                        if(choix!=1 && choix!=2)
                                        {
                                                System.out.println("Commande non reconnue, veuillez taper 1 ou 2.");
                                        }
                                        else
                                        {
                                                break;
                                        }
                                }
                                System.out.println("Veuillez donner le numéro de l'ouvrage que vous voulez réserver.");
                                int ouv=Lire.i();
                                if(choix==1)
                                {
                                        if(Med.getRom().size()>=ouv)
                                        {
                                                if(Med.resaPossible(Med.getRom().get(ouv), "Roman"))
                                                {
                                                        Reservation Resa=new Reservation(Adh, Med.getRom().get(ouv));
                                                        Med.ajouteResa(Resa);
                                                        System.out.println("Réservation réussie.");
                                                }
                                                else
                                                {
                                                        System.out.println("Le Roman voulu est déjà réservé, échec de la réservation.");
                                                }
                                        }
                                        else
                                        {
                                                System.out.println("Il n'y a pas de Roman portant ce numéro. Echec de la réservation.");
                                        }
                                }
                                else
                                {
                                        if(Med.getCD().size()>=ouv)
                                        {
                                                if(Med.resaPossible(Med.getCD().get(ouv), "CD"))
                                                {
                                                        Reservation Resa=new Reservation(Adh, Med.getCD().get(ouv));
                                                        Med.ajouteResa(Resa);
                                                        System.out.println("Réservation réussie.");
                                                }
                                                else
                                                {
                                                        System.out.println("Le CD voulu est déjà réservé, échec de la réservation.");
                                                }
                                        }
                                        else
                                        {
                                                System.out.println("Il n'y a pas de CD portant ce numéro. Echec de la réservation.");
                                        }
                                }
                        }
                }
        }
        //Methode qui affiche tout les emprunt d'un adherent et génére une liste de ces emprunts 
        public static ArrayList<Emprunt> afficherListeEmprunts(Mediatheque Med, Adherent Adh)
        {
		ArrayList<Emprunt> AdhEmp = new ArrayList();
		System.out.println("Emprunts de : " + Adh.toString());
		for(int i=0; i<Med.getEmp().size();i++ )
		{
			if(Med.getEmp().get(i).getAdh().getNum()==Adh.getNum())
			{
				System.out.println("["+AdhEmp.size()+"]" + Med.getEmp().get(i).getOuv().toString());
				AdhEmp.add(Med.getEmp().get(i));
			}
		}
		return AdhEmp;
        }
        //Methode qui permet a adherent de rendre un ouvrage
        public static void rendre(Mediatheque Med, Adherent Adh)
        {
		ArrayList<Emprunt> AdhEmp = afficherListeEmprunts(Med,Adh);
		if(AdhEmp.isEmpty())
		{
			System.out.println("Aucun emprunt !");
			return;
		}
		System.out.println("Quel ouvrage souhaitez vous rendre ? (entrez le numéro correspondant) ");
		int id = Lire.i();
		while(id>=AdhEmp.size())
		{
			System.out.println("L'emprunt que vous avez demandé n'existe pas !");
			id = Lire.i();
		}
		for(int i=0; i<Med.getEmp().size();i++)
		{
			if(AdhEmp.get(id).toString().equals(Med.getEmp().get(i).toString()))
			{
				Med.supprimeEmprunt(i);
				System.out.println("L'ouvrage a été rendu !");
				return;
			} 
		}
		        
        }
        //Methode qui affiche toutes les réservations d'un adherent et génére une liste de ces réservations 
        public static ArrayList<Reservation> afficherListeReservations(Mediatheque Med, Adherent Adh)
        {
		ArrayList<Reservation> AdhResa = new ArrayList();
		System.out.println("Réservations de : " + Adh.toString());
		for(int i=0; i<Med.getResa().size();i++ )
		{
			if(Med.getResa().get(i).getAdh().getNum()==Adh.getNum())
			{
				System.out.println("["+AdhResa.size()+"]" + Med.getResa().get(i).getOuv().toString());
				AdhResa.add(Med.getResa().get(i));
			}
		}
		return AdhResa;
        }
        //Methode qui permet a adherent de rendre un ouvrage
        public static void annulerReservation(Mediatheque Med, Adherent Adh)
        {
		ArrayList<Reservation> AdhResa = afficherListeReservations(Med,Adh);
		if(AdhResa.isEmpty())
		{
			System.out.println("Aucune réservation !");
			return;
		}
		System.out.println("Quelle réservation souhaitez-vous annuler ? (entrez le numéro correspondant) ");
		int id = Lire.i();
		while(id>=AdhResa.size())
		{
			System.out.println("La réservation que vous avez demandée n'existe pas !");
			id = Lire.i();
		}
		for(int i=0; i<Med.getResa().size();i++)
		{
			if(AdhResa.get(id).toString().equals(Med.getResa().get(i).toString()))
			{
				Med.supprimeReservation(i);
				System.out.println("La réservation a été annulée !");
				return;
			} 
		}
		        
        }
        //Methode qui recherche des ouvrages selon les caractéristiques demandées
       public static void recherche(Mediatheque Med)
        {
                ArrayList<Ouvrage> liste=new ArrayList();
                liste.addAll(Med.getRom());
                liste.addAll(Med.getCD());
                boolean T=true;
                while(T)
                {
                        System.out.println("Veuillez donner indiquer la caractéristique que vous voulez ajouter à la recherche.\n"
                                + "\t1-Par Auteur.\n"
                                + "\t2-Par type d'Ouvrage (Roman, CD).\n"
                                + "\t3-Par titre.\n"
                                + "\t4-Par disponibilité.\n"
                                + "\t5-Par Editeur.\n"
                                + "\t6-Fin des critères.");
                        int choix=Lire.i();
                        switch(choix)
                        {
                                case 1:
                                        System.out.println("Veuillez donner le prénom puis le nom de l'Auteur:");
                                        String prenom=Lire.S();
                                        String nom=Lire.S();
                                        for(int i=0; i<liste.size(); i++)
                                        {
                                                if(!liste.get(i).getAut().getPrenom().equals(prenom))
                                                {
                                                        if(!liste.get(i).getAut().getNom().equals(nom))
                                                        {
                                                                liste.remove(i);
                                                        }
                                                }
                                        }
                                break;
                                case 2:
                                        System.out.println("Veuillez donner le type d'Ouvrage (1 pour Roman et 2 pour CD):");
                                        int type=Lire.i();
                                        if(type==1)
                                        {
                                                for(int i=0; i<liste.size(); i++)
                                                {
                                                        if(liste.get(i) instanceof CD)
                                                        {
                                                                liste.remove(i);
                                                        }
                                                }
                                        }
                                        else if (type==2)
                                        {
                                                for(int i=0; i<liste.size(); i++)
                                                {
                                                        if(liste.get(i) instanceof Roman)
                                                        {
                                                                liste.remove(i);
                                                        }
                                                }
                                        }
                                break;
                                case 3:
                                        System.out.println("Veuillez donner le titre de l'Ouvrage.");
                                        String titre=Lire.S();
                                        for(int i=0; i<liste.size(); i++)
                                        {
                                                if(!liste.get(i).getTitre().equals(titre))
                                                {
                                                        liste.remove(i);
                                                }
                                        }
                                break;
                                case 4:
                                        System.out.println("La recherche n'affichera que des Ouvrages disponibles.");
                                        for(int i=0; i<liste.size(); i++)
                                        {
                                                if(!liste.get(i).getDispo())
                                                {
                                                        liste.remove(i);
                                                }
                                        }
                                break;
                                case 5:
                                        System.out.println("Veuillez donner l'éditeur de l'Ouvrage");
                                        String editeur=Lire.S();
                                        for(int i=0; i<liste.size(); i++)
                                        {
                                                if(!liste.get(i).getEdit().equals(editeur))
                                                {
                                                        liste.remove(i);
                                                }
                                        }
                                break;
                                case 6:
                                        T=false;
                                break;
                        }
                }
                System.out.println("Liste des Ouvrages:");
                for(int i=0; i<liste.size(); i++)
                {
                        System.out.println("Test");
                        System.out.println(liste.get(i).toString());
                }
        }
}
