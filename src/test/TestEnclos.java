package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import animaux.Mouton;
import animaux.Poule;
import animaux.Vache;
import animaux.TypeAnimal;
import ferme.Enclos;

class TestEnclos {
	Enclos e = new Enclos(TypeAnimal.Mouton);
	Enclos autre = new Enclos(TypeAnimal.Mouton);
	Mouton mouton = new Mouton();

	@Test
	public void testAddAnimalMoutonDansEnclosMouton() {
		assertTrue(e.addAnimal(mouton));
	}


		@Test
		public void testAddAnimalVacheDansEnclosMouton() {
			assertFalse(e.addAnimal(new Vache()));
		}

		@Test
		public void testAddAnimalDepassementTailleMaximum() {
			for(int cpt=e.getSize(); cpt<20; cpt++){
				e.addAnimal(new Mouton());
			}
			assertFalse(e.addAnimal(mouton));
		}

	@Test
	public void testRemoveAnimal() {
		e.addAnimal(mouton);
		assertTrue(e.removeAnimal(mouton));
	}
	
	@Test
	public void removeAminalQuiNexistePasDansLenclos() {
		assertFalse(e.removeAnimal(new Poule()));
	}
	
	@Test
	public void removeAminalQuandLEnclosEstVide() {
		assertFalse(autre.removeAnimal(new Mouton()));
	}
}
