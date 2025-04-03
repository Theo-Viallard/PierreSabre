package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation;

	
	public int getReputation() {
		return reputation;
	}
	
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à ta vie, donne-moi ta bourse !");
		int argentGagne = victime.seFaireExtorquer();
		gagnerArgent(argentGagne);
		parler("J'ai piqué les " + argentGagne + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi hi !");
		reputation++;
	}

	
	public int perdre() {
		int argent = getArgent();
		parler("Il m'a bien cogné, j'ai perdu mes " + argent + " sous. J'ai déshonoré le clan de " + clan + ". Désolé la famille ;(");
		reputation--;
		perdreArgent(argent);
		return argent;
	}
	
	
	public void gagner(int gain) {
		parler("Il a vraiment cru qu'il pouvait battre " + getNom() + " du clan " + clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
		reputation++;
		gagnerArgent(gain);
	}
	
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
	}
	
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		reputation = 0;
	}

}
