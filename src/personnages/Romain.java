package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		if (force <= 0) {
			throw new IllegalArgumentException("Force invalid: " + force);
		}
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int forceOrig = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e !!!");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force<forceOrig;
//	}


	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			
		}
		parler(texte + resistanceEquipement + "!");
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		int oldForce = force;		
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		assert force < oldForce;
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	
	public void sEquiper(Equipement equipement) {
		String soldat = "Le soldat " + nom;
		
		switch (nbEquipement) {
		case 2:
			System.out.println(soldat + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[nbEquipement - 1] == equipement) {
				System.out.println(soldat + " possède déjà un " + equipement + " !");
				break;
			} else {
				equipements[nbEquipement] = equipement;
				nbEquipement += 1;
				System.out.println(soldat + " s'équipe avec un " + equipement + ".");
				break;
			}
		default:
			nbEquipement += 1;
			equipements[0] = equipement;
			System.out.println(soldat + " s'équipe avec un " + equipement + ".");
			break;
		}

	}

//	public static void main(String[] args) {
//		Romain minus = new Romain("Minus", 6);
//		minus.recevoirCoup(4);
//		minus.sEquiper(Equipement.BOUCLIER);
//		minus.sEquiper(Equipement.BOUCLIER);
//		minus.sEquiper(Equipement.CASQUE);
//		minus.sEquiper(Equipement.CASQUE);
//	}

}
