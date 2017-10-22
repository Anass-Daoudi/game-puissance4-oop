package jeudepuissnace4poo;

import java.util.Scanner;

public class Main {
	private final static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nom du joueur: ");
		String nom = reader.nextLine();

		System.out.print("Taille de la table: ");
		int taille = reader.nextInt();

		Jeu jeu = new Jeu(taille);
		Partie partie = new Partie(jeu, new JoueurHumain(nom, jeu.BLEU), new Ordinateur(jeu.ROUGE));
		partie.joue();
		partie.resultat();
	}
}
