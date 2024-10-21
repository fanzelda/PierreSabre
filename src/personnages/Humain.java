package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public Humain(String nom, String boissonFavorite, int argent) {
		super();
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	protected void gagnerArgent(int gain) {
		argent = argent + gain;
	}

	protected void perdreArgent(int perte) {
		argent = argent - perte;
	}

	protected void parler(String texte) {
		System.out.println("(prof) - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}

	public void boire(String boisson) {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}

	public String acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir une boisson à " + prix + " sous.");
			argent = argent - prix;
			return bien;
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à "
					+ prix + " sous.");
			return "Argent insuffisant";
		}

	}

}
