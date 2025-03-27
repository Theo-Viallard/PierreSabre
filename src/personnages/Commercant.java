package personnages;

public class Commercant extends Humain {
	
	public int seFaireExtorquer() {
		int argent = getArgent();
		perdreArgent(argent);
		parler("Le monde est trop injuste, on m'a tout pris ;(");
		return argent;
	}
	
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous ! Merci le boss tu régales !");
	}
	

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}

}
