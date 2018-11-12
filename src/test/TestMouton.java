package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import animaux.Genre;
import animaux.Mouton;

public class TestMouton {

	Mouton m = new Mouton();
	Mouton m2 = new Mouton();

	@Test
	void testContientLaine() {
		assertFalse(m.estTondable());
		m2.setTondable(true);
		assertTrue(m2.estTondable()); //T'as discord ? Tic#2756
	}

	@Test
	void testEstTondable() {
		assertFalse(m.estTondable());
		m2.setTondable(true);
		assertTrue(m2.estTondable());
	}

	@Test
	void testReproduction() {
		m.setGenre(Genre.FEMELLE);
		m2.setGenre(Genre.MALE);
		if (m.getGenre() != m2.getGenre()) {
			m.reproduction(m2);
			assertEquals(3, m.getTourFuturEnfant());
			System.out.println(m.getTourFuturEnfant());
			m.timeResetChildren();
		}
		System.out.println(m.getTourFuturEnfant());
		assertEquals(-1, m.getTourFuturEnfant());
	}

}
