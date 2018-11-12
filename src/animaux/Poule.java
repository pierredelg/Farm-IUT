package animaux;

import java.util.ArrayList;

import ressources.Ressource;

public class Poule extends Animal{

	private Ressource oeuf;

	public Poule() {
		super(TypeAnimal.Poule,50);
		this.oeuf = null;
	}
	
	public boolean chanceNouvelOeuf() {
		return Math.random() < 0.4;
	}
	

	@Override
	public void jouerTour() {
		if(this.chanceNouvelOeuf()) {
			oeuf = new Ressource("Oeuf",2);
		};
	}

	@Override
	public Ressource getRessource() {
		if(this.oeuf != null)
			return this.oeuf;
		return null;
	}
}
