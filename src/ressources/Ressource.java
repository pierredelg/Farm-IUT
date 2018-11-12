package ressources;

public class Ressource {

	private String nom;
	private int prix;
	
	public Ressource(String nom, int prix) {
		this.prix = prix;
		this.nom = nom;
	}
	public int getPrix() {return prix;};
	
	public String getNom() {return nom;};
	
	public String toString() {
		return  nom + " | prix : " + prix;
	}
}
