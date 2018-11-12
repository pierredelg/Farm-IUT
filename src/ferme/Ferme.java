package ferme;

import java.util.ArrayList;

import animaux.Animal;
import animaux.Mouton;
import animaux.TypeAnimal;

public class Ferme {
	ArrayList<Enclos> ensembleEnclos;
	ArrayList<Champs> ensembleChamps;
	Inventaire inventaire;
	public int temps;
	private final int MAX_ENCLOS = 6;
	private int faimGeneral;
	private boolean aNourri;
	private int argent;
	private int tour;
	private String pseudo;
	private String design;

	public Ferme(String pseudo) {
		design = "***************************************************************************************************\n" +
				"*         .                                                                                       *\n" + 
				"*     \\\\ | /                                                                                      *\n" +
				"*    '-.;;;.-'                                                                                    *\n" +
				"*   -==;;;;;==-                                                                                   *\n" +
				"*    .-';;;'-.                                                                                    *\n" +
				"*      / | \\\\                                                                                     *\n" +
				"*     '                x                                                                          *\n" +
				"*           .-. _______|                                                                          *\n" +
				"*           |=|/     /  \\                                                                         *\n" +
				"*           | |_____|_\"\"_|                                                                        *\n" +
				"*     |=|=|=|_|_[X]_|____|                                                                        *\n" +
				"*  ^^^^^^^^^^^^^^^^^^^^^^^^^^^                                                                    *\n" +
				"*                                                                                                 *\n" +
				"*   *****************             *******  *******  *******  *******  *******  *******            *\n" +
				"*   *               *             *m    *  *     *  *     *  *     *  *     *  *     *            *\n" +
				"*   *               *             *     *  *     *  *     *  *     *  *     *  *     *            *\n" +
				"*   *               *             *     *  *     *  *     *  *     *  *     *  *     *            *\n" +
				"*   *               *             *     *  *     *  *     *  *     *  *     *  *     *            *\n" +
				"*   *               *             *******  *******  *******  *******  *******  *******            *\n" +
				"*   *               *                                                                             *\n" +
				"*   *               *                                                                             *\n" +
				"*   *               *                                                                             *\n" +
				"*   *               *                                                                             *\n" +
				"*   *               *                                                                             *\n" +
				"*   *               *                                                                             *\n" +
				"*   *****************                                                                             *\n" +
				"*                                                                                                 *\n" +
				"***************************************************************************************************";
		this.aNourri = false;
		this.pseudo = pseudo;
		this.temps = 100;
		this.faimGeneral = 100;
		argent = 100;
		this.tour = 50;
		this.inventaire = new Inventaire();
		this.ensembleEnclos = new ArrayList<Enclos>();
		this.ensembleChamps = new ArrayList<Champs>();
		
		Champs premierChamps = new Champs();
		Enclos premierEnclos = new Enclos(TypeAnimal.Mouton);
		
		ensembleEnclos.add(premierEnclos);
		for (int nombreDeMouton = 0; nombreDeMouton < 3; nombreDeMouton++) {
			addAnimal(TypeAnimal.Mouton);
		}
		ensembleEnclos.add(premierEnclos);
		ensembleChamps.add(premierChamps);
	}

	public void addEnclos(Enclos e) {
		if (ensembleEnclos.size() < MAX_ENCLOS) {
		ensembleEnclos.add(e);
		}
	}
	public boolean addEnclos(TypeAnimal type) {
		if (ensembleEnclos.size() < MAX_ENCLOS) {
			return ensembleEnclos.add(new Enclos(type));
		}
		return false;
	}

	public ArrayList<Enclos> getEnsembleEnclos() {
		return ensembleEnclos;
	}
	
	public int getArgent() {
		return argent;
	}

	
	
	public void setArgent(int argent) {
		this.argent = argent;
	}

	public int getFaimGeneral() {
		return faimGeneral;
	}

	public boolean addAnimal(TypeAnimal type) {
		Enclos avantAjout = null;
		boolean aEteAjoute = false;
		for(Enclos enclos: ensembleEnclos) {
			if(enclos.getType().equals(type)) {
				avantAjout=enclos;
				aEteAjoute = enclos.addAnimal(enclos.getType().getAnimal());
			}
		}
		if(aEteAjoute) {
			addAnimalDesign(type, avantAjout);
		}
		return aEteAjoute;
	}

