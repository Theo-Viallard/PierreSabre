package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise;

	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est " + niveauTraitrise + ". Chut !");
	}
	
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconne = argentCommercant * 2 / 10;
			
			commercant.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			niveauTraitrise++;
			
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconne + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		} else {
			parler("Je ne peux plus rançonner personne, sinon un samouraï risque de me démasquer !");
		}
	}
	
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami-ami avec personne car je ne connais personne ! Snif.");
		} else {
			Random r = new Random();
			
			Humain ami = memoire[r.nextInt(nbConnaissance)];
			int don = getArgent() * 1 / 20;
			String nomAmi = ami.getNom();
			
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami-ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			
			ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
			
			if (niveauTraitrise > 0) {
				niveauTraitrise--;
			}
		}
	}
	
	
	public Traitre(String seigneur, String nom, String boisson, int force) {
		super(seigneur, nom, boisson, force);
		niveauTraitrise = 0;
	}

}
