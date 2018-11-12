package aleas;

public class Evenement {

	private String nom; 
	private int perte;
	
	public Evenement(String nom, int perte) {
		this.nom = nom;
		this.perte = perte;
	}

	public String getNom() {
		return nom;
	}

	public int getPerte() {
		return perte;
	}
	
	public String toString() {
		return "Vous avez été vicitime de " + nom + " vous perdez " + perte + " animaux !";
	}
	
}
