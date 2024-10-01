package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert force>0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "�");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
		
//	@Override
//	public String toString() {
//		return "Romain [nom=" + nom + ", force=" + force + "]";
//	}

	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int forceOrig = force;
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		assert force<forceOrig;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(4);
	}
}
