package animaux;

import ressources.Ressource;

public class Mouton extends Animal {

	private int tourFuturEnfant;
	private final int TOUR_CREATION_ENFANT = 3;
	private final int PAS_DE_FUTUR_ENFANT = -1;

	private Ressource laine;
	private Genre genre;
	private int tourArriveMouton;
	private int seraTondableDans;


	public Mouton() {
		super(TypeAnimal.Mouton,70);
		
		laine = new Ressource("Laine",5*(int)((Math.random()*7) + 1));
		
		tourFuturEnfant = PAS_DE_FUTUR_ENFANT;
		genre = ((int) Math.random() == 0 ? Genre.MALE : Genre.FEMELLE);

		seraTondableDans = 0;
	}

	public int tond() {
		return laine.getPrix();
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Genre getGenre() {
		return genre;
	}

	public int getPrixLaine() {
		return this.laine.getPrix();
	}

	public boolean estTondable() {
		return (seraTondableDans == 0 ? true : false);
	}

	public void setTondable(boolean possedeLaine){
		seraTondableDans = (possedeLaine ? 0 : 3);
	}

	public boolean reproduction(Mouton m1) {
		if (getGenre() != m1.getGenre()) {
			tourFuturEnfant = 3;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "M";
	}

	@Override
	public void jouerTour() {
		if(this.enGestation()) {
			tourFuturEnfant--;
		}
		if(seraTondableDans > 0) {
			seraTondableDans--;
		}
	}

	private boolean enGestation() {
		return tourFuturEnfant > 0;
	}

	public boolean aUnEnfant() {
		return tourFuturEnfant == 0;
	}

	public void setTourFuturEnfant() {
		tourFuturEnfant = TOUR_CREATION_ENFANT;
	}

	public void timeResetChildren() {
		tourFuturEnfant = PAS_DE_FUTUR_ENFANT;
	}

	public int getTourArriveMouton() {
		return tourArriveMouton;
	}

	public int getTourFuturEnfant() {
		return tourFuturEnfant;
	}

	@Override
	public Ressource getRessource() {
		return laine;
	}

}
