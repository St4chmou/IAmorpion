import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Fenetre extends JFrame {
	
	private JMenuBar menuBar = new JMenuBar();			// Instanciation d'un objet "Barre de menu"
	private JMenu menu1 = new JMenu("Jeu");	//
	private JMenu menu2 = new JMenu("Paramètres");		// Menus
	private JMenu menu3 = new JMenu("Aide");			//
	
	private JMenuItem item1 = new JMenuItem("Nouvelle partie");
	private JMenuItem item2 = new JMenuItem("Meilleurs scores");
	private JMenuItem item3 = new JMenuItem("Quitter");
	private JMenuItem item4 = new JMenuItem("Plein écran");
	private JMenuItem item5 = new JMenuItem("Options");
	private JMenuItem item6 = new JMenuItem("Comment jouer ?");
	private JMenuItem item7 = new JMenuItem("A propos");
	
	public Fenetre(){
	this.setTitle("Tic Tac Toe");			// Titre de la Fenetre
	this.setSize(500, 500);					// Taille de la Fenetre
	this.setLocationRelativeTo(null);		// Position centrée sur l'écran
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Termine le processus quand on clique sur la croix rouge pour fermer la fenetre
	this.setVisible(true);					// Rend la fenetre visible
	this.setResizable(false);				// Empeche le redimensionnement de la fenetre
		
	JPanel pan = new JPanel();				// Instanciation d'un objet Jpanel
	
	this.setContentPane(pan);				// L'objet Jpanel est le "panneau de contenu" de la fenetre JFrame
	pan.setBackground(Color.GRAY);			// Couleur de fond de la fenêtre
	
	// Imbrication des éléments
	this.menu1.add(item1);
	this.menu1.addSeparator();
	this.menu1.add(item2);
	this.menu1.addSeparator();
	
	// Fermeture de l'application au clic sur "quitter"
	item3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}        
	});
	
	this.menu1.add(item3);
	this.menu2.add(item4);
	this.menu2.addSeparator();
	this.menu2.add(item5);
	this.menu3.add(item6);
	this.menu3.addSeparator();
	this.menu3.add(item7);
	
	// Ajout des éléments dans la barre de menu
	this.menuBar.add(menu1);
	this.menuBar.add(menu2);
	this.menuBar.add(menu3);
	
	// Ajout de la barre de menu à la fenetre
	this.setJMenuBar(menuBar);
	
	
	
		
    
	}
}
