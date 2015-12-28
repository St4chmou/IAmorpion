
public class Morpion {
	// attributs
	private int[][] matriceJeu;
	private final int WIDTH = 3;
	private final int HEIGHT = 3;
	private final int PROFONDEUR_DE_JEU = 4;
	// constructeurs
	public Morpion() {
		matriceJeu = new int[WIDTH][HEIGHT];
	}
	// méthodes
	public boolean jouer(boolean typeJoueur ,int ligne, int colonne) {

		int jeton ;
		if(typeJoueur)
			jeton = 1;
		else
			jeton = 2;
		if (matriceJeu[ligne][colonne]!=0)
			return false;
		matriceJeu[ligne][colonne] = jeton;
		return true;
	}
	
	public boolean jouer(boolean typeJoueur ,int ligne, int colonne, int[][] matrice) {

		int jeton ;
		if(typeJoueur)
			jeton = 1;
		else
			jeton = 2;
		if (matrice[ligne][colonne]!=0)
			return false;
		matrice[ligne][colonne] = jeton;
		return true;
	}
	
	public boolean estFinJeu(Boolean typeJoueur)
	{
		boolean victoire = false;
		boolean full = true;
		String message ="";
		
		for(int i=0; i<HEIGHT ; i++)
			for(int j=0; j<WIDTH; j++)
				if(matriceJeu[i][j]==0)
					full = false;
			
		Noeud n = new Noeud(typeJoueur, matriceJeu);
			
		if (n.troisPionsAlignes(typeJoueur) == true  )
		{
			victoire = true;
			message =  "Le joueur " + typeJoueur + " a gagne !\n";
		}

		if (victoire || full)
		{
			System.out.println(message +"fin du jeu!!");
		}
		return full||victoire;
	}
}
