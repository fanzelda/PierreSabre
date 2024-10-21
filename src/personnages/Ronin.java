package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	
	public Ronin(String nom, String boissonFavorite ,int argent) {
		super(nom, boissonFavorite , argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = getArgent()/10;
		perdreArgent(don);
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		beneficiaire.recevoir(don);
		
	}	
		
	public void provoquer(Yakuza adversaire) {
		int force = 2 * honneur;
		int arg = getArgent();
		parler("Je t'ai retrouv� vermine, tu vas payer pour ce que tu as fait � ce pauvre marchand !");
		if (force >= adversaire.getReputation()) {
			gagnerArgent(arg);
			honneur = honneur + 1;
			parler("Je t'ai eu petit yakusa!");
			adversaire.perdre();
		}
		else {
			honneur = honneur - 1;
			perdreArgent(arg);
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			adversaire.gagner(getArgent());
		}
	}
	
	
}
