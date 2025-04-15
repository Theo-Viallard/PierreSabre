package personnages;


public class Humain {
	private static final int TAILLE_MEMOIRE = 30;
	
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire;
	
	public String getNom() {
		return nom;
	}
	
	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
	}
	
	public void boire() {
		parler("Mmmh, un bon verre de " + boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		}
	}
	
	public void gagnerArgent(int montant) {
		argent += montant;
	}
	
	public void perdreArgent(int montant) {
		argent -= montant;
	}
	
	
	private void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);
	}
	
	
	protected void memoriser(Humain autreHumain) {
		if (nbConnaissance == TAILLE_MEMOIRE) {
			for (int i = 1; i < nbConnaissance; i++) {
				memoire[i-1] = memoire[i];
			}
			memoire[nbConnaissance-1] = autreHumain;
		} else {
			memoire[nbConnaissance] = autreHumain;
			nbConnaissance++;
		}
	}
	
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	
	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont : " + memoire[0].getNom();
		for (int i = 1; i < nbConnaissance; i++) {
			texte += ", " + memoire[i].getNom();
		}
		
		parler(texte);
	}
	

	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
		this.nbConnaissance = 0;
		this.memoire = new Humain[TAILLE_MEMOIRE];
	}
}
