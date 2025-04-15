package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	private static final int TAILLE_MEMOIRE = 5;
	private enum TypeHumain {
		COMMERCANT("commerçant"), GRAND_MERE("grand-mère"), HABITANT("habitant"), RONIN("ronin"), SAMOURAI("samouraï"), YAKUZA("yakuza");
		
		public final String nom;
		
		private TypeHumain(String nom) {
			this.nom = nom;
		}
	}
	
	
	@Override
	protected void memoriser(Humain autreHumain) {
		if (nbConnaissance == TAILLE_MEMOIRE) {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		} else {
			memoire[nbConnaissance] = autreHumain;
			nbConnaissance++;
		}
	}
	
	
	private String humainHasard() {
		Random random = new Random();
		
		int no = random.nextInt(5);
		TypeHumain[] types = TypeHumain.values();
		String humain = types[no].nom;
		
		return humain;
	}
	
	
	public void ragoter() {
		for (Humain humain : memoire) {
			if (humain == null) {
				return;
			}
			if (humain instanceof Traitre) {
				parler("Je sais que " + humain.getNom() + " est un traître. Petit chenapan !");
			} else {
				parler("Je crois que " + humain.getNom() + " est un " + humainHasard());
			}
		}
	}
	

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
}
