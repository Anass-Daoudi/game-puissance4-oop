package jeudepuissnace4poo;

public class Ordinateur extends Joueur {
	public Ordinateur(int couleur) {
		super("Ordinateur", couleur);
	}

	public void joue(Jeu jeu) {
		for (int col = 1; col <= jeu.getTaille(); col++) {
			if (jeu.joueCoup(col, getCouleur())) {
				System.out.println("Ordinateur a joué dans la colonne: " + col);
				return;
			}
		}
	}
}
