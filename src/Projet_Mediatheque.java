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
		menu();
		
	}
	public static void menu()
	{
		clear();
		System.out.println("BONJOUR JE SUIS UNE MEDIATHEQUE");
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
}
