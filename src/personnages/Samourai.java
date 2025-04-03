package personnages;

public class Samourai extends Humain {
	private String seigneur;

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur " + seigneur + ".");
	}
	
	
	public void boire(String boisson) {
		parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boisson + ".");
	}
	
	
	public Samourai(String seigneur, String nom, String boisson, int force) {
		super(nom, boisson, force);
		this.seigneur = seigneur;
	}
}
