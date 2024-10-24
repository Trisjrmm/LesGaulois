package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Trophee;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophee;
	
	public Musee() {
		this.trophees = new Trophee[200];
	}
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee newTrophee = new Trophee(gaulois, equipement); 
		trophees[nbTrophee] = newTrophee;
		nbTrophee += 1;
	}
	
}