	private void addAnimalDesign(TypeAnimal type, Enclos avantAjout) {
		// TODO Auto-generated method stub
		int numeroDeLEnclo=0;
		for(int cpt=0; cpt<ensembleEnclos.size(); cpt++) {
			if(ensembleEnclos.get(cpt).getType().equals(avantAjout.getType()) && ensembleEnclos.get(cpt).getSize() == avantAjout.getSize()+1) {
				numeroDeLEnclo=cpt;
			}
		}
		int colonneEnclos = (ensembleEnclos.get(numeroDeLEnclo).getSize()-1)%5;
		int ligneEnclos = (ensembleEnclos.get(numeroDeLEnclo).getSize()-1)/5;
		String debutDuDesign = design.substring(0, (15 + ligneEnclos)*100 + (35 + colonneEnclos) + numeroDeLEnclo*9);
	    String rajoutEtFinDuDesign = type.getLettre() + design.substring((15 + ligneEnclos)*100 +(36 + colonneEnclos) + numeroDeLEnclo*9);
	    design = debutDuDesign + rajoutEtFinDuDesign;
	}

	public ArrayList<Champs> getEnsembleChamps() {
		return ensembleChamps;
	}

	public Enclos getEnclos(TypeAnimal type, int combien) {
		int compteur = 0;
		for (Enclos e : this.ensembleEnclos) {
			if (e.getType().equals(type)) {
				compteur++;
				if (compteur == combien) {
					return e;
				}
			}
		}
		return null;
	}

	public void jouerTour() {
		for (Enclos e : ensembleEnclos) {
			e.jouerTour();
		}
		for (Champs c : ensembleChamps) {
			c.jouerTour();
		}
		if (!aNourri()) {
			gestionFaim();
			this.setaNourri(false);
		}
		tour--;
	}

	public int getTour() {
		return this.tour;
	}
	
	public boolean aNourri() {

		return aNourri;
	}

	public void donnerAManger() {
		int nbrNourriture = 0;
		if (getInventaire().contenu().equals("nourriture")) {
			nbrNourriture++;
		}
		int nbrBête = 0;
		for (Enclos ensembleEnclos : getEnsembleEnclos()) {
			int nbrNourriturePourPourcent = 5;
			nbrBête += ensembleEnclos.getSize();
			int nbrNourritureGlobal = nbrNourriturePourPourcent*nbrNourriture;
			if (nbrNourritureGlobal >= nbrBête) {
				faimGeneral += 10;
			} else {
				System.out.println("Achète de la nourriture pour nourir");
			}
		}
	}
	
	public String getPseudo() {
		return this.pseudo;
	}

	public void setaNourri(boolean aNourri) {
		this.aNourri = aNourri;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void finDuTour() {
		temps--;
	}

	public void gestionFaim() {
		final int FAIM_RETIRE_PAR_TOUR = 2;
		for (Enclos e : this.getEnsembleEnclos()) {
			this.faimGeneral -= e.getSize() * FAIM_RETIRE_PAR_TOUR;
		}
	}
	
	public int getNbAnimaux(TypeAnimal type) {
		int nb = 0;
		for(Enclos e : ensembleEnclos) {
			if(e.getType().equals(type)) {
				nb+=e.getSize();
			}
		}
		return nb;
	}
	
	public int getNbEnclos(TypeAnimal type) {
		int nb = 0;
		for(Enclos e : ensembleEnclos) {
			if(e.getType().equals(type)) {
				nb+=1;
			}
		}
		return nb;
	}  
	
	public int vendreAnimal(int qté, Enclos e) {
		if(qté <= e.getSize()) inventaire.setArgent(inventaire.getArgent()+e.getAnimal().venteAnimal()*qté);
		e.getAnimaux().subList( e.getAnimaux().size()-qté, e.getAnimaux().size()).clear();
		return inventaire.getArgent();
	}

	public int getScore() {
		int nbBete = 0;
		for(Enclos e : this.ensembleEnclos) {
			nbBete += e.getSize();
		}
		return this.getArgent()+(2*nbBete);
	}
	
@Override
public String toString() { 
	return design;
	}

public void setFaim(String faim) {
	this.faimGeneral = Integer.parseInt(faim);
}

public void setArgent(String argent) {
	this.faimGeneral = Integer.parseInt(argent);

}

public void setEnclos(String nbEnclos, TypeAnimal type) {
	int nbEnclo = Integer.parseInt(nbEnclos);
	for(int cpt = 0 ; cpt < nbEnclo ; cpt++) {
		this.addEnclos(type);
	}

}

public void addAnimal(String nbAnimaux, TypeAnimal type) {
	int nbAnimal = Integer.parseInt(nbAnimaux);
	for(int cpt = 0 ; cpt < nbAnimal ; cpt++) {
		this.addAnimal(type);
	}

}
}
