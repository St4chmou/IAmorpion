
public class Main {
	
	public static void main(String[] args){       
		//Fenetre fen = new Fenetre();
		Morpion m = new Morpion();
		int[][] matrice = new int [3][3];
		Noeud n = new Noeud(true, matrice);
		m.creerArbreSituation(n, 3);
	  } 
	
	
}
