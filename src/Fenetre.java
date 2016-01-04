import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Fenetre extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean deuxJoueurs = false;
	private boolean qui = true;
		
	private JMenuBar menuBar = new JMenuBar();			// Instanciation d'un objet "Barre de menu"
	
	private JMenu jeu = new JMenu("Jeu");					//
	private JMenu options = new JMenu("Options");		// Parties du menu
	private JMenu aide = new JMenu("Aide");					//
	
	private JMenuItem nouveau = new JMenuItem("Nouvelle partie");		//
	private JMenuItem scores = new JMenuItem("Meilleurs scores");		//
	private JMenuItem quitter = new JMenuItem("Quitter");				// Elements du menu
	private JMenuItem commentJouer = new JMenuItem("Comment jouer ?");	//
	private JMenuItem aPropos = new JMenuItem("A propos");				//
	private JMenuItem choixCouleur = new JMenuItem("Couleur du fond");	//
	
	private JButton[] boutons = new JButton[9];
	
	JPanel pan = new JPanel();				// Instanciation d'un objet Jpanel
	
	private int[] coord = new int[2];
	private int[][] matrice = new int[3][3];
	
	private boolean event;
	
	// getter du tableau de coordonnées clic
	 public int[] getCoord() {
		 return coord;
	 }
	 
	 public void setMatrice(int[][] matrice) {
		 this.matrice = matrice;
	 }
	 
	 public void setEvent(boolean event) {
		 this.event = event;
	 }
	 
	 public boolean isEvent() {
		 return event;
	 }
	 
	 public void majFenetre() {
		 if(matrice[0][0] == 1)
			 boutons[0].setIcon(rond);
		 if(matrice[0][1] == 1)
			 boutons[1].setIcon(rond);
		 if(matrice[0][2] == 1)
			 boutons[2].setIcon(rond);
		 if(matrice[1][0] == 1)
			 boutons[3].setIcon(rond);
		 if(matrice[1][1] == 1)
			 boutons[4].setIcon(rond);
		 if(matrice[1][2] == 1)
			 boutons[5].setIcon(rond);
		 if(matrice[2][0] == 1)
			 boutons[6].setIcon(rond);
		 if(matrice[2][1] == 1)
			 boutons[7].setIcon(rond);
		 if(matrice[2][2] == 1)
			 boutons[8].setIcon(rond);
		 
		 
		 if(matrice[0][0] == 2)
			 boutons[0].setIcon(croix);
		 if(matrice[0][1] == 2)
			 boutons[1].setIcon(croix);
		 if(matrice[0][2] == 2)
			 boutons[2].setIcon(croix);
		 if(matrice[1][0] == 2)
			 boutons[3].setIcon(croix);
		 if(matrice[1][1] == 2)
			 boutons[4].setIcon(croix);
		 if(matrice[1][2] == 2)
			 boutons[5].setIcon(croix);
		 if(matrice[2][0] == 2)
			 boutons[6].setIcon(croix);
		 if(matrice[2][1] == 2)
			 boutons[7].setIcon(croix);
		 if(matrice[2][2] == 2)
			 boutons[8].setIcon(croix);
	
	 }
	 
	 
	
	// Extraction du symbole "croix" et mise à l'échelle
	ImageIcon croix1 = new ImageIcon("images/croix.png");
		Image img = croix1.getImage() ;  
		Image newimg = img.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH );  
		ImageIcon croix = new ImageIcon( img.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) );
	
	// Extraction du symbole "rond" et mise à l'échelle
	ImageIcon rond1 = new ImageIcon("images/rond.png");
		Image img2 = rond1.getImage(); 
		Image newimg2 = img2.getScaledInstance( 150, 150, java.awt.Image.SCALE_SMOOTH ) ;
		ImageIcon rond = new ImageIcon( newimg2 );
			
	// Messages
	private static String regles = "Le Tic Tac Toe est un jeu de réflexion où 2 joueurs s'affrontent sur une grille de 3x3 cases.\n\nChaque joueur rempli à tour de rôle une case de la grille avec le symbole qui lui est attribué :\nX ou O. Lorsque c'est à vous de jouer, cliquez à l'endroit de la grille où vous souhaiter placer  \nvotre symbole pour jouer.\n\n Le gagnant est le joueur qui parvient à aligner 3 fois son symbole : horizontalement,\nverticalement ou en diagonale.\n\n";
	private static String infos = "Tic Tac Toe\n\nProjet IA 2015 - 2016\nIng2 Info\n\nJulien BAYART\nNicolas SART\n\n";
	
	//Constructeur
	public Fenetre(){
		
		this.setTitle("Tic Tac Toe");			// Titre de la Fenetre
		this.setSize(500, 500);					// Taille de la Fenetre
		this.setLocationRelativeTo(null);		// Position centrée sur l'écran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Termine le processus quand on clique sur la croix rouge pour fermer la fenetre
		this.setResizable(false);				// Empeche le redimensionnement de la fenetre
		
		this.setContentPane(pan);				// L'objet Jpanel est le "panneau de contenu" de la fenetre JFrame
		pan.setBackground(Color.WHITE);			// Couleur de fond de la fenêtre
		
				
		this.setLayout(new BorderLayout());
		pan.setLayout(new GridLayout(3,3,5,5));
		for(int i=0;i<boutons.length;i++){
            boutons[i]= new JButton("");
            boutons[i].setPreferredSize(new Dimension(500,500));
            pan.add(boutons[i]);
            boutons[i].addActionListener(this);
        }

		
		//boutons[1].setIcon(rond);
		//boutons[2].setIcon(croix);
		
		coord[0] = -1;
		coord[1] = -1;
		
		event = false;
		
		// Imbrication des éléments
		nouveau.addActionListener(this);
		this.jeu.add(nouveau);
		this.jeu.addSeparator();
		this.jeu.add(scores);
		this.jeu.addSeparator();
		quitter.addActionListener(this);
		this.jeu.add(quitter);
		choixCouleur.addActionListener(this);
		this.options.add(choixCouleur);
		commentJouer.addActionListener(this);;;
		this.aide.add(commentJouer);
		this.aide.addSeparator();
		aPropos.addActionListener(this);
		this.aide.add(aPropos);
	
		// Ajout des éléments dans la barre de menu
		this.menuBar.add(jeu);
		this.menuBar.add(options);
		this.menuBar.add(aide);
		
		// Ajout de la barre de menu à la fenetre
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);					// Rend la fenetre visible
			
	}
	
	// Affiche un message "regles"
	public static void AfficheRegles(){
		JOptionPane.showMessageDialog(null, regles, "Comment jouer ?", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void MessageFin1(){
		JOptionPane.showMessageDialog(null, "Vous avez gagné !", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void MessageFin2(){
		JOptionPane.showMessageDialog(null, "Vous avez perdu !", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
	}

	public void MessageFin3(){
		JOptionPane.showMessageDialog(null, "Egalité !", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void MessageFin4(){
		JOptionPane.showMessageDialog(null, "Joueur 1 gagne ( O )", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void MessageFin5(){
		JOptionPane.showMessageDialog(null, "Joueur 2 gagne ( X )", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Affiche un message "infos"
	public void AfficheInfos(){
		JOptionPane.showMessageDialog(null, infos, "Comment jouer ?", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Lance une nouvelle partie
	public void NouvellePartie(){
		String[] nbJoueurs = {"Joueur vs Ordi","2 Joueurs"};
		int choixNbJoueurs = JOptionPane.showOptionDialog(null, "Choisissez le type de partie :", "Choix de la nouvelle partie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, nbJoueurs, nbJoueurs[0]);
		
		if(choixNbJoueurs==0)NouvellePartieOrdi();
		if(choixNbJoueurs==1)NouvellePartie2J();
		
	}
	
	public void NouvellePartieOrdi(){
		for(int i=0;i<boutons.length;i++){
			boutons[i].setIcon(null);
		}
		deuxJoueurs = false;
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				matrice[i][j]=0;
			}
		}
	}
	
	public void NouvellePartie2J(){
		for(int i=0;i<boutons.length;i++){
			boutons[i].setIcon(null);
		}
		deuxJoueurs = true;
		qui=true;
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				matrice[i][j]=0;
			}
		}
	}
	
	// Change la couleur de fond
	public void CouleurFond(){
		Color couleur = JColorChooser.showDialog(null, "Couleur du fond", Color.WHITE);
		pan.setBackground(couleur);
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
	
	public boolean matricePleine(){
		boolean plein = true;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(matrice[i][j]==0){
					plein = false;
				}
			}
		}
		return plein;
	}
	
	
	// Traite le clic de souris : effectue la bonne action
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==nouveau)NouvellePartie();
		if(e.getSource()==quitter)System.exit(0);
		if(e.getSource()==choixCouleur)CouleurFond();
        if(e.getSource()==commentJouer)AfficheRegles();
        if(e.getSource()==aPropos)AfficheInfos();
        for(int i=0;i<9;i++){
            if(e.getSource()==boutons[i]){
            	event = true;
             switch(i){
             case 0 : coord[0] = 0; coord[1] = 0; break;
             case 1 : coord[0] = 0; coord[1] = 1; break;
             case 2 : coord[0] = 0; coord[1] = 2; break;
             case 3 : coord[0] = 1; coord[1] = 0; break;
             case 4 : coord[0] = 1; coord[1] = 1; break;
             case 5 : coord[0] = 1; coord[1] = 2; break;
             case 6 : coord[0] = 2; coord[1] = 0; break;
             case 7 : coord[0] = 2; coord[1] = 1; break;
             case 8 : coord[0] = 2; coord[1] = 2; break;
             }
            }
           }
        
        if(deuxJoueurs==true){
        	for(int i=0;i<9;i++){
        		if(e.getSource()==boutons[i]){
        			switch(i){
                    case 0 : coord[0] = 0; coord[1] = 0; break;
                    case 1 : coord[0] = 0; coord[1] = 1; break;
                    case 2 : coord[0] = 0; coord[1] = 2; break;
                    case 3 : coord[0] = 1; coord[1] = 0; break;
                    case 4 : coord[0] = 1; coord[1] = 1; break;
                    case 5 : coord[0] = 1; coord[1] = 2; break;
                    case 6 : coord[0] = 2; coord[1] = 0; break;
                    case 7 : coord[0] = 2; coord[1] = 1; break;
                    case 8 : coord[0] = 2; coord[1] = 2; break;
                    }
        			if(qui==true && matrice[coord[0]][coord[1]]==0){
        				matrice[coord[0]][coord[1]]=1;
        				majFenetre();
        				if(this.troisPionsAlignes(qui)){
        					MessageFin4();
        				}
        				else if(matricePleine()){
        					MessageFin3();
        				}
        			}
        			if(qui==false && matrice[coord[0]][coord[1]]==0){
        				matrice[coord[0]][coord[1]]=2;
        				majFenetre();
        				if(this.troisPionsAlignes(qui)){
        					MessageFin5();
        					
        				}
        				else if(matricePleine()){
        					MessageFin3();
        				}
        			}
        			qui=!qui;
        		}
        	}
        }
        
	}
	
}
