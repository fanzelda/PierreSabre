package personnages;


public class Humain {
	private static final int MEMMAX = 30;
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[MEMMAX];
	
	
	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	protected void gagnerArgent(int gain) {
		argent += + gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	public String acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir une boisson à " + prix + " sous.");
			argent -= prix;
			return bien;
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à "
					+ prix + " sous.");
			return "Argent insuffisant";
		}

	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	private void repondre(Humain homme){
		direBonjour();
		memoriser(homme);
	}
	
	private void memoriser(Humain homme) {
		if (nbConnaissance == MEMMAX) {
			for (int i = 0; i < nbConnaissance - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[nbConnaissance -1] = homme;
		}
		else {
			memoire[nbConnaissance] = homme;
			nbConnaissance++;
		}
	}
	
	public void listerConnaissance() {
		StringBuilder connais = new StringBuilder();
		if(nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}
		else {
			for (int i = 0; i < nbConnaissance - 1; i++) {
				connais.append(memoire[i].getNom() + ", ");
			}
			connais.append(memoire[nbConnaissance-1].getNom()); 
			parler("Je connais beaucoup de monde dont : " + connais);
		}
	}

}
