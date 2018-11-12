package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import ferme.Inventaire;
import ressources.Ressource;

public class TestInventaire {

	Inventaire i = new Inventaire();
	Ressource blé= new Ressource("blé", 15);

	@Test
	public void testArgent() {
		assertEquals(300, i.getArgent());
	}
	@Test
	public void testVendre() {
		i.getInventaire().put(blé, 15);
		i.vendre(i.getRessource(blé), 1 );
		assertEquals(315, i.getArgent());
	}

	@Test 
	public void testUseItemTrue() {
		i.getInventaire().put(blé, 15);
		assertTrue(i.useItem(i.getRessource(blé), 1));
	}
	@Test
	public void testUseItemFalse() {
		i.getInventaire().put(blé, 15);
		assertFalse(i.useItem(i.getRessource(blé), 35));
	}
}
