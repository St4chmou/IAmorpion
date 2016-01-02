import java.util.ArrayList;

public class Morpion {
	// attributs
	private int[][] matriceJeu;
	private final int WIDTH = 3;
	private final int HEIGHT = 3;
	//private final int PROFONDEUR_DE_JEU = 4;
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
	
	public static void copieMatrice(int [][] matriceSource, int[][] matriceDestination) {
		for(int i = 0; i < matriceSource.length; i++)
			for(int j = 0; j < matriceSource.length; j++)
				matriceDestination[i][j] = matriceSource[i][j];
	}
	
	void creerArbreSituation(Noeud noeud, int profondeur){
		if(!noeud.isFeuille() && profondeur > 0) {
			boolean joueurSuccesseur = !noeud.isMax();
			boolean feuille = false;
			ArrayList<Noeud> successeurs = new ArrayList<Noeud>();
			for(int i=0; i<WIDTH; i++)
				for(int j = 0; j < HEIGHT; j++) {
					Noeud n = new Noeud();
					int[][] matriceCopie = new int[HEIGHT][WIDTH];
					copieMatrice(noeud.getMatrice(), matriceCopie);
					if(jouer(joueurSuccesseur, i, j, matriceCopie)) {
						if(estFinJeu(joueurSuccesseur) || profondeur == 1)
							feuille = true;
						n.setMatrice(matriceCopie);
						n.setFeuille(feuille);
						n.evaluer();
						n.setMax(joueurSuccesseur);
						n.setLigne(i);
						n.setColonne(j);
						
						//recursif
						creerArbreSituation(n, profondeur-1);
						
						successeurs.add(n);
					}
				}
			noeud.setSuccesseurs(successeurs);
		}
	}

	public int resolution(Noeud noeud, int alpha, int beta) {
		int evaluation = 0;
		if(noeud.isFeuille())
			return noeud.getH();
		
		int bestEval;
		if(noeud.isMax()) {
			bestEval = alpha;
			for(Noeud successeur : noeud.getSuccesseurs()) {
				evaluation = resolution(successeur, bestEval, beta);
				successeur.setH(evaluation);
				if(evaluation > bestEval)
					bestEval = evaluation;
				if(bestEval >= beta)
					return bestEval;
			}
		}
		else {
			bestEval = beta;
			for(Noeud successeur : noeud.getSuccesseurs()) {
				evaluation = resolution(successeur, bestEval, beta);
				successeur.setH(evaluation);
				if(evaluation < bestEval)
					bestEval = evaluation;
				if(bestEval <= beta)
					return bestEval;
			}
		}
		
		
		
		return evaluation;
	}
	
	@Override
	public String toString() {
		String s;
		s = "matrice=\n";
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				s += matriceJeu[i][j] + " ";
			s += "\n";
		}
		return s;
	}
	
	public void print() {
		System.out.println(this);
	}
	
	public static void main(String[] args){
		Morpion m = new Morpion();
		int[][] matrice = new int[3][3];
		Noeud noeud = new Noeud(true, matrice);
		noeud.evaluer();
		m.creerArbreSituation(noeud, 2);
		//noeud.print();
	}
}
