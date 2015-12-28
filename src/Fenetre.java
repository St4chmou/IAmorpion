import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Fenetre extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar = new JMenuBar();			// Instanciation d'un objet "Barre de menu"
	
	private JMenu menu1 = new JMenu("Jeu");				//
	private JMenu menu2 = new JMenu("Paramètres");		// Parties du menu
	private JMenu menu3 = new JMenu("Aide");			//
	
	private JMenuItem item1 = new JMenuItem("Nouvelle partie");		//
	private JMenuItem item2 = new JMenuItem("Meilleurs scores");	//
	private JMenuItem item3 = new JMenuItem("Quitter");				//
	private JMenuItem item4 = new JMenuItem("Plein écran");			// Elements du menu
	private JMenuItem item5 = new JMenuItem("Options");				//
	private JMenuItem item6 = new JMenuItem("Comment jouer ?");		//
	private JMenuItem item7 = new JMenuItem("A propos");			//
	
	private JButton[] boutons = new JButton[9];
	
	
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
			
		JPanel pan = new JPanel();				// Instanciation d'un objet Jpanel
		
		this.setContentPane(pan);				// L'objet Jpanel est le "panneau de contenu" de la fenetre JFrame
		pan.setBackground(Color.GRAY);			// Couleur de fond de la fenêtre
		
				
		this.setLayout(new BorderLayout());
		pan.setLayout(new GridLayout(3,3,5,5));
		for(int i=0;i<boutons.length;i++){
            boutons[i]= new JButton("");
            boutons[i].setPreferredSize(new Dimension(500,500));
            pan.add(boutons[i]);
            boutons[i].addActionListener(this);
        }

		
		ImageIcon croix = new ImageIcon("images/croix.png");
			Image img = croix.getImage() ;  
			Image newimg = img.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;  
			croix = new ImageIcon( newimg );
		   
		ImageIcon rond = new ImageIcon("images/rond.png");
			Image img2 = rond.getImage() ;  
			Image newimg2 = img2.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;  
			rond = new ImageIcon( newimg2 );
		
		boutons[1].setIcon(rond);
		boutons[2].setIcon(croix);
		
		
		// Imbrication des éléments
		item1.addActionListener(this);
		this.menu1.add(item1);
		this.menu1.addSeparator();
		this.menu1.add(item2);
		this.menu1.addSeparator();
		item3.addActionListener(this);
		this.menu1.add(item3);
		this.menu2.add(item4);
		this.menu2.addSeparator();
		this.menu2.add(item5);
		item6.addActionListener(this);;;
		this.menu3.add(item6);
		this.menu3.addSeparator();
		item7.addActionListener(this);
		this.menu3.add(item7);
	
		// Ajout des éléments dans la barre de menu
		this.menuBar.add(menu1);
		this.menuBar.add(menu2);
		this.menuBar.add(menu3);
		
		// Ajout de la barre de menu à la fenetre
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);					// Rend la fenetre visible
			
	}
	
	// Affiche un message "regles"
	public static void AfficheRegles(){
		JOptionPane.showMessageDialog(null, regles, "Comment jouer ?", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Affiche un message "infos"
	public void AfficheInfos(){
		JOptionPane.showMessageDialog(null, infos, "Comment jouer ?", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Lance une nouvelle partie
	public void NouvellePartie(){
		for(int i=0;i<boutons.length;i++){
			boutons[i].setIcon(null);
		}
	}
	
	// Traite le clic de souris : effectue la bonne action
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==item1)NouvellePartie();
		if(e.getSource()==item3)System.exit(0);
        if(e.getSource()==item6)AfficheRegles();
        if(e.getSource()==item7)AfficheInfos();
	}
	
}
