package save;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import animaux.TypeAnimal;
import ferme.Ferme;
import tours.Moteur;

public class Save {

	public final static String CHEMIN_SAVE = "Sauvegarde.csv";
	private static final String DELIMITER = ";";
	private static final String NEW_LINE = "\n";

	public static boolean existeSave() {
		String[][] save = FileReader();
		for (int cpt = 1; cpt < save.length; cpt++) {
			if (!save[cpt][0].equals("NOUVEL EMPLACEMENT")) {
				return true;
			}
		}
		return false;
	}

	public static boolean save(Ferme ferme, int emplacement) {
		String[][] save = FileReader();
		StringBuilder fileContent = new StringBuilder();
		PrintWriter pw = null;
		if (emplacement > save.length || emplacement < 1)
			return false;
		String pseudo = ferme.getPseudo();
		String nbMouton = "" + ferme.getNbAnimaux(TypeAnimal.Mouton);
		String nbPoule = "" + ferme.getNbAnimaux(TypeAnimal.Poule);
		String nbVache = "" + ferme.getNbAnimaux(TypeAnimal.Vache);
		String nbEnclosMouton = "" + ferme.getNbEnclos(TypeAnimal.Mouton);
		String nbEnclosPoule = "" + ferme.getNbEnclos(TypeAnimal.Poule);
		String nbEnclosVache = "" + ferme.getNbEnclos(TypeAnimal.Vache);
		String argent = "" + ferme.getArgent();
		String faim = "" + ferme.getFaimGeneral();
		String score = "" + ferme.getScore();
		String[] savePlayer = new String[] { pseudo, nbMouton, nbPoule, nbVache, nbEnclosMouton, nbEnclosPoule,
				nbEnclosVache, argent, faim, score };

		try {
			pw = new PrintWriter(new File("donnee/"+CHEMIN_SAVE));
			for (int cpty = 0; cpty < save[0].length; cpty++) {
				for (int cptx = 0; cptx < save.length; cptx++) {
					if (cptx == emplacement) {
						fileContent.append(savePlayer[cpty]);
					} else {
						fileContent.append(save[cptx][cpty]);
					}
					fileContent.append(DELIMITER);
				}
				fileContent.append(NEW_LINE);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.write(fileContent.toString());
		pw.close();

		return true;

	}

	/**
	 * Permet de lire un fichier externe
	 * 
	 * @return l'ensemble de ce qui a ete lu
	 */
	public static String[][] FileReader() {
		Scanner scanner = null;
		String ligne = "";
		String separateur = ";";
		ArrayList<String[]> tab = new ArrayList<String[]>();

		try {
			scanner = new Scanner(Save.class.getClassLoader().getResourceAsStream((CHEMIN_SAVE)), "utf-8");
			while (scanner.hasNext()) {
				ligne = scanner.nextLine();
				tab.add(ligne.split(separateur));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		String[][] tableauSave = new String[4][tab.size()];

		for (int compteur = 0; compteur < tab.size(); compteur++) {
			String[] tableau = tab.get(compteur);
			for (int cpt = 0; cpt < tableau.length; cpt++) {
				tableauSave[cpt][compteur] = tableau[cpt];
			}
		}

		return tableauSave;
	}

	public static int wantLoadSave() {
		String[][] save = FileReader();
		int choix = 0;
		do {
			
		Moteur.clean_screen();
			
		System.out.println("\n\n\t\t\t-CHARGER UNE SAUVEGARDE-\n\n");
		for(int cpt = 1 ; cpt < 4 ; cpt++) {
		System.out.println(
				"**¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯**\n" +
				"*                                                                 *\n" +
				"                             ");
		System.out.println("\t\t\t"+cpt+"."+save[cpt][0]);
			System.out.print(
				"|                                                                 |\n" +
				"|-----------------------------------------------------------------|\n" +
				"|                                                                 |\n");
			System.out.println("\t          Mouton: "+(save[cpt][3].equals("null") ? "0" : save[cpt][3])+"    Vache:"+(save[cpt][4].equals("null") ? "0" : save[cpt][4])+"    Poule:"+(save[cpt][5].equals("null") ? "0" : save[cpt][5])+"\n");
			System.out.println("\t\t         Argent:"+(save[cpt][2].equals("null") ? "0" : save[cpt][2])+"    Score:"+(save[cpt][9].equals("null") ? "0" : save[cpt][9]));
			System.out.print(
				"*                                                                 *\n" +
				"**_______________________________________________________________**\n\n\n");
			
		}
		
		System.out.println();
		System.out.print("Quelle partie voulez-vous jouer ? :");
		
		Scanner sc = new Scanner(System.in);
    	try {
    		choix = Integer.parseInt(sc.nextLine());
    		
    	}catch(Exception e) {
    		choix = -1;
    	}
		
		}while(choix < 0 || choix > 3 || save[choix][0].equals("NOUVEL EMPLACEMENT"));
		return choix;
	}

	public static int choixSave() {
		int choix = 0;
		
		return choix;
	}

	public static boolean chargerUneSave() {
		int choix = 0;
		do {
			Moteur.clean_screen();
		System.out.print(
	            "**¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯**\n" +
	            "*                                                                 *\n" +
	            "|                 Des sauvegardes ont été trouvées                |\n" +
	            "|              Voulez-vous continuer une des parties ?            |\n" +
	            "|                                                                 |\n" +
	            "|                                                                 |\n" +
	            "|                        ");
		System.out.print("1.Oui");
	        System.out.print("           ");
	        System.out.print("2.Non");
	        System.out.print("                    |\n" +
	            "*                                                                 *\n" +
	            "**_______________________________________________________________**");
	        Moteur.middle_clean_screen();
	        
	        Scanner sc = new Scanner(System.in);
	        	try {
	        		choix = Integer.parseInt(sc.nextLine());
	        		
	        	}catch(Exception e) {
	        		choix = 0;
	        	}
	        	
	        }while(choix == 0);
		return choix == 1;
	}

	public static String[] chargerSave(int choixSave) {
		String[][] save = FileReader();
		String[] donnee = new String[] {
				save[choixSave][0],
				save[choixSave][1],
				save[choixSave][2],
				save[choixSave][3],
				save[choixSave][4],
				save[choixSave][5],
				save[choixSave][6],
				save[choixSave][7],
				save[choixSave][8]};
		return donnee;
	}
}
