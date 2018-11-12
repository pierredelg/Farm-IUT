package tours;

import animaux.TypeAnimal;
import ferme.Ferme;
import ferme.Introduction;
import save.Save;

public class Moteur {

	public static void main(String[] args) {
		Introduction.loadIntro();
		int choix = Introduction.choixIntro();

		int choixSave = 0;
		if(Save.existeSave()) {
			if(Save.chargerUneSave()) {
				choixSave = Save.wantLoadSave();
				
			}
			if(choixSave == 0){
				Introduction.loadIntro();
				Introduction.choixIntro();
			}
			else {
				String[] save = Save.chargerSave(choixSave);
				Ferme ferme = new Ferme(save[0]);
				ferme.setFaim(save[1]);
				ferme.setArgent(save[2]);
				ferme.setEnclos(save[6],TypeAnimal.Mouton);
				ferme.setEnclos(save[7],TypeAnimal.Vache);
				ferme.setEnclos(save[8],TypeAnimal.Poule);
				ferme.addAnimal(save[3],TypeAnimal.Mouton);
				ferme.addAnimal(save[4],TypeAnimal.Vache);
				ferme.addAnimal(save[5],TypeAnimal.Poule);
				Game game = new Game(ferme);
				
			}
		}
		if(choixSave == 0){
			Introduction.loadIntro();
			Introduction.choixIntro();
		}
		else {
			String[] save = Save.chargerSave(choixSave);
			Ferme ferme = new Ferme(save[0]);
			ferme.setFaim(save[1]);
			ferme.setArgent(save[2]);
			System.out.println(save[6] + " " + save[7] + " " + save[8]);
			ferme.setEnclos(save[6],TypeAnimal.Mouton);
			ferme.setEnclos(save[7],TypeAnimal.Vache);
			ferme.setEnclos(save[8],TypeAnimal.Poule);
			ferme.addAnimal(save[3],TypeAnimal.Mouton);
			ferme.addAnimal(save[4],TypeAnimal.Vache);
			ferme.addAnimal(save[5],TypeAnimal.Poule);
			Game game = new Game(ferme);
			game.loadGame();
			Moteur.clean_screen();
		}
	}

	public static void clean_screen() {
		Moteur.nbSpace(10);
	}

	public static void middle_clean_screen() {
		Moteur.nbSpace(10);
	}
	
	public static void nbSpace(int nb) {
		for(int cpt = 0 ; cpt < 100 ; cpt++)
			System.out.print("\n");
	}
}
