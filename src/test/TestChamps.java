package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ferme.Champs;
import ferme.EtatDuChamps;

class TestChamps {
	
	Champs c1 = new Champs();
	
	@Test
	void testSemer() {
		c1.semer(50);
		assertEquals(EtatDuChamps.semé,c1.getEtatDuChamps());
	}
	
	@Test
	void testRecolter() {
		
		assertEquals(0,c1.recolter());
		
		c1.semer(50);
		
		c1.jouerTour();
		assertEquals(1,c1.getTempsDePousse());
		assertEquals(0,c1.recolter());
		
		c1.jouerTour();
		assertEquals(2,c1.getTempsDePousse());
		assertEquals(0,c1.recolter());
		
		c1.jouerTour();
		assertEquals(3,c1.getTempsDePousse());
		assertEquals(c1.getTaille()*10,c1.recolter());
		
		

	}
	
	@Test
	void testAgrandir() {
		
		c1.agrandirChamps(100);
		assertEquals(51,c1.getTaille());
	}

}
