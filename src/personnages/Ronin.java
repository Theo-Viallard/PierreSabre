package personnages;

public class Ronin extends Humain {
	private int honneur;

	
	public void donner(Commercant beneficiaire) {
		int argentDonne = (int) (getArgent() * 0.1);
		
		parler(beneficiaire.getNom() + ", prends ces " + argentDonne + " sous.");
		
		perdreArgent(argentDonne);
		beneficiaire.recevoir(argentDonne);
	}
	
	
	public void provoquer(Yakuza adversaire) {
		int force = honneur * 2;
		
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
			parler("Je t'ai eu petit yakuza !");
			
			int argentGagne = adversaire.perdre();
			gagnerArgent(argentGagne);
			honneur++;			
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			
			int argentPerdu = getArgent();
			perdreArgent(argentPerdu);
			adversaire.gagner(argentPerdu);
			honneur--;
		}
	}
	
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		honneur = 1;
	}

}
