package personnages;

public class Ronin extends Humain {
	private int honneur;

	
	public void donner(Commercant beneficiaire) {
		int argentDonne = (int) (getArgent() * 0.1);
		
		parler(beneficiaire.getNom() + ", prends ces " + argentDonne + " sous.");
		
		perdreArgent(argentDonne);
		beneficiaire.recevoir(argentDonne);
	}
	
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		honneur = 1;
	}

}
