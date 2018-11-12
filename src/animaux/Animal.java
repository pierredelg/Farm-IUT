package animaux;

import ressources.Ressource;

public abstract class Animal {

	private int faim = 0;
	private final int FAIM_RETIRE_PAR_TOUR = 2;
	private boolean malade;
	private final int PRIX_VENTE;
	private final TypeAnimal type;
	
	public Animal(TypeAnimal type, int prixVente) {
		this.type = type;
		this.malade = false;
		this.PRIX_VENTE = prixVente;
	}

	public int getFAIM_RETIRE_PAR_TOUR() {
		return FAIM_RETIRE_PAR_TOUR;
	}
	
	public int getFaim() {
		return faim;
	}

	public boolean isMalade() {
		return malade;
	}
	
	public int venteAnimal() {
		return this.PRIX_VENTE;
	}
	
	
	public TypeAnimal getType() {
		return this.type;
	}

	public abstract void jouerTour();
	
	public abstract Ressource getRessource();
}
