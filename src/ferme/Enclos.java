package ferme;

import java.util.ArrayList;
import java.util.List;

import animaux.Animal;
import animaux.Mouton;
import animaux.TypeAnimal;


public class Enclos {
	private List<Animal> animaux;
	private TypeAnimal type;
	private int tailleMaximal;
	
	public Enclos(TypeAnimal type) {
		animaux=new ArrayList<Animal>();
		this.type = type;
		tailleMaximal = 20;
	}

	public List<Animal> getAnimaux() {
		return animaux;
	}
	public boolean agrandir() {
		if(this.animaux.size() == tailleMaximal) {
			return false;
		}
		return true;
	}

	public boolean addAnimal(Animal nouveau) {
		if(type.equals(nouveau.getType()) && 
				getSize() < tailleMaximal) {
			return animaux.add(nouveau);
		}
		return false;
		
	}
	
	public boolean removeAnimal(Animal retirer) {
		return (animaux.contains(retirer) ? animaux.remove(retirer) : false);
	}
	
	public TypeAnimal getType() {
		return type;
	}

	public int getTailleMaximal() {
		return tailleMaximal;
	}

	public int getSize() {
		return animaux.size();
	}
	
	public void jouerTour() {
		for(Animal a : animaux) {
			a.jouerTour();
			if(type.equals(TypeAnimal.Mouton)) {
				Mouton mouton = (Mouton) a;
				if(mouton.aUnEnfant()) {
					mouton.timeResetChildren();
					addAnimal(new Mouton());
				}
			}
		}
	}
	
	public Animal getAnimal() {
		return animaux.get(0);
	}
	
}
