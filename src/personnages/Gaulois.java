package personnages;

public class Gaulois {
	private String nom;
	private int force; 
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.trophees = new Equipement[100];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "�");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}


//	public void frapper(Romain romain) {
//		parler(nom + " envoie un grand coup dans la machoire  de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement newTrophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = newTrophees[i];
		}
	}
	
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois d�cupl�e. ");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		System.out.println(asterix);
		asterix.parler("Bonjour!!");
		asterix.boirePotion(5);
		Romain cesar = new Romain("C�sar", 6);
		asterix.frapper(cesar);
	}
}
