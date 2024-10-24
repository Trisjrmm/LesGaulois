package personnages;

import villagegaulois.Musee;

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
		System.out.println(prendreParole() + texte);
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
	    System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom() + ".");
	    Equipement[] newTrophees = romain.recevoirCoup((force / 3) * effetPotion);
	    
	    if (newTrophees != null) {
	    	int i = 0;
	    	while (i < newTrophees.length && newTrophees[i] != null && nbTrophees < trophees.length) {
	            this.trophees[nbTrophees] = newTrophees[i];
	            nbTrophees++;
	            i++;
	        }
	    }
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée. ");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			parler("Je donne au musee tous mes trophees : ");
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophee(this, trophees[i]);;
				System.out.println("- " + trophees[i]);
			}
		}
	}

//	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Astérix", 8);
//		System.out.println(asterix);
//		asterix.parler("Bonjour!!");
//		asterix.boirePotion(5);
//		Romain cesar = new Romain("César", 6);
//		asterix.frapper(cesar);
//	}
}
