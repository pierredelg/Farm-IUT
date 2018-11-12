package animaux;

public enum TypeAnimal {

	Poule('p'),
	Vache('v'),
	Mouton('m');
	
	private char lettre;
	
	TypeAnimal(char lettre) {
		this.lettre = lettre;
	}

	public char getLettre() {
		return lettre;
	}
	
	public Animal getAnimal() {
		Animal animal = null;
		switch(this.lettre) {
			case 'p' : animal = new Poule();
			break;
			case 'v' : animal = new Vache();
			break;
			case 'm' : animal = new Mouton();
			break;
		}
		return animal;
	}
	
}
