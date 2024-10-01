package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximus) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximus];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	private Gaulois trouverHabitant(int i) {
		return villageois[i];
	}
	
	private void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irrèductibles", 30);
		Chef abracourcix = new Chef("Abracourcix", 6, village);
		village.setChef(abracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
