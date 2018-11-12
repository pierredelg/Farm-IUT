package animaux;

import ressources.Ressource;

public class Vache extends Animal{

	private int nbrViandeVache;
	private int tempsFabricationLait;
	private int TEMPS_INITIALE_AVANT_LAIT = 5;
	private Ressource lait;
	
	public Vache() {
		super(TypeAnimal.Vache,150);
		this.nbrViandeVache = ((int)(Math.random()*7)+3);
		this.tempsFabricationLait = this.TEMPS_INITIALE_AVANT_LAIT;
		lait = new Ressource("Lait",20);
	}
	
	public boolean laitRecoltable() {
		return this.tempsFabricationLait == 0;
	}

	@Override
	public void jouerTour() {
		if(!laitRecoltable()) {
			this.tempsFabricationLait --;
		}
	}

	@Override
	public Ressource getRessource() {
		return lait;
	}
}
