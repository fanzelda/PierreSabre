package histoire;

import personnages.Humain;
import personnages.Commercant;


public class HistoireTP4 {
	public static void main(String[] args) {
//		Humain prof = new Humain("Prof", "kombucha", 54);
//		
//		prof.direBonjour();
//		String boisson = prof.acheter("kombucha", 12);
//		prof.boire(boisson);
//		String jeu = prof.acheter("jeu", 2);
//		String kimono = prof.acheter("kimono", 50);
		
		Commercant marco = new Commercant("Marco", 20);
		
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire("th�");
		
	}
}
