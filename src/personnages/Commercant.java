package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom, "th�" , argent);
	}
	
	public int seFaireExtorquer() {
		parler("J'ai tout perdu ! Le monde est trop injuste...");
		int perte = getArgent();
		perdreArgent(perte);
		return perte;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie g�n�reux donateur ");
		gagnerArgent(argent);
	}
}
