package jeudepuissnace4poo;

public class Jeu {
	private int[][] table;
	public final int VIDE = 0;
	public final int ROUGE = 2;
	public final int BLEU = 1;
	private int indiceLigne;
	private int indiceColonne;
	private int nombrePion;

	public Jeu() {
		table = new int[8][8];
		nombrePion = 0;
	}

	public Jeu(int taille) {
		this();
		if (taille > 8) {
			table = new int[taille][taille];
		}
	}

	public void init() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				table[i][j] = VIDE;
			}
		}
	}

	public void afficherJeu() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				if (table[i][j] == BLEU) {
					System.out.print("|B");
				} else if (table[i][j] == ROUGE) {
					System.out.print("|R");
				} else {
					System.out.print("| ");
				}
			}
			System.out.println('|');
		}

		System.out.print("=");
		for (int i = 1; i <= table.length; i++) {
			System.out.print(i + "=");
		}
		System.out.println();
	}

	public boolean joueCoup(int colonne, int couleur) {
		if (!colonnePleine(colonne - 1)) {
			int i = 0;

			while (i < table.length && table[i][colonne - 1] == VIDE) {
				i++;
			}
			table[i - 1][colonne - 1] = couleur;
			nombrePion++;
			indiceLigne = i - 1;
			indiceColonne = colonne - 1;
			return true;
		}
		return false;
	}

	public boolean colonnePleine(int colonne) {
		if (table[0][colonne] == VIDE) {
			return false;
		}
		return true;
	}

	public boolean cherche4() {
		if (testAlignement(0, 1, 0, -1) || testAlignement(-1, 0, 1, 0) || testAlignement(-1, 1, 1, -1)
				|| testAlignement(-1, -1, 1, 1)) {
			return true;
		}
		return false;
	}

	private boolean testAlignement(int dirLigne1, int dirColonne1, int dirLigne2, int dirColonne2) {
		int compt = comptPion(dirLigne1, dirColonne1);

		if (compt == 3) {
			return true;
		}
		compt += comptPion(dirLigne2, dirColonne2);
		if (compt >= 3) {
			return true;
		}
		return false;
	}

	private int comptPion(int dirLigne, int dirColonne) {
		int compt = 0;
		int parcoursLigne = indiceLigne + dirLigne;
		int parcoursColonne = indiceColonne + dirColonne;

		while (compt < 3 && parcoursLigne >= 0 && parcoursLigne < table.length && parcoursColonne >= 0
				&& parcoursColonne < table.length
				&& table[parcoursLigne][parcoursColonne] == table[indiceLigne][indiceColonne]) {
			compt++;
			parcoursLigne += dirLigne;
			parcoursColonne += dirColonne;
		}

		return compt;

	}

	public int getTaille() {
		return table.length;
	}

	public boolean tablePleine() {
		if (nombrePion == Math.pow(table.length, 2)) {
			return true;
		}
		return false;
	}

}
