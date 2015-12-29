import java.util.ArrayList;
import java.util.Arrays;

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
	
	public void setSuccesseurs(ArrayList<Noeud> successeurs) {
		this.successeurs = successeurs;
	}
	
	public ArrayList<Noeud> getSuccesseurs() {
		return successeurs;
	}
	
	public Noeud getSuccesseur(int i) {
		return successeurs.get(i);
	}
	
	public void addSuccesseur(Noeud n) {
		successeurs.add(n);
	}

	public int getH() {
		return h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public boolean isFeuille() {
		return feuille;
	}
	
	public void setFeuille(boolean feuille) {
		this.feuille = feuille;
	}
	
	public boolean isMax() {
		return typeJoueur;
	}
	
	public void setMax(boolean typeJoueur) {
		this.typeJoueur = typeJoueur;
	}
	
	public int getColonne() {
		return colonne;
	}
	
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	
	public int getLigne() {
		return ligne;
	}
	
	public void setLigne(int ligne) {
		this.colonne = ligne;
	}
	
	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
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
	
	@Override
	public String toString() {
		String s;
		s = "matrice=\n";
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				s += matrice[i][j] + " ";
			s += "\n";
		}
		s += "successeurs=" + successeurs
		+ "\ntypeJoueur=" + typeJoueur + ", ligne=" + ligne + ", colonne=" + colonne + ", feuille=" + feuille + ", h=" + h;
		return s;
	}
	
	public void print() {
		System.out.println(this);
	}
	
	public static void main(String[] args){       
		//Fenetre fen = new Fenetre();
		// Tests
		Noeud n = new Noeud();
		n.print();
		int[][] matrice = new int[3][3];
		matrice[0][0] = 1;
		matrice[0][1] = 2;
		matrice[0][2] = 1;
		n.setMatrice(matrice);
		n.print();
		if(n.troisPionsAlignes(true))
			System.out.println("trois pions alignés");
	  } 
}
