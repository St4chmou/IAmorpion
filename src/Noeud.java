import java.util.ArrayList;

public class Noeud {
	// attributs
	private int[][] matrice;
	private ArrayList<Noeud> successeurs;
	private boolean typeJoueur;
	private int ligne;
	private int colonne;
	private boolean feuille;
	private int h;
	// constructeurs
	public Noeud() {
		matrice = new int[3][3];
		successeurs = new ArrayList<Noeud>();
	}
	public Noeud(boolean typeJoueur, int[][] matrice)
	{
		this();
		this.typeJoueur = typeJoueur;
		this.matrice = matrice;
	}
	
	public Noeud(boolean typeJoueur, int[][] matrice, int ligne, int colonne)
	{
		this();
		this.typeJoueur = typeJoueur;
		this.matrice = matrice;
		this.ligne = ligne;
		this.colonne= colonne;
	}
	
	public boolean troisPionsAlignes(boolean typeJoueur) {
		int jeton ;
		if(typeJoueur)
			jeton = 1;
		else
			jeton = 2;
		// vérifier lignes
		for(int i=0; i<3; i++)
			if((matrice[i][0] == jeton)&&(matrice[i][1] == jeton)&&(matrice[i][2] == jeton))
				return true;
		//vérifier colonnes
		for(int i=0; i<3; i++)
			if((matrice[0][i] == jeton)&&(matrice[1][i] == jeton)&&(matrice[2][i] == jeton))
				return true;
		// vérifier diagonales
		if((matrice[0][0] == jeton)&&(matrice[1][1] == jeton)&&(matrice[2][2] == jeton))
			return true;
		if((matrice[2][0] == jeton)&&(matrice[1][1] == jeton)&&(matrice[0][2] == jeton))
			return true;
		return false;
	}
}
