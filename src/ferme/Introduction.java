package ferme;

import java.util.Scanner;

import tours.Game;
import tours.Moteur;

public class Introduction {

	public static void loadIntro() {

		Scanner sc = new Scanner(System.in);

		System.out.println("_______  ___   _______  __    _  __   __  _______  __    _  __   __  _______ \n"
				+ "|  _    ||   | |       ||  |  | ||  | |  ||       ||  |  | ||  | |  ||       |\n"
				+ "| |_|   ||   | |    ___||   |_| ||  |_|  ||    ___||   |_| ||  | |  ||    ___|\n"
				+ "|       ||   | |   |___ |       ||       ||   |___ |       ||  |_|  ||   |___ \n"
				+ "|  _   | |   | |    ___||  _    ||       ||    ___||  _    ||       ||    ___|\n"
				+ "| |_|   ||   | |   |___ | | |   | |     | |   |___ | | |   ||       ||   |___ \n"
				+ "|_______||___| |_______||_|  |__|  |___|  |_______||_|  |__||_______||_______|");

		System.out.println();

		System.out.println(" \t\t\t_______  __   __  ______   \n" + "\t\t\t|       ||  | |  ||    _ |  \n"
				+ "\t\t\t|  _____||  | |  ||   | ||  \n" + "\t\t\t| |_____ |  |_|  ||   |_||_ \n"
				+ "\t\t\t|_____  ||       ||    __  |\n" + "\t\t\t _____| ||       ||   |  | |\n"
				+ "\t\t\t|_______||_______||___|  |_|");
		System.out.println();
		System.out.println("\t_______  _______  ______    __   __  ___   __   __  _______ \n"
				+ "\t|       ||   _   ||    _ |  |  |_|  ||   | |  | |  ||       |\n"
				+ "\t|    ___||  |_|  ||   | ||  |       ||   | |  | |  ||_     _|\n"
				+ "\t|   |___ |       ||   |_||_ |       ||   | |  |_|  |  |   |  \n"
				+ "\t|    ___||       ||    __  ||       ||   | |       |  |   |  \n"
				+ "\t|   |    |   _   ||   |  | || ||_|| ||   | |       |  |   |  \n"
				+ "\t|___|    |__| |__||___|  |_||_|   |_||___| |_______|  |___|  ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Moteur.nbSpace(5);
		phraseTime(
		"************************************ Bienvenu ! ********************************\n"+
		"*Salut!                                                                        *\n"+
		"*Aprés plusieures années à travailler dans l'industrie automobile,             *\n"+
		"*avec un patron dépressif dont la principale occupation,                       *\n"+
		"*était de me surveiller.Aujourd'hui je fête mes 25 ans et mon grand-père,      *\n"+
		"*chez qui je passais tout mes étés depuis tout petit à profiter                *\n"+
		"*de l'air de la campagne vient de m'annoncer qu'il me donne sa ferme           *\n"+
		"*afin de pouvoir changer de vie. D'oublier les voitures et de m'occuper        *\n"+
		"*des animaux et des cultures.                                                  *\n"+
		"*Le problème c'est que je ne sais pas comment faire et c'est pour cela que     *\n"+
		"*tu es là afin de m'aider à garder la ferme familiale et à la faire évoluer...*\n"+
		"********************************************************************************",10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("1. JOUER");
		System.out.println("2. QUITTER");
		System.out.println();
		System.out.println("Que veux-tu faire ? :");
	}

	public static void phraseTime(String phrase,int temps) {
		for(int cpt = 0 ; cpt < phrase.length() ; cpt++) {
			System.out.print(phrase.charAt(cpt));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static int choixIntro() {
		Scanner sc = new Scanner(System.in);
		int choix = 0;

		while (!sc.hasNextInt()) {
			sc.next();

		}

		while (choix != 1 && choix != 2 && choix != 3) {
			choix = sc.nextInt();
		}

		switch (choix) {

		case 1:
			System.out.println("Menu joueur");
			String nomJoueur = new String();
			System.out.println("Choisis ton nom de joueur");
			sc.nextLine();
			nomJoueur = sc.nextLine();
			try {
				Thread.sleep(1000);
				System.out.println("Salut à toi " + nomJoueur);
				Game jeu = new Game(new Ferme(nomJoueur));
				jeu.loadGame();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			Moteur.clean_screen();
			System.out.println(
					"    ___      __    __     .______       ___________    ____  ______    __  .______      \n"
							+ "    /   \\    |  |  |  |    |   _  \\     |   ____\\   \\  /   / /  __  \\  |  | |   _  \\     \n"
							+ "   /  ^  \\   |  |  |  |    |  |_)  |    |  |__   \\   \\/   / |  |  |  | |  | |  |_)  |    \n"
							+ "  /  /_\\  \\  |  |  |  |    |      /     |   __|   \\      /  |  |  |  | |  | |      /     \n"
							+ " /  _____  \\ |  `--'  |    |  |\\  \\----.|  |____   \\    /   |  `--'  | |  | |  |\\  \\----.\n"
							+ "/__/     \\__\\ \\______/     | _| `._____||_______|   \\__/     \\______/  |__| | _| `._____|\n"
							+ "                                                                                         ");
			System.exit(1);
			break;
		}
		return choix;
	}

}
