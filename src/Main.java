import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		coord = fen.getCoord();
		while(!m.estFinJeu(true) && !m.estFinJeu(false) ) {
			fen.majFenetre();
			fen.setMatrice(grille);
			System.out.println("infini");
			
			//si c'est au joueur
			//if(joueur == true) {
			System.out.println("joueur");
			System.out.println(coord[0] + " " + coord[1]);
			coord = fen.getCoord();
			while(!m.jouer(true, coord[0], coord[1], grille)) {
				String s = "\nmatrice=\n";
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++)
						s += grille[i][j] + " ";
					s += "\n";
				}
				System.out.println(s);
				coord = fen.getCoord();
			}
			m.setMatrice(grille);
			fen.majFenetre();
				
			if(!m.estFinJeu(true)) {
			
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
				m.jouer(false, meilleurSuccesseur.getLigne(), meilleurSuccesseur.getColonne(), grille);
				racine.printM();
				racine.setMatrice(grille);
				joueur = true;
				racine.setMax(joueur);
				m.setMatrice(grille);
				fen.majFenetre();
			}
		}
		if(racine.troisPionsAlignes(true)){
			fen.MessageFin1();
		}
		else if (racine.troisPionsAlignes(false)){
			fen.MessageFin2();
		}
		else{
			fen.MessageFin3();
		}
		
		
	} 
}
