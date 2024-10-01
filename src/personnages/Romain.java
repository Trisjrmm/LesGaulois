package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		assert force>0;
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
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
		
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}

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
	
//	private void sEquiper(Equipement equipement) {
//		switch (nbEquipements) {
//			case 2:
//				System.out.println("Le soldat " + nom + " est d�j� bien prot�g� !");
//				break;
//			case 1:
//				if (equipements[nbEquipements-1] == equipement) {
//					System.out.println("Le soldat " + nom + " poss�de d�j� un " + equipement +" !");
//				} else {
//					equipements[nbEquipements] = equipement;
//				}
//		}
//
//	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(4);
	}
}
