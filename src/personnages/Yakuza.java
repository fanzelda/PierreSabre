package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		String nomVictime = victime.getNom();
		parler(nomVictime + ", si tu tiens � la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		parler("J'ai piqu� les " + gain + " sous � " + nomVictime + " ce qui me fait " + getArgent()
				+ " sous dans ma poche. Hi! Hi!");
	}

	public void perdre() {
		int arg = getArgent();
		perdreArgent(arg);
		reputation--;
		parler("J'ai perdu mon duel et mes " + arg + " sous, snif... J'ai d�shonor� le clan de " + clan);
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan des " + clan + " ? Je l'ai d�pouill� de ses "
				+ gain + " sous.");
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
	}
	
}
