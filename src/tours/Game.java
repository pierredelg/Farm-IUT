package tours;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import animaux.Animal;
import animaux.Mouton;
import animaux.TypeAnimal;
import animaux.Vache;
import ferme.Champs;
import ferme.Enclos;
import ferme.Ferme;
import magasin.Magasin;
import ressources.Ressource;

public class Game {

	private Ferme f;

	public Game(Ferme ferme) {
		super();
		this.f = ferme;
	}

	public void loadGame() {
		// TODO Auto-generated method stub
		Magasin m = new Magasin(f.getInventaire());
		System.out.println("F :" + f.getFaimGeneral());
		System.out.println(f);
		System.out.println(" __________________________");
		System.out.println();
		System.out.println("| 1. Nourir les animaux    |");
		System.out.println("| 2. Recolter le lait      |");
		System.out.println("| 3. Recolter la laine     |");
		System.out.println("| 4. Recolter les champs   |");
		System.out.println("| 5. Semer les champs      |");
		System.out.println("| 6. Aller au magasin      |");
		System.out.println("| 7. Passer tour           |");
		System.out.println("| 8. Quitter le jeu        |");
		System.out.println(" __________________________");
		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {

			while (!sc.hasNextInt()) {
				sc.next();
			}

			while (choix < 1 || choix > 8) {
				choix = sc.nextInt();

			}

			switch (choix) {
			case 1:
				f.donnerAManger();
				choix = 0;
				break;
			case 2:
				List<Enclos> ensemble = f.getEnsembleEnclos();
				for (Enclos e : ensemble) {
					if (e.getType().equals(TypeAnimal.Vache)) {
						Enclos vache = f.getEnclos(TypeAnimal.Vache, 1); // JE RECUP LE 1ER ENCLOS MOUTON
						List<Animal> listV = vache.getAnimaux();
						System.out.println(f.getArgent());
						int resV = 0;
						for (Animal a : listV) {
							Vache v = (Vache) a;
							if (v.laitRecoltable()) {
								resV += v.getRessource().getPrix();
							}
						}
						f.setArgent(f.getArgent() + resV);
						System.out.println(f.getArgent());
					}
				}
				System.out.println("Pas d'enclos vache");
				choix = 0;
				break;
			case 3:
				Enclos mouton = f.getEnclos(TypeAnimal.Mouton, 1); // JE RECUP LE 1ER ENCLOS MOUTON
				List<Animal> list = mouton.getAnimaux();
				System.out.println(f.getArgent());
				int res = 0;
				for (Animal a : list) {
					Mouton mout = (Mouton) a;
					if (mout.estTondable()) {
						res += mout.tond();
						mout.setTondable(false);
					}
				}
				f.setArgent(f.getArgent() + res);
				System.out.println(f.getArgent());
				choix = 0;
				break;
			case 4:// Recolter Champs
				ArrayList<Champs> listC = f.getEnsembleChamps();
				int total = 0;
				for (Champs c : listC) {
					total += c.recolter();
				}
				if (total == 0) {
					System.out.println("Le champ n'est pas semé");
				} else {
					System.out.println("Vous avez récolté " + total);
				}
				choix = 0;
				break;
			case 5:
				ArrayList<Champs> listChamps = f.getEnsembleChamps();
				for (Champs c : listChamps) {
					if (f.getInventaire().getRessource(m.getBlé()) != new Ressource("Blé",10)) {
						f.getInventaire().useItem(new Ressource("blé", 10), 1);
						c.semer();
						System.out.println("Le champs a été semé");
					}
				}
				choix = 0;
				break;
			case 6:
				System.out.println(m);
				m.achat();
				choix = 0;
				break;
			case 7:
				f.jouerTour();
				if(f.getTour() == 0) {
					this.endGame();
				}
				break;
			case 8:
				System.out.println("Merci d'avoir joué");
				try {
					Thread.sleep(10000);
					System.exit(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
		} while (choix == 0);
	}

	private void endGame() {
		// TODO Auto-generated method stub
		System.out.println(" ______ _____ _   __  \n" + 
				"           |  ____|_   _| \\ | |\n" + 
				"           | |__    | | |  \\| |\n" + 
				"           |  __|   | | |  .`  |\n" + 
				"           | |     _| |_| |\\  |\n" + 
				"           |_|    |_____|_| \\_|");
	}

	public void loadScore() {
		// TODO Auto-generated method stub
		System.out.println("Voici votre score" + f.getScore());
	}

}
