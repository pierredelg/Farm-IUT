package ferme;

import ressources.Ressource;

public class Champs {
	
	private int taille;
	private EtatDuChamps etat;
	private int tempsDePousse;
	
	public Champs() {
		
		this.taille = 50;
		this.etat = EtatDuChamps.vide;
		this.tempsDePousse = 0;
	}
		
	public int getTaille() {
		
		return this.taille;
	}
	
	public EtatDuChamps getEtatDuChamps() {
		
		return this.etat;
	}
	
	public int getTempsDePousse() {
		
		return this.tempsDePousse;
	}
	
	public void semer() {	
			this.etat = EtatDuChamps.semé;
	}
	
	public void agrandirChamps(int argent) {
		
		if(argent >= 100) {
			this.taille += argent/100;
		}
	}
	
	public int recolter() {
		
		if(this.etat == EtatDuChamps.pret) {
			
			this.tempsDePousse = 0;
			
			this.etat = EtatDuChamps.vide;
			
			return taille * 10;
		}
		return 0;
	}
	
	public void jouerTour() {
		
		if(this.etat == EtatDuChamps.semé) {
			
			this.tempsDePousse ++;
		}
		
		if(this.tempsDePousse == 3) {
			
			this.etat = EtatDuChamps.pret;
		}
		
		
	}
}
