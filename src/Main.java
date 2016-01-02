
public class Main {
	
	public static void main(String[] args){  
		final int PROFONDEUR_DE_JEU = 2;
		
		//Fenetre fen = new Fenetre();
		
		Morpion m = new Morpion();
		
		int[][] matriceTest = new int[3][3];
		//matriceTest[1][1] = 1;
		
		Noeud racine = new Noeud(true, matriceTest);
		racine.evaluer();
		m.creerArbreSituation(racine, PROFONDEUR_DE_JEU);
		
		
		racine.print();
		
		int eval = m.resolution(racine, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println(eval);
		
		/*
		int[][] matriceTest = new int[3][3];
		matriceTest[1][1] = 2;
		Noeud noeudTest = new Noeud(false, matriceTest);
		noeudTest.evaluer();
		noeudTest.print();
		*/
		
		// resolution
		
		/*
		int eval = m.resolution(racine, integer.MIN_VALUE, integer.MAX_VALUE);
		racine.setH(eval);
		boulean trouve = false;
		ArrayList<Noeud> successeurs = racine.getSuccesseurs();
		Noeud meilleurSuccesseur = null;
		for(int i=0; i<successeurs.size()&&!trouve; i++) {
			if(successeurs.get(i).getH == eval) {
				trouve = true;
				meilleurSuccesseur = successeur.get(i);
			}
		}
		m.jouer(true, meilleurSuccesseur.getLigne, meilleurSuccesseur.getColonne);
		m.print();
		*/
		
	  } 
	
	
}
