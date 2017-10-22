package jeudepuissnace4poo;

import java.util.Scanner;

public class JoueurHumain extends Joueur {
	private final static Scanner reader = new Scanner(System.in);

	public JoueurHumain(String nom,int couleur) {
		super(nom, couleur);
	}

	public void joue(Jeu jeu) {
		demanderColonne(jeu);
	}

	public void demanderColonne(Jeu jeu) {
		int colonne;

		do {
			System.out.print("Entrer le numero de colonne: ");
			colonne = reader.nextInt();
		} while (colonne < 1 || colonne > jeu.getTaille() || !jeu.joueCoup(colonne, getCouleur()));
	}
}
