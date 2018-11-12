package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import animaux.Mouton;
import animaux.Poule;
import animaux.TypeAnimal;
import animaux.Vache;
import ferme.Enclos;
import ferme.Ferme;
import magasin.Magasin;
import ressources.Ressource;

public class TestFerme {

	@Test
	void testFaim() {
		Enclos e = new Enclos(TypeAnimal.Mouton);
		e.addAnimal(new Mouton());
		Ferme f = new Ferme("test");
		f.addEnclos(TypeAnimal.Mouton);
		f.addAnimal(TypeAnimal.Mouton);
		f.gestionFaim();
		// A refaire
		assertEquals(0,e.getAnimaux().get(0).getFaim());
	}
	
	@Test
	void testDonnerAManger() {
		Ferme f = new Ferme("test");
		Magasin m = new Magasin(f.getInventaire());
		Ressource nourriture = new Ressource("Nourriture",1);
		m.achat(nourriture, 50);
	}
	
	@Test
	void testvendreAnimalMouton()  {
		Enclos moutons = new Enclos(TypeAnimal.Mouton);
		Ferme f = new Ferme("test");
		moutons.addAnimal(new Mouton());
		moutons.addAnimal(new Mouton());
		moutons.addAnimal(new Mouton());
		f.addEnclos(moutons);
		
		
		assertEquals(370, f.vendreAnimal(1, moutons));
	}
	
	@Test
	void testvendreAnimalVache()  {
		Enclos vaches = new Enclos(TypeAnimal.Vache);
		Ferme f = new Ferme("salut");
		vaches.addAnimal(new Vache());
		vaches.addAnimal(new Vache());
		vaches.addAnimal(new Vache());
		f.addEnclos(vaches);
		
		
		assertEquals(450, f.vendreAnimal(1, vaches));
	}
	
	@Test
	void testvendreAnimalPoule()  {
		Enclos poules = new Enclos(TypeAnimal.Poule);
		Ferme f = new Ferme("test");
		poules.addAnimal(new Poule());
		poules.addAnimal(new Poule());
		poules.addAnimal(new Poule());
		f.addEnclos(poules);
		
		
		assertEquals(400, f.vendreAnimal(2, poules));
	}
}
