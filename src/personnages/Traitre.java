package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	private Random rand = new Random();

	public Traitre(String nom, String seigneur, String boissonFavorite, int argent) {
		super(nom, seigneur, boissonFavorite, argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traitrise est : " + niveauTraitrise + ".Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconne = argentCommercant * 2 / 10;
			commercant.perdreArgent(argentRanconne);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconne + " sous ou gare à toi");
			parler("Tout de suite grand " + commercant.getNom() + ".");
		}
		else {
			parler("Mince je ne peux plus rançonner personne sinon un samourai risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if(nbConnaissance < 1) {
			parler("Je ne peux faire ami avec personne  car je ne connais personne ! Snif");
		}
		else {
			int index = rand.nextInt(nbConnaissance);
			Humain humain = memoire[index];
			int don = getArgent() * 1 / 20;
			String nomAmi = humain.getNom();
			parler("Il faut absolument remonter ma cote de confiance. je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! " + "Je voudrais vous aider en vous donnant " + don + " sous.");
			humain.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			humain.parler("Merci " + nom + " Vous etes quelqu'un de bien.");
			if(niveauTraitrise > 1) {
				niveauTraitrise--;
			}
		}
	}
	

}
