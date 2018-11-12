package magasin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ferme.Ferme;
import ferme.Inventaire;
import ressources.Ressource;

public class Magasin {
	
	Inventaire i;
	private HashMap<Ressource, Integer> inventaire = new HashMap<>();
	Ressource blé= new Ressource("Blé", 10);
	Ressource graine = new Ressource("Graine de blé", 5);
	Ressource nourriture = new Ressource("Nourriture",1);
	Ressource ciseau = new Ressource("Cisaille", 150);
	Ressource achatVache = new Ressource("Vache", 300);
	Ressource achatMouton = new Ressource("Mouton", 250);
	Ressource achatPoule = new Ressource("Poule", 150);
	Ressource enclosMouton = new Ressource("Enclos à Mouton", 200);
	Ressource enclosVache = new Ressource("Enclos à Vache", 200);
	Ressource enclosPoule = new Ressource("Enclos à Poule", 200);
	
	ArrayList<Ressource> r = new ArrayList<>();
	
	public Magasin(Inventaire i) {
		this.i = i;
		inventaire.put(blé, 15);
		inventaire.put(graine, 60);
		inventaire.put(ciseau, 1);
		inventaire.put(nourriture, 50);
		inventaire.put(achatVache, 1);
		inventaire.put(achatMouton, 1);
		inventaire.put(achatPoule, 1);
		inventaire.put(enclosMouton, 1);
		inventaire.put(enclosVache, 1);
		inventaire.put(enclosPoule, 1);
		
		r.add(graine);
		r.add(ciseau);
		r.add(blé);
		r.add(enclosMouton);
		r.add(enclosVache);	
		r.add(enclosPoule);
		r.add(achatMouton);
		r.add(achatPoule);		
		r.add(achatVache);
		r.add(nourriture);
		
		
	}
	
	public boolean achat(Ressource r, int qté) {
		for( Map.Entry<Ressource, Integer> entry : inventaire.entrySet() ) {
			if(entry.getKey().equals(r) && entry.getValue() >= qté && i.getArgent() >= r.getPrix()*qté) {			
				entry.setValue(inventaire.get(r).intValue()-qté);
				i.setArgent(i.getArgent()-r.getPrix()*qté);
				System.out.println("Vous avez acheter " + qté + " " + r.getNom());
				System.out.println(" Il vous reste " + i.getArgent());
				return true;
			}
			
		}
		System.out.println("Achat impossible !");
		return false;	
	}
	
	public void restock() {
		for( Map.Entry<Ressource, Integer> entry : inventaire.entrySet() ) {
			entry.setValue(entry.getValue()+5);
		}
	}
	
	public HashMap<Ressource, Integer> getInventaire() {
		return inventaire;
	}

	public Ressource getBlé() {
		return blé;
	}

	public Ressource getGraine() {
		return graine;
	}

	public Ressource getCiseau() {
		return ciseau;
	}
	
	public Ressource getAchatVache() {
		return achatVache;
	}

	public Ressource getAchatMouton() {
		return achatMouton;
	}

	public Ressource getAchatPoule() {
		return achatPoule;
	}

	public String contenu() {
		int num = 0;
		String res = "Magasin : \n";
		for (Map.Entry<Ressource, Integer> entry : inventaire.entrySet()) {
			res+=  ++num +". "+ entry.getKey().toString() + " | quantité :" + entry.getValue() + '\n'; 
		}
		
		return res;
	}

	@Override
	public String toString() {
		return 
				" _______________________________________________________\n"+
				"/  .      :      -.      '       _.-       -.     . :   \\\n"+
				"l========================================================l\n"+
				"|- - -            B  O  U  T  I  Q  U  E            - - -|\n"+
				"l========================================================l\n"+
				"||\\_            _|_        .---.      _______         _/||\n"+
				"||  |          /|||\\      | o o |    |       |  ____ |  ||\n"+
				"||  |   _______'  '       | ._. |    |       | |0420||  ||\n"+
				"||  |  |¯¯¯o¯¯¯|   '       '___'     |o      |  ¯¯¯¯ |  ||\n"+
				"||  |  |¯¯¯o¯¯¯| '         ._|_.     |       |       |  ||\n"+
				"|| _|  |¯¯¯o¯¯¯|          / : : \\    |       |       |_ ||\n"+
				"||/¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯/ /| |\\ \\¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\\||\n"+
				"||.====================================================.||\n"+
				"|/               Que voulez-vous acheter?               \\|\n"+
				"l========================================================l\n"+
				"\\        _       .-                     .               /\n"+
				"/        -                      '                '      \\\n"+
				"l========================================================l\n"+
				"************************************************************\n"+
				this.contenu() +
				"************************************************************\n";
	}
	
	public void achat() {
		System.out.println("Que voulez vous acheter ? Vous avez " + i.getArgent());
		Scanner sc = new Scanner(System.in);
		String item = sc.nextLine();
		System.out.println("Combien?");
		String quantité = sc.nextLine();
		
		this.achat(r.get(Integer.parseInt(item)-1), Integer.parseInt(quantité));
		sc.close();
	}
	
	
	
	
}