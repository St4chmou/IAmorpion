import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args){  
		final int PROFONDEUR_DE_JEU = 2;
		
		Fenetre fen = new Fenetre();
		
		Morpion m = new Morpion();
		
		int[][] grille = new int[3][3];
		
		boolean joueur = true;
		Noeud racine = new Noeud(joueur, grille);
		racine.evaluer();
		m.creerArbreSituation(racine, PROFONDEUR_DE_JEU);
		
		
		boolean trouve;
		int eval;
		
		racine.printM();
		
		int[] coord = new int[2];
		
		while(!m.estFinJeu(joueur) || !m.estFinJeu(!joueur) ) {
			//si c'est au joueur
			if(joueur == true) {
				while(!m.jouer(joueur, coord[0], coord[1], grille));
			}
			else {
				// recuperer les coordonnees + jouer
				
				// si c'est à l'ordi
				
				m.creerArbreSituation(racine, PROFONDEUR_DE_JEU);
				eval = m.resolution(racine, Integer.MIN_VALUE, Integer.MAX_VALUE);
				racine.setH(eval);
				trouve = false;
				ArrayList<Noeud> successeurs = racine.getSuccesseurs();
				Noeud meilleurSuccesseur = null;
				for(int i=0; i<successeurs.size()&&!trouve; i++) {
					if(successeurs.get(i).getH() == eval) {
						trouve = true;
						meilleurSuccesseur = successeurs.get(i);
					}
				}
				m.jouer(joueur, meilleurSuccesseur.getLigne(), meilleurSuccesseur.getColonne(), grille);
				racine.printM();
				racine.setMatrice(grille);
				joueur = !joueur;
				racine.setMax(joueur);
				m.setMatrice(grille);
			}
		}
		
	} 
}
