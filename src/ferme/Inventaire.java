package ferme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ressources.Ressource;

public class Inventaire {

	private int argent;
	private HashMap<Ressource, Integer> inventaire = new HashMap<>();

	public Inventaire() {
		argent = 300;
		inventaire.put(new Ressource("blé", 10), 2);
	}

	public int vendre(Ressource r, int qté) {
		if (inventaire.containsKey(r) && qté <= inventaire.get(r).intValue()) {
			argent += r.getPrix() * qté;
			inventaire.replace(r, inventaire.get(r).intValue(), inventaire.get(r).intValue() - qté);
		}
		clean();
		return argent;
	}

	public int getArgent() {
		return argent;
	}

	public boolean useItem(Ressource r, int qté) {
		System.out.println("RESSOURCE :" +r);
		System.out.println(this.inventaire.containsKey(r));
		/*if (inventaire.containsKey(r) && qté <= inventaire) {
			inventaire.replace(r, inventaire.get(r).intValue(), inventaire.get(r).intValue() - qté);
			return true;
		}*/
		return false;
	}

	public HashMap<Ressource, Integer> getInventaire() {
		return inventaire;
	}

	public Ressource getRessource(Ressource r) {
		for (Map.Entry<Ressource, Integer> entry : inventaire.entrySet()) {
			if (entry.getKey().equals(r))
				return r;
		}
		return null;
	}

	public String contenu() {
		String res = "Inventaire : \n";
		for (Map.Entry<Ressource, Integer> entry : inventaire.entrySet()) {
			res += entry.getKey().toString() + " | quantité :" + entry.getValue() + '\n';
		}

		return res;
	}

	public void clean() {
		List<Ressource> temp = new ArrayList<Ressource>();
		for (Map.Entry<Ressource, Integer> entry : inventaire.entrySet()) {
			if (entry.getValue().intValue() == 0)
				temp.add(entry.getKey());
		}
		for (Ressource r : temp) {
			inventaire.remove(r);
		}

	}

	public void addDansInventaire(Ressource r) {
		inventaire.put(r, 1);
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

}
