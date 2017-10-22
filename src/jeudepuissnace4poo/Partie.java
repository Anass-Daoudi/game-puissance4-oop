package jeudepuissnace4poo;

public class Partie {
	private JoueurHumain joueurHumain;
	private Ordinateur ordinateur;
	private Jeu jeu;
	private int couleur;

	public Partie(Jeu jeu, JoueurHumain joueurHumain, Ordinateur ordinateur) {
		this.jeu = jeu;
		this.joueurHumain = joueurHumain;
		this.ordinateur = ordinateur;
		couleur = ordinateur.getCouleur();
	}

	public void joue() {
		do {
			if (couleur == jeu.ROUGE) {
				ordinateur.joue(jeu);
			} else {
				joueurHumain.joue(jeu);
			}
			jeu.afficherJeu();
			couleur = changerCouleur(couleur);
		} while (!jeu.cherche4() && !jeu.tablePleine());
	}

	public int changerCouleur(int couleur) {
		if (couleur == jeu.ROUGE) {
			return jeu.BLEU;
		}
		return jeu.ROUGE;
	}

	public void resultat() {
		if (jeu.cherche4()) {
			if (couleur == jeu.ROUGE) {
				System.out.println("Joueur " + joueurHumain.getNom() + " a gagné!");
			} else {
				System.out.println("Ordinateur a gagné!");
			}
		} else {
			System.out.println("Partie nulle!");
		}
	}

}
