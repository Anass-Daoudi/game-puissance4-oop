package jeudepuissnace4poo;

public class Joueur {
	private String nom;
	private int couleur;

	public Joueur(String nom, int couleur) {
		this.couleur = couleur;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public int getCouleur() {
		return couleur;
	}
}
