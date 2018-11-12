package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ferme.Ferme;
import magasin.Magasin;

class TestMagasin {
	Magasin m = new Magasin(new Ferme("lolo").getInventaire());
	
	@Test
	void testAchatTrue() {
		assertTrue(m.achat(m.getBlé(), 10));
	}
	
	@Test
	void testAchatFalse() {
		assertFalse(m.achat(m.getBlé(), 20));
	}
	
	@Test
	void testRestock() {
		m.achat(m.getBlé(), 10);
		m.restock();
		assertEquals(10, m.getInventaire().get(m.getBlé()).intValue());
	}
}
